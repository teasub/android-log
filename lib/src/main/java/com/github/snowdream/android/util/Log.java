package com.github.snowdream.android.util;

import android.text.TextUtils;

import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;

/**
 * Wrapper API for sending log output <BR /><BR />
 * <p/>
 * 1.enable/disable log
 * <pre>
 * Log.setEnabled(true);
 * Log.setEnabled(false);
 * </pre>
 * <p/>
 * 2.set the Tag for the log
 * Log.setTag("Android");
 * </pre>
 * <p/>
 * 3.log simple
 * <pre>
 * Log.d("test");
 * Log.v("test");
 * Log.i("test");
 * Log.w("test");
 * Log.e("test");
 * </pre>
 * <p/>
 * 4.log simple -- set custom tag
 * <pre>
 * Log.d("TAG","test");
 * Log.v("TAG","test");
 * Log.i("TAG","test");
 * Log.w("TAG","test");
 * Log.e("TAG","test");
 * </pre>
 * <p/>
 * 5.log advance
 * <pre>
 * Log.d("test",new Throwable("test"));
 * Log.v("test",new Throwable("test"));
 * Log.i("test",new Throwable("test"));
 * Log.w("test",new Throwable("test"));
 * Log.e("test",new Throwable("test"));
 * </pre>
 * <p/>
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
     * None
     */
    public static final int LOG_NONE_TO_FILE = 0;

    /**
     * WARN
     */
    public static final int LOG_WARN_TO_FILE = 1;

    /**
     * ERROR
     */
    public static final int LOG_ERROR_TO_FILE = 2;

    /**
     * ALL
     */
    public static final int LOG_ALL_TO_FILE = 3;

    private enum TYPE {
        INFO, DEBUG, VERBOSE, WARN, ERROR
    }

    /**
     * Whether to enable the log
     */
    protected static boolean isEnable = true;

    /**
     * Which will be logged into the file
     */
    protected static int policy = LOG_NONE_TO_FILE;

    /**
     * The log dir path
     */
    protected static String logDirPath = "/mnt/sdcard/snowdream/log";

    /**
     * The log file base name
     */
    protected static String logFileBaseName = "snowdream";

    /**
     * The log file suffix,such as log.
     */
    protected static String logFileSuffix = "log";

    /**
     * The log file path
     */
    protected static String path = "";

    /**
     * the constructor
     */
    private Log() {
    }

    /**
     * Get the Tag of the application
     */
    public static String getTag() {
        return TAG;
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
     * is the log enabled?
     *
     */
    public static boolean isEnabled() {
        return isEnable;
    }

    /**
     * enable or disable the log
     *
     * @param enabled whether to enable the log
     */
    public static void setEnabled(boolean enabled) {
        isEnable = enabled;
    }

    /**
     * get the policy of the log
     *
     * @return the policy of the log
     */
    public static int getPolicy() {
        return policy;
    }

    /**
     * set the policy of the log
     *
     * @param policy the policy of the log
     */
    public static void setPolicy(int policy) {
        Log.policy = policy;
    }

    /**
     * set the log file path
     *
     * The log file path will be: logDirPath + logFileBaseName + Formated time +logFileSuffix
     *
     *
     * @param logDirPath the log file dir path,such as "/mnt/sdcard/snowdream/log"
     * @param logFileBaseName the log file base file name,such as "log"
     * @param logFileSuffix  the log file suffix,such as "log"
     */
    public static void setPath(String logDirPath, String logFileBaseName, String logFileSuffix) {
        if (!TextUtils.isEmpty(logDirPath)) {
            Log.logDirPath = logDirPath;
        }

        if (!TextUtils.isEmpty(logFileBaseName)) {
            Log.logFileBaseName = logFileBaseName;
        }

        if (!TextUtils.isEmpty(logFileSuffix)) {
            Log.logFileSuffix = logFileSuffix;
        }

        Date myDate = new Date();
        FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM-dd-HH-mm-ss");
        String myDateString = fdf.format(myDate);

        StringBuffer buffer = new StringBuffer();
        buffer.append(logDirPath);
        buffer.append("/");
        buffer.append(logFileBaseName);
        buffer.append("-");
        buffer.append(myDateString);
        buffer.append(".");
        buffer.append(logFileSuffix);

        if (TextUtils.isEmpty(path)) {
            path = buffer.toString();
        }
    }

    /**
     * get the log file path
     *
     * @return path
     */
    public static String getPath() {
        return path;
    }

    /**
     * set the path of the log file
     *
     * @param path
     */
    public static void setPath(String path) {
        Log.path = path;
    }

    /**
     * Send a VERBOSE log message.
     *
     * @param msg The message you would like logged.
     */
    public static void v(String msg) {
        if (isEnable) {
            android.util.Log.v(TAG, buildMessage(TYPE.VERBOSE, TAG, msg));
        }
    }

    /**
     * Send a VERBOSE log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void v(String msg, Throwable thr) {
        if (isEnable) {
            android.util.Log.v(TAG, buildMessage(TYPE.VERBOSE, TAG, msg), thr);
        }
    }

    /**
     * Send a VERBOSE log message.
     *
     * @param msg The message you would like logged.
     */
    public static void v(String tag, String msg) {
        if (isEnable) {
            if (tag == null || tag == "") {
                v(msg);
            } else {
                android.util.Log.v(TAG, buildMessage(TYPE.VERBOSE, TAG, msg));
            }
        }
    }

    /**
     * Send a VERBOSE log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void v(String tag, String msg, Throwable thr) {
        if (isEnable) {
            if (tag == null || tag == "") {
                v(msg, thr);
            } else {
                android.util.Log.v(TAG, buildMessage(TYPE.VERBOSE, TAG, msg), thr);
            }
        }
    }

    /**
     * Send a DEBUG log message.
     */
    public static void d(String msg) {
        if (isEnable) {
            android.util.Log.d(TAG, buildMessage(TYPE.DEBUG, TAG, msg));
        }
    }

    /**
     * Send a DEBUG log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void d(String msg, Throwable thr) {
        if (isEnable) {
            android.util.Log.d(TAG, buildMessage(TYPE.DEBUG, TAG, msg), thr);
        }
    }

    /**
     * Send a DEBUG log message.
     *
     * @param msg The message you would like logged.
     */
    public static void d(String tag, String msg) {
        if (isEnable) {
            if (tag == null || tag == "") {
                d(msg);
            } else {
                android.util.Log.d(TAG, buildMessage(TYPE.DEBUG, TAG, msg));
            }
        }
    }

    /**
     * Send a DEBUG log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void d(String tag, String msg, Throwable thr) {
        if (isEnable) {
            if (tag == null || tag == "") {
                d(msg, thr);
            } else {
                android.util.Log.d(TAG, buildMessage(TYPE.DEBUG, TAG, msg), thr);
            }
        }
    }

    /**
     * Send an INFO log message.
     *
     * @param msg The message you would like logged.
     */
    public static void i(String msg) {
        if (isEnable) {
            android.util.Log.i(TAG, buildMessage(TYPE.INFO, TAG, msg));
        }
    }

    /**
     * Send a INFO log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void i(String msg, Throwable thr) {
        if (isEnable) {
            android.util.Log.i(TAG, buildMessage(TYPE.INFO, TAG, msg), thr);
        }
    }

    /**
     * Send a INFO log message.
     *
     * @param msg The message you would like logged.
     */
    public static void i(String tag, String msg) {
        if (isEnable) {
            if (tag == null || tag == "") {
                i(msg);
            } else {
                android.util.Log.i(TAG, buildMessage(TYPE.INFO, TAG, msg));
            }
        }
    }

    /**
     * Send a INFO log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void i(String tag, String msg, Throwable thr) {
        if (isEnable) {
            if (tag == null || tag == "") {
                i(msg, thr);
            } else {
                android.util.Log.i(TAG, buildMessage(TYPE.INFO, TAG, msg), thr);
            }
        }
    }

    /**
     * Send an ERROR log message.
     *
     * @param msg The message you would like logged.
     */
    public static void e(String msg) {
        if (isEnable) {
            android.util.Log.e(TAG, buildMessage(TYPE.ERROR, TAG, msg));
        }
    }

    /**
     * Send an ERROR log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void e(String msg, Throwable thr) {
        if (isEnable) {
            android.util.Log.e(TAG, buildMessage(TYPE.ERROR, TAG, msg), thr);
        }
    }

    /**
     * Send a ERROR log message.
     *
     * @param msg The message you would like logged.
     */
    public static void e(String tag, String msg) {
        if (isEnable) {
            if (tag == null || tag == "") {
                e(msg);
            } else {
                android.util.Log.e(TAG, buildMessage(TYPE.ERROR, TAG, msg));
            }
        }
    }

    /**
     * Send a ERROR log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void e(String tag, String msg, Throwable thr) {
        if (isEnable) {
            if (tag == null || tag == "") {
                e(msg, thr);
            } else {
                android.util.Log.e(TAG, buildMessage(TYPE.ERROR, TAG, msg), thr);
            }
        }
    }

    /**
     * Send a WARN log message
     *
     * @param msg The message you would like logged.
     */
    public static void w(String msg) {
        if (isEnable) {
            android.util.Log.w(TAG, buildMessage(TYPE.WARN, TAG, msg));
        }
    }

    /**
     * Send a WARN log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void w(String msg, Throwable thr) {
        if (isEnable) {
            android.util.Log.w(TAG, buildMessage(TYPE.WARN, TAG, msg), thr);
        }
    }

    /**
     * Send an empty WARN log message and log the exception.
     *
     * @param thr An exception to log
     */
    public static void w(Throwable thr) {
        if (isEnable) {
            android.util.Log.w(TAG, buildMessage(TYPE.WARN, TAG, ""), thr);
        }
    }

    /**
     * Send a WARN log message.
     *
     * @param msg The message you would like logged.
     */
    public static void w(String tag, String msg) {
        if (isEnable) {
            if (tag == null || tag == "") {
                w(msg);
            } else {
                android.util.Log.w(TAG, buildMessage(TYPE.WARN, TAG, msg));
            }
        }
    }

    /**
     * Send a WARN log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param thr An exception to log
     */
    public static void w(String tag, String msg, Throwable thr) {
        if (isEnable) {
            if (tag == null || tag == "") {
                w(msg, thr);
            } else {
                android.util.Log.w(TAG, buildMessage(TYPE.WARN, TAG, msg), thr);
            }
        }
    }

    /**
     * Building Message
     *
     * @param msg The message you would like logged.
     * @return Message String
     */
    protected static String buildMessage(TYPE type, String tag, String msg) {
        StackTraceElement caller = new Throwable().fillInStackTrace()
                .getStackTrace()[2];

        boolean isLog2File = false;

        switch (policy) {
            case LOG_NONE_TO_FILE:
                isLog2File = false;
                break;
            case LOG_WARN_TO_FILE:
                if (type == TYPE.WARN) {
                    isLog2File = true;
                } else {
                    isLog2File = false;
                }
                break;
            case LOG_ERROR_TO_FILE:
                if (type == TYPE.ERROR) {
                    isLog2File = true;
                } else {
                    isLog2File = false;
                }
                break;
            case LOG_ALL_TO_FILE:
                isLog2File = true;
                break;
            default:
                break;
        }

        if (isLog2File) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(type.name());
            buffer.append("    ");
            buffer.append(tag);
            buffer.append("    ");
            buffer.append(caller.getClassName());
            buffer.append("");
            buffer.append(caller.getMethodName());
            buffer.append("(): ");
            buffer.append(msg);
            com.github.snowdream.android.util.Log2File.log2file(path, buffer.toString());
        }

        return new StringBuffer().append(caller.getClassName()).append("")
                .append(caller.getMethodName()).append("(): ").append(msg)
                .toString();
    }
}