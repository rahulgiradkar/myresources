/**
 * 
 */
package com.copsearch.business;

import java.util.List;

/**
 * Comentário
 *
 * @author João Paulo (joao_fernandes@netel.trana.com.br)
 * 
 * @since 20/05/2009
 */
public class VeiculoBusiness extends GenericBusiness implements IVeiculoBusiness {
	
	public List teste(){
		getHibernateDao().executeQuery("com.copsearch.model.Veiculo.buscaAll");
		return null;
	}
}
