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

package com.liferay.portal.dao.orm.hibernate;

import java.io.Serializable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.engine.SessionImplementor;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;

/**
 * @author Brian Wing Shun Chan
 * @author Bruno Farache
 */
public class IntegerType implements CompositeUserType, Serializable {

	public static final Integer DEFAULT_VALUE = Integer.valueOf(0);

	@Override
	public Object assemble(
		Serializable cached, SessionImplementor session, Object owner) {

		return cached;
	}

	@Override
	public Object deepCopy(Object obj) {
		return obj;
	}

	@Override
	public Serializable disassemble(Object value, SessionImplementor session) {
		return (Serializable)value;
	}

	@Override
	public boolean equals(Object x, Object y) {
		if (x == y) {
			return true;
		}
		else if ((x == null) || (y == null)) {
			return false;
		}

		return x.equals(y);
	}

	@Override
	public String[] getPropertyNames() {
		return new String[0];
	}

	@Override
	public Type[] getPropertyTypes() {
		return new Type[] {StandardBasicTypes.INTEGER};
	}

	@Override
	public Object getPropertyValue(Object component, int property) {
		return component;
	}

	@Override
	public int hashCode(Object x) {
		return x.hashCode();
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public Object nullSafeGet(
		ResultSet rs, String[] names, SessionImplementor session,
		Object owner) {

		Integer value = null;

		try {
			value = StandardBasicTypes.INTEGER.nullSafeGet(
				rs, names[0], session);
		}
		catch (SQLException sqle) {
		}

		if (value == null) {
			return DEFAULT_VALUE;
		}

		return value;
	}

	@Override
	public void nullSafeSet(
			PreparedStatement ps, Object target, int index,
			SessionImplementor session)
		throws SQLException {

		if (target == null) {
			target = DEFAULT_VALUE;
		}

		ps.setInt(index, (Integer)target);
	}

	@Override
	public Object replace(
		Object original, Object target, SessionImplementor session,
		Object owner) {

		return original;
	}

	@Override
	public Class<Integer> returnedClass() {
		return Integer.class;
	}

	@Override
	public void setPropertyValue(Object component, int property, Object value) {
	}

}