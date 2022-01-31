package defpackage;

import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import com.google.android.gms.cloudmessaging.zza;

/* renamed from: c22  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final class c22 {

    /* renamed from: a  reason: collision with root package name */
    public final Messenger f507a;
    public final zza b;

    public c22(IBinder iBinder) throws RemoteException {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.f507a = new Messenger(iBinder);
            this.b = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.b = new zza(iBinder);
            this.f507a = null;
        } else {
            String valueOf = String.valueOf(interfaceDescriptor);
            if (valueOf.length() != 0) {
                "Invalid interface descriptor: ".concat(valueOf);
            } else {
                new String("Invalid interface descriptor: ");
            }
            throw new RemoteException();
        }
    }
}
