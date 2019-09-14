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

package com.liferay.message.boards.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for MBBan. This utility wraps
 * <code>com.liferay.message.boards.service.impl.MBBanServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MBBanService
 * @generated
 */
public class MBBanServiceUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.message.boards.service.impl.MBBanServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MBBanServiceUtil} to access the message boards ban remote service. Add custom service methods to <code>com.liferay.message.boards.service.impl.MBBanServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static com.liferay.message.boards.model.MBBan addBan(
			long banUserId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addBan(banUserId, serviceContext);
	}

	public static void deleteBan(
			long banUserId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteBan(banUserId, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static MBBanService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MBBanService, MBBanService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MBBanService.class);

		ServiceTracker<MBBanService, MBBanService> serviceTracker =
			new ServiceTracker<MBBanService, MBBanService>(
				bundle.getBundleContext(), MBBanService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}