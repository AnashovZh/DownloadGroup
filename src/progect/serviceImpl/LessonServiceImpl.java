package progect.serviceImpl;

import progect.model.Database;
import progect.model.Group;
import progect.model.Lesson;
import progect.service.LessonService;

public class LessonServiceImpl implements LessonService {
    private Database database;

    public LessonServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public void addLessonToGroup(String groupName, Lesson lesson) {
        for (Group g:database.getGroups()) {
            if (g.getName().equalsIgnoreCase(groupName)){
                g.getLessons().add(lesson);
              //  g.addLessons(lesson);
                g.getLessons().add(lesson);
               // database.getLessons().add(lesson);
            }
        }
        System.out.println(lesson);
    }

    @Override
    public void getLessonByName(String lessonName) {
        for (Lesson s: database.getLessons()) {
            if (s.getNameLesson().equalsIgnoreCase(lessonName)){
                System.out.println(s);
            }
        }
    }

    @Override
    public void getAllLessonByGroupName(String groupName) {
        for (Group g: database.getGroups()) {
            if (g.getName().equalsIgnoreCase(groupName)){
                System.out.println(g.getLessons());
            }
        }
    }
}
