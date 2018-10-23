package com.liferay.sample.custom.query.service.persistence.impl;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.sample.custom.query.service.persistence.CustomFinder;

public class CustomFinderImpl extends CustomFinderBaseImpl 
	implements CustomFinder {

	public List<String> getCustomNames(String sqlQuery) {
		Session session = null;

		try {
			session = openSession();

			SQLQuery queryObject = session.createSQLQuery(sqlQuery);

			queryObject.setCacheable(true);

			List<String> result = queryObject.list();
			return result;
		} 
		catch (Exception e) {
			log.error(e.getMessage());
		} 
		finally {
			closeSession(session);
		}

		return null;
	}

	private static final Log log = LogFactoryUtil.getLog(CustomFinderImpl.class);
}
