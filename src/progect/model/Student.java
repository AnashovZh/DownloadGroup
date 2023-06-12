package progect.model;

import progect.enums.Gender;

import java.util.ArrayList;

public class Student {
    private static long counter=1;
    private long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private int age;
    private Gender gender;
    private ArrayList<Lesson>lessons;

    public Student( String name, String lastName, String email, String password, int age, Gender gender) {
        this.id = counter++;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    public Student(long id, String name, String lastName, String email, String password, int age, Gender gender, ArrayList<Lesson> lessons) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.lessons = lessons;
    }

    public ArrayList<Lesson> getLessons() {
        if (lessons==null){
            lessons=new ArrayList<>();
        }
        return lessons;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", lessons=" + lessons +
                '}';
    }
}