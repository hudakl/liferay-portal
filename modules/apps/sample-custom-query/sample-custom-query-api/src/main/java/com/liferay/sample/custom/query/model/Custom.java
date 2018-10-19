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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Custom service. Represents a row in the &quot;SAMPLE_Custom&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CustomModel
 * @see com.liferay.sample.custom.query.model.impl.CustomImpl
 * @see com.liferay.sample.custom.query.model.impl.CustomModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.sample.custom.query.model.impl.CustomImpl")
@ProviderType
public interface Custom extends CustomModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.sample.custom.query.model.impl.CustomImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Custom, Long> CUSTOM_ID_ACCESSOR = new Accessor<Custom, Long>() {
			@Override
			public Long get(Custom custom) {
				return custom.getCustomId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Custom> getTypeClass() {
				return Custom.class;
			}
		};
}