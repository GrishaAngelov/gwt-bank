package com.clouway.gwtbank.server;

import com.google.web.bindery.requestfactory.shared.ServiceLocator;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class InMemoryUserRepoLocator implements ServiceLocator {
    @Override
    public Object getInstance(Class<?> aClass) {
        return InMemoryUserRepo.getInstance();
    }
}
