package framework.utils.fakerUtils;

public class Employee {
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String username;
    private String password;

    public Employee(Integer id, String firstName, String middleName, String lastName, String email, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
