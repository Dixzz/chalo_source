package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* renamed from: ma4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public abstract class ma4 extends mq3 implements ja4 {
    public ma4() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // defpackage.mq3
    public final boolean C(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        ArrayList arrayList;
        boolean z = false;
        switch (i) {
            case 1:
                ((ac4) this).H2((zzaq) hp3.a(parcel, zzaq.CREATOR), (zzn) hp3.a(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                zzku zzku = (zzku) hp3.a(parcel, zzku.CREATOR);
                zzn zzn = (zzn) hp3.a(parcel, zzn.CREATOR);
                ac4 ac4 = (ac4) this;
                Objects.requireNonNull(zzku, "null reference");
                ac4.M3(zzn);
                ac4.L(new pc4(ac4, zzku, zzn));
                parcel2.writeNoException();
                break;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                zzn zzn2 = (zzn) hp3.a(parcel, zzn.CREATOR);
                ac4 ac42 = (ac4) this;
                ac42.M3(zzn2);
                ac42.L(new rc4(ac42, zzn2));
                parcel2.writeNoException();
                break;
            case 5:
                zzaq zzaq = (zzaq) hp3.a(parcel, zzaq.CREATOR);
                String readString = parcel.readString();
                parcel.readString();
                ac4 ac43 = (ac4) this;
                Objects.requireNonNull(zzaq, "null reference");
                gj1.j(readString);
                ac43.C1(readString, true);
                ac43.L(new nc4(ac43, zzaq, readString));
                parcel2.writeNoException();
                break;
            case 6:
                zzn zzn3 = (zzn) hp3.a(parcel, zzn.CREATOR);
                ac4 ac44 = (ac4) this;
                ac44.M3(zzn3);
                ac44.L(new dc4(ac44, zzn3));
                parcel2.writeNoException();
                break;
            case 7:
                zzn zzn4 = (zzn) hp3.a(parcel, zzn.CREATOR);
                if (parcel.readInt() != 0) {
                    z = true;
                }
                ac4 ac45 = (ac4) this;
                ac45.M3(zzn4);
                try {
                    List<vg4> list = (List) ((FutureTask) ac45.f.f().s(new oc4(ac45, zzn4))).get();
                    arrayList = new ArrayList(list.size());
                    for (vg4 vg4 : list) {
                        if (z || !ug4.q0(vg4.c)) {
                            arrayList.add(new zzku(vg4));
                        }
                    }
                } catch (InterruptedException | ExecutionException e) {
                    ac45.f.g().f.c("Failed to get user properties. appId", ra4.q(zzn4.f), e);
                    arrayList = null;
                }
                parcel2.writeNoException();
                parcel2.writeTypedList(arrayList);
                break;
            case 9:
                byte[] R = ((ac4) this).R((zzaq) hp3.a(parcel, zzaq.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(R);
                break;
            case 10:
                ((ac4) this).l1(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 11:
                String O0 = ((ac4) this).O0((zzn) hp3.a(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(O0);
                break;
            case 12:
                ((ac4) this).v3((zzz) hp3.a(parcel, zzz.CREATOR), (zzn) hp3.a(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                break;
            case 13:
                ((ac4) this).F((zzz) hp3.a(parcel, zzz.CREATOR));
                parcel2.writeNoException();
                break;
            case 14:
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                ClassLoader classLoader = hp3.f1408a;
                if (parcel.readInt() != 0) {
                    z = true;
                }
                List<zzku> L1 = ((ac4) this).L1(readString2, readString3, z, (zzn) hp3.a(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(L1);
                break;
            case 15:
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                ClassLoader classLoader2 = hp3.f1408a;
                if (parcel.readInt() != 0) {
                    z = true;
                }
                List<zzku> p0 = ((ac4) this).p0(readString4, readString5, readString6, z);
                parcel2.writeNoException();
                parcel2.writeTypedList(p0);
                break;
            case 16:
                List<zzz> s1 = ((ac4) this).s1(parcel.readString(), parcel.readString(), (zzn) hp3.a(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(s1);
                break;
            case 17:
                List<zzz> q1 = ((ac4) this).q1(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(q1);
                break;
            case 18:
                zzn zzn5 = (zzn) hp3.a(parcel, zzn.CREATOR);
                ac4 ac46 = (ac4) this;
                ac46.C1(zzn5.f, false);
                ac46.L(new ic4(ac46, zzn5));
                parcel2.writeNoException();
                break;
            case 19:
                ((ac4) this).P2((Bundle) hp3.a(parcel, Bundle.CREATOR), (zzn) hp3.a(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                break;
            case 20:
                ((ac4) this).S((zzn) hp3.a(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                break;
        }
        return true;
    }
}
