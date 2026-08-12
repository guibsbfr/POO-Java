package entitites;

public class Student {
    private Integer id;
    private String name;
    private String email;

    public Student() {
    }

    public Student(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }
}
