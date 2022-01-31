package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

/* renamed from: gy5  reason: default package */
/* compiled from: AttributeSetConfigParser */
public class gy5 implements iy5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1317a;
    public final AttributeSet b;

    public gy5(Context context, AttributeSet attributeSet) {
        this.f1317a = context;
        this.b = attributeSet;
    }

    public boolean a(String str, boolean z) {
        int attributeResourceValue = this.b.getAttributeResourceValue(null, str, 0);
        if (attributeResourceValue != 0) {
            return this.f1317a.getResources().getBoolean(attributeResourceValue);
        }
        return this.b.getAttributeBooleanValue(null, str, z);
    }

    public int b(String str, int i) {
        int attributeResourceValue = this.b.getAttributeResourceValue(null, str, 0);
        if (attributeResourceValue != 0) {
            return q5.b(this.f1317a, attributeResourceValue);
        }
        String d = d(str);
        if (hd3.G1(d)) {
            return i;
        }
        return Color.parseColor(d);
    }

    public int c(String str, int i) {
        String d = d(str);
        if (hd3.G1(d)) {
            return i;
        }
        return Integer.parseInt(d);
    }

    public String d(String str) {
        int attributeResourceValue = this.b.getAttributeResourceValue(null, str, 0);
        if (attributeResourceValue != 0) {
            return this.f1317a.getString(attributeResourceValue);
        }
        return this.b.getAttributeValue(null, str);
    }
}
