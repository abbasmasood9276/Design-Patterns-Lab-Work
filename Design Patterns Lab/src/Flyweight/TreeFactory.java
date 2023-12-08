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
import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
    private static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, Color color, String otherTreeData,
                                       boolean isFruitTree, int countOfFruits) {
        // Generate a unique key for each TreeType based on name and color
        String key = name + color.getRGB();

        // Check if the TreeType with the given key already exists
        TreeType result = treeTypes.get(key);

        if (result == null) {
            // If not, create a new TreeType and store it in the map
            result = new TreeType(name, color, otherTreeData, isFruitTree, countOfFruits);
            treeTypes.put(key, result);
        }

        return result;
    }
}



