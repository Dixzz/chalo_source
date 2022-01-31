package defpackage;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

/* renamed from: m7  reason: default package */
/* compiled from: RequestExecutor */
public class m7 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public String f2332a;
    public int b;

    /* renamed from: m7$a */
    /* compiled from: RequestExecutor */
    public static class a extends Thread {
        public final int f;

        public a(Runnable runnable, String str, int i) {
            super(runnable, str);
            this.f = i;
        }

        public void run() {
            Process.setThreadPriority(this.f);
            super.run();
        }
    }

    public m7(String str, int i) {
        this.f2332a = str;
        this.b = i;
    }

    public Thread newThread(Runnable runnable) {
        return new a(runnable, this.f2332a, this.b);
    }
}
