package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import app.zophop.R;
import defpackage.gn0;
import defpackage.qm0;

/* renamed from: pb1  reason: default package */
/* compiled from: RatingTagView */
public class pb1 extends LinearLayout {
    public final Context f;
    public String g;
    public String h;
    public gn0.b i;
    public qm0.f j;

    public pb1(Context context) {
        super(context);
        this.f = context;
        LayoutInflater.from(getContext()).inflate(R.layout.rating_tag, (ViewGroup) this, true);
        findViewById(R.id.tag).setOnClickListener(new ob1(this));
    }

    public boolean a() {
        return ((CheckBox) findViewById(R.id.tag)).isChecked();
    }

    public String getName() {
        return this.h;
    }

    public String getTagId() {
        return this.g;
    }

    public void setName(String str) {
        this.h = str;
        ((CheckBox) findViewById(R.id.tag)).setText(this.h);
    }

    public void setTagId(String str) {
        this.g = str;
    }

    public void setTagStatusListener(gn0.b bVar) {
        this.i = bVar;
    }

    public void setTagStatusListener(qm0.f fVar) {
        this.j = fVar;
    }
}
