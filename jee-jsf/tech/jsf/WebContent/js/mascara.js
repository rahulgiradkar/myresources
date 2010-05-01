//mascara generica em javascript  
function mascaraTexto(evento, mascara) {

	var campo, valor, i, tam, caracter;

	if (document.all) // Internet Explorer
		campo = evento.srcElement;
	else
		// Nestcape, Mozzila
		campo = evento.target;

	valor = campo.value;
	tam = valor.length;

	for (i = 0; i < mascara.length; i++) {
		caracter = mascara.charAt(i);
		if (caracter != "9")
			if (i < tam & caracter != valor.charAt(i))
				campo.value = valor.substring(0, i) + caracter
						+ valor.substring(i, tam);

	}

}


//Esta função valida o tamanho de caracteres digitados na text area.
function maxTextArea(txarea, n, Entrada, Saida)
{ 
	total = n; 
	tam = txarea.value.length; 
	str=""; 
	str=str+tam; 
	Entrada.innerHTML = str; 
	Saida.innerHTML = total - str;
	if (tam > total)
	{ 
		aux = txarea.value; 
		txarea.value = aux.substring(0,total);
		Entrada.innerHTML = total
		Saida.innerHTML = 0 
	} 
}