package dbunit.manager;


import org.apache.commons.dbcp.BasicDataSource;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by rpacheco
 */
public class DBUnitConnectionManager {

    private static Properties properties;
    private static final String DATABASE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DATABASE_URL = "jdbc:oracle:thin:@192.168.1.52:1521:oracsel";
    private static final String DATABASE_USER = "userDB";
    private static final String DATABASE_PASSWORD = "passwDB";
    private static final String DATABASE_SCHEMA = "userDB";
    private static final String INSTANCE_ISO_CODE = "instance.conf.for.test";


    public static BasicDataSource getUserDataSource() {

        //properties = DBUnitProperties.getProperties();
        //String instance = properties.getProperty(INSTANCE_ISO_CODE);

        BasicDataSource datasource = new BasicDataSource();
        //datasource.setDriverClassName(properties.getProperty(DATABASE_DRIVER));
        //datasource.setUrl(properties.getProperty(DATABASE_URL));
        //datasource.setUsername(properties.getProperty(DATABASE_USER + instance));
        //datasource.setPassword(properties.getProperty(DATABASE_PASSWORD + instance));
        /*datasource.setDriverClassName(DATABASE_DRIVER);
        datasource.setUrl(DATABASE_URL);
        datasource.setUsername(DATABASE_USER);
        datasource.setPassword(DATABASE_PASSWORD);*/
        datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        datasource.setUrl("jdbc:oracle:thin:@192.168.1.52:1521:oracsel");
        datasource.setUsername("SPT_BRHN_V138_II");
        datasource.setPassword("SPT_BRHN_V138_II");

        return datasource;

    }

    public static BasicDataSource getGlobalDataSource() {

        properties = DBUnitProperties.getProperties();

        BasicDataSource datasource = new BasicDataSource();
        /*datasource.setDriverClassName(properties.getProperty(DATABASE_DRIVER));
        datasource.setUrl(properties.getProperty(DATABASE_URL));
        datasource.setUsername(properties.getProperty(DATABASE_USER));
        datasource.setPassword(properties.getProperty(DATABASE_PASSWORD));*/
        datasource.setDriverClassName(DATABASE_DRIVER);
        datasource.setUrl(DATABASE_URL);
        datasource.setUsername(DATABASE_USER);
        datasource.setPassword(DATABASE_PASSWORD);

        return datasource;

    }


    public static IDatabaseConnection createDBUnitGlobalConnection() throws SQLException {

        IDatabaseConnection dbConn = null;
        Connection conn = null;
        BasicDataSource dataSource = DBUnitConnectionManager.getGlobalDataSource();

        try {
            conn = dataSource.getConnection();
            dbConn = new DatabaseConnection(conn, dataSource.getUsername());

        } catch (DatabaseUnitException e) {
            e.printStackTrace();
        }
        return dbConn;
    }

    public static IDatabaseConnection createDBUnitProductConnection() throws SQLException {

        IDatabaseConnection dbConn = null;
        Connection conn = null;
        BasicDataSource dataSource = DBUnitConnectionManager.getUserDataSource();

        try {
            conn = dataSource.getConnection();
            dbConn = new DatabaseConnection(conn, dataSource.getUsername());

        } catch (DatabaseUnitException e) {
            e.printStackTrace();
        }
        return dbConn;
    }

}
