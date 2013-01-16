/**
 * Copyright (C) 2012 yanghui <yanghui1986527@gmail.com>
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.snowdream.android;

/**
 * Wrapper API for sending log output
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
	 * @param tag the Tag of the application
	 */
	public static void setTag(String tag) {
		TAG = tag;
	}

	/**
	 * enable or disable the log
	 * @param enabled whether to enable the log
	 */
	public static void setEnabled(boolean enabled) {
		isEnable = enabled;
	}

	/**
	 * Send a VERBOSE log message.
	 * @param msg The message you would like logged.
	 */
	public static void v(String msg) {
		if (isEnable) {
			android.util.Log.v(TAG, buildMessage(msg));
		}
	}

	/**
	 * Send a VERBOSE log message and log the exception.
	 * @param msg The message you would like logged.
	 * @param thr An exception to log
	 */
	public static void v(String msg, Throwable thr) {
		if (isEnable) {
			android.util.Log.v(TAG, buildMessage(msg), thr);
		}
	}

	/**
	 * Send a DEBUG log message.
	 * @param msg
	 */
	public static void d(String msg) {
		if (isEnable) {
			android.util.Log.d(TAG, buildMessage(msg));
		}
	}

	/**
	 * Send a DEBUG log message and log the exception.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	public static void d(String msg, Throwable thr) {
		if (isEnable) {
			android.util.Log.d(TAG, buildMessage(msg), thr);
		}
	}

	/**
	 * Send an INFO log message.
	 * @param msg The message you would like logged.
	 */
	public static void i(String msg) {
		if (isEnable) {
			android.util.Log.i(TAG, buildMessage(msg));
		}
	}

	/**
	 * Send a INFO log message and log the exception.
	 * @param msg The message you would like logged.
	 * @param thr An exception to log
	 */
	public static void i(String msg, Throwable thr) {
		if (isEnable) {
			android.util.Log.i(TAG, buildMessage(msg), thr);
		}
	}

	/**
	 * Send an ERROR log message.
	 * @param msg The message you would like logged.
	 */
	public static void e(String msg) {
		if (isEnable) {
			android.util.Log.e(TAG, buildMessage(msg));
		}
	}

	/**
	 * Send a WARN log message
	 * @param msg The message you would like logged.
	 */
	public static void w(String msg) {
		if (isEnable) {
			android.util.Log.w(TAG, buildMessage(msg));
		}
	}

	/**
	 * Send a WARN log message and log the exception.
	 * @param msg The message you would like logged.
	 * @param thr An exception to log
	 */
	public static void w(String msg, Throwable thr) {
		if (isEnable) {
			android.util.Log.w(TAG, buildMessage(msg), thr);
		}
	}

	/**
	 * Send an empty WARN log message and log the exception.
	 * @param thr An exception to log
	 */
	public static void w(Throwable thr) {
		if (isEnable) {
			android.util.Log.w(TAG, buildMessage(""), thr);
		}
	}

	/**
	 * Send an ERROR log message and log the exception.
	 * @param msg The message you would like logged.
	 * @param thr An exception to log
	 */
	public static void e(String msg, Throwable thr) {
		if (isEnable) {
			android.util.Log.e(TAG, buildMessage(msg), thr);
		}
	}

	/**
	 * Building Message
	 * @param msg The message you would like logged.
	 * @return Message String
	 */
	protected static String buildMessage(String msg) {
		StackTraceElement caller = new Throwable().fillInStackTrace().getStackTrace()[2];

		return new StringBuilder()
		.append(caller.getClassName())
		.append(".")
		.append(caller.getMethodName())
		.append("(): ")
		.append(msg).toString();
	}
}