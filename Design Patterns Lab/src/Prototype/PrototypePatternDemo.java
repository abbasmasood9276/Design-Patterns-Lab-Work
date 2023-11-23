/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prototype;

/**
 *
 * @author aabik
 */
public class PrototypePatternDemo {
   public static void main(String[] args) {
      ShapeCache.loadCache();

      // Clone shapes
      Shape clonedShape = (Shape) ShapeCache.getShape("1");
      Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
      Shape clonedShape3 = (Shape) ShapeCache.getShape("3");

      // Compare shapes
      System.out.println("Shape 1 equals Shape 2: " + clonedShape.equals(clonedShape2));
      System.out.println("Shape 1 equals Shape 3: " + clonedShape.equals(clonedShape3));

      // Clone Avatars
      Shape avatar1 = (Shape) new Avatar("Fish");
      Shape avatar2 = (Shape) new Avatar("Fish");

      // Compare Avatars
      System.out.println("Avatar 1 equals Avatar 2: " + avatar1.equals(avatar2));
   }
}
