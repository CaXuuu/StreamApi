import java.util.List;

public class Employee {

    public Employee(String firstName, String lastName, int age, List<String> skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.skills = skills;
    }

    private String firstName;
    private String lastName;
    int age;

    private List<String> skills;

}
