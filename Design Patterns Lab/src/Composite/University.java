/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Composite;

/**
 *
 * @author aabik
 */
import java.util.Observable;

public class University extends Observable {
    public static void main(String[] args) {
        Director director = new Director("Director", 100000);
        HeadOfDepartment hod = new HeadOfDepartment("HOD", 80000, "Computer Science");
        Teacher teacher = new Teacher("Professor", 50000, "Ph.D.", "Permanent");

        director.addSubordinate(hod);
        hod.addSubordinate(teacher);

        EmployeeController controller = new EmployeeController(director);

        // Generate organogram
        controller.generateOrganogram();

        // Activate bonus
        controller.activateBonus("Yearly Bonus", 10);

        // Modify the solution for Iterator and Observer patterns as per your requirements
    }
}

