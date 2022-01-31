package defpackage;

import android.content.Intent;
import android.os.Bundle;
import com.freshchat.consumer.sdk.beans.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* renamed from: us4  reason: default package */
public final /* synthetic */ class us4 implements ct4 {

    /* renamed from: a  reason: collision with root package name */
    public final dt4 f3551a;
    public final Bundle b;
    public final /* synthetic */ int c = 0;

    public us4(dt4 dt4, Bundle bundle) {
        this.f3551a = dt4;
        this.b = bundle;
    }

    public us4(dt4 dt4, Bundle bundle, byte[] bArr) {
        this.f3551a = dt4;
        this.b = bundle;
    }

    @Override // defpackage.ct4
    public final Object a() {
        Boolean bool = Boolean.FALSE;
        Boolean bool2 = Boolean.TRUE;
        boolean z = true;
        if (this.c != 0) {
            dt4 dt4 = this.f3551a;
            Bundle bundle = this.b;
            Objects.requireNonNull(dt4);
            int i = bundle.getInt("session_id");
            if (i == 0) {
                return bool;
            }
            Map<Integer, at4> map = dt4.e;
            Integer valueOf = Integer.valueOf(i);
            if (map.containsKey(valueOf)) {
                at4 c2 = dt4.c(i);
                int i2 = bundle.getInt(hd3.L0("status", c2.c.f4206a));
                if (mt4.g(c2.c.c, i2)) {
                    dt4.g.b(3, "Found stale update for session %s with status %d.", new Object[]{valueOf, Integer.valueOf(c2.c.c)});
                    zs4 zs4 = c2.c;
                    String str = zs4.f4206a;
                    int i3 = zs4.c;
                    if (i3 == 4) {
                        dt4.b.a().c(i, str);
                    } else if (i3 == 5) {
                        dt4.b.a().a(i);
                    } else if (i3 == 6) {
                        dt4.b.a().f(Arrays.asList(str));
                    }
                } else {
                    c2.c.c = i2;
                    if (mt4.e(i2)) {
                        dt4.a(i);
                        dt4.c.a(c2.c.f4206a);
                    } else {
                        for (bt4 bt4 : c2.c.e) {
                            ArrayList parcelableArrayList = bundle.getParcelableArrayList(hd3.T0("chunk_intents", c2.c.f4206a, bt4.f473a));
                            if (parcelableArrayList != null) {
                                for (int i4 = 0; i4 < parcelableArrayList.size(); i4++) {
                                    if (!(parcelableArrayList.get(i4) == null || ((Intent) parcelableArrayList.get(i4)).getData() == null)) {
                                        bt4.d.get(i4).f4083a = true;
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                String d = dt4.d(bundle);
                long j = bundle.getLong(hd3.L0("pack_version", d));
                int i5 = bundle.getInt(hd3.L0("status", d));
                long j2 = bundle.getLong(hd3.L0("total_bytes_to_download", d));
                List<String> stringArrayList = bundle.getStringArrayList(hd3.L0("slice_ids", d));
                ArrayList arrayList = new ArrayList();
                if (stringArrayList == null) {
                    stringArrayList = Collections.emptyList();
                }
                for (String str2 : stringArrayList) {
                    List<Intent> parcelableArrayList2 = bundle.getParcelableArrayList(hd3.T0("chunk_intents", d, str2));
                    ArrayList arrayList2 = new ArrayList();
                    if (parcelableArrayList2 == null) {
                        parcelableArrayList2 = Collections.emptyList();
                    }
                    for (Intent intent : parcelableArrayList2) {
                        if (intent == null) {
                            z = false;
                        }
                        arrayList2.add(new ys4(z));
                        z = true;
                    }
                    String string = bundle.getString(hd3.T0("uncompressed_hash_sha256", d, str2));
                    long j3 = bundle.getLong(hd3.T0("uncompressed_size", d, str2));
                    int i6 = bundle.getInt(hd3.T0("patch_format", d, str2), 0);
                    arrayList.add(i6 != 0 ? new bt4(str2, string, j3, arrayList2, 0, i6) : new bt4(str2, string, j3, arrayList2, bundle.getInt(hd3.T0("compression_format", d, str2), 0), 0));
                    z = true;
                }
                dt4.e.put(Integer.valueOf(i), new at4(i, bundle.getInt(User.DEVICE_META_APP_VERSION_CODE), new zs4(d, j, i5, j2, arrayList)));
            }
            return bool2;
        }
        dt4 dt42 = this.f3551a;
        Bundle bundle2 = this.b;
        Objects.requireNonNull(dt42);
        int i7 = bundle2.getInt("session_id");
        if (i7 != 0) {
            Map<Integer, at4> map2 = dt42.e;
            Integer valueOf2 = Integer.valueOf(i7);
            if (map2.containsKey(valueOf2)) {
                at4 at4 = dt42.e.get(valueOf2);
                if (at4.c.c == 6) {
                    return bool;
                }
                return Boolean.valueOf(!mt4.g(at4.c.c, bundle2.getInt(hd3.L0("status", dt4.d(bundle2)))));
            }
        }
        return bool2;
    }
}
