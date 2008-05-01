package iFactory.treinamento.hibernate.dao;

import iFactory.treinamento.hibernate.domain.Product;

import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;

import org.springframework.orm.hibernate.HibernateCallback;
import org.springframework.orm.hibernate.support.HibernateDaoSupport;

public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao {

	private static final String FINDALL_CACHE_REG = "ProductDao.findall";

	public void delete(Product p) {
		getHibernateTemplate().delete(p);
	}

	public List findAll() {
		return getHibernateTemplate().find("from Product");
	}

	public List findAllCached() {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {
    		public Object doInHibernate(Session session) throws HibernateException {
    		    return session.createQuery("from Product")
    				.setCacheable(true).setCacheRegion(FINDALL_CACHE_REG).list();
    		}
	}, true);
	}

	public Product findById(Long id) {
		return (Product) getHibernateTemplate().get(Product.class, id);
	}

	public void insert(Product p) {
		getHibernateTemplate().save(p);
	}

	public void update(Product p) {
		getHibernateTemplate().update(p);
	}

}
