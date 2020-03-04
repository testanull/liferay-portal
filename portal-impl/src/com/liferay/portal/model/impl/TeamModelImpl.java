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

package com.liferay.portal.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.Team;
import com.liferay.portal.kernel.model.TeamModel;
import com.liferay.portal.kernel.model.TeamSoap;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Team service. Represents a row in the &quot;Team&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>TeamModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TeamImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeamImpl
 * @generated
 */
@JSON(strict = true)
public class TeamModelImpl extends BaseModelImpl<Team> implements TeamModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a team model instance should use the <code>Team</code> interface instead.
	 */
	public static final String TABLE_NAME = "Team";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"teamId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"groupId", Types.BIGINT}, {"name", Types.VARCHAR},
		{"description", Types.VARCHAR}, {"lastPublishDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("teamId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Team (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,teamId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,groupId LONG,name VARCHAR(75) null,description STRING null,lastPublishDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table Team";

	public static final String ORDER_BY_JPQL = " ORDER BY team.name ASC";

	public static final String ORDER_BY_SQL = " ORDER BY Team.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.entity.cache.enabled.com.liferay.portal.kernel.model.Team"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.finder.cache.enabled.com.liferay.portal.kernel.model.Team"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.com.liferay.portal.kernel.model.Team"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long NAME_COLUMN_BITMASK = 4L;

	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Team toModel(TeamSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Team model = new TeamImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setUuid(soapModel.getUuid());
		model.setTeamId(soapModel.getTeamId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setGroupId(soapModel.getGroupId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setLastPublishDate(soapModel.getLastPublishDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Team> toModels(TeamSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Team> models = new ArrayList<Team>(soapModels.length);

		for (TeamSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final String MAPPING_TABLE_USERS_TEAMS_NAME = "Users_Teams";

	public static final Object[][] MAPPING_TABLE_USERS_TEAMS_COLUMNS = {
		{"companyId", Types.BIGINT}, {"teamId", Types.BIGINT},
		{"userId", Types.BIGINT}
	};

	public static final String MAPPING_TABLE_USERS_TEAMS_SQL_CREATE =
		"create table Users_Teams (companyId LONG not null,teamId LONG not null,userId LONG not null,primary key (teamId, userId))";

	public static final boolean FINDER_CACHE_ENABLED_USERS_TEAMS =
		GetterUtil.getBoolean(
			com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.Users_Teams"),
			true);

	public static final String MAPPING_TABLE_USERGROUPS_TEAMS_NAME =
		"UserGroups_Teams";

	public static final Object[][] MAPPING_TABLE_USERGROUPS_TEAMS_COLUMNS = {
		{"companyId", Types.BIGINT}, {"teamId", Types.BIGINT},
		{"userGroupId", Types.BIGINT}
	};

	public static final String MAPPING_TABLE_USERGROUPS_TEAMS_SQL_CREATE =
		"create table UserGroups_Teams (companyId LONG not null,teamId LONG not null,userGroupId LONG not null,primary key (teamId, userGroupId))";

	public static final boolean FINDER_CACHE_ENABLED_USERGROUPS_TEAMS =
		GetterUtil.getBoolean(
			com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.UserGroups_Teams"),
			true);

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.portal.kernel.model.Team"));

	public TeamModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _teamId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTeamId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _teamId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Team.class;
	}

	@Override
	public String getModelClassName() {
		return Team.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Team, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Team, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Team, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Team)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Team, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Team, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Team)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Team, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Team, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Team>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Team.class.getClassLoader(), Team.class, ModelWrapper.class);

		try {
			Constructor<Team> constructor =
				(Constructor<Team>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<Team, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Team, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Team, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Team, Object>>();
		Map<String, BiConsumer<Team, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Team, ?>>();

		attributeGetterFunctions.put("mvccVersion", Team::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion", (BiConsumer<Team, Long>)Team::setMvccVersion);
		attributeGetterFunctions.put("uuid", Team::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Team, String>)Team::setUuid);
		attributeGetterFunctions.put("teamId", Team::getTeamId);
		attributeSetterBiConsumers.put(
			"teamId", (BiConsumer<Team, Long>)Team::setTeamId);
		attributeGetterFunctions.put("companyId", Team::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Team, Long>)Team::setCompanyId);
		attributeGetterFunctions.put("userId", Team::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Team, Long>)Team::setUserId);
		attributeGetterFunctions.put("userName", Team::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Team, String>)Team::setUserName);
		attributeGetterFunctions.put("createDate", Team::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Team, Date>)Team::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Team::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate", (BiConsumer<Team, Date>)Team::setModifiedDate);
		attributeGetterFunctions.put("groupId", Team::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Team, Long>)Team::setGroupId);
		attributeGetterFunctions.put("name", Team::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<Team, String>)Team::setName);
		attributeGetterFunctions.put("description", Team::getDescription);
		attributeSetterBiConsumers.put(
			"description", (BiConsumer<Team, String>)Team::setDescription);
		attributeGetterFunctions.put(
			"lastPublishDate", Team::getLastPublishDate);
		attributeSetterBiConsumers.put(
			"lastPublishDate",
			(BiConsumer<Team, Date>)Team::setLastPublishDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getTeamId() {
		return _teamId;
	}

	@Override
	public void setTeamId(long teamId) {
		_teamId = teamId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	@Override
	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Team.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Team.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Team toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Team>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TeamImpl teamImpl = new TeamImpl();

		teamImpl.setMvccVersion(getMvccVersion());
		teamImpl.setUuid(getUuid());
		teamImpl.setTeamId(getTeamId());
		teamImpl.setCompanyId(getCompanyId());
		teamImpl.setUserId(getUserId());
		teamImpl.setUserName(getUserName());
		teamImpl.setCreateDate(getCreateDate());
		teamImpl.setModifiedDate(getModifiedDate());
		teamImpl.setGroupId(getGroupId());
		teamImpl.setName(getName());
		teamImpl.setDescription(getDescription());
		teamImpl.setLastPublishDate(getLastPublishDate());

		teamImpl.resetOriginalValues();

		return teamImpl;
	}

	@Override
	public int compareTo(Team team) {
		int value = 0;

		value = getName().compareTo(team.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Team)) {
			return false;
		}

		Team team = (Team)obj;

		long primaryKey = team.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		TeamModelImpl teamModelImpl = this;

		teamModelImpl._originalUuid = teamModelImpl._uuid;

		teamModelImpl._originalCompanyId = teamModelImpl._companyId;

		teamModelImpl._setOriginalCompanyId = false;

		teamModelImpl._setModifiedDate = false;

		teamModelImpl._originalGroupId = teamModelImpl._groupId;

		teamModelImpl._setOriginalGroupId = false;

		teamModelImpl._originalName = teamModelImpl._name;

		teamModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Team> toCacheModel() {
		TeamCacheModel teamCacheModel = new TeamCacheModel();

		teamCacheModel.mvccVersion = getMvccVersion();

		teamCacheModel.uuid = getUuid();

		String uuid = teamCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			teamCacheModel.uuid = null;
		}

		teamCacheModel.teamId = getTeamId();

		teamCacheModel.companyId = getCompanyId();

		teamCacheModel.userId = getUserId();

		teamCacheModel.userName = getUserName();

		String userName = teamCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			teamCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			teamCacheModel.createDate = createDate.getTime();
		}
		else {
			teamCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			teamCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			teamCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		teamCacheModel.groupId = getGroupId();

		teamCacheModel.name = getName();

		String name = teamCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			teamCacheModel.name = null;
		}

		teamCacheModel.description = getDescription();

		String description = teamCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			teamCacheModel.description = null;
		}

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			teamCacheModel.lastPublishDate = lastPublishDate.getTime();
		}
		else {
			teamCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		return teamCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Team, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Team, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Team, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Team)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Team, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Team, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Team, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Team)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Team>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _mvccVersion;
	private String _uuid;
	private String _originalUuid;
	private long _teamId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private String _name;
	private String _originalName;
	private String _description;
	private Date _lastPublishDate;
	private long _columnBitmask;
	private Team _escapedModel;

}