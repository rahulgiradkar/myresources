/**
 * 
 */
package com.copsearch.business;

import java.util.List;

/**
 * Coment�rio
 *
 * @author Jo�o Paulo (joao_fernandes@netel.trana.com.br)
 * 
 * @since 20/05/2009
 */
public class VeiculoBusiness extends GenericBusiness {
	public List teste(){
		getHibernateDao().executeQuery("");
		return null;
	}
}
