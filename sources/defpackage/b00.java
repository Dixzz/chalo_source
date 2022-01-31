package defpackage;

import app.zophop.models.City;
import defpackage.xt;

/* renamed from: b00  reason: default package */
/* compiled from: ErrorReporter.kt */
public final class b00 {

    /* renamed from: a  reason: collision with root package name */
    public static final b00 f358a = null;
    public static final j56<a00> b = hd3.a2(a.f);

    /* renamed from: b00$a */
    /* compiled from: ErrorReporter.kt */
    public static final class a extends o86 implements h76<a00> {
        public static final a f = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public a00 invoke() {
            a00 a00 = new a00();
            xt.t1 t1Var = xt.f3961a;
            a00.c("USER_ID", t1Var.m0());
            a00.c("environment", ut.f3552a.toString());
            a00.c("GIT_SHA", "");
            a00.c("BUILD_TIME", "17-01 23:11");
            City d = t1Var.k().d();
            if (d != null) {
                a00.c("USER_CITY", d.getName());
            }
            return a00;
        }
    }

    public static final c00 a() {
        return b.getValue();
    }
}
