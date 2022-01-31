package defpackage;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.Favourites.BusFavourite;
import app.zophop.models.Favourites.Favourite;
import app.zophop.models.Favourites.RailFavourite;
import app.zophop.models.Favourites.StopBasedTripFavourite;
import app.zophop.models.Favourites.TripFavourite;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import com.razorpay.AnalyticsConstants;
import defpackage.jk;
import java.util.List;
import java.util.Objects;

/* renamed from: bk0  reason: default package */
/* compiled from: RecentSearchListAdapter.kt */
public final class bk0 extends ok<Favourite, c> {
    public static final a e = new a(null);
    public final Context c;
    public final h76<s56> d;

    /* renamed from: bk0$a */
    /* compiled from: RecentSearchListAdapter.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    /* renamed from: bk0$b */
    /* compiled from: RecentSearchListAdapter.kt */
    public static final class b extends jk.e<Favourite> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.jk.e
        public boolean a(Favourite favourite, Favourite favourite2) {
            Favourite favourite3 = favourite;
            Favourite favourite4 = favourite2;
            n86.e(favourite3, "oldItem");
            n86.e(favourite4, "newItem");
            return favourite3.getType() == favourite4.getType();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.jk.e
        public boolean b(Favourite favourite, Favourite favourite2) {
            Favourite favourite3 = favourite;
            Favourite favourite4 = favourite2;
            n86.e(favourite3, "oldItem");
            n86.e(favourite4, "newItem");
            return n86.a(favourite3.getId(), favourite4.getId());
        }
    }

    /* renamed from: bk0$c */
    /* compiled from: RecentSearchListAdapter.kt */
    public final class c extends RecyclerView.a0 {

        /* renamed from: a  reason: collision with root package name */
        public final xy f444a;
        public final /* synthetic */ bk0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(bk0 bk0, xy xyVar) {
            super(xyVar.f3977a);
            n86.e(bk0, "this$0");
            n86.e(xyVar, "viewBinding");
            this.b = bk0;
            this.f444a = xyVar;
            xyVar.f3977a.setOnClickListener(new oi0(this, bk0));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bk0(Context context, h76<s56> h76) {
        super(new b());
        n86.e(context, AnalyticsConstants.CONTEXT);
        n86.e(h76, "listChangeListener");
        this.c = context;
        this.d = h76;
    }

    @Override // defpackage.ok
    public void c(List<Favourite> list, List<Favourite> list2) {
        n86.e(list, "previousList");
        n86.e(list2, "currentList");
        this.d.invoke();
    }

    public final String e(String str) {
        if (str == null || str.length() == 0) {
            return new String();
        }
        int n = ea6.n(str, ",", 0, false, 6);
        if (n == -1) {
            int length = str.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = n86.g(str.charAt(!z ? i : length), 32) <= 0;
                if (!z) {
                    if (!z2) {
                        z = true;
                    } else {
                        i++;
                    }
                } else if (!z2) {
                    break;
                } else {
                    length--;
                }
            }
            return str.subSequence(i, length + 1).toString();
        }
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(0, n);
        n86.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        int length2 = substring.length() - 1;
        int i2 = 0;
        boolean z3 = false;
        while (i2 <= length2) {
            boolean z4 = n86.g(substring.charAt(!z3 ? i2 : length2), 32) <= 0;
            if (!z3) {
                if (!z4) {
                    z3 = true;
                } else {
                    i2++;
                }
            } else if (!z4) {
                break;
            } else {
                length2--;
            }
        }
        return substring.subSequence(i2, length2 + 1).toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v12, resolved type: android.text.SpannableStringBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(RecyclerView.a0 a0Var, int i) {
        int i2;
        int i3;
        String str;
        String str2;
        c cVar = (c) a0Var;
        n86.e(cVar, "holder");
        View view = cVar.itemView;
        if (getItemCount() == 1) {
            i2 = -1;
        } else {
            i2 = (int) (((float) this.c.getResources().getDisplayMetrics().widthPixels) * 0.6f);
        }
        view.setLayoutParams(new ViewGroup.LayoutParams(i2, -2));
        xy xyVar = cVar.f444a;
        ImageView imageView = xyVar.c;
        T t = this.f2701a.f.get(i);
        if (t instanceof TripFavourite ? true : t instanceof StopBasedTripFavourite) {
            i3 = R.drawable.recent_trip;
        } else {
            i3 = t instanceof RailFavourite ? R.drawable.metro_nearby_card_item_icon : R.drawable.bus_nearby_card_item_icon;
        }
        imageView.setImageResource(i3);
        MaterialTextView materialTextView = xyVar.b;
        T t2 = this.f2701a.f.get(i);
        if (t2 instanceof TripFavourite) {
            String string = this.c.getString(R.string.from);
            n86.d(string, "context.getString(R.string.from)");
            str = hj1.e0(new Object[]{e(t2.getFrom().c)}, 1, string, "java.lang.String.format(format, *args)");
        } else if (t2 instanceof StopBasedTripFavourite) {
            String string2 = this.c.getString(R.string.from);
            n86.d(string2, "context.getString(R.string.from)");
            str = hj1.e0(new Object[]{e(t2.getOriginStop().getName())}, 1, string2, "java.lang.String.format(format, *args)");
        } else if (t2 instanceof BusFavourite) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            T t3 = t2;
            spannableStringBuilder.append((CharSequence) t3.getRouteName());
            for (String str3 : t3.get_spfList()) {
                d71.b(this.c, spannableStringBuilder, str3, true, R.color.spf, t3.getRouteName().length(), R.color.black_87);
            }
            str = spannableStringBuilder;
        } else if (t2 instanceof RailFavourite) {
            String string3 = this.c.getString(R.string.from);
            n86.d(string3, "context.getString(R.string.from)");
            str = hj1.e0(new Object[]{t2.getFromStop().getName()}, 1, string3, "java.lang.String.format(format, *args)");
        } else {
            str = new String();
        }
        materialTextView.setText(str);
        MaterialTextView materialTextView2 = xyVar.d;
        T t4 = this.f2701a.f.get(i);
        if (t4 instanceof TripFavourite) {
            String string4 = this.c.getString(R.string.to);
            n86.d(string4, "context.getString(R.string.to)");
            str2 = hj1.e0(new Object[]{e(t4.getTo().c)}, 1, string4, "java.lang.String.format(format, *args)");
        } else if (t4 instanceof StopBasedTripFavourite) {
            String string5 = this.c.getString(R.string.to);
            n86.d(string5, "context.getString(R.string.to)");
            str2 = hj1.e0(new Object[]{e(t4.getDestinationStop().getName())}, 1, string5, "java.lang.String.format(format, *args)");
        } else if (t4 instanceof RailFavourite) {
            String string6 = this.c.getString(R.string.to);
            n86.d(string6, "context.getString(R.string.to)");
            str2 = hj1.e0(new Object[]{t4.getToStop().getName()}, 1, string6, "java.lang.String.format(format, *args)");
        } else {
            String string7 = this.c.getString(R.string.to);
            n86.d(string7, "context.getString(R.string.to)");
            Objects.requireNonNull(t4, "null cannot be cast to non-null type app.zophop.models.Favourites.BusFavourite");
            str2 = hj1.e0(new Object[]{t4.getEndStopName()}, 1, string7, "java.lang.String.format(format, *args)");
        }
        materialTextView2.setText(str2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public RecyclerView.a0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        n86.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.c).inflate(R.layout.recent_card_home, (ViewGroup) null, false);
        int i2 = R.id.bus_number_or_destination;
        MaterialTextView materialTextView = (MaterialTextView) inflate.findViewById(R.id.bus_number_or_destination);
        if (materialTextView != null) {
            i2 = R.id.bus_or_destination_icon;
            ImageView imageView = (ImageView) inflate.findViewById(R.id.bus_or_destination_icon);
            if (imageView != null) {
                i2 = R.id.destination_or_starting;
                MaterialTextView materialTextView2 = (MaterialTextView) inflate.findViewById(R.id.destination_or_starting);
                if (materialTextView2 != null) {
                    xy xyVar = new xy((MaterialCardView) inflate, materialTextView, imageView, materialTextView2);
                    n86.d(xyVar, "inflate(LayoutInflater.from(context))");
                    return new c(this, xyVar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }
}
