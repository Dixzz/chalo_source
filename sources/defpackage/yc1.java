package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.ui.views.RouteListLine;
import app.zophop.ui.views.summary_card.CardItem;
import app.zophop.ui.views.summary_card.RouteListCardItem;

/* renamed from: yc1  reason: default package */
/* compiled from: RouteListItem */
public class yc1 extends LinearLayout {
    public RouteListCardItem f;
    public RouteListLine g;
    public b h;
    public View i;
    public View j;
    public final int k;
    public boolean l;
    public final Handler m = new Handler();

    /* renamed from: yc1$a */
    /* compiled from: RouteListItem */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            yc1.this.invalidate();
        }
    }

    /* renamed from: yc1$b */
    /* compiled from: RouteListItem */
    public enum b {
        FIRST,
        INTERMEDIATE,
        LAST
    }

    public yc1(Context context) {
        super(context, null, 0);
        removeAllViews();
        View inflate = LayoutInflater.from(context).inflate(R.layout.route_list_item, (ViewGroup) this, false);
        this.i = inflate;
        addView(inflate);
        this.f = (RouteListCardItem) findViewById(R.id.card_item);
        this.g = (RouteListLine) findViewById(R.id.route_list_line);
        this.f.setBackgroundResource(0);
        this.j = findViewById(R.id.divider);
        this.k = getResources().getDimensionPixelSize(R.dimen.route_list_center_drawable_size) / 2;
    }

    public final int a(int i2) {
        invalidate();
        requestLayout();
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i3 = iArr[1];
        int[] iArr2 = new int[2];
        findViewById(R.id.card_title).getLocationOnScreen(iArr2);
        return ((findViewById(R.id.card_title).getMeasuredHeight() / 2) - i2) + Math.abs(i3 - iArr2[1]);
    }

    public void b(int i2, int i3, int i4) {
        a(i3 / 2);
        this.g.b(i2, i4);
    }

    public RouteListLine getListLine() {
        return this.g;
    }

    public TextView getViewScheduleView() {
        return this.f.getViewScheduledTextView();
    }

    public void setColor(int i2) {
        this.g.setColor(i2);
    }

    public void setContent(CardItem.b bVar) {
        this.f.setContent(bVar);
        if (!this.l && this.f.getReportHook() != null) {
            this.f.getReportHook().setVisibility(8);
        }
        if (bVar.b != null) {
            this.f.findViewById(R.id.train_list_bottom_line).setVisibility(0);
        }
        if (bVar.f != null) {
            this.f.findViewById(R.id.card_title_from).setAlpha(0.4f);
        }
    }

    public void setDrawableIcon(int i2) {
        b(i2, getContext().getResources().getDimensionPixelSize(R.dimen.arrow_down_width), R.dimen.center_dot_route_adapter_top_margin);
    }

    public void setEnabled(boolean z) {
        TextView textView = (TextView) this.f.findViewById(R.id.card_title);
        if (z) {
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getContext().getResources().getColor(R.color.card_item_enable_color));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(textView.getText());
            spannableStringBuilder.setSpan(foregroundColorSpan, 0, spannableStringBuilder.length(), 17);
            textView.setText(spannableStringBuilder);
            return;
        }
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(getContext().getResources().getColor(R.color.card_item_disabled_color));
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        spannableStringBuilder2.append(textView.getText());
        spannableStringBuilder2.setSpan(foregroundColorSpan2, 0, spannableStringBuilder2.length(), 17);
        textView.setText(spannableStringBuilder2);
    }

    public void setLiveBottom(int i2) {
        RouteListLine routeListLine = this.g;
        routeListLine.j.setImageResource(i2);
        routeListLine.j.setVisibility(0);
    }

    public void setLiveTop(int i2) {
        RouteListLine routeListLine = this.g;
        routeListLine.i.setImageResource(i2);
        routeListLine.i.setVisibility(0);
    }

    public void setNearestStop(boolean z) {
    }

    public void setPressStateBackground(int i2) {
        this.i.setBackground(getResources().getDrawable(i2));
    }

    public void setShowReportHook(boolean z) {
        this.l = z;
    }

    public void setStopType(b bVar) {
        RouteListLine routeListLine = (RouteListLine) findViewById(R.id.route_list_line);
        int a2 = a(this.k);
        if (bVar.equals(b.FIRST)) {
            routeListLine.setFirstStop(a2);
        } else if (bVar.equals(b.INTERMEDIATE)) {
            routeListLine.g.setVisibility(0);
            routeListLine.h.setVisibility(0);
        } else {
            routeListLine.setLastStop(getMeasuredHeight() - a2);
        }
        this.m.postDelayed(new a(), 500);
        this.h = bVar;
    }

    public void setLiveBottom(Bitmap bitmap) {
        RouteListLine routeListLine = this.g;
        routeListLine.j.setImageBitmap(bitmap);
        routeListLine.j.setVisibility(0);
    }

    public void setLiveTop(Bitmap bitmap) {
        RouteListLine routeListLine = this.g;
        routeListLine.i.setImageBitmap(bitmap);
        routeListLine.i.setVisibility(0);
    }
}
