package defpackage;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Process;
import android.view.SurfaceHolder;
import com.budiyev.android.codescanner.CodeScannerView;
import defpackage.uk1;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: qk1  reason: default package */
/* compiled from: CodeScanner */
public final class qk1 {
    public static final List<o25> G;
    public static final List<o25> H = Collections.unmodifiableList(Arrays.asList(o25.CODABAR, o25.CODE_39, o25.CODE_93, o25.CODE_128, o25.EAN_8, o25.EAN_13, o25.ITF, o25.RSS_14, o25.RSS_EXPANDED, o25.UPC_A, o25.UPC_E, o25.UPC_EAN_EXTENSION));
    public static final List<o25> I = Collections.unmodifiableList(Arrays.asList(o25.AZTEC, o25.DATA_MATRIX, o25.MAXICODE, o25.PDF_417, o25.QR_CODE));
    public static final List<o25> J;
    public static final zk1 K = zk1.SINGLE;
    public static final pk1 L = pk1.SAFE;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public int D = 0;
    public int E = 0;
    public int F = 0;

    /* renamed from: a  reason: collision with root package name */
    public final Object f2950a = new Object();
    public final Context b;
    public final Handler c;
    public final CodeScannerView d;
    public final SurfaceHolder e;
    public final SurfaceHolder.Callback f;
    public final Camera.PreviewCallback g;
    public final Camera.AutoFocusCallback h;
    public final Camera.AutoFocusCallback i;
    public final Runnable j;
    public final Runnable k;
    public final b l;
    public volatile List<o25> m = J;
    public volatile zk1 n = K;
    public volatile pk1 o = L;
    public volatile sk1 p = null;
    public volatile wk1 q = null;
    public volatile vk1 r = null;
    public volatile boolean s = false;
    public volatile boolean t = false;
    public volatile boolean u = false;
    public volatile boolean v = true;
    public volatile boolean w = false;
    public volatile int x = -1;
    public boolean y = false;
    public boolean z = false;

    /* renamed from: qk1$b */
    /* compiled from: CodeScanner */
    public final class b implements uk1.c {
        public b(a aVar) {
        }
    }

    /* renamed from: qk1$c */
    /* compiled from: CodeScanner */
    public final class c implements Runnable {
        public final xk1 f;

        public c(xk1 xk1, a aVar) {
            this.f = xk1;
        }

        public void run() {
            if (qk1.this.t) {
                qk1.this.d.setPreviewSize(this.f);
                qk1 qk1 = qk1.this;
                qk1.d.setAutoFocusEnabled(qk1.v);
                qk1 qk12 = qk1.this;
                qk12.d.setFlashEnabled(qk12.w);
                qk1.this.h();
            }
        }
    }

    /* renamed from: qk1$d */
    /* compiled from: CodeScanner */
    public final class d extends Thread {
        public final int f;
        public final int g;

        public d(int i, int i2) {
            super("cs-init");
            this.f = i;
            this.g = i2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:103:0x018c  */
        /* JADX WARNING: Removed duplicated region for block: B:107:0x019e  */
        /* JADX WARNING: Removed duplicated region for block: B:112:0x01ab  */
        /* JADX WARNING: Removed duplicated region for block: B:120:0x01d3  */
        /* JADX WARNING: Removed duplicated region for block: B:139:0x0223 A[SYNTHETIC, Splitter:B:139:0x0223] */
        /* JADX WARNING: Removed duplicated region for block: B:175:0x01ed A[EDGE_INSN: B:175:0x01ed->B:125:0x01ed ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x011f  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x0121  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x0124  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x0126  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x013a  */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x0144  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0166  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a() {
            /*
            // Method dump skipped, instructions count: 669
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.qk1.d.a():void");
        }

        public void run() {
            Process.setThreadPriority(10);
            try {
                a();
            } catch (Exception e) {
                qk1.this.c();
                wk1 wk1 = qk1.this.q;
                if (wk1 != null) {
                    wk1.a(e);
                    return;
                }
                throw e;
            }
        }
    }

    /* renamed from: qk1$e */
    /* compiled from: CodeScanner */
    public final class e implements Camera.PreviewCallback {
        public e(a aVar) {
        }

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            vk1 vk1;
            yk1 frameRect;
            if (qk1.this.t && !qk1.this.u && qk1.this.n != zk1.PREVIEW && bArr != null && (vk1 = qk1.this.r) != null) {
                uk1 uk1 = vk1.b;
                if (uk1.h == uk1.b.IDLE && (frameRect = qk1.this.d.getFrameRect()) != null && frameRect.b() >= 1 && frameRect.a() >= 1) {
                    tk1 tk1 = new tk1(bArr, vk1.c, vk1.d, vk1.e, frameRect, vk1.f, vk1.g);
                    synchronized (uk1.e) {
                        if (uk1.h != uk1.b.STOPPED) {
                            uk1.g = tk1;
                            uk1.e.notify();
                        }
                    }
                }
            }
        }
    }

    /* renamed from: qk1$f */
    /* compiled from: CodeScanner */
    public final class f implements Camera.AutoFocusCallback {
        public f(a aVar) {
        }

        public void onAutoFocus(boolean z, Camera camera) {
            qk1.this.A = false;
        }
    }

    /* renamed from: qk1$g */
    /* compiled from: CodeScanner */
    public final class g implements Runnable {
        public g(a aVar) {
        }

        public void run() {
            vk1 vk1;
            int i;
            qk1 qk1 = qk1.this;
            qk1.B = false;
            if (qk1.o == pk1.SAFE) {
                qk1 qk12 = qk1.this;
                if (qk12.t && qk12.z && (vk1 = qk12.r) != null && vk1.h && qk12.v) {
                    if (!qk12.A || (i = qk12.D) >= 2) {
                        try {
                            Camera camera = vk1.f3658a;
                            camera.cancelAutoFocus();
                            camera.autoFocus(qk12.i);
                            qk12.D = 0;
                            qk12.A = true;
                        } catch (Exception unused) {
                            qk12.A = false;
                        }
                    } else {
                        qk12.D = i + 1;
                    }
                    qk12.d();
                }
            }
        }
    }

    /* renamed from: qk1$h */
    /* compiled from: CodeScanner */
    public final class h implements CodeScannerView.d {
        public h(a aVar) {
        }
    }

    /* renamed from: qk1$i */
    /* compiled from: CodeScanner */
    public final class i implements Runnable {
        public i(a aVar) {
        }

        public void run() {
            qk1 qk1 = qk1.this;
            if (qk1.t && qk1.z) {
                qk1.e.removeCallback(qk1.f);
                qk1.j(false);
            }
        }
    }

    /* renamed from: qk1$j */
    /* compiled from: CodeScanner */
    public final class j implements SurfaceHolder.Callback {
        public j(a aVar) {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            if (surfaceHolder.getSurface() == null) {
                qk1.this.z = false;
                return;
            }
            qk1 qk1 = qk1.this;
            if (qk1.t && qk1.z) {
                qk1.j(true);
            }
            qk1 qk12 = qk1.this;
            if (qk12.t && !qk12.z) {
                qk12.i(true);
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            qk1 qk1 = qk1.this;
            if (qk1.t && !qk1.z) {
                qk1.i(true);
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            qk1 qk1 = qk1.this;
            if (qk1.t && qk1.z) {
                qk1.j(true);
            }
        }
    }

    /* renamed from: qk1$k */
    /* compiled from: CodeScanner */
    public final class k implements Camera.AutoFocusCallback {
        public k(a aVar) {
        }

        public void onAutoFocus(boolean z, Camera camera) {
            qk1.this.y = false;
        }
    }

    static {
        List<o25> unmodifiableList = Collections.unmodifiableList(Arrays.asList(o25.values()));
        G = unmodifiableList;
        J = unmodifiableList;
    }

    public qk1(Context context, CodeScannerView codeScannerView) {
        this.b = context;
        this.d = codeScannerView;
        this.e = codeScannerView.getPreviewView().getHolder();
        this.c = new Handler();
        this.f = new j(null);
        this.g = new e(null);
        this.h = new k(null);
        this.i = new f(null);
        this.j = new g(null);
        this.k = new i(null);
        this.l = new b(null);
        codeScannerView.setCodeScanner(this);
        codeScannerView.setSizeListener(new h(null));
    }

    public final void a(int i2, int i3) {
        this.E = i2;
        this.F = i3;
        if (i2 <= 0 || i3 <= 0) {
            this.C = true;
            return;
        }
        this.s = true;
        this.C = false;
        new d(i2, i3).start();
    }

    public void b() {
        if (this.t) {
            if (this.z && this.t && this.z) {
                this.e.removeCallback(this.f);
                j(false);
            }
            c();
        }
    }

    public final void c() {
        this.t = false;
        this.s = false;
        this.u = false;
        this.z = false;
        this.A = false;
        vk1 vk1 = this.r;
        if (vk1 != null) {
            this.r = null;
            vk1.f3658a.release();
            uk1 uk1 = vk1.b;
            uk1.b.interrupt();
            uk1.g = null;
        }
    }

    public final void d() {
        if (!this.B) {
            this.B = true;
            this.c.postDelayed(this.j, 2000);
        }
    }

    public void e(boolean z2) {
        synchronized (this.f2950a) {
            boolean z3 = this.v != z2;
            this.v = z2;
            this.d.setAutoFocusEnabled(z2);
            vk1 vk1 = this.r;
            if (this.t && this.z && z3 && vk1 != null && vk1.h) {
                f(z2);
            }
        }
    }

    public final void f(boolean z2) {
        yk1 frameRect;
        try {
            vk1 vk1 = this.r;
            if (vk1 != null) {
                Camera camera = vk1.f3658a;
                camera.cancelAutoFocus();
                this.y = false;
                Camera.Parameters parameters = camera.getParameters();
                pk1 pk1 = this.o;
                if (z2) {
                    gj1.m0(parameters, pk1);
                } else {
                    List<String> supportedFocusModes = parameters.getSupportedFocusModes();
                    if (supportedFocusModes != null) {
                        if (!supportedFocusModes.isEmpty()) {
                            String focusMode = parameters.getFocusMode();
                            if (supportedFocusModes.contains("fixed")) {
                                if (!"fixed".equals(focusMode)) {
                                    parameters.setFocusMode("fixed");
                                }
                            } else if (supportedFocusModes.contains("auto") && !"auto".equals(focusMode)) {
                                parameters.setFocusMode("auto");
                            }
                        }
                    }
                }
                if (z2 && (frameRect = this.d.getFrameRect()) != null) {
                    xk1 xk1 = vk1.c;
                    gj1.p(parameters, frameRect, vk1.d, vk1.e, xk1.f3936a, xk1.b, vk1.f);
                }
                camera.setParameters(parameters);
                if (z2) {
                    this.D = 0;
                    this.A = false;
                    if (pk1 == pk1.SAFE) {
                        d();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void g(boolean z2) {
        Camera camera;
        Camera.Parameters parameters;
        try {
            vk1 vk1 = this.r;
            if (vk1 != null && (parameters = (camera = vk1.f3658a).getParameters()) != null) {
                if (z2) {
                    gj1.n0(parameters, "torch");
                } else {
                    gj1.n0(parameters, "off");
                }
                camera.setParameters(parameters);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        if (r3.z != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        r3.e.addCallback(r3.f);
        i(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f2950a
            monitor-enter(r0)
            boolean r1 = r3.t     // Catch:{ all -> 0x002d }
            if (r1 != 0) goto L_0x001c
            boolean r1 = r3.s     // Catch:{ all -> 0x002d }
            if (r1 != 0) goto L_0x001c
            com.budiyev.android.codescanner.CodeScannerView r1 = r3.d     // Catch:{ all -> 0x002d }
            int r1 = r1.getWidth()     // Catch:{ all -> 0x002d }
            com.budiyev.android.codescanner.CodeScannerView r2 = r3.d     // Catch:{ all -> 0x002d }
            int r2 = r2.getHeight()     // Catch:{ all -> 0x002d }
            r3.a(r1, r2)     // Catch:{ all -> 0x002d }
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            boolean r0 = r3.z
            if (r0 != 0) goto L_0x002c
            android.view.SurfaceHolder r0 = r3.e
            android.view.SurfaceHolder$Callback r1 = r3.f
            r0.addCallback(r1)
            r0 = 0
            r3.i(r0)
        L_0x002c:
            return
        L_0x002d:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qk1.h():void");
    }

    public final void i(boolean z2) {
        try {
            vk1 vk1 = this.r;
            if (vk1 != null) {
                Camera camera = vk1.f3658a;
                camera.setPreviewCallback(this.g);
                camera.setPreviewDisplay(this.e);
                if (!z2 && vk1.i && this.w) {
                    g(true);
                }
                camera.startPreview();
                this.u = false;
                this.z = true;
                this.A = false;
                this.D = 0;
                if (vk1.h && this.v) {
                    yk1 frameRect = this.d.getFrameRect();
                    if (frameRect != null) {
                        Camera.Parameters parameters = camera.getParameters();
                        xk1 xk1 = vk1.c;
                        gj1.p(parameters, frameRect, vk1.d, vk1.e, xk1.f3936a, xk1.b, vk1.f);
                        camera.setParameters(parameters);
                    }
                    if (this.o == pk1.SAFE) {
                        d();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void j(boolean z2) {
        try {
            vk1 vk1 = this.r;
            if (vk1 != null) {
                Camera camera = vk1.f3658a;
                camera.cancelAutoFocus();
                Camera.Parameters parameters = camera.getParameters();
                if (!z2 && vk1.i && this.w) {
                    gj1.n0(parameters, "off");
                }
                camera.setParameters(parameters);
                camera.setPreviewCallback(null);
                camera.stopPreview();
            }
        } catch (Exception unused) {
        }
        this.u = false;
        this.z = false;
        this.A = false;
        this.D = 0;
    }
}
