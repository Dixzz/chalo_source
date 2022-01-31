package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.freshchat.consumer.sdk.beans.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: lt4  reason: default package */
public final class lt4 implements vu4 {
    public static final nv4 g = new nv4("FakeAssetPackService");

    /* renamed from: a  reason: collision with root package name */
    public final String f2267a;
    public final yr4 b;
    public final Context c;
    public final xt4 d;
    public final kw4<Executor> e;
    public final Handler f = new Handler(Looper.getMainLooper());

    static {
        new AtomicInteger(1);
    }

    public lt4(File file, yr4 yr4, ss4 ss4, Context context, xt4 xt4, kw4<Executor> kw4) {
        this.f2267a = file.getAbsolutePath();
        this.b = yr4;
        this.c = context;
        this.d = xt4;
        this.e = kw4;
    }

    public static long g(int i, long j) {
        if (i == 2) {
            return j / 2;
        }
        if (i == 3 || i == 4) {
            return j;
        }
        return 0;
    }

    @Override // defpackage.vu4
    public final void a(int i) {
        g.b(4, "notifySessionFailed", new Object[0]);
    }

    @Override // defpackage.vu4
    public final void b(int i, String str, String str2, int i2) {
        g.b(4, "notifyChunkTransferred", new Object[0]);
    }

    @Override // defpackage.vu4
    public final void c(int i, String str) {
        g.b(4, "notifyModuleCompleted", new Object[0]);
        this.e.a().execute(new it4(this, i, str));
    }

    @Override // defpackage.vu4
    public final ey4<ParcelFileDescriptor> d(int i, String str, String str2, int i2) {
        g.b(4, "getChunkFileDescriptor(session=%d, %s, %s, %d)", new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2)});
        ey4<ParcelFileDescriptor> ey4 = new ey4<>();
        try {
            File[] h = h(str);
            for (File file : h) {
                if (hd3.x(file).equals(str2)) {
                    ey4.a(ParcelFileDescriptor.open(file, 268435456));
                    return ey4;
                }
            }
            throw new zu4(String.format("Local testing slice for '%s' not found.", str2));
        } catch (FileNotFoundException e2) {
            g.b(5, "getChunkFileDescriptor failed", new Object[]{e2});
            ey4.c(new zu4("Asset Slice file not found.", e2));
        } catch (zu4 e3) {
            g.b(5, "getChunkFileDescriptor failed", new Object[]{e3});
            ey4.c(e3);
        }
    }

    @Override // defpackage.vu4
    public final ey4<List<String>> e(Map<String, Long> map) {
        g.b(4, "syncPacks()", new Object[0]);
        ArrayList arrayList = new ArrayList();
        ey4<List<String>> ey4 = new ey4<>();
        ey4.a(arrayList);
        return ey4;
    }

    @Override // defpackage.vu4
    public final void f(List<String> list) {
        g.b(4, "cancelDownload(%s)", new Object[]{list});
    }

    public final File[] h(String str) throws zu4 {
        File file = new File(this.f2267a);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles(new jt4(str));
            if (listFiles != null) {
                int length = listFiles.length;
                if (length != 0) {
                    for (File file2 : listFiles) {
                        if (hd3.x(file2).equals(str)) {
                            return listFiles;
                        }
                    }
                    throw new zu4(String.format("No master slice available for pack '%s'.", str));
                }
                throw new zu4(String.format("No APKs available for pack '%s'.", str));
            }
            throw new zu4(String.format("Failed fetching APKs for pack '%s'.", str));
        }
        throw new zu4(String.format("Local testing directory '%s' not found.", file));
    }

    public final void i(int i, String str, int i2) throws zu4 {
        Bundle bundle = new Bundle();
        bundle.putInt(User.DEVICE_META_APP_VERSION_CODE, this.d.a());
        bundle.putInt("session_id", i);
        File[] h = h(str);
        ArrayList<String> arrayList = new ArrayList<>();
        long j = 0;
        for (File file : h) {
            j += file.length();
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
            arrayList2.add(i2 == 3 ? new Intent().setData(Uri.EMPTY) : null);
            String x = hd3.x(file);
            bundle.putParcelableArrayList(hd3.T0("chunk_intents", str, x), arrayList2);
            try {
                bundle.putString(hd3.T0("uncompressed_hash_sha256", str, x), mt4.a(Arrays.asList(file)));
                bundle.putLong(hd3.T0("uncompressed_size", str, x), file.length());
                arrayList.add(x);
            } catch (NoSuchAlgorithmException e2) {
                throw new zu4("SHA256 algorithm not supported.", e2);
            } catch (IOException e3) {
                throw new zu4(String.format("Could not digest file: %s.", file), e3);
            }
        }
        bundle.putStringArrayList(hd3.L0("slice_ids", str), arrayList);
        bundle.putLong(hd3.L0("pack_version", str), (long) this.d.a());
        bundle.putInt(hd3.L0("status", str), i2);
        bundle.putInt(hd3.L0("error_code", str), 0);
        bundle.putLong(hd3.L0("bytes_downloaded", str), g(i2, j));
        bundle.putLong(hd3.L0("total_bytes_to_download", str), j);
        bundle.putStringArrayList("pack_names", new ArrayList<>(Arrays.asList(str)));
        bundle.putLong("bytes_downloaded", g(i2, j));
        bundle.putLong("total_bytes_to_download", j);
        this.f.post(new kt4(this, new Intent("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE").putExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE", bundle)));
    }

    @Override // defpackage.vu4
    public final void j() {
        g.b(4, "keepAlive", new Object[0]);
    }
}
