package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;
import java.util.Objects;

/* renamed from: f9  reason: default package */
/* compiled from: AccessibilityNodeProviderCompat */
public class f9 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1103a;

    /* renamed from: f9$a */
    /* compiled from: AccessibilityNodeProviderCompat */
    public static class a extends AccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        public final f9 f1104a;

        public a(f9 f9Var) {
            this.f1104a = f9Var;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            e9 a2 = this.f1104a.a(i);
            if (a2 == null) {
                return null;
            }
            return a2.f942a;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            Objects.requireNonNull(this.f1104a);
            return null;
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f1104a.c(i, i2, bundle);
        }
    }

    /* renamed from: f9$b */
    /* compiled from: AccessibilityNodeProviderCompat */
    public static class b extends a {
        public b(f9 f9Var) {
            super(f9Var);
        }

        public AccessibilityNodeInfo findFocus(int i) {
            e9 b = this.f1104a.b(i);
            if (b == null) {
                return null;
            }
            return b.f942a;
        }
    }

    /* renamed from: f9$c */
    /* compiled from: AccessibilityNodeProviderCompat */
    public static class c extends b {
        public c(f9 f9Var) {
            super(f9Var);
        }

        public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            Objects.requireNonNull(this.f1104a);
        }
    }

    public f9() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1103a = new c(this);
        } else {
            this.f1103a = new b(this);
        }
    }

    public e9 a(int i) {
        return null;
    }

    public e9 b(int i) {
        return null;
    }

    public boolean c(int i, int i2, Bundle bundle) {
        return false;
    }

    public f9(Object obj) {
        this.f1103a = obj;
    }
}
