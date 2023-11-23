/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proxy;

/**
 *
 * @author aabik
 */
class SmartProxyImage implements Image {
   private String fileName;

   public SmartProxyImage(String fileName){
      this.fileName = fileName;
   }

   @Override
   public void display() {
      if (fileName.endsWith(".jpg")) {
         // For supported image types, use the ProxyImage behavior
         Image image = new ProxyImage(fileName);
         image.display();
      } else {
         // For unsupported types, display fake content
         System.out.println("Displaying fake content for unsupported image type: " + fileName);
      }
   }
}

