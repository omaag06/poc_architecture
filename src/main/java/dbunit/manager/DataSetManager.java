package dbunit.manager;

import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.util.fileloader.DataFileLoader;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by rpacheco.
 */
public class DataSetManager {

    public static final int REFRESH_OPERATION = 1;
    public static final int DELETE_OPERATION = 2;
    public static final int CLEAN_INSERT_OPERATION = 3;
    public static final int INSERT_OPERATION = 4;
    public static final int UPDATE_OPERATION = 5;


    public static void createPartialDataSet(String query, String table, String fileName) throws Exception {

        IDatabaseConnection connection = DBUnitConnectionManager.createDBUnitProductConnection();

        QueryDataSet partialDataSet = new QueryDataSet(connection);
        partialDataSet.addTable(table, query);
        FlatXmlDataSet.write(partialDataSet, new FileOutputStream(fileName));
    }

    public static void loadDataSet(String fileLocation, int operationType) throws Exception {

        IDatabaseConnection connection = DBUnitConnectionManager.createDBUnitProductConnection();
        DataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet dataSet = loader.load(fileLocation);

        switch (operationType) {

            case REFRESH_OPERATION:

                DatabaseOperation.REFRESH.execute(connection, dataSet);
                break;

            case DELETE_OPERATION:

                DatabaseOperation.DELETE.execute(connection, dataSet);
                break;

            case CLEAN_INSERT_OPERATION:

                DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
                break;

            case INSERT_OPERATION:

                DatabaseOperation.INSERT.execute(connection, dataSet);
                break;

            case UPDATE_OPERATION:

                DatabaseOperation.UPDATE.execute(connection, dataSet);
                break;

            default:

                break;
        }
    }

    public static IDataSet createDataSet(String classPathResource) throws MalformedURLException, DataSetException, IOException {
        Resource resource = new ClassPathResource(classPathResource);
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(resource.getFile());
        return dataSet;
    }
}
