import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class TestClass {

    @Test
    public void test1_jsonToList() throws ParseException {
// given:
        List<Employee> actualList = new ArrayList<>();
        Employee e1 = new Employee(1, "John", "Smith", "USA", 25);
        Employee e2 = new Employee(2, "Ivan", "Petrov", "RU", 23);
        actualList.add(e1);
        actualList.add(e2);

// when:
        List<Employee> expectedList = Main.jsonToList(Main.readString("new_data.json"));

// then:
        Assertions.assertNotNull(expectedList, "Not null: failed");
        Assertions.assertEquals(actualList.toString(), expectedList.toString(), "Equals: failed");
    }

    @Test
    public void test2_jsonToList() throws ParseException {
// given:

// when:
        List<Employee> expectedList = Main.jsonToList(Main.readString("new_data.json"));

// then:
        Assertions.assertNotSame(expectedList.get(0), expectedList.get(1), "NotSame: failed");
    }


}
