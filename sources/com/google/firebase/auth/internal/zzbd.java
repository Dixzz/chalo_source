package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.auth.AuthResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzbd {
    public static final long zza = 3600000;
    private static final List<String> zzb = new ArrayList(Arrays.asList("firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", "timestamp"));
    private static final zzbd zzc = new zzbd();
    private yi4<AuthResult> zzd;
    private yi4<String> zze;
    private long zzf = 0;

    private zzbd() {
    }

    public static zzbd zza() {
        return zzc;
    }

    private static final void zzf(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (String str : zzb) {
            edit.remove(str);
        }
        edit.commit();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x008a, code lost:
        if (r4.equals("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN") == false) goto L_0x00a1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.firebase.auth.FirebaseAuth r13) {
        /*
        // Method dump skipped, instructions count: 351
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzbd.zzb(com.google.firebase.auth.FirebaseAuth):void");
    }

    public final yi4<AuthResult> zzc() {
        if (System.currentTimeMillis() - this.zzf < zza) {
            return this.zzd;
        }
        return null;
    }

    public final yi4<String> zzd() {
        if (System.currentTimeMillis() - this.zzf < zza) {
            return this.zze;
        }
        return null;
    }

    public final void zze(Context context) {
        Objects.requireNonNull(context, "null reference");
        zzf(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        this.zzd = null;
        this.zzf = 0;
    }
}
