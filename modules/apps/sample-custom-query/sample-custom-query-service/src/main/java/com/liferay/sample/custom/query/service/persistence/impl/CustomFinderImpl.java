package com.liferay.sample.custom.query.service.persistence.impl;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

public class CustomFinderImpl extends CustomFinderBaseImpl {

	public List<String> getCustomNames(String sqlQuery) {
		Session session = null;

		try {
			session = openSession();

			SQLQuery queryObject = session.createSQLQuery(sqlQuery);

			queryObject.setCacheable(true);

			QueryPos qPos = QueryPos.getInstance(queryObject);
	
			for (int i = 0; i < params.length; i++) {
				if (params[i] != null)
					qPos.add(params[i]);
			}

			List<String> result = queryObject.list();
			return result;
		} 
		catch (Exception e) {
			log.error(FormattingUtil.getMessage(e));
		} 
		finally {
			closeSession(session);
		}

		return null;
	}
}
