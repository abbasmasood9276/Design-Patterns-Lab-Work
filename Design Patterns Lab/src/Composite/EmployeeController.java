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
public class EmployeeController {
    private IEmployee root;

    public EmployeeController(IEmployee root) {
        this.root = root;
    }

    public void generateOrganogram() {
        // Your logic to generate the organogram
        // This may involve traversing the hierarchy and printing information
    }

    public void activateBonus(String bonusType, int percentageOfBonus) {
        BonusVisitor bonusVisitor = new BonusVisitor(bonusType, percentageOfBonus);
        root.accept(bonusVisitor);
    }
}

