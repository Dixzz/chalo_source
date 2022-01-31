package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: ur4  reason: default package */
public final class ur4 implements vu4 {
    public static final nv4 f = new nv4("AssetPackServiceImpl");
    public static final Intent g = new Intent("com.google.android.play.core.assetmoduleservice.BIND_ASSET_MODULE_SERVICE").setPackage("com.android.vending");

    /* renamed from: a  reason: collision with root package name */
    public final String f3547a;
    public final ss4 b;
    public xv4<yw4> c;
    public xv4<yw4> d;
    public final AtomicBoolean e = new AtomicBoolean();

    public ur4(Context context, ss4 ss4) {
        this.f3547a = context.getPackageName();
        this.b = ss4;
        if (zv4.a(context)) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = applicationContext != null ? applicationContext : context;
            nv4 nv4 = f;
            Intent intent = g;
            this.c = new xv4<>(context2, nv4, "AssetPackService", intent, wu4.c);
            Context applicationContext2 = context.getApplicationContext();
            this.d = new xv4<>(applicationContext2 != null ? applicationContext2 : context, nv4, "AssetPackService-keepAlive", intent, wu4.b);
        }
        f.b(3, "AssetPackService initiated.", new Object[0]);
    }

    public static Bundle g() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 10901);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        bundle.putIntegerArrayList("supported_compression_formats", arrayList);
        bundle.putIntegerArrayList("supported_patch_formats", new ArrayList<>());
        return bundle;
    }

    public static /* synthetic */ Bundle h(Map map) {
        Bundle g2 = g();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            Bundle bundle = new Bundle();
            bundle.putString("installed_asset_module_name", (String) entry.getKey());
            bundle.putLong("installed_asset_module_version", ((Long) entry.getValue()).longValue());
            arrayList.add(bundle);
        }
        g2.putParcelableArrayList("installed_asset_module", arrayList);
        return g2;
    }

    public static Bundle i(int i, String str, String str2, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", i);
        bundle.putString("module_name", str);
        bundle.putString("slice_id", str2);
        bundle.putInt("chunk_number", i2);
        return bundle;
    }

    public static <T> ey4<T> l() {
        f.b(6, "onError(%d)", new Object[]{-11});
        ir4 ir4 = new ir4(-11);
        ey4<T> ey4 = new ey4<>();
        ey4.c(ir4);
        return ey4;
    }

    @Override // defpackage.vu4
    public final void a(int i) {
        if (this.c != null) {
            f.b(4, "notifySessionFailed", new Object[0]);
            ay4 ay4 = new ay4();
            this.c.a(new mr4(this, ay4, i, ay4));
            return;
        }
        throw new os4("The Play Store app is not installed or is an unofficial version.", i);
    }

    @Override // defpackage.vu4
    public final void b(int i, String str, String str2, int i2) {
        if (this.c != null) {
            f.b(4, "notifyChunkTransferred", new Object[0]);
            ay4 ay4 = new ay4();
            this.c.a(new kr4(this, ay4, i, str, str2, i2, ay4));
            return;
        }
        throw new os4("The Play Store app is not installed or is an unofficial version.", i);
    }

    @Override // defpackage.vu4
    public final void c(int i, String str) {
        k(i, str, 10);
    }

    @Override // defpackage.vu4
    public final ey4<ParcelFileDescriptor> d(int i, String str, String str2, int i2) {
        if (this.c == null) {
            return l();
        }
        f.b(4, "getChunkFileDescriptor(%s, %s, %d, session=%d)", new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i)});
        ay4 ay4 = new ay4();
        this.c.a(new nr4(this, ay4, i, str, str2, i2, ay4));
        return ay4.f348a;
    }

    @Override // defpackage.vu4
    public final ey4<List<String>> e(Map<String, Long> map) {
        if (this.c == null) {
            return l();
        }
        f.b(4, "syncPacks", new Object[0]);
        ay4 ay4 = new ay4();
        this.c.a(new yu4(this, ay4, map, ay4));
        return ay4.f348a;
    }

    @Override // defpackage.vu4
    public final void f(List<String> list) {
        if (this.c != null) {
            f.b(4, "cancelDownloads(%s)", new Object[]{list});
            ay4 ay4 = new ay4();
            this.c.a(new xu4(this, ay4, list, ay4));
        }
    }

    @Override // defpackage.vu4
    public final synchronized void j() {
        if (this.d == null) {
            f.b(5, "Keep alive connection manager is not initialized.", new Object[0]);
            return;
        }
        nv4 nv4 = f;
        nv4.b(4, "keepAlive", new Object[0]);
        if (!this.e.compareAndSet(false, true)) {
            nv4.b(4, "Service is already kept alive.", new Object[0]);
            return;
        }
        ay4 ay4 = new ay4();
        this.d.a(new or4(this, ay4, ay4));
    }

    public final void k(int i, String str, int i2) {
        if (this.c != null) {
            f.b(4, "notifyModuleCompleted", new Object[0]);
            ay4 ay4 = new ay4();
            this.c.a(new lr4(this, ay4, i, str, ay4, i2));
            return;
        }
        throw new os4("The Play Store app is not installed or is an unofficial version.", i);
    }
}
