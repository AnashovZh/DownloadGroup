package progect.service;

import progect.model.Group;

public interface GroupService {

    void addGroup(Group group);
    void getGroupByName(String name);
    void getAllGroups();
}
