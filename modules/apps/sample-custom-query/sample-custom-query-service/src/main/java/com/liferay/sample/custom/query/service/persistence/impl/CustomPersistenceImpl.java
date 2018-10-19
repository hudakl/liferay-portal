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

package com.liferay.sample.custom.query.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.liferay.sample.custom.query.exception.NoSuchCustomException;
import com.liferay.sample.custom.query.model.Custom;
import com.liferay.sample.custom.query.model.impl.CustomImpl;
import com.liferay.sample.custom.query.model.impl.CustomModelImpl;
import com.liferay.sample.custom.query.service.persistence.CustomPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the custom service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomPersistence
 * @see com.liferay.sample.custom.query.service.persistence.CustomUtil
 * @generated
 */
@ProviderType
public class CustomPersistenceImpl extends BasePersistenceImpl<Custom>
	implements CustomPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CustomUtil} to access the custom persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CustomImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CustomModelImpl.ENTITY_CACHE_ENABLED,
			CustomModelImpl.FINDER_CACHE_ENABLED, CustomImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CustomModelImpl.ENTITY_CACHE_ENABLED,
			CustomModelImpl.FINDER_CACHE_ENABLED, CustomImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CustomModelImpl.ENTITY_CACHE_ENABLED,
			CustomModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CustomPersistenceImpl() {
		setModelClass(Custom.class);
	}

	/**
	 * Caches the custom in the entity cache if it is enabled.
	 *
	 * @param custom the custom
	 */
	@Override
	public void cacheResult(Custom custom) {
		entityCache.putResult(CustomModelImpl.ENTITY_CACHE_ENABLED,
			CustomImpl.class, custom.getPrimaryKey(), custom);

		custom.resetOriginalValues();
	}

	/**
	 * Caches the customs in the entity cache if it is enabled.
	 *
	 * @param customs the customs
	 */
	@Override
	public void cacheResult(List<Custom> customs) {
		for (Custom custom : customs) {
			if (entityCache.getResult(CustomModelImpl.ENTITY_CACHE_ENABLED,
						CustomImpl.class, custom.getPrimaryKey()) == null) {
				cacheResult(custom);
			}
			else {
				custom.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all customs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CustomImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the custom.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Custom custom) {
		entityCache.removeResult(CustomModelImpl.ENTITY_CACHE_ENABLED,
			CustomImpl.class, custom.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Custom> customs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Custom custom : customs) {
			entityCache.removeResult(CustomModelImpl.ENTITY_CACHE_ENABLED,
				CustomImpl.class, custom.getPrimaryKey());
		}
	}

	/**
	 * Creates a new custom with the primary key. Does not add the custom to the database.
	 *
	 * @param customId the primary key for the new custom
	 * @return the new custom
	 */
	@Override
	public Custom create(long customId) {
		Custom custom = new CustomImpl();

		custom.setNew(true);
		custom.setPrimaryKey(customId);

		return custom;
	}

	/**
	 * Removes the custom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customId the primary key of the custom
	 * @return the custom that was removed
	 * @throws NoSuchCustomException if a custom with the primary key could not be found
	 */
	@Override
	public Custom remove(long customId) throws NoSuchCustomException {
		return remove((Serializable)customId);
	}

	/**
	 * Removes the custom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the custom
	 * @return the custom that was removed
	 * @throws NoSuchCustomException if a custom with the primary key could not be found
	 */
	@Override
	public Custom remove(Serializable primaryKey) throws NoSuchCustomException {
		Session session = null;

		try {
			session = openSession();

			Custom custom = (Custom)session.get(CustomImpl.class, primaryKey);

			if (custom == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustomException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(custom);
		}
		catch (NoSuchCustomException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Custom removeImpl(Custom custom) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(custom)) {
				custom = (Custom)session.get(CustomImpl.class,
						custom.getPrimaryKeyObj());
			}

			if (custom != null) {
				session.delete(custom);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (custom != null) {
			clearCache(custom);
		}

		return custom;
	}

	@Override
	public Custom updateImpl(Custom custom) {
		boolean isNew = custom.isNew();

		Session session = null;

		try {
			session = openSession();

			if (custom.isNew()) {
				session.save(custom);

				custom.setNew(false);
			}
			else {
				custom = (Custom)session.merge(custom);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(CustomModelImpl.ENTITY_CACHE_ENABLED,
			CustomImpl.class, custom.getPrimaryKey(), custom, false);

		custom.resetOriginalValues();

		return custom;
	}

	/**
	 * Returns the custom with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom
	 * @return the custom
	 * @throws NoSuchCustomException if a custom with the primary key could not be found
	 */
	@Override
	public Custom findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustomException {
		Custom custom = fetchByPrimaryKey(primaryKey);

		if (custom == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustomException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return custom;
	}

	/**
	 * Returns the custom with the primary key or throws a {@link NoSuchCustomException} if it could not be found.
	 *
	 * @param customId the primary key of the custom
	 * @return the custom
	 * @throws NoSuchCustomException if a custom with the primary key could not be found
	 */
	@Override
	public Custom findByPrimaryKey(long customId) throws NoSuchCustomException {
		return findByPrimaryKey((Serializable)customId);
	}

	/**
	 * Returns the custom with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the custom
	 * @return the custom, or <code>null</code> if a custom with the primary key could not be found
	 */
	@Override
	public Custom fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CustomModelImpl.ENTITY_CACHE_ENABLED,
				CustomImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Custom custom = (Custom)serializable;

		if (custom == null) {
			Session session = null;

			try {
				session = openSession();

				custom = (Custom)session.get(CustomImpl.class, primaryKey);

				if (custom != null) {
					cacheResult(custom);
				}
				else {
					entityCache.putResult(CustomModelImpl.ENTITY_CACHE_ENABLED,
						CustomImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CustomModelImpl.ENTITY_CACHE_ENABLED,
					CustomImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return custom;
	}

	/**
	 * Returns the custom with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param customId the primary key of the custom
	 * @return the custom, or <code>null</code> if a custom with the primary key could not be found
	 */
	@Override
	public Custom fetchByPrimaryKey(long customId) {
		return fetchByPrimaryKey((Serializable)customId);
	}

	@Override
	public Map<Serializable, Custom> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Custom> map = new HashMap<Serializable, Custom>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Custom custom = fetchByPrimaryKey(primaryKey);

			if (custom != null) {
				map.put(primaryKey, custom);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CustomModelImpl.ENTITY_CACHE_ENABLED,
					CustomImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Custom)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CUSTOM_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Custom custom : (List<Custom>)q.list()) {
				map.put(custom.getPrimaryKeyObj(), custom);

				cacheResult(custom);

				uncachedPrimaryKeys.remove(custom.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CustomModelImpl.ENTITY_CACHE_ENABLED,
					CustomImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the customs.
	 *
	 * @return the customs
	 */
	@Override
	public List<Custom> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Custom> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Custom> findAll(int start, int end,
		OrderByComparator<Custom> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Custom> findAll(int start, int end,
		OrderByComparator<Custom> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Custom> list = null;

		if (retrieveFromCache) {
			list = (List<Custom>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CUSTOM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOM;

				if (pagination) {
					sql = sql.concat(CustomModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Custom>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Custom>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the customs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Custom custom : findAll()) {
			remove(custom);
		}
	}

	/**
	 * Returns the number of customs.
	 *
	 * @return the number of customs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CUSTOM);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CustomModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the custom persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CustomImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CUSTOM = "SELECT custom FROM Custom custom";
	private static final String _SQL_SELECT_CUSTOM_WHERE_PKS_IN = "SELECT custom FROM Custom custom WHERE customId IN (";
	private static final String _SQL_COUNT_CUSTOM = "SELECT COUNT(custom) FROM Custom custom";
	private static final String _ORDER_BY_ENTITY_ALIAS = "custom.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Custom exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(CustomPersistenceImpl.class);
}