import java.util.HashMap;
import java.util.LinkedList;

public class HashTableChallengeTwo {

    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));

        employees.forEach(e -> System.out.println(e));
       
        var map = new HashMap<Integer, Employee>();

        employees.forEach(e -> map.put(e.getId(), e));

        employees = new LinkedList<>();
        for(Employee e : map.values()) {
            employees.add(e);
        }

        System.out.println("===================== AFTER REMOVAL =====================");
        employees.forEach(System.out::println);
    }

    public static int hash(int value) {
        return Math.abs(value % 10);
    }
}
