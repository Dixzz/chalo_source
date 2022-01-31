package defpackage;

import android.os.Bundle;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: rr4  reason: default package */
public final class rr4 extends pr4<List<String>> {
    public final /* synthetic */ ur4 h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public rr4(ur4 ur4, ay4<List<String>> ay4) {
        super(ur4, ay4);
        this.h = ur4;
    }

    @Override // defpackage.pr4, defpackage.ax4
    public final void b3(List<Bundle> list) {
        this.g.c.b();
        ur4.f.b(4, "onGetSessionStates", new Object[0]);
        ur4 ur4 = this.h;
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : list) {
            ss4 ss4 = ur4.b;
            ArrayList arrayList2 = new ArrayList();
            zr4 zr4 = as4.b;
            ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
            HashMap hashMap = new HashMap();
            int size = stringArrayList.size();
            for (int i = 0; i < size; i++) {
                String str = stringArrayList.get(i);
                hashMap.put(str, AssetPackState.d(bundle, str, ss4, zr4));
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                hashMap.put(str2, AssetPackState.b(str2, 4, 0, 0, 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1));
            }
            bundle.getLong("total_bytes_to_download");
            AssetPackState assetPackState = (AssetPackState) hashMap.values().iterator().next();
            if (assetPackState == null) {
                ur4.f.b(6, "onGetSessionStates: Bundle contained no pack.", new Object[0]);
            }
            if (mt4.d(assetPackState.g())) {
                arrayList.add(assetPackState.f());
            }
        }
        this.f.b(arrayList);
    }
}
