package com.clouway.gwtbank.server;

import com.clouway.gwtbank.inject.RequestFactoryInjectingModule;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class AppLoader extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                install(new RequestFactoryInjectingModule("/gwtRequest"));
                bind(UserRepository.class).to(InMemoryUserRepo.class).in(Singleton.class);
            }
        });
        return injector;
    }
}
