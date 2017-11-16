import java.util.ArrayList;
import java.util.Vector;

public class Course  {
   public Department dept;
   private String title; // title of the course (e.g. “Intro to programming”);
   private String code; // course code, e.g. SOFE, ELEE, MANE, etc.
   private int number; // course number, e.g. 1200, 2710, 2800, etc.
  // Student obj =;
   Vector  classList; // contains all students registered in this course

   public String getDept() {
	   return dept.toString();
   }
  
   public String getCode() {
	   return code;
   }
   public int getNumber() {
       return number;
   }

   public Course(String code, int number, Department dept, String title) {
	   classList = new Vector();
	   this.code= code;
	   this.title = title;
	   this.number = number;
	   this.dept = dept;
	   dept.offerCourse(this);
   }

  public String toString() {
     // return a string representation of the course with the course code,
     // name, and number of people registered in the course in the following
     // format:
     // SOFE 2710 Object Oriented Programming and Design, Enrollment = 260
	//  classList = obj.returnCourseList();
	  return code+" "+number+" " +title+" Enrollment = "+( classList == null ? 0 : classList.size());
  }
}
