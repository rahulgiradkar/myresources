/**
 * 
 */
package com.copsearch.dwr;

import java.util.List;

import com.copsearch.business.DWRBase;
import com.copsearch.business.VeiculoBusiness;

import flexjson.JSONSerializer;

/**
 * Comentário
 *
 * @author João Paulo (joao_fernandes@netel.trana.com.br)
 * 
 * @since 20/05/2009
 */
public class DWRVeiculo extends DWRBase {
	
	public String getPosition()
	{
		VeiculoBusiness veiculoBusiness = (VeiculoBusiness) getBusinessClass(VeiculoBusiness.class.getName());
		List l = veiculoBusiness.teste();
		JSONSerializer serializer = new JSONSerializer();		
		return serializer.serialize(l);
	}
	
	
}
