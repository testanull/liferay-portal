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

package com.liferay.fragment.web.internal.portlet;

import com.liferay.fragment.constants.FragmentActionKeys;
import com.liferay.fragment.constants.FragmentPortletKeys;
import com.liferay.fragment.contributor.FragmentCollectionContributorTracker;
import com.liferay.fragment.model.FragmentCollection;
import com.liferay.fragment.processor.FragmentEntryProcessorRegistry;
import com.liferay.fragment.renderer.FragmentRendererController;
import com.liferay.fragment.service.FragmentCollectionService;
import com.liferay.fragment.web.internal.configuration.FragmentPortletConfiguration;
import com.liferay.fragment.web.internal.constants.FragmentWebKeys;
import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.GroupService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jürgen Kappler
 */
@Component(
	configurationPid = "com.liferay.fragment.web.internal.configuration.FragmentPortletConfiguration",
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.css-class-wrapper=portlet-fragment-web",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.preferences-owned-by-group=true",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.display-name=Fragments",
		"javax.portlet.init-param.template-path=/META-INF/resources/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + FragmentPortletKeys.FRAGMENT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=administrator"
	},
	service = Portlet.class
)
public class FragmentPortlet extends MVCPortlet {

	@Override
	protected void doDispatch(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		FragmentPortletConfiguration fragmentPortletConfiguration = null;

		try {
			fragmentPortletConfiguration =
				_configurationProvider.getCompanyConfiguration(
					FragmentPortletConfiguration.class,
					themeDisplay.getCompanyId());
		}
		catch (ConfigurationException ce) {
			throw new PortletException(ce);
		}

		renderRequest.setAttribute(
			FragmentWebKeys.FRAGMENT_COLLECTION_CONTRIBUTOR_TRACKER,
			_fragmentCollectionContributorTracker);
		renderRequest.setAttribute(
			FragmentWebKeys.FRAGMENT_COLLECTIONS,
			_fragmentCollectionService.getFragmentCollections(
				themeDisplay.getScopeGroupId()));
		renderRequest.setAttribute(
			FragmentPortletConfiguration.class.getName(),
			fragmentPortletConfiguration);
		renderRequest.setAttribute(
			FragmentWebKeys.FRAGMENT_ENTRY_PROCESSOR_REGISTRY,
			_fragmentEntryProcessorRegistry);
		renderRequest.setAttribute(
			FragmentActionKeys.FRAGMENT_RENDERER_CONTROLLER,
			_fragmentRendererController);

		Map<String, List<FragmentCollection>> inheritedFragmentCollections =
			new TreeMap<>();

		if (themeDisplay.getScopeGroupId() !=
				themeDisplay.getCompanyGroupId()) {

			try {
				inheritedFragmentCollections = _getInheritedFragmentCollections(
					themeDisplay);
			}
			catch (PortalException pe) {
				if (_log.isWarnEnabled()) {
					_log.warn(pe, pe);
				}
			}
		}

		renderRequest.setAttribute(
			FragmentWebKeys.INHERITED_FRAGMENT_COLLECTIONS,
			inheritedFragmentCollections);

		renderRequest.setAttribute(
			FragmentWebKeys.ITEM_SELECTOR, _itemSelector);

		super.doDispatch(renderRequest, renderResponse);
	}

	private Map<String, List<FragmentCollection>>
			_getInheritedFragmentCollections(ThemeDisplay themeDisplay)
		throws PortalException {

		Map<String, List<FragmentCollection>> inheritedFragmentCollections =
			new TreeMap<>();

		Group group = _groupService.getGroup(themeDisplay.getCompanyGroupId());

		List<FragmentCollection> fragmentCollections =
			_fragmentCollectionService.getFragmentCollections(
				group.getGroupId());

		if (ListUtil.isNotEmpty(fragmentCollections)) {
			inheritedFragmentCollections.put(
				group.getDescriptiveName(themeDisplay.getLocale()),
				fragmentCollections);
		}

		return inheritedFragmentCollections;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		FragmentPortlet.class);

	@Reference
	private ConfigurationProvider _configurationProvider;

	@Reference
	private FragmentCollectionContributorTracker
		_fragmentCollectionContributorTracker;

	@Reference
	private FragmentCollectionService _fragmentCollectionService;

	@Reference
	private FragmentEntryProcessorRegistry _fragmentEntryProcessorRegistry;

	@Reference
	private FragmentRendererController _fragmentRendererController;

	@Reference
	private GroupService _groupService;

	@Reference
	private ItemSelector _itemSelector;

}