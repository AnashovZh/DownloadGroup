package progect;

import org.w3c.dom.ls.LSOutput;
import progect.enums.Gender;
import progect.model.*;
import progect.serviceImpl.GroupServiceImpl;
import progect.serviceImpl.LessonServiceImpl;
import progect.serviceImpl.StudentServiceImpl;
import progect.serviceImpl.UserServiceImpl;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Random;
import java.util.Scanner;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner1=new Scanner(System.in);//string
        Scanner scanner2=new Scanner(System.in);//int
        int a;
        int n;

        Database database=new Database();
        GroupServiceImpl groupService=new GroupServiceImpl(database);
        LessonServiceImpl lessonService=new LessonServiceImpl(database);
        StudentServiceImpl studentService=new StudentServiceImpl(database);
        User user=new User();

        while (true){
            ZonedDateTime zonedDateTime=ZonedDateTime.now();
            System.out.println(zonedDateTime);
            LocalTime localTime=LocalTime.now();
            if (localTime.isBefore(LocalTime.NOON)){
                System.out.println("Kutman tanynyz menen");
            } else if (localTime.isBefore(LocalTime.of(18,0))) {
                System.out.println("Kutman kununuz menen");
            } else System.out.println("Kutman keciniz menen");

            System.out.println("Kattalgan bolsonuz 1 unutup kalsanyz 2 baskychyn basyp almashtyrynyz.");

            switch (a=scanner2.nextInt()){
                case  1:
                    System.out.println("Admindin pochtasyn jazynyz");
                    String gmail=scanner1.nextLine();
                    System.out.println("Admindin parolun jazynyz");
                    String passw=scanner1.nextLine();
                  try {
                      if (!user.getEmail().equals(gmail) || !user.getPassword().equals(passw)) {
                          throw new MyException("Email je parol tuura emes!");
                      }else {
                          while (true) {
                              System.out.println(
                                      "|____________________________________________________________________|\n" +
                                              "| 1.Add new Group                 | 8.Get all students by group name |\n" +
                                              "| 2.Get Group by name             | 9.Get all student's lesson       |\n" +
                                              "| 3.Update group name             | 10.Delete student                |\n" +
                                              "| 4.Get all groups                | 11.Add new lesson to group       |\n" +
                                              "| 5.Add new student to group      | 12.Get lesson by name            |\n" +
                                              "| 6.Update student                | 13.Get all lesson by group name  |\n" +
                                              "| 7.Find student by first name    | 14.Delete Group                  |\n" +
                                              "|                        15.Delete Lesson                            |\n" +
                                              "|____________________________________________________________________|\n");


                              switch (n=scanner2.nextInt()) {
                                  case 1:
                                      System.out.println("add new group");
                                      System.out.println("Write name group:");
                                      System.out.println("Input name group");
                                      String groupName = scanner1.nextLine();
                                      System.out.println("Input description");
                                      String description = scanner1.nextLine();
                                      groupService.addGroup(new Group(groupName, description));
                                      break;
                                  case 2: System.out.println("get group by name:");
                                      String word1 = scanner1.nextLine();
                                      groupService.getGroupByName(word1);
                                      break;

                                  case 3:   System.out.println("Uppdate group name:");
                                      System.out.println("Write group name");
                                      String groupName7 = scanner1.nextLine();
                                      System.out.println("Write new group name:");
                                      String newGroupName = scanner1.nextLine();
                                      groupService.updateGroupName(groupName7, newGroupName);
                                      break;

                                  case 4:  System.out.println("get all groups");
                                      groupService.getAllGroups();
                                      break;

                                  case 5:
                                      System.out.println("Add new student to group ");
                                      System.out.println("Input group name");
                                      // System.out.println("Write name student");
                                      String groupNAME=scanner1.nextLine();
                                      System.out.println("Write name student");
                                      String name=scanner1.nextLine();
                                      System.out.println("Write last name student");
                                      String lastName=scanner1.nextLine();
                                      System.out.println("Write email student");
                                      String email=scanner1.nextLine();
                                      System.out.println("Write pasword student");
                                      String password=scanner1.nextLine();
                                      System.out.println("Write age student");
                                      int age=scanner2.nextInt();
                                      System.out.println("Write gender student");
                                      String gender=scanner1.nextLine();
                                      if (gender.equalsIgnoreCase("male")){
                                          gender=String.valueOf(Gender.MALE);
                                      } else if (gender.equalsIgnoreCase("female")) {
                                          gender=String.valueOf(Gender.FEMALE);
                                      }
                                      studentService.addStudentToGroup(groupNAME,new Student(name,lastName,email,password,age,Gender.valueOf(gender)));
                                      break;

                                  case 6:
                                      System.out.println("Update student");
                                      System.out.println("Input group name");
                                      String groupName6=scanner1.nextLine();
                                      System.out.println("write student name");
                                      String studentName=scanner1.nextLine();
                                      System.out.println("write student new name");
                                      String studentNewName=scanner1.nextLine();
                                      System.out.println("write student new last name");
                                      String studLastName=scanner1.nextLine();
                                      System.out.println("write email student");
                                      String emailSt=scanner1.nextLine();
                                      System.out.println("write password student");
                                      String passwordSt=scanner1.nextLine();
                                      System.out.println("write age student");
                                      int ageSt=scanner2.nextInt();
                                      System.out.println("write student gender");
                                      String genderSt=scanner1.nextLine();
                                      if (genderSt.equalsIgnoreCase("male")){
                                          genderSt=String.valueOf(Gender.MALE);
                                      } else if (genderSt.equalsIgnoreCase("female")) {
                                          genderSt=String.valueOf(Gender.FEMALE);
                                      }
                                      System.out.println(studentService.uppDateStudent(groupName6,studentName,studentNewName,studLastName,emailSt,passwordSt,ageSt,Gender.valueOf(genderSt)));
                                      break;

                                  case 7:
                                      System.out.println("Find student by first name");
                                      System.out.println("Input student name");
                                      String studentName7=scanner1.nextLine();
                                      studentService.findStudentByFirstName(studentName7);
                                      break;
                                  case 8:
                                      System.out.println("Get all students by group name");
                                      System.out.println("write group name");
                                      String groupName8=scanner1.nextLine();
                                      studentService.getAllStudentsByGroupName(groupName8);
                                      break;
                                  case 9:
                                      System.out.println("Get all students lesson");
                                      System.out.println("write student's name");
                                      String stName=scanner1.nextLine();
                                      lessonService.getAllStudentsLessonByNameSt(stName);
                                      break;
                                  case 10:
                                      System.out.println("Delete student");
                                      System.out.println("write student name");
                                      String nameStudent=scanner1.nextLine();
                                      studentService.deleteStudent(nameStudent);
                                      break;
                                  case 11:
                                      System.out.println("add new lesson to group");
                                      System.out.println("write group name");
                                      String groupName1 = scanner1.nextLine();
                                      System.out.println("write lesson name");
                                      String lessonNAME = scanner1.nextLine();
                                      System.out.println("write lesson description");
                                      String lessonDescription = scanner1.nextLine();
                                      lessonService.addLessonToGroup(groupName1, new Lesson( lessonNAME, lessonDescription));
                                      break;
                                  case 12:
                                      System.out.println("get lesson by name:");
                                      String word4 = scanner1.nextLine();
                                      lessonService.getLessonByName(word4);
                                      break;
                                  case 13:
                                      System.out.println("get all  lesson by group name:");
                                      String word5 = scanner1.nextLine();
                                      lessonService.getAllLessonByGroupName(word5);
                                      break;
                                  case 14:
                                      System.out.println("Delete lesson");
                                      String lessonName=scanner1.nextLine();
                                      lessonService.deleteLesson(lessonName);
                                      break;
                                  case 15:
                                      System.out.println("Delete group ");
                                      System.out.println("Write group name ");
                                      String groupName16=scanner1.nextLine();
                                      System.out.println(groupService.deleteGroup(groupName16));
                                      break;
                              }
                          }
                      }
                  }catch (MyException m){
                      System.err.println(m.getMessage());
                  }
                  break;
                case 2:
                    System.out.println("write admin email");
                    String emailAd=scanner1.nextLine();
                    System.out.println("write new password");
                    String passwordAd=scanner1.nextLine();
                    user.uppDatePassword(emailAd,passwordAd);
                    break;
            }

      }
    }}
