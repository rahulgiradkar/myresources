package com.enumeration;

public enum ConstrucaoEnum {
	CASA(10), APT(20), TERRENO(30);
	
	ConstrucaoEnum(int numero){
		this.numero = numero;
	}
	
	int numero;
} 
