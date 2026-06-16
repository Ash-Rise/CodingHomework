import java.util.*;

class EmployeeComparator {
    public int compareBySalary(Employee a, Employee b) {
        return Double.compare(a.getSalary(), b.getSalary());
    }

    public int compareByLevel(Employee a, Employee b) {
        return Integer.compare(a.getLevelOrder(), b.getLevelOrder());
    }
}

public class EmployeeSys {
    private List<Employee> list = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void input() {
        for (int i = 0; i < 5; i++) {
            System.out.printf("请输入第%d个员工信息(工号 姓名 性别 出生年 出生月 出生日 工资 等级): ", i + 1);
            String id = sc.next();
            String name = sc.next();
            String gender = sc.next();
            int y = sc.nextInt();
            int m = sc.nextInt();
            int d = sc.nextInt();
            double salary = sc.nextDouble();
            String level = sc.next();
            String bir = String.format("%d-%02d-%02d", y, m, d);
            list.add(new Employee(id, name, gender, bir, salary, level));
        }
    }

    public void display() {
        for (Employee e : list)
            System.out.println(e);
    }

    public void handleBusiness(String choice) {
        EmployeeComparator c = new EmployeeComparator();
        switch (choice) {
            case "a" -> Collections.sort(list, (a, b) -> a.getId().compareTo(b.getId()));
            case "b" -> list.sort((a, b) -> a.getName().compareTo(b.getName()));
            case "c" -> list.sort((a, b) -> a.getBirthday().compareTo(b.getBirthday()));
            case "d" -> list.sort(Comparator.comparing(Employee::getGender));
            case "e" -> list.sort(c::compareBySalary);
            case "f" -> list.sort(c::compareByLevel);
            case "g" -> {
                for (Employee e : list)
                    System.out.println(e.getName() + " " + e.getLevel() + " 奖金:" + (int) e.getYearEndBonus() + "元");
                return;
            }
            case "h" -> { display(); return; }
            case "i" -> { System.out.println("再见"); System.exit(0); }
            default -> { System.out.println("输入错误"); return; }
        }
        display();
    }

    public void menu() {
        System.out.println("\n===== 员工管理系统 =====");
        System.out.println("a. 按工号字典顺序排序");
        System.out.println("b. 按姓名字典顺序排序");
        System.out.println("c. 按年龄大小排序");
        System.out.println("d. 按性别排序");
        System.out.println("e. 按工资多少排序");
        System.out.println("f. 按业绩等级排序");
        System.out.println("g. 发放年终奖金");
        System.out.println("h. 显示所有员工信息");
        System.out.println("i. 退出系统");
        System.out.print("请选择：");
    }

    public void run() {
        input();
        while (true) {
            menu();
            handleBusiness(sc.next());
        }
    }
}
