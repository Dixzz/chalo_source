package com.google.firebase.perf.util;

import android.content.Context;
import android.content.res.Resources;
import com.google.firebase.perf.logging.AndroidLogger;
import java.net.URI;

public class URLWhitelist {
    private static String[] whitelistedDomains;

    public static boolean isURLWhitelisted(URI uri, Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("firebase_performance_whitelisted_domains", "array", context.getPackageName());
        if (identifier == 0) {
            return true;
        }
        AndroidLogger.getInstance().info("Detected domain whitelist, only whitelisted domains will be measured.", new Object[0]);
        if (whitelistedDomains == null) {
            whitelistedDomains = resources.getStringArray(identifier);
        }
        String host = uri.getHost();
        if (host == null) {
            return true;
        }
        for (String str : whitelistedDomains) {
            if (host.contains(str)) {
                return true;
            }
        }
        return false;
    }
}
