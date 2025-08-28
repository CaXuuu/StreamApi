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
public void skipOperation () {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getFirstName))
                .skip(2) // skipujemy 2 pierwsze elementy
                .forEach(System.out::println);
}

public void countOperation () {
    long nuberOfEmloyes = employees.stream()
            .filter(employee -> employee.getFirstName().startsWith("B"))
            .count();
    System.out.println(nuberOfEmloyes);
}

public void minMaxOperation () {
    Employee youngestEmployee = employees.stream()
            .min(Comparator.comparing(Employee::getAge)).get();  //zwraca optional wiec musimy dac get
    System.out.println(youngestEmployee);

    Employee oldestEmployee = employees.stream()
            .max(Comparator.comparing(Employee::getAge)).get();
    System.out.println(oldestEmployee);
}
public void findAnyOperation () {
    Employee findEmp = employees.stream()
            .filter(employee -> employee.getFirstName().startsWith("B"))
            .findAny().get();
    System.out.println(findEmp);
}

public void matchOperation () {
    boolean b = employees.stream()
            .allMatch(employee -> employee.getFirstName().startsWith("B")); //sprawdzamy czy dla wszytskich imie zaczyna sie na B
    System.out.println(b);

    boolean b1 = employees.stream()
            .anyMatch(employee -> employee.getFirstName().startsWith("B")); //czy kogokolwiek imie zaczyna sie na B
    System.out.println(b1);

    boolean b2 = employees.stream()
            .noneMatch(employee -> employee.getFirstName().startsWith("B")); //czy nikogo imie zaczyna sie na B
    System.out.println(b2);
}

public void reduceOperation () {
    Integer sumOfAllAges = employees.stream()
            .map(Employee::getAge)
            .reduce(Integer::sum)
            .get();
    System.out.println(sumOfAllAges);

    Integer sumOfAllAges2 = employees.stream()
            .map(Employee::getAge)
            .reduce(0, Integer::sum); //0 - zaczynamy od zera

    System.out.println(sumOfAllAges2);

    Integer sumOfAllAges3 = employees.stream()
            .map(Employee::getAge)
            .reduce((age1,age2)->age1+age2)
            // bierzemy jedna wartosc i drugdodajemy wynik tego traktujemy jako pierwsza i dodajemy druga i tak dalej
            .get();
    System.out.println(sumOfAllAges3);

    Integer sumOfAllAges4 = employees.stream()
            .reduce(0, (age, employees) -> age + employees.getAge(), Integer::sum); //troche dlugie ale dziala
    System.out.println(sumOfAllAges4);

    String allNames = employees.stream()
            .map(Employee::getFirstName)
            .reduce((name, name2) -> name + ", " + name2)// wypisuje imiona po przecinku
            .get();
    System.out.println(allNames);

}

public void takeWhileOperation () {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .takeWhile(employee -> employee.getAge() < 30) // stosujemy na posortowanych streamach
                .forEach(System.out::println);

}

public void dropWhileOperation () {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .dropWhile(employee -> employee.getAge() < 30) // pracownicy powyzej 30roku zycia
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
        //example.limitOperation();
        //example.skipOperation();
        //example.countOperation();
        //example.minMaxOperation();
        //example.findAnyOperation();
        //example.matchOperation();
        //example.reduceOperation();
        //example.takeWhileOperation();
        example.dropWhileOperation();
    }
    }

