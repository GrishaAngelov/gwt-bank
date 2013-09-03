package com.clouway.gwtbank.server;

/**
 * User repository responsible for storing and retrieving users
 *
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface UserRepository {

    boolean add(User user);

    boolean hasUser(User user);
}
