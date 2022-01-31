package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R;
import defpackage.e9;
import defpackage.g9;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: z7  reason: default package */
/* compiled from: AccessibilityDelegateCompat */
public class z7 {
    public static final View.AccessibilityDelegate c = new View.AccessibilityDelegate();

    /* renamed from: a  reason: collision with root package name */
    public final View.AccessibilityDelegate f4141a;
    public final View.AccessibilityDelegate b;

    /* renamed from: z7$a */
    /* compiled from: AccessibilityDelegateCompat */
    public static final class a extends View.AccessibilityDelegate {

        /* renamed from: a  reason: collision with root package name */
        public final z7 f4142a;

        public a(z7 z7Var) {
            this.f4142a = z7Var;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f4142a.a(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            f9 b = this.f4142a.b(view);
            if (b != null) {
                return (AccessibilityNodeProvider) b.f1103a;
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f4142a.c(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            boolean z;
            boolean z2;
            int i;
            e9 e9Var = new e9(accessibilityNodeInfo);
            AtomicInteger atomicInteger = r8.f3055a;
            Boolean bool = (Boolean) new s8(R.id.tag_screen_reader_focusable, Boolean.class, 28).d(view);
            if (bool == null) {
                z = false;
            } else {
                z = bool.booleanValue();
            }
            int i2 = Build.VERSION.SDK_INT;
            boolean z3 = true;
            if (i2 >= 28) {
                e9Var.f942a.setScreenReaderFocusable(z);
            } else {
                e9Var.l(1, z);
            }
            Boolean bool2 = (Boolean) new v8(R.id.tag_accessibility_heading, Boolean.class, 28).d(view);
            if (bool2 == null) {
                z2 = false;
            } else {
                z2 = bool2.booleanValue();
            }
            if (i2 >= 28) {
                e9Var.f942a.setHeading(z2);
            } else {
                e9Var.l(2, z2);
            }
            CharSequence i3 = r8.i(view);
            if (i2 >= 28) {
                e9Var.f942a.setPaneTitle(i3);
            } else {
                e9Var.f942a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", i3);
            }
            CharSequence charSequence = (CharSequence) new u8(R.id.tag_state_description, CharSequence.class, 64, 30).d(view);
            if (i2 < 30) {
                z3 = false;
            }
            if (z3) {
                e9Var.f942a.setStateDescription(charSequence);
            } else {
                e9Var.f942a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
            }
            this.f4142a.d(view, e9Var);
            CharSequence text = accessibilityNodeInfo.getText();
            if (i2 < 26) {
                e9Var.f942a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
                e9Var.f942a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
                e9Var.f942a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
                e9Var.f942a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
                SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
                if (sparseArray != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                        if (((WeakReference) sparseArray.valueAt(i4)).get() == null) {
                            arrayList.add(Integer.valueOf(i4));
                        }
                    }
                    for (int i5 = 0; i5 < arrayList.size(); i5++) {
                        sparseArray.remove(((Integer) arrayList.get(i5)).intValue());
                    }
                }
                ClickableSpan[] f = e9.f(text);
                if (f != null && f.length > 0) {
                    e9Var.h().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R.id.accessibility_action_clickable_span);
                    int i6 = R.id.tag_accessibility_clickable_spans;
                    SparseArray sparseArray2 = (SparseArray) view.getTag(i6);
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        view.setTag(i6, sparseArray2);
                    }
                    for (int i7 = 0; i7 < f.length; i7++) {
                        ClickableSpan clickableSpan = f[i7];
                        int i8 = 0;
                        while (true) {
                            if (i8 >= sparseArray2.size()) {
                                i = e9.d;
                                e9.d = i + 1;
                                break;
                            } else if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray2.valueAt(i8)).get())) {
                                i = sparseArray2.keyAt(i8);
                                break;
                            } else {
                                i8++;
                            }
                        }
                        sparseArray2.put(i, new WeakReference(f[i7]));
                        ClickableSpan clickableSpan2 = f[i7];
                        Spanned spanned = (Spanned) text;
                        e9Var.b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan2)));
                        e9Var.b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan2)));
                        e9Var.b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan2)));
                        e9Var.b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
                    }
                }
            }
            List list = (List) view.getTag(R.id.tag_accessibility_actions);
            if (list == null) {
                list = Collections.emptyList();
            }
            for (int i9 = 0; i9 < list.size(); i9++) {
                e9Var.a((e9.a) list.get(i9));
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f4142a.e(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f4142a.f(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f4142a.g(view, i, bundle);
        }

        public void sendAccessibilityEvent(View view, int i) {
            this.f4142a.h(view, i);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f4142a.i(view, accessibilityEvent);
        }
    }

    public z7() {
        this.f4141a = c;
        this.b = new a(this);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f4141a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public f9 b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.f4141a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new f9(accessibilityNodeProvider);
        }
        return null;
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f4141a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, e9 e9Var) {
        this.f4141a.onInitializeAccessibilityNodeInfo(view, e9Var.f942a);
    }

    public void e(View view, AccessibilityEvent accessibilityEvent) {
        this.f4141a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f4141a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean g(View view, int i, Bundle bundle) {
        boolean z;
        WeakReference weakReference;
        boolean z2;
        List list = (List) view.getTag(R.id.tag_accessibility_actions);
        if (list == null) {
            list = Collections.emptyList();
        }
        boolean z3 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= list.size()) {
                break;
            }
            e9.a aVar = (e9.a) list.get(i2);
            if (aVar.a() != i) {
                i2++;
            } else if (aVar.d != null) {
                g9.a aVar2 = null;
                Class<? extends g9.a> cls = aVar.c;
                if (cls != null) {
                    try {
                        g9.a aVar3 = (g9.a) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        try {
                            Objects.requireNonNull(aVar3);
                        } catch (Exception unused) {
                        }
                        aVar2 = aVar3;
                    } catch (Exception unused2) {
                    }
                }
                z = aVar.d.a(view, aVar2);
            }
        }
        z = false;
        if (!z) {
            z = this.f4141a.performAccessibilityAction(view, i, bundle);
        }
        if (z || i != R.id.accessibility_action_clickable_span) {
            return z;
        }
        int i3 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
        if (!(sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i3)) == null)) {
            ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
            if (clickableSpan != null) {
                ClickableSpan[] f = e9.f(view.createAccessibilityNodeInfo().getText());
                int i4 = 0;
                while (true) {
                    if (f == null || i4 >= f.length) {
                        break;
                    } else if (clickableSpan.equals(f[i4])) {
                        z2 = true;
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            z2 = false;
            if (z2) {
                clickableSpan.onClick(view);
                z3 = true;
            }
        }
        return z3;
    }

    public void h(View view, int i) {
        this.f4141a.sendAccessibilityEvent(view, i);
    }

    public void i(View view, AccessibilityEvent accessibilityEvent) {
        this.f4141a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public z7(View.AccessibilityDelegate accessibilityDelegate) {
        this.f4141a = accessibilityDelegate;
        this.b = new a(this);
    }
}
