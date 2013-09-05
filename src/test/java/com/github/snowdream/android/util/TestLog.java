/*******************************************************************************
 * Copyright (C) 2013 Snowdream Mobile
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package com.github.snowdream.android.util;

import android.test.AndroidTestCase;

/**
 * @author snowdream
 * 
 */
public class TestLog extends AndroidTestCase {
	private final String TAG = "TestLog";

	
	public void testLog(){
		// enable or disable test
		Log.i("Log is enable!");

		Log.setEnabled(false);
		Log.i("Log is disable!");

		Log.setEnabled(true);
		Log.i("Log is enable again!");

		// set the global tag of log
		Log.setTag(TAG);
		Log.i("The tag of Log is :" + TAG);

		// set the custom tag of log for the method
		Log.i("Custom Tag", "Test");

		// test i w e d v
		Log.i("test INFO");
		Log.d("test DEBUG");
		Log.w("test WARNNING");
		Log.e("test ERROR");
		Log.v("test VERBOSE");

	}
}
