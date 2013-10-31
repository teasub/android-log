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

                    if (file == null && !TextUtils.isEmpty(path)) {
                        file = new File(path);
                    }

                    if (file == null){
                        Log.e("Error","The Log file can not be found!");
                        return;
                    }

                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }

                    try {
                        out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
                        out.write(str);
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
