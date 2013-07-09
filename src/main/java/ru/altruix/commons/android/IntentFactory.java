/**
 * 
 */
package ru.altruix.commons.android;

import android.app.Activity;
import android.content.Intent;

/**
 * @author DP118M
 *
 */
public class IntentFactory implements IIntentFactory {

	@Override
	public IIntent create(final Activity aParent,
			final Class<? extends Activity> aClass) {
		return new IntentWrapper(new Intent(aParent, aClass));
	}
}
