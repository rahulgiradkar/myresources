package com.copsearch.business;

import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.struts.ContextLoaderPlugIn;

import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;

public class DWRBase {

	protected Object getBusinessClass(Class _class){
		return getBusinessClass(_class.getName());
	}
	
	protected Object getBusinessClass(String className){
		WebContext ctx = WebContextFactory.get();
		ServletContext sc = ctx.getServletContext();
		WebApplicationContext wac = (WebApplicationContext) sc
		.getAttribute(ContextLoaderPlugIn.SERVLET_CONTEXT_PREFIX);
		if (wac == null) {
		wac = WebApplicationContextUtils
		.getRequiredWebApplicationContext(sc);
		}

		Object managerObj = wac.getBean(className);
		return managerObj;
	}

}
