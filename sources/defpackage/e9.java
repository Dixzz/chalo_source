package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import defpackage.g9;
import java.util.ArrayList;
import java.util.List;

/* renamed from: e9  reason: default package */
/* compiled from: AccessibilityNodeInfoCompat */
public class e9 {
    public static int d;

    /* renamed from: a  reason: collision with root package name */
    public final AccessibilityNodeInfo f942a;
    public int b = -1;
    public int c = -1;

    /* renamed from: e9$a */
    /* compiled from: AccessibilityNodeInfoCompat */
    public static class a {
        public static final a e = new a(1, null);
        public static final a f = new a(2, null);
        public static final a g = new a(16, null);
        public static final a h = new a(4096, null);
        public static final a i = new a(RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST, null);
        public static final a j = new a(262144, null);
        public static final a k = new a(524288, null);
        public static final a l = new a(CommonUtils.BYTES_IN_A_MEGABYTE, null);
        public static final a m;
        public static final a n;

        /* renamed from: a  reason: collision with root package name */
        public final Object f943a;
        public final int b;
        public final Class<? extends g9.a> c;
        public final g9 d;

        static {
            new AccessibilityNodeInfo.AccessibilityAction(4, null);
            new AccessibilityNodeInfo.AccessibilityAction(8, null);
            new AccessibilityNodeInfo.AccessibilityAction(32, null);
            new AccessibilityNodeInfo.AccessibilityAction(64, null);
            new AccessibilityNodeInfo.AccessibilityAction(128, null);
            new AccessibilityNodeInfo.AccessibilityAction(256, null);
            new AccessibilityNodeInfo.AccessibilityAction(512, null);
            new AccessibilityNodeInfo.AccessibilityAction(1024, null);
            new AccessibilityNodeInfo.AccessibilityAction(2048, null);
            new AccessibilityNodeInfo.AccessibilityAction(16384, null);
            new AccessibilityNodeInfo.AccessibilityAction(32768, null);
            new AccessibilityNodeInfo.AccessibilityAction(65536, null);
            new AccessibilityNodeInfo.AccessibilityAction(131072, null);
            new AccessibilityNodeInfo.AccessibilityAction(2097152, null);
            int i2 = Build.VERSION.SDK_INT;
            if ((i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908342, null);
            }
            if ((i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908343, null);
            }
            m = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, null, null, null);
            if ((i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908345, null);
            }
            n = new a(i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, null, null, null);
            if ((i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908347, null);
            }
            if ((i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908358, null);
            }
            if ((i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908359, null);
            }
            if ((i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908360, null);
            }
            if ((i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908361, null);
            }
            if ((i2 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908348, null);
            }
            if ((i2 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908349, null);
            }
            if ((i2 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908354, null);
            }
            if ((i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908356, null);
            }
            if ((i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908357, null);
            }
            if ((i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908362, null);
            }
            if ((i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908372, null);
            }
        }

        public a(int i2, CharSequence charSequence) {
            this(null, i2, null, null, null);
        }

        public int a() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f943a).getId();
        }

        public CharSequence b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f943a).getLabel();
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f943a;
            if (obj2 == null) {
                if (aVar.f943a != null) {
                    return false;
                }
                return true;
            } else if (!obj2.equals(aVar.f943a)) {
                return false;
            } else {
                return true;
            }
        }

        public int hashCode() {
            Object obj = this.f943a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public a(Object obj, int i2, CharSequence charSequence, g9 g9Var, Class<? extends g9.a> cls) {
            this.b = i2;
            this.d = g9Var;
            if (obj == null) {
                this.f943a = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
            } else {
                this.f943a = obj;
            }
            this.c = cls;
        }
    }

    /* renamed from: e9$b */
    /* compiled from: AccessibilityNodeInfoCompat */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Object f944a;

        public b(Object obj) {
            this.f944a = obj;
        }

        public static b a(int i, int i2, boolean z, int i3) {
            return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
        }
    }

    /* renamed from: e9$c */
    /* compiled from: AccessibilityNodeInfoCompat */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final Object f945a;

        public c(Object obj) {
            this.f945a = obj;
        }

        public static c a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
        }
    }

    public e9(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f942a = accessibilityNodeInfo;
    }

    public static String c(int i) {
        if (i == 1) {
            return "ACTION_FOCUS";
        }
        if (i == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case 16908354:
                return "ACTION_MOVE_WINDOW";
            case 16908372:
                return "ACTION_IME_ENTER";
            default:
                switch (i) {
                    case 16908342:
                        return "ACTION_SHOW_ON_SCREEN";
                    case 16908343:
                        return "ACTION_SCROLL_TO_POSITION";
                    case 16908344:
                        return "ACTION_SCROLL_UP";
                    case 16908345:
                        return "ACTION_SCROLL_LEFT";
                    case 16908346:
                        return "ACTION_SCROLL_DOWN";
                    case 16908347:
                        return "ACTION_SCROLL_RIGHT";
                    case 16908348:
                        return "ACTION_CONTEXT_CLICK";
                    case 16908349:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i) {
                            case 16908356:
                                return "ACTION_SHOW_TOOLTIP";
                            case 16908357:
                                return "ACTION_HIDE_TOOLTIP";
                            case 16908358:
                                return "ACTION_PAGE_UP";
                            case 16908359:
                                return "ACTION_PAGE_DOWN";
                            case 16908360:
                                return "ACTION_PAGE_LEFT";
                            case 16908361:
                                return "ACTION_PAGE_RIGHT";
                            case 16908362:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                return "ACTION_UNKNOWN";
                        }
                }
        }
    }

    public static ClickableSpan[] f(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public void a(a aVar) {
        this.f942a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f943a);
    }

    public final List<Integer> b(String str) {
        ArrayList<Integer> integerArrayList = this.f942a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f942a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public int d() {
        return this.f942a.getActions();
    }

    public CharSequence e() {
        return this.f942a.getClassName();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof e9)) {
            return false;
        }
        e9 e9Var = (e9) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f942a;
        if (accessibilityNodeInfo == null) {
            if (e9Var.f942a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(e9Var.f942a)) {
            return false;
        }
        return this.c == e9Var.c && this.b == e9Var.b;
    }

    public CharSequence g() {
        return this.f942a.getContentDescription();
    }

    public Bundle h() {
        return this.f942a.getExtras();
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f942a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public CharSequence i() {
        if (!(!b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty())) {
            return this.f942a.getText();
        }
        List<Integer> b2 = b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> b3 = b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> b4 = b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> b5 = b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f942a.getText(), 0, this.f942a.getText().length()));
        for (int i = 0; i < b2.size(); i++) {
            spannableString.setSpan(new d9(b5.get(i).intValue(), this, h().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), b2.get(i).intValue(), b3.get(i).intValue(), b4.get(i).intValue());
        }
        return spannableString;
    }

    public boolean j() {
        return this.f942a.isEnabled();
    }

    public boolean k(a aVar) {
        return this.f942a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f943a);
    }

    public final void l(int i, boolean z) {
        Bundle h = h();
        if (h != null) {
            int i2 = h.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i);
            if (!z) {
                i = 0;
            }
            h.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }

    public void m(Object obj) {
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f942a;
        if (obj == null) {
            collectionInfo = null;
        } else {
            collectionInfo = (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f944a;
        }
        accessibilityNodeInfo.setCollectionInfo(collectionInfo);
    }

    public void n(Object obj) {
        this.f942a.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).f945a);
    }

    public void o(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f942a.setHintText(charSequence);
        } else {
            this.f942a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public void p(View view) {
        this.b = -1;
        this.f942a.setParent(view);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x014b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
        // Method dump skipped, instructions count: 402
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e9.toString():java.lang.String");
    }
}
