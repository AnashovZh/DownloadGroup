package progect.serviceImpl;

import progect.model.*;
import progect.service.LessonService;

public class LessonServiceImpl implements LessonService {
    private Database database;

    public LessonServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public void addLessonToGroup(String groupName, Lesson lesson) {
        try {
            for (Group g : database.getGroups()) {
                for (Lesson l : g.getLessons()) {
                    if (l.getNameLesson().equalsIgnoreCase(lesson.getNameLesson())) {
                        throw new MyException("Мындай аталыштагы сабак бар !");
                    }
                }
            }
            for (Group g : database.getGroups()) {
                if (g.getName().equalsIgnoreCase(groupName)) {
                    for (Student s : g.getStudents()) {
                        s.getLessons().add(lesson);

                    }
                }
            }
            System.out.println(lesson);
        } catch (MyException m) {
            System.out.println(m.getMessage());
        }
    }

    @Override
    public void getLessonByName(String lessonName) {
        boolean a = false;
        int b = 0;
        try {
            for (Group g : database.getGroups()) {
                for (Lesson l : g.getLessons()) {
                    if (l.getNameLesson().equalsIgnoreCase(lessonName)) {
                        a = false;
                        b++;
                        System.out.println(l);
                    } else {
                        a = true;
                    }
                }
                if (b == 1) {
                    a = false;
                }
            }
            if (a) {
                throw new MyException("Not found this student");
            }
        } catch (MyException m) {
            System.err.println(m.getMessage());
        }
    }

    @Override
    public void getAllLessonByGroupName(String groupName) {
        boolean a = false;
        int b = 0;
        try {
            for (Group g : database.getGroups()) {
                if (g.getName().equalsIgnoreCase(groupName)) {
                    a = false;
                    b++;
                    System.out.println("Тайпанан аты: "+g.getName() +" "+g.getLessons());
                } else {
                    a = true;
                }
            }
            if (b == 1) {
                a = false;
            }
            if (a) {
                throw new MyException("Мындай группа жок");
            }
        } catch (MyException m) {
            System.out.println(m.getMessage());
        }
    }

    @Override
    public void deleteLesson(String lessonName) {
        boolean a = false;
        int b = 0;
        try {
            for (Group g : database.getGroups()) {
                for (int i = 0; i < g.getLessons().size(); i++) {
                    if (g.getLessons().get(i).getNameLesson().equalsIgnoreCase(lessonName)) {
                        a = false;
                        b++;
                        g.getLessons().remove(g.getLessons().get(i));
                        System.out.println("Delete ");
                    }else {
                        a=true;
                    }
                }if (b==1){
                    a=false;
                }
            }if (a){
                throw new MyException("Мындай сабак жок");
            }
        }catch (MyException myException){
            System.err.println(myException.getMessage());
        }

    }

    @Override
    public void getAllStudentsLessonByNameSt(String studentName) {
        boolean a = false;
        int b = 0;
        try {
            for (Group g : database.getGroups()) {
                for (Student s : g.getStudents()) {
                    if (s.getName().equalsIgnoreCase(studentName)) {
                        a = false;
                        b++;
                        System.out.println("Тайпасынын аты" + g.getName() + " " + s.getLessons());
                    } else {
                        a = true;
                    }
                }
                if (b == 1) {
                    a = false;
                }
            }
            if (a) {
                throw new MyException("Бул ысымдагы окуучу жок");
            }
        } catch (MyException m) {
            System.err.println(m.getMessage());
        }
    }
}
