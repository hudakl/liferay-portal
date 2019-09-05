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

package com.liferay.portal.spring.transaction;

import com.liferay.portal.kernel.transaction.TransactionLifecycleManager;

import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author Michael C. Han
 * @author Shuyang Zhou
 */
public class DefaultTransactionExecutor extends BaseTransactionExecutor {

	public DefaultTransactionExecutor(
		PlatformTransactionManager platformTransactionManager) {

		_platformTransactionManager = platformTransactionManager;
	}

	@Override
	public void commit(
		TransactionAttributeAdapter transactionAttributeAdapter,
		TransactionStatusAdapter transactionStatusAdapter) {

		_commit(transactionAttributeAdapter, transactionStatusAdapter, null);
	}

	@Override
	public PlatformTransactionManager getPlatformTransactionManager() {
		return _platformTransactionManager;
	}

	@Override
	public void rollback(
			Throwable throwable,
			TransactionAttributeAdapter transactionAttributeAdapter,
			TransactionStatusAdapter transactionStatusAdapter)
		throws Throwable {

		if (transactionAttributeAdapter.rollbackOn(throwable)) {
			try {
				_platformTransactionManager.rollback(
					transactionStatusAdapter.getTransactionStatus());
			}
			catch (Throwable t) {
				t.addSuppressed(throwable);

				throw t;
			}
			finally {
				TransactionLifecycleManager.fireTransactionRollbackedEvent(
					transactionAttributeAdapter, transactionStatusAdapter,
					throwable);

				TransactionExecutorThreadLocal.popTransactionExecutor();
			}
		}
		else {
			_commit(
				transactionAttributeAdapter, transactionStatusAdapter,
				throwable);
		}

		throw throwable;
	}

	@Override
	public TransactionStatusAdapter start(
		TransactionAttributeAdapter transactionAttributeAdapter) {

		TransactionStatusAdapter transactionStatusAdapter =
			new TransactionStatusAdapter(
				_platformTransactionManager.getTransaction(
					transactionAttributeAdapter));

		TransactionExecutorThreadLocal.pushTransactionExecutor(this);

		TransactionLifecycleManager.fireTransactionCreatedEvent(
			transactionAttributeAdapter, transactionStatusAdapter);

		return transactionStatusAdapter;
	}

	private void _commit(
		TransactionAttributeAdapter transactionAttributeAdapter,
		TransactionStatusAdapter transactionStatusAdapter,
		Throwable applicationThrowable) {

		Throwable throwable = null;

		try {
			_platformTransactionManager.commit(
				transactionStatusAdapter.getTransactionStatus());
		}
		catch (Throwable t) {
			if (applicationThrowable != null) {
				t.addSuppressed(applicationThrowable);
			}

			throwable = t;

			throw t;
		}
		finally {
			if (throwable == null) {
				TransactionLifecycleManager.fireTransactionCommittedEvent(
					transactionAttributeAdapter, transactionStatusAdapter);
			}
			else {
				TransactionLifecycleManager.fireTransactionRollbackedEvent(
					transactionAttributeAdapter, transactionStatusAdapter,
					throwable);
			}

			TransactionExecutorThreadLocal.popTransactionExecutor();
		}
	}

	private final PlatformTransactionManager _platformTransactionManager;

}