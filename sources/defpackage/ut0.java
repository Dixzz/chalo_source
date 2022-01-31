package defpackage;

import app.zophop.models.LiveRouteData;
import defpackage.mt0;

/* renamed from: ut0  reason: default package */
/* compiled from: BusRouteFragment */
public class ut0 implements ji1<Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ mt0 f3553a;

    public ut0(mt0 mt0) {
        this.f3553a = mt0;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ji1
    public void a(String str) {
        if (this.f3553a.isAdded()) {
            b();
            if (!this.f3553a.r.isLiveFeedProvider()) {
                this.f3553a.h();
            }
        }
    }

    public final void b() {
        if (!this.f3553a.r.getFirebaseResponse().equals(mt0.h.SUCCESS)) {
            LiveRouteData liveRouteData = this.f3553a.r;
            mt0.h hVar = mt0.h.FAILED;
            liveRouteData.setFirebaseResponse(hVar);
            if (!this.f3553a.r.isLiveFeedProvider() || this.f3553a.r.getLiveFeedResponse().equals(hVar)) {
                this.f3553a.l();
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ji1
    public void onSuccess(Integer num) {
        Integer num2 = num;
        if (this.f3553a.isAdded()) {
            if (num2.intValue() > 0) {
                this.f3553a.r.setFirebaseResponse(mt0.h.SUCCESS);
            } else if (!this.f3553a.r.getFirebaseResponse().equals(mt0.h.SUCCESS)) {
                b();
            }
            if (!this.f3553a.r.isLiveFeedProvider()) {
                this.f3553a.h();
            }
        }
    }
}
