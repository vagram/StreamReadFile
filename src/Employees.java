import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employees {
    static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private String surname;
    private String name;
    private Long salary;
    private LocalDate startWorkDate;



    public Employees(String surname, String name, long salary, LocalDate startWorkDate) {
        this.surname = surname;
        this.name = name;
        this.salary = salary;
        this.startWorkDate = startWorkDate;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary( ) {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public LocalDate getStartWorkDate() {
        return startWorkDate;
    }

    public void setStartWorkDate(LocalDate startWorkDate) {
        this.startWorkDate = startWorkDate;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", startWorkDate=" + startWorkDate.format(dateTimeFormatter) +
                '}';
    }
}
