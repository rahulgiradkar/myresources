package jm.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class CadastrarDynaActionForm extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		//Look dispacht action
		DynaActionForm da = (DynaActionForm) form;
		
		// Get the variables by get 
		String name = (String) da.get("name");
		String[] produto = (String[]) da.get("produto");
		
		return mapping.findForward("telaCadastro");
	}

	
	/*protected Map getKeyMethodMap() {
		Map map = new HashMap();
		map.put("button.salva", "salva");

		return map;
	}*/
}