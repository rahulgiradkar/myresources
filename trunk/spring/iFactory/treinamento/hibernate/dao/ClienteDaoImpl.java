package iFactory.treinamento.hibernate.dao;

import iFactory.treinamento.hibernate.domain.Category;
import iFactory.treinamento.hibernate.domain.Client;

import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.cache.EhCacheProvider;

import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate.HibernateCallback;
import org.springframework.orm.hibernate.support.HibernateDaoSupport;

public class ClienteDaoImpl extends HibernateDaoSupport implements CategoryDao
{

	private static final String FINDALL_CACHE_REG = "CategoryDao.findall";
	
	public Category findById(Long id)
	{
		return (Category) getHibernateTemplate().get(Category.class, id);
	}
	
	public Client findByIdQuery(Long id)
	{
		Client category = null;
		try {
			category = (Client) getSession().createQuery("from Client c where c.id = :id").setCacheable(true).setLong("id", id).uniqueResult();
		} catch (DataAccessResourceFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return category;
	}

	public List findAllCached()
	{
		return (List) getHibernateTemplate().execute(new HibernateCallback()
		{
			public Object doInHibernate(Session session)
					throws HibernateException
			{
				return session.createQuery("from Category").setCacheable(true)
						.setCacheRegion(FINDALL_CACHE_REG).list();
			}
		}, true);
	}

	public List findAll()
	{
		return getHibernateTemplate().find("from Category");
	}

	public void insert(Category c)
	{
		getHibernateTemplate().save(c);

	}

	public void delete(Category c)
	{
		getHibernateTemplate().delete(c);
	}

	public void update(Category c)
	{
		getHibernateTemplate().update(c);
	}

}
