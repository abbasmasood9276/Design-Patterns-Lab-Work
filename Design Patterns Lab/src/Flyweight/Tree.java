/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flyweight;

/**
 *
 * @author aabik
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

    public void draw(Graphics g, int canvasSize) {
        int sizeMultiplier = calculateSizeMultiplier(canvasSize);
        type.draw(g, x, y, sizeMultiplier);
    }

    private int calculateSizeMultiplier(int canvasSize) {
        if (y < canvasSize / 3) {
            return 1;
        } else if (y < 2 * canvasSize / 3) {
            return 2;
        } else {
            return 3;
        }
    }
}



