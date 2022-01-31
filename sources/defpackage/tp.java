package defpackage;

/* renamed from: tp  reason: default package */
/* compiled from: Logger */
public abstract class tp {

    /* renamed from: a  reason: collision with root package name */
    public static tp f3386a;

    /* renamed from: tp$a */
    /* compiled from: Logger */
    public static class a extends tp {
        public int b;

        public a(int i) {
            this.b = i;
        }

        @Override // defpackage.tp
        public void a(String str, String str2, Throwable... thArr) {
            if (this.b <= 3 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        @Override // defpackage.tp
        public void b(String str, String str2, Throwable... thArr) {
            if (this.b <= 6 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        @Override // defpackage.tp
        public void d(String str, String str2, Throwable... thArr) {
            if (this.b <= 4 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        @Override // defpackage.tp
        public void f(String str, String str2, Throwable... thArr) {
            if (this.b <= 5 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }
    }

    public static synchronized tp c() {
        tp tpVar;
        synchronized (tp.class) {
            if (f3386a == null) {
                f3386a = new a(3);
            }
            tpVar = f3386a;
        }
        return tpVar;
    }

    public static String e(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        if (length >= 20) {
            sb.append(str.substring(0, 20));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public abstract void a(String str, String str2, Throwable... thArr);

    public abstract void b(String str, String str2, Throwable... thArr);

    public abstract void d(String str, String str2, Throwable... thArr);

    public abstract void f(String str, String str2, Throwable... thArr);
}
