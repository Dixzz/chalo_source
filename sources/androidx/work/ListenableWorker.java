package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;

public abstract class ListenableWorker {
    public Context f;
    public WorkerParameters g;
    public volatile boolean h;
    public boolean i;

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        } else if (workerParameters != null) {
            this.f = context;
            this.g = workerParameters;
        } else {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
    }

    public boolean a() {
        return false;
    }

    public void c() {
    }

    public abstract gy4<a> d();

    public final void e() {
        this.h = true;
        c();
    }

    public static abstract class a {

        /* renamed from: androidx.work.ListenableWorker$a$a  reason: collision with other inner class name */
        public static final class C0002a extends a {

            /* renamed from: a  reason: collision with root package name */
            public final np f259a = np.c;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || C0002a.class != obj.getClass()) {
                    return false;
                }
                return this.f259a.equals(((C0002a) obj).f259a);
            }

            public int hashCode() {
                return this.f259a.hashCode() + (C0002a.class.getName().hashCode() * 31);
            }

            public String toString() {
                StringBuilder i0 = hj1.i0("Failure {mOutputData=");
                i0.append(this.f259a);
                i0.append('}');
                return i0.toString();
            }
        }

        public static final class b extends a {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && b.class == obj.getClass();
            }

            public int hashCode() {
                return b.class.getName().hashCode();
            }

            public String toString() {
                return "Retry";
            }
        }

        public static final class c extends a {

            /* renamed from: a  reason: collision with root package name */
            public final np f260a;

            public c() {
                this.f260a = np.c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || c.class != obj.getClass()) {
                    return false;
                }
                return this.f260a.equals(((c) obj).f260a);
            }

            public int hashCode() {
                return this.f260a.hashCode() + (c.class.getName().hashCode() * 31);
            }

            public String toString() {
                StringBuilder i0 = hj1.i0("Success {mOutputData=");
                i0.append(this.f260a);
                i0.append('}');
                return i0.toString();
            }

            public c(np npVar) {
                this.f260a = npVar;
            }
        }
    }
}
