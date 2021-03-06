/*
 * Copyright (C) 2017 The LineageOS Project
 * Copyright (C) 2017 The halogenOS Project
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

package org.cyanogenmod.hardware;

import org.halogenos.io.FileUtils;

import java.io.File;
/*
 * Disable capacitive keys
 *
 * This is intended for use on devices in which the capacitive keys
 * can be fully disabled for replacement with a soft navbar. You
 * really should not be using this on a device with mechanical or
 * otherwise visible-when-inactive keys
 */

public class KeyDisabler {

    private static String CONTROL_PATH = "/proc/touchpanel/capacitive_keys_disable";

    public static boolean isSupported() {
        return FileUtils.isFileWritable(CONTROL_PATH);
    }

    public static boolean isActive() {
        return FileUtils.readString(new File(CONTROL_PATH), true).equals("0");
    }

    public static boolean setActive(boolean state) {
        return FileUtils.writeString(CONTROL_PATH, (state ? "0" : "1"));
    }

}
