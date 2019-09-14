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

package com.liferay.portal.kernel.model;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the RecentLayoutRevision service. Represents a row in the &quot;RecentLayoutRevision&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.portal.model.impl.RecentLayoutRevisionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.portal.model.impl.RecentLayoutRevisionImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RecentLayoutRevision
 * @generated
 */
@ProviderType
public interface RecentLayoutRevisionModel
	extends BaseModel<RecentLayoutRevision>, MVCCModel, ShardedModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a recent layout revision model instance should use the {@link RecentLayoutRevision} interface instead.
	 */

	/**
	 * Returns the primary key of this recent layout revision.
	 *
	 * @return the primary key of this recent layout revision
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this recent layout revision.
	 *
	 * @param primaryKey the primary key of this recent layout revision
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this recent layout revision.
	 *
	 * @return the mvcc version of this recent layout revision
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this recent layout revision.
	 *
	 * @param mvccVersion the mvcc version of this recent layout revision
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the recent layout revision ID of this recent layout revision.
	 *
	 * @return the recent layout revision ID of this recent layout revision
	 */
	public long getRecentLayoutRevisionId();

	/**
	 * Sets the recent layout revision ID of this recent layout revision.
	 *
	 * @param recentLayoutRevisionId the recent layout revision ID of this recent layout revision
	 */
	public void setRecentLayoutRevisionId(long recentLayoutRevisionId);

	/**
	 * Returns the group ID of this recent layout revision.
	 *
	 * @return the group ID of this recent layout revision
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this recent layout revision.
	 *
	 * @param groupId the group ID of this recent layout revision
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this recent layout revision.
	 *
	 * @return the company ID of this recent layout revision
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this recent layout revision.
	 *
	 * @param companyId the company ID of this recent layout revision
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this recent layout revision.
	 *
	 * @return the user ID of this recent layout revision
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this recent layout revision.
	 *
	 * @param userId the user ID of this recent layout revision
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this recent layout revision.
	 *
	 * @return the user uuid of this recent layout revision
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this recent layout revision.
	 *
	 * @param userUuid the user uuid of this recent layout revision
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the layout revision ID of this recent layout revision.
	 *
	 * @return the layout revision ID of this recent layout revision
	 */
	public long getLayoutRevisionId();

	/**
	 * Sets the layout revision ID of this recent layout revision.
	 *
	 * @param layoutRevisionId the layout revision ID of this recent layout revision
	 */
	public void setLayoutRevisionId(long layoutRevisionId);

	/**
	 * Returns the layout set branch ID of this recent layout revision.
	 *
	 * @return the layout set branch ID of this recent layout revision
	 */
	public long getLayoutSetBranchId();

	/**
	 * Sets the layout set branch ID of this recent layout revision.
	 *
	 * @param layoutSetBranchId the layout set branch ID of this recent layout revision
	 */
	public void setLayoutSetBranchId(long layoutSetBranchId);

	/**
	 * Returns the plid of this recent layout revision.
	 *
	 * @return the plid of this recent layout revision
	 */
	public long getPlid();

	/**
	 * Sets the plid of this recent layout revision.
	 *
	 * @param plid the plid of this recent layout revision
	 */
	public void setPlid(long plid);

}