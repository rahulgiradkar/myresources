package iFactory.treinamento.hibernate.dao.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import iFactory.treinamento.hibernate.dao.CategoryDaoImpl;
import iFactory.treinamento.hibernate.domain.Category;
import iFactory.treinamento.hibernate.util.SpringUtil;
import junit.framework.TestCase;

public class CategoryDaoImplTest extends TestCase
{

	CategoryDaoImpl dao;

	@Override
	protected void setUp() throws Exception
	{
		try {
			super.setUp();
			dao = (CategoryDaoImpl) SpringUtil.getBean("categoryDao");
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
		for(int i = 0; i < 10; i++){
			TestTimer timer = new TestTimer("testFindByIdCache");
			try {
				Category c = dao.findByIdQuery(new Long(1));				
				assertNotNull(c);
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
