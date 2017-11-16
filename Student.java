import java.util.ArrayList;
import java.util.Vector;

public class Student {
  private String id;
  private String name;
  private ArrayList courses; // contains all courses the student is registered in
  Student(){}
  public ArrayList returnCourseList(){
	//  System.out.println(courses.get(0).getCode());
	return this.courses;
}
  public String getName() {
	  return this.name;
  }

  public String getId() {
	  return this.id;
  }
  //contructor 
  public Student(String id, String name) { 
	  this.courses =new ArrayList();
	  this.id = id;
	  this.name = name;  
  }

  public String toString() {
     // return a string representation of a student using the following format:
     // 100234546 John McDonald
     // Registered courses: ELEE 2110, ELEE 2790, SOFE 2710, SOFE 2800, SOFE 2850
	  int count = courses.size()-1;
	  StringBuilder resutl=new StringBuilder(id+" "+name);
	     //forloop to iterate through every courses
	     for(int i=0;i<courses.size();i++){
	    	 resutl.append("Registered courses:[");
	         resutl.append(" "+courses.get(i));
	         if(i==count)
	        	 resutl.append("]");
	     }
	     return resutl.toString();  
  }
  public void registerFor(Course course)
  {
      boolean isRegister=false;  // set flag    
      for(int i=0;i<course.classList.size();i++){
    	  // check if it is register
          if(((Student)course.classList.get(i)).getId().equals(this.id)){
        	  isRegister=true;
          }
      }    
      if(isRegister==false){      
          courses.add(course);
          course.classList.add(this);
          course.dept.registerList.add(this);
      }	
      else{}
  }
  public boolean isRegisteredInCourse(Course course) {
      for(int i=0;i<course.classList.size();i++){ 
    	  // check isRegisteredInCourse
          if(((Student)course.classList.get(i)).getId().equals(this.id)){
              return true; // if registered return true
          }
      } 
      return false; // not registered return false
      }
}
