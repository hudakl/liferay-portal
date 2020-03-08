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

package com.liferay.data.engine.taglib.servlet.taglib;

import com.liferay.data.engine.taglib.internal.servlet.ServletContextUtil;
import com.liferay.data.engine.taglib.servlet.taglib.base.BaseDataLayoutBuilderTag;
import com.liferay.data.engine.taglib.servlet.taglib.util.DataLayoutTaglibUtil;
import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolvedPackageNameUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.ListUtil;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

/**
 * @author Jeyvison Nascimento
 * @author Leonardo Barros
 */
public class DataLayoutBuilderTag extends BaseDataLayoutBuilderTag {

	@Override
	public int doStartTag() throws JspException {
		int result = super.doStartTag();

		setNamespacedAttribute(
			request, "dataLayoutBuilderModule",
			DataLayoutTaglibUtil.resolveModule(
				"data-engine-taglib/data_layout_builder/js" +
					"/DataLayoutBuilder.es"));
		setNamespacedAttribute(
			request, "fieldTypes",
			DataLayoutTaglibUtil.getFieldTypesJSONArray(request, getScopes()));
		setNamespacedAttribute(
			request, "fieldTypesModules",
			DataLayoutTaglibUtil.resolveFieldTypesModules());

		String npmResolvedPackageName = NPMResolvedPackageNameUtil.get(
			ServletContextUtil.getServletContext());

		Map<String, Object> sidebarPanels = HashMapBuilder.<String, Object>put(
			"fields",
			HashMapBuilder.<String, Object>put(
				"icon", "grid"
			).put(
				"isLink", false
			).put(
				"label", "fields"
			).put(
				"pluginEntryPoint",
				npmResolvedPackageName + "/data_layout_builder/js/plugins" +
					"/fields-sidebar/index.es"
			).put(
				"sidebarPanelId", "fields"
			).build()
		).build();

		List<Map> additionalPanels = getAdditionalPanels();

		if (ListUtil.isNotEmpty(additionalPanels)) {
			for (Map<String, Object> additionalPanel : additionalPanels) {
				//panels.add(ListUtil.toList({additionalPanel.sidebarPanelId}));
				sidebarPanels.put(
					(String)additionalPanel.get("sidebarPanelId"),
					additionalPanel);
			}
		}

		setNamespacedAttribute(request, "sidebarPanels", sidebarPanels);

		return result;
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {
		super.setAttributes(httpServletRequest);

		Set<Locale> availableLocales = DataLayoutTaglibUtil.getAvailableLocales(
			getDataDefinitionId(), getDataLayoutId(), httpServletRequest);

		setNamespacedAttribute(
			httpServletRequest, "availableLanguageIds",
			_getLanguageIds(availableLocales));
		setNamespacedAttribute(
			httpServletRequest, "availableLocales",
			availableLocales.toArray(new Locale[0]));

		setNamespacedAttribute(
			httpServletRequest, "config",
			DataLayoutTaglibUtil.getDataLayoutConfigJSONObject(
				getContentType()));
		setNamespacedAttribute(
			httpServletRequest, "dataLayout",
			DataLayoutTaglibUtil.getDataLayoutJSONObject(
				availableLocales, getDataDefinitionId(), getDataLayoutId(),
				httpServletRequest,
				(HttpServletResponse)pageContext.getResponse()));
	}

	private String[] _getLanguageIds(Set<Locale> locales) {
		Stream<Locale> stream = locales.stream();

		return stream.map(
			LanguageUtil::getLanguageId
		).toArray(
			String[]::new
		);
	}

}