package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import defpackage.a32;
import defpackage.x22;
import java.util.Collections;
import java.util.Set;

/* renamed from: z72  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public abstract class z72<T extends IInterface> extends w72<T> implements x22.f, k92 {
    private final x72 zaa;
    private final Set<Scope> zab;
    private final Account zac;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public z72(@androidx.annotation.RecentlyNonNull android.content.Context r9, @androidx.annotation.RecentlyNonNull android.os.Handler r10, int r11, @androidx.annotation.RecentlyNonNull defpackage.x72 r12) {
        /*
            r8 = this;
            a82 r3 = defpackage.a82.a(r9)
            java.lang.Object r0 = defpackage.q22.c
            q22 r4 = defpackage.q22.d
            r6 = 0
            r7 = 0
            r0 = r8
            r1 = r9
            r2 = r10
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            java.lang.String r9 = "null reference"
            java.util.Objects.requireNonNull(r12, r9)
            r8.zaa = r12
            android.accounts.Account r9 = r12.f3896a
            r8.zac = r9
            java.util.Set<com.google.android.gms.common.api.Scope> r9 = r12.c
            java.util.Set r9 = r8.zaa(r9)
            r8.zab = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z72.<init>(android.content.Context, android.os.Handler, int, x72):void");
    }

    private final Set<Scope> zaa(Set<Scope> set) {
        Set<Scope> validateScopes = validateScopes(set);
        for (Scope scope : validateScopes) {
            if (!set.contains(scope)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return validateScopes;
    }

    @Override // defpackage.w72
    @RecentlyNullable
    public final Account getAccount() {
        return this.zac;
    }

    @RecentlyNonNull
    public final x72 getClientSettings() {
        return this.zaa;
    }

    @RecentlyNonNull
    public Feature[] getRequiredFeatures() {
        return new Feature[0];
    }

    @Override // defpackage.w72
    @RecentlyNonNull
    public final Set<Scope> getScopes() {
        return this.zab;
    }

    @Override // defpackage.x22.f
    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        return requiresSignIn() ? this.zab : Collections.emptySet();
    }

    public Set<Scope> validateScopes(@RecentlyNonNull Set<Scope> set) {
        return set;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public z72(@androidx.annotation.RecentlyNonNull android.content.Context r10, @androidx.annotation.RecentlyNonNull android.os.Looper r11, int r12, @androidx.annotation.RecentlyNonNull defpackage.x72 r13) {
        /*
            r9 = this;
            a82 r3 = defpackage.a82.a(r10)
            java.lang.Object r0 = defpackage.q22.c
            q22 r4 = defpackage.q22.d
            r7 = 0
            r8 = 0
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z72.<init>(android.content.Context, android.os.Looper, int, x72):void");
    }

    @Deprecated
    public z72(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, int i, @RecentlyNonNull x72 x72, @RecentlyNonNull a32.b bVar, @RecentlyNonNull a32.c cVar) {
        this(context, looper, i, x72, (n32) bVar, (w32) cVar);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public z72(@androidx.annotation.RecentlyNonNull android.content.Context r10, @androidx.annotation.RecentlyNonNull android.os.Looper r11, int r12, @androidx.annotation.RecentlyNonNull defpackage.x72 r13, @androidx.annotation.RecentlyNonNull defpackage.n32 r14, @androidx.annotation.RecentlyNonNull defpackage.w32 r15) {
        /*
            r9 = this;
            a82 r3 = defpackage.a82.a(r10)
            java.lang.Object r0 = defpackage.q22.c
            q22 r4 = defpackage.q22.d
            java.lang.String r0 = "null reference"
            java.util.Objects.requireNonNull(r14, r0)
            java.util.Objects.requireNonNull(r15, r0)
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z72.<init>(android.content.Context, android.os.Looper, int, x72, n32, w32):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public z72(@androidx.annotation.RecentlyNonNull android.content.Context r12, @androidx.annotation.RecentlyNonNull android.os.Looper r13, @androidx.annotation.RecentlyNonNull defpackage.a82 r14, @androidx.annotation.RecentlyNonNull defpackage.q22 r15, int r16, @androidx.annotation.RecentlyNonNull defpackage.x72 r17, defpackage.n32 r18, defpackage.w32 r19) {
        /*
            r11 = this;
            r9 = r11
            r10 = r17
            r0 = r18
            r1 = r19
            r2 = 0
            if (r0 != 0) goto L_0x000c
            r6 = r2
            goto L_0x0012
        L_0x000c:
            i92 r3 = new i92
            r3.<init>(r0)
            r6 = r3
        L_0x0012:
            if (r1 != 0) goto L_0x0016
            r7 = r2
            goto L_0x001c
        L_0x0016:
            j92 r0 = new j92
            r0.<init>(r1)
            r7 = r0
        L_0x001c:
            java.lang.String r8 = r10.f
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r9.zaa = r10
            android.accounts.Account r0 = r10.f3896a
            r9.zac = r0
            java.util.Set<com.google.android.gms.common.api.Scope> r0 = r10.c
            java.util.Set r0 = r11.zaa(r0)
            r9.zab = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z72.<init>(android.content.Context, android.os.Looper, a82, q22, int, x72, n32, w32):void");
    }
}
