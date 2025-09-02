package org.example;

public class Grades {
    private double GPA;
    Student student; // student 'has a' GPA

    // constructor
    public Grades(Student student, double GPA) {
        this.student = student;
        this.GPA = GPA;
    }

    // getter & setter
    // GPA should be affiliated with a student's last name
    public double getGPA(String studentLastName) {
        if (student.getLastName().equalsIgnoreCase(studentLastName)) {
            return GPA;
        } else {
            return 0;
        }
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
}
