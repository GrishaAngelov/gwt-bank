package com.clouway.gwtbank.server;

import com.google.web.bindery.requestfactory.shared.ServiceLocator;

/**
 * Created with IntelliJ IDEA.
 * User: clouway
 * Date: 8/29/13
 * Time: 3:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class InMemoryUserDaoLocator implements ServiceLocator {
    @Override
    public Object getInstance(Class<?> aClass) {
        return new InMemoryUserDao();
    }
}
