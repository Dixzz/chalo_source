package app.zophop.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import app.zophop.R;

public class RouteListLine extends RelativeLayout {
    public int f;
    public View g;
    public View h;
    public ImageView i;
    public ImageView j;
    public boolean k;
    public Context l;
    public ImageView m;
    public View n;

    public RouteListLine(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        a();
        this.l = context;
        this.l = context;
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.route_list_vertical_stops, (ViewGroup) this, true);
        this.g = findViewById(R.id.route_list_line_top);
        this.h = findViewById(R.id.route_list_line_bottom);
        this.i = (ImageView) findViewById(R.id.top_live_view);
        this.j = (ImageView) findViewById(R.id.bottom_live_view);
        this.n = findViewById(R.id.dummyView);
        this.m = (ImageView) findViewById(R.id.center_drawable);
    }

    public void b(int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(i3);
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.center_dot_route_adapter);
        this.n.setLayoutParams(layoutParams);
        this.m.setBackgroundResource(i2);
        invalidate();
        requestLayout();
    }

    public int getColor() {
        return this.f;
    }

    public void setCenterDrawableMargin(int i2) {
        getContext().getResources().getDimensionPixelSize(R.dimen.arrow_down_width);
        b(i2, R.dimen.center_dot_route_adapter_top_margin);
    }

    public void setColor(int i2) {
        this.f = i2;
        this.g.setBackgroundColor(i2);
        this.h.setBackgroundColor(this.f);
    }

    public void setFerry(boolean z) {
        this.k = z;
        if ((!ui1.Y() && !ui1.X()) || (ui1.Y() && this.k)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams.width = this.l.getResources().getDimensionPixelSize(R.dimen.route_list_live_drawable_width);
            layoutParams.height = this.l.getResources().getDimensionPixelSize(R.dimen.route_list_live_drawable_height_icon);
            layoutParams.topMargin = this.l.getResources().getDimensionPixelOffset(R.dimen.route_bus_icon_margin);
            layoutParams.leftMargin = this.l.getResources().getDimensionPixelOffset(R.dimen.route_bus_icon_left_padding);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams2.width = this.l.getResources().getDimensionPixelSize(R.dimen.route_list_live_drawable_width);
            layoutParams2.height = this.l.getResources().getDimensionPixelSize(R.dimen.route_list_live_drawable_height_icon);
            layoutParams2.bottomMargin = this.l.getResources().getDimensionPixelOffset(R.dimen.route_bus_icon_margin);
            layoutParams2.leftMargin = this.l.getResources().getDimensionPixelOffset(R.dimen.route_bus_icon_left_padding);
            this.i.setLayoutParams(layoutParams);
            this.j.setLayoutParams(layoutParams2);
        }
    }

    public void setFirstStop(int i2) {
        this.g.setVisibility(8);
        this.h.setVisibility(0);
    }

    public void setLastStop(int i2) {
        this.g.setVisibility(0);
        this.h.setVisibility(8);
    }
}
