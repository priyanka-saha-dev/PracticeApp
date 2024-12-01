package patterns.singleton;

import java.io.Serializable;
import java.util.List;

public final class ConfigurationManagerSingleton implements Serializable {

    private static volatile ConfigurationManagerSingleton instance;

    private List<String> properties;

    private ConfigurationManagerSingleton() {
        leadProperties();
    }

    private static ConfigurationManagerSingleton getInstance() {
        if(instance == null) {
            synchronized (ConfigurationManagerSingleton.class) {
                if(instance == null) {
                    instance = new ConfigurationManagerSingleton();
                }
            }
        }

        return instance;
    }

    private void leadProperties() {
        properties = List.of("immutable", "properties");
    }

    public List<String> getProperties() {
        return properties;
    }


}
