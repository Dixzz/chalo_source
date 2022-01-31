package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import defpackage.m4;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class TimePickerView extends ConstraintLayout {
    public static final /* synthetic */ int A = 0;
    public final Chip w;
    public final Chip x;
    public final MaterialButtonToggleGroup y;
    public final View.OnClickListener z;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            TimePickerView timePickerView = TimePickerView.this;
            int i = TimePickerView.A;
            Objects.requireNonNull(timePickerView);
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        a aVar = new a();
        this.z = aVar;
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        ClockFaceView clockFaceView = (ClockFaceView) findViewById(R.id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.y = materialButtonToggleGroup;
        materialButtonToggleGroup.i.add(new fq4(this));
        Chip chip = (Chip) findViewById(R.id.material_minute_tv);
        this.w = chip;
        Chip chip2 = (Chip) findViewById(R.id.material_hour_tv);
        this.x = chip2;
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        hq4 hq4 = new hq4(this, new GestureDetector(getContext(), new gq4(this)));
        chip.setOnTouchListener(hq4);
        chip2.setOnTouchListener(hq4);
        int i = R.id.selection_type;
        chip.setTag(i, 12);
        chip2.setTag(i, 10);
        chip.setOnClickListener(aVar);
        chip2.setOnClickListener(aVar);
    }

    public final void j() {
        if (this.y.getVisibility() == 0) {
            m4 m4Var = new m4();
            m4Var.b(this);
            AtomicInteger atomicInteger = r8.f3055a;
            char c = getLayoutDirection() == 0 ? (char) 2 : 1;
            int i = R.id.material_clock_display;
            if (m4Var.c.containsKey(Integer.valueOf(i))) {
                m4.a aVar = m4Var.c.get(Integer.valueOf(i));
                switch (c) {
                    case 1:
                        m4.b bVar = aVar.d;
                        bVar.i = -1;
                        bVar.h = -1;
                        bVar.D = -1;
                        bVar.J = -1;
                        break;
                    case 2:
                        m4.b bVar2 = aVar.d;
                        bVar2.k = -1;
                        bVar2.j = -1;
                        bVar2.E = -1;
                        bVar2.L = -1;
                        break;
                    case 3:
                        m4.b bVar3 = aVar.d;
                        bVar3.m = -1;
                        bVar3.l = -1;
                        bVar3.F = -1;
                        bVar3.K = -1;
                        break;
                    case 4:
                        m4.b bVar4 = aVar.d;
                        bVar4.n = -1;
                        bVar4.o = -1;
                        bVar4.G = -1;
                        bVar4.M = -1;
                        break;
                    case 5:
                        aVar.d.p = -1;
                        break;
                    case 6:
                        m4.b bVar5 = aVar.d;
                        bVar5.q = -1;
                        bVar5.r = -1;
                        bVar5.I = -1;
                        bVar5.O = -1;
                        break;
                    case 7:
                        m4.b bVar6 = aVar.d;
                        bVar6.s = -1;
                        bVar6.t = -1;
                        bVar6.H = -1;
                        bVar6.N = -1;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown constraint");
                }
            }
            m4Var.a(this, true);
            setConstraintSet(null);
            requestLayout();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        j();
    }

    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            j();
        }
    }
}
