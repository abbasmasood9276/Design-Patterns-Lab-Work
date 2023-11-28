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
public class ShapeMaker {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCircle(String... arguments) {
        circle.draw(arguments);
    }

    public void drawRectangle(String... arguments) {
        rectangle.draw(arguments);
    }

    public void drawSquare(String... arguments) {
        square.draw(arguments);
    }
}
}
