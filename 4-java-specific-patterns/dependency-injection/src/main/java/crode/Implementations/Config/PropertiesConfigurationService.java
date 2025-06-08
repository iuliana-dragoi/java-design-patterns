package crode.Implementations.Config;

import crode.Interfaces.ConfigurationService;

import java.util.HashMap;
import java.util.Map;

public class PropertiesConfigurationService implements ConfigurationService {

    private Map<String, String> properties;

    public PropertiesConfigurationService() {
        properties = new HashMap<>();
        // Simulation of loading configurations from file
        properties.put("app.name", "MyApp");
        properties.put("app.version", "1.0.0");
        properties.put("smtp.server", "smtp.gmail.com");
        properties.put("debug.mode", "true");
    }

    @Override
    public String getProperty(String key) {
        return properties.getOrDefault(key, "");
    }
}
