package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.urbanairship.UAirship;
import com.urbanairship.messagecenter.MessageCenterActivity;
import defpackage.ik5;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: yu5  reason: default package */
/* compiled from: MessageCenter */
public class yu5 extends oj5 {
    public final ik5 e;
    public final vv5 f;
    public final qu5 g;
    public final uv5 h;
    public AtomicBoolean i = new AtomicBoolean(false);

    /* renamed from: yu5$a */
    /* compiled from: MessageCenter */
    public class a implements ik5.a {
        public a() {
        }

        @Override // defpackage.ik5.a
        public void a() {
            yu5.this.l();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public yu5(Context context, hk5 hk5, ik5 ik5, kp5 kp5, vv5 vv5) {
        super(context, hk5);
        qu5 qu5 = new qu5(context, hk5, kp5);
        this.e = ik5;
        this.f = vv5;
        this.g = qu5;
        this.h = new xu5(this);
    }

    public static String i(Intent intent) {
        if (intent == null || intent.getData() == null || intent.getAction() == null || !"message".equalsIgnoreCase(intent.getData().getScheme())) {
            return null;
        }
        String action = intent.getAction();
        action.hashCode();
        if (action.equals("com.urbanairship.VIEW_RICH_PUSH_INBOX") || action.equals("com.urbanairship.VIEW_RICH_PUSH_MESSAGE")) {
            return intent.getData().getSchemeSpecificPart();
        }
        return null;
    }

    public static yu5 j() {
        return (yu5) UAirship.l().k(yu5.class);
    }

    @Override // defpackage.oj5
    public int a() {
        return 2;
    }

    @Override // defpackage.oj5
    public void b() {
        super.b();
        ik5 ik5 = this.e;
        ik5.b.add(new a());
        l();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009f, code lost:
        if ((r4 + 86400000) >= r6) goto L_0x021c;
     */
    @Override // defpackage.oj5
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int g(com.urbanairship.UAirship r13, defpackage.rt5 r14) {
        /*
        // Method dump skipped, instructions count: 541
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yu5.g(com.urbanairship.UAirship, rt5):int");
    }

    @Override // defpackage.oj5
    public void h() {
        this.g.a(true);
    }

    public void k(String str) {
        if (!this.e.d(2)) {
            yj5.i("Unable to show Message Center. FEATURE_MESSAGE_CENTER is not enabled in PrivacyManager.", new Object[0]);
            return;
        }
        Intent addFlags = new Intent("com.urbanairship.VIEW_RICH_PUSH_INBOX").setPackage(this.c.getPackageName()).addFlags(805306368);
        if (str != null) {
            addFlags.setData(Uri.fromParts("message", str, null));
        }
        if (addFlags.resolveActivity(this.c.getPackageManager()) != null) {
            this.c.startActivity(addFlags);
            return;
        }
        if (str != null) {
            addFlags.setAction("com.urbanairship.VIEW_RICH_PUSH_MESSAGE");
            if (addFlags.resolveActivity(this.c.getPackageManager()) != null) {
                this.c.startActivity(addFlags);
                return;
            }
        }
        addFlags.setClass(this.c, MessageCenterActivity.class);
        this.c.startActivity(addFlags);
    }

    public void l() {
        boolean d = this.e.d(2);
        this.g.u.set(d);
        qu5 qu5 = this.g;
        if (!qu5.u.get()) {
            qu5.h.execute(new su5(qu5));
            synchronized (qu5.y) {
                qu5.c.clear();
                qu5.d.clear();
                qu5.b.clear();
            }
            qu5.g();
            uu5 uu5 = qu5.t;
            if (uu5 != null) {
                uu5.d.l("com.urbanairship.user.LAST_MESSAGE_REFRESH_TIME");
                uu5.d.l("com.urbanairship.user.LAST_UPDATE_TIME");
            }
            qu5.j();
        } else if (!qu5.v.getAndSet(true)) {
            qu5.g.f2125a.add(qu5.p);
            qu5.i(false);
            qu5.q.a(qu5.m);
            qu5.r.j.add(qu5.n);
            kv5 kv5 = qu5.g;
            if (kv5.c.l() != null && !kv5.b.g("com.urbanairship.user.REGISTERED_CHANNEL_ID", "").equals(kv5.c.l())) {
                qu5.a(true);
            }
            qu5.r.k.add(qu5.o);
        }
        if (!d) {
            this.g.j();
            vv5 vv5 = this.f;
            uv5 uv5 = this.h;
            vv5.r.remove(uv5);
            vv5.s.remove(uv5);
            this.i.set(false);
        } else if (!this.i.getAndSet(true)) {
            yj5.h("Initializing Inbox...", new Object[0]);
            this.f.s.add(this.h);
        }
    }
}
