package com.truecaller.android.sdk;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import com.truecaller.android.sdk.clients.VerificationCallback;
import java.util.Locale;

@Keep
public final class TruecallerSDK {
    public static final int SHARE_PROFILE_REQUEST_CODE = 100;
    private static TruecallerSDK sInstance;
    private final sg5 mTcClientManager;

    private TruecallerSDK(sg5 sg5) {
        this.mTcClientManager = sg5;
    }

    public static void clear() {
        TruecallerSDK truecallerSDK = sInstance;
        if (truecallerSDK != null) {
            xg5 xg5 = truecallerSDK.mTcClientManager.f3212a;
            if (xg5 != null && xg5.c == 2) {
                ah5 ah5 = (ah5) xg5;
                if (ah5.k != null) {
                    ah5.d();
                    ah5.k = null;
                }
                ah5.l = null;
                Handler handler = ah5.m;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                    ah5.m = null;
                }
            }
            sInstance.mTcClientManager.f3212a = null;
            sg5.b = null;
            sInstance = null;
        }
    }

    public static TruecallerSDK getInstance() throws RuntimeException {
        TruecallerSDK truecallerSDK = sInstance;
        if (truecallerSDK != null) {
            return truecallerSDK;
        }
        throw new RuntimeException(TrueException.TYPE_SDK_NOT_INITIALIZED);
    }

    @Deprecated
    public static synchronized void init(Context context, ITrueCallback iTrueCallback) throws RuntimeException {
        ApplicationInfo applicationInfo;
        synchronized (TruecallerSDK.class) {
            Context applicationContext = context.getApplicationContext();
            try {
                applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
            } catch (PackageManager.NameNotFoundException unused) {
                applicationInfo = null;
            }
            String p1 = hd3.p1(applicationInfo);
            if (!TextUtils.isEmpty(p1)) {
                sg5 sg5 = new sg5(applicationContext, iTrueCallback, p1);
                sg5.b = sg5;
                sInstance = new TruecallerSDK(sg5);
            } else {
                throw new RuntimeException(TrueException.TYPE_PARTNER_KEY);
            }
        }
    }

    public void getUserProfile(ve veVar) {
        if (isUsable()) {
            xg5 xg5 = this.mTcClientManager.f3212a;
            if (xg5.c == 1) {
                yg5 yg5 = (yg5) xg5;
                try {
                    Intent a2 = yg5.a(veVar);
                    if (a2 == null) {
                        yg5.b(veVar, 11);
                    } else {
                        veVar.startActivityForResult(a2, 100);
                    }
                } catch (ActivityNotFoundException unused) {
                    yg5.b(veVar, 15);
                }
            } else {
                hd3.Q2(veVar);
                ((dh5) ((ah5) xg5).h).c.onVerificationRequired(null);
            }
        } else {
            throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
        }
    }

    public boolean isUsable() {
        return this.mTcClientManager.f3212a != null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0087 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onActivityResultObtained(defpackage.ve r4, int r5, int r6, android.content.Intent r7) {
        /*
        // Method dump skipped, instructions count: 145
        */
        throw new UnsupportedOperationException("Method not decompiled: com.truecaller.android.sdk.TruecallerSDK.onActivityResultObtained(ve, int, int, android.content.Intent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d5, code lost:
        if (r4.booleanValue() != false) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x011f, code lost:
        if (r5.booleanValue() != false) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0121, code lost:
        r11 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008d A[Catch:{ NameNotFoundException -> 0x00a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x012c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void requestVerification(java.lang.String r14, java.lang.String r15, com.truecaller.android.sdk.clients.VerificationCallback r16, defpackage.ve r17) {
        /*
        // Method dump skipped, instructions count: 334
        */
        throw new UnsupportedOperationException("Method not decompiled: com.truecaller.android.sdk.TruecallerSDK.requestVerification(java.lang.String, java.lang.String, com.truecaller.android.sdk.clients.VerificationCallback, ve):void");
    }

    public void setLocale(Locale locale) {
        if (isUsable()) {
            this.mTcClientManager.f3212a.f = locale;
            return;
        }
        throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
    }

    public void setRequestNonce(String str) {
        if (isUsable()) {
            this.mTcClientManager.f3212a.e = str;
            return;
        }
        throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
    }

    public void setTheme(int i) {
        if (isUsable()) {
            this.mTcClientManager.f3212a.g = i;
            return;
        }
        throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
    }

    public void updateCallback(ITrueCallback iTrueCallback) {
        if (isUsable()) {
            sg5.b.f3212a.b = iTrueCallback;
            return;
        }
        throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
    }

    public void verifyMissedCall(TrueProfile trueProfile, VerificationCallback verificationCallback) {
        if (isUsable()) {
            xg5 xg5 = this.mTcClientManager.f3212a;
            if (xg5.c == 2) {
                ah5 ah5 = (ah5) xg5;
                ch5 ch5 = ah5.h;
                String str = ah5.d;
                dh5 dh5 = (dh5) ch5;
                String str2 = dh5.i;
                if (str2 != null) {
                    dh5.b(trueProfile, str2, str, verificationCallback);
                } else {
                    verificationCallback.onRequestFailure(5, new TrueException(3, TrueException.TYPE_MISSING_CREATE_CALL_MESSAGE));
                }
            }
        } else {
            throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
        }
    }

    public void verifyOtp(TrueProfile trueProfile, String str, VerificationCallback verificationCallback) {
        if (isUsable()) {
            xg5 xg5 = this.mTcClientManager.f3212a;
            if (xg5.c == 2) {
                ah5 ah5 = (ah5) xg5;
                ((dh5) ah5.h).b(trueProfile, str, ah5.d, verificationCallback);
                return;
            }
            return;
        }
        throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
    }

    public static synchronized void init(TruecallerSdkScope truecallerSdkScope) {
        synchronized (TruecallerSDK.class) {
            sg5 sg5 = new sg5(truecallerSdkScope);
            sg5.b = sg5;
            sInstance = new TruecallerSDK(sg5);
        }
    }

    public void getUserProfile(Fragment fragment) {
        if (isUsable()) {
            xg5 xg5 = this.mTcClientManager.f3212a;
            if (xg5.c == 1) {
                yg5 yg5 = (yg5) xg5;
                ve activity = fragment.c();
                if (activity != null) {
                    try {
                        Intent a2 = yg5.a(activity);
                        if (a2 == null) {
                            yg5.b(activity, 11);
                        } else {
                            fragment.startActivityForResult(a2, 100);
                        }
                    } catch (ActivityNotFoundException unused) {
                        yg5.b(activity, 15);
                    }
                }
            } else {
                hd3.Q2(fragment.c());
                ((dh5) ((ah5) xg5).h).c.onVerificationRequired(null);
            }
        } else {
            throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
        }
    }
}
