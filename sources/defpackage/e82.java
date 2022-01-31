package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.zzai;
import java.util.Objects;

/* renamed from: e82  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public interface e82 extends IInterface {

    /* renamed from: e82$a */
    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public static abstract class a extends Binder implements e82 {
        public a() {
            attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }

        @RecentlyNonNull
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i, @RecentlyNonNull Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            d82 d82;
            if (i > 16777215) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder readStrongBinder = parcel.readStrongBinder();
            GetServiceRequest getServiceRequest = null;
            if (readStrongBinder == null) {
                d82 = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
                if (queryLocalInterface instanceof d82) {
                    d82 = (d82) queryLocalInterface;
                } else {
                    d82 = new va2(readStrongBinder);
                }
            }
            if (i == 46) {
                if (parcel.readInt() != 0) {
                    getServiceRequest = GetServiceRequest.CREATOR.createFromParcel(parcel);
                }
                getService(d82, getServiceRequest);
                Objects.requireNonNull(parcel2, "null reference");
                parcel2.writeNoException();
                return true;
            } else if (i == 47) {
                if (parcel.readInt() != 0) {
                    zzai.CREATOR.createFromParcel(parcel);
                }
                throw new UnsupportedOperationException();
            } else {
                parcel.readInt();
                if (i != 4) {
                    parcel.readString();
                    if (i != 1) {
                        if (!(i == 2 || i == 23 || i == 25 || i == 27)) {
                            if (i != 30) {
                                if (i != 34) {
                                    if (!(i == 41 || i == 43 || i == 37 || i == 38)) {
                                        switch (i) {
                                            case 9:
                                                parcel.readString();
                                                parcel.createStringArray();
                                                parcel.readString();
                                                parcel.readStrongBinder();
                                                parcel.readString();
                                                if (parcel.readInt() != 0) {
                                                    Bundle bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                                                    break;
                                                }
                                                break;
                                            case 10:
                                                parcel.readString();
                                                parcel.createStringArray();
                                                break;
                                            case 19:
                                                parcel.readStrongBinder();
                                                if (parcel.readInt() != 0) {
                                                    Bundle bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                                                    break;
                                                }
                                                break;
                                        }
                                    }
                                } else {
                                    parcel.readString();
                                }
                            }
                            parcel.createStringArray();
                            parcel.readString();
                            if (parcel.readInt() != 0) {
                                Bundle bundle3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                            }
                        }
                        if (parcel.readInt() != 0) {
                            Bundle bundle4 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                    } else {
                        parcel.readString();
                        parcel.createStringArray();
                        parcel.readString();
                        if (parcel.readInt() != 0) {
                            Bundle bundle5 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                    }
                }
                throw new UnsupportedOperationException();
            }
        }
    }

    void getService(@RecentlyNonNull d82 d82, GetServiceRequest getServiceRequest) throws RemoteException;
}
