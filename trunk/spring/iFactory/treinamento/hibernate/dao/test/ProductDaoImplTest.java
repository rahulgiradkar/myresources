package iFactory.treinamento.hibernate.dao.test;

import iFactory.treinamento.hibernate.dao.ProductDao;
import iFactory.treinamento.hibernate.dao.ProductDaoImpl;
import iFactory.treinamento.hibernate.util.SpringUtil;
import junit.framework.TestCase;

public class ProductDaoImplTest extends TestCase {

	private ProductDaoImpl dao;

	protected void setUp() throws Exception {
		dao = (ProductDaoImpl)SpringUtil.getBean("productDao");
	}

	/*public void testFindAll() {
		List product = o.findAll();
		assertNotNull(product);
	}
*/
	/*public void testFindAllCached() {
		List product = o.findAllCached();
		assertNotNull(product);
	}*/

	public void testBenchFindAll() {
		assertEquals(dao.findAll().size(), dao.findAllCached().size());
		System.out.println("Size = " + dao.findAll().size());

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
		System.out.println("Proporção é de " + (tempo1/tempo2));


	}
}
