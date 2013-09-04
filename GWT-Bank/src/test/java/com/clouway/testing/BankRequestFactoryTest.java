package com.clouway.testing;

import com.clouway.gwtbank.server.User;
import com.clouway.gwtbank.server.UserRepository;
import com.clouway.gwtbank.shared.BankRequestFactory;
import com.clouway.gwtbank.shared.UserProxy;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import org.easymock.Capture;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.easymock.EasyMock.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
@Factories(BankRequestFactory.class)
public class BankRequestFactoryTest extends RequestFactoryJreTest {
    @Inject
    BankRequestFactory bankRequestFactory;

    @Inject
    UserRepository userRepository;

    @Test
    public void addUserHappyPath() {
        BankRequestFactory.UserRequestContext userRequestContext = bankRequestFactory.context();

        Capture<User> userCapture = new Capture<User>();
        expect(userRepository.add(capture(userCapture))).andReturn(true).once();
        replay(userRepository);

        UserProxy userProxy = userRequestContext.create(UserProxy.class);
        userProxy.setUsername("John");
        userProxy.setPassword("12345");
        userRequestContext.add(userProxy).fire(new Receiver<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                assertTrue(result);
            }
        });

        assertEquals("John", userCapture.getValue().getUsername());
        assertEquals("12345", userCapture.getValue().getPassword());
        verify(userRepository);
    }

    @Test
    public void addSameUserTwice() {
        BankRequestFactory.UserRequestContext userRequestContext = bankRequestFactory.context();

        Capture<User> userCapture = new Capture<User>();

        expect(userRepository.add(capture(userCapture))).andReturn(false).once();

        replay(userRepository);

        UserProxy userProxy = userRequestContext.create(UserProxy.class);
        userProxy.setUsername("John");
        userProxy.setPassword("12345");

        userRequestContext.add(userProxy).fire(new Receiver<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                assertFalse(result);
            }
        });

        verify(userRepository);

    }

    @Test
    public void checkUserIsAlreadyAdded(){
        BankRequestFactory.UserRequestContext userRequestContext = bankRequestFactory.context();

        Capture<User> userCapture = new Capture<User>();

        expect(userRepository.hasUser(capture(userCapture))).andReturn(true);

        replay(userRepository);

        UserProxy userProxy = userRequestContext.create(UserProxy.class);
        userProxy.setUsername("John");
        userProxy.setPassword("12345");

        userRequestContext.hasUser(userProxy).fire(new Receiver<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                assertTrue(result);
            }
        });

        verify(userRepository);

    }

    @Test
    public void checkUserIsNotAdded(){
        BankRequestFactory.UserRequestContext userRequestContext = bankRequestFactory.context();

        Capture<User> userCapture = new Capture<User>();

        expect(userRepository.hasUser(capture(userCapture))).andReturn(false);

        replay(userRepository);

        UserProxy userProxy = userRequestContext.create(UserProxy.class);
        userProxy.setUsername("John");
        userProxy.setPassword("12345");

        userRequestContext.hasUser(userProxy).fire(new Receiver<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                assertFalse(result);
            }
        });

        verify(userRepository);

    }
}
