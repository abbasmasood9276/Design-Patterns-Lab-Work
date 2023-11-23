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
class Avatar extends Shape {

   public Avatar(String type) {
      this.type = type;
   }

   @Override
   public void draw() {
      System.out.println("Inside Avatar::draw() method.");
   }
}
