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

package com.liferay.sample.custom.query.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.liferay.sample.custom.query.model.Custom;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Custom in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Custom
 * @generated
 */
@ProviderType
public class CustomCacheModel implements CacheModel<Custom>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CustomCacheModel)) {
			return false;
		}

		CustomCacheModel customCacheModel = (CustomCacheModel)obj;

		if (customId == customCacheModel.customId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, customId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{customId=");
		sb.append(customId);
		sb.append(", customName=");
		sb.append(customName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Custom toEntityModel() {
		CustomImpl customImpl = new CustomImpl();

		customImpl.setCustomId(customId);

		if (customName == null) {
			customImpl.setCustomName("");
		}
		else {
			customImpl.setCustomName(customName);
		}

		customImpl.resetOriginalValues();

		return customImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		customId = objectInput.readLong();
		customName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(customId);

		if (customName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customName);
		}
	}

	public long customId;
	public String customName;
}