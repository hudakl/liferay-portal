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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Custom}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Custom
 * @generated
 */
@ProviderType
public class CustomWrapper implements Custom, ModelWrapper<Custom> {
	public CustomWrapper(Custom custom) {
		_custom = custom;
	}

	@Override
	public Class<?> getModelClass() {
		return Custom.class;
	}

	@Override
	public String getModelClassName() {
		return Custom.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("customId", getCustomId());
		attributes.put("customName", getCustomName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long customId = (Long)attributes.get("customId");

		if (customId != null) {
			setCustomId(customId);
		}

		String customName = (String)attributes.get("customName");

		if (customName != null) {
			setCustomName(customName);
		}
	}

	@Override
	public Object clone() {
		return new CustomWrapper((Custom)_custom.clone());
	}

	@Override
	public int compareTo(Custom custom) {
		return _custom.compareTo(custom);
	}

	/**
	* Returns the custom ID of this custom.
	*
	* @return the custom ID of this custom
	*/
	@Override
	public long getCustomId() {
		return _custom.getCustomId();
	}

	/**
	* Returns the custom name of this custom.
	*
	* @return the custom name of this custom
	*/
	@Override
	public String getCustomName() {
		return _custom.getCustomName();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _custom.getExpandoBridge();
	}

	/**
	* Returns the primary key of this custom.
	*
	* @return the primary key of this custom
	*/
	@Override
	public long getPrimaryKey() {
		return _custom.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _custom.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _custom.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _custom.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _custom.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _custom.isNew();
	}

	@Override
	public void persist() {
		_custom.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_custom.setCachedModel(cachedModel);
	}

	/**
	* Sets the custom ID of this custom.
	*
	* @param customId the custom ID of this custom
	*/
	@Override
	public void setCustomId(long customId) {
		_custom.setCustomId(customId);
	}

	/**
	* Sets the custom name of this custom.
	*
	* @param customName the custom name of this custom
	*/
	@Override
	public void setCustomName(String customName) {
		_custom.setCustomName(customName);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_custom.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_custom.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_custom.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_custom.setNew(n);
	}

	/**
	* Sets the primary key of this custom.
	*
	* @param primaryKey the primary key of this custom
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_custom.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_custom.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Custom> toCacheModel() {
		return _custom.toCacheModel();
	}

	@Override
	public Custom toEscapedModel() {
		return new CustomWrapper(_custom.toEscapedModel());
	}

	@Override
	public String toString() {
		return _custom.toString();
	}

	@Override
	public Custom toUnescapedModel() {
		return new CustomWrapper(_custom.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _custom.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CustomWrapper)) {
			return false;
		}

		CustomWrapper customWrapper = (CustomWrapper)obj;

		if (Objects.equals(_custom, customWrapper._custom)) {
			return true;
		}

		return false;
	}

	@Override
	public Custom getWrappedModel() {
		return _custom;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _custom.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _custom.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_custom.resetOriginalValues();
	}

	private final Custom _custom;
}