package iFactory.treinamento.hibernate.dao.test;

import iFactory.treinamento.hibernate.util.SpringUtil;
import junit.framework.TestCase;

public class SpringUtilTest extends TestCase
{
	public void testGetBean()
	{
		for(int i = 0; i < 5; i++){
			TestTimer timer = new TestTimer("testGetCountries");
			Object o = SpringUtil.getBean("categoryDao");
			timer.done();
			assertNotNull(o);	
		}	
	}
}
