package exercise;

// BEGIN
import java.util.Map;

class FileKV implements KeyValueStorage {

    private final String path;

    FileKV(String path, Map<String, String> map) {
        this.path = path;
        var json = Utils.serialize(map);
        Utils.writeFile(path, json);
    }

    @Override
    public void set(String key, String value) {
        var json = Utils.readFile(path);
        var map = Utils.unserialize(json);
        map.put(key, value);
        json = Utils.serialize(map);
        Utils.writeFile(path, json);
    }

    @Override
    public void unset(String key) {
        var json = Utils.readFile(path);
        var map = Utils.unserialize(json);
        map.remove(key);
        json = Utils.serialize(map);
        Utils.writeFile(path, json);
    }

    @Override
    public String get(String key, String defaultValue) {
        var json = Utils.readFile(path);
        var map = Utils.unserialize(json);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return defaultValue;
    }

    @Override
    public Map<String, String> toMap() {
        var json = Utils.readFile(path);
        return Utils.unserialize(json);
    }
}
// END
