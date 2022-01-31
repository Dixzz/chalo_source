package defpackage;

import android.database.Cursor;
import defpackage.dy1;
import java.util.ArrayList;

/* renamed from: gx1  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class gx1 implements dy1.b {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ gx1 f1311a = new gx1();

    @Override // defpackage.dy1.b
    public final Object apply(Object obj) {
        Cursor cursor = (Cursor) obj;
        zt1 zt1 = dy1.j;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i += blob.length;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            byte[] bArr2 = (byte[]) arrayList.get(i3);
            System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
            i2 += bArr2.length;
        }
        return bArr;
    }
}
