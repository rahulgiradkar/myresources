/**
 * 
 */
package com.copsearch.business;

import com.copsearch.hibernate.HibernateGenericDao;

/**
 * Comentário
 *
 * @author João Paulo (joao_fernandes@netel.trana.com.br)
 * 
 * @since 20/05/2009
 */
public class GenericBusiness {
	private HibernateGenericDao hibernateDao;

	public HibernateGenericDao getHibernateDao() {
		return hibernateDao;
	}

	public void setHibernateDao(HibernateGenericDao hibernateDao) {
		this.hibernateDao = hibernateDao;
	}
	
	
}
