package com.clouway.gwtbank.client;

import com.clouway.gwtbank.client.proxy.UserProxy;
import com.clouway.gwtbank.server.InMemoryUserDao;
import com.clouway.gwtbank.server.InMemoryUserDaoLocator;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.google.web.bindery.requestfactory.shared.Service;

/**
 * Created with IntelliJ IDEA.
 * User: clouway
 * Date: 8/29/13
 * Time: 3:34 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserRequestFactory extends RequestFactory {

    @Service(value = InMemoryUserDao.class, locator = InMemoryUserDaoLocator.class)
    public interface UserRequestContext extends RequestContext {
        Request<Boolean> add(UserProxy userProxy);

        Request<Boolean> hasUser(UserProxy userProxy);

        Request<UserProxy> findBy(Long id);
    }

    UserRequestContext context();


}
