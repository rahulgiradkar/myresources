package com.enumeration;

public class EnumUtils 
{	
	public static final int CONSTANT = 5;  
	
	public static String stringToArray(){
		StringBuffer array = new StringBuffer();
		ConstrucaoEnum[] casaEnums = ConstrucaoEnum.values(); 
		
		// Inicializa a declaração do array javascript
		array.append("{");
		for(int i = 0; i < casaEnums.length; i++)
		{
			array.append( "'"+ casaEnums[i].name() + "'" + ":" + casaEnums[i].numero);
			if(i+1 != casaEnums.length){
				array.append(",");
			}
		}
		array.append("}");
		
		return array.toString();
	}	
	
}
