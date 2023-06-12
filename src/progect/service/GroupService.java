package progect.service;

import progect.model.Group;

public interface GroupService {

    void addGroup(Group group);
    void getGroupByName(String name);
    void updateGroupName(String groupName,String newName);
    void getAllGroups();
    String deleteGroup(String groupName);
}
