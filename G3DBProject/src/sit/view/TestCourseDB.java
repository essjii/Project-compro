/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.view;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import sit.controller.CourseController;
import sit.model.Course;

/**
 *
 * @author INT105
 */
public class TestCourseDB {
    public static void main(String[] args) {
        try{
            Scanner usr = new Scanner(System.in);
            
            System.out.print("Enter User Name : ");
            String usrName = usr.next();
            
            System.out.print("Enter Password : ");
            String password = usr.next();
            
            CourseController courseCtrl = new CourseController(usrName, password);
//            CourseController courseCtrl = new CourseController("sit", "sit");
//            courseCtrl.executeSQLFromUsre("Select * from course where courseId = 'GEN111'");
//            courseCtrl.executeSQLFromUsre("update course set courseName = 'Strong Man' where courseId = 'GEN111'");
            courseCtrl.dropCourseTable();
//            courseCtrl.createCourseTable();

//            Course c1 = new Course("INT105", "Computer Programming II");
//            int insertedRec = courseCtrl.insertCourse(c1);
//            System.out.println(insertedRec+"Insert Record");

//            courseCtrl.insertFromFile("courseList.txt");
            
//            ArrayList<Course> cList = courseCtrl.selectCourses();
            //การ update or แก้ข้อมูลลงบน data base
            
//            for (int i = 0; i < cList.size(); i++) {
//                System.out.println(cList.get(i));
//                String cName = cList.get(i).getCourseName();
//                if(cName.equalsIgnoreCase("GEN111")){
//                    cList.get(i).setCourseName("Strong Man");
//                }
//            }
            courseCtrl.closeCourseConnection();
                        
        }
        catch(ClassNotFoundException cnf){
            System.out.println(cnf);
        }
        catch(SQLException cnf){
            System.out.println(cnf);
        }
//        catch(FileNotFoundException fnf){
//            System.out.println(fnf);
//        }
    }
}
