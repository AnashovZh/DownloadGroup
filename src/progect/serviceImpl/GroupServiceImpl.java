package progect.serviceImpl;

import progect.model.Database;
import progect.model.Group;
import progect.model.MyExseption;
import progect.service.GroupService;

import java.util.Random;

public class GroupServiceImpl implements GroupService {
    private Database database;

    public GroupServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public void addGroup(Group group) {
        try {
            for (Group g: database.getGroups()) {
                if (g.getName().equalsIgnoreCase(group.getName())){
                    throw  new MyExseption("Myndai grupa bar");
                }
            }
            database.getGroups().add(group);
            System.out.println(database.getGroups());
        }catch (MyExseption m){
            System.out.println(m.getMessage());
        }
    }

    @Override
    public void getGroupByName(String name) {
        for (Group g:database.getGroups()) {
            if (g.getName().equalsIgnoreCase(name)){
                System.out.println(g);
            }
        }
    }

    @Override
    public void getAllGroups() {
        System.out.println(database.getGroups());
    }
}
