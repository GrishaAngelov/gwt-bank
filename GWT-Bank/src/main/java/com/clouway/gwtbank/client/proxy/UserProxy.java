package com.clouway.gwtbank.client.proxy;

import com.clouway.gwtbank.server.User;
import com.clouway.gwtbank.server.UserLocator;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

/**
 * Created with IntelliJ IDEA.
 * User: clouway
 * Date: 8/29/13
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */
@ProxyFor(value = User.class, locator = UserLocator.class)
public interface UserProxy extends EntityProxy {
    String getUsername();
    String getPassword();
    Long getId();

    void setUsername(String username);
    void setPassword(String password);
    void setId(Long id);



}
