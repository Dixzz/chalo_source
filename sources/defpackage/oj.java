package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.R;
import com.razorpay.AnalyticsConstants;
import defpackage.mj;
import java.util.ArrayDeque;
import java.util.Iterator;

@mj.b("fragment")
/* renamed from: oj  reason: default package */
/* compiled from: FragmentNavigator */
public class oj extends mj<a> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2696a;
    public final FragmentManager b;
    public final int c;
    public ArrayDeque<Integer> d = new ArrayDeque<>();

    /* renamed from: oj$a */
    /* compiled from: FragmentNavigator */
    public static class a extends ej {
        public String n;

        public a(mj<? extends a> mjVar) {
            super(mjVar);
        }

        @Override // defpackage.ej
        public void s(Context context, AttributeSet attributeSet) {
            super.s(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.FragmentNavigator);
            String string = obtainAttributes.getString(R.styleable.FragmentNavigator_android_name);
            if (string != null) {
                this.n = string;
            }
            obtainAttributes.recycle();
        }

        @Override // defpackage.ej
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" class=");
            String str = this.n;
            if (str == null) {
                sb.append(AnalyticsConstants.NULL);
            } else {
                sb.append(str);
            }
            return sb.toString();
        }
    }

    /* renamed from: oj$b */
    /* compiled from: FragmentNavigator */
    public static final class b implements mj.a {
    }

    public oj(Context context, FragmentManager fragmentManager, int i) {
        this.f2696a = context;
        this.b = fragmentManager;
        this.c = i;
    }

    /* Return type fixed from 'ej' to match base method */
    @Override // defpackage.mj
    public a a() {
        return new a(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [ej, android.os.Bundle, kj, mj$a] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0184  */
    @Override // defpackage.mj
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.ej b(defpackage.oj.a r9, android.os.Bundle r10, defpackage.kj r11, defpackage.mj.a r12) {
        /*
        // Method dump skipped, instructions count: 408
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oj.b(ej, android.os.Bundle, kj, mj$a):ej");
    }

    @Override // defpackage.mj
    public void c(Bundle bundle) {
        int[] intArray = bundle.getIntArray("androidx-nav-fragment:navigator:backStackIds");
        if (intArray != null) {
            this.d.clear();
            for (int i : intArray) {
                this.d.add(Integer.valueOf(i));
            }
        }
    }

    @Override // defpackage.mj
    public Bundle d() {
        Bundle bundle = new Bundle();
        int[] iArr = new int[this.d.size()];
        Iterator<Integer> it = this.d.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        bundle.putIntArray("androidx-nav-fragment:navigator:backStackIds", iArr);
        return bundle;
    }

    @Override // defpackage.mj
    public boolean e() {
        if (this.d.isEmpty() || this.b.S()) {
            return false;
        }
        FragmentManager fragmentManager = this.b;
        fragmentManager.A(new FragmentManager.m(f(this.d.size(), this.d.peekLast().intValue()), -1, 1), false);
        this.d.removeLast();
        return true;
    }

    public final String f(int i, int i2) {
        return i + "-" + i2;
    }
}
