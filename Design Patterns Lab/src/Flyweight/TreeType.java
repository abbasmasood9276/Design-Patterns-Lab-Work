/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flyweight;

import java.awt.*;

public class TreeType {
    private String name;
    private Color color;
    private String otherTreeData;
    private boolean isFruitTree;
    private int countOfFruits;

    public TreeType(String name, Color color, String otherTreeData, boolean isFruitTree, int countOfFruits) {
        this.name = name;
        this.color = color;
        this.otherTreeData = otherTreeData;
        this.isFruitTree = isFruitTree;
        this.countOfFruits = countOfFruits;
    }

    public boolean isFruitTree() {
        return isFruitTree;
    }

    public void draw(Graphics g, int x, int y, int sizeMultiplier) {
        if (isFruitTree) {
            drawFruits(g, x, y, sizeMultiplier);
        }
        g.setColor(color);
        g.fillOval(x - 5 * sizeMultiplier, y - 10 * sizeMultiplier, 10 * sizeMultiplier, 10 * sizeMultiplier);
    }

    private void drawFruits(Graphics g, int x, int y, int sizeMultiplier) {
        g.setColor(Color.RED);
        for (int i = 0; i < countOfFruits; i++) {
            g.fillOval(x - 5 * sizeMultiplier + i * 5, y - 15 * sizeMultiplier, 5 * sizeMultiplier, 5 * sizeMultiplier);
        }
    }
}

