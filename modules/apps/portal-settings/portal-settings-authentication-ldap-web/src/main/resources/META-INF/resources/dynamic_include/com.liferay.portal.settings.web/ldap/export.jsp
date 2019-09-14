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

<%@ include file="/dynamic_include/init.jsp" %>

<%
ConfigurationProvider<LDAPExportConfiguration> ldapExportConfigurationProvider = ConfigurationProviderUtil.getLDAPExportConfigurationProvider();

LDAPExportConfiguration ldapExportConfiguration = ldapExportConfigurationProvider.getConfiguration(themeDisplay.getCompanyId());

ConfigurationProvider<LDAPImportConfiguration> ldapImportConfigurationProvider = ConfigurationProviderUtil.getLDAPImportConfigurationProvider();

LDAPImportConfiguration ldapImportConfiguration = ldapImportConfigurationProvider.getConfiguration(themeDisplay.getCompanyId());

boolean ldapExportGroupEnabled = ldapExportConfiguration.exportGroupEnabled();
boolean ldapImportEnabled = ldapImportConfiguration.importEnabled();

boolean ldapExportEnabled = !(ldapImportConfiguration.importUserPasswordAutogenerated() && ldapImportEnabled) && ldapExportConfiguration.exportEnabled();
%>

<aui:fieldset>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= LDAPSettingsConstants.CMD_UPDATE_EXPORT %>" />

	<aui:input disabled="<%= ldapImportConfiguration.importUserPasswordAutogenerated() && ldapImportEnabled %>" id="ldapExportEnabled" label="enable-export" name='<%= "ldap--" + LDAPConstants.EXPORT_ENABLED + "--" %>' type="checkbox" value="<%= ldapExportEnabled %>" />

	<aui:input id="ldapExportGroupEnabled" label="enable-group-export" name='<%= "ldap--" + LDAPConstants.EXPORT_GROUP_ENABLED + "--" %>' type="checkbox" value="<%= ldapExportGroupEnabled %>" />
</aui:fieldset>