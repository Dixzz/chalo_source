package defpackage;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import java.util.HashMap;

@Encodable
/* renamed from: ya3  reason: default package */
/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public abstract class ya3 {

    /* renamed from: a  reason: collision with root package name */
    public static final ua3 f4025a;

    static {
        ta3 ta3 = new ta3();
        ta3.registerEncoder(ya3.class, xa3.f3909a);
        ta3.registerEncoder(MessagingClientEventExtension.class, wa3.f3752a);
        ta3.registerEncoder(MessagingClientEvent.class, pa3.f2789a);
        f4025a = new ua3(new HashMap(ta3.f3326a), new HashMap(ta3.b), ta3.c);
    }

    public abstract MessagingClientEventExtension a();
}
