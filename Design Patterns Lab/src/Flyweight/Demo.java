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

public class Demo {
    static int CANVAS_SIZE = 500;
    static int TREES_TO_DRAW = 10000;
    static int TREE_TYPES = 2;

    public static void main(String[] args) {
        Forest forest = new Forest();

        for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
            int y = random(0, CANVAS_SIZE);
            String treeName;
            Color treeColor;
            String treeTexture;

            if (y < CANVAS_SIZE / 3) {
                treeName = "North Tree";
                treeColor = Color.BLUE;
                treeTexture = "North Texture";
            } else if (y < 2 * CANVAS_SIZE / 3) {
                treeName = "Middle Tree";
                treeColor = Color.GREEN;
                treeTexture = "Middle Texture";
            } else {
                treeName = "South Tree";
                treeColor = Color.RED;
                treeTexture = "South Texture";
            }

            boolean isFruitTree = (Math.random() < 0.5);
            int countOfFruits = isFruitTree ? random(1, 10) : 0;

            forest.plantTree(random(0, CANVAS_SIZE), y, treeName, treeColor, treeTexture,
                             isFruitTree, countOfFruits);
        }

        forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
        forest.setVisible(true);

        System.out.println(TREES_TO_DRAW + " trees drawn");
        System.out.println("---------------------");
        System.out.println("Memory usage:");
        System.out.println("Tree size (8 bytes) * " + TREES_TO_DRAW);
        System.out.println("+ TreeTypes size (~30 bytes) * " + TREE_TYPES + "");
        System.out.println("---------------------");
        System.out.println("Total: " + ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024) +
                "MB (instead of " + ((TREES_TO_DRAW * 38) / 1024 / 1024) + "MB)");
    }

    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
