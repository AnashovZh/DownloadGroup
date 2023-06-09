package progect;

import progect.model.Database;
import progect.model.Group;
import progect.model.Lesson;
import progect.serviceImpl.GroupServiceImpl;
import progect.serviceImpl.LessonServiceImpl;

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
        Scanner scanner3=new Scanner(System.in);//int
        int n;
        Database database=new Database();
        GroupServiceImpl groupService=new GroupServiceImpl(database);
        LessonServiceImpl lessonService=new LessonServiceImpl(database);
        while (true){
            ZonedDateTime zonedDateTime=ZonedDateTime.now();
            System.out.println(zonedDateTime);
            System.out.println(LocalTime.now());
            LocalTime localTime=LocalTime.now();
            if (localTime.isBefore(LocalTime.NOON)){
                System.out.println("Kutman tanynyz menen");
            } else if (localTime.isBefore(LocalTime.of(18,0))) {
                System.out.println("Kutman kununuz menen");
            } else System.out.println("Kutman keciniz menen");


        while (true){
        switch (n= scanner2.nextInt()){
            case 1:
                System.out.println("Write name group:");
                Random random=new Random();
                long id= random.nextLong();
                System.out.println("Input name group");
                String groupName=scanner1.nextLine();
                System.out.println("Input description");
                String description=scanner1.nextLine();
                groupService.addGroup(new Group(id,groupName,description));
                break;
            case 2:
                System.out.println("get all");
                groupService.getAllGroups();
                break;
            case 3:
                System.out.println("get group by name:");
                String word1= scanner1.nextLine();
                groupService.getGroupByName(word1);
                break;
            case 4:
                System.out.println("add lesson to group");
                Random random1=new Random();
                Long id1= random1.nextLong();
                System.out.println("write group name");
                String groupName1= scanner1.nextLine();
                System.out.println("write lesson name");
                String lessonNAME= scanner1.nextLine();
                System.out.println("write lesson description");
                String lessonDescription= scanner1.nextLine();
                lessonService.addLessonToGroup(groupName1,new Lesson(id1,lessonNAME,lessonDescription));
                break;
            case 5:
                System.out.println("get lesson by name:");
                String word4= scanner1.nextLine();
                lessonService.getLessonByName(word4);
                break;
            case 6:
                System.out.println("get by group name:");
                Scanner scanner5=new Scanner(System.in);
                String word5= scanner5.nextLine();
                lessonService.getAllLessonByGroupName(word5);
                break;
        }}
    }}
}