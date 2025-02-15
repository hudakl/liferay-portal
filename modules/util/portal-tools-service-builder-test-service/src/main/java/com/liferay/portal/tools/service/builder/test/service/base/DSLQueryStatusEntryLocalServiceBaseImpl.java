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

package com.liferay.portal.tools.service.builder.test.service.base;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.liferay.portal.tools.service.builder.test.model.DSLQueryStatusEntry;
import com.liferay.portal.tools.service.builder.test.service.DSLQueryStatusEntryLocalService;
import com.liferay.portal.tools.service.builder.test.service.persistence.DSLQueryStatusEntryPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the dsl query status entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portal.tools.service.builder.test.service.impl.DSLQueryStatusEntryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portal.tools.service.builder.test.service.impl.DSLQueryStatusEntryLocalServiceImpl
 * @generated
 */
public abstract class DSLQueryStatusEntryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements DSLQueryStatusEntryLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>DSLQueryStatusEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.portal.tools.service.builder.test.service.DSLQueryStatusEntryLocalServiceUtil</code>.
	 */

	/**
	 * Adds the dsl query status entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DSLQueryStatusEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dslQueryStatusEntry the dsl query status entry
	 * @return the dsl query status entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DSLQueryStatusEntry addDSLQueryStatusEntry(
		DSLQueryStatusEntry dslQueryStatusEntry) {

		dslQueryStatusEntry.setNew(true);

		return dslQueryStatusEntryPersistence.update(dslQueryStatusEntry);
	}

	/**
	 * Creates a new dsl query status entry with the primary key. Does not add the dsl query status entry to the database.
	 *
	 * @param dslQueryStatusEntryId the primary key for the new dsl query status entry
	 * @return the new dsl query status entry
	 */
	@Override
	@Transactional(enabled = false)
	public DSLQueryStatusEntry createDSLQueryStatusEntry(
		long dslQueryStatusEntryId) {

		return dslQueryStatusEntryPersistence.create(dslQueryStatusEntryId);
	}

	/**
	 * Deletes the dsl query status entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DSLQueryStatusEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dslQueryStatusEntryId the primary key of the dsl query status entry
	 * @return the dsl query status entry that was removed
	 * @throws PortalException if a dsl query status entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DSLQueryStatusEntry deleteDSLQueryStatusEntry(
			long dslQueryStatusEntryId)
		throws PortalException {

		return dslQueryStatusEntryPersistence.remove(dslQueryStatusEntryId);
	}

	/**
	 * Deletes the dsl query status entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DSLQueryStatusEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dslQueryStatusEntry the dsl query status entry
	 * @return the dsl query status entry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DSLQueryStatusEntry deleteDSLQueryStatusEntry(
		DSLQueryStatusEntry dslQueryStatusEntry) {

		return dslQueryStatusEntryPersistence.remove(dslQueryStatusEntry);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return dslQueryStatusEntryPersistence.dslQuery(dslQuery);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			DSLQueryStatusEntry.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return dslQueryStatusEntryPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.portal.tools.service.builder.test.model.impl.DSLQueryStatusEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return dslQueryStatusEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.portal.tools.service.builder.test.model.impl.DSLQueryStatusEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return dslQueryStatusEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return dslQueryStatusEntryPersistence.countWithDynamicQuery(
			dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return dslQueryStatusEntryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public DSLQueryStatusEntry fetchDSLQueryStatusEntry(
		long dslQueryStatusEntryId) {

		return dslQueryStatusEntryPersistence.fetchByPrimaryKey(
			dslQueryStatusEntryId);
	}

	/**
	 * Returns the dsl query status entry with the primary key.
	 *
	 * @param dslQueryStatusEntryId the primary key of the dsl query status entry
	 * @return the dsl query status entry
	 * @throws PortalException if a dsl query status entry with the primary key could not be found
	 */
	@Override
	public DSLQueryStatusEntry getDSLQueryStatusEntry(
			long dslQueryStatusEntryId)
		throws PortalException {

		return dslQueryStatusEntryPersistence.findByPrimaryKey(
			dslQueryStatusEntryId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			dslQueryStatusEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DSLQueryStatusEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"dslQueryStatusEntryId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			dslQueryStatusEntryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			DSLQueryStatusEntry.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"dslQueryStatusEntryId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			dslQueryStatusEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DSLQueryStatusEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"dslQueryStatusEntryId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return dslQueryStatusEntryPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return dslQueryStatusEntryLocalService.deleteDSLQueryStatusEntry(
			(DSLQueryStatusEntry)persistedModel);
	}

	@Override
	public BasePersistence<DSLQueryStatusEntry> getBasePersistence() {
		return dslQueryStatusEntryPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return dslQueryStatusEntryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the dsl query status entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.portal.tools.service.builder.test.model.impl.DSLQueryStatusEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dsl query status entries
	 * @param end the upper bound of the range of dsl query status entries (not inclusive)
	 * @return the range of dsl query status entries
	 */
	@Override
	public List<DSLQueryStatusEntry> getDSLQueryStatusEntries(
		int start, int end) {

		return dslQueryStatusEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of dsl query status entries.
	 *
	 * @return the number of dsl query status entries
	 */
	@Override
	public int getDSLQueryStatusEntriesCount() {
		return dslQueryStatusEntryPersistence.countAll();
	}

	/**
	 * Updates the dsl query status entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DSLQueryStatusEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dslQueryStatusEntry the dsl query status entry
	 * @return the dsl query status entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DSLQueryStatusEntry updateDSLQueryStatusEntry(
		DSLQueryStatusEntry dslQueryStatusEntry) {

		return dslQueryStatusEntryPersistence.update(dslQueryStatusEntry);
	}

	/**
	 * Returns the dsl query status entry local service.
	 *
	 * @return the dsl query status entry local service
	 */
	public DSLQueryStatusEntryLocalService
		getDSLQueryStatusEntryLocalService() {

		return dslQueryStatusEntryLocalService;
	}

	/**
	 * Sets the dsl query status entry local service.
	 *
	 * @param dslQueryStatusEntryLocalService the dsl query status entry local service
	 */
	public void setDSLQueryStatusEntryLocalService(
		DSLQueryStatusEntryLocalService dslQueryStatusEntryLocalService) {

		this.dslQueryStatusEntryLocalService = dslQueryStatusEntryLocalService;
	}

	/**
	 * Returns the dsl query status entry persistence.
	 *
	 * @return the dsl query status entry persistence
	 */
	public DSLQueryStatusEntryPersistence getDSLQueryStatusEntryPersistence() {
		return dslQueryStatusEntryPersistence;
	}

	/**
	 * Sets the dsl query status entry persistence.
	 *
	 * @param dslQueryStatusEntryPersistence the dsl query status entry persistence
	 */
	public void setDSLQueryStatusEntryPersistence(
		DSLQueryStatusEntryPersistence dslQueryStatusEntryPersistence) {

		this.dslQueryStatusEntryPersistence = dslQueryStatusEntryPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register(
			"com.liferay.portal.tools.service.builder.test.model.DSLQueryStatusEntry",
			dslQueryStatusEntryLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.portal.tools.service.builder.test.model.DSLQueryStatusEntry");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DSLQueryStatusEntryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return DSLQueryStatusEntry.class;
	}

	protected String getModelClassName() {
		return DSLQueryStatusEntry.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				dslQueryStatusEntryPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@BeanReference(type = DSLQueryStatusEntryLocalService.class)
	protected DSLQueryStatusEntryLocalService dslQueryStatusEntryLocalService;

	@BeanReference(type = DSLQueryStatusEntryPersistence.class)
	protected DSLQueryStatusEntryPersistence dslQueryStatusEntryPersistence;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry
		persistedModelLocalServiceRegistry;

}