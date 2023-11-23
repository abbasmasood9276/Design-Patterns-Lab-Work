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
class TeacherProxy {
   public void viewResults(ExamResults examResults) {
      examResults.display(this);
   }
}
