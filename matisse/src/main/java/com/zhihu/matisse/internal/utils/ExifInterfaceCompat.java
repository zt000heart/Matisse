/*
 * Copyright 2017 Zhihu Inc.
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
package com.zhihu.matisse.internal.utils;

import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Bug fixture for ExifInterface constructor.
 */
final class ExifInterfaceCompat {

    /**
     * Do not instantiate this class.
     */
    private ExifInterfaceCompat() {
    }

    /**
     * Creates new instance of {@link ExifInterface}.
     * Original constructor won't check filename value, so if null value has been passed,
     * the process will be killed because of SIGSEGV.
     * Google Play crash report system cannot perceive this crash, so this method will throw
     * {@link NullPointerException} when the filename is null.
     *
     * @param filename a JPEG filename.
     * @return {@link ExifInterface} instance.
     * @throws IOException something wrong with I/O.
     */
    public static ExifInterface newInstance(String filename) throws IOException {
        if (filename == null) throw new NullPointerException("filename should not be null");
        return new ExifInterface(filename);
    }
}