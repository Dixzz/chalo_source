package defpackage;

import android.media.AudioRecord;
import com.razorpay.AnalyticsConstants;

/* renamed from: qg5  reason: default package */
/* compiled from: Recorder */
public class qg5 {

    /* renamed from: a  reason: collision with root package name */
    public final pg5 f2944a;
    public final int b;
    public bg5 c = null;
    public AudioRecord d;
    public Thread e;
    public int f;
    public int g;
    public rg5 h;
    public int i = 0;

    /* renamed from: qg5$a */
    /* compiled from: Recorder */
    public class a extends Thread {
        public a() {
        }

        public void run() {
            while (true) {
                try {
                    qg5 qg5 = qg5.this;
                    int i = qg5.f;
                    short[] sArr = new short[i];
                    int read = qg5.d.read(sArr, 0, i);
                    if (read >= 0) {
                        qg5 qg52 = qg5.this;
                        if (qg52.f != read) {
                            qg52.f = read;
                        }
                        int i2 = qg52.g;
                        if (i2 == 3) {
                            if (read == 0) {
                                qg52.g = 2;
                                qg52.h.a("rec_in_use", 2);
                                break;
                            }
                            qg52.g = 4;
                            qg52.f2944a.d(4);
                        } else if (i2 == 4) {
                            qg52.f2944a.b(sArr);
                            qg5 qg53 = qg5.this;
                            qg53.f2944a.a(qg53.i, i);
                            if (read == 0) {
                                qg5.this.i++;
                            } else {
                                qg5.this.i = 0;
                            }
                        }
                    }
                } catch (OutOfMemoryError e) {
                    try {
                        e.printStackTrace();
                        System.gc();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                if (qg5.this.g != 4) {
                    break;
                }
            }
            qg5.this.e.interrupt();
            qg5.this.e = null;
        }
    }

    public qg5(pg5 pg5, int i2) {
        this.f2944a = pg5;
        this.g = 0;
        this.h = new rg5(pg5);
        this.b = i2;
    }

    public void a() {
        int i2 = this.g;
        if (i2 == 4) {
            this.g = 0;
            this.h.a("stop", 0);
            bg5 bg5 = this.c;
            if (bg5 != null) {
                StringBuilder i0 = hj1.i0(" Recorder Stopped. Rec State : ");
                i0.append(this.g);
                bg5.a("Recorder", i0.toString());
            }
            this.d.release();
            this.d = null;
            this.f2944a.d(0);
        } else if (i2 == 2) {
            this.d.release();
            this.d = null;
            this.g = 0;
            this.f2944a.d(0);
        } else {
            this.h.a(AnalyticsConstants.DESTROY, i2);
        }
        bg5 bg52 = this.c;
        if (bg52 != null) {
            StringBuilder i02 = hj1.i0(" Recorder Destroyed. Rec State : ");
            i02.append(this.g);
            bg52.a("Recorder", i02.toString());
        }
    }

    public void b() {
        int i2 = this.g;
        if (i2 == 2) {
            this.d.startRecording();
            this.g = 3;
            this.d.getSampleRate();
            bg5 bg5 = this.c;
            if (bg5 != null) {
                StringBuilder i0 = hj1.i0(" Starting Recorder. Rec State : ");
                i0.append(this.g);
                bg5.a("Recorder", i0.toString());
            }
            a aVar = new a();
            this.e = aVar;
            aVar.start();
            return;
        }
        this.h.a(AnalyticsConstants.START, i2);
    }
}
