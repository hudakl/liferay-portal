/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.sample.custom.query.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.liferay.sample.custom.query.model.Custom;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the custom service. This utility wraps {@link com.liferay.sample.custom.query.service.persistence.impl.CustomPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomPersistence
 * @see com.liferay.sample.custom.query.service.persistence.impl.CustomPersistenceImpl
 * @generated
 */
@ProviderType
public class CustomUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Custom custom) {
		getPersistence().clearCache(custom);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Custom> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Custom> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Custom> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Custom> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Custom update(Custom custom) {
		return getPersistence().update(custom);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Custom update(Custom custom, ServiceContext serviceContext) {
		return getPersistence().update(custom, serviceContext);
	}

	/**
	* Caches the custom in the entity cache if it is enabled.
	*
	* @param custom the custom
	*/
	public static void cacheResult(Custom custom) {
		getPersistence().cacheResult(custom);
	}

	/**
	* Caches the customs in the entity cache if it is enabled.
	*
	* @param customs the customs
	*/
	public static void cacheResult(List<Custom> customs) {
		getPersistence().cacheResult(customs);
	}

	/**
	* Creates a new custom with the primary key. Does not add the custom to the database.
	*
	* @param customId the primary key for the new custom
	* @return the new custom
	*/
	public static Custom create(long customId) {
		return getPersistence().create(customId);
	}

	/**
	* Removes the custom with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param customId the primary key of the custom
	* @return the custom that was removed
	* @throws NoSuchCustomException if a custom with the primary key could not be found
	*/
	public static Custom remove(long customId)
		throws com.liferay.sample.custom.query.exception.NoSuchCustomException {
		return getPersistence().remove(customId);
	}

	public static Custom updateImpl(Custom custom) {
		return getPersistence().updateImpl(custom);
	}

	/**
	* Returns the custom with the primary key or throws a {@link NoSuchCustomException} if it could not be found.
	*
	* @param customId the primary key of the custom
	* @return the custom
	* @throws NoSuchCustomException if a custom with the primary key could not be found
	*/
	public static Custom findByPrimaryKey(long customId)
		throws com.liferay.sample.custom.query.exception.NoSuchCustomException {
		return getPersistence().findByPrimaryKey(customId);
	}

	/**
	* Returns the custom with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param customId the primary key of the custom
	* @return the custom, or <code>null</code> if a custom with the primary key could not be found
	*/
	public static Custom fetchByPrimaryKey(long customId) {
		return getPersistence().fetchByPrimaryKey(customId);
	}

	public static java.util.Map<java.io.Serializable, Custom> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the customs.
	*
	* @return the customs
	*/
	public static List<Custom> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the customs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of customs
	* @param end the upper bound of the range of customs (not inclusive)
	* @return the range of customs
	*/
	public static List<Custom> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the customs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of customs
	* @param end the upper bound of the range of customs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of customs
	*/
	public static List<Custom> findAll(int start, int end,
		OrderByComparator<Custom> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the customs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of customs
	* @param end the upper bound of the range of customs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of customs
	*/
	public static List<Custom> findAll(int start, int end,
		OrderByComparator<Custom> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the customs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of customs.
	*
	* @return the number of customs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CustomPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CustomPersistence, CustomPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CustomPersistence.class);

		ServiceTracker<CustomPersistence, CustomPersistence> serviceTracker = new ServiceTracker<CustomPersistence, CustomPersistence>(bundle.getBundleContext(),
				CustomPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}