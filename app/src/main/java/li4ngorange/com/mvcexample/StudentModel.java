package li4ngorange.com.mvcexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liangorange on 10/21/15.
 */
public class StudentModel {

    Map<Integer, Student> studentList;

    public StudentModel() {
        studentList = new HashMap<>();
    }


    public ArrayList<Student> getAllStudents() {
        return new ArrayList<>(studentList.values());
    }

    public Student getStudent(Integer studentID) {

        return studentList.get(studentID);

    }

    public void addStudent(Integer studentID, Student student) {
        studentList.put(studentID, student);
    }

    public int getTotalStudentNumber() {
        return studentList.size();
    }

}
