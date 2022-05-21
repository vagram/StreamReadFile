import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static ArrayList<Employees> employees = readEmployeesFromFile("/Users/VagramsMac/Desktop/Employees.txt");

    public static void main(String[] args){
        //sortBySalaryAndWorkDate();
        findEmployeeWithHighestSalary();

    }
    public static ArrayList<Employees> readEmployeesFromFile(String filepath){
        ArrayList<Employees> employees = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Path.of(filepath));
            lines.stream()
                    .map(l-> l.split(";"))
                    .forEach(infoArray->
                            employees.add(new Employees(
                                    infoArray[0],
                                    infoArray[1],
                                    Long.parseLong(infoArray[2]),
                                    LocalDate.parse(infoArray[3], Employees.dateTimeFormatter))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static void sortBySalaryAndWorkDate() {

        Comparator<Employees> comparator = (e1, e2) -> {
            if (e1.getSalary().equals(e2.getSalary())) {
                return e1.getStartWorkDate().compareTo(e2.getStartWorkDate());
            } else {
                return e1.getSalary().compareTo(e2.getSalary());
            }
        };
        employees.sort(comparator);
        employees.forEach(System.out::println);
    }

    public static void findEmployeeWithHighestSalary() {

        String year = "2020";
        System.out.println("Год начало работы: " + year);
            Comparator<Employees> comparator = (e1, e2) -> {
                if (e1.getSalary() > e2.getSalary()) {
                    return e1.getSalary().compareTo(e2.getSalary());
                }else {
                    return e2.getSalary().compareTo(e1.getSalary());
                }
            };
            employees.sort(comparator);
            employees.stream().filter(e -> e.getStartWorkDate().
                    getYear() == Integer.parseInt(year)).
                    sorted(comparator).
                    max(Comparator.comparing(Employees::getSalary)).
                    ifPresent(System.out::println);
    }
}
