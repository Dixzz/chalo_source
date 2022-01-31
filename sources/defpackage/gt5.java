package defpackage;

import android.content.Context;
import android.widget.ImageView;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/* renamed from: gt5  reason: default package */
/* compiled from: DefaultImageLoader */
public class gt5 implements it5 {

    /* renamed from: a  reason: collision with root package name */
    public final Map<ImageView, jt5> f1302a = new WeakHashMap();
    public final ht5 b;

    /* renamed from: gt5$a */
    /* compiled from: DefaultImageLoader */
    public class a extends jt5 {
        public final /* synthetic */ kt5 j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Context context, ht5 ht5, ImageView imageView, kt5 kt5, kt5 kt52) {
            super(context, ht5, imageView, kt5);
            this.j = kt52;
        }

        @Override // defpackage.jt5
        public void d(ImageView imageView) {
            if (imageView != null) {
                gt5.this.f1302a.remove(imageView);
                Objects.requireNonNull(this.j);
            }
        }
    }

    public gt5(Context context) {
        this.b = new ht5(context);
    }

    public void a(Context context, ImageView imageView, kt5 kt5) {
        jt5 remove;
        if (!(imageView == null || (remove = this.f1302a.remove(imageView)) == null)) {
            ImageView imageView2 = remove.d.get();
            if (!(imageView2 == null || remove.g == null)) {
                imageView2.getViewTreeObserver().removeOnPreDrawListener(remove.g);
                remove.d.clear();
            }
            remove.f.cancel();
        }
        a aVar = new a(context, this.b, imageView, kt5, kt5);
        this.f1302a.put(imageView, aVar);
        aVar.b();
    }
}
