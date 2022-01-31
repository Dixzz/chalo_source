package com.freshchat.consumer.sdk.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.s;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.f.e;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.k.w;
import com.freshchat.consumer.sdk.service.Status;

public class FAQSearchActivity extends ah<w> {
    private final View.OnClickListener ac = new bf(this);
    private final SearchView.OnQueryTextListener ad = new bd(this);
    private RecyclerView pT;
    private e po = new bb(this);
    private final MenuItem.OnActionExpandListener qK = new be(this);
    private s ql;
    private final s.b qm = new ba(this);
    private View qo;
    private TextView qp;
    private boolean rE = false;

    /* access modifiers changed from: private */
    public void bw(String str) {
        if (!((w) this.pe).bB(str)) {
            if (((w) this.pe).bA(str)) {
                ((w) this.pe).jJ();
                this.pT.setAdapter(this.ql);
                a(((w) this.pe).jH());
                i.c(this.qo);
                return;
            }
            A(false);
        }
    }

    /* access modifiers changed from: private */
    public void s(boolean z) {
        a(((w) this.pe).B(z));
    }

    public void A(boolean z) {
        String hV = z ? hV() : getString(R.string.freshchat_minimum_search_criteria);
        h(this.qo);
        this.qp.setText(hV);
    }

    public void V(int i) {
        Intent ac2;
        try {
            if (k.a(((w) this.pe).iV()) && (ac2 = ((w) this.pe).ac(i)) != null) {
                startActivity(ac2);
            }
        } catch (Exception e) {
            q.a(e);
        }
    }

    @Override // com.freshchat.consumer.sdk.activity.b
    public void a(Context context, Intent intent) {
        Status jm;
        if ("com.freshchat.consumer.sdk.actions.FAQSearchResultFetched".equals(intent.getAction())) {
            jm = ((w) this.pe).g(intent.getExtras());
        } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            jm = ((w) this.pe).jm();
        } else {
            return;
        }
        a(jm);
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public void a(Status status) {
        if (status != null) {
            if (((w) this.pe).b(status)) {
                super.a(status);
            } else {
                this.ql.setStatus(status);
            }
        }
    }

    @Override // com.freshchat.consumer.sdk.activity.b
    public String[] a() {
        return new String[]{"com.freshchat.consumer.sdk.actions.TokenWaitTimeout", "com.freshchat.consumer.sdk.actions.FAQApiVersionChanged"};
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public void bv(String str) {
        if (this.rE) {
            A(true);
            return;
        }
        i.c(this.qo);
        super.bv(str);
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public String dA() {
        return "";
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public void dh() {
        w wVar = new w(getContext());
        this.pe = wVar;
        wVar.j(getIntent());
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public void hP() {
        i.c(this.qo);
        this.ql.setStatus(Status.SUCCESS);
        i(this.pT);
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public String hV() {
        return getString(R.string.freshchat_no_articles_found);
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public void ie() {
        s(false);
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    /* renamed from: if  reason: not valid java name */
    public View m4if() {
        return this.pT;
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public String[] ig() {
        return new String[]{"com.freshchat.consumer.sdk.actions.FAQSearchResultFetched"};
    }

    @Override // androidx.activity.ComponentActivity, com.freshchat.consumer.sdk.activity.ah, defpackage.y4, defpackage.ve, com.freshchat.consumer.sdk.activity.a
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.freshchat_activity_faq_search);
        u();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.freshchat_articles_list, menu);
        MenuItem findItem = menu.findItem(R.id.freshchat_menu_item_contact_us);
        MenuItem findItem2 = menu.findItem(R.id.freshchat_menu_item_search_solutions);
        SearchView searchView = (SearchView) findItem2.getActionView();
        searchView.setOnQueryTextListener(this.ad);
        searchView.setQueryHint(getString(R.string.freshchat_faq_search_query_hint));
        searchView.setOnQueryTextFocusChangeListener(new bc(this));
        findItem2.setOnActionExpandListener(this.qK);
        findItem2.expandActionView();
        i.a(searchView, getSupportActionBar());
        boolean z = ((w) this.pe).shouldShowContactUsOnFaqScreens() && ((w) this.pe).shouldShowContactUsOnAppBar();
        if (findItem != null) {
            findItem.setVisible(z);
        }
        return true;
    }

    @Override // com.freshchat.consumer.sdk.activity.ah, com.freshchat.consumer.sdk.activity.a
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.freshchat_categories_menu_item_contact_us) {
            return super.onOptionsItemSelected(menuItem);
        }
        ((w) this.pe).jg();
        return true;
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public void u() {
        super.u();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.search_faq_recycler_view);
        this.pT = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        s sVar = new s(((w) this.pe).iV(), this.qm, this.po);
        this.ql = sVar;
        this.pT.setAdapter(sVar);
        this.pT.g(new az(this));
        this.qo = findViewById(R.id.search_description_view);
        this.qp = (TextView) findViewById(R.id.search_description);
        if (((w) this.pe).shouldShowContactUsOnFaqScreens()) {
            a(((w) this.pe).shouldShowContactUsOnAppBar(), this.ac);
        }
        A(false);
    }
}
