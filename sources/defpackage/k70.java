package defpackage;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.products.CategorySelectionActivity;
import java.util.HashMap;

/* renamed from: k70  reason: default package */
/* compiled from: CategorySelectionActivity */
public class k70 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ mu f;
    public final /* synthetic */ CategorySelectionActivity g;

    public k70(CategorySelectionActivity categorySelectionActivity, mu muVar) {
        this.g = categorySelectionActivity;
        this.f = muVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        view.findViewById(R.id.groupingId).setBackground(this.g.getResources().getDrawable(R.drawable.orange_capsule));
        ((TextView) view.findViewById(R.id.groupingId)).setTextColor(this.g.getResources().getColor(R.color.white));
        view.findViewById(R.id.groupingId).setPadding((int) ui1.n(16.0f, this.g), (int) ui1.n(10.0f, this.g), (int) ui1.n(16.0f, this.g), (int) ui1.n(10.0f, this.g));
        CategorySelectionActivity categorySelectionActivity = this.g;
        categorySelectionActivity.b0 = true;
        categorySelectionActivity.H = (String) view.findViewById(R.id.groupingId).getTag();
        categorySelectionActivity.r0();
        this.f.notifyDataSetChanged();
        HashMap hashMap = new HashMap();
        hashMap.put("ss category", this.g.H);
        jz5.b().g(new ed1("ss category selected", Long.MIN_VALUE, hashMap));
    }
}
