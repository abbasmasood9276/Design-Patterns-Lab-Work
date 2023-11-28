/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

/**
 *
 * @author aabik
 */
public class Rectangle implements Shape {
    @Override
    public void draw(String... arguments) {
        StringBuilder sb = new StringBuilder("Rectangle::draw(");
        for (String arg : arguments) {
            sb.append(arg).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());  // Remove the trailing comma and space
        sb.append(")");
        System.out.println(sb.toString());
    }
}