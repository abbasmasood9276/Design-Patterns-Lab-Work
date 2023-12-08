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
public abstract class BaseEmployee implements IEmployee {
    private String name;
    private int salary;

    public BaseEmployee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public void giveBonus(int bonusPercentage) {
        int bonus = (int) (salary * bonusPercentage / 100.0);
        System.out.println("Bonus of " + bonus + " added to " + name);
    }

    @Override
    public void accept(IEmployeeVisitor visitor) {
        visitor.visit(this);
    }
}
