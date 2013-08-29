package com.clouway.gwtbank.server;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: clouway
 * Date: 8/29/13
 * Time: 2:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class InMemoryUserDao implements UserRepository {
//    private Map<Long, User> users = new HashMap<Long, User>();
private Map<String, String> users = new HashMap<String, String>();

//    @Override
//    public boolean add(User user) {
//        boolean isAdded = false;
//        if (!users.containsKey(user.getId())) {
//            users.put(user.getId(),user);
//            isAdded = true;
//        }
//        return isAdded;
//    }

    @Override
    public boolean add(User user) {
        boolean isAdded = false;
        if (!users.containsKey(user.getUsername())) {
           users.put(user.getUsername(),user.getPassword());
            isAdded = true;
        }
        return isAdded;
    }

    @Override
    public boolean hasUser(User user) {
//        return users.containsKey(user.getId()) && users.containsValue(user);
        return true;
    }

    @Override
    public User findBy(Long id) {
//        User user = null;
//        if(users.containsKey(id)){
//            user = users.get(id);
//        }
//        return user;

        return null;
    }
}
