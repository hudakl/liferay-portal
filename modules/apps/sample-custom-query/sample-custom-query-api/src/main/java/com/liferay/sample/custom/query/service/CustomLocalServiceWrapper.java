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

package com.liferay.sample.custom.query.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CustomLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CustomLocalService
 * @generated
 */
@ProviderType
public class CustomLocalServiceWrapper implements CustomLocalService,
	ServiceWrapper<CustomLocalService> {
	public CustomLocalServiceWrapper(CustomLocalService customLocalService) {
		_customLocalService = customLocalService;
	}

	/**
	* Adds the custom to the database. Also notifies the appropriate model listeners.
	*
	* @param custom the custom
	* @return the custom that was added
	*/
	@Override
	public com.liferay.sample.custom.query.model.Custom addCustom(
		com.liferay.sample.custom.query.model.Custom custom) {
		return _customLocalService.addCustom(custom);
	}

	/**
	* Creates a new custom with the primary key. Does not add the custom to the database.
	*
	* @param customId the primary key for the new custom
	* @return the new custom
	*/
	@Override
	public com.liferay.sample.custom.query.model.Custom createCustom(
		long customId) {
		return _customLocalService.createCustom(customId);
	}

	/**
	* Deletes the custom from the database. Also notifies the appropriate model listeners.
	*
	* @param custom the custom
	* @return the custom that was removed
	*/
	@Override
	public com.liferay.sample.custom.query.model.Custom deleteCustom(
		com.liferay.sample.custom.query.model.Custom custom) {
		return _customLocalService.deleteCustom(custom);
	}

	/**
	* Deletes the custom with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param customId the primary key of the custom
	* @return the custom that was removed
	* @throws PortalException if a custom with the primary key could not be found
	*/
	@Override
	public com.liferay.sample.custom.query.model.Custom deleteCustom(
		long customId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _customLocalService.deleteCustom(customId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _customLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _customLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _customLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.custom.query.model.impl.CustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _customLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.custom.query.model.impl.CustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _customLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _customLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _customLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.sample.custom.query.model.Custom fetchCustom(
		long customId) {
		return _customLocalService.fetchCustom(customId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _customLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the custom with the primary key.
	*
	* @param customId the primary key of the custom
	* @return the custom
	* @throws PortalException if a custom with the primary key could not be found
	*/
	@Override
	public com.liferay.sample.custom.query.model.Custom getCustom(long customId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _customLocalService.getCustom(customId);
	}

	/**
	* Returns a range of all the customs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.sample.custom.query.model.impl.CustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of customs
	* @param end the upper bound of the range of customs (not inclusive)
	* @return the range of customs
	*/
	@Override
	public java.util.List<com.liferay.sample.custom.query.model.Custom> getCustoms(
		int start, int end) {
		return _customLocalService.getCustoms(start, end);
	}

	/**
	* Returns the number of customs.
	*
	* @return the number of customs
	*/
	@Override
	public int getCustomsCount() {
		return _customLocalService.getCustomsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _customLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _customLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _customLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the custom in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param custom the custom
	* @return the custom that was updated
	*/
	@Override
	public com.liferay.sample.custom.query.model.Custom updateCustom(
		com.liferay.sample.custom.query.model.Custom custom) {
		return _customLocalService.updateCustom(custom);
	}

	@Override
	public CustomLocalService getWrappedService() {
		return _customLocalService;
	}

	@Override
	public void setWrappedService(CustomLocalService customLocalService) {
		_customLocalService = customLocalService;
	}

	private CustomLocalService _customLocalService;
}