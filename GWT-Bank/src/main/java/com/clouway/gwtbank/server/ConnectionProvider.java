package com.clouway.gwtbank.server;

import com.google.inject.Provider;
import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnection;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.pool.impl.GenericObjectPool;


/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

public class ConnectionProvider implements Provider<PoolableConnection> {

    private static GenericObjectPool objectPool;
    private static ConnectionFactory connectionFactory;
    private static PoolableConnectionFactory poolableConnectionFactory;
    private static ThreadLocal<PoolableConnection> connectionThreadLocal;

    private String url = "jdbc:mysql://localhost:3306/bank";
    private String user = "root";
    private String password = "123456";

    public ConnectionProvider() {
        setUpDatabaseConnection(url, user, password);
    }


    public static void setUpDatabaseConnection(String url, String user, String password) {
        objectPool = new GenericObjectPool();
        objectPool.setMaxActive(10);
        objectPool.setWhenExhaustedAction(GenericObjectPool.WHEN_EXHAUSTED_GROW);
        connectionFactory = new DriverManagerConnectionFactory(url, user, password);
        poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, objectPool, null, null, false, true);
        connectionThreadLocal = new ThreadLocal<PoolableConnection>();
    }

    @Override
    public PoolableConnection get() {
        try {
            connectionThreadLocal.set((PoolableConnection) poolableConnectionFactory.getPool().borrowObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connectionThreadLocal.get();
    }
}
