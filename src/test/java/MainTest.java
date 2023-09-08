import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.readString;

public class MainTest {

    @Test
    public void testJsonToList_returnNotNull_success() throws ParseException {
// given: expectedList not null

// when:
        List<Employee> expectedList = Main.jsonToList(Main.readString("new_data.json"));

// then:
        Assertions.assertNotNull(expectedList, "Not null: failed");

    }

    @Test
    public void testJsonToList_listValidValues_success() throws ParseException {
// given:
        List<Employee> actualList = new ArrayList<>();
        Employee e1 = new Employee(1, "John", "Smith", "USA", 25);
        Employee e2 = new Employee(2, "Ivan", "Petrov", "RU", 23);
        actualList.add(e1);
        actualList.add(e2);

// when:
        List<Employee> expectedList = Main.jsonToList(Main.readString("new_data.json"));

// then:
        for (int i = 0; i < expectedList.size(); i++) {
            Assertions.assertEquals(actualList.get(i).id, expectedList.get(i).id);
            Assertions.assertEquals(actualList.get(i).firstName, expectedList.get(i).firstName);
            Assertions.assertEquals(actualList.get(i).lastName, expectedList.get(i).lastName);
            Assertions.assertEquals(actualList.get(i).country, expectedList.get(i).country);
            Assertions.assertEquals(actualList.get(i).age, expectedList.get(i).age);
        }
    }

    @Test
    public void testReadString_IOException_expected() {
// given: IOException not expected
        String fileName = "new_data.json";

// when: IOException expected
        String fileName_expected = "fileNotExist.json";

// then:
        try {
            String json = readString(Path.of(fileName_expected));
            Assertions.fail("Expected IOException");
        } catch (IOException e) {
            Assertions.assertNotEquals("", e.getMessage());
        }

    }

}
