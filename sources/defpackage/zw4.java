package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* renamed from: zw4  reason: default package */
public abstract class zw4 extends pw4 implements ax4 {
    public zw4() {
        super("com.google.android.play.core.assetpacks.protocol.IAssetModuleServiceCallback");
    }

    @Override // defpackage.pw4
    public final boolean C(int i, Parcel parcel) throws RemoteException {
        switch (i) {
            case 2:
                int readInt = parcel.readInt();
                Bundle bundle = (Bundle) qw4.a(parcel, Bundle.CREATOR);
                ((pr4) this).g.c.b();
                ur4.f.b(4, "onStartDownload(%d)", new Object[]{Integer.valueOf(readInt)});
                break;
            case 3:
                int readInt2 = parcel.readInt();
                Bundle bundle2 = (Bundle) qw4.a(parcel, Bundle.CREATOR);
                ((pr4) this).g.c.b();
                ur4.f.b(4, "onCancelDownload(%d)", new Object[]{Integer.valueOf(readInt2)});
                break;
            case 4:
                int readInt3 = parcel.readInt();
                Bundle bundle3 = (Bundle) qw4.a(parcel, Bundle.CREATOR);
                ((pr4) this).g.c.b();
                ur4.f.b(4, "onGetSession(%d)", new Object[]{Integer.valueOf(readInt3)});
                break;
            case 5:
                b3(parcel.createTypedArrayList(Bundle.CREATOR));
                break;
            case 6:
                Parcelable.Creator creator = Bundle.CREATOR;
                Bundle bundle4 = (Bundle) qw4.a(parcel, creator);
                Bundle bundle5 = (Bundle) qw4.a(parcel, creator);
                ((pr4) this).g.c.b();
                ur4.f.b(4, "onNotifyChunkTransferred(%s, %s, %d, session=%d)", new Object[]{bundle4.getString("module_name"), bundle4.getString("slice_id"), Integer.valueOf(bundle4.getInt("chunk_number")), Integer.valueOf(bundle4.getInt("session_id"))});
                break;
            case 7:
                J2((Bundle) qw4.a(parcel, Bundle.CREATOR));
                break;
            case 8:
                Parcelable.Creator creator2 = Bundle.CREATOR;
                Bundle bundle6 = (Bundle) qw4.a(parcel, creator2);
                Bundle bundle7 = (Bundle) qw4.a(parcel, creator2);
                ((pr4) this).g.c.b();
                ur4.f.b(4, "onNotifyModuleCompleted(%s, sessionId=%d)", new Object[]{bundle6.getString("module_name"), Integer.valueOf(bundle6.getInt("session_id"))});
                break;
            case 9:
            default:
                return false;
            case 10:
                Parcelable.Creator creator3 = Bundle.CREATOR;
                Bundle bundle8 = (Bundle) qw4.a(parcel, creator3);
                ((pr4) this).g.c.b();
                ur4.f.b(4, "onNotifySessionFailed(%d)", new Object[]{Integer.valueOf(((Bundle) qw4.a(parcel, creator3)).getInt("session_id"))});
                break;
            case 11:
                Parcelable.Creator creator4 = Bundle.CREATOR;
                w2((Bundle) qw4.a(parcel, creator4), (Bundle) qw4.a(parcel, creator4));
                break;
            case 12:
                Parcelable.Creator creator5 = Bundle.CREATOR;
                O2((Bundle) qw4.a(parcel, creator5), (Bundle) qw4.a(parcel, creator5));
                break;
            case 13:
                Parcelable.Creator creator6 = Bundle.CREATOR;
                Bundle bundle9 = (Bundle) qw4.a(parcel, creator6);
                Bundle bundle10 = (Bundle) qw4.a(parcel, creator6);
                ((pr4) this).g.c.b();
                ur4.f.b(4, "onRequestDownloadInfo()", new Object[0]);
                break;
            case 14:
                Parcelable.Creator creator7 = Bundle.CREATOR;
                Bundle bundle11 = (Bundle) qw4.a(parcel, creator7);
                Bundle bundle12 = (Bundle) qw4.a(parcel, creator7);
                ((pr4) this).g.c.b();
                ur4.f.b(4, "onRemoveModule()", new Object[0]);
                break;
            case 15:
                Bundle bundle13 = (Bundle) qw4.a(parcel, Bundle.CREATOR);
                ((pr4) this).g.c.b();
                ur4.f.b(4, "onCancelDownloads()", new Object[0]);
                break;
        }
        return true;
    }
}
