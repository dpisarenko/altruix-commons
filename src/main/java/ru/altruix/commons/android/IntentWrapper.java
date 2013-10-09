/*
 * This file is part of the Altruix Commons library
 * http://altruix.wordpress.com
 *
 * Copyright 2010-2013 Dmitri Pisarenko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * 
 */
package ru.altruix.commons.android;

import android.content.Intent;

/**
 * @author DP118M
 *
 */
public class IntentWrapper implements IIntent {
	private Intent intent; 
	public IntentWrapper(final Intent aIntent)
	{
		intent = aIntent;
	}
	
	@Override
	public Intent putExtra(final String aName, final long aValue)
	{
		return intent.putExtra(aName, aValue);
	}
	
	@Override
	public Intent putExtra(final String aName, final String aValue) {
		return intent.putExtra(aName, aValue);
	}
	
	@Override
	public void startActivity(final IActivity aActivity) {
		aActivity.startActivity(intent);
	}

	public Intent getIntent() {
		return intent;
	}

	public void setIntent(final Intent aIntent) {
		this.intent = aIntent;
	}

	@Override
	public String getStringExtra(final String aName) {
		return intent.getStringExtra(aName);
	}

	@Override
	public long getLongExtra(final String aName, final long aDefaultValue) {
		return intent.getLongExtra(aName, aDefaultValue);
	}
}
