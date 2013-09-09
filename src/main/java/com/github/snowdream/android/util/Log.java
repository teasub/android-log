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

/**
 * Wrapper API for sending log output <BR /><BR />
 * 
 * 1.enable/disable log
 *  <pre>
 * Log.setEnabled(true);  
 * Log.setEnabled(false);  
 * </pre>
 * 
 * 2.set the Tag for the log
 *  <pre>
 * Log.setTag("Android");  
 * </pre>
 * 
 * 3.log simple
 *  <pre>
 * Log.d("test");  
 * Log.v("test");  
 * Log.i("test");  
 * Log.w("test");  
 * Log.e("test");  
 * </pre>
 * 
 * 4.log simple -- set custom tag
 *  <pre>
 * Log.d("TAG","test");  
 * Log.v("TAG","test");  
 * Log.i("TAG","test");  
 * Log.w("TAG","test");  
 * Log.e("TAG","test");  
 * </pre>
 * 
 * 5.log advance
 *  <pre>
 * Log.d("test",new Throwable("test"));  
 * Log.v("test",new Throwable("test"));  
 * Log.i("test",new Throwable("test"));  
 * Log.w("test",new Throwable("test"));  
 * Log.e("test",new Throwable("test"));  
 * </pre>
 * 
 * 6.log advance -- set custom tag
 * <pre>
 * Log.d("TAG","test",new Throwable("test"));  
 * Log.v("TAG","test",new Throwable("test"));  
 * Log.i("TAG","test",new Throwable("test"));  
 * Log.w("TAG","test",new Throwable("test"));  
 * Log.e("TAG","test",new Throwable("test"));  
 * </pre>
 */
public class Log {

	/**
	 * The TAG of the Application
	 */
	protected static String TAG = "MyApplication";

	/**
	 * Whether to enable the log
	 */
	protected static boolean isEnable = true;

	/**
	 * the constructor
	 */
	private Log() {
	}

	/**
	 * Set the Tag of the application
	 * 
	 * @param tag
	 *            the Tag of the application
	 */
	public static void setTag(String tag) {
		TAG = tag;
	}

	/**
	 * Get the Tag of the application
	 * 
	 * @param tag
	 *            the Tag of the application
	 */
	public static String getTag() {
		return TAG;
	}

	/**
	 * enable or disable the log
	 * 
	 * @param enabled
	 *            whether to enable the log
	 */
	public static void setEnabled(boolean enabled) {
		isEnable = enabled;
	}

	/**
	 * is the log enabled?
	 * 
	 * @param enabled
	 *            whether to enable the log
	 */
	public static boolean isEnabled() {
		return isEnable;
	}

	/**
	 * Send a VERBOSE log message.
	 * 
	 * @param msg
	 *            The message you would like logged.
	 */
	public static void v(String msg) {
		if (isEnable) {
			android.util.Log.v(TAG, buildMessage(msg));
		}
	}

	/**
	 * Send a VERBOSE log message and log the exception.
	 * 
	 * @param msg
	 *            The message you would like logged.
	 * @param thr
	 *            An exception to log
	 */
	public static void v(String msg, Throwable thr) {
		if (isEnable) {
			android.util.Log.v(TAG, buildMessage(msg), thr);
		}
	}

	/**
	 * Send a VERBOSE log message.
	 * 
	 * @param msg
	 *            The message you would like logged.
	 */
	public static void v(String tag, String msg) {
		if (isEnable) {
			if (tag == null || tag == "") {
				v(msg);
			} else {
				android.util.Log.v(TAG, buildMessage(msg));
			}
		}
	}

	/**
	 * Send a VERBOSE log message and log the exception.
	 * 
	 * @param msg
	 *            The message you would like logged.
	 * @param thr
	 *            An exception to log
	 */
	public static void v(String tag, String msg, Throwable thr) {
		if (isEnable) {
			if (tag == null || tag == "") {
				v(msg, thr);
			} else {
				android.util.Log.v(TAG, buildMessage(msg), thr);
			}
		}
	}

	/**
	 * Send a DEBUG log message.
	 * 
	 * @param msg
	 */
	public static void d(String msg) {
		if (isEnable) {
			android.util.Log.d(TAG, buildMessage(msg));
		}
	}

	/**
	 * Send a DEBUG log message and log the exception.
	 * 
	 * @param msg
	 *            The message you would like logged.
	 * @param tr
	 *            An exception to log
	 */
	public static void d(String msg, Throwable thr) {
		if (isEnable) {
			android.util.Log.d(TAG, buildMessage(msg), thr);
		}
	}

	/**
	 * Send a DEBUG log message.
	 * 
	 * @param msg
	 *            The message you would like logged.
	 */
	public static void d(String tag, String msg) {
		if (isEnable) {
			if (tag == null || tag == "") {
				d(msg);
			} else {
				android.util.Log.d(TAG, buildMessage(msg));
			}
		}
	}

	/**
	 * Send a DEBUG log message and log the exception.
	 * 
	 * @param msg
	 *            The message you would like logged.
	 * @param thr
	 *            An exception to log
	 */
	public static void d(String tag, String msg, Throwable thr) {
		if (isEnable) {
			if (tag == null || tag == "") {
				d(msg, thr);
			} else {
				android.util.Log.d(TAG, buildMessage(msg), thr);
			}
		}
	}

	/**
	 * Send an INFO log message.
	 * 
	 * @param msg
	 *            The message you would like logged.
	 */
	public static void i(String msg) {
		if (isEnable) {
			android.util.Log.i(TAG, buildMessage(msg));
		}
	}

	/**
	 * Send a INFO log message and log the exception.
	 * 
	 * @param msg
	 *            The message you would like logged.
	 * @param thr
	 *            An exception to log
	 */
	public static void i(String msg, Throwable thr) {
		if (isEnable) {
			android.util.Log.i(TAG, buildMessage(msg), thr);
		}
	}

	/**
	 * Send a INFO log message.
	 * 
	 * @param msg
	 *            The message you would like logged.
	 */
	public static void i(String tag, String msg) {
		if (isEnable) {
			if (tag == null || tag == "") {
				i(msg);
			} else {
				android.util.Log.i(TAG, buildMessage(msg));
			}
		}
	}

	/**
	 * Send a INFO log message and log the exception.
	 * 
	 * @param msg
	 *            The message you would like logged.
	 * @param thr
	 *            An exception to log
	 */
	public static void i(String tag, String msg, Throwable thr) {
		if (isEnable) {
			if (tag == null || tag == "") {
				i(msg, thr);
			} else {
				android.util.Log.i(TAG, buildMessage(msg), thr);
			}
		}
	}

	/**
	 * Send an ERROR log message.
	 * 
	 * @param msg
	 *            The message you would like logged.
	 */
	public static void e(String msg) {
		if (isEnable) {
			android.util.Log.e(TAG, buildMessage(msg));
		}
	}

	/**
	 * Send an ERROR log message and log the exception.
	 * 
	 * @param msg
	 *            The message you would like logged.
	 * @param thr
	 *            An exception to log
	 */
	public static void e(String msg, Throwable thr) {
		if (isEnable) {
			android.util.Log.e(TAG, buildMessage(msg), thr);
		}
	}

	/**
	 * Send a ERROR log message.
	 * 
	 * @param msg
	 *            The message you would like logged.
	 */
	public static void e(String tag, String msg) {
		if (isEnable) {
			if (tag == null || tag == "") {
				e(msg);
			} else {
				android.util.Log.e(TAG, buildMessage(msg));
			}
		}
	}

	/**
	 * Send a ERROR log message and log the exception.
	 * 
	 * @param msg
	 *            The message you would like logged.
	 * @param thr
	 *            An exception to log
	 */
	public static void e(String tag, String msg, Throwable thr) {
		if (isEnable) {
			if (tag == null || tag == "") {
				e(msg, thr);
			} else {
				android.util.Log.e(TAG, buildMessage(msg), thr);
			}
		}
	}

	/**
	 * Send a WARN log message
	 * 
	 * @param msg
	 *            The message you would like logged.
	 */
	public static void w(String msg) {
		if (isEnable) {
			android.util.Log.w(TAG, buildMessage(msg));
		}
	}

	/**
	 * Send a WARN log message and log the exception.
	 * 
	 * @param msg
	 *            The message you would like logged.
	 * @param thr
	 *            An exception to log
	 */
	public static void w(String msg, Throwable thr) {
		if (isEnable) {
			android.util.Log.w(TAG, buildMessage(msg), thr);
		}
	}

	/**
	 * Send an empty WARN log message and log the exception.
	 * 
	 * @param thr
	 *            An exception to log
	 */
	public static void w(Throwable thr) {
		if (isEnable) {
			android.util.Log.w(TAG, buildMessage(""), thr);
		}
	}

	/**
	 * Send a WARN log message.
	 * 
	 * @param msg
	 *            The message you would like logged.
	 */
	public static void w(String tag, String msg) {
		if (isEnable) {
			if (tag == null || tag == "") {
				w(msg);
			} else {
				android.util.Log.w(TAG, buildMessage(msg));
			}
		}
	}

	/**
	 * Send a WARN log message and log the exception.
	 * 
	 * @param msg
	 *            The message you would like logged.
	 * @param thr
	 *            An exception to log
	 */
	public static void w(String tag, String msg, Throwable thr) {
		if (isEnable) {
			if (tag == null || tag == "") {
				w(msg, thr);
			} else {
				android.util.Log.w(TAG, buildMessage(msg), thr);
			}
		}
	}

	/**
	 * Building Message
	 * 
	 * @param msg
	 *            The message you would like logged.
	 * @return Message String
	 */
	protected static String buildMessage(String msg) {
		StackTraceElement caller = new Throwable().fillInStackTrace()
				.getStackTrace()[2];

		return new StringBuilder().append(caller.getClassName()).append(".")
				.append(caller.getMethodName()).append("(): ").append(msg)
				.toString();
	}
}