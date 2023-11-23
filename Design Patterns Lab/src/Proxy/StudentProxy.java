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
class StudentProxy {
   private String studentName;

   public StudentProxy(String studentName) {
      this.studentName = studentName;
   }

   public String getStudentName() {
      return studentName;
   }

   public void viewResults(ExamResults examResults) {
      examResults.display(this);
   }
}
