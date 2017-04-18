package dbunit;


import dbunit.manager.DBUnitConnectionManager;
import dbunit.manager.DataSetManager;
import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Created by rpacheco on 22/04/2016.
 */
public class AppointmentTest {

    //private static final AcseleLogger log = AcseleLogger.getLogger(Appointment.class);

    @Test
    //@Transactional
    public void getAllStatesTest() {

        //log.info("Inicio del test de inserción");
        Assert.assertEquals(5, countStates());

    }

    /*@Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream("/state_dataset.xml"));
    }*/


    @Before
    public void setUp() throws Exception {

        //DataSetManager.createPartialDataSet("select * from stca_doctype","stca_doctype","/state_dataset.xml");
        DataSetManager.loadDataSet("/state_dataset.xml",DataSetManager.REFRESH_OPERATION);

    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/state_dataset.xml",DataSetManager.DELETE_OPERATION);
    }

    public int countStates(){

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int states = 0;

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT COUNT(1) FROM stca_state");

        try {
            conn = DBUnitConnectionManager.getUserDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                states = rs.getInt(1);
                System.out.println("Hay "+states);
            }
        }catch(SQLException e){
            //log.error(e);
        }
        return states;

    }
}
