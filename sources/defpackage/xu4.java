package defpackage;

import android.os.Bundle;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: xu4  reason: default package */
public final class xu4 extends ov4 {
    public final /* synthetic */ List g;
    public final /* synthetic */ ay4 h;
    public final /* synthetic */ ur4 i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public xu4(ur4 ur4, ay4 ay4, List list, ay4 ay42) {
        super(ay4);
        this.i = ur4;
        this.g = list;
        this.h = ay42;
    }

    @Override // defpackage.ov4
    public final void a() {
        List<String> list = this.g;
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", str);
            arrayList.add(bundle);
        }
        try {
            ur4 ur4 = this.i;
            ((yw4) ur4.c.k).W(ur4.f3547a, arrayList, ur4.g(), new pr4(this.i, this.h, (byte[]) null));
        } catch (RemoteException e) {
            ur4.f.a(e, "cancelDownloads(%s)", this.g);
        }
    }
}
