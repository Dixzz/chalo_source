package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import com.razorpay.AnalyticsConstants;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
public class GmsRpc {
    public static final String ERROR_INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";

    /* renamed from: app  reason: collision with root package name */
    private final FirebaseApp f662app;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final Provider<HeartBeatInfo> heartbeatInfo;
    private final Metadata metadata;
    private final o12 rpc;
    private final Provider<UserAgentPublisher> userAgentPublisher;

    public GmsRpc(FirebaseApp firebaseApp, Metadata metadata2, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this(firebaseApp, metadata2, new o12(firebaseApp.getApplicationContext()), provider, provider2, firebaseInstallationsApi);
    }

    public GmsRpc(FirebaseApp firebaseApp, Metadata metadata2, o12 o12, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this.f662app = firebaseApp;
        this.metadata = metadata2;
        this.rpc = o12;
        this.userAgentPublisher = provider;
        this.heartbeatInfo = provider2;
        this.firebaseInstallations = firebaseInstallationsApi;
    }

    private static String base64UrlSafe(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    private yi4<String> extractResponseWhenComplete(yi4<Bundle> yi4) {
        return yi4.i(FirebaseIidExecutors.directExecutor(), new GmsRpc$$Lambda$0(this));
    }

    private String getHashedFirebaseAppName() {
        try {
            return base64UrlSafe(MessageDigest.getInstance("SHA-1").digest(this.f662app.getName().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    private String handleResponse(Bundle bundle) throws IOException {
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string != null) {
                return string;
            }
            String string2 = bundle.getString("unregistered");
            if (string2 != null) {
                return string2;
            }
            String string3 = bundle.getString("error");
            if ("RST".equals(string3)) {
                throw new IOException("INSTANCE_ID_RESET");
            } else if (string3 != null) {
                throw new IOException(string3);
            } else {
                String.valueOf(bundle).length();
                new Throwable();
                throw new IOException(ERROR_SERVICE_NOT_AVAILABLE);
            }
        } else {
            throw new IOException(ERROR_SERVICE_NOT_AVAILABLE);
        }
    }

    public static boolean isErrorMessageForRetryableError(String str) {
        return ERROR_SERVICE_NOT_AVAILABLE.equals(str) || ERROR_INTERNAL_SERVER_ERROR.equals(str) || "InternalServerError".equals(str);
    }

    private Bundle setDefaultAttributesToBundle(String str, String str2, String str3, Bundle bundle) {
        HeartBeatInfo.HeartBeat heartBeatCode;
        bundle.putString("scope", str3);
        bundle.putString(AnalyticsConstants.SENDER, str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        bundle.putString("gmp_app_id", this.f662app.getOptions().getApplicationId());
        bundle.putString("gmsv", Integer.toString(this.metadata.getGmsVersionCode()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.metadata.getAppVersionCode());
        bundle.putString("app_ver_name", this.metadata.getAppVersionName());
        bundle.putString("firebase-app-name-hash", getHashedFirebaseAppName());
        try {
            String token = ((InstallationTokenResult) hd3.u(this.firebaseInstallations.getToken(false))).getToken();
            if (!TextUtils.isEmpty(token)) {
                bundle.putString("Goog-Firebase-Installations-Auth", token);
            }
        } catch (InterruptedException | ExecutionException unused) {
        }
        bundle.putString("cliv", "fiid-21.1.0");
        HeartBeatInfo heartBeatInfo = this.heartbeatInfo.get();
        UserAgentPublisher userAgentPublisher2 = this.userAgentPublisher.get();
        if (!(heartBeatInfo == null || userAgentPublisher2 == null || (heartBeatCode = heartBeatInfo.getHeartBeatCode("fire-iid")) == HeartBeatInfo.HeartBeat.NONE)) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(heartBeatCode.getCode()));
            bundle.putString("Firebase-Client", userAgentPublisher2.getUserAgent());
        }
        return bundle;
    }

    private yi4<Bundle> startRpc(String str, String str2, String str3, Bundle bundle) {
        setDefaultAttributesToBundle(str, str2, str3, bundle);
        return this.rpc.a(bundle);
    }

    public yi4<?> deleteInstanceId(String str) {
        return extractResponseWhenComplete(startRpc(str, "*", "*", hj1.c("iid-operation", "delete", "delete", "1")));
    }

    public yi4<?> deleteToken(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("delete", "1");
        return extractResponseWhenComplete(startRpc(str, str2, str3, bundle));
    }

    public yi4<String> getToken(String str, String str2, String str3) {
        return extractResponseWhenComplete(startRpc(str, str2, str3, new Bundle()));
    }

    public final /* synthetic */ String lambda$extractResponseWhenComplete$0$GmsRpc(yi4 yi4) throws Exception {
        return handleResponse((Bundle) yi4.n(IOException.class));
    }

    public yi4<?> subscribeToTopic(String str, String str2, String str3) {
        String str4;
        String str5;
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        if (valueOf.length() != 0) {
            str4 = "/topics/".concat(valueOf);
        } else {
            str4 = new String("/topics/");
        }
        bundle.putString("gcm.topic", str4);
        String valueOf2 = String.valueOf(str3);
        if (valueOf2.length() != 0) {
            str5 = "/topics/".concat(valueOf2);
        } else {
            str5 = new String("/topics/");
        }
        return extractResponseWhenComplete(startRpc(str, str2, str5, bundle));
    }

    public yi4<?> unsubscribeFromTopic(String str, String str2, String str3) {
        String str4;
        String str5;
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        if (valueOf.length() != 0) {
            str4 = "/topics/".concat(valueOf);
        } else {
            str4 = new String("/topics/");
        }
        bundle.putString("gcm.topic", str4);
        bundle.putString("delete", "1");
        String valueOf2 = String.valueOf(str3);
        if (valueOf2.length() != 0) {
            str5 = "/topics/".concat(valueOf2);
        } else {
            str5 = new String("/topics/");
        }
        return extractResponseWhenComplete(startRpc(str, str2, str5, bundle));
    }
}
