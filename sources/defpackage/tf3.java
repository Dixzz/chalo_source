package defpackage;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.TreeMap;

/* renamed from: tf3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final /* synthetic */ class tf3 implements rf3 {

    /* renamed from: a  reason: collision with root package name */
    public final qf3 f3346a;
    public final String b;

    public tf3(qf3 qf3, String str) {
        this.f3346a = qf3;
        this.b = str;
    }

    @Override // defpackage.rf3
    public final Object e() {
        String str;
        qf3 qf3 = this.f3346a;
        String str2 = this.b;
        ContentResolver contentResolver = qf3.f2939a.getContentResolver();
        Uri uri = hf3.f1365a;
        synchronized (hf3.class) {
            if (hf3.f == null) {
                hf3.e.set(false);
                hf3.f = new HashMap<>();
                hf3.k = new Object();
                hf3.l = false;
                contentResolver.registerContentObserver(hf3.f1365a, true, new kf3());
            } else if (hf3.e.getAndSet(false)) {
                hf3.f.clear();
                hf3.g.clear();
                hf3.h.clear();
                hf3.i.clear();
                hf3.j.clear();
                hf3.k = new Object();
                hf3.l = false;
            }
            Object obj = hf3.k;
            str = null;
            if (hf3.f.containsKey(str2)) {
                String str3 = hf3.f.get(str2);
                if (str3 != null) {
                    str = str3;
                }
            } else {
                String[] strArr = hf3.m;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        Cursor query = contentResolver.query(hf3.f1365a, null, null, new String[]{str2}, null);
                        if (query != null) {
                            try {
                                if (!query.moveToFirst()) {
                                    hf3.a(obj, str2, null);
                                } else {
                                    String string = query.getString(1);
                                    if (string != null && string.equals(null)) {
                                        string = null;
                                    }
                                    hf3.a(obj, str2, string);
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
                    } else if (!hf3.l || hf3.f.isEmpty()) {
                        String[] strArr2 = hf3.m;
                        HashMap<String, String> hashMap = hf3.f;
                        Cursor query2 = contentResolver.query(hf3.b, null, null, strArr2, null);
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
                        hf3.l = true;
                        if (hf3.f.containsKey(str2)) {
                            String str4 = hf3.f.get(str2);
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
