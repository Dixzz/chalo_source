package com.urbanairship.modules;

import com.urbanairship.AirshipVersionInfo;
import com.urbanairship.UAirship;

public class Modules {
    public static <T extends AirshipVersionInfo> T a(String str, Class<T> cls) {
        try {
            T t = (T) ((AirshipVersionInfo) Class.forName(str).asSubclass(cls).newInstance());
            Object obj = UAirship.t;
            if ("14.6.0".equals(t.getAirshipVersion())) {
                return t;
            }
            yj5.c("Unable to load module with factory %s, versions do not match. Core Version: %s, Module Version: %s.", cls, "14.6.0", t.getAirshipVersion());
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Exception e) {
            yj5.e(e, "Unable to create module factory %s", cls);
            return null;
        }
    }
}
