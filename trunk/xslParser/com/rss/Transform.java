package com.rss;

import java.io.File;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Transform {

	public void psrserXml(String xmlFileName, String xslFileName)
			throws TransformerConfigurationException, TransformerException
	{
		File xmlFile = new File(xmlFileName);
		File xsltFile = new File(xslFileName);

		Source xmlSource = new StreamSource(xmlFile);
		Source xsltSource = new StreamSource(xsltFile);
		
		TransformerFactory transFact = TransformerFactory.newInstance();
				
		Transformer trans = transFact.newTransformer(xsltSource);
		
		// Joga a saida em formato html passado pelo xslt
		trans.transform(xmlSource, new StreamResult(System.out));
	}

	public static void main(String[] args) 
	{
		Transform transfXsl = new Transform();
		try
		{
			transfXsl.psrserXml( "schedule.xml", "schedule.xslt" );
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}
}
