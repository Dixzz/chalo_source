package defpackage;

import android.accounts.Account;
import android.view.View;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nullable;

/* renamed from: x72  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class x72 {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final Account f3896a;
    public final Set<Scope> b;
    public final Set<Scope> c;
    public final Map<x22<?>, c92> d;
    public final String e;
    public final String f;
    public final zh4 g;
    public Integer h;

    /* renamed from: x72$a */
    /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
    public static final class a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public Account f3897a;
        public p2<Scope> b;
        public String c;
        public String d;

        @RecentlyNonNull
        public x72 a() {
            return new x72(this.f3897a, this.b, null, 0, null, this.c, this.d, zh4.f);
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroid/accounts/Account;Ljava/util/Set<Lcom/google/android/gms/common/api/Scope;>;Ljava/util/Map<Lx22<*>;Lc92;>;ILandroid/view/View;Ljava/lang/String;Ljava/lang/String;Lzh4;Z)V */
    public x72(@Nullable Account account, @RecentlyNonNull Set set, @RecentlyNonNull Map map, int i, @Nullable View view, @RecentlyNonNull String str, @RecentlyNonNull String str2, @Nullable zh4 zh4) {
        this.f3896a = account;
        Set<Scope> emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.b = emptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.d = map;
        this.e = str;
        this.f = str2;
        this.g = zh4 == null ? zh4.f : zh4;
        HashSet hashSet = new HashSet(emptySet);
        for (c92 c92 : map.values()) {
            Objects.requireNonNull(c92);
            hashSet.addAll(null);
        }
        this.c = Collections.unmodifiableSet(hashSet);
    }
}
