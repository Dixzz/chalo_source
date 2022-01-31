package defpackage;

import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* renamed from: jm  reason: default package */
/* compiled from: TableInfo */
public final class jm {

    /* renamed from: a  reason: collision with root package name */
    public final String f1953a;
    public final Map<String, a> b;
    public final Set<b> c;
    public final Set<d> d;

    /* renamed from: jm$a */
    /* compiled from: TableInfo */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f1954a;
        public final String b;
        public final int c;
        public final boolean d;
        public final int e;
        public final String f;
        public final int g;

        public a(String str, String str2, boolean z, int i, String str3, int i2) {
            this.f1954a = str;
            this.b = str2;
            this.d = z;
            this.e = i;
            int i3 = 5;
            if (str2 != null) {
                String upperCase = str2.toUpperCase(Locale.US);
                if (upperCase.contains("INT")) {
                    i3 = 3;
                } else if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                    i3 = 2;
                } else if (!upperCase.contains("BLOB")) {
                    i3 = (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
                }
            }
            this.c = i3;
            this.f = str3;
            this.g = i2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x0045  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0057 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean a(java.lang.String r6, java.lang.String r7) {
            /*
                r0 = 0
                if (r7 != 0) goto L_0x0004
                return r0
            L_0x0004:
                boolean r1 = r6.equals(r7)
                r2 = 1
                if (r1 == 0) goto L_0x000c
                return r2
            L_0x000c:
                int r1 = r6.length()
                if (r1 != 0) goto L_0x0013
                goto L_0x0042
            L_0x0013:
                r1 = 0
                r3 = 0
            L_0x0015:
                int r4 = r6.length()
                if (r1 >= r4) goto L_0x003e
                char r4 = r6.charAt(r1)
                r5 = 40
                if (r1 != 0) goto L_0x0026
                if (r4 == r5) goto L_0x0026
                goto L_0x0042
            L_0x0026:
                if (r4 != r5) goto L_0x002b
                int r3 = r3 + 1
                goto L_0x003b
            L_0x002b:
                r5 = 41
                if (r4 != r5) goto L_0x003b
                int r3 = r3 + -1
                if (r3 != 0) goto L_0x003b
                int r4 = r6.length()
                int r4 = r4 - r2
                if (r1 == r4) goto L_0x003b
                goto L_0x0042
            L_0x003b:
                int r1 = r1 + 1
                goto L_0x0015
            L_0x003e:
                if (r3 != 0) goto L_0x0042
                r1 = 1
                goto L_0x0043
            L_0x0042:
                r1 = 0
            L_0x0043:
                if (r1 == 0) goto L_0x0057
                int r0 = r6.length()
                int r0 = r0 - r2
                java.lang.String r6 = r6.substring(r2, r0)
                java.lang.String r6 = r6.trim()
                boolean r6 = r6.equals(r7)
                return r6
            L_0x0057:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.jm.a.a(java.lang.String, java.lang.String):boolean");
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.e != aVar.e || !this.f1954a.equals(aVar.f1954a) || this.d != aVar.d) {
                return false;
            }
            if (this.g == 1 && aVar.g == 2 && (str3 = this.f) != null && !a(str3, aVar.f)) {
                return false;
            }
            if (this.g == 2 && aVar.g == 1 && (str2 = aVar.f) != null && !a(str2, this.f)) {
                return false;
            }
            int i = this.g;
            if ((i == 0 || i != aVar.g || ((str = this.f) == null ? aVar.f == null : a(str, aVar.f))) && this.c == aVar.c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f1954a.hashCode() * 31) + this.c) * 31) + (this.d ? 1231 : 1237)) * 31) + this.e;
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("Column{name='");
            hj1.U0(i0, this.f1954a, '\'', ", type='");
            hj1.U0(i0, this.b, '\'', ", affinity='");
            i0.append(this.c);
            i0.append('\'');
            i0.append(", notNull=");
            i0.append(this.d);
            i0.append(", primaryKeyPosition=");
            i0.append(this.e);
            i0.append(", defaultValue='");
            i0.append(this.f);
            i0.append('\'');
            i0.append('}');
            return i0.toString();
        }
    }

    /* renamed from: jm$b */
    /* compiled from: TableInfo */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f1955a;
        public final String b;
        public final String c;
        public final List<String> d;
        public final List<String> e;

        public b(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.f1955a = str;
            this.b = str2;
            this.c = str3;
            this.d = Collections.unmodifiableList(list);
            this.e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f1955a.equals(bVar.f1955a) && this.b.equals(bVar.b) && this.c.equals(bVar.c) && this.d.equals(bVar.d)) {
                return this.e.equals(bVar.e);
            }
            return false;
        }

        public int hashCode() {
            int r0 = hj1.r0(this.c, hj1.r0(this.b, this.f1955a.hashCode() * 31, 31), 31);
            return this.e.hashCode() + ((this.d.hashCode() + r0) * 31);
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("ForeignKey{referenceTable='");
            hj1.U0(i0, this.f1955a, '\'', ", onDelete='");
            hj1.U0(i0, this.b, '\'', ", onUpdate='");
            hj1.U0(i0, this.c, '\'', ", columnNames=");
            i0.append(this.d);
            i0.append(", referenceColumnNames=");
            i0.append(this.e);
            i0.append('}');
            return i0.toString();
        }
    }

    /* renamed from: jm$c */
    /* compiled from: TableInfo */
    public static class c implements Comparable<c> {
        public final int f;
        public final int g;
        public final String h;
        public final String i;

        public c(int i2, int i3, String str, String str2) {
            this.f = i2;
            this.g = i3;
            this.h = str;
            this.i = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(c cVar) {
            c cVar2 = cVar;
            int i2 = this.f - cVar2.f;
            return i2 == 0 ? this.g - cVar2.g : i2;
        }
    }

    /* renamed from: jm$d */
    /* compiled from: TableInfo */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f1956a;
        public final boolean b;
        public final List<String> c;

        public d(String str, boolean z, List<String> list) {
            this.f1956a = str;
            this.b = z;
            this.c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (this.b != dVar.b || !this.c.equals(dVar.c)) {
                return false;
            }
            if (this.f1956a.startsWith("index_")) {
                return dVar.f1956a.startsWith("index_");
            }
            return this.f1956a.equals(dVar.f1956a);
        }

        public int hashCode() {
            int i;
            if (this.f1956a.startsWith("index_")) {
                i = -1184239155;
            } else {
                i = this.f1956a.hashCode();
            }
            return this.c.hashCode() + (((i * 31) + (this.b ? 1 : 0)) * 31);
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("Index{name='");
            hj1.U0(i0, this.f1956a, '\'', ", unique=");
            i0.append(this.b);
            i0.append(", columns=");
            i0.append(this.c);
            i0.append('}');
            return i0.toString();
        }
    }

    public jm(String str, Map<String, a> map, Set<b> set, Set<d> set2) {
        Set<d> set3;
        this.f1953a = str;
        this.b = Collections.unmodifiableMap(map);
        this.c = Collections.unmodifiableSet(set);
        if (set2 == null) {
            set3 = null;
        } else {
            set3 = Collections.unmodifiableSet(set2);
        }
        this.d = set3;
    }

    /* JADX INFO: finally extract failed */
    public static jm a(om omVar, String str) {
        List<c> list;
        int i;
        int i2;
        int i3;
        Cursor n0 = omVar.n0("PRAGMA table_info(`" + str + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (n0.getColumnCount() > 0) {
                int columnIndex = n0.getColumnIndex("name");
                int columnIndex2 = n0.getColumnIndex("type");
                int columnIndex3 = n0.getColumnIndex("notnull");
                int columnIndex4 = n0.getColumnIndex("pk");
                int columnIndex5 = n0.getColumnIndex("dflt_value");
                while (n0.moveToNext()) {
                    String string = n0.getString(columnIndex);
                    hashMap.put(string, new a(string, n0.getString(columnIndex2), n0.getInt(columnIndex3) != 0, n0.getInt(columnIndex4), n0.getString(columnIndex5), 2));
                }
            }
            n0.close();
            HashSet hashSet = new HashSet();
            Cursor n02 = omVar.n0("PRAGMA foreign_key_list(`" + str + "`)");
            try {
                int columnIndex6 = n02.getColumnIndex("id");
                int columnIndex7 = n02.getColumnIndex("seq");
                int columnIndex8 = n02.getColumnIndex("table");
                int columnIndex9 = n02.getColumnIndex("on_delete");
                int columnIndex10 = n02.getColumnIndex("on_update");
                List<c> b2 = b(n02);
                int count = n02.getCount();
                int i4 = 0;
                while (i4 < count) {
                    n02.moveToPosition(i4);
                    if (n02.getInt(columnIndex7) != 0) {
                        i3 = columnIndex6;
                        i2 = columnIndex7;
                        list = b2;
                        i = count;
                    } else {
                        int i5 = n02.getInt(columnIndex6);
                        i3 = columnIndex6;
                        ArrayList arrayList = new ArrayList();
                        i2 = columnIndex7;
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it = ((ArrayList) b2).iterator();
                        while (it.hasNext()) {
                            c cVar = (c) it.next();
                            if (cVar.f == i5) {
                                arrayList.add(cVar.h);
                                arrayList2.add(cVar.i);
                            }
                            count = count;
                            b2 = b2;
                        }
                        list = b2;
                        i = count;
                        hashSet.add(new b(n02.getString(columnIndex8), n02.getString(columnIndex9), n02.getString(columnIndex10), arrayList, arrayList2));
                    }
                    i4++;
                    columnIndex6 = i3;
                    columnIndex7 = i2;
                    count = i;
                    b2 = list;
                }
                n02.close();
                Cursor n03 = omVar.n0("PRAGMA index_list(`" + str + "`)");
                try {
                    int columnIndex11 = n03.getColumnIndex("name");
                    int columnIndex12 = n03.getColumnIndex(FirebaseAnalytics.Param.ORIGIN);
                    int columnIndex13 = n03.getColumnIndex("unique");
                    HashSet hashSet2 = null;
                    if (columnIndex11 != -1 && columnIndex12 != -1) {
                        if (columnIndex13 != -1) {
                            HashSet hashSet3 = new HashSet();
                            while (n03.moveToNext()) {
                                if ("c".equals(n03.getString(columnIndex12))) {
                                    d c2 = c(omVar, n03.getString(columnIndex11), n03.getInt(columnIndex13) == 1);
                                    if (c2 != null) {
                                        hashSet3.add(c2);
                                    }
                                }
                            }
                            n03.close();
                            hashSet2 = hashSet3;
                            return new jm(str, hashMap, hashSet, hashSet2);
                        }
                    }
                    return new jm(str, hashMap, hashSet, hashSet2);
                } finally {
                    n03.close();
                }
            } catch (Throwable th) {
                n02.close();
                throw th;
            }
        } catch (Throwable th2) {
            n0.close();
            throw th2;
        }
    }

    public static List<c> b(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex(Constants.MessagePayloadKeys.FROM);
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < count; i++) {
            cursor.moveToPosition(i);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static d c(om omVar, String str, boolean z) {
        Cursor n0 = omVar.n0("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = n0.getColumnIndex("seqno");
            int columnIndex2 = n0.getColumnIndex("cid");
            int columnIndex3 = n0.getColumnIndex("name");
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    TreeMap treeMap = new TreeMap();
                    while (n0.moveToNext()) {
                        if (n0.getInt(columnIndex2) >= 0) {
                            int i = n0.getInt(columnIndex);
                            treeMap.put(Integer.valueOf(i), n0.getString(columnIndex3));
                        }
                    }
                    ArrayList arrayList = new ArrayList(treeMap.size());
                    arrayList.addAll(treeMap.values());
                    d dVar = new d(str, z, arrayList);
                    n0.close();
                    return dVar;
                }
            }
            return null;
        } finally {
            n0.close();
        }
    }

    public boolean equals(Object obj) {
        Set<d> set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jm)) {
            return false;
        }
        jm jmVar = (jm) obj;
        String str = this.f1953a;
        if (str == null ? jmVar.f1953a != null : !str.equals(jmVar.f1953a)) {
            return false;
        }
        Map<String, a> map = this.b;
        if (map == null ? jmVar.b != null : !map.equals(jmVar.b)) {
            return false;
        }
        Set<b> set2 = this.c;
        if (set2 == null ? jmVar.c != null : !set2.equals(jmVar.c)) {
            return false;
        }
        Set<d> set3 = this.d;
        if (set3 == null || (set = jmVar.d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        String str = this.f1953a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, a> map = this.b;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set<b> set = this.c;
        if (set != null) {
            i = set.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("TableInfo{name='");
        hj1.U0(i0, this.f1953a, '\'', ", columns=");
        i0.append(this.b);
        i0.append(", foreignKeys=");
        i0.append(this.c);
        i0.append(", indices=");
        i0.append(this.d);
        i0.append('}');
        return i0.toString();
    }
}
