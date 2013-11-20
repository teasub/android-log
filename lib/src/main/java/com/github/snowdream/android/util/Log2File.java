/*
 * Copyright (C) 2013 Snowdream Mobile (yanghui1986527@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
            executor = Executors.newSingleThreadExecutor();
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

                    file = new File(path);

                    if (!file.exists()) {
                        Log.e("Error", "The Log file does not exist.");
                        return;
                    }

                    if (!file.canWrite()) {
                        Log.e("Error", "The Log file can not be written.");
                        return;
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
