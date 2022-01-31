package defpackage;

import com.urbanairship.push.PushMessage;

/* renamed from: xu5  reason: default package */
/* compiled from: MessageCenter */
public class xu5 implements uv5 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ yu5 f3966a;

    public xu5(yu5 yu5) {
        this.f3966a = yu5;
    }

    @Override // defpackage.uv5
    public void a(PushMessage pushMessage, boolean z) {
        if (!hd3.G1(pushMessage.h()) && this.f3966a.g.d(pushMessage.h()) == null) {
            yj5.a("Received a Rich Push.", new Object[0]);
            this.f3966a.g.b(null, null);
        }
    }
}
