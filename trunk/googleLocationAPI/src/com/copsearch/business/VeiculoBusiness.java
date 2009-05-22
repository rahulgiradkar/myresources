/**
 * 
 */
package com.copsearch.business;

import java.util.List;

import com.copsearch.model.Localizacao;
import com.copsearch.model.Veiculo;

/**
 * Comentário
 *
 * @author João Paulo (joao_fernandes@netel.trana.com.br)
 * 
 * @since 20/05/2009
 */
public class VeiculoBusiness extends GenericBusiness implements IVeiculoBusiness {
	
	public List teste(){
		List veiculos = getHibernateDao().executeQuery("com.copsearch.model.Veiculo.buscaAll");
		Localizacao l = (Localizacao)((Veiculo)veiculos.get(0)).getLocalizacao();
		return 	veiculos;
	}
}
