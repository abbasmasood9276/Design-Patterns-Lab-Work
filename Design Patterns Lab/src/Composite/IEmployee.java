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
public interface IEmployee {
    void giveBonus(int bonusPercentage);
    void accept(IEmployeeVisitor visitor);
}
