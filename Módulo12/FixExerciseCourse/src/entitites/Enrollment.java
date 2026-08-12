package entitites;

import java.time.LocalDate;

public class Enrollment {
    private Student student;
    private Course course;
    private LocalDate enrollmentDate;

    public Enrollment() {
    }

    public Enrollment(Course course, LocalDate enrollmentDate, Student student) {
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }
}
