package progect.service;

import progect.model.Lesson;

public interface LessonService {
    void addLessonToGroup(String groupName,Lesson lesson);
    void getLessonByName(String lessonName);
    void getAllLessonByGroupName(String groupName);
}
