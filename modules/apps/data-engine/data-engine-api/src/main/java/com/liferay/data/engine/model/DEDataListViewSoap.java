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

package com.liferay.data.engine.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class DEDataListViewSoap implements Serializable {

	public static DEDataListViewSoap toSoapModel(DEDataListView model) {
		DEDataListViewSoap soapModel = new DEDataListViewSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setDeDataListViewId(model.getDeDataListViewId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAppliedFilters(model.getAppliedFilters());
		soapModel.setDdmStructureId(model.getDdmStructureId());
		soapModel.setFieldNames(model.getFieldNames());
		soapModel.setName(model.getName());
		soapModel.setSortField(model.getSortField());

		return soapModel;
	}

	public static DEDataListViewSoap[] toSoapModels(DEDataListView[] models) {
		DEDataListViewSoap[] soapModels = new DEDataListViewSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DEDataListViewSoap[][] toSoapModels(
		DEDataListView[][] models) {

		DEDataListViewSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DEDataListViewSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DEDataListViewSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DEDataListViewSoap[] toSoapModels(
		List<DEDataListView> models) {

		List<DEDataListViewSoap> soapModels = new ArrayList<DEDataListViewSoap>(
			models.size());

		for (DEDataListView model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DEDataListViewSoap[soapModels.size()]);
	}

	public DEDataListViewSoap() {
	}

	public long getPrimaryKey() {
		return _deDataListViewId;
	}

	public void setPrimaryKey(long pk) {
		setDeDataListViewId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getDeDataListViewId() {
		return _deDataListViewId;
	}

	public void setDeDataListViewId(long deDataListViewId) {
		_deDataListViewId = deDataListViewId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getAppliedFilters() {
		return _appliedFilters;
	}

	public void setAppliedFilters(String appliedFilters) {
		_appliedFilters = appliedFilters;
	}

	public long getDdmStructureId() {
		return _ddmStructureId;
	}

	public void setDdmStructureId(long ddmStructureId) {
		_ddmStructureId = ddmStructureId;
	}

	public String getFieldNames() {
		return _fieldNames;
	}

	public void setFieldNames(String fieldNames) {
		_fieldNames = fieldNames;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getSortField() {
		return _sortField;
	}

	public void setSortField(String sortField) {
		_sortField = sortField;
	}

	private String _uuid;
	private long _deDataListViewId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _appliedFilters;
	private long _ddmStructureId;
	private String _fieldNames;
	private String _name;
	private String _sortField;

}