package iFactory.treinamento.hibernate.dao;

import iFactory.treinamento.hibernate.domain.Category;
import iFactory.treinamento.hibernate.util.SpringUtil;

import java.util.List;

import javax.sql.DataSource;

import org.dbunit.Assertion;
import org.dbunit.DataSourceBasedDBTestCase;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.DatabaseUnitException;
import org.dbunit.IDatabaseTester;
import org.dbunit.database.DatabaseSequenceFilter;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.FilteredDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.filter.ITableFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;

public class CategoryDaoImplTestDbU extends DataSourceBasedDBTestCase {

    CategoryDao dao;

    IDataSet iDs;


    protected void setUp() throws Exception {
        try {
	    super.setUp();
	    dao = (CategoryDao) SpringUtil.getBean("categoryDao");
	} catch (RuntimeException e) {
	    e.printStackTrace();
	    throw e;
	}
    }

    public void testFindById() {
	try {
	    Category c = dao.findById(new Long(1));
	    assertNotNull(c);
	} catch (RuntimeException e) {
	    e.printStackTrace();
	    throw e;
	}
    }

    public void testFindAll() {
	List all = dao.findAll();
	assertNotNull(all);
	assertEquals("Expected 7 registers", 7, all.size());
    }

    public void testFindAllCached() {
	List all = dao.findAll();
	assertNotNull(all);
	assertEquals("Expected 7 registers", 7, all.size());

	List allCache = dao.findAll();
	assertNotNull(all);
	assertEquals("Expected equal result from querys", all.toString(), allCache.toString());
    }

    public void testInsert() throws Exception {
	Category c = new Category();
	c.setName("test insert2");
	dao.insert(c);


	ITable expectedTb = getITableFromXML("CategoryInsert.xml", "CATEGORIA");
	ITable actualTb = getITableFromDs("CATEGORIA");

	//colls to compare
	String[] colls = new String[] {"NOME"};

	assertITableEquals(expectedTb, actualTb, colls);
    }

    public void testDelete() throws Exception {
	Category c = dao.findById(new Long(1));
	dao.delete(c);

	ITable expectedTb = getITableFromXML("CategoryDelete.xml", "CATEGORIA");
	ITable actualTb = getITableFromDs("CATEGORIA");

	Assertion.assertEquals(expectedTb, actualTb);
    }

    public void testUpdate() throws Exception {
	Category c = dao.findById(new Long(1));
	c.setName("new name");
	dao.update(c);

	ITable expectedTb = getITableFromXML("CategoryUpdate.xml", "CATEGORIA");
	ITable actualTb = getITableFromDs("CATEGORIA");

	Assertion.assertEquals(expectedTb, actualTb);
    }

    protected DataSource getDataSource() {
	return (DataSource) SpringUtil.getBean("dataSource");
    }


    /* ###################### Utilities Methods ######################### */

    protected IDataSet getDataSet() throws Exception {
	if (iDs == null) {
	    iDs = new FlatXmlDataSet(this.getClass().getResource("CategoryStd.xml"));
	}
	return iDs;
    }

    protected ITable getITableFromXML(String xmlName, String tableName) {
	try {
	    return (new FlatXmlDataSet(
		    this.getClass().getResource(xmlName))).getTable(tableName);
	} catch (Exception e) {
	    throw new RuntimeException("Erro reading xml file", e);
	}
    }

    protected ITable getITableFromDs(String tableName) {
	IDataSet iDs = getDbIDataSet();
	try {
	    return iDs.getTable(tableName);
	} catch (Exception e) {
	    throw new RuntimeException("Erro reading table from xml file", e);
	}
    }

    protected IDataSet getDbIDataSet() {
	DataSource ds = (DataSource) SpringUtil.getBean("dataSource");
	IDatabaseTester iDbTester = new DataSourceDatabaseTester(ds);

	IDataSet iDs;
	try {
	    IDatabaseConnection iConn = iDbTester.getConnection();
	    ITableFilter filter = new DatabaseSequenceFilter(iConn);
	    iDs = new FilteredDataSet(filter,
	    	       iConn.createDataSet());
	} catch (Exception e) {
	    throw new RuntimeException("Erro reading database", e);
	}
	return iDs;
    }

    protected void assertITableEquals(ITable expectedTb, ITable actualTb, String[] colls) throws DataSetException, DatabaseUnitException {
	ITable actualFiltTb = DefaultColumnFilter.includedColumnsTable(
		actualTb, colls);

	ITable expecFiltTb = DefaultColumnFilter.includedColumnsTable(
		expectedTb, colls);


	Assertion.assertEquals(actualFiltTb, expecFiltTb);
    }

    @Override
    protected DatabaseOperation getSetUpOperation() throws Exception {
        // TODO Auto-generated method stub
        return super.getSetUpOperation();
    }
}
