package progect.model;

import java.util.ArrayList;

public class Group {
    private long id;
    private String name;
    private String description;
    private ArrayList<Lesson>lessons;
    private ArrayList<Student>students;

    public Group(long id, String name, String description, ArrayList<Lesson> lessons, ArrayList<Student> students) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lessons = lessons;
        this.students = students;
    }

    public Group(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }
    public void addLessons(Lesson lesson){
        lessons.add(lesson);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", lessons=" + lessons +
                ", students=" + students +
                '}';
    }
}
