package com.epam.ogoltsov.pool;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class DBConnectionPool {
    public static synchronized Connection getConnection() {
        try {
            return InstanceHolder.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBConnectionPoolException("Failed to getConnection()");
        }
    }

    private static class InstanceHolder {
        private static final DataSource DATASOURCE = create();

        private static DataSource create() {
            Context initContext;
            DataSource datasource;
            try {
                initContext = new InitialContext();
                Context envContext = (Context) initContext.lookup("java:/comp/env");
                datasource = (DataSource) envContext.lookup("jdbc/TestDB");
            } catch (NamingException e) {
                e.printStackTrace();
                throw new DBConnectionPoolException("Database initial context error.");
            }
            return datasource;
        }

        public static DataSource getInstance() {
            return DATASOURCE;
        }
    }

}
