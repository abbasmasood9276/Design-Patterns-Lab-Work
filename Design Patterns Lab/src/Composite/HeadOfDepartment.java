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
import java.util.ArrayList;
import java.util.List;

public class HeadOfDepartment extends BaseEmployee {
    private String departmentName;
    private List<IEmployee> subordinates;

    public HeadOfDepartment(String name, int salary, String departmentName) {
        super(name, salary);
        this.departmentName = departmentName;
        subordinates = new ArrayList<>();
    }

    public void addSubordinate(IEmployee employee) {
        subordinates.add(employee);
    }

    @Override
    public void accept(IEmployeeVisitor visitor) {
        visitor.visit(this);
        for (IEmployee subordinate : subordinates) {
            subordinate.accept(visitor);
        }
    }
}

