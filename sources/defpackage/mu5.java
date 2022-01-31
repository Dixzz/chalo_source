package defpackage;

import defpackage.rt5;

/* renamed from: mu5  reason: default package */
/* compiled from: Inbox */
public class mu5 implements xl5 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ qt5 f2448a;

    public mu5(qu5 qu5, qt5 qt5) {
        this.f2448a = qt5;
    }

    @Override // defpackage.xl5
    public void a(long j) {
        rt5.b a2 = rt5.a();
        a2.f3130a = "ACTION_RICH_PUSH_MESSAGES_UPDATE";
        a2.b(yu5.class);
        this.f2448a.a(a2.a());
    }

    @Override // defpackage.xl5
    public void b(long j) {
        rt5.b a2 = rt5.a();
        a2.f3130a = "ACTION_SYNC_MESSAGE_STATE";
        a2.b(yu5.class);
        this.f2448a.a(a2.a());
    }
}
