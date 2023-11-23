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
import java.util.ArrayList;
import java.util.List;

class ExamResults implements Cloneable {
   private List<String> answers;

   public ExamResults() {
      this.answers = new ArrayList<>();
   }

   public void addAnswer(String answer) {
      this.answers.add(answer);
   }

   public void display(StudentProxy studentProxy) {
      // Protected Proxy behavior - Only show results to the specific student
      System.out.println("Displaying results for student: " + studentProxy.getStudentName());
      System.out.println("Answers: " + answers);
   }

   public void display(TeacherProxy teacherProxy) {
      // Protected Proxy behavior - Show a collection of results to the teacher
      System.out.println("Displaying results for all students:");
      System.out.println("Answers: " + answers);
   }

   @Override
   public ExamResults clone() {
      try {
         ExamResults clone = (ExamResults) super.clone();
         clone.answers = new ArrayList<>(this.answers);
         return clone;
      } catch (CloneNotSupportedException e) {
         throw new RuntimeException(e);
      }
   }
}

