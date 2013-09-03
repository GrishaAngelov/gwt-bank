package com.clouway.gwtbank.server;

import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Locator;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class EntityLocator<T> extends Locator<T,Long> {
    private final UserRepository userRepository;

    @Inject
    public EntityLocator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public T create(Class<? extends T> aClass) {
        try {
            return aClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public T find(Class<? extends T> aClass, Long aLong) {
        return (T) userRepository.findBy(aLong);
    }

    @Override
    public Class<T> getDomainType() {
        return (Class<T>) User.class;
    }

    @Override
    public Long getId(T domainObject) {
        return ((User)domainObject).getId();
    }

    @Override
    public Class<Long> getIdType() {
        return Long.class;
    }

    @Override
    public Object getVersion(T domainObject) {
        return ((User)domainObject).getVersion();
    }
}
