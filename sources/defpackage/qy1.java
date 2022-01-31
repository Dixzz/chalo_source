package defpackage;

import android.view.View;
import androidx.appcompat.widget.RtlSpacingHelper;
import com.google.android.flexbox.FlexItem;
import java.util.ArrayList;
import java.util.List;

/* renamed from: qy1  reason: default package */
/* compiled from: FlexLine */
public class qy1 {

    /* renamed from: a  reason: collision with root package name */
    public int f3006a = Integer.MAX_VALUE;
    public int b = Integer.MAX_VALUE;
    public int c = RtlSpacingHelper.UNDEFINED;
    public int d = RtlSpacingHelper.UNDEFINED;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public float j;
    public float k;
    public int l;
    public int m;
    public List<Integer> n = new ArrayList();
    public int o;
    public int p;

    public int a() {
        return this.h - this.i;
    }

    public void b(View view, int i2, int i3, int i4, int i5) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.f3006a = Math.min(this.f3006a, (view.getLeft() - flexItem.i0()) - i2);
        this.b = Math.min(this.b, (view.getTop() - flexItem.q0()) - i3);
        this.c = Math.max(this.c, flexItem.O0() + view.getRight() + i4);
        this.d = Math.max(this.d, flexItem.g0() + view.getBottom() + i5);
    }
}
