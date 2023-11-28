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
public class Circle implements Shape {
    @Override
    public void draw(String... arguments) {
        StringBuilder sb = new StringBuilder("Circle::draw(");
        for (String arg : arguments) {
            sb.append(arg).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(")");
        System.out.println(sb.toString());
    }
}
