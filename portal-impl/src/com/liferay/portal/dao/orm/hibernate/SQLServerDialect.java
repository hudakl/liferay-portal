package com.liferay.portal.dao.orm.hibernate;

import java.sql.Types;

public class SQLServerDialect extends org.hibernate.dialect.SQLServerDialect {

	public SQLServerDialect() {
		registerHibernateType(Types.NVARCHAR, "string" );
	}
}