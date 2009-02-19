<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<html>
  <head>
     <title>
       Cadastro de Usuários
     </title>
  </head>
<body>

<table>
<html:form action="/cadastrarusuario">
<tr>
<td colspan=2>
  <h2>Cadastro de usuários</h2>
</td>
</tr>

<!-- input nome -->
<tr><td><bean:message key="cadastrarUsuarioForm.nome"/></td>
<td><html:text property="nome"/></td></tr>

<!-- input email -->
<tr><td><bean:message key="cadastrarUsuarioForm.email"/></td>
<td><html:text property="email"/></td></tr>

<!-- input endereco -->
<tr><td><bean:message key="cadastrarUsuarioForm.endereco"/></td>
<td><html:text property="endereco"/></td></tr>

<!-- input telefone -->
<tr><td><bean:message key="cadastrarUsuarioForm.telefone"/></td>
<td><html:text property="telefone"/></td></tr>

<!-- input login -->
<tr><td><bean:message key="cadastrarUsuarioForm.login"/></td>
<td><html:text property="login"/></td></tr>

<!-- input senha -->
<tr><td><bean:message key="cadastrarUsuarioForm.senha"/></td>
<td><html:text property="senha"/></td></tr>

<tr><td colspan="2"><html:submit property="ok"/></td></tr>

<tr><td colspan="2">
<hr>
<logic:messagesPresent>
   <bean:message key="errors.header"/>
   <ul>
   <html:messages id="error">
      <li><bean:write name="error"/></li>
   </html:messages>
   </ul><hr>
</logic:messagesPresent>
</td></tr>

</html:form>

</table>

</body>
</html>
