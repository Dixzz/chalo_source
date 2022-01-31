package defpackage;

import java.util.List;

/* renamed from: x5  reason: default package */
/* compiled from: GradientColorInflaterCompat */
public final class x5 {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f3885a;
    public final float[] b;

    public x5(List<Integer> list, List<Float> list2) {
        int size = list.size();
        this.f3885a = new int[size];
        this.b = new float[size];
        for (int i = 0; i < size; i++) {
            this.f3885a[i] = list.get(i).intValue();
            this.b[i] = list2.get(i).floatValue();
        }
    }

    public x5(int i, int i2) {
        this.f3885a = new int[]{i, i2};
        this.b = new float[]{0.0f, 1.0f};
    }

    public x5(int i, int i2, int i3) {
        this.f3885a = new int[]{i, i2, i3};
        this.b = new float[]{0.0f, 0.5f, 1.0f};
    }
}
