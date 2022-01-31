package defpackage;

import com.rabbitmq.client.AMQP;
import com.razorpay.AnalyticsConstants;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: jg5  reason: default package */
/* compiled from: Sender */
public class jg5 extends og5 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ kg5 f1923a;

    public jg5(kg5 kg5) {
        this.f1923a = kg5;
    }

    @Override // defpackage.og5
    public void a() {
        Objects.requireNonNull(this.f1923a);
        this.f1923a.p.e = 132300;
    }

    @Override // defpackage.og5
    public void b(float f) {
        Objects.requireNonNull(this.f1923a);
        kg5 kg5 = this.f1923a;
        if (kg5.i == 6) {
            kg5.d.a("Sender", "Unable to decoded");
            kg5.a(this.f1923a);
        }
    }

    @Override // defpackage.og5
    public void c(byte[] bArr) {
        Objects.requireNonNull(this.f1923a);
        if (Arrays.equals(bArr, new byte[]{-120, -120})) {
            kg5 kg5 = this.f1923a;
            Objects.requireNonNull(kg5);
            kg5.d.a("Sender", "Nack found");
            kg5 kg52 = this.f1923a;
            if (kg52.i == 6) {
                kg52.j.b(AMQP.REPLY_SUCCESS, "Nack Received, Retry.");
                kg5.a(this.f1923a);
                return;
            }
            return;
        }
        int abs = Math.abs((int) bArr[1]) + (Math.abs((int) bArr[0]) * 100);
        int i = abs > 999 ? abs / 10 : abs;
        Objects.requireNonNull(this.f1923a);
        String.valueOf(abs);
        String.valueOf(this.f1923a.l);
        kg5 kg53 = this.f1923a;
        int i2 = kg53.l;
        if (i2 != 0 && i2 == i) {
            kg53.j.c(abs);
            this.f1923a.d.a("Sender", "Session Successful");
            kg5 kg54 = this.f1923a;
            kg54.d("stop");
            if (kg54.i != 1) {
                kg54.e();
                int b = kg54.q.b();
                bg5 bg5 = kg54.d;
                bg5.a("Sender", "Transaction Time : " + b + " milliseconds");
                cg5 cg5 = kg54.j;
                cg5.b(AMQP.REPLY_SUCCESS, "Transaction Time : " + b + " milliseconds");
                kg54.d.b();
            } else {
                kg54.c(AnalyticsConstants.START);
                kg54.j.a(400, "SDK Already Running");
            }
        }
        kg5 kg55 = this.f1923a;
        Objects.requireNonNull(kg55);
        kg55.d.a("Sender", "Expecting Code: " + this.f1923a.l + " Code Received : " + abs);
    }

    @Override // defpackage.og5
    public void d(String str) {
    }

    @Override // defpackage.og5
    public void e() {
        Objects.requireNonNull(this.f1923a);
        this.f1923a.p.e = 132300;
    }
}
