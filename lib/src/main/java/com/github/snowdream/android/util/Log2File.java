package com.github.snowdream.android.util;

import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by snowdream on 10/20/13.
 */
public class Log2File {

    private static File file = null;

    private static ExecutorService executor = null;

    public static void log2file(final String path, final String str) {
        if (executor == null) {
            executor = Executors.newCachedThreadPool();
        }

        if (executor != null) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    PrintWriter out = null;

                    if (TextUtils.isEmpty(path)) {
                        Log.e("Error", "The path of Log file is Null.");
                        return;
                    }

                    if (file == null && !TextUtils.isEmpty(path)) {
                        file = new File(path);
                    }

                    /**
                     * checkout
                     */
                    boolean ret = true;
                    boolean exist = true;

                    exist = file.getParentFile().exists();
                    if (!exist) {
                        ret = file.getParentFile().mkdirs();

                        if (!ret) {
                            Log.e("Error", "The Log Dir can not be created!");
                            return;
                        }

                        Log.i("Success", "The Log Dir was successfully created! -" + file.getParent());
                    }

                    exist = file.exists();
                    if (!exist) {
                        try {
                            ret = file.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        if (!ret) {
                            Log.e("Error", "The Log file can not be created!");
                            return;
                        }

                        Log.i("Success", "The Log file was successfully created! -" + file.getAbsolutePath());
                    }

                    try {
                        out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
                        out.println(str);
                        out.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        out.close();
                    }
                }
            });
        }
    }

}
