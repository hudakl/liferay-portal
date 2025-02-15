<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
List<CommerceTierPriceEntry> commerceTierPriceEntries = (List<CommerceTierPriceEntry>)request.getAttribute(CommercePriceListWebKeys.COMMERCE_TIER_PRICE_ENTRIES);

if (commerceTierPriceEntries == null) {
	commerceTierPriceEntries = Collections.emptyList();
}
%>

<c:choose>
	<c:when test="<%= commerceTierPriceEntries.size() == 1 %>">

		<%
		CommerceTierPriceEntry commerceTierPriceEntry = commerceTierPriceEntries.get(0);

		request.setAttribute("info_panel.jsp-entry", commerceTierPriceEntries);

		CommercePriceEntry commercePriceEntry = commerceTierPriceEntry.getCommercePriceEntry();

		CPInstance cpInstance = commercePriceEntry.getCPInstance();

		CPDefinition cpDefinition = cpInstance.getCPDefinition();
		%>

		<div class="sidebar-header">
			<clay:content-row
				cssClass="sidebar-section"
			>
				<clay:content-col
					expand="<%= true %>"
				>
					<h4 class="component-title"><%= HtmlUtil.escape(cpDefinition.getName(languageId)) %></h4>
				</clay:content-col>

				<clay:content-col>
					<ul class="autofit-padded-no-gutters autofit-row">
						<li class="autofit-col">
							<liferay-util:include page="/tier_price_entry_action.jsp" servletContext="<%= application %>" />
						</li>
					</ul>
				</clay:content-col>
			</clay:content-row>
		</div>

		<div class="sidebar-body">
			<dl class="sidebar-dl sidebar-section">
				<dt class="sidebar-dt"><liferay-ui:message key="id" /></dt>

				<dd class="sidebar-dd">
					<%= HtmlUtil.escape(String.valueOf(commerceTierPriceEntry.getCommerceTierPriceEntryId())) %>
				</dd>
				<dt class="sidebar-dt"><liferay-ui:message key="name" /></dt>

				<dd class="sidebar-dd">
					<%= HtmlUtil.escape(cpDefinition.getName(languageId)) %>
				</dd>
				<dt class="sidebar-dt"><liferay-ui:message key="sku" /></dt>

				<dd class="sidebar-dd">
					<%= HtmlUtil.escape(cpInstance.getSku()) %>
				</dd>
			</dl>
		</div>
	</c:when>
	<c:otherwise>
		<div class="sidebar-header">
			<clay:content-row
				cssClass="sidebar-section"
			>
				<clay:content-col
					expand="<%= true %>"
				>
					<h4 class="component-title"><liferay-ui:message arguments="<%= commerceTierPriceEntries.size() %>" key="x-items-are-selected" /></h4>
				</clay:content-col>
			</clay:content-row>
		</div>
	</c:otherwise>
</c:choose>