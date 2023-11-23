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
public class ProxyPatternDemo {
   public static void main(String[] args) {
      // Virtual Proxy example
      Image image = new ProxyImage("test_10mb.jpg");
      // Image will be loaded from disk
      image.display();
      System.out.println("");

      // Image will not be loaded from disk (cached)
      image.display();
      System.out.println("");

      // Smart Proxy example
      Image smartImage = new SmartProxyImage("test.png");
      // Displaying fake content for unsupported image type
      smartImage.display();
      System.out.println("");

      // Exam scenario using Virtual, Smart, and Protected Proxy
      ExamResults originalResults = new ExamResults();
      originalResults.addAnswer("Q1: A");
      originalResults.addAnswer("Q2: B");
      originalResults.addAnswer("Q3: C");

      StudentProxy student1 = new StudentProxy("John");
      StudentProxy student2 = new StudentProxy("Alice");
      TeacherProxy teacher = new TeacherProxy();

      // Each student adds their answers to a clone of the original results
      ExamResults student1Results = originalResults.clone();
      student1Results.addAnswer("Q4: D");
      ExamResults student2Results = originalResults.clone();
      student2Results.addAnswer("Q4: A");

      // Students view their own results
      student1.viewResults(student1Results);
      System.out.println("");
      student2.viewResults(student2Results);
      System.out.println("");

      // Teacher views all results
      teacher.viewResults(originalResults);
   }
}
