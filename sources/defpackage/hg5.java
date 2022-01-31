package defpackage;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Looper;
import com.rabbitmq.client.AMQP;
import com.razorpay.AnalyticsConstants;
import defpackage.kg5;
import java.util.Objects;

/* renamed from: hg5  reason: default package */
/* compiled from: Sender */
public class hg5 extends mg5 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ kg5 f1370a;

    public hg5(kg5 kg5) {
        this.f1370a = kg5;
    }

    @Override // defpackage.mg5
    public void a(int i) {
        Objects.requireNonNull(this.f1370a);
        this.f1370a.d.a("Sender", "Playing Started");
    }

    @Override // defpackage.mg5
    public void b(int i) {
        Objects.requireNonNull(this.f1370a);
        this.f1370a.d.a("Sender", "Playing Stopped");
        kg5 kg5 = this.f1370a;
        boolean z = false;
        if (kg5.m) {
            kg5.i = 4;
            kg5.d("start_listening_to_custom_response");
            if (kg5.i == 4) {
                kg5.i = 5;
                qg5 qg5 = kg5.e;
                int i2 = qg5.g;
                if (i2 == 0) {
                    qg5.g = 1;
                    qg5.f = AudioRecord.getMinBufferSize(qg5.b, 16, 2);
                    AudioRecord audioRecord = new AudioRecord(0, qg5.b, 16, 2, qg5.f);
                    qg5.d = audioRecord;
                    if (audioRecord.getState() == 1) {
                        try {
                            qg5.g = 2;
                            qg5.f2944a.d(2);
                            qg5.b();
                        } catch (Exception e) {
                            e.printStackTrace();
                            qg5.f2944a.c("Unable to INITIALIZED recorder, check permissions");
                            qg5.f2944a.d(0);
                        }
                    }
                } else {
                    qg5.h.a(AnalyticsConstants.INIT, i2);
                }
            }
        } else if (kg5.i != 1) {
            kg5.a aVar = kg5.p;
            if (aVar.b >= aVar.f2056a) {
                z = true;
            }
            bg5 bg5 = kg5.d;
            bg5.a("Sender", "Does Repetition Count Limit Reached : " + z);
            if (z) {
                int b = kg5.q.b();
                bg5 bg52 = kg5.d;
                bg52.a("Sender", "Transaction Time : " + b + " miliseconds");
                cg5 cg5 = kg5.j;
                cg5.b(AMQP.REPLY_SUCCESS, "Transaction Time : " + b + " miliseconds");
                kg5.d.b();
                kg5.j.e(AMQP.REPLY_SUCCESS);
                kg5.i = 1;
                return;
            }
            kg5.i = 2;
            kg5.q.a();
            bg5 bg53 = kg5.d;
            StringBuilder i0 = hj1.i0("Repeating play after ");
            i0.append(kg5.n);
            i0.append(" miliseconds");
            bg53.a("Sender", i0.toString());
            new Handler(Looper.getMainLooper()).postDelayed(new ig5(kg5), (long) kg5.n);
        } else {
            kg5.c("stop");
            kg5.j.a(400, "SDK Already Running");
        }
    }
}
