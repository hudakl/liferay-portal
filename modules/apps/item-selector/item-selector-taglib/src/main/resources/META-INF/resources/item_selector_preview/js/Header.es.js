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

import ClayButton from '@clayui/button';
import ClayIcon from '@clayui/icon';
import ClayLayout from '@clayui/layout';
import PropTypes from 'prop-types';
import React from 'react';

const Header = ({
	disabledAddButton = false,
	handleClickAdd,
	handleClickBack,
	headerTitle,
	infoButtonRef,
	showInfoIcon,
}) => (
	<div className="navbar navigation-bar navigation-bar-light">
		<ClayLayout.ContainerFluid className="header">
			<nav className="navbar navbar-expand-md navbar-underline navigation-bar navigation-bar-light">
				<ClayLayout.ContainerFluid>
					<ul className="navbar-nav">
						<li className="nav-item">
							<ClayButton
								borderless
								displayType="secondary"
								monospaced
								onClick={handleClickBack}
							>
								<ClayIcon symbol="angle-left" />
							</ClayButton>
						</li>
						<li className="d-none d-sm-inline-flex nav-item">
							<strong>{headerTitle}</strong>
						</li>
					</ul>
				</ClayLayout.ContainerFluid>
			</nav>

			<nav className="navbar navbar-expand-md navbar-underline navigation-bar navigation-bar-light">
				<ClayLayout.ContainerFluid>
					<ul className="navbar-nav">
						{showInfoIcon && (
							<li className="btn-group-item nav-item">
								<ClayButton
									borderless
									displayType="secondary"
									id="infoButtonRef"
									monospaced
									ref={infoButtonRef}
								>
									<ClayIcon symbol="info-panel-open" />
								</ClayButton>
							</li>
						)}
						<li className="nav-item">
							<ClayButton
								disabled={disabledAddButton}
								displayType="primary"
								onClick={handleClickAdd}
							>
								{Liferay.Language.get('add')}
							</ClayButton>
						</li>
					</ul>
				</ClayLayout.ContainerFluid>
			</nav>
		</ClayLayout.ContainerFluid>
	</div>
);

Header.propTypes = {
	disabledAddButton: PropTypes.bool,
	handleClickAdd: PropTypes.func.isRequired,
	handleClickBack: PropTypes.func.isRequired,
	headerTitle: PropTypes.string.isRequired,
	showInfoIcon: PropTypes.bool,
};

export default Header;
