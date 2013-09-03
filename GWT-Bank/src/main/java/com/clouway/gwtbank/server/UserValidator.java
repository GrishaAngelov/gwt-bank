package com.clouway.gwtbank.server;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class UserValidator implements Validator<User> {

  public boolean isValid(User user) {
    return !user.getUsername().equals("") && !user.getPassword().equals("");
  }
}
