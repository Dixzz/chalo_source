package defpackage;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.Favourites.BusFavourite;
import app.zophop.models.Favourites.BusFavouriteWithSubscription;
import app.zophop.models.Favourites.Favourite;
import app.zophop.models.Favourites.RailFavourite;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.Favourites.StopBasedTripFavourite;
import app.zophop.models.Favourites.TripFavourite;
import app.zophop.ui.activities.SubscriptionActivity;
import defpackage.xt;
import java.util.Objects;
import org.json.JSONException;

/* renamed from: gc1  reason: default package */
/* compiled from: FavoriteCard */
public class gc1 extends LinearLayout {
    public static final /* synthetic */ int k = 0;
    public Favourite f;
    public ci1<Favourite> g;
    public ci1<Favourite> h;
    public ci1<Favourite> i;
    public ci1<Favourite> j;

    /* renamed from: gc1$a */
    /* compiled from: FavoriteCard */
    public class a implements View.OnClickListener {
        public final /* synthetic */ Favourite f;
        public final /* synthetic */ ImageView g;

        public a(Favourite favourite, ImageView imageView) {
            this.f = favourite;
            this.g = imageView;
        }

        public void onClick(View view) {
            if (this.f.getRouteStoreType().equals(RouteStoreType.FAVORITE)) {
                gc1 gc1 = gc1.this;
                Context context = gc1.getContext();
                ImageView imageView = this.g;
                int i = gc1.k;
                int dimensionPixelSize = gc1.getResources().getDimensionPixelSize(R.dimen.favorite_edit_pop_up_width);
                View inflate = LayoutInflater.from(context).inflate(R.layout.fav_pop_up, (ViewGroup) null, false);
                PopupWindow popupWindow = new PopupWindow(context);
                popupWindow.setContentView(inflate);
                popupWindow.setWidth(dimensionPixelSize);
                popupWindow.setHeight(-2);
                popupWindow.setFocusable(true);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.showAsDropDown(imageView, 0, 0);
                inflate.setOnClickListener(new hc1(gc1, popupWindow));
                return;
            }
            gc1 gc12 = gc1.this;
            Context context2 = gc12.getContext();
            ImageView imageView2 = this.g;
            RouteStoreType routeStoreType = RouteStoreType.RECENT;
            int i2 = gc1.k;
            Objects.requireNonNull(gc12);
            View inflate2 = LayoutInflater.from(context2).inflate(R.layout.favorite_edit_pop_up, (ViewGroup) null, false);
            ((TextView) inflate2.findViewById(R.id.edit)).setText(context2.getString(R.string.set_favorite));
            ((TextView) inflate2.findViewById(R.id.remove)).setText(context2.getString(R.string.remove));
            int dimensionPixelSize2 = context2.getResources().getDimensionPixelSize(R.dimen.favorite_edit_pop_up_width);
            PopupWindow popupWindow2 = new PopupWindow(context2);
            popupWindow2.setContentView(inflate2);
            popupWindow2.setWidth(dimensionPixelSize2);
            popupWindow2.setHeight(-2);
            popupWindow2.setFocusable(true);
            popupWindow2.setBackgroundDrawable(new BitmapDrawable());
            popupWindow2.setSoftInputMode(3);
            popupWindow2.showAsDropDown(imageView2, 0, 0);
            inflate2.findViewById(R.id.remove).setOnClickListener(new ic1(gc12, routeStoreType, popupWindow2));
            inflate2.findViewById(R.id.edit).setOnClickListener(new jc1(gc12, popupWindow2));
            if (gc12.f instanceof TripFavourite) {
                inflate2.findViewById(R.id.edit).setVisibility(8);
            }
        }
    }

    /* renamed from: gc1$b */
    /* compiled from: FavoriteCard */
    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            gc1 gc1 = gc1.this;
            ci1<Favourite> ci1 = gc1.h;
            if (ci1 != null) {
                ci1.a(gc1.f);
            }
        }
    }

    /* renamed from: gc1$c */
    /* compiled from: FavoriteCard */
    public class c implements View.OnClickListener {
        public final /* synthetic */ BusFavourite f;

        public c(gc1 gc1, BusFavourite busFavourite) {
            this.f = busFavourite;
        }

        public void onClick(View view) {
            Context context = view.getContext();
            BusFavourite busFavourite = this.f;
            int i = SubscriptionActivity.y;
            try {
                Intent intent = new Intent(context, SubscriptionActivity.class);
                intent.putExtra("favorite_route", new mv().c(busFavourite).toString());
                context.startActivity(intent);
            } catch (JSONException unused) {
            }
        }
    }

    public gc1(Context context) {
        super(context);
    }

    private void setSubscribeIcon(BusFavourite busFavourite) {
        ImageView imageView = (ImageView) findViewById(R.id.subscribe_button);
        xt.t1 t1Var = xt.f3961a;
        if (((BusFavourite) t1Var.r().h(busFavourite.getRouteId(), RouteStoreType.FAVORITE)) == null) {
            imageView.setVisibility(8);
            return;
        }
        if (((BusFavouriteWithSubscription) t1Var.r().h(busFavourite.getRouteId(), RouteStoreType.SUBSCRIBED)) != null) {
            imageView.setImageResource(R.drawable.unsubscribe_tool_bar_icon);
        } else {
            imageView.setImageResource(R.drawable.subscribe_tool_bar_icon);
        }
        imageView.setOnClickListener(new c(this, busFavourite));
    }

    public final int a(Favourite favourite) {
        int ordinal = favourite.getMode().ordinal();
        if (ordinal == 0) {
            return R.drawable.train_nearby_card_item_icon;
        }
        if (ordinal == 1) {
            return R.drawable.bus_nearby_card_item_icon;
        }
        if (ordinal == 2) {
            return R.drawable.metro_nearby_card_item_icon;
        }
        if (ordinal == 3) {
            return R.drawable.monorail_nearby_card_item_icon;
        }
        if (ordinal != 5) {
            return -1;
        }
        return R.drawable.ferry_nearby_card_item_icon;
    }

    public final String b(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(",");
        if (indexOf != -1) {
            return str.substring(0, indexOf).trim();
        }
        return str.trim();
    }

    public void c(Favourite favourite) {
        this.f = favourite;
        LayoutInflater.from(getContext()).inflate(R.layout.fav_from_to_container, (ViewGroup) this, true);
        TextView textView = (TextView) findViewById(R.id.from_station);
        TextView textView2 = (TextView) findViewById(R.id.to_station);
        ImageView imageView = (ImageView) findViewById(R.id.fav_icon);
        ImageView imageView2 = (ImageView) findViewById(R.id.subscribe_button);
        findViewById(R.id.agency_name).setVisibility(8);
        findViewById(R.id.fav_options_container).setOnClickListener(new a(favourite, (ImageView) findViewById(R.id.fav_options)));
        findViewById(R.id.fav_content).setOnClickListener(new b());
        if (favourite instanceof RailFavourite) {
            RailFavourite railFavourite = (RailFavourite) favourite;
            CharSequence format = String.format(getContext().getString(R.string.from), railFavourite.getFromStop().getName());
            CharSequence format2 = String.format(getContext().getString(R.string.to), railFavourite.getToStop().getName());
            textView.setText(format);
            textView2.setText(format2);
            imageView.setImageResource(a(favourite));
            imageView2.setVisibility(8);
        } else if (favourite instanceof TripFavourite) {
            TripFavourite tripFavourite = (TripFavourite) favourite;
            textView.setText(String.format(getContext().getString(R.string.from), b(tripFavourite.getFrom().c)));
            String format3 = String.format(getContext().getString(R.string.to), b(tripFavourite.getTo().c));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(format3);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.setSpan(vn.N(getContext(), wg1.NOTOSANS_MEDIUM), spannableStringBuilder.length() - spannableString.length(), spannableStringBuilder.length(), 33);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(18, true), spannableStringBuilder.length() - spannableString.length(), spannableStringBuilder.length(), 33);
            textView2.setText(spannableStringBuilder);
            imageView.setImageResource(R.drawable.recent_trip);
            imageView2.setVisibility(8);
        } else if (favourite instanceof StopBasedTripFavourite) {
            StopBasedTripFavourite stopBasedTripFavourite = (StopBasedTripFavourite) favourite;
            textView.setText(String.format(getContext().getString(R.string.from), b(stopBasedTripFavourite.getOriginStop().getName())));
            String format4 = String.format(getContext().getString(R.string.to), b(stopBasedTripFavourite.getDestinationStop().getName()));
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            SpannableString spannableString2 = new SpannableString(format4);
            spannableStringBuilder2.append((CharSequence) spannableString2);
            spannableStringBuilder2.setSpan(vn.N(getContext(), wg1.NOTOSANS_MEDIUM), spannableStringBuilder2.length() - spannableString2.length(), spannableStringBuilder2.length(), 33);
            spannableStringBuilder2.setSpan(new AbsoluteSizeSpan(18, true), spannableStringBuilder2.length() - spannableString2.length(), spannableStringBuilder2.length(), 33);
            textView2.setText(spannableStringBuilder2);
            imageView.setImageResource(R.drawable.recent_trip);
            imageView2.setVisibility(8);
        } else {
            BusFavourite busFavourite = (BusFavourite) favourite;
            String routeName = busFavourite.getRouteName();
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder();
            SpannableString spannableString3 = new SpannableString(routeName);
            spannableStringBuilder3.append((CharSequence) spannableString3);
            spannableStringBuilder3.setSpan(vn.N(getContext(), wg1.NOTOSANS_MEDIUM), spannableStringBuilder3.length() - spannableString3.length(), spannableStringBuilder3.length(), 33);
            spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(18, true), spannableStringBuilder3.length() - spannableString3.length(), spannableStringBuilder3.length(), 33);
            float dimensionPixelSize = (float) getResources().getDimensionPixelSize(R.dimen.favorite_item_bus_to);
            if (!ui1.Y()) {
                textView2.setTextSize(0, dimensionPixelSize);
                textView2.setText(String.format(getContext().getResources().getString(R.string.to), busFavourite.getEndStopName()));
                textView2.setMaxLines(2);
            } else {
                textView2.setVisibility(8);
            }
            imageView.setImageResource(a(favourite));
            setSubscribeIcon(busFavourite);
            for (int i2 = 0; i2 < busFavourite.get_spfList().size(); i2++) {
                d71.b(getContext(), spannableStringBuilder3, busFavourite.get_spfList().get(i2), true, R.color.spf, busFavourite.getRouteName().length(), R.color.black_87);
            }
            if (busFavourite.getAgency() != null && !ui1.Y()) {
                findViewById(R.id.agency_name).setVisibility(8);
                d71.a(getContext(), spannableStringBuilder3, busFavourite.getAgency().toUpperCase(), true, busFavourite.getRouteName().length());
            }
            textView.setText(spannableStringBuilder3);
        }
    }

    public void setAddFavoriteListener(ci1<Favourite> ci1) {
        this.j = ci1;
    }

    public void setClickListener(ci1<Favourite> ci1) {
        this.h = ci1;
    }

    public void setFavoriteRemovedListener(ci1<Favourite> ci1) {
        this.g = ci1;
    }

    public void setRecentRemovedListener(ci1<Favourite> ci1) {
        this.i = ci1;
    }
}
