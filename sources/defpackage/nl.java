package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import defpackage.pm;
import defpackage.wl;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* renamed from: nl  reason: default package */
/* compiled from: DatabaseConfiguration */
public class nl {

    /* renamed from: a  reason: collision with root package name */
    public final pm.c f2572a;
    public final Context b;
    public final String c;
    public final wl.d d;
    public final List<wl.b> e;
    public final List<Object> f = Collections.emptyList();
    public final List<em> g = Collections.emptyList();
    public final boolean h;
    public final wl.c i;
    public final Executor j;
    public final Executor k;
    public final boolean l;
    public final boolean m;

    /* JADX WARN: Incorrect args count in method signature: (Landroid/content/Context;Ljava/lang/String;Lpm$c;Lwl$d;Ljava/util/List<Lwl$b;>;ZLwl$c;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;ZZZLjava/util/Set<Ljava/lang/Integer;>;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable<Ljava/io/InputStream;>;Ljava/lang/Object;Ljava/util/List<Ljava/lang/Object;>;Ljava/util/List<Lem;>;)V */
    @SuppressLint({"LambdaLast"})
    public nl(Context context, String str, pm.c cVar, wl.d dVar, List list, boolean z, wl.c cVar2, Executor executor, Executor executor2, boolean z2, boolean z3, boolean z4, Set set, String str2, File file, Callable callable, List list2, List list3) {
        this.f2572a = cVar;
        this.b = context;
        this.c = str;
        this.d = dVar;
        this.e = list;
        this.h = z;
        this.i = cVar2;
        this.j = executor;
        this.k = executor2;
        this.l = z3;
        this.m = z4;
    }

    public boolean a(int i2, int i3) {
        if ((!(i2 > i3) || !this.m) && this.l) {
            return true;
        }
        return false;
    }
}
