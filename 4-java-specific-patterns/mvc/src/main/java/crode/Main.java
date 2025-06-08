package crode;

import crode.Controller.StudentController;
import crode.View.StudentView;

public class Main {

    public static void main(String[] args) {
        //  Create View
        StudentView view = new StudentView();

        //  Create Controller with View
        StudentController controller = new StudentController(view);

        //  Test Application
        System.out.println("=== MVC Pattern Demo ===");

        // ADD
        controller.addStudent("Ion Popescu", "ion@email.com", 20);
        controller.addStudent("Maria Ionescu", "maria@email.com", 22);
        controller.addStudent("Alex Georgescu", "alex@email.com", 19);

        // DISPLAY
        controller.displayAllStudents();
        controller.displayStudent(0);

        // UPDATE
        controller.updateStudent(1, "Maria Popescu", "maria.popescu@email.com", 23);

        // DISPLAY ALL STUDENTS
        controller.displayAllStudents();
    }
}
