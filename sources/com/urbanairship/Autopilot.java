package com.urbanairship;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.urbanairship.UAirship;

public class Autopilot implements UAirship.c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f713a;
    public static Autopilot b;

    public static synchronized void c(Application application) {
        synchronized (Autopilot.class) {
            d(application, false);
        }
    }

    public static synchronized void d(Application application, boolean z) {
        Bundle bundle;
        Autopilot autopilot;
        synchronized (Autopilot.class) {
            if (!UAirship.u) {
                if (!UAirship.v) {
                    if (!f713a) {
                        try {
                            ApplicationInfo applicationInfo = application.getPackageManager().getApplicationInfo(application.getPackageName(), 128);
                            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                                String string = bundle.getString("com.urbanairship.autopilot");
                                if (string != null) {
                                    try {
                                        autopilot = (Autopilot) Class.forName(string).newInstance();
                                    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
                                    }
                                    b = autopilot;
                                    f713a = true;
                                }
                                autopilot = null;
                                b = autopilot;
                                f713a = true;
                            } else {
                                return;
                            }
                        } catch (PackageManager.NameNotFoundException unused2) {
                            return;
                        }
                    }
                    Autopilot autopilot2 = b;
                    if (autopilot2 != null) {
                        if (z && !autopilot2.b()) {
                            return;
                        }
                        if (b.g()) {
                            AirshipConfigOptions f = b.f(application);
                            if (!UAirship.u) {
                                boolean z2 = UAirship.v;
                            }
                            UAirship.m(application, f, b);
                            b = null;
                        }
                    }
                }
            }
        }
    }

    public static void e(Context context) {
        d((Application) context.getApplicationContext(), false);
    }

    @Override // com.urbanairship.UAirship.c
    public void a(UAirship uAirship) {
        yj5.a("Airship ready!", new Object[0]);
    }

    public boolean b() {
        return true;
    }

    public AirshipConfigOptions f(Context context) {
        return null;
    }

    public boolean g() {
        return true;
    }
}
