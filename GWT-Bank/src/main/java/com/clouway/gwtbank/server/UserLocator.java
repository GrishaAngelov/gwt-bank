package com.clouway.gwtbank.server;

import com.google.web.bindery.requestfactory.shared.Locator;

/**
 * Created with IntelliJ IDEA.
 * User: clouway
 * Date: 8/29/13
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserLocator extends Locator<User,Long> {
    @Override
    public User create(Class<? extends User> aClass) {
        return new User();
    }

    @Override
    public User find(Class<? extends User> aClass, Long id) {
        InMemoryUserDao inMemoryUserDao = new InMemoryUserDao();
        return inMemoryUserDao.findBy(id);
    }

    @Override
    public Class<User> getDomainType() {
        return User.class;
    }

    @Override
    public Long getId(User user) {
        return user.getId();
    }

    @Override
    public Class<Long> getIdType() {
        return Long.class;
    }

    @Override
    public Object getVersion(User user) {
        return user.getVersion();
    }
}
