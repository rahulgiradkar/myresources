<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>

<html>
<head>
<title>Cadastro de DynaAction form</title>
</head>
<body>

<table>
	<html:form action="/cadastrarDynaActionForm" method="post">		
		<tr>
			<td colspan=2>
			<h2>Cadastro de usuários</h2>
			</td>
		</tr>

		<!-- input nome -->
		<tr>
			<td><bean:message key="cadastrarUsuarioForm.nome" /></td>
			<td><html:text property="name" /></td>
		</tr>
		
		<tr>
			<td><bean:message key="cadastrarUsuarioForm.nome" /></td> 
		    <td><html:hidden indexed="true" name="produto" property="id" value="228"/></td>
		</tr>
		<tr>
			<td><bean:message key="cadastrarUsuarioForm.nome" /></td>
			<td><html:hidden indexed="true" name="produto" property="id" value="22"/></td>
		</tr>
		

		<tr>
			<td colspan="2">
			<html:submit property="metodo">
				<bean:message key="button.salva" />
			</html:submit>
			
			<html:submit property="ok"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<hr>
			<logic:messagesPresent>
				<bean:message key="errors.header" />
				<ul>
					<html:messages id="error">
						<li><bean:write name="error" /></li>
					</html:messages>
				</ul>
				<hr>
			</logic:messagesPresent></td>
		</tr>

	</html:form>
</table>

</body>
</html>
