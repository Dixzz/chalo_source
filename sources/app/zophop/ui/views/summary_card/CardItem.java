package app.zophop.ui.views.summary_card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.TransitMode;
import com.facebook.shimmer.ShimmerFrameLayout;
import java.util.List;
import java.util.Objects;
import zophop.models.SPECIAL_FEATURE;

public class CardItem extends LinearLayout {
    public b f;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            ci1 ci1;
            CardItem cardItem = CardItem.this;
            b bVar = cardItem.f;
            Objects.requireNonNull(cardItem);
            if (bVar != null && (ci1 = bVar.o) != null) {
                ci1.a(Boolean.TRUE);
            }
        }
    }

    public CardItem(Context context) {
        super(context);
        a(context);
    }

    public void a(Context context) {
        LayoutInflater.from(getContext()).inflate(R.layout.card_item, (ViewGroup) this, true);
        setBackgroundResource(R.drawable.favorite_selector);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0167  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
        // Method dump skipped, instructions count: 1259
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.views.summary_card.CardItem.b():void");
    }

    public b getContent() {
        return this.f;
    }

    public TextView getScheduledTimeView() {
        return (TextView) findViewById(R.id.scheduled_time);
    }

    public ImageView getSeatAvailabilityIconView() {
        return (ImageView) findViewById(R.id.seat_availability_imageview_nearby_stops);
    }

    public ShimmerFrameLayout getSkeletonLoaderEta() {
        return (ShimmerFrameLayout) findViewById(R.id.nearby_stop_trip_card_eta_skeleton);
    }

    public LinearLayout getTimeDetailsContainer() {
        return (LinearLayout) findViewById(R.id.time_details_containter);
    }

    public TextView getTimeView() {
        return (TextView) findViewById(R.id.card_timing);
    }

    public TextView getViewScheduledTextView() {
        return (TextView) findViewById(R.id.view_schedule_view);
    }

    public void setContent(b bVar) {
        this.f = bVar;
        b();
    }

    public CardItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f318a;
        public final CharSequence b;
        public final CharSequence c;
        public CharSequence d;
        public List<SPECIAL_FEATURE> e;
        public CharSequence f;
        public final int g;
        public String h;
        public TransitMode i;
        public int j = -1;
        public int k = -1;
        public int l = -1;
        public boolean m = false;
        public String n;
        public ci1 o = null;
        public String p = null;

        public b(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
            this.f318a = charSequence;
            this.b = charSequence2;
            this.c = charSequence3;
            this.f = charSequence4;
            this.g = -1;
        }

        public b(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, int i2, TransitMode transitMode) {
            this.f318a = charSequence;
            this.b = charSequence2;
            this.c = charSequence3;
            this.f = charSequence4;
            this.g = i2;
            this.i = transitMode;
        }

        public b(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5) {
            this.f318a = charSequence;
            this.b = null;
            this.c = null;
            this.f = null;
            this.g = -1;
            this.d = charSequence5;
        }
    }
}
