package defpackage;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.TreeMap;

/* renamed from: ds3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final /* synthetic */ class ds3 implements as3 {

    /* renamed from: a  reason: collision with root package name */
    public final zr3 f884a;
    public final String b;

    public ds3(zr3 zr3, String str) {
        this.f884a = zr3;
        this.b = str;
    }

    @Override // defpackage.as3
    public final Object zza() {
        String str;
        zr3 zr3 = this.f884a;
        String str2 = this.b;
        ContentResolver contentResolver = zr3.f4204a.getContentResolver();
        Uri uri = rr3.f3121a;
        synchronized (rr3.class) {
            if (rr3.f == null) {
                rr3.e.set(false);
                rr3.f = new HashMap<>();
                rr3.k = new Object();
                rr3.l = false;
                contentResolver.registerContentObserver(rr3.f3121a, true, new qr3());
            } else if (rr3.e.getAndSet(false)) {
                rr3.f.clear();
                rr3.g.clear();
                rr3.h.clear();
                rr3.i.clear();
                rr3.j.clear();
                rr3.k = new Object();
                rr3.l = false;
            }
            Object obj = rr3.k;
            str = null;
            if (rr3.f.containsKey(str2)) {
                String str3 = rr3.f.get(str2);
                if (str3 != null) {
                    str = str3;
                }
            } else {
                String[] strArr = rr3.m;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        Cursor query = contentResolver.query(rr3.f3121a, null, null, new String[]{str2}, null);
                        if (query != null) {
                            try {
                                if (!query.moveToFirst()) {
                                    rr3.a(obj, str2, null);
                                } else {
                                    String string = query.getString(1);
                                    if (string != null && string.equals(null)) {
                                        string = null;
                                    }
                                    rr3.a(obj, str2, string);
                                    if (string != null) {
                                        str = string;
                                    }
                                    query.close();
                                }
                            } finally {
                                query.close();
                            }
                        } else if (query != null) {
                            query.close();
                        }
                    } else if (!str2.startsWith(strArr[i])) {
                        i++;
                    } else if (!rr3.l || rr3.f.isEmpty()) {
                        String[] strArr2 = rr3.m;
                        HashMap<String, String> hashMap = rr3.f;
                        Cursor query2 = contentResolver.query(rr3.b, null, null, strArr2, null);
                        TreeMap treeMap = new TreeMap();
                        if (query2 != null) {
                            while (query2.moveToNext()) {
                                try {
                                    treeMap.put(query2.getString(0), query2.getString(1));
                                } finally {
                                    query2.close();
                                }
                            }
                        }
                        hashMap.putAll(treeMap);
                        rr3.l = true;
                        if (rr3.f.containsKey(str2)) {
                            String str4 = rr3.f.get(str2);
                            if (str4 != null) {
                                str = str4;
                            }
                        }
                    }
                }
            }
        }
        return str;
    }
}
