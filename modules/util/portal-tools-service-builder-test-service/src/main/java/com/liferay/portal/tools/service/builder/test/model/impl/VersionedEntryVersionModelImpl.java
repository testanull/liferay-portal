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

package com.liferay.portal.tools.service.builder.test.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.tools.service.builder.test.model.VersionedEntry;
import com.liferay.portal.tools.service.builder.test.model.VersionedEntryVersion;
import com.liferay.portal.tools.service.builder.test.model.VersionedEntryVersionModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the VersionedEntryVersion service. Represents a row in the &quot;VersionedEntryVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>VersionedEntryVersionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VersionedEntryVersionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VersionedEntryVersionImpl
 * @generated
 */
public class VersionedEntryVersionModelImpl
	extends BaseModelImpl<VersionedEntryVersion>
	implements VersionedEntryVersionModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a versioned entry version model instance should use the <code>VersionedEntryVersion</code> interface instead.
	 */
	public static final String TABLE_NAME = "VersionedEntryVersion";

	public static final Object[][] TABLE_COLUMNS = {
		{"versionedEntryVersionId", Types.BIGINT}, {"version", Types.INTEGER},
		{"versionedEntryId", Types.BIGINT}, {"groupId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("versionedEntryVersionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("version", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("versionedEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table VersionedEntryVersion (versionedEntryVersionId LONG not null primary key,version INTEGER,versionedEntryId LONG,groupId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table VersionedEntryVersion";

	public static final String ORDER_BY_JPQL =
		" ORDER BY versionedEntryVersion.version DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY VersionedEntryVersion.version DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.tools.service.builder.test.service.util.ServiceProps.
			get(
				"value.object.entity.cache.enabled.com.liferay.portal.tools.service.builder.test.model.VersionedEntryVersion"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.tools.service.builder.test.service.util.ServiceProps.
			get(
				"value.object.finder.cache.enabled.com.liferay.portal.tools.service.builder.test.model.VersionedEntryVersion"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.tools.service.builder.test.service.util.ServiceProps.
			get(
				"value.object.column.bitmask.enabled.com.liferay.portal.tools.service.builder.test.model.VersionedEntryVersion"),
		true);

	public static final long GROUPID_COLUMN_BITMASK = 1L;

	public static final long VERSION_COLUMN_BITMASK = 2L;

	public static final long VERSIONEDENTRYID_COLUMN_BITMASK = 4L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.tools.service.builder.test.service.util.ServiceProps.
			get(
				"lock.expiration.time.com.liferay.portal.tools.service.builder.test.model.VersionedEntryVersion"));

	public VersionedEntryVersionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _versionedEntryVersionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVersionedEntryVersionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _versionedEntryVersionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return VersionedEntryVersion.class;
	}

	@Override
	public String getModelClassName() {
		return VersionedEntryVersion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<VersionedEntryVersion, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<VersionedEntryVersion, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<VersionedEntryVersion, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((VersionedEntryVersion)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<VersionedEntryVersion, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<VersionedEntryVersion, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(VersionedEntryVersion)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<VersionedEntryVersion, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<VersionedEntryVersion, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, VersionedEntryVersion>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			VersionedEntryVersion.class.getClassLoader(),
			VersionedEntryVersion.class, ModelWrapper.class);

		try {
			Constructor<VersionedEntryVersion> constructor =
				(Constructor<VersionedEntryVersion>)proxyClass.getConstructor(
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

	private static final Map<String, Function<VersionedEntryVersion, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<VersionedEntryVersion, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<VersionedEntryVersion, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<VersionedEntryVersion, Object>>();
		Map<String, BiConsumer<VersionedEntryVersion, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<VersionedEntryVersion, ?>>();

		attributeGetterFunctions.put(
			"versionedEntryVersionId",
			new Function<VersionedEntryVersion, Object>() {

				@Override
				public Object apply(
					VersionedEntryVersion versionedEntryVersion) {

					return versionedEntryVersion.getVersionedEntryVersionId();
				}

			});
		attributeSetterBiConsumers.put(
			"versionedEntryVersionId",
			new BiConsumer<VersionedEntryVersion, Object>() {

				@Override
				public void accept(
					VersionedEntryVersion versionedEntryVersion,
					Object versionedEntryVersionId) {

					versionedEntryVersion.setVersionedEntryVersionId(
						(Long)versionedEntryVersionId);
				}

			});
		attributeGetterFunctions.put(
			"version",
			new Function<VersionedEntryVersion, Object>() {

				@Override
				public Object apply(
					VersionedEntryVersion versionedEntryVersion) {

					return versionedEntryVersion.getVersion();
				}

			});
		attributeSetterBiConsumers.put(
			"version",
			new BiConsumer<VersionedEntryVersion, Object>() {

				@Override
				public void accept(
					VersionedEntryVersion versionedEntryVersion,
					Object version) {

					versionedEntryVersion.setVersion((Integer)version);
				}

			});
		attributeGetterFunctions.put(
			"versionedEntryId",
			new Function<VersionedEntryVersion, Object>() {

				@Override
				public Object apply(
					VersionedEntryVersion versionedEntryVersion) {

					return versionedEntryVersion.getVersionedEntryId();
				}

			});
		attributeSetterBiConsumers.put(
			"versionedEntryId",
			new BiConsumer<VersionedEntryVersion, Object>() {

				@Override
				public void accept(
					VersionedEntryVersion versionedEntryVersion,
					Object versionedEntryId) {

					versionedEntryVersion.setVersionedEntryId(
						(Long)versionedEntryId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<VersionedEntryVersion, Object>() {

				@Override
				public Object apply(
					VersionedEntryVersion versionedEntryVersion) {

					return versionedEntryVersion.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<VersionedEntryVersion, Object>() {

				@Override
				public void accept(
					VersionedEntryVersion versionedEntryVersion,
					Object groupId) {

					versionedEntryVersion.setGroupId((Long)groupId);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getVersionedModelId() {
		return getVersionedEntryId();
	}

	@Override
	public void populateVersionedModel(VersionedEntry versionedEntry) {
		versionedEntry.setGroupId(getGroupId());
	}

	@Override
	public void setVersionedModelId(long versionedEntryId) {
		setVersionedEntryId(versionedEntryId);
	}

	@Override
	public VersionedEntry toVersionedModel() {
		VersionedEntry versionedEntry = new VersionedEntryImpl();

		versionedEntry.setPrimaryKey(getVersionedModelId());
		versionedEntry.setHeadId(-getVersionedModelId());

		populateVersionedModel(versionedEntry);

		return versionedEntry;
	}

	@Override
	public long getVersionedEntryVersionId() {
		return _versionedEntryVersionId;
	}

	@Override
	public void setVersionedEntryVersionId(long versionedEntryVersionId) {
		_versionedEntryVersionId = versionedEntryVersionId;
	}

	@Override
	public int getVersion() {
		return _version;
	}

	@Override
	public void setVersion(int version) {
		_columnBitmask = -1L;

		if (!_setOriginalVersion) {
			_setOriginalVersion = true;

			_originalVersion = _version;
		}

		_version = version;
	}

	public int getOriginalVersion() {
		return _originalVersion;
	}

	@Override
	public long getVersionedEntryId() {
		return _versionedEntryId;
	}

	@Override
	public void setVersionedEntryId(long versionedEntryId) {
		_columnBitmask |= VERSIONEDENTRYID_COLUMN_BITMASK;

		if (!_setOriginalVersionedEntryId) {
			_setOriginalVersionedEntryId = true;

			_originalVersionedEntryId = _versionedEntryId;
		}

		_versionedEntryId = versionedEntryId;
	}

	public long getOriginalVersionedEntryId() {
		return _originalVersionedEntryId;
	}

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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, VersionedEntryVersion.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public VersionedEntryVersion toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, VersionedEntryVersion>
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
		VersionedEntryVersionImpl versionedEntryVersionImpl =
			new VersionedEntryVersionImpl();

		versionedEntryVersionImpl.setVersionedEntryVersionId(
			getVersionedEntryVersionId());
		versionedEntryVersionImpl.setVersion(getVersion());
		versionedEntryVersionImpl.setVersionedEntryId(getVersionedEntryId());
		versionedEntryVersionImpl.setGroupId(getGroupId());

		versionedEntryVersionImpl.resetOriginalValues();

		return versionedEntryVersionImpl;
	}

	@Override
	public int compareTo(VersionedEntryVersion versionedEntryVersion) {
		int value = 0;

		if (getVersion() < versionedEntryVersion.getVersion()) {
			value = -1;
		}
		else if (getVersion() > versionedEntryVersion.getVersion()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

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

		if (!(obj instanceof VersionedEntryVersion)) {
			return false;
		}

		VersionedEntryVersion versionedEntryVersion =
			(VersionedEntryVersion)obj;

		long primaryKey = versionedEntryVersion.getPrimaryKey();

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
		VersionedEntryVersionModelImpl versionedEntryVersionModelImpl = this;

		versionedEntryVersionModelImpl._originalVersion =
			versionedEntryVersionModelImpl._version;

		versionedEntryVersionModelImpl._setOriginalVersion = false;

		versionedEntryVersionModelImpl._originalVersionedEntryId =
			versionedEntryVersionModelImpl._versionedEntryId;

		versionedEntryVersionModelImpl._setOriginalVersionedEntryId = false;

		versionedEntryVersionModelImpl._originalGroupId =
			versionedEntryVersionModelImpl._groupId;

		versionedEntryVersionModelImpl._setOriginalGroupId = false;

		versionedEntryVersionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<VersionedEntryVersion> toCacheModel() {
		VersionedEntryVersionCacheModel versionedEntryVersionCacheModel =
			new VersionedEntryVersionCacheModel();

		versionedEntryVersionCacheModel.versionedEntryVersionId =
			getVersionedEntryVersionId();

		versionedEntryVersionCacheModel.version = getVersion();

		versionedEntryVersionCacheModel.versionedEntryId =
			getVersionedEntryId();

		versionedEntryVersionCacheModel.groupId = getGroupId();

		return versionedEntryVersionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<VersionedEntryVersion, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<VersionedEntryVersion, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<VersionedEntryVersion, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((VersionedEntryVersion)this));
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
		Map<String, Function<VersionedEntryVersion, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<VersionedEntryVersion, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<VersionedEntryVersion, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((VersionedEntryVersion)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, VersionedEntryVersion>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _versionedEntryVersionId;
	private int _version;
	private int _originalVersion;
	private boolean _setOriginalVersion;
	private long _versionedEntryId;
	private long _originalVersionedEntryId;
	private boolean _setOriginalVersionedEntryId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _columnBitmask;
	private VersionedEntryVersion _escapedModel;

}