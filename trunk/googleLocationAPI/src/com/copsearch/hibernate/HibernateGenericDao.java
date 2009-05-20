/**
 * 
 */
package com.copsearch.hibernate;

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
}
