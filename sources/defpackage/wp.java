package defpackage;

import android.annotation.SuppressLint;

/* renamed from: wp  reason: default package */
/* compiled from: Operation */
public interface wp {
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: a  reason: collision with root package name */
    public static final b.c f3818a = new b.c(null);
    @SuppressLint({"SyntheticAccessor"})
    public static final b.C0066b b = new b.C0066b(null);

    /* renamed from: wp$b */
    /* compiled from: Operation */
    public static abstract class b {

        /* renamed from: wp$b$a */
        /* compiled from: Operation */
        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            public final Throwable f3819a;

            public a(Throwable th) {
                this.f3819a = th;
            }

            public String toString() {
                return String.format("FAILURE (%s)", this.f3819a.getMessage());
            }
        }

        /* renamed from: wp$b$b  reason: collision with other inner class name */
        /* compiled from: Operation */
        public static final class C0066b extends b {
            public C0066b(a aVar) {
            }

            public String toString() {
                return "IN_PROGRESS";
            }
        }

        /* renamed from: wp$b$c */
        /* compiled from: Operation */
        public static final class c extends b {
            public c() {
            }

            public String toString() {
                return "SUCCESS";
            }

            public c(a aVar) {
            }
        }
    }
}
