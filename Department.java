import java.util.ArrayList;
import java.util.Vector;

public class Department {
   private String name; // the name of school “Dept of Computing and Info Science”
   private String id; // short name for courses “SOFE”, “ELEE”, “STAT”, etc
   ArrayList courseList; // all courses offered by the department
   ArrayList registerList; // all students taking courses in the department.

   public String getName() {
	   return name;
   }

   public String getId() {
	   return id;
   }

   public Department(String name, String id) {
	   this.name = name;
	   this.id = id;
	   this.courseList = new ArrayList<Course>();
	   this.registerList = new  ArrayList<Student>() ;
   }

   public String toString() {
      // returns a string representation of department name, number 
      // of courses offered and number of students registered in the
      // department. Use the format:
      // ECSE: 53 courses, 460 students
	 //  for (int counter = 0; counter < courseList.size(); counter++) { 		      
	       return id+": "+( courseList == null ? 0 : courseList.size())+" courses, "+( registerList == null ? 0 : registerList.size())+"students"; 		
	     // }  
	 //  return "";
   }
   public void offerCourse(Course course){
	   boolean flagEnroll = false;
	   for (int counter = 0; counter <(courseList == null ? 0 : courseList.size()); counter++) { 
		   if(((Course)courseList.get(counter)).getNumber()==course.getNumber()){
			   flagEnroll=true;}
		  } 
	   if(flagEnroll == false){
	   courseList.add(course);
	   }
   }
   public void printCoursesOffered(){
	   for (int counter = 0; counter < (courseList == null ? 0 : courseList.size()); counter++) { 		      
		   System.out.println(courseList.get(counter));
		  }    
   }
  
   public boolean isStudentRegistered(Student student){
	   for (int counter = 0; counter < (courseList == null ? 0 : courseList.size()); counter++) { 
	   if(((Student)registerList.get(counter)).getId().equals(student.getId())){
		   return true;
	     }
	   }
	   return false; 
   }
   public Vector studentsRegisteredInCourse(int code){
	   Vector<Student> Stulist = new Vector<Student>();
	   if((courseList == null ? 0 :courseList.size())>0){
	   for (int counter = 0; counter < ( courseList == null ? 0 :courseList.size()) ; counter++) { 
		   if(((Course)courseList.get(counter)).getNumber()==code ){	  
			   Vector Tempcrslist = ((Course)courseList.get(counter)).classList;
			  // add Registered students in list 
			   for(int j=0;j<Tempcrslist.size();j++)
               {
				   Stulist.add((Student)Tempcrslist.get(j));
               }
		     }
		   else{}
	      }
	   }
		   return Stulist;
    }
  public void  printStudentsRegisteredInCourse(int code){
	  Vector<Student> crs= studentsRegisteredInCourse(code);
	  if(crs!=null){
	  for (int counter = 0; counter < crs.size(); counter++) { 
	  System.out.println(crs.get(counter).getId()+"    "+crs.get(counter).getName());
	  }
	  }
  }
  public Course largestCourse(){  
	  Course largerCrs = (Course)courseList.get(0);  
      for(int counter=0;counter<(courseList == null ? 0 :courseList.size());counter++)
      {
          if(largerCrs.classList.size()<((Course)courseList.get(counter)).classList.size())
          {
        	  largerCrs = (Course)courseList.get(counter);
          }
      }   
      return largerCrs;
  }
  public void printStudentsByName(){
	  
      Vector<Student> VprintStudentsByName = new Vector<Student>();
      for(int i=0;i<( registerList == null ? 0 : registerList.size());i++){
    	  boolean stuflag=false;
          for(Student stu : VprintStudentsByName){
              if(stu.getId().equals(((Student)registerList.get(i)).getId())){
                  stuflag=true;
              }
          }
           if(stuflag==false)
        	  VprintStudentsByName.add((Student)registerList.get(i));
      }
      for(int counter=0;counter<VprintStudentsByName.size();counter++)
          System.out.println(VprintStudentsByName.get(counter).getName()+"   "+VprintStudentsByName.get(counter).getId());
  }
}
