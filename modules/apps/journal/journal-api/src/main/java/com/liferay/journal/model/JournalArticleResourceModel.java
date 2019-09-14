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

package com.liferay.journal.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the JournalArticleResource service. Represents a row in the &quot;JournalArticleResource&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.journal.model.impl.JournalArticleResourceModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.journal.model.impl.JournalArticleResourceImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JournalArticleResource
 * @generated
 */
@ProviderType
public interface JournalArticleResourceModel
	extends BaseModel<JournalArticleResource>, MVCCModel, ShardedModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a journal article resource model instance should use the {@link JournalArticleResource} interface instead.
	 */

	/**
	 * Returns the primary key of this journal article resource.
	 *
	 * @return the primary key of this journal article resource
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this journal article resource.
	 *
	 * @param primaryKey the primary key of this journal article resource
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this journal article resource.
	 *
	 * @return the mvcc version of this journal article resource
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this journal article resource.
	 *
	 * @param mvccVersion the mvcc version of this journal article resource
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this journal article resource.
	 *
	 * @return the uuid of this journal article resource
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this journal article resource.
	 *
	 * @param uuid the uuid of this journal article resource
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the resource prim key of this journal article resource.
	 *
	 * @return the resource prim key of this journal article resource
	 */
	public long getResourcePrimKey();

	/**
	 * Sets the resource prim key of this journal article resource.
	 *
	 * @param resourcePrimKey the resource prim key of this journal article resource
	 */
	public void setResourcePrimKey(long resourcePrimKey);

	/**
	 * Returns the group ID of this journal article resource.
	 *
	 * @return the group ID of this journal article resource
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this journal article resource.
	 *
	 * @param groupId the group ID of this journal article resource
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this journal article resource.
	 *
	 * @return the company ID of this journal article resource
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this journal article resource.
	 *
	 * @param companyId the company ID of this journal article resource
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the article ID of this journal article resource.
	 *
	 * @return the article ID of this journal article resource
	 */
	@AutoEscape
	public String getArticleId();

	/**
	 * Sets the article ID of this journal article resource.
	 *
	 * @param articleId the article ID of this journal article resource
	 */
	public void setArticleId(String articleId);

}