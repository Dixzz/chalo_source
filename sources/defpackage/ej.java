package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.navigation.common.R;
import defpackage.cj;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: ej  reason: default package */
/* compiled from: NavDestination */
public class ej {
    public final String f;
    public gj g;
    public int h;
    public String i;
    public CharSequence j;
    public ArrayList<cj> k;
    public v2<vi> l;
    public HashMap<String, zi> m;

    /* renamed from: ej$a */
    /* compiled from: NavDestination */
    public static class a implements Comparable<a> {
        public final ej f;
        public final Bundle g;
        public final boolean h;
        public final boolean i;
        public final int j;

        public a(ej ejVar, Bundle bundle, boolean z, boolean z2, int i2) {
            this.f = ejVar;
            this.g = bundle;
            this.h = z;
            this.i = z2;
            this.j = i2;
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            boolean z = this.h;
            if (z && !aVar.h) {
                return 1;
            }
            if (!z && aVar.h) {
                return -1;
            }
            Bundle bundle = this.g;
            if (bundle != null && aVar.g == null) {
                return 1;
            }
            if (bundle == null && aVar.g != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size() - aVar.g.size();
                if (size > 0) {
                    return 1;
                }
                if (size < 0) {
                    return -1;
                }
            }
            boolean z2 = this.i;
            if (z2 && !aVar.i) {
                return 1;
            }
            if (z2 || !aVar.i) {
                return this.j - aVar.j;
            }
            return -1;
        }
    }

    static {
        new HashMap();
    }

    public ej(mj<? extends ej> mjVar) {
        this.f = nj.b(mjVar.getClass());
    }

    public static String k(Context context, int i2) {
        if (i2 <= 16777215) {
            return Integer.toString(i2);
        }
        try {
            return context.getResources().getResourceName(i2);
        } catch (Resources.NotFoundException unused) {
            return Integer.toString(i2);
        }
    }

    public Bundle b(Bundle bundle) {
        HashMap<String, zi> hashMap;
        if (bundle == null && ((hashMap = this.m) == null || hashMap.isEmpty())) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        HashMap<String, zi> hashMap2 = this.m;
        if (hashMap2 != null) {
            for (Map.Entry<String, zi> entry : hashMap2.entrySet()) {
                zi value = entry.getValue();
                String key = entry.getKey();
                if (value.c) {
                    value.f4177a.d(bundle2, key, value.d);
                }
            }
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            HashMap<String, zi> hashMap3 = this.m;
            if (hashMap3 != null) {
                for (Map.Entry<String, zi> entry2 : hashMap3.entrySet()) {
                    zi value2 = entry2.getValue();
                    String key2 = entry2.getKey();
                    boolean z = false;
                    if (value2.b || !bundle2.containsKey(key2) || bundle2.get(key2) != null) {
                        try {
                            value2.f4177a.a(bundle2, key2);
                            z = true;
                            continue;
                        } catch (ClassCastException unused) {
                            continue;
                        }
                    }
                    if (!z) {
                        StringBuilder i0 = hj1.i0("Wrong argument type for '");
                        i0.append(entry2.getKey());
                        i0.append("' in argument bundle. ");
                        i0.append(entry2.getValue().f4177a.b());
                        i0.append(" expected.");
                        throw new IllegalArgumentException(i0.toString());
                    }
                }
            }
        }
        return bundle2;
    }

    public int[] d() {
        ArrayDeque arrayDeque = new ArrayDeque();
        gj gjVar = this;
        while (true) {
            gj gjVar2 = gjVar.g;
            if (gjVar2 == null || gjVar2.o != gjVar.h) {
                arrayDeque.addFirst(gjVar);
            }
            if (gjVar2 == null) {
                break;
            }
            gjVar = gjVar2;
        }
        int[] iArr = new int[arrayDeque.size()];
        int i2 = 0;
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            iArr[i2] = ((ej) it.next()).h;
            i2++;
        }
        return iArr;
    }

    public final vi e(int i2) {
        vi viVar;
        v2<vi> v2Var = this.l;
        if (v2Var == null) {
            viVar = null;
        } else {
            viVar = v2Var.e(i2, null);
        }
        if (viVar != null) {
            return viVar;
        }
        gj gjVar = this.g;
        if (gjVar != null) {
            return gjVar.e(i2);
        }
        return null;
    }

    public a n(dj djVar) {
        Bundle bundle;
        int i2;
        Map map;
        Bundle bundle2;
        Matcher matcher;
        Uri uri;
        ArrayList<cj> arrayList = this.k;
        Matcher matcher2 = null;
        if (arrayList == null) {
            return null;
        }
        Iterator<cj> it = arrayList.iterator();
        a aVar = null;
        while (it.hasNext()) {
            cj next = it.next();
            Uri uri2 = djVar.f844a;
            if (uri2 != null) {
                HashMap<String, zi> hashMap = this.m;
                if (hashMap == null) {
                    map = Collections.emptyMap();
                } else {
                    map = Collections.unmodifiableMap(hashMap);
                }
                Matcher matcher3 = next.c.matcher(uri2.toString());
                if (matcher3.matches()) {
                    bundle2 = new Bundle();
                    int size = next.f570a.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 < size) {
                            String str = next.f570a.get(i3);
                            i3++;
                            if (next.b(bundle2, str, Uri.decode(matcher3.group(i3)), (zi) map.get(str))) {
                                break;
                            }
                        } else if (next.e) {
                            Iterator<String> it2 = next.b.keySet().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                String next2 = it2.next();
                                cj.b bVar = next.b.get(next2);
                                String queryParameter = uri2.getQueryParameter(next2);
                                if (queryParameter != null) {
                                    matcher = Pattern.compile(bVar.f571a).matcher(queryParameter);
                                    if (!matcher.matches()) {
                                        break;
                                    }
                                } else {
                                    matcher = matcher2;
                                }
                                int i4 = 0;
                                while (true) {
                                    if (i4 < bVar.b.size()) {
                                        String decode = matcher != null ? Uri.decode(matcher.group(i4 + 1)) : matcher2;
                                        String str2 = bVar.b.get(i4);
                                        zi ziVar = (zi) map.get(str2);
                                        if (decode != null) {
                                            uri = uri2;
                                            if (!decode.replaceAll("[{}]", "").equals(str2) && next.b(bundle2, str2, decode, ziVar)) {
                                                bundle2 = null;
                                                break;
                                            }
                                        } else {
                                            uri = uri2;
                                        }
                                        i4++;
                                        uri2 = uri;
                                        matcher2 = null;
                                    }
                                }
                            }
                        }
                    }
                    bundle = bundle2;
                }
                bundle2 = matcher2;
                bundle = bundle2;
            } else {
                bundle = null;
            }
            String str3 = djVar.b;
            boolean z = str3 != null && str3.equals(next.f);
            String str4 = djVar.c;
            if (str4 != null) {
                i2 = (next.h == null || !next.g.matcher(str4).matches()) ? -1 : new cj.a(next.h).compareTo(new cj.a(str4));
            } else {
                i2 = -1;
            }
            if (bundle != null || z || i2 > -1) {
                a aVar2 = new a(this, bundle, next.d, z, i2);
                if (aVar == null || aVar2.compareTo(aVar) > 0) {
                    aVar = aVar2;
                }
            }
            matcher2 = null;
        }
        return aVar;
    }

    public void s(Context context, AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.Navigator);
        int resourceId = obtainAttributes.getResourceId(R.styleable.Navigator_android_id, 0);
        this.h = resourceId;
        this.i = null;
        this.i = k(context, resourceId);
        this.j = obtainAttributes.getText(R.styleable.Navigator_android_label);
        obtainAttributes.recycle();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        String str = this.i;
        if (str == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(this.h));
        } else {
            sb.append(str);
        }
        sb.append(")");
        if (this.j != null) {
            sb.append(" label=");
            sb.append(this.j);
        }
        return sb.toString();
    }

    public boolean u() {
        return true;
    }
}
