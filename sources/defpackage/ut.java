package defpackage;

import server.zophop.CS;

/* renamed from: ut  reason: default package */
/* compiled from: AppConstants */
public class ut {
    public static boolean A;
    public static String B;
    public static String C;
    public static String D;
    public static String E;
    public static String F;
    public static String G;
    public static String H;
    public static String I;

    /* renamed from: a  reason: collision with root package name */
    public static a f3552a = vt.f3680a;
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static String f;
    public static CS.ENVIRONMENT g;
    public static String h;
    public static String i;
    public static String j;
    public static String k;
    public static String l;
    public static String m;
    public static String n;
    public static String o;
    public static String p;
    public static String q;
    public static String r;
    public static String s;
    public static String t;
    public static String u;
    public static String v;
    public static String w;
    public static String x;
    public static String y;
    public static String z;

    /* renamed from: ut$a */
    /* compiled from: AppConstants */
    public enum a {
        PRODUCTION,
        DEVELOPMENT,
        STAGING
    }

    public static boolean a() {
        a aVar = a.DEVELOPMENT;
        a aVar2 = vt.f3680a;
        return aVar.equals(aVar2) || a.STAGING.equals(aVar2);
    }
}
