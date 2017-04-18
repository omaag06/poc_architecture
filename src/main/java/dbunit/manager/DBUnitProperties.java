package dbunit.manager;

import org.springframework.core.io.FileSystemResource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by Administrador on 16/05/2016.
 */
public class DBUnitProperties {

    private static final String CONFIGURATION_FILE_2 = "external/AcseleSeleniumTestConfigurationFile.properties";
    public static final String COUNTRY = "country";
    public static final String LANGUAGE = "language";
    public static final String DATABASE_DRIVER_SELENIUM = "driverDBSelenium";
    public static final String DATABASE_URL_SELENIUM = "urlDBSelenium";
    public static final String DATABASE_USER_SELENIUM = "userDBSelenium";
    public static final String DATABASE_PASSWORD_SELENIUM = "passwDBSelenium";
    public static final String DATABASE_SCHEMA_SELENIUM = "schemaDBSelenium";
    public static final String DATABASE_DRIVER_ACSELE = "driverDBAcsele";
    public static final String DATABASE_URL_ACSELE = "urlDBAcsele";
    public static final String DATABASE_USER_ACSELE = "userDBAcsele";
    public static final String DATABASE_PASSWORD_ACSELE = "passwDBAcsele";
    public static final String DATABASE_SCHEMA_ACSELE = "schemaDBAcsele";

    private static ResourceBundle commonProperties;
    private static Properties propertyRegistry;
    private static final String CONFIGURATION_FILE = "ConfigurationFile";
    private static final String SYSTEM_VARIABLE_ACSELE_CONFIGFILE = "ACSELE_CONFIGFILE";


    public static Properties getProperties() {

        propertyRegistry = new Properties();

        String property = null;
        try {
            if (property == null) {
                property = commonProperties.getString(CONFIGURATION_FILE_2);
            }

            if (property != null) {
                property = property.replaceAll("\\\\", "/");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (property != null) {
            FileInputStream inStream = null;
            try {
                inStream = new FileInputStream(getFileSystemResource(property).getPath());
                propertyRegistry.load(inStream);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (inStream != null) inStream.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
        return propertyRegistry;
    }

    public static FileSystemResource getFileSystemResource(String pathName) {

        return new FileSystemResource(pathName);

    }
}
