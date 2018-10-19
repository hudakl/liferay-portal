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

package com.liferay.sample.custom.query.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.sample.custom.query.service.http.CustomServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.sample.custom.query.service.http.CustomServiceSoap
 * @generated
 */
@ProviderType
public class CustomSoap implements Serializable {
	public static CustomSoap toSoapModel(Custom model) {
		CustomSoap soapModel = new CustomSoap();

		soapModel.setCustomId(model.getCustomId());
		soapModel.setCustomName(model.getCustomName());

		return soapModel;
	}

	public static CustomSoap[] toSoapModels(Custom[] models) {
		CustomSoap[] soapModels = new CustomSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CustomSoap[][] toSoapModels(Custom[][] models) {
		CustomSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CustomSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CustomSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CustomSoap[] toSoapModels(List<Custom> models) {
		List<CustomSoap> soapModels = new ArrayList<CustomSoap>(models.size());

		for (Custom model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CustomSoap[soapModels.size()]);
	}

	public CustomSoap() {
	}

	public long getPrimaryKey() {
		return _customId;
	}

	public void setPrimaryKey(long pk) {
		setCustomId(pk);
	}

	public long getCustomId() {
		return _customId;
	}

	public void setCustomId(long customId) {
		_customId = customId;
	}

	public String getCustomName() {
		return _customName;
	}

	public void setCustomName(String customName) {
		_customName = customName;
	}

	private long _customId;
	private String _customName;
}