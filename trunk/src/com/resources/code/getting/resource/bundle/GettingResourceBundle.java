package com.resources.code.getting.resource.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class GettingResourceBundle
{
	/* If the specifield locale bundle doesnt exit it returns */ 
	/* a default											  */
	public static void main(String[] args)
	{		
		Locale locale_fr = new Locale("fr","FR","");
		ResourceBundle bundle = ResourceBundle.getBundle("myBundle", locale_fr);
		
		System.out.println( bundle.getString("firstEntry") );		
	}
}
