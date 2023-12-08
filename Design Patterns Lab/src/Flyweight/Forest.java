/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flyweight;


import static Flyweight.Demo.CANVAS_SIZE;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Forest extends JFrame {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, Color color, String otherTreeData,
                          boolean isFruitTree, int countOfFruits) {
        TreeType type = TreeFactory.getTreeType(name, color, otherTreeData, isFruitTree, countOfFruits);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    @Override
    public void paint(Graphics graphics) {
        for (Tree tree : trees) {
            try {
                tree.draw(graphics, CANVAS_SIZE);  // Pass CANVAS_SIZE as an argument
            } catch (RuntimeException e) {
                System.err.println("Error drawing tree: " + e.getMessage());
            }
        }
    }
}


