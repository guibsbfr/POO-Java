package entitites;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private Integer id;
    private String instructor;

    List<Enrollment> enrollments = new ArrayList<>();

    public Course() {
    }

    public Course(Integer id, String instructor, String name) {
        this.id = id;
        this.instructor = instructor;
        this.name = name;
    }

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public void removeEnrollment(Enrollment enrollment) {
        enrollments.remove(enrollment);
    }

    public String getName() {
        return name;
    }

    public String getInstructor() {
        return instructor;
    }

    public Integer getId() {
        return id;
    }

    int n = 0;
    public String toString() {
        StringBuilder summary = new StringBuilder();
        summary.append("COURSE SUMMARY").append("\n");
        summary.append("Course: ").append(getName()).append("\n");
        summary.append("Instructor: ").append(getInstructor()).append("\n");
        for (Enrollment en : enrollments) {
            n++;
        }
        summary.append("Students enrolled: ").append(n).append("\n");
        summary.append("\n");
        summary.append("Students: ").append("\n");
        int x = 1;
        for (Enrollment en : enrollments) {
            summary.append(x).append(" - ").append(en.getStudent().getName()).append(" - ").append(en.getStudent().getEmail()).append("\n");
            x++;
        }
        return summary.toString();
    }
}
