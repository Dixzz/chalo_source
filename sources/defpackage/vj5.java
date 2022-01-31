package defpackage;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.urbanairship.AirshipConfigOptions;
import java.util.Calendar;

/* renamed from: vj5  reason: default package */
/* compiled from: ChannelCapture */
public class vj5 extends oj5 {
    public final Context e;
    public final AirshipConfigOptions f;
    public final kp5 g;
    public ClipboardManager h;
    public final xl5 i = new a();
    public final wl5 j;
    public int k;
    public long[] l = new long[6];
    public boolean m;

    /* renamed from: vj5$a */
    /* compiled from: ChannelCapture */
    public class a extends dm5 {
        public a() {
        }

        @Override // defpackage.xl5
        public void a(long j) {
            vj5 vj5 = vj5.this;
            if (vj5.m) {
                if (vj5.k >= 6) {
                    vj5.k = 0;
                }
                long[] jArr = vj5.l;
                int i = vj5.k;
                jArr[i] = j;
                boolean z = true;
                vj5.k = i + 1;
                long timeInMillis = Calendar.getInstance().getTimeInMillis();
                long[] jArr2 = vj5.l;
                int length = jArr2.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (jArr2[i2] + 30000 < timeInMillis) {
                        z = false;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    if (vj5.h == null) {
                        try {
                            vj5.h = (ClipboardManager) vj5.e.getSystemService("clipboard");
                        } catch (Exception e) {
                            yj5.e(e, "Unable to initialize clipboard manager: ", new Object[0]);
                        }
                    }
                    if (vj5.h == null) {
                        yj5.a("Unable to attempt channel capture, clipboard manager uninitialized", new Object[0]);
                        return;
                    }
                    vj5.l = new long[6];
                    vj5.k = 0;
                    String l = vj5.g.l();
                    String str = "ua:";
                    if (!hd3.G1(l)) {
                        str = hj1.S(str, l);
                    }
                    vj5.h.setPrimaryClip(ClipData.newPlainText("UA Channel ID", str));
                    yj5.a("Channel ID copied to clipboard", new Object[0]);
                }
            }
        }
    }

    public vj5(Context context, AirshipConfigOptions airshipConfigOptions, kp5 kp5, hk5 hk5, wl5 wl5) {
        super(context, hk5);
        this.e = context.getApplicationContext();
        this.f = airshipConfigOptions;
        this.g = kp5;
        this.j = wl5;
    }

    @Override // defpackage.oj5
    public void b() {
        super.b();
        this.m = this.f.u;
        this.j.a(this.i);
    }
}
