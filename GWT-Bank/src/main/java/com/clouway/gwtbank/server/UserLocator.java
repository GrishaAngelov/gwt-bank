package com.clouway.gwtbank.server;

import com.google.web.bindery.requestfactory.shared.Locator;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class UserLocator extends Locator<User,Long> {
    @Override
    public User create(Class<? extends User> aClass) {
        return new User();
    }

    @Override
    public User find(Class<? extends User> aClass, Long id) {
        InMemoryUserRepo inMemoryUserRepo = InMemoryUserRepo.getInstance();
        return inMemoryUserRepo.findBy(id);
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
