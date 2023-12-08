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
public class BonusVisitor implements IEmployeeVisitor {
    private String bonusType;
    private int percentageOfBonus;

    public BonusVisitor(String bonusType, int percentageOfBonus) {
        this.bonusType = bonusType;
        this.percentageOfBonus = percentageOfBonus;
    }

    @Override
    public void visit(BaseEmployee employee) {
        employee.giveBonus(percentageOfBonus);
    }

    @Override
    public void visit(Teacher teacher) {
        teacher.giveBonus(percentageOfBonus);
    }
}

