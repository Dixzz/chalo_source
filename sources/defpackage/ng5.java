package defpackage;

import android.os.Handler;
import android.os.Looper;
import com.trillbit.datasdk.core.CWrapper;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: ng5  reason: default package */
/* compiled from: Processor */
public class ng5 implements Runnable {
    public CWrapper f;
    public og5 g;
    public boolean h;
    public Thread i;
    public int j;
    public int k = 0;
    public ArrayList<short[]> l;

    /* renamed from: ng5$a */
    /* compiled from: Processor */
    public class a implements Runnable {
        public final /* synthetic */ og5 f;

        public a(og5 og5) {
            this.f = og5;
        }

        public void run() {
            ng5 ng5 = ng5.this;
            if (ng5.k < 10) {
                Objects.requireNonNull(ng5);
                this.f.d("Unable to start");
            }
        }
    }

    public ng5(CWrapper cWrapper) {
        this.f = cWrapper;
        this.l = new ArrayList<>();
        new ArrayList();
    }

    public void a() {
        Objects.requireNonNull(this.f);
        String logsFromNative = CWrapper.getLogsFromNative();
        if (logsFromNative.equals("")) {
            logsFromNative = null;
        }
        if (logsFromNative != null && this.g != null) {
            this.g.f(logsFromNative.split("\n"));
        }
    }

    public void b(og5 og5) {
        Thread thread = new Thread(this);
        this.i = thread;
        this.g = og5;
        this.h = true;
        thread.start();
        this.l = new ArrayList<>();
        new Handler(Looper.getMainLooper()).postDelayed(new a(og5), 1000);
    }

    public void run() {
        while (this.h) {
            this.k++;
            if (this.f != null) {
                if (this.l.size() > 0) {
                    short[] sArr = this.l.get(0);
                    CWrapper cWrapper = this.f;
                    Objects.requireNonNull(cWrapper);
                    try {
                        CWrapper.addBuffer(sArr, sArr.length, cWrapper.b);
                    } catch (NullPointerException unused) {
                    }
                    this.l.remove(0);
                }
                int processBuffer = CWrapper.processBuffer(this.f.b);
                if (processBuffer != 0) {
                    this.k = 10;
                    if (processBuffer == 1 && this.j != 1) {
                        this.j = 1;
                        this.g.a();
                    } else if (processBuffer == 2 && this.j != 2) {
                        this.j = 2;
                        this.g.e();
                    } else if (processBuffer == 3 && this.j != 0) {
                        this.j = 0;
                        this.g.c(CWrapper.getDecodedString(this.f.b));
                    } else if (processBuffer == 9 && this.j != 0) {
                        this.j = 0;
                        Objects.requireNonNull(this.f);
                        String[] split = CWrapper.getPeakHeightLog().split("\t");
                        float f2 = 7.0f;
                        if (split.length == 2) {
                            try {
                                f2 = Float.parseFloat(split[1]);
                            } catch (Exception unused2) {
                            }
                        }
                        String.valueOf(f2);
                        CWrapper.getDecodedString(this.f.b);
                        this.g.b(f2);
                    } else if (processBuffer == 10) {
                        this.j = 0;
                        this.g.b(-1.0f);
                    }
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a();
            }
        }
    }
}
