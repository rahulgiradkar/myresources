/**
 * 
 */
package com.copsearch.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Comentário
 *
 * @author João Paulo (joao_fernandes@netel.trana.com.br)
 * 
 * @since 20/05/2009
 */
public class HibernateGenericDao extends HibernateDaoSupport 
{
	public void save(Object o)
	{
		getHibernateTemplate().save(o);		
	}
	
	public void executeQuery(String queryName)
	{
		getHibernateTemplate().findByNamedQuery(queryName);		
	}
	
	public List executeQuery(String queryName, String[] parameterNames,
			Object[] parameterValues) {
		return getHibernateTemplate().findByNamedQueryAndNamedParam(queryName,
				parameterNames, parameterValues);
	}
}
