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

package com.liferay.portal.tools.service.builder.test.uad.exporter;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.tools.service.builder.test.model.UADPartialEntry;
import com.liferay.portal.tools.service.builder.test.service.UADPartialEntryLocalService;
import com.liferay.portal.tools.service.builder.test.uad.constants.SBTestUADConstants;
import com.liferay.user.associated.data.exporter.DynamicQueryUADExporter;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the uad partial entry UAD exporter.
 *
 * <p>
 * This implementation exists only as a container for the default methods
 * generated by ServiceBuilder. All custom service methods should be put in
 * {@link UADPartialEntryUADExporter}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class BaseUADPartialEntryUADExporter
	extends DynamicQueryUADExporter<UADPartialEntry> {

	@Override
	public Class<UADPartialEntry> getTypeClass() {
		return UADPartialEntry.class;
	}

	@Override
	protected ActionableDynamicQuery doGetActionableDynamicQuery() {
		return uadPartialEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	protected String[] doGetUserIdFieldNames() {
		return SBTestUADConstants.USER_ID_FIELD_NAMES_UAD_PARTIAL_ENTRY;
	}

	@Override
	protected String toXmlString(UADPartialEntry uadPartialEntry) {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.portal.tools.service.builder.test.model.UADPartialEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uadPartialEntryId</column-name><column-value><![CDATA[");
		sb.append(uadPartialEntry.getUadPartialEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(uadPartialEntry.getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(uadPartialEntry.getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>message</column-name><column-value><![CDATA[");
		sb.append(uadPartialEntry.getMessage());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	@Reference
	protected UADPartialEntryLocalService uadPartialEntryLocalService;

}