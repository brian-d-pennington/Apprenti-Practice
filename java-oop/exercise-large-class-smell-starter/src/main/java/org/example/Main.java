package org.example;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        Teacher teacher = new Teacher();
        ;
        ConsoleIO.display("Welcome to Better School Tracker!");

        student.setFirstName(ConsoleIO.promptString("Enter Student First Name"));
        student.setLastName(ConsoleIO.promptString("Enter Student Last Name"));
        double storeGPA = ConsoleIO.promptDouble("Enter Student's GPA");
        Grades grades = new Grades(student, storeGPA);
        teacher.setFirstName(ConsoleIO.promptString("Enter Homeroom teacher's first Name"));
        teacher.setLastName(ConsoleIO.promptString("Enter Homeroom teacher's last name"));

        System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("GPA: " + grades.getGPA(student.getLastName()));
        System.out.println("Homeroom Teacher: " + teacher.getFirstName() + " " + teacher.getLastName());

    }
}