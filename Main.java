import java.util.*;
import java.io.*;
import java.text.ParseException;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        //CSVReader path define
		String path = "C:\\Users\\shinh\\Desktop\\RMIT\\Further Programming\\test.csv";

        String line = "";


		try {
			
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			while ((line = br.readLine()) != null) {
				String[] col = line.split(",");

                List<String> list = new ArrayList<String>();

                for (int i = 0; i < col.length; i++) {
                    list.add(col[i]);
                }

                System.out.println(list.toString());

                
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (PrintWriter writer = new PrintWriter(path)) {
            StringBuilder sb = new StringBuilder();
            sb.append("ID");
            sb.append(",");
            sb.append("Student Name");
            sb.append(",");
            sb.append("Date of Birth");
            sb.append(",");
            sb.append("Course ID");
            sb.append(",");
            sb.append("Course Name");
            sb.append(",");
            sb.append("Number of Credits");
            sb.append(",");
            sb.append("Semester");
            sb.append("\n");

            writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Course update = new Course();
        update.courseCredits("Python", "BH0001");
		// //Create a scanner student name
        // Scanner studentName = new Scanner(System.in);
        // System.out.println("Enter the student name: ");
        // String sName = studentName.nextLine();

        // //Create a scanner for student ID
        // Scanner studentID = new Scanner(System.in);
        // System.out.println("Enter the student ID: ");
        // String sID = studentID.nextLine();

        // //Create a scanner for student birthdate
        // Scanner studentBirthdate = new Scanner(System.in);
        // System.out.println("Enter the student birthdate (DD/MM/YYYY): ");
        // String sDate = studentBirthdate.nextLine();

        // Student student = new Student(sName, sID, sDate);
        
        // //Test for Student input
        // //System.out.println(student);

        // //Create a scanner for course name
        // Scanner courseName = new Scanner(System.in);
        // System.out.println("Enter the course name: ");
        // String cName = courseName.nextLine();

        // //Create a scanner for course id
        // Scanner courseID = new Scanner(System.in);
        // System.out.println("Enter the course ID: ");
        // String cID = courseID.nextLine();

        // //Create a scanner for course number of credits
        // Scanner courseCredits = new Scanner(System.in);
        // System.out.println("Enter the course number of credits: ");
        // String cCredits = courseCredits.nextLine();

        // Course course = new Course(cName, cID, cCredits);
        
        // //Test for Course input
        // //System.out.println(course);

        // //Create a scanner for course semester
        // Scanner courseSemester = new Scanner(System.in);
        // System.out.println("Enter the course semester: ");
        // String cSemester = courseSemester.nextLine();

        // //Create an array to store student information
        // ArrayList<String> studentList = new ArrayList<String>();
        // studentList.add(sID);
        // studentList.add(sName);
        // studentList.add(sDate);
        // studentList.add(cID);
        // studentList.add(cName);
        // studentList.add(cCredits);
        // studentList.add(cSemester);

        // System.out.println(studentList);
        

	}
	
	// public static void CSVReader(String path) {
		
		
	// }

}

class Student {
	public String studentName;
    public String studentID;
    public String date;
       
}

class Course {
	public String courseName;
    public String courseID;
    public String credits;

    String coursePath = "C:\\Users\\shinh\\Desktop\\RMIT\\Further Programming\\Course.csv";
    public void courseCredits(String courseName, String courseID){

        try (PrintWriter writer = new PrintWriter(coursePath)) {
            StringBuilder sb = new StringBuilder();

            try {
                BufferedReader br = new BufferedReader(new FileReader(coursePath));
                String line = "";

                while ((line = br.readLine()) != null) {
                    String[] col = line.split(",");

                    if (col[0].equals(courseID)) {
                        sb.append(courseID);
                        sb.append(",");
                        sb.append(courseName);
                        sb.append(",");
                        sb.append("5");
                        
                        writer.write(sb.toString());
                    }

                }

            } catch (Exception e) {
                //TODO: handle exception
            }   
        } catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }

    }
}


abstract class StudentEnrolment implements StudentEnrolManager {
    
}


interface StudentEnrolManager {
    public String add(Course courseName, Student studentName, Student studentID);
    public String update(Course courseName, Student studentName, Student studentID);
    public String delete(Course courseName, Student studentName, Student studentID);
    public String getOne(Course courseName, Student studentName, Student studentID);
    public String getAll(Course courseName, Student studentName, Student studentID);
}
