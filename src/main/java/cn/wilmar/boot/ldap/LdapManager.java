package cn.wilmar.boot.ldap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Component;

@Component
public class LdapManager {
	private final LdapTemplate template;

	@Autowired
	public LdapManager(LdapTemplate template) {
		this.template = template;
	}
	
//	private void test() {
//		this.template
//	}
}