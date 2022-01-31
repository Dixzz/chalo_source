package defpackage;

import android.content.Context;
import android.view.View;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.products.CategorySelectionActivity;
import defpackage.pu;
import java.util.List;

/* renamed from: ou  reason: default package */
/* compiled from: DurationAdapter */
public class ou implements View.OnClickListener {
    public final /* synthetic */ pu.a f;

    public ou(pu.a aVar) {
        this.f = aVar;
    }

    public void onClick(View view) {
        pu.a aVar = this.f;
        pu.this.c = aVar.getAdapterPosition();
        pu.this.notifyDataSetChanged();
        Context context = pu.this.b;
        if (context instanceof CategorySelectionActivity) {
            CategorySelectionActivity categorySelectionActivity = (CategorySelectionActivity) context;
            categorySelectionActivity.C.setText(categorySelectionActivity.getString(R.string.next));
            categorySelectionActivity.C.setVisibility(0);
            pu.a aVar2 = this.f;
            CategorySelectionActivity categorySelectionActivity2 = (CategorySelectionActivity) pu.this.b;
            long j = aVar2.k;
            List<String> list = aVar2.l;
            double parseDouble = Double.parseDouble(aVar2.b.getText().toString().substring(1));
            pu.a aVar3 = this.f;
            String str = aVar3.m;
            int i = aVar3.n;
            int i2 = aVar3.o;
            categorySelectionActivity2.J = list;
            categorySelectionActivity2.F = j;
            categorySelectionActivity2.V = str;
            categorySelectionActivity2.K = parseDouble;
            categorySelectionActivity2.Z = i;
            categorySelectionActivity2.a0 = i2;
            ed1 l = hj1.l("duration selection", Long.MIN_VALUE, "durationName", str);
            l.a("durationId", Integer.valueOf((int) (j / 86400000)));
            l.a(SuperPassJsonKeys.FARE, Double.valueOf(parseDouble));
            jz5.b().g(l);
        }
    }
}
