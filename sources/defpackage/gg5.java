package defpackage;

import com.trillbit.datasdk.core.CWrapper;
import defpackage.kg5;
import java.util.Objects;

/* renamed from: gg5  reason: default package */
/* compiled from: Sender */
public class gg5 extends pg5 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ kg5 f1257a;

    public gg5(kg5 kg5) {
        this.f1257a = kg5;
    }

    @Override // defpackage.pg5
    public void a(int i, int i2) {
    }

    @Override // defpackage.pg5
    public void b(short[] sArr) {
        kg5 kg5 = this.f1257a;
        if (kg5.i == 6 && sArr.length > 0) {
            CWrapper cWrapper = kg5.f;
            Objects.requireNonNull(cWrapper);
            try {
                CWrapper.addBuffer(sArr, sArr.length, cWrapper.b);
            } catch (NullPointerException unused) {
            }
            kg5 kg52 = this.f1257a;
            kg5.a aVar = kg52.p;
            int length = aVar.d + sArr.length;
            aVar.d = length;
            if (length > aVar.e) {
                kg52.d.a("Sender", "Recorder Timeout Reached");
                kg5.a(this.f1257a);
            }
        } else if (sArr.length == 0) {
            kg5.d.a("Sender", "Buffer length 0 obtained");
        }
    }

    @Override // defpackage.pg5
    public void c(String str) {
    }

    @Override // defpackage.pg5
    public void d(int i) {
        if (i == 4) {
            kg5 kg5 = this.f1257a;
            kg5.d("start_processor");
            if (kg5.i == 5) {
                kg5.i = 6;
                kg5.b.b(new jg5(kg5));
            }
        } else if (i == 0) {
            kg5 kg52 = this.f1257a;
            kg52.d("stop_processor");
            kg52.b.h = false;
        }
    }
}
