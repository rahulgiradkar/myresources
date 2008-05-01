package iFactory.treinamento.hibernate.util;

import java.util.Collection;

public interface AuthUtil {
	String getPrincipalName();
	boolean isInRole(String role);
	Collection getRoles();
}
