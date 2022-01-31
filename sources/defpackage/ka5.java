package defpackage;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.view.SurfaceHolder;
import com.google.zxing.client.android.R;
import java.util.Objects;

/* renamed from: ka5  reason: default package */
/* compiled from: CameraInstance */
public class ka5 {
    public static final String l = "ka5";

    /* renamed from: a  reason: collision with root package name */
    public oa5 f2040a;
    public na5 b;
    public la5 c;
    public Handler d;
    public qa5 e;
    public boolean f = false;
    public ma5 g = new ma5();
    public Runnable h = new a();
    public Runnable i = new b();
    public Runnable j = new c();
    public Runnable k = new d();

    /* renamed from: ka5$a */
    /* compiled from: CameraInstance */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                String str = ka5.l;
                ka5.this.c.c();
            } catch (Exception e) {
                ka5.a(ka5.this, e);
                String str2 = ka5.l;
            }
        }
    }

    /* renamed from: ka5$b */
    /* compiled from: CameraInstance */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            fa5 fa5;
            try {
                String str = ka5.l;
                ka5.this.c.a();
                ka5 ka5 = ka5.this;
                Handler handler = ka5.d;
                if (handler != null) {
                    int i = R.id.zxing_prewiew_size_ready;
                    la5 la5 = ka5.c;
                    if (la5.j == null) {
                        fa5 = null;
                    } else if (la5.b()) {
                        fa5 fa52 = la5.j;
                        fa5 = new fa5(fa52.g, fa52.f);
                    } else {
                        fa5 = la5.j;
                    }
                    handler.obtainMessage(i, fa5).sendToTarget();
                }
            } catch (Exception e) {
                ka5.a(ka5.this, e);
                String str2 = ka5.l;
            }
        }
    }

    /* renamed from: ka5$c */
    /* compiled from: CameraInstance */
    public class c implements Runnable {
        public c() {
        }

        public void run() {
            try {
                String str = ka5.l;
                ka5 ka5 = ka5.this;
                la5 la5 = ka5.c;
                na5 na5 = ka5.b;
                Camera camera = la5.f2194a;
                SurfaceHolder surfaceHolder = na5.f2530a;
                if (surfaceHolder != null) {
                    camera.setPreviewDisplay(surfaceHolder);
                } else {
                    camera.setPreviewTexture(na5.b);
                }
                ka5.this.c.f();
            } catch (Exception e) {
                ka5.a(ka5.this, e);
                String str2 = ka5.l;
            }
        }
    }

    /* renamed from: ka5$d */
    /* compiled from: CameraInstance */
    public class d implements Runnable {
        public d() {
        }

        public void run() {
            try {
                String str = ka5.l;
                la5 la5 = ka5.this.c;
                ha5 ha5 = la5.c;
                if (ha5 != null) {
                    ha5.c();
                    la5.c = null;
                }
                x35 x35 = la5.d;
                if (x35 != null) {
                    Objects.requireNonNull(x35);
                    la5.d = null;
                }
                Camera camera = la5.f2194a;
                if (camera != null && la5.e) {
                    camera.stopPreview();
                    la5.m.f2195a = null;
                    la5.e = false;
                }
                la5 la52 = ka5.this.c;
                Camera camera2 = la52.f2194a;
                if (camera2 != null) {
                    camera2.release();
                    la52.f2194a = null;
                }
            } catch (Exception unused) {
                String str2 = ka5.l;
            }
            oa5 oa5 = ka5.this.f2040a;
            synchronized (oa5.d) {
                int i = oa5.c - 1;
                oa5.c = i;
                if (i == 0) {
                    synchronized (oa5.d) {
                        oa5.b.quit();
                        oa5.b = null;
                        oa5.f2672a = null;
                    }
                }
            }
        }
    }

    public ka5(Context context) {
        hd3.g3();
        if (oa5.e == null) {
            oa5.e = new oa5();
        }
        this.f2040a = oa5.e;
        la5 la5 = new la5(context);
        this.c = la5;
        la5.g = this.g;
    }

    public static void a(ka5 ka5, Exception exc) {
        Handler handler = ka5.d;
        if (handler != null) {
            handler.obtainMessage(R.id.zxing_camera_error, exc).sendToTarget();
        }
    }

    public final void b() {
        if (!this.f) {
            throw new IllegalStateException("CameraInstance is not open");
        }
    }
}
