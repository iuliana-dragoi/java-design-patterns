package crode.View;

import crode.Model.Student;

public class StudentView {

    public void displayStudentDetails(Student student) {
        System.out.println("=== Student Details ===");
        System.out.println("Name: " + student.getName());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Age: " + student.getAge());
        System.out.println("=======================");
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayAllStudents(java.util.List<Student> students) {
        System.out.println("\n=== All Students ===");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("====================");
    }
}
