package iFactory.treinamento.hibernate.util;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;


public class SpringUtil {


	private static XmlBeanFactory factory;

	static {
		Resource resource = new ClassPathResource("test-config.xml");
		factory = new XmlBeanFactory(resource);

		resource = new FileSystemResource("WEB-INF/applicationContext.xml");
		factory = new XmlBeanFactory(resource, factory);

	}

	public static Object getBean(String bean)

	{
		return factory.getBean(bean);
	}





}
