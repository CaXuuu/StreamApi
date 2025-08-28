import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {
    List<Employee> employees = new ArrayList<>();

    public void setUp() {
        Employee employee1 = new Employee("Honkytonk", "Cumbercooch", 25, List.of("Java", "JavaScript", "Python"));
        Employee employee2 = new Employee("Brewery", "Chickenstrips", 31, List.of("C#"));
        Employee employee3 = new Employee("Beetlejuice", "Snugglesnatch", 23, List.of("Java", "Haskell", "Scala"));
        Employee employee4 = new Employee("Boobytrap", "Humperdinck", 42, List.of("PHP", "JavaScript", "React", "Angular"));
        Employee employee5 = new Employee("Buttermilk", "Bumbersplat", 38, List.of("Java", "Scala"));
        Employee employee6 = new Employee("Rinkydink", "Curdlesnoot", 30, List.of("C", "C++"));
        Employee employee7 = new Employee("Cogglesnatch", "Splishsplash", 27, List.of("Rust", "Python"));
        Employee employee8 = new Employee("Tiddleywomp", "Charmander", 51, List.of("Java", "Spring", "Hibernate", "Java"));

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);
        employees.add(employee8);

    }


        public void firstStream () {
            employees
                    .forEach(System.out::println);
        }
        public void mapOperation () {
        employees.stream()
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
            .forEach(System.out::println);
        }
public void flatMapOperation () {
        //zapisywanie do zmiennej ctrl + alt + v
    Collection<List<String>> allSkilss = employees.stream()
            .map(Employee::getSkills)
            .collect(Collectors.toList());
    System.out.println(allSkilss);

    Collection<String> allSKills2 = employees.stream()
            .map(Employee::getSkills)
            .flatMap(list -> list.stream())  //mapa ktora daje wszytysko
            .distinct()  //nie beda sie powtarzaly
            .collect(Collectors.toList());  //zbieramy do kolekcji
    System.out.println(allSKills2);
}

public void filterOperation () {
        employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("B"))  //filtrowanie
                .forEach(System.out::println);
}

public void sortedOperation () {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))  //sortowanie w tym przypadku po wieku
                .forEach(System.out::println);

}

public void limitOperation () {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName))
                .limit(2)  //limit ile elementow sie wyswietli
                .forEach(System.out::println);
}

    public static void main(String[] args) {
        StreamsExample example = new StreamsExample();
        example.setUp();
        //example.firstStream();
        //example.mapOperation();
        //example.flatMapOperation();
        //example.filterOperation();
        //example.sortedOperation();
        example.limitOperation();
    }
    }

