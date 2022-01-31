package defpackage;

import android.content.Context;
import com.google.firebase.appindexing.Indexable;
import com.rabbitmq.client.AMQP;
import com.trillbit.datasdk.core.CWrapper;
import defpackage.lg5;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: kg5  reason: default package */
/* compiled from: Sender */
public class kg5 {

    /* renamed from: a  reason: collision with root package name */
    public final ag5 f2055a;
    public ng5 b;
    public final Context c;
    public final bg5 d;
    public qg5 e;
    public CWrapper f;
    public lg5 g;
    public mg5 h;
    public int i;
    public cg5 j;
    public pg5 k;
    public int l;
    public boolean m;
    public int n;
    public int o;
    public a p;
    public b q;

    /* renamed from: kg5$a */
    /* compiled from: Sender */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f2056a = 100000;
        public int b = 0;
        public byte[] c;
        public int d = 0;
        public int e = 88200;

        public a(byte[] bArr) {
            this.c = bArr;
        }
    }

    /* renamed from: kg5$b */
    /* compiled from: Sender */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Long f2057a = 0L;
        public int b = 0;
        public ArrayList<Integer> c = new ArrayList<>();

        public b(gg5 gg5) {
        }

        public void a() {
            if (this.f2057a.longValue() != 0) {
                this.b = (int) (System.currentTimeMillis() - this.f2057a.longValue());
                this.f2057a = Long.valueOf(System.currentTimeMillis());
                this.c.add(Integer.valueOf(this.b));
                String.valueOf(this.c);
            }
        }

        public int b() {
            if (this.f2057a.longValue() != 0) {
                int currentTimeMillis = (int) (System.currentTimeMillis() - this.f2057a.longValue());
                this.b = currentTimeMillis;
                this.c.add(Integer.valueOf(currentTimeMillis));
            }
            int i = 0;
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                i += this.c.get(i2).intValue();
            }
            return i;
        }
    }

    public kg5(Context context, int i2, bg5 bg5) {
        this.i = -1;
        this.l = 0;
        this.i = 0;
        this.c = context;
        this.d = bg5;
        this.f2055a = new ag5(context);
    }

    public static void a(kg5 kg5) {
        if (kg5.i != 1) {
            kg5.e();
            a aVar = kg5.p;
            boolean z = aVar.b >= aVar.f2056a;
            bg5 bg5 = kg5.d;
            bg5.a("Sender", "Does Repetition Count Limit Reached : " + z);
            if (z) {
                int b2 = kg5.q.b();
                bg5 bg52 = kg5.d;
                bg52.a("Sender", "Transaction Time : " + b2 + " miliseconds");
                cg5 cg5 = kg5.j;
                cg5.b(AMQP.REPLY_SUCCESS, "Transaction Time : " + b2 + " miliseconds");
                kg5.d.a("Sender", "Unable to verify, Session Timeout\n\n");
                kg5.j.b(AMQP.REPLY_SUCCESS, "Unable to verify, Session Timeout");
                kg5.d.b();
                return;
            }
            kg5.i = 2;
            kg5.j.b(AMQP.REPLY_SUCCESS, "Unable to verify, Trying again");
            kg5.d.a("Sender", "Unable to verify, Trying again\n\n");
            kg5.q.a();
            kg5.b(true);
            return;
        }
        kg5.c("stop");
        kg5.j.a(400, "SDK Already Running");
    }

    public final void b(boolean z) {
        d("play_samples");
        if (this.i == 2) {
            a aVar = this.p;
            aVar.b++;
            lg5 lg5 = this.g;
            byte[] bArr = aVar.c;
            int i2 = this.o;
            lg5.b(0.95d);
            lg5.b bVar = lg5.d;
            if (!bVar.f2218a) {
                bVar.a();
                CWrapper cWrapper = lg5.h;
                Objects.requireNonNull(cWrapper);
                float[] audioSamplesFromBytes = CWrapper.getAudioSamplesFromBytes(bArr, 0, i2);
                if (cWrapper.f710a != null) {
                    CWrapper.getLogsFromNative().equals("");
                }
                if (z) {
                    float[] fArr = new float[(audioSamplesFromBytes.length + Indexable.MAX_STRING_LENGTH)];
                    for (int i3 = 0; i3 < 20000; i3++) {
                        fArr[i3] = 0.0f;
                    }
                    System.arraycopy(audioSamplesFromBytes, 0, fArr, Indexable.MAX_STRING_LENGTH, (audioSamplesFromBytes.length + Indexable.MAX_STRING_LENGTH) - Indexable.MAX_STRING_LENGTH);
                    audioSamplesFromBytes = fArr;
                }
                if (audioSamplesFromBytes.length < 10) {
                    lg5.d.a();
                    return;
                }
                bg5 bg5 = lg5.f;
                if (bg5 != null) {
                    StringBuilder i0 = hj1.i0("Samples Generated : len ");
                    i0.append(audioSamplesFromBytes.length);
                    bg5.a("Player", i0.toString());
                }
                lg5.a(audioSamplesFromBytes);
            }
        }
    }

    public final void c(String str) {
        bg5 bg5 = this.d;
        StringBuilder l0 = hj1.l0("Unable to execute '", str, "' Current state: ");
        l0.append(this.f2055a.b(this.i));
        bg5.a("Sender/CodeFlowError", l0.toString());
    }

    public final void d(String str) {
        bg5 bg5 = this.d;
        StringBuilder k0 = hj1.k0(str, " Method called, Current SDK State -> ");
        k0.append(this.f2055a.b(this.i));
        bg5.a("Sender", k0.toString());
    }

    public final void e() {
        a aVar = this.p;
        aVar.d = 0;
        aVar.e = 88200;
        this.g.c();
        this.i = 1;
        if (this.m) {
            this.e.a();
            Objects.requireNonNull(this.f);
        }
    }
}
