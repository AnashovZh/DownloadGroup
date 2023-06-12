package progect.serviceImpl;

import progect.enums.Gender;
import progect.model.Database;
import progect.model.Group;
import progect.model.MyException;
import progect.model.Student;
import progect.service.StudentService;

import java.util.ArrayList;

public class StudentServiceImpl implements StudentService {
    private Database database;

    public StudentServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public void addStudentToGroup(String groupName, Student student) {
        boolean isTrue = false;
        try {
            for (Group g : database.getGroups()) {
                if (g.getName().equalsIgnoreCase(groupName)) {
                    g.getStudents().add(student);
                    System.out.println(g.getName()+" gruppasyna student igiliktyy koshuldu ");
                    isTrue = true;
                    break;
                } else {
                    isTrue = false;
                }
            }
            if (isTrue == false) {
                throw new MyException("Myndai gruppa jok");
            }
        } catch (MyException m) {
            System.err.println(m.getMessage());
        }
    }

    @Override
    public ArrayList<Student> uppDateStudent(String groupName, String studentName, String newNameStudent, String newLastName, String newEmail, String newPassword, int newAge, Gender gender) {
        boolean q = false;
        boolean x = false;
        try {
            for (Group g : database.getGroups()) {
                if (g.getName().equalsIgnoreCase(groupName)) {
                    q = false;
                    for (Student s : g.getStudents()) {
                        if (s.getName().equalsIgnoreCase(studentName)) {
                            s.setName(newNameStudent);
                            s.setLastName(newLastName);
                            s.setEmail(newEmail);
                            s.setPassword(newPassword);
                            s.setAge(newAge);
                            s.setGender(gender);
                            System.out.println("hello");
                            x = true;
                            break;
                        } else {
                            x = false;
                            break;
                        }
                    }
                } else {
                    q = false;
                    break;
                }
            }
            if (q) {
                throw new MyException("Myndai atalyshtagy gruppa jok");
            }
            if (x) {
                throw new MyException("Myndai atalyshtagy student jok");
            }
        } catch (MyException m) {
            System.err.println(m.getMessage());
        }
        return database.getStudents();
    }

    @Override
    public void findStudentByFirstName(String studentFirstName) {
        boolean a = false;
        int b = 0;
        try {
            for (Group g : database.getGroups()) {
                for (Student s : g.getStudents()) {
                    if (s.getName().equalsIgnoreCase(studentFirstName)) {
                        a = false;
                        System.out.println("Group name: " + g.getName() + " " + s);
                        b++;
                        break;
                    } else {
                        a = true;
                    }
                }
                if (b == 1) {
                    break;
                }
            }
            if (a) {
                throw new MyException("Нет такого студента!");
            }
        } catch (MyException m) {
            System.err.println(m.getMessage());
        }
    }

    @Override
    public void getAllStudentsByGroupName(String groupName) {
        boolean a = false;
        int b = 0;
        try {
            for (Group g : database.getGroups()) {
                for (Student s : g.getStudents()) {
                    if (g.getName().equalsIgnoreCase(groupName)) {
                        a = false;
                        b++;
                        System.out.println("Group name: " + g.getName() + " " + s);
                        break;
                    } else {
                        a = true;
                    }
                }
                if (b == 1) {
                    a = false;
                }
            }
            if (a) {
                throw new MyException("Myndai gruppa jok");
            }
        } catch (MyException m) {
            System.err.println(m.getMessage());
        }
    }

    @Override
    public void deleteStudent(String studentName) {
        boolean a = false;
        int b = 0;
        try {
            for (Group g : database.getGroups()) {
                for (int i = 0; i < g.getStudents().size(); i++) {
                    if (g.getStudents().get(i).getName().equalsIgnoreCase(studentName)) {
                        a=false;
                        b++;
                        g.getStudents().remove(g.getStudents().get(i));
                    }else{
                        a=true;
                    }
                }if (b==1){
                    a=false;
                }
            }if (a){
                throw new MyException("MYNDAI STUDENT JOK.");
            }
        }catch (MyException m){
            System.err.println(m.getMessage());
        }
    }
}

