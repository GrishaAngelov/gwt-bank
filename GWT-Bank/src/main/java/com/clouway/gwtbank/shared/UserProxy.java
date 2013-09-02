package com.clouway.gwtbank.shared;

import com.clouway.gwtbank.server.EntityLocator;
import com.clouway.gwtbank.server.User;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
@ProxyFor(value = User.class, locator = EntityLocator.class)
public interface UserProxy extends EntityProxy {
    String getUsername();
    String getPassword();
    Long getId();

    void setUsername(String username);
    void setPassword(String password);
    void setId(Long id);



}
