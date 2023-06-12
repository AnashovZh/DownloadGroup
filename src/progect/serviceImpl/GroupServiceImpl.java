package progect.serviceImpl;

import progect.model.Database;
import progect.model.Group;
import progect.model.MyException;
import progect.service.GroupService;

public class GroupServiceImpl implements GroupService {
    private Database database;

    public GroupServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public void addGroup(Group group) {
        try {
            for (Group g : database.getGroups()) {
                if (g.getName().equalsIgnoreCase(group.getName())) {
                    throw new MyException("Мындай аталыштагы группа бар ! ");
                }
            }
            database.getGroups().add(group);
            System.out.println(database.getGroups());
        } catch (MyException m) {
            System.err.println(m.getMessage());
        }
    }

    @Override
    public void getGroupByName(String name) {
        boolean b = false;
        try {
            for (int i = 0; i < database.getGroups().size(); i++) {
                if (database.getGroups().get(i).getName().equalsIgnoreCase(name)) {
                    System.out.println(database.getGroups().get(i));
                    b = true;
                    break;
                } else {
                    b = false;
                }
            }
            if (b == false) {
                throw new MyException("Myndai grupa jok");
            }
        } catch (MyException m) {
            System.err.println(m.getMessage());
        }
    }


    @Override
    public void updateGroupName(String groupName, String newName) {
        boolean a=false;
        int b=0;
        try {
           for (Group g : database.getGroups()) {
               if (g.getName().equalsIgnoreCase(groupName)) {
                   a=false;
                   b++;
                   g.setName(newName);
                   System.out.println("<<Группа ийгиликтуу алмаштырылды>>");
                   System.out.println(g.getName());

               }else{a=true;
               }
           }if (b==1){
               a=false;
            }if (a){
               throw new MyException("Not found this gruop");
            }
       }catch (MyException m){
            System.err.println(m.getMessage());
        }
    }

    @Override
    public void getAllGroups() {
        System.out.println(database.getGroups());
    }

    @Override
    public String deleteGroup(String groupName) {
        boolean a = false;
        int b = 0;
        try {
            for (int i = 0; i < database.getGroups().size(); i++) {
                if (database.getGroups().get(i).getName().equalsIgnoreCase(groupName)) {
                    database.getGroups().remove(database.getGroups().get(i));
                    System.out.println("Группа успешно удалено");
                    a = false;
                    b++;

                } else {
                    a = true;
                }
            }
            if (b == 1) {
                a = false;
            }if (a){
                throw new MyException("Такой грппы нет");
            }
        }catch (MyException m){
            System.err.println(m.getMessage());
        }return " ";
    }
}
