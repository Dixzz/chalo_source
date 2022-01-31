package defpackage;

import android.content.Context;
import java.util.List;

/* renamed from: cb  reason: default package */
/* compiled from: PreferenceDataStoreDelegate.kt */
public final class cb implements d96<Context, oa<kb>> {

    /* renamed from: a  reason: collision with root package name */
    public final String f541a;
    public final s76<Context, List<ja<kb>>> b;
    public final mb6 c;
    public final Object d = new Object();
    public volatile oa<kb> e;

    /* JADX WARN: Incorrect args count in method signature: (Ljava/lang/String;Ljava/lang/Object<Lkb;>;Ls76<-Landroid/content/Context;+Ljava/util/List<+Lja<Lkb;>;>;>;Lmb6;)V */
    public cb(String str, s76 s76, mb6 mb6) {
        n86.e(str, "name");
        n86.e(s76, "produceMigrations");
        n86.e(mb6, "scope");
        this.f541a = str;
        this.b = s76;
        this.c = mb6;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, s96] */
    @Override // defpackage.d96
    public oa<kb> a(Context context, s96 s96) {
        oa<kb> oaVar;
        Context context2 = context;
        n86.e(context2, "thisRef");
        n86.e(s96, "property");
        oa<kb> oaVar2 = this.e;
        if (oaVar2 != null) {
            return oaVar2;
        }
        synchronized (this.d) {
            if (this.e == null) {
                Context applicationContext = context2.getApplicationContext();
                s76<Context, List<ja<kb>>> s76 = this.b;
                n86.d(applicationContext, "applicationContext");
                List<ja<kb>> invoke = s76.invoke(applicationContext);
                mb6 mb6 = this.c;
                bb bbVar = new bb(applicationContext, this);
                n86.e(invoke, "migrations");
                n86.e(mb6, "scope");
                n86.e(bbVar, "produceFile");
                mb mbVar = mb.f2347a;
                jb jbVar = new jb(bbVar);
                n86.e(mbVar, "serializer");
                n86.e(invoke, "migrations");
                n86.e(mb6, "scope");
                n86.e(jbVar, "produceFile");
                za zaVar = new za();
                n86.e(invoke, "migrations");
                this.e = new ib(new ua(jbVar, mbVar, hd3.c2(new ka(invoke, null)), zaVar, mb6));
            }
            oaVar = this.e;
            n86.c(oaVar);
        }
        return oaVar;
    }
}
