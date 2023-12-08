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
public class Teacher extends BaseEmployee {
    private String qualification;
    private String status;

    public Teacher(String name, int salary, String qualification, String status) {
        super(name, salary);
        this.qualification = qualification;
        this.status = status;
    }

    public String getQualification() {
        return qualification;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public void accept(IEmployeeVisitor visitor) {
        visitor.visit(this);
    }
}
