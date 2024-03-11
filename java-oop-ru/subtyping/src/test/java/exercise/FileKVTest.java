package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
// BEGIN
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Map;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    void testGet() {
        var map = Map.of("key1", "value1",
                "key2", "value2",
                "key3", "value3"
        );
        FileKV fKV = new FileKV("src/test/resources/file", map);
        assertThat(fKV.get("key2", "default")).isEqualTo("value2");
        assertThat(fKV.get("key4", "default")).isEqualTo("default");
    }


    @Test
    void testSetUnset() {
        var map = Map.of("key1", "value1",
                "key2", "value2",
                "key3", "value3"
        );
        FileKV fKV = new FileKV("src/test/resources/file", map);
        fKV.set("key4", "value4");
        assertThat(fKV.get("key4", "default")).isEqualTo("value4");
        fKV.unset("key4");
        assertThat(fKV.get("key4", "default")).isEqualTo("default");
    }

    @Test
    void testToMap() {
        var map = Map.of("key1", "value1",
                "key2", "value2",
                "key3", "value3"
        );
        FileKV fKV = new FileKV("src/test/resources/file", map);
        fKV.unset("key2");
        fKV.set("key5", "value5");
        var expected = Map.of("key1", "value1",
                "key3", "value3",
                "key5", "value5"
        );
        assertThat(fKV.toMap()).isEqualTo(expected);
    }
    // END
}
