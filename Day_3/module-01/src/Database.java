import java.util.ArrayList;

public class Database {
    public static ArrayList<Student> studentDatabaseTable = new ArrayList<>();

    static {
        studentDatabaseTable.add(
                new Student("C001", "Nimal", "038", "Panadura")
        );
        studentDatabaseTable.add(
                new Student("C002", "Bandara", "027", "Galle")
        );
    }
}
