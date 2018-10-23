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

package com.liferay.sample.custom.query.service.impl;

import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.sample.custom.query.model.Custom;
import com.liferay.sample.custom.query.service.base.CustomServiceBaseImpl;

/**
 * The implementation of the custom remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.sample.custom.query.service.CustomService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomServiceBaseImpl
 * @see com.liferay.sample.custom.query.service.CustomServiceUtil
 */
public class CustomServiceImpl extends CustomServiceBaseImpl {

	public void createEntry(String name) {
		try {
			Custom entry = customPersistence.create(CounterLocalServiceUtil.increment(Custom.class.getName()));
			entry.setCustomName(name);
			customPersistence.update(entry);
		} catch (Exception e) {
		}
	}

	public List<String> getEntryNames() {
		List<String> customNames = null;
		try {
			String query = "select customName from sample_custom";
			customNames = customFinder.getCustomNames(query);
		} catch (Exception e) {
		}

		return customNames;
	}
}