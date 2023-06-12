package progect.model;

import java.util.ArrayList;

public class Database {
    private ArrayList<Group>groups=new ArrayList<>();
    private ArrayList<Student>students=new ArrayList<>();
    private ArrayList<Lesson>lessons=new ArrayList<>();
    private ArrayList<User>users=new ArrayList<>();

    public Database(ArrayList<User> users, ArrayList<Group> groups, ArrayList<Student> students, ArrayList<Lesson> lessons) {
        this.users = users;
        this.groups = groups;
        this.students = students;
        this.lessons = lessons;
    }

    public Database() {
    }

    public Database(ArrayList<Group> groups, ArrayList<Student> students, ArrayList<Lesson> lessons) {
        this.groups = groups;
        this.students = students;
        this.lessons = lessons;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }
}
