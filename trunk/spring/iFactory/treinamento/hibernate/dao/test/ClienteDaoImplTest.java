package iFactory.treinamento.hibernate.dao.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import iFactory.treinamento.hibernate.dao.CategoryDaoImpl;
import iFactory.treinamento.hibernate.dao.ClienteDaoImpl;
import iFactory.treinamento.hibernate.domain.Category;
import iFactory.treinamento.hibernate.domain.Client;
import iFactory.treinamento.hibernate.util.SpringUtil;
import junit.framework.TestCase;

public class ClienteDaoImplTest extends TestCase
{

	ClienteDaoImpl dao;

	@Override
	protected void setUp() throws Exception
	{
		try {
			super.setUp();
			dao = (ClienteDaoImpl) SpringUtil.getBean("clienteDao");
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/*public void testFindById()
	{
		try {
			Category c = dao.findById(new Long(1));
			System.out.println(c);
			assertNotNull(c);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}*/
	
	public void testFindByIdCache()
	{
		for(int i = 1; i < 23; i++){
			TestTimer timer = new TestTimer("testFindByIdCache");
			try {
				Client c = dao.findByIdQuery(new Long(i));			
			} catch (RuntimeException e) {
				e.printStackTrace();
				throw e;
			}
			timer.done();
		}		
	}

	/*public void testFindAll()
	{
		List all = dao.findAll();
		assertNotNull(all);
	}*/

	/*public void testBenchFindAll()
	{
		assertEquals(dao.findAll().size(), dao.findAllCached().size());

		long start = System.currentTimeMillis();
		for (int i = 0; i < 50; i++) {
			dao.findAll();
		}
		long end = System.currentTimeMillis();
		long tempo1 = end - start;
		System.out.println("Tempo sem cache = " + tempo1);

		start = System.currentTimeMillis();
		for (int i = 0; i < 50; i++) {
			dao.findAllCached();
		}
		end = System.currentTimeMillis();
		long tempo2 = end - start;
		System.out.println("Tempo com cache = " + tempo2);
		System.out.println("Proporção é de " + (tempo1 / tempo2));
	}*/

}
