package com.freshchat.consumer.sdk.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.b;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.Category;
import com.freshchat.consumer.sdk.g.f;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.af;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.be;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.p;
import com.freshchat.consumer.sdk.j.u;
import com.freshchat.consumer.sdk.j.v;
import com.freshchat.consumer.sdk.service.d.b;
import com.freshchat.consumer.sdk.service.e.f;
import com.rabbitmq.client.AMQP;
import defpackage.ii;
import java.util.ArrayList;
import java.util.List;

public class CategoryListActivity extends b {
    private String M;
    private View Q;
    private View S;
    public View.OnClickListener ac = new View.OnClickListener() {
        /* class com.freshchat.consumer.sdk.activity.CategoryListActivity.AnonymousClass2 */

        public void onClick(View view) {
            CategoryListActivity.this.r().aE();
            new b(CategoryListActivity.this.getApplicationContext(), b.a.channels_launch).g("source", "contact_us").dB();
        }
    };
    private RecyclerView af;
    private com.freshchat.consumer.sdk.a.b<Category> ag;
    private List<Category> ah = new ArrayList();
    private boolean ai;
    public b.a aj = new b.a() {
        /* class com.freshchat.consumer.sdk.activity.CategoryListActivity.AnonymousClass1 */

        @Override // com.freshchat.consumer.sdk.a.b.a
        public void a(View view, int i) {
            Category category = (Category) CategoryListActivity.this.ah.get(i);
            CategoryListActivity.this.r().a(category.getId(), category.getTitle(), CategoryListActivity.this.lE);
        }
    };
    public ii.a<List<Category>> ak = new ii.a<List<Category>>() {
        /* class com.freshchat.consumer.sdk.activity.CategoryListActivity.AnonymousClass3 */

        /* renamed from: a */
        public void onLoadFinished(li<List<Category>> liVar, List<Category> list) {
            if (!CategoryListActivity.this.ai || k.b(list) != 0) {
                CategoryListActivity.this.ah.clear();
                CategoryListActivity.this.ah.addAll(list);
                CategoryListActivity.this.x();
                CategoryListActivity.this.B().setAdapter(CategoryListActivity.this.ag);
                return;
            }
            CategoryListActivity.this.finish();
            i.a(CategoryListActivity.this.getContext(), R.string.freshchat_faqs_reload_and_redirect);
            Freshchat.showFAQs(CategoryListActivity.this.getContext(), CategoryListActivity.this.g);
        }

        @Override // defpackage.ii.a
        public li<List<Category>> onCreateLoader(int i, Bundle bundle) {
            return (bundle == null || !k.a(bundle.getStringArrayList("TAGS"))) ? new f(CategoryListActivity.this.getApplicationContext()) : new f(CategoryListActivity.this.getApplicationContext(), bundle.getStringArrayList("TAGS"));
        }

        @Override // defpackage.ii.a
        public void onLoaderReset(li<List<Category>> liVar) {
            CategoryListActivity.this.ah.clear();
            CategoryListActivity.this.ag.notifyDataSetChanged();
        }
    };
    private ProgressBar am;
    private FaqOptions g = new FaqOptions();
    private String[] lE;
    private RecyclerView.m mLayoutManager;

    private void A() {
        i.c(this.am);
    }

    private void E() {
        Bundle bundle = new Bundle();
        if (this.ai) {
            bundle.putStringArrayList("TAGS", new ArrayList<>(this.g.getTags()));
        }
        getSupportLoaderManager().d(0, bundle, this.ak);
    }

    private void a(Intent intent) {
        if (intent != null) {
            FaqOptions d = u.d(intent.getExtras());
            this.g = d;
            this.M = as.a(d.getFilteredViewTitle()) ? this.g.getFilteredViewTitle() : getString(R.string.freshchat_activity_title_category_list);
            if (k.a(this.g.getTags())) {
                this.ai = true;
            }
            this.lE = intent.getStringArrayExtra("INPUT_TAGS");
        }
    }

    /* access modifiers changed from: private */
    public ArrayList<String> e(List<Category> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (k.isEmpty(list)) {
            return arrayList;
        }
        for (Category category : list) {
            arrayList.add(category.getId());
        }
        return arrayList;
    }

    private synchronized void eA() {
        A();
        i.c(B());
        i.b(getEmptyView());
    }

    private void ez() {
        z();
        i.c(B());
        i.c(getEmptyView());
        boolean aS = al.aS(getContext());
        boolean isEmpty = as.isEmpty(e.i(getApplicationContext()).br());
        if (!aS && isEmpty) {
            eA();
            i.a(getContext(), R.string.freshchat_error_message_not_connected_to_internet);
        }
        if (!isEmpty) {
            E();
        }
    }

    private void gD() {
        be.eC().gx().execute(new j(this));
    }

    private int getColumnCount() {
        return Math.round((float) (af.i(this, p.ar(this)) / (p.a(getApplicationContext(), getWindowManager()) ? AMQP.REPLY_SUCCESS : 150)));
    }

    private View getEmptyView() {
        if (this.Q == null) {
            this.Q = findViewById(R.id.empty);
        }
        return this.Q;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private v r() {
        return aa.a(getContext(), this.g);
    }

    private void u() {
        View findViewById;
        if (this.g.shouldShowContactUsOnFaqScreens()) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.freshchat_contact_us_stub);
            viewStub.setInflatedId(R.id.freshchat_contact_us_group);
            viewStub.setLayoutResource(R.layout.freshchat_partial_start_conversation_frame);
            this.am = (ProgressBar) findViewById(R.id.freshchat_activity_category_list_progressbar);
            if (!this.g.shouldShowContactUsOnAppBar()) {
                View inflate = viewStub.inflate();
                this.S = inflate;
                if (!(inflate == null || (findViewById = inflate.findViewById(R.id.freshchat_contact_us_btn)) == null)) {
                    findViewById.setOnClickListener(this.ac);
                }
            }
        }
        this.mLayoutManager = this.g.shouldShowFaqCategoriesAsGrid() ? new GridLayoutManager(this, getColumnCount()) : new LinearLayoutManager(1, false);
        B().setLayoutManager(this.mLayoutManager);
        this.ag = new com.freshchat.consumer.sdk.a.b<>(this, this.ah, this.g.shouldShowFaqCategoriesAsGrid(), this.aj);
        B().setAdapter(this.ag);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void x() {
        if (k.isEmpty(this.ah)) {
            eA();
        } else {
            A();
            i.b(B());
            i.c(getEmptyView());
        }
    }

    private void z() {
        i.b(this.am);
    }

    public RecyclerView B() {
        if (this.af == null) {
            this.af = (RecyclerView) findViewById(R.id.freshchat_activity_category_list_recycler_view);
        }
        return this.af;
    }

    @Override // com.freshchat.consumer.sdk.activity.b
    public void a(Context context, Intent intent) {
        if ("com.freshchat.consumer.sdk.actions.SolutionsUpdated".equals(intent.getAction())) {
            E();
        }
    }

    @Override // com.freshchat.consumer.sdk.activity.b
    public String[] a() {
        return new String[]{"com.freshchat.consumer.sdk.actions.SolutionsUpdated", "com.freshchat.consumer.sdk.actions.TokenWaitTimeout", "com.freshchat.consumer.sdk.actions.FAQApiVersionChanged"};
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4, defpackage.ve, com.freshchat.consumer.sdk.activity.a
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.freshchat_activity_category_list);
        a(getIntent());
        e(this.M);
        C();
        u();
        ez();
        if (al.aS(getContext())) {
            com.freshchat.consumer.sdk.j.b.a(getApplicationContext(), f.a.NORMAL);
        }
        new com.freshchat.consumer.sdk.service.d.b(getApplicationContext(), b.a.faqs_launch).dB();
        bg.c(getContext(), this.lE);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.freshchat_categories_list, menu);
        menu.findItem(R.id.freshchat_categories_menu_item_contact_us).setVisible(this.g.shouldShowContactUsOnFaqScreens() && this.g.shouldShowContactUsOnAppBar());
        return true;
    }

    @Override // com.freshchat.consumer.sdk.activity.a
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.freshchat_categories_menu_item_search_solutions) {
            if (this.ai) {
                gD();
            } else {
                r().e(this.lE);
            }
            new com.freshchat.consumer.sdk.service.d.b(getApplicationContext(), b.a.faq_search_launch).g("source", "category_list").dB();
            return true;
        } else if (menuItem.getItemId() != R.id.freshchat_categories_menu_item_contact_us) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            r().aE();
            return true;
        }
    }
}
