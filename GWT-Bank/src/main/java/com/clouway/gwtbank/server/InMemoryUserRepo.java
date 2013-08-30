package com.clouway.gwtbank.server;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class InMemoryUserRepo implements UserRepository {
    private static  InMemoryUserRepo instance = new InMemoryUserRepo();

    private InMemoryUserRepo() {

    }

    public static InMemoryUserRepo getInstance(){
        return instance;
    }

    private Map<Long, User> users = new HashMap<Long, User>();
    private Long id = 1L;

    @Override
    public boolean add(User user) {
        boolean isAdded = false;
        if (!users.containsValue(user)) {
            user.setId(id);
            users.put(user.getId(), user);
            isAdded = true;
            id++;
        }
        return isAdded;
    }

    @Override
    public boolean hasUser(User user) {
        boolean hasUser = false;

        for(Map.Entry<Long,User> userEntry : users.entrySet()){
            User regUser = userEntry.getValue();
            if(regUser.getUsername().equals(user.getUsername()) && regUser.getPassword().equals(user.getPassword())){
                hasUser = true;
                break;
            }
        }
        return hasUser;
    }

    @Override
    public User findBy(Long id) {
        User user = null;
        if (users.containsKey(id)) {
            user = users.get(id);
        }
        return user;
    }
}
