package apartado1a;

public class Employee extends Person {
    private final int salary;

    public Employee(String name, int salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Employee employee = (Employee) o;

        return salary == employee.salary;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + salary;
        return result;
    }
}
