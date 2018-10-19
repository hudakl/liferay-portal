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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.liferay.sample.custom.query.exception.NoSuchCustomException;
import com.liferay.sample.custom.query.model.Custom;

/**
 * The persistence interface for the custom service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.sample.custom.query.service.persistence.impl.CustomPersistenceImpl
 * @see CustomUtil
 * @generated
 */
@ProviderType
public interface CustomPersistence extends BasePersistence<Custom> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CustomUtil} to access the custom persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the custom in the entity cache if it is enabled.
	*
	* @param custom the custom
	*/
	public void cacheResult(Custom custom);

	/**
	* Caches the customs in the entity cache if it is enabled.
	*
	* @param customs the customs
	*/
	public void cacheResult(java.util.List<Custom> customs);

	/**
	* Creates a new custom with the primary key. Does not add the custom to the database.
	*
	* @param customId the primary key for the new custom
	* @return the new custom
	*/
	public Custom create(long customId);

	/**
	* Removes the custom with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param customId the primary key of the custom
	* @return the custom that was removed
	* @throws NoSuchCustomException if a custom with the primary key could not be found
	*/
	public Custom remove(long customId) throws NoSuchCustomException;

	public Custom updateImpl(Custom custom);

	/**
	* Returns the custom with the primary key or throws a {@link NoSuchCustomException} if it could not be found.
	*
	* @param customId the primary key of the custom
	* @return the custom
	* @throws NoSuchCustomException if a custom with the primary key could not be found
	*/
	public Custom findByPrimaryKey(long customId) throws NoSuchCustomException;

	/**
	* Returns the custom with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param customId the primary key of the custom
	* @return the custom, or <code>null</code> if a custom with the primary key could not be found
	*/
	public Custom fetchByPrimaryKey(long customId);

	@Override
	public java.util.Map<java.io.Serializable, Custom> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the customs.
	*
	* @return the customs
	*/
	public java.util.List<Custom> findAll();

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
	public java.util.List<Custom> findAll(int start, int end);

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
	public java.util.List<Custom> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Custom> orderByComparator);

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
	public java.util.List<Custom> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Custom> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the customs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of customs.
	*
	* @return the number of customs
	*/
	public int countAll();
}