package com.freshchat.consumer.sdk.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.s;
import com.freshchat.consumer.sdk.beans.FAQ;
import com.freshchat.consumer.sdk.f.e;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.k.v;
import com.freshchat.consumer.sdk.service.Status;

public class FAQListActivity extends ah<v> {
    private final View.OnClickListener ac = new aw(this);
    private RecyclerView pT;
    private e po = new ay(this);
    private s ql;
    private final s.b qm = new ax(this);

    /* access modifiers changed from: private */
    public void s(boolean z) {
        a(((v) this.pe).B(z));
    }

    public void V(int i) {
        try {
            if (k.a(((v) this.pe).iV())) {
                FAQ faq = ((v) this.pe).iV().get(i);
                startActivity(((v) this.pe).y(faq.getId(), faq.getTitle()));
            }
        } catch (Exception e) {
            q.a(e);
        }
    }

    @Override // com.freshchat.consumer.sdk.activity.b
    public void a(Context context, Intent intent) {
        Status jm;
        if ("com.freshchat.consumer.sdk.actions.FAQListFetched".equals(intent.getAction())) {
            jm = ((v) this.pe).g(intent.getExtras());
        } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            jm = ((v) this.pe).jm();
        } else {
            return;
        }
        a(jm);
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public void a(Status status) {
        if (status != null) {
            if (((v) this.pe).b(status)) {
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
    public String dA() {
        return ((v) this.pe).jE();
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public void dh() {
        v vVar = new v(getContext());
        this.pe = vVar;
        vVar.j(getIntent());
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public void hP() {
        this.ql.setStatus(Status.SUCCESS);
        i(this.pT);
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public String hV() {
        return ((v) this.pe).jF();
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public void ie() {
        s(false);
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    /* renamed from: if  reason: not valid java name */
    public View m3if() {
        return this.pT;
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public String[] ig() {
        return new String[]{"com.freshchat.consumer.sdk.actions.FAQListFetched"};
    }

    @Override // androidx.activity.ComponentActivity, com.freshchat.consumer.sdk.activity.ah, defpackage.y4, defpackage.ve, com.freshchat.consumer.sdk.activity.a
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.freshchat_activity_faq_list);
        u();
        ((v) this.pe).jG();
        s(false);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.freshchat_faq, menu);
        MenuItem findItem = menu.findItem(R.id.freshchat_menu_item_contact_us);
        boolean z = ((v) this.pe).shouldShowContactUsOnFaqScreens() && ((v) this.pe).shouldShowContactUsOnAppBar();
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
        ((v) this.pe).jg();
        return true;
    }

    @Override // com.freshchat.consumer.sdk.activity.ah
    public void u() {
        super.u();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        this.pT = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.pT.g(new av(this));
        s sVar = new s(((v) this.pe).iV(), this.qm, this.po);
        this.ql = sVar;
        this.pT.setAdapter(sVar);
        if (((v) this.pe).shouldShowContactUsOnFaqScreens()) {
            a(((v) this.pe).shouldShowContactUsOnAppBar(), this.ac);
        }
    }
}
