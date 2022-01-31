package defpackage;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;

/* renamed from: ck4  reason: default package */
/* compiled from: DrawableAlphaProperty */
public class ck4 extends Property<Drawable, Integer> {
    public static final Property<Drawable, Integer> b = new ck4();

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap<Drawable, Integer> f574a = new WeakHashMap<>();

    public ck4() {
        super(Integer.class, "drawableAlphaCompat");
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.util.Property
    public Integer get(Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // android.util.Property
    public void set(Drawable drawable, Integer num) {
        drawable.setAlpha(num.intValue());
    }
}
