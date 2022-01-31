package defpackage;

import android.content.Intent;
import android.location.Location;
import android.os.Parcel;
import com.google.android.gms.internal.location.zzbh;
import java.util.ArrayList;
import java.util.List;

/* renamed from: f34  reason: default package */
public class f34 {

    /* renamed from: a  reason: collision with root package name */
    public final int f1068a;
    public final int b;
    public final List<c34> c;

    public f34(int i, int i2, List<c34> list, Location location) {
        this.f1068a = i;
        this.b = i2;
        this.c = list;
    }

    public static f34 a(Intent intent) {
        ArrayList arrayList = null;
        if (intent == null) {
            return null;
        }
        int i = -1;
        int intExtra = intent.getIntExtra("gms_error_code", -1);
        int intExtra2 = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        if (intExtra2 != -1 && (intExtra2 == 1 || intExtra2 == 2 || intExtra2 == 4)) {
            i = intExtra2;
        }
        ArrayList arrayList2 = (ArrayList) intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (arrayList2 != null) {
            arrayList = new ArrayList(arrayList2.size());
            int size = arrayList2.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList2.get(i2);
                i2++;
                byte[] bArr = (byte[]) obj;
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(bArr, 0, bArr.length);
                obtain.setDataPosition(0);
                obtain.recycle();
                arrayList.add(zzbh.CREATOR.createFromParcel(obtain));
            }
        }
        return new f34(intExtra, i, arrayList, (Location) intent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
    }
}
