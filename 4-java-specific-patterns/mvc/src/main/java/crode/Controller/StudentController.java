package crode.Controller;

import crode.Model.Student;
import crode.View.StudentView;

import java.util.List;

public class StudentController {

    private List<Student> students;
    private StudentView view;

    public StudentController(StudentView view) {
        this.view = view;
        this.students = new java.util.ArrayList<>();
    }

    public void addStudent(String name, String email, int age) {
        Student student = new Student(name, email, age);
        students.add(student);
        view.displayMessage("Student added successfully!");
    }

    public void displayStudent(int index) {
        if (index >= 0 && index < students.size()) {
            view.displayStudentDetails(students.get(index));
        } else {
            view.displayMessage("Student not found!");
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            view.displayMessage("No students found!");
        } else {
            view.displayAllStudents(students);
        }
    }

    public void updateStudent(int index, String name, String email, int age) {
        if (index >= 0 && index < students.size()) {
            Student student = students.get(index);
            student.setName(name);
            student.setEmail(email);
            student.setAge(age);
            view.displayMessage("Student updated successfully!");
        } else {
            view.displayMessage("Student not found!");
        }
    }
}
