package defpackage;

import android.annotation.TargetApi;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import defpackage.be5;
import defpackage.wd5;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(16)
/* renamed from: je5  reason: default package */
/* compiled from: ViewVisitor */
public abstract class je5 implements be5.a {

    /* renamed from: a  reason: collision with root package name */
    public final List<be5.c> f1912a;
    public final be5 b = new be5();

    /* renamed from: je5$b */
    /* compiled from: ViewVisitor */
    public static class b extends e {
        public final int f;
        public final WeakHashMap<View, a> g = new WeakHashMap<>();

        /* renamed from: je5$b$a */
        /* compiled from: ViewVisitor */
        public class a extends View.AccessibilityDelegate {

            /* renamed from: a  reason: collision with root package name */
            public View.AccessibilityDelegate f1913a;

            public a(View.AccessibilityDelegate accessibilityDelegate) {
                this.f1913a = accessibilityDelegate;
            }

            public void a(a aVar) {
                View.AccessibilityDelegate accessibilityDelegate = this.f1913a;
                if (accessibilityDelegate == aVar) {
                    this.f1913a = aVar.f1913a;
                } else if (accessibilityDelegate instanceof a) {
                    ((a) accessibilityDelegate).a(aVar);
                }
            }

            public boolean b(String str) {
                if (b.this.d.equals(str)) {
                    return true;
                }
                View.AccessibilityDelegate accessibilityDelegate = this.f1913a;
                if (accessibilityDelegate instanceof a) {
                    return ((a) accessibilityDelegate).b(str);
                }
                return false;
            }

            public void sendAccessibilityEvent(View view, int i) {
                b bVar = b.this;
                if (i == bVar.f) {
                    bVar.d(view);
                }
                View.AccessibilityDelegate accessibilityDelegate = this.f1913a;
                if (accessibilityDelegate != null) {
                    accessibilityDelegate.sendAccessibilityEvent(view, i);
                }
            }
        }

        public b(List<be5.c> list, int i, String str, i iVar) {
            super(list, str, iVar, false);
            this.f = i;
        }

        @Override // defpackage.be5.a
        public void a(View view) {
            View.AccessibilityDelegate e = e(view);
            if (!(e instanceof a) || !((a) e).b(this.d)) {
                a aVar = new a(e);
                view.setAccessibilityDelegate(aVar);
                this.g.put(view, aVar);
            }
        }

        @Override // defpackage.je5
        public void b() {
            for (Map.Entry<View, a> entry : this.g.entrySet()) {
                View key = entry.getKey();
                a value = entry.getValue();
                View.AccessibilityDelegate e = e(key);
                if (e == value) {
                    key.setAccessibilityDelegate(value.f1913a);
                } else if (e instanceof a) {
                    a aVar = (a) e;
                    View.AccessibilityDelegate accessibilityDelegate = aVar.f1913a;
                    if (accessibilityDelegate == value) {
                        aVar.f1913a = value.f1913a;
                    } else if (accessibilityDelegate instanceof a) {
                        ((a) accessibilityDelegate).a(value);
                    }
                }
            }
            this.g.clear();
        }

        public final View.AccessibilityDelegate e(View view) {
            try {
                return (View.AccessibilityDelegate) view.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(view, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }
    }

    /* renamed from: je5$c */
    /* compiled from: ViewVisitor */
    public static class c extends e {
        public final Map<TextView, TextWatcher> f = new HashMap();

        /* renamed from: je5$c$a */
        /* compiled from: ViewVisitor */
        public class a implements TextWatcher {
            public final View f;

            public a(View view) {
                this.f = view;
            }

            public void afterTextChanged(Editable editable) {
                c.this.d(this.f);
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        }

        public c(List<be5.c> list, String str, i iVar) {
            super(list, str, iVar, true);
        }

        @Override // defpackage.be5.a
        public void a(View view) {
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                a aVar = new a(textView);
                TextWatcher textWatcher = this.f.get(textView);
                if (textWatcher != null) {
                    textView.removeTextChangedListener(textWatcher);
                }
                textView.addTextChangedListener(aVar);
                this.f.put(textView, aVar);
            }
        }

        @Override // defpackage.je5
        public void b() {
            for (Map.Entry<TextView, TextWatcher> entry : this.f.entrySet()) {
                entry.getKey().removeTextChangedListener(entry.getValue());
            }
            this.f.clear();
        }
    }

    /* renamed from: je5$d */
    /* compiled from: ViewVisitor */
    public static class d {
        public d(a aVar) {
        }

        public final boolean a(TreeMap<View, List<View>> treeMap, View view, List<View> list) {
            if (list.contains(view)) {
                return false;
            }
            if (!treeMap.containsKey(view)) {
                return true;
            }
            List<View> remove = treeMap.remove(view);
            list.add(view);
            int size = remove.size();
            for (int i = 0; i < size; i++) {
                if (!a(treeMap, remove.get(i), list)) {
                    return false;
                }
            }
            list.remove(view);
            return true;
        }
    }

    /* renamed from: je5$e */
    /* compiled from: ViewVisitor */
    public static abstract class e extends je5 {
        public final i c;
        public final String d;
        public final boolean e;

        public e(List<be5.c> list, String str, i iVar, boolean z) {
            super(list);
            this.c = iVar;
            this.d = str;
            this.e = z;
        }

        public void d(View view) {
            i iVar = this.c;
            String str = this.d;
            boolean z = this.e;
            wd5 wd5 = (wd5) iVar;
            Objects.requireNonNull(wd5);
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("$text", wd5.a(view));
                jSONObject.put("$from_binding", true);
                jSONObject.put("time", currentTimeMillis / 1000);
            } catch (JSONException unused) {
            }
            if (z) {
                wd5.c cVar = new wd5.c(view, str);
                wd5.d dVar = new wd5.d(str, jSONObject, currentTimeMillis);
                synchronized (wd5.d) {
                    boolean isEmpty = wd5.d.isEmpty();
                    wd5.d.put(cVar, dVar);
                    if (isEmpty) {
                        wd5.b.postDelayed(wd5.c, 1000);
                    }
                }
                return;
            }
            nc5 nc5 = wd5.f3762a;
            if (!nc5.m()) {
                nc5.s(str, jSONObject, false);
            }
        }
    }

    /* renamed from: je5$f */
    /* compiled from: ViewVisitor */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public final String f1914a;
        public final String b;

        public f(String str, String str2) {
            this.f1914a = str;
            this.b = str2;
        }
    }

    /* renamed from: je5$g */
    /* compiled from: ViewVisitor */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public final int f1915a;
        public final int b;
        public final int c;

        public g(int i, int i2, int i3) {
            this.f1915a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    /* renamed from: je5$h */
    /* compiled from: ViewVisitor */
    public static class h extends je5 {
        public static final Set<Integer> i = new HashSet(Arrays.asList(0, 1, 5, 7));
        public static final Set<Integer> j = new HashSet(Arrays.asList(2, 3, 4, 6, 8));
        public final WeakHashMap<View, int[]> c = new WeakHashMap<>();
        public final List<g> d;
        public final String e;
        public boolean f;
        public final j g;
        public final d h;

        public h(List<be5.c> list, List<g> list2, String str, j jVar) {
            super(list);
            this.d = list2;
            this.e = str;
            this.f = true;
            this.g = jVar;
            this.h = new d(null);
        }

        @Override // defpackage.be5.a
        public void a(View view) {
            boolean z;
            ViewGroup viewGroup = (ViewGroup) view;
            SparseArray sparseArray = new SparseArray();
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                int id = childAt.getId();
                if (id > 0) {
                    sparseArray.put(id, childAt);
                }
            }
            int size = this.d.size();
            for (int i3 = 0; i3 < size; i3++) {
                g gVar = this.d.get(i3);
                View view2 = (View) sparseArray.get(gVar.f1915a);
                if (view2 != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
                    int[] iArr = (int[]) layoutParams.getRules().clone();
                    if (iArr[gVar.b] != gVar.c) {
                        if (!this.c.containsKey(view2)) {
                            this.c.put(view2, iArr);
                        }
                        layoutParams.addRule(gVar.b, gVar.c);
                        Set<Integer> set = i;
                        if (!set.contains(Integer.valueOf(gVar.b))) {
                            set = j;
                            if (!set.contains(Integer.valueOf(gVar.b))) {
                                set = null;
                            }
                        }
                        if (set != null) {
                            TreeMap<View, List<View>> treeMap = new TreeMap<>(new ke5(this));
                            int size2 = sparseArray.size();
                            for (int i4 = 0; i4 < size2; i4++) {
                                View view3 = (View) sparseArray.valueAt(i4);
                                int[] rules = ((RelativeLayout.LayoutParams) view3.getLayoutParams()).getRules();
                                ArrayList arrayList = new ArrayList();
                                for (Integer num : set) {
                                    int i5 = rules[num.intValue()];
                                    if (i5 > 0 && i5 != view3.getId()) {
                                        arrayList.add(sparseArray.get(i5));
                                    }
                                }
                                treeMap.put(view3, arrayList);
                            }
                            d dVar = this.h;
                            Objects.requireNonNull(dVar);
                            ArrayList arrayList2 = new ArrayList();
                            while (true) {
                                if (!treeMap.isEmpty()) {
                                    if (!dVar.a(treeMap, treeMap.firstKey(), arrayList2)) {
                                        z = false;
                                        break;
                                    }
                                } else {
                                    z = true;
                                    break;
                                }
                            }
                            if (!z) {
                                b();
                                j jVar = this.g;
                                f fVar = new f("circular_dependency", this.e);
                                ge5 ge5 = (ge5) jVar;
                                Message obtainMessage = ge5.h.obtainMessage();
                                obtainMessage.what = 12;
                                obtainMessage.obj = fVar;
                                ge5.h.sendMessage(obtainMessage);
                                return;
                            }
                        }
                        view2.setLayoutParams(layoutParams);
                    } else {
                        continue;
                    }
                }
            }
        }

        @Override // defpackage.je5
        public void b() {
            Iterator<Map.Entry<View, int[]>> it = this.c.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<View, int[]> next = it.next();
                    View key = next.getKey();
                    int[] value = next.getValue();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) key.getLayoutParams();
                    for (int i2 = 0; i2 < value.length; i2++) {
                        layoutParams.addRule(i2, value[i2]);
                    }
                    key.setLayoutParams(layoutParams);
                } else {
                    this.f = false;
                    return;
                }
            }
        }

        @Override // defpackage.je5
        public void c(View view) {
            if (this.f) {
                this.b.c(view, this.f1912a, this);
            }
        }
    }

    /* renamed from: je5$i */
    /* compiled from: ViewVisitor */
    public interface i {
    }

    /* renamed from: je5$j */
    /* compiled from: ViewVisitor */
    public interface j {
    }

    /* renamed from: je5$k */
    /* compiled from: ViewVisitor */
    public static class k extends je5 {
        public final vd5 c;
        public final vd5 d;
        public final WeakHashMap<View, Object> e = new WeakHashMap<>();
        public final Object[] f = new Object[1];

        public k(List<be5.c> list, vd5 vd5, vd5 vd52) {
            super(list);
            this.c = vd5;
            this.d = vd52;
        }

        /* JADX WARNING: Removed duplicated region for block: B:61:0x00bb  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x00c1  */
        @Override // defpackage.be5.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(android.view.View r9) {
            /*
            // Method dump skipped, instructions count: 207
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.je5.k.a(android.view.View):void");
        }

        @Override // defpackage.je5
        public void b() {
            for (Map.Entry<View, Object> entry : this.e.entrySet()) {
                View key = entry.getKey();
                Object value = entry.getValue();
                if (value != null) {
                    Object[] objArr = this.f;
                    objArr[0] = value;
                    this.c.a(key, objArr);
                }
            }
        }
    }

    /* renamed from: je5$l */
    /* compiled from: ViewVisitor */
    public static class l extends e {
        public boolean f = false;

        public l(List<be5.c> list, String str, i iVar) {
            super(list, str, iVar, false);
        }

        @Override // defpackage.be5.a
        public void a(View view) {
            if (view != null && !this.f) {
                d(view);
            }
            this.f = view != null;
        }

        @Override // defpackage.je5
        public void b() {
        }
    }

    public je5(List<be5.c> list) {
        this.f1912a = list;
    }

    public abstract void b();

    public void c(View view) {
        this.b.c(view, this.f1912a, this);
    }
}
