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

package com.liferay.frontend.taglib.clay.servlet.taglib.soy;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.LabelItem;

import java.util.List;
import java.util.Map;

/**
 * @author Eudaldo Alonso
 */
public interface FileCard extends BaseClayCard {

	public default String getIcon() {
		return null;
	}

	public default List<LabelItem> getLabels() {
		return null;
	}

	public default Map<String, String> getLabelStylesMap() {
		return null;
	}

	public default String getStickerCssClass() {
		return null;
	}

	public default String getStickerIcon() {
		return null;
	}

	public default String getStickerImageAlt() {
		return null;
	}

	public default String getStickerImageSrc() {
		return null;
	}

	public default String getStickerLabel() {
		return null;
	}

	public default String getStickerShape() {
		return null;
	}

	public default String getStickerStyle() {
		return null;
	}

	public default String getSubtitle() {
		return null;
	}

	public String getTitle();

}