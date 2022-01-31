package defpackage;

import android.os.Bundle;
import android.util.Log;
import com.google.firebase.iid.GmsRpc;
import java.io.IOException;

/* renamed from: h22  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final /* synthetic */ class h22 implements qi4 {

    /* renamed from: a  reason: collision with root package name */
    public static final qi4 f1333a = new h22();

    @Override // defpackage.qi4
    public final Object then(yi4 yi4) {
        int i = o12.h;
        if (yi4.q()) {
            return (Bundle) yi4.m();
        }
        if (Log.isLoggable("Rpc", 3)) {
            String.valueOf(yi4.l()).length();
        }
        throw new IOException(GmsRpc.ERROR_SERVICE_NOT_AVAILABLE, yi4.l());
    }
}
