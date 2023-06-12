package progect.service;

import progect.enums.Gender;
import progect.model.Student;

import java.util.ArrayList;

public interface StudentService {
    //    private String name;
    //    private String lastName;
    //    private String email;
    //    private String password;
    //    private int age;
    //    private Gender gender;
    void addStudentToGroup(String groupName, Student student);
    ArrayList<Student> uppDateStudent(String groupName, String studentName, String newNameStudent, String newLastName, String newEmail, String newPassword, int newAge, Gender gender);
    void findStudentByFirstName(String studentFirstName);
    void getAllStudentsByGroupName(String groupName);
 void deleteStudent(String studentName);
}
