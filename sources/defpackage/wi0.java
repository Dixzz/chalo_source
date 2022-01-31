package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.City;
import com.razorpay.AnalyticsConstants;
import defpackage.jk;
import io.github.inflationx.calligraphy3.CalligraphyUtils;
import java.util.List;
import java.util.Objects;

/* renamed from: wi0  reason: default package */
/* compiled from: CityListAdapter.kt */
public final class wi0 extends ok<b, RecyclerView.a0> {
    public final Context c;
    public final LiveData<String> d;
    public final h76<s56> e;
    public final ci1<Integer> f;
    public String g = "";

    /* renamed from: wi0$a */
    /* compiled from: CityListAdapter.kt */
    public final class a extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final iz f3785a;
        public final /* synthetic */ wi0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(wi0 wi0, iz izVar) {
            super(izVar.f1585a);
            n86.e(wi0, "this$0");
            n86.e(izVar, "viewBinding");
            this.b = wi0;
            this.f3785a = izVar;
            izVar.b.setOnClickListener(new ii0(wi0));
        }
    }

    /* renamed from: wi0$b */
    /* compiled from: CityListAdapter.kt */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final c f3786a;
        public City b;

        public b(c cVar, City city) {
            n86.e(cVar, "itemType");
            this.f3786a = cVar;
            this.b = city;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f3786a == bVar.f3786a && n86.a(this.b, bVar.b);
        }

        public int hashCode() {
            int hashCode = this.f3786a.hashCode() * 31;
            City city = this.b;
            return hashCode + (city == null ? 0 : city.hashCode());
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("CityListItem(itemType=");
            i0.append(this.f3786a);
            i0.append(", city=");
            i0.append(this.b);
            i0.append(')');
            return i0.toString();
        }
    }

    /* renamed from: wi0$c */
    /* compiled from: CityListAdapter.kt */
    public enum c {
        CITY,
        FOOTER
    }

    /* renamed from: wi0$d */
    /* compiled from: CityListAdapter.kt */
    public final class d extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final vw f3787a;
        public final /* synthetic */ wi0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(wi0 wi0, vw vwVar) {
            super(vwVar.f3686a);
            n86.e(wi0, "this$0");
            n86.e(vwVar, "viewBinding");
            this.b = wi0;
            this.f3787a = vwVar;
            vwVar.f3686a.setOnClickListener(new ji0(this, wi0));
        }
    }

    /* renamed from: wi0$e */
    /* compiled from: CityListAdapter.kt */
    public static final class e extends jk.e<b> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.jk.e
        public boolean a(b bVar, b bVar2) {
            String str;
            b bVar3 = bVar;
            b bVar4 = bVar2;
            n86.e(bVar3, "oldItem");
            n86.e(bVar4, "newItem");
            City city = bVar3.b;
            String str2 = null;
            if (city == null) {
                str = null;
            } else {
                str = city.getDisplayName();
            }
            City city2 = bVar4.b;
            if (city2 != null) {
                str2 = city2.getDisplayName();
            }
            return n86.a(str, str2);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.jk.e
        public boolean b(b bVar, b bVar2) {
            b bVar3 = bVar;
            b bVar4 = bVar2;
            n86.e(bVar3, "oldItem");
            n86.e(bVar4, "newItem");
            return bVar3.f3786a == bVar4.f3786a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public wi0(Context context, LiveData<String> liveData, h76<s56> h76, ci1<Integer> ci1) {
        super(new e());
        n86.e(context, AnalyticsConstants.CONTEXT);
        n86.e(liveData, "queryString");
        n86.e(h76, "simpleItemClickListener");
        n86.e(ci1, "itemClickListener");
        this.c = context;
        this.d = liveData;
        this.e = h76;
        this.f = ci1;
    }

    @Override // defpackage.ok
    public void c(List<b> list, List<b> list2) {
        n86.e(list, "previousList");
        n86.e(list2, "currentList");
        this.e.invoke();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemViewType(int i) {
        return this.f2701a.f.get(i).f3786a == c.CITY ? 1 : 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(RecyclerView.a0 a0Var, int i) {
        String str;
        n86.e(a0Var, "holder");
        if (a0Var instanceof d) {
            if (i == getItemCount() - 2) {
                ((d) a0Var).f3787a.b.setVisibility(8);
            } else {
                ((d) a0Var).f3787a.b.setVisibility(0);
            }
            T t = this.f2701a.f.get(i);
            LiveData<String> liveData = this.d;
            d dVar = (d) a0Var;
            Context context = dVar.f3787a.c.getContext();
            Objects.requireNonNull(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            liveData.f((fh) context, new ki0(t, this, a0Var));
            City city = t.b;
            if (city == null) {
                str = null;
            } else {
                str = city.getDisplayName();
            }
            if (n86.a(str, this.g)) {
                dVar.f3787a.c.setTextColor(q5.b(this.c, R.color.orange_primary));
                Context context2 = this.c;
                CalligraphyUtils.applyFontToTextView(context2, dVar.f3787a.c, context2.getString(R.string.font_medium));
                dVar.f3787a.d.setVisibility(0);
                return;
            }
            Context context3 = this.c;
            CalligraphyUtils.applyFontToTextView(context3, dVar.f3787a.c, context3.getString(R.string.font_regular));
            dVar.f3787a.d.setVisibility(4);
            dVar.f3787a.c.setTextColor(Color.parseColor("#DE000000"));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public RecyclerView.a0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        RecyclerView.a0 a0Var;
        n86.e(viewGroup, "parent");
        if (i == 1) {
            View inflate = LayoutInflater.from(this.c).inflate(R.layout.city_view, (ViewGroup) null, false);
            int i2 = R.id.bottom_divider;
            View findViewById = inflate.findViewById(R.id.bottom_divider);
            if (findViewById != null) {
                i2 = R.id.city_name;
                TextView textView = (TextView) inflate.findViewById(R.id.city_name);
                if (textView != null) {
                    i2 = R.id.selection_icon;
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.selection_icon);
                    if (imageView != null) {
                        vw vwVar = new vw((RelativeLayout) inflate, findViewById, textView, imageView);
                        n86.d(vwVar, "inflate(LayoutInflater.from(context))");
                        a0Var = new d(this, vwVar);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
        }
        View inflate2 = LayoutInflater.from(this.c).inflate(R.layout.suggest_city_footer_view, (ViewGroup) null, false);
        int i3 = R.id.textView3;
        TextView textView2 = (TextView) inflate2.findViewById(R.id.textView3);
        if (textView2 != null) {
            i3 = R.id.vote_for_next_city;
            TextView textView3 = (TextView) inflate2.findViewById(R.id.vote_for_next_city);
            if (textView3 != null) {
                iz izVar = new iz((ConstraintLayout) inflate2, textView2, textView3);
                n86.d(izVar, "inflate(LayoutInflater.from(context))");
                a0Var = new a(this, izVar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate2.getResources().getResourceName(i3)));
        return a0Var;
    }
}
