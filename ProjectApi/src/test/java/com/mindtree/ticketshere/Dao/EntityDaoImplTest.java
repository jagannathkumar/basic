package com.mindtree.ticketshere.Dao;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;





		
@ContextConfiguration(classes= {HibernateConfigTest.class})
public abstract class EntityDaoImplTest extends AbstractTransactionalTestNGSpringContextTests {
	
	@Autowired
	DataSource dataSource;
	
	@BeforeMethod
	public void set() throws Exception{
		IDatabaseConnection conn=new DatabaseDataSourceConnection(dataSource);
		DatabaseOperation.CLEAN_INSERT.execute(conn, getDataSet());
	}
	
	protected abstract IDataSet getDataSet() throws Exception;
}
	




