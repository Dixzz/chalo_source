package defpackage;

import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.ProfileRequestInfo;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.pubsub.eventbus.events.UserProfileEvent;

/* renamed from: t20  reason: default package */
/* compiled from: IProfileFeature */
public interface t20 {
    String a();

    @c60
    void b(ProfileRequestInfo profileRequestInfo);

    String c(MPass mPass, String str, String str2, String str3, ProfileRequestInfo profileRequestInfo, String str4);

    void d(UserProfileEvent.TYPE type);

    UserProfile e();

    boolean f();

    @c60
    void g(ProfileRequestInfo profileRequestInfo);

    String getUserId();

    void h(String str);

    void i(boolean z, String str);

    String j();

    void k(ProfileRequestInfo profileRequestInfo);

    void l(boolean z);

    boolean m();

    void n(UserProfile userProfile);

    void o();

    String p();

    String q();

    void r(String str, String str2, String str3, String str4, String str5);

    void s(UserProfile userProfile);

    String t();
}
