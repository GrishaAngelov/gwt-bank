package com.clouway.gwtbank.server;

import java.sql.SQLException;

/**
* @author Grisha Angelov <grisha.angelov@clouway.com>
*/
public interface Action<T> {
    T execute() throws SQLException;

    void finish() throws SQLException;
}
