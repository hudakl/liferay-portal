package com.liferay.sample.custom.query.service.persistence.impl;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.liferay.sample.custom.query.service.persistence.CustomFinder;

public class CustomFinderImpl extends CustomFinderBaseImpl 
	implements CustomFinder {

	public List<String> getCustomNames(String sqlQuery) {
		Session session = null;

		try {
			session = openSession();

			String sql = _customSQL.get(getClass(), GET_CUSTOM_NAME);

			SQLQuery queryObject = session.createSQLQuery(sql);

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

	public static final String GET_CUSTOM_NAME =
		CustomFinder.class.getName() + ".getCustomNames";

	@ServiceReference(type=CustomSQL.class)
	private CustomSQL _customSQL;

	private static final Log log = LogFactoryUtil.getLog(CustomFinderImpl.class);
}
