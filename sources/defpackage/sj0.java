package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import defpackage.h30;
import java.util.Objects;

/* renamed from: sj0  reason: default package */
/* compiled from: LanguageSelectAdapter.kt */
public final class sj0 extends RecyclerView.e<a> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3220a;
    public String b;
    public int c;
    public final ci1<View> d;
    public final h30.a[] e = h30.a.values();

    /* renamed from: sj0$a */
    /* compiled from: LanguageSelectAdapter.kt */
    public final class a extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final zw f3221a;
        public final /* synthetic */ sj0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(sj0 sj0, zw zwVar) {
            super(zwVar.f4220a);
            n86.e(sj0, "this$0");
            n86.e(zwVar, "viewBinding");
            this.b = sj0;
            this.f3221a = zwVar;
            zwVar.f4220a.setOnClickListener(new mi0(sj0, this));
        }
    }

    public sj0(Context context, String str, int i, ci1<View> ci1) {
        n86.e(context, "_context");
        n86.e(ci1, "_itemClickListener");
        this.f3220a = context;
        this.b = str;
        this.c = i;
        this.d = ci1;
        Objects.requireNonNull(xt.f3961a.z());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemCount() {
        return this.e.length;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$a0, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(a aVar, int i) {
        a aVar2 = aVar;
        n86.e(aVar2, "holder");
        h30.a aVar3 = this.e[i];
        aVar2.f3221a.f4220a.setTag(aVar3.getLocale());
        aVar2.f3221a.b.setText(aVar3.getLanguageName(this.f3220a));
        int b2 = q5.b(this.f3220a, R.color.black);
        if (n86.a(aVar2.f3221a.f4220a.getTag(), this.b)) {
            b2 = q5.b(this.f3220a, R.color.orange_primary);
            aVar2.f3221a.c.setVisibility(0);
        } else {
            aVar2.f3221a.c.setVisibility(4);
        }
        aVar2.f3221a.b.setTextColor(b2);
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$a0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        n86.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f3220a).inflate(R.layout.dialog_radio_button_splash, (ViewGroup) null, false);
        int i2 = R.id.language;
        TextView textView = (TextView) inflate.findViewById(R.id.language);
        if (textView != null) {
            i2 = R.id.selected_lang;
            ImageView imageView = (ImageView) inflate.findViewById(R.id.selected_lang);
            if (imageView != null) {
                zw zwVar = new zw((CardView) inflate, textView, imageView);
                n86.d(zwVar, "inflate(LayoutInflater.from(_context))");
                return new a(this, zwVar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }
}
