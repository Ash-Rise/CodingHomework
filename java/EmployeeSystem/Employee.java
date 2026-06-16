import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private String id;
    private String name;
    private String gender;
    private String birthday;
    private double salary;
    private String level;

    public Employee(String id, String name, String gender, String birthday, double salary, String level) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.salary = salary;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getAge() {
        String[] p = birthday.split("-");
        return 2026 - Integer.parseInt(p[0]);
    }

    public int getLevelOrder() {
        if ("优".equals(level)) return 1;
        if ("合格".equals(level)) return 2;
        if ("基本合格".equals(level)) return 3;
        return 4;
    }

    public double getYearEndBonus() {
        if ("优".equals(level)) return 10000;
        if ("合格".equals(level)) return 8000;
        if ("基本合格".equals(level)) return 5000;
        return 0;
    }

    @Override
    public String toString() {
        return "员工:[ 工号：" + id + "，姓名：" + name + "，性别：" + gender
                + "，生日：" + birthday + "，工资：" + salary + "，等级：" + level + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Employee o) {
        return this.id.compareTo(o.id);
    }
}
