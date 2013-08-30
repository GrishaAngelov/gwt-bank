package com.clouway.gwtbank.client;

import com.clouway.gwtbank.client.proxy.UserProxy;
import com.clouway.gwtbank.server.InMemoryUserRepo;
import com.clouway.gwtbank.server.InMemoryUserRepoLocator;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.google.web.bindery.requestfactory.shared.Service;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface UserRequestFactory extends RequestFactory {

    @Service(value = InMemoryUserRepo.class, locator = InMemoryUserRepoLocator.class)
    public interface UserRequestContext extends RequestContext {
        Request<Boolean> add(UserProxy userProxy);

        Request<Boolean> hasUser(UserProxy userProxy);

        Request<UserProxy> findBy(Long id);
    }

    UserRequestContext context();


}
