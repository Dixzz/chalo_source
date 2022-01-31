package app.zophop.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import app.zophop.R;

public class InfoIndexView extends LinearLayout {
    public int f;
    public View g;
    public View h;

    public enum a {
        START,
        INTERMEDIATE,
        END
    }

    public InfoIndexView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.InfoIndexView);
        this.f = obtainStyledAttributes.getColor(2, getResources().getColor(R.color.black));
        setGravity(17);
        setOrientation(1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(3, R.dimen.action_bar_height);
        View view = new View(getContext());
        view.setBackgroundColor(this.f);
        view.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.route_horizontal_line_height), dimensionPixelSize));
        this.g = view;
        addView(view);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        drawable = drawable == null ? getResources().getDrawable(R.drawable.mticketinfo_circle) : drawable;
        int dimension = (int) obtainStyledAttributes.getDimension(1, 2.13116531E9f);
        View view2 = new View(getContext());
        view2.setBackgroundDrawable(drawable);
        view2.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
        addView(view2);
        View view3 = new View(getContext());
        view3.setBackgroundColor(this.f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.route_horizontal_line_height), 0);
        layoutParams.weight = 1.0f;
        view3.setLayoutParams(layoutParams);
        this.h = view3;
        addView(view3);
    }

    public void setMode(a aVar) {
        if (a.START.equals(aVar)) {
            this.h.setVisibility(0);
            this.g.setVisibility(4);
        } else if (a.END.equals(aVar)) {
            this.g.setVisibility(0);
            this.h.setVisibility(4);
        } else {
            this.g.setVisibility(0);
            this.h.setVisibility(0);
        }
    }
}
