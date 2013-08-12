package ru.altruix.commons.android;

import android.app.Activity;

public interface IIntentFactory {
	IIntent create(final Activity aParent, final Class<? extends Activity> aClass);
	IIntent createEmptyIntent();
}
