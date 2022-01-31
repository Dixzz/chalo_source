package com.freshchat.consumer.sdk.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.b;
import com.freshchat.consumer.sdk.a.q;
import com.freshchat.consumer.sdk.beans.FAQCategory;
import com.freshchat.consumer.sdk.f.e;
import com.freshchat.consumer.sdk.k.t;
import com.freshchat.consumer.sdk.service.Status;

public class FAQCategoriesActivity extends ah<t> {
    private View.OnClickListener ac = new am(this);
    private b.a aj = new al(this);
    private RecyclerView pj;
    private q<FAQCategory> pk;
    private e po = new an(this);

    private RecyclerView.m iA() {
        return ((t) this.pe).shouldShowFaqCategoriesAsGrid() ? iB() : new LinearLayoutManager(getContext());
    }

    private GridLayoutManager iB() {
        int a2 = ((t) this.pe).a(getWindowManager());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), a2);
        gridLayoutManager.S = new ap(this, a2);
        return gridLayoutManager;
    }

    /* access modifiers changed from: private */
    public void s(boolean z) {
        a(((t) this.pe).B(z));
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public void U(int i) {
        super.U(i);
        if (((t) this.pe).shouldShowFaqCategoriesAsGrid()) {
            this.pj.setLayoutManager(iB());
            this.pk.notifyDataSetChanged();
        }
    }

    @Override // com.freshchat.consumer.sdk.activity.b
    public void a(Context context, Intent intent) {
        Status jm;
        if ("com.freshchat.consumer.sdk.actions.FAQCategoriesFetched".equals(intent.getAction())) {
            jm = ((t) this.pe).g(intent.getExtras());
        } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            jm = ((t) this.pe).jm();
        } else {
            return;
        }
        a(jm);
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public void a(Status status) {
        if (status != null) {
            if (((t) this.pe).b(status)) {
                super.a(status);
            } else {
                this.pk.setStatus(status);
            }
        }
    }

    @Override // com.freshchat.consumer.sdk.activity.b
    public String[] a() {
        return new String[]{"com.freshchat.consumer.sdk.actions.TokenWaitTimeout", "com.freshchat.consumer.sdk.actions.FAQApiVersionChanged"};
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public String dA() {
        return ((t) this.pe).getTitle();
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public void dh() {
        t tVar = new t(getContext());
        this.pe = tVar;
        tVar.j(getIntent());
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public void hP() {
        this.pk.setStatus(Status.SUCCESS);
        i(this.pj);
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public String hV() {
        return ((t) this.pe).ju();
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public void ie() {
        s(false);
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    /* renamed from: if  reason: not valid java name */
    public View m1if() {
        return this.pj;
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public String[] ig() {
        return new String[]{"com.freshchat.consumer.sdk.actions.FAQCategoriesFetched"};
    }

    @Override // androidx.activity.ComponentActivity, com.freshchat.consumer.sdk.activity.ah, defpackage.y4, defpackage.ve, com.freshchat.consumer.sdk.activity.a
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.freshchat_activity_faq_categories);
        u();
        ((t) this.pe).js();
        s(false);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.freshchat_faq, menu);
        MenuItem findItem = menu.findItem(R.id.freshchat_menu_item_contact_us);
        boolean z = ((t) this.pe).shouldShowContactUsOnFaqScreens() && ((t) this.pe).shouldShowContactUsOnAppBar();
        if (findItem != null) {
            findItem.setVisible(z);
        }
        return true;
    }

    @Override // com.freshchat.consumer.sdk.activity.ah, com.freshchat.consumer.sdk.activity.a
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.freshchat_menu_item_contact_us) {
            return super.onOptionsItemSelected(menuItem);
        }
        ((t) this.pe).jg();
        return true;
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public void u() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.freshchat_activity_category_list_recycler_view);
        this.pj = recyclerView;
        recyclerView.setLayoutManager(iA());
        this.pj.g(new ao(this));
        q<FAQCategory> qVar = new q<>(getContext(), ((t) this.pe).jt(), ((t) this.pe).shouldShowFaqCategoriesAsGrid(), this.aj, this.po);
        this.pk = qVar;
        this.pj.setAdapter(qVar);
        super.u();
        if (((t) this.pe).shouldShowContactUsOnFaqScreens()) {
            a(((t) this.pe).shouldShowContactUsOnAppBar(), this.ac);
        }
    }
}
