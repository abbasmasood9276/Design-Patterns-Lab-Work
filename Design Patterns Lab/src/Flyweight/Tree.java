/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flyweight;

/**
 *
 * @author fa20-bse-001
 */
import java.awt.*;

public class Tree {
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(Graphics g) {
        int sizeMultiplier = calculateSizeMultiplier();
        type.draw(g, x, y, sizeMultiplier);
    }

    private int calculateSizeMultiplier() {
        // Adjust the size based on the y coordinate
        if (y < Forest.CANVAS_SIZE / 3) {
            // North: Small size
            return 1;
        } else if (y < 2 * Forest.CANVAS_SIZE / 3) {
            // Middle: Medium size
            return 2;
        } else {
            // South: Large size
            return 3;
        }
    }
}


