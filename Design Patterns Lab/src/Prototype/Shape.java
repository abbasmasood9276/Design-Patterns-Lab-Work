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
abstract class Shape implements Cloneable {

   private String id;
   protected String type;

   abstract void draw();

   public String getType() {
      return type;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   @Override
   public Object clone() {
      try {
         return super.clone();
      } catch (CloneNotSupportedException e) {
         e.printStackTrace();
         return null;
      }
   }

   public boolean equals(Shape a) {
      return this.getType().equals(a.getType());
   }
}