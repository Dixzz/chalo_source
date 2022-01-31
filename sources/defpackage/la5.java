package defpackage;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import com.google.zxing.client.android.R;
import defpackage.aa5;
import defpackage.ma5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import server.zophop.logicLayer.CsLogic;

/* renamed from: la5  reason: default package */
/* compiled from: CameraManager */
public final class la5 {
    public static final String n = "la5";

    /* renamed from: a  reason: collision with root package name */
    public Camera f2194a;
    public Camera.CameraInfo b;
    public ha5 c;
    public x35 d;
    public boolean e;
    public String f;
    public ma5 g = new ma5();
    public qa5 h;
    public fa5 i;
    public fa5 j;
    public int k = -1;
    public Context l;
    public final a m;

    /* renamed from: la5$a */
    /* compiled from: CameraManager */
    public final class a implements Camera.PreviewCallback {

        /* renamed from: a  reason: collision with root package name */
        public ta5 f2195a;
        public fa5 b;

        public a() {
        }

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            fa5 fa5 = this.b;
            ta5 ta5 = this.f2195a;
            if (fa5 == null || ta5 == null) {
                String str = la5.n;
                return;
            }
            ga5 ga5 = new ga5(bArr, fa5.f, fa5.g, camera.getParameters().getPreviewFormat(), la5.this.k);
            aa5.b bVar = (aa5.b) ta5;
            synchronized (aa5.this.h) {
                aa5 aa5 = aa5.this;
                if (aa5.g) {
                    aa5.c.obtainMessage(R.id.zxing_decode, ga5).sendToTarget();
                }
            }
        }
    }

    public la5(Context context) {
        this.l = context;
        this.m = new a();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(15:2|3|4|(12:(2:7|(2:9|(1:11)(1:12))(1:13))(1:14)|16|(1:18)(1:19)|20|21|22|23|24|26|(1:28)(1:29)|30|31)|15|16|(0)(0)|20|21|22|(2:23|24)|26|(0)(0)|30|31) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x003b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0025 A[Catch:{ Exception -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002f A[Catch:{ Exception -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
        // Method dump skipped, instructions count: 111
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.la5.a():void");
    }

    public boolean b() {
        int i2 = this.k;
        if (i2 != -1) {
            return i2 % CsLogic.ETA_FORCE_UPDATE_REDIS_TTL != 0;
        }
        throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
    }

    public void c() {
        Camera camera;
        int a2 = d45.a(this.g.f2346a);
        if (a2 == -1) {
            camera = null;
        } else {
            camera = Camera.open(a2);
        }
        this.f2194a = camera;
        if (camera != null) {
            int a3 = d45.a(this.g.f2346a);
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            this.b = cameraInfo;
            Camera.getCameraInfo(a3, cameraInfo);
            return;
        }
        throw new RuntimeException("Failed to open camera");
    }

    public final void d(boolean z) {
        String str;
        Camera.Parameters parameters = this.f2194a.getParameters();
        String str2 = this.f;
        if (str2 == null) {
            this.f = parameters.flatten();
        } else {
            parameters.unflatten(str2);
        }
        if (parameters != null) {
            parameters.flatten();
            ma5.a aVar = this.g.b;
            int i2 = c45.f517a;
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            int[] iArr = null;
            if (z || aVar == ma5.a.AUTO) {
                str = c45.a("focus mode", supportedFocusModes, "auto");
            } else if (aVar == ma5.a.CONTINUOUS) {
                str = c45.a("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", "auto");
            } else if (aVar == ma5.a.INFINITY) {
                str = c45.a("focus mode", supportedFocusModes, "infinity");
            } else {
                str = aVar == ma5.a.MACRO ? c45.a("focus mode", supportedFocusModes, "macro") : null;
            }
            if (!z && str == null) {
                str = c45.a("focus mode", supportedFocusModes, "macro", "edof");
            }
            if (str != null && !str.equals(parameters.getFocusMode())) {
                parameters.setFocusMode(str);
            }
            if (!z) {
                c45.b(parameters, false);
                Objects.requireNonNull(this.g);
                Objects.requireNonNull(this.g);
                Objects.requireNonNull(this.g);
            }
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            ArrayList arrayList = new ArrayList();
            if (supportedPreviewSizes == null) {
                Camera.Size previewSize = parameters.getPreviewSize();
                if (previewSize != null) {
                    arrayList.add(new fa5(previewSize.width, previewSize.height));
                }
            } else {
                for (Camera.Size size : supportedPreviewSizes) {
                    arrayList.add(new fa5(size.width, size.height));
                }
            }
            if (arrayList.size() == 0) {
                this.i = null;
            } else {
                qa5 qa5 = this.h;
                boolean b2 = b();
                fa5 fa5 = qa5.f2919a;
                if (fa5 == null) {
                    fa5 = null;
                } else if (b2) {
                    fa5 = new fa5(fa5.g, fa5.f);
                }
                va5 va5 = qa5.c;
                Objects.requireNonNull(va5);
                if (fa5 != null) {
                    Collections.sort(arrayList, new ua5(va5, fa5));
                }
                String str3 = "Viewfinder size: " + fa5;
                String str4 = "Preview in order of preference: " + arrayList;
                fa5 fa52 = (fa5) arrayList.get(0);
                this.i = fa52;
                parameters.setPreviewSize(fa52.f, fa52.g);
            }
            if (Build.DEVICE.equals("glass-1")) {
                List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                if (supportedPreviewFpsRange != null && !supportedPreviewFpsRange.isEmpty()) {
                    Iterator<int[]> it = supportedPreviewFpsRange.iterator();
                    while (it.hasNext()) {
                        Arrays.toString(it.next());
                        it.hasNext();
                    }
                }
                if (supportedPreviewFpsRange != null && !supportedPreviewFpsRange.isEmpty()) {
                    Iterator<int[]> it2 = supportedPreviewFpsRange.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        int[] next = it2.next();
                        int i3 = next[0];
                        int i4 = next[1];
                        if (i3 >= 10000 && i4 <= 20000) {
                            iArr = next;
                            break;
                        }
                    }
                    if (iArr != null) {
                        int[] iArr2 = new int[2];
                        parameters.getPreviewFpsRange(iArr2);
                        if (Arrays.equals(iArr2, iArr)) {
                            Arrays.toString(iArr);
                        } else {
                            Arrays.toString(iArr);
                            parameters.setPreviewFpsRange(iArr[0], iArr[1]);
                        }
                    }
                }
            }
            parameters.flatten();
            this.f2194a.setParameters(parameters);
        }
    }

    public void e(boolean z) {
        String flashMode;
        Camera camera = this.f2194a;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (z != ((parameters == null || (flashMode = parameters.getFlashMode()) == null || (!"on".equals(flashMode) && !"torch".equals(flashMode))) ? false : true)) {
                ha5 ha5 = this.c;
                if (ha5 != null) {
                    ha5.c();
                }
                Camera.Parameters parameters2 = this.f2194a.getParameters();
                c45.b(parameters2, z);
                Objects.requireNonNull(this.g);
                this.f2194a.setParameters(parameters2);
                ha5 ha52 = this.c;
                if (ha52 != null) {
                    ha52.f1353a = false;
                    ha52.b();
                }
            }
        }
    }

    public void f() {
        Camera camera = this.f2194a;
        if (camera != null && !this.e) {
            camera.startPreview();
            this.e = true;
            this.c = new ha5(this.f2194a, this.g);
            Context context = this.l;
            ma5 ma5 = this.g;
            this.d = new x35(context, this, ma5);
            Objects.requireNonNull(ma5);
        }
    }
}
