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

package com.liferay.bookmarks.internal.social;

import com.liferay.bookmarks.constants.BookmarksPortletKeys;
import com.liferay.bookmarks.model.BookmarksEntry;
import com.liferay.bookmarks.social.BookmarksActivityKeys;
import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoader;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.social.kernel.model.BaseSocialActivityInterpreter;
import com.liferay.social.kernel.model.SocialActivity;
import com.liferay.social.kernel.model.SocialActivityConstants;
import com.liferay.social.kernel.model.SocialActivityInterpreter;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Juan Fernández
 * @author Zsolt Berentey
 */
@Component(
	property = {
		"javax.portlet.name=" + BookmarksPortletKeys.BOOKMARKS,
		"model.class.name=com.liferay.bookmarks.model.BookmarksEntry"
	},
	service = SocialActivityInterpreter.class
)
public class BookmarksEntryActivityInterpreter
	extends BaseSocialActivityInterpreter {

	@Override
	public String[] getClassNames() {
		return _CLASS_NAMES;
	}

	@Override
	protected ResourceBundleLoader acquireResourceBundleLoader() {
		return _resourceBundleLoader;
	}

	@Override
	protected String getPath(
		SocialActivity activity, ServiceContext serviceContext) {

		return "/bookmarks/find_entry?entryId=" + activity.getClassPK();
	}

	@Override
	protected String getTitlePattern(
		String groupName, SocialActivity activity) {

		int activityType = activity.getType();

		if (activityType == BookmarksActivityKeys.ADD_ENTRY) {
			if (Validator.isNull(groupName)) {
				return "activity-bookmarks-entry-add-entry";
			}

			return "activity-bookmarks-entry-add-entry-in";
		}
		else if (activityType == BookmarksActivityKeys.UPDATE_ENTRY) {
			if (Validator.isNull(groupName)) {
				return "activity-bookmarks-entry-update-entry";
			}

			return "activity-bookmarks-entry-update-entry-in";
		}
		else if (activityType == SocialActivityConstants.TYPE_MOVE_TO_TRASH) {
			if (Validator.isNull(groupName)) {
				return "activity-bookmarks-entry-move-to-trash";
			}

			return "activity-bookmarks-entry-move-to-trash-in";
		}
		else if (activityType ==
					SocialActivityConstants.TYPE_RESTORE_FROM_TRASH) {

			if (Validator.isNull(groupName)) {
				return "activity-bookmarks-entry-restore-from-trash";
			}

			return "activity-bookmarks-entry-restore-from-trash-in";
		}

		return null;
	}

	@Override
	protected boolean hasPermissions(
			PermissionChecker permissionChecker, SocialActivity activity,
			String actionId, ServiceContext serviceContext)
		throws Exception {

		return _bookmarksEntryModelResourcePermission.contains(
			permissionChecker, activity.getClassPK(), actionId);
	}

	private static final String[] _CLASS_NAMES = {
		BookmarksEntry.class.getName()
	};

	@Reference(
		target = "(model.class.name=com.liferay.bookmarks.model.BookmarksEntry)"
	)
	private ModelResourcePermission<BookmarksEntry>
		_bookmarksEntryModelResourcePermission;

	@Reference(
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		target = "(bundle.symbolic.name=com.liferay.bookmarks.web)"
	)
	private volatile ResourceBundleLoader _resourceBundleLoader;

}