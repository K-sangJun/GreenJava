package D20240924;

import java.util.Map;

public class DatabaseMain {
    public static void main(String[] args) {

//        DatabaseUtil.insertData("student", Map.of("name", "황황황", "schoolYear", 1));

        DatabaseUtil.selectData("student", null);

//        DatabaseUtil.updateData("student", Map.of("name", "황황황"), Map.of("name", "승승승"));

//        DatabaseUtil.deleteData("student", Map.of("name", "황황황"));
    }
}
