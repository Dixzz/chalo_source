package app.zophop.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import app.zophop.R;

public class RectangleStopView extends RelativeLayout {
    public int f;
    public View g;
    public View h;
    public View i;
    public View j;
    public View k;

    public RectangleStopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (attributeSet != null) {
            LayoutInflater.from(getContext()).inflate(R.layout.rectangle_vertical_stops, (ViewGroup) this, true);
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.RectangleStopView);
            this.f = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.action_bar_color));
            obtainStyledAttributes.recycle();
            this.g = findViewById(R.id.top_half_line);
            this.h = findViewById(R.id.bottom_half_line);
            this.i = findViewById(R.id.left_half_line);
            this.j = findViewById(R.id.righ_half_line);
            this.k = findViewById(R.id.center_dot);
            a();
        }
    }

    public final void a() {
        this.g.setBackgroundColor(this.f);
        this.h.setBackgroundColor(this.f);
        this.i.setBackgroundColor(this.f);
        this.j.setBackgroundColor(this.f);
        this.k.setBackgroundColor(this.f);
    }

    public int getColor() {
        return this.f;
    }

    public void setColor(int i2) {
        this.f = i2;
        a();
    }
}
