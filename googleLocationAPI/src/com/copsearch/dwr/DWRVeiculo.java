/**
 * 
 */
package com.copsearch.dwr;

import java.util.List;

import com.copsearch.business.VeiculoBusiness;

import flexjson.JSONSerializer;

/**
 * Comentário
 *
 * @author João Paulo (joao_fernandes@netel.trana.com.br)
 * 
 * @since 20/05/2009
 */
public class DWRVeiculo {

	private VeiculoBusiness veiculoBusiness;
	public String getPosition(Long idVeiculo)
	{
		List l = veiculoBusiness.teste();
		JSONSerializer serializer = new JSONSerializer();
		serializer.serialize(l);
		return "Ok";
	}
	
	public VeiculoBusiness getVeiculoBusiness() {
		return veiculoBusiness;
	}
	public void setVeiculoBusiness(VeiculoBusiness veiculoBusiness) {
		this.veiculoBusiness = veiculoBusiness;
	}	
	
}
