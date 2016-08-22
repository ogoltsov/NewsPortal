package com.epam.ogoltsov.pool;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionPool {

    private static final String GET_CONNECTION_EXCEPTION = "Can't getting connection from CP";

    public static synchronized Connection getConnection() {
        try {
            return InstanceHolder.getInstance().getConnection();
        } catch (SQLException e) {
            throw new DBConnectionPoolException(GET_CONNECTION_EXCEPTION, e);
        }
    }

    private static class InstanceHolder {
        private static final DataSource DATASOURCE = create();
        private static final String CONNECTION_POOL_EXCEPTION = "Connection Pool initialization exception";

        private static DataSource create() {
            Context initContext;
            DataSource datasource;
            try {
                initContext = new InitialContext();
                Context envContext = (Context) initContext.lookup("java:/comp/env");
                datasource = (DataSource) envContext.lookup("jdbc/TestDB");
            } catch (NamingException e) {
                throw new DBConnectionPoolException(CONNECTION_POOL_EXCEPTION, e);
            }
            return datasource;
        }

        static DataSource getInstance() {
            return DATASOURCE;
        }
    }

}
