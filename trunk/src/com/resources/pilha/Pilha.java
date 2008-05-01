package com.resources.pilha;

import java.util.Stack;

public class Pilha
{
	public static Stack pilha = new Stack();
	
	public static void main(String[] args)
	{
		String item0 = new String("0");
		pilha.push(item0);
		
		// Coloca elemento na pilha
		String item1 = new String("1");
		pilha.push(item1);
		
		// Pode se colocar uma referencia mais de uma vez		
		pilha.push(item1);
		
		
		String item2 = new String("2");
		pilha.push(item2);
		System.out.println("Valores armazenados : "+ pilha);
		
		// Retira o topo da pilha
		if(!pilha.empty()){
			String item = (String)pilha.pop();
			System.out.println("Topo atual remivido: "+ item);
		}
		
		// Busca na pilha
		int indice = pilha.search(new String("0")); // Caso não exista retorna -1
		System.out.println("Indice do item0: "+indice);
		System.out.println(pilha);
		
		// Testando se a pilha é vazia evita exception
		if(!pilha.empty()){
			String item = (String)pilha.peek();
			System.out.println("Topo atual espiado: "+ item);
		}
	}
}
