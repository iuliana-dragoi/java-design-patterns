package crode;

import java.util.HashMap;
import java.util.Map;

public class DIContainer {

    private Map<Class<?>, Object> services;

    public DIContainer() {
        services = new HashMap<>();
    }

    public <T> void register(Class<T> serviceClass, T implementation) {
        services.put(serviceClass, implementation);
    }

    @SuppressWarnings("unchecked")
    public <T> T resolve(Class<T> serviceClass) {
        return (T) services.get(serviceClass);
    }
}
