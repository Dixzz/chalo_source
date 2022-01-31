package defpackage;

import android.content.Context;
import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.FreshchatUser;
import com.freshchat.consumer.sdk.exception.MethodNotAllowedException;
import java.util.Map;

/* renamed from: id1  reason: default package */
/* compiled from: KonotorSender */
public class id1 implements hd1 {

    /* renamed from: a  reason: collision with root package name */
    public Context f1505a;
    public zc1 b;

    public id1(Context context, zc1 zc1) {
        this.f1505a = context;
        this.b = zc1;
    }

    @Override // defpackage.hd1
    public void a(String str) {
        Freshchat instance = Freshchat.getInstance(this.f1505a);
        FreshchatUser user = instance.getUser();
        user.setEmail(str);
        try {
            instance.setUser(user);
            if (this.b.b() != null) {
                instance.setUserProperty("email", this.b.b());
            }
        } catch (MethodNotAllowedException e) {
            e.printStackTrace();
        }
    }

    @Override // defpackage.hd1
    public void b(String str) {
        Freshchat instance = Freshchat.getInstance(this.f1505a);
        FreshchatUser user = instance.getUser();
        user.setFirstName(str);
        try {
            instance.setUser(user);
            if (this.b.d() != null) {
                instance.setUserProperty("name", this.b.d());
            }
        } catch (MethodNotAllowedException e) {
            e.printStackTrace();
        }
    }

    @Override // defpackage.hd1
    public void c() {
    }

    @Override // defpackage.hd1
    public void d(String str, double d) {
    }

    @Override // defpackage.hd1
    public void e(Map<String, String> map) {
        try {
            Freshchat.getInstance(this.f1505a).setUserProperties(map);
        } catch (MethodNotAllowedException e) {
            e.printStackTrace();
        }
        if (this.b.d() != null) {
            b(this.b.d());
        }
        if (this.b.b() != null) {
            a(this.b.b());
        }
    }

    @Override // defpackage.hd1
    public void f(Map<String, String> map) {
    }

    @Override // defpackage.hd1
    public void g(ed1 ed1) {
    }
}
