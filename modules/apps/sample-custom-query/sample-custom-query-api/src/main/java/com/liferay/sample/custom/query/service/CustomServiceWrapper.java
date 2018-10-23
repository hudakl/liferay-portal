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
 * Provides a wrapper for {@link CustomService}.
 *
 * @author Brian Wing Shun Chan
 * @see CustomService
 * @generated
 */
@ProviderType
public class CustomServiceWrapper implements CustomService,
	ServiceWrapper<CustomService> {
	public CustomServiceWrapper(CustomService customService) {
		_customService = customService;
	}

	@Override
	public void createEntry(String name) {
		_customService.createEntry(name);
	}

	@Override
	public java.util.List<String> getEntryNames() {
		return _customService.getEntryNames();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _customService.getOSGiServiceIdentifier();
	}

	@Override
	public CustomService getWrappedService() {
		return _customService;
	}

	@Override
	public void setWrappedService(CustomService customService) {
		_customService = customService;
	}

	private CustomService _customService;
}