package com.clouway.gwtbank.server;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface Validator<T> {
    boolean isValid(T t);
}
