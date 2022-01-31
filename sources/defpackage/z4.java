package defpackage;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: z4  reason: default package */
/* compiled from: FrameMetricsAggregator */
public class z4 {

    /* renamed from: a  reason: collision with root package name */
    public b f4121a;

    /* renamed from: z4$a */
    /* compiled from: FrameMetricsAggregator */
    public static class a extends b {
        public static HandlerThread e;
        public static Handler f;

        /* renamed from: a  reason: collision with root package name */
        public int f4122a;
        public SparseIntArray[] b = new SparseIntArray[9];
        public ArrayList<WeakReference<Activity>> c = new ArrayList<>();
        public Window.OnFrameMetricsAvailableListener d = new Window$OnFrameMetricsAvailableListenerC0069a();

        /* renamed from: z4$a$a  reason: collision with other inner class name */
        /* compiled from: FrameMetricsAggregator */
        public class Window$OnFrameMetricsAvailableListenerC0069a implements Window.OnFrameMetricsAvailableListener {
            public Window$OnFrameMetricsAvailableListenerC0069a() {
            }

            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
                a aVar = a.this;
                if ((aVar.f4122a & 1) != 0) {
                    aVar.c(aVar.b[0], frameMetrics.getMetric(8));
                }
                a aVar2 = a.this;
                if ((aVar2.f4122a & 2) != 0) {
                    aVar2.c(aVar2.b[1], frameMetrics.getMetric(1));
                }
                a aVar3 = a.this;
                if ((aVar3.f4122a & 4) != 0) {
                    aVar3.c(aVar3.b[2], frameMetrics.getMetric(3));
                }
                a aVar4 = a.this;
                if ((aVar4.f4122a & 8) != 0) {
                    aVar4.c(aVar4.b[3], frameMetrics.getMetric(4));
                }
                a aVar5 = a.this;
                if ((aVar5.f4122a & 16) != 0) {
                    aVar5.c(aVar5.b[4], frameMetrics.getMetric(5));
                }
                a aVar6 = a.this;
                if ((aVar6.f4122a & 64) != 0) {
                    aVar6.c(aVar6.b[6], frameMetrics.getMetric(7));
                }
                a aVar7 = a.this;
                if ((aVar7.f4122a & 32) != 0) {
                    aVar7.c(aVar7.b[5], frameMetrics.getMetric(6));
                }
                a aVar8 = a.this;
                if ((aVar8.f4122a & 128) != 0) {
                    aVar8.c(aVar8.b[7], frameMetrics.getMetric(0));
                }
                a aVar9 = a.this;
                if ((aVar9.f4122a & 256) != 0) {
                    aVar9.c(aVar9.b[8], frameMetrics.getMetric(2));
                }
            }
        }

        public a(int i) {
            this.f4122a = i;
        }

        @Override // defpackage.z4.b
        public void a(Activity activity) {
            if (e == null) {
                HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                e = handlerThread;
                handlerThread.start();
                f = new Handler(e.getLooper());
            }
            for (int i = 0; i <= 8; i++) {
                SparseIntArray[] sparseIntArrayArr = this.b;
                if (sparseIntArrayArr[i] == null && (this.f4122a & (1 << i)) != 0) {
                    sparseIntArrayArr[i] = new SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.d, f);
            this.c.add(new WeakReference<>(activity));
        }

        @Override // defpackage.z4.b
        public SparseIntArray[] b(Activity activity) {
            Iterator<WeakReference<Activity>> it = this.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference<Activity> next = it.next();
                if (next.get() == activity) {
                    this.c.remove(next);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.d);
            return this.b;
        }

        public void c(SparseIntArray sparseIntArray, long j) {
            if (sparseIntArray != null) {
                int i = (int) ((500000 + j) / 1000000);
                if (j >= 0) {
                    sparseIntArray.put(i, sparseIntArray.get(i) + 1);
                }
            }
        }
    }

    /* renamed from: z4$b */
    /* compiled from: FrameMetricsAggregator */
    public static class b {
        public void a(Activity activity) {
        }

        public SparseIntArray[] b(Activity activity) {
            return null;
        }
    }

    public z4() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f4121a = new a(1);
        } else {
            this.f4121a = new b();
        }
    }
}
