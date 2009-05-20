/**
 * 
 */
package com.copsearch.business;

import br.com.enovar.trex.core.dao.IHibernateGenericDao;

/**
 * Comentário
 *
 * @author João Paulo (joao_fernandes@netel.trana.com.br)
 * 
 * @since 20/05/2009
 */
public class GenericBusiness {
	private IHibernateGenericDao hibernateDao;

	public IHibernateGenericDao getHibernateDao() {
		return hibernateDao;
	}

	public void setHibernateDao(IHibernateGenericDao hibernateDao) {
		this.hibernateDao = hibernateDao;
	}
	
	
}
