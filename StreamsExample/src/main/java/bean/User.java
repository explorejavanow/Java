package bean;

public class User {
    private String name;
    private String department;

    public User(String name, String department){
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}
