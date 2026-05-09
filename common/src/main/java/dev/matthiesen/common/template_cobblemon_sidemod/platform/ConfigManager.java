package dev.matthiesen.common.template_cobblemon_sidemod.platform;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.matthiesen.common.template_cobblemon_sidemod.Constants;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;

public class ConfigManager<T> {
    private final Class<T> configClass;
    private final String configName;
    private final Gson gson;
    private T config;

    /**
     * Creates a new ConfigManager for the specified config class and name.
     *
     * @param configClass The class of the config to manage
     * @param configName The name of the config file (without .json extension)
     */
    public ConfigManager(Class<T> configClass, String configName) {
        this.configClass = configClass;
        this.configName = configName;
        this.gson = getGsonFromConfigClass();
    }

    /**
     * Attempts to get the GSON instance from the config class.
     * Falls back to creating a new Gson instance if not available.
     */
    private Gson getGsonFromConfigClass() {
        try {
            Field gsonField = configClass.getDeclaredField("GSON");
            gsonField.setAccessible(true);
            return (Gson) gsonField.get(null);
        } catch (NoSuchFieldException | IllegalAccessException | ClassCastException e) {
            Constants.createInfoLog("No GSON field found in " + configClass.getSimpleName() + ", using default Gson instance");
            return new Gson();
        }
    }

    /**
     * Creates a new instance of the config class.
     */
    private T createDefaultConfig() {
        try {
            return configClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            Constants.createErrorLog("Failed to create default instance of " + configClass.getSimpleName());
            throw new RuntimeException(e);
        }
    }

    public T loadConfig() {
        String configFileLoc = System.getProperty("user.dir") + File.separator + "config" +
                File.separator + Constants.MOD_ID + File.separator + configName + ".json";
        Constants.createInfoLog("Loading config file found at: " + configFileLoc);
        File configFile = new File(configFileLoc);
        boolean madeDir = configFile.getParentFile().mkdirs();

        if (madeDir) {
            Constants.createInfoLog("Config Directory exists");
        }

        // Check config existence and load if it exists, otherwise create default.
        if (configFile.exists()) {
            try {
                FileReader fileReader = new FileReader(configFile);

                // Create a default config instance
                T defaultConfig = createDefaultConfig();
                String defaultConfigJson = gson.toJson(defaultConfig);

                JsonElement fileConfigElement = JsonParser.parseReader(fileReader);

                // Convert default config JSON string to JsonElement
                JsonElement defaultConfigElement = JsonParser.parseString(defaultConfigJson);

                // Merge default config with the file config
                JsonElement mergedConfigElement = mergeConfigs(
                        defaultConfigElement.getAsJsonObject(),
                        fileConfigElement.getAsJsonObject()
                );

                // Deserialize the merged JsonElement back to the config class
                config = gson.fromJson(mergedConfigElement, configClass);

                fileReader.close();
            } catch (Exception e) {
                Constants.createErrorLog("Failed to load the config! Using default config as fallback");
                e.printStackTrace();
                config = createDefaultConfig();
            }
        } else {
            config = createDefaultConfig();
        }

        saveConfig();

        return config;
    }

    public JsonElement mergeConfigs(JsonObject defaultConfig, JsonObject fileConfig) {
        // For every entry in the default config, check if it exists in the file config
        Constants.createInfoLog("Checking for config merge.");
        boolean merged = false;

        for (String key : defaultConfig.keySet()) {
            if (!fileConfig.has(key)) {
                // If the file config does not have the key, add it from the default config
                fileConfig.add(key, defaultConfig.get(key));
                Constants.createInfoLog(key + " not found in file config, adding from default.");
                merged = true;
            } else {
                // If it's a nested object, recursively merge it
                if (defaultConfig.get(key).isJsonObject() && fileConfig.get(key).isJsonObject()) {
                    mergeConfigs(defaultConfig.getAsJsonObject(key), fileConfig.getAsJsonObject(key));
                }
            }
        }

        if (merged) {
            Constants.createInfoLog("Successfully merged config.");
        }

        return fileConfig;
    }

    public void saveConfig() {
        try {
            String configFileLoc = System.getProperty("user.dir") + File.separator + "config" +
                    File.separator + Constants.MOD_ID + File.separator + configName + ".json";
            Constants.createInfoLog("Saving config to: " + configFileLoc);
            File configFile = new File(configFileLoc);
            FileWriter fileWriter = new FileWriter(configFile);
            gson.toJson(config, fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            Constants.createErrorLog("Failed to save config");
            e.printStackTrace();
        }
    }
}
