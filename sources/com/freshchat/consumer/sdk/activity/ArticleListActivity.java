package com.freshchat.consumer.sdk.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.widget.SearchView;
import androidx.core.widget.ContentLoadingProgressBar;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.a;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.Article;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.u;
import com.freshchat.consumer.sdk.j.v;
import com.freshchat.consumer.sdk.service.d.b;
import com.freshchat.consumer.sdk.service.e.f;
import defpackage.ii;
import java.util.ArrayList;
import java.util.List;

public class ArticleListActivity extends b {
    private String A = "article_list";
    private boolean J = false;
    private String K = "";
    private a L;
    private String M = "";
    private ContentLoadingProgressBar N;
    private SearchView O;
    private ListView P;
    private View Q;
    private Menu R;
    private View S;
    private boolean T = false;
    private boolean U = false;
    private boolean V;
    private List<Article> W = new ArrayList();
    private List<Article> X = new ArrayList();
    private ArrayList<String> Y;
    public ii.a<List<Article>> Z = new ac(this);
    public g8 aa = new ad(this);
    public AdapterView.OnItemClickListener ab = new ae(this);
    public View.OnClickListener ac = new af(this);
    public SearchView.OnQueryTextListener ad = new ag(this);
    private String categoryId = "";
    private String categoryName = "";
    private List<String> eM;
    public FaqOptions g = new FaqOptions();
    private Bundle h = null;
    private String[] lE;

    private void A() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.N;
        if (contentLoadingProgressBar != null) {
            contentLoadingProgressBar.post(new n9(contentLoadingProgressBar));
        }
    }

    private void a(Intent intent) {
        if (intent != null) {
            this.g = u.d(intent.getExtras());
            if (intent.hasExtra("force_search_open")) {
                this.V = true;
            }
            if (intent.hasExtra("category_name")) {
                this.categoryName = intent.getStringExtra("category_name");
            }
            if (intent.hasExtra("category_ids")) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("category_ids");
                this.Y = stringArrayListExtra;
                if (k.b(stringArrayListExtra) == 1) {
                    this.categoryId = this.Y.get(0);
                }
            }
            this.M = (this.g.getFilterType() != FaqOptions.FilterType.ARTICLE || !as.a(this.g.getFilteredViewTitle())) ? as.a(this.categoryName) ? this.categoryName : getString(R.string.freshchat_activity_title_article_list) : this.g.getFilteredViewTitle();
            if (k.a(this.g.getTags())) {
                this.T = true;
            }
        }
    }

    /* access modifiers changed from: private */
    public void aJ() {
        MenuItem findItem;
        Menu menu = this.R;
        if (menu != null && (findItem = menu.findItem(R.id.freshchat_menu_item_contact_us)) != null) {
            findItem.setVisible(!this.J && this.g.shouldShowContactUsOnFaqScreens() && this.g.shouldShowContactUsOnAppBar());
        }
    }

    /* access modifiers changed from: private */
    public void bL() {
        getListView().setAdapter((ListAdapter) this.L);
        getListView().setOnItemClickListener(this.ab);
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        if (this.J) {
            Bundle bundle = new Bundle();
            bundle.putString("search_key", str);
            getSupportLoaderManager().d(111, bundle, this.Z);
        }
    }

    private View getEmptyView() {
        if (this.Q == null) {
            this.Q = findViewById(R.id.empty);
        }
        return this.Q;
    }

    private ListView getListView() {
        if (this.P == null) {
            this.P = (ListView) findViewById(R.id.list);
        }
        return this.P;
    }

    /* access modifiers changed from: private */
    public v r() {
        return aa.a(getContext(), this.g);
    }

    private void u() {
        this.N = (ContentLoadingProgressBar) findViewById(R.id.freshchat_article_list_cl_progressbar);
        y();
    }

    private void v() {
        new b(getApplicationContext(), b.a.faq_open_category).g("category_id", this.categoryId).g("category_name", this.categoryName).dB();
    }

    /* access modifiers changed from: private */
    public void w() {
        ArrayList<String> arrayList;
        String str;
        Bundle bundle = new Bundle();
        if (k.a(this.Y)) {
            arrayList = this.Y;
            str = "category_ids";
        } else {
            if (k.a(this.g.getTags()) && this.g.getFilterType() == FaqOptions.FilterType.ARTICLE) {
                arrayList = new ArrayList<>(this.g.getTags());
                str = "FAQ_TAGS";
            }
            getSupportLoaderManager().d(111, bundle, this.Z);
        }
        bundle.putStringArrayList(str, arrayList);
        getSupportLoaderManager().d(111, bundle, this.Z);
    }

    /* access modifiers changed from: private */
    public synchronized void x() {
        A();
        if (k.isEmpty(this.W)) {
            i.c(getListView());
            i.b(getEmptyView());
        } else {
            i.b(getListView());
            i.c(getEmptyView());
        }
    }

    /* access modifiers changed from: private */
    public void y() {
        View findViewById = findViewById(R.id.freshchat_contact_us_group);
        this.S = findViewById;
        if (findViewById == null) {
            return;
        }
        if (this.J && this.g.shouldShowContactUsOnFaqNotHelpful()) {
            this.S.setVisibility(0);
            this.S.setOnClickListener(this.ac);
        } else if (!this.g.shouldShowContactUsOnFaqScreens() || this.g.shouldShowContactUsOnAppBar()) {
            this.S.setVisibility(8);
        } else {
            this.S.setVisibility(0);
            this.S.setOnClickListener(this.ac);
        }
    }

    /* access modifiers changed from: private */
    public void z() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.N;
        if (contentLoadingProgressBar != null) {
            contentLoadingProgressBar.post(new p9(contentLoadingProgressBar));
        }
    }

    public void a(long j) {
        if (as.a(this.K)) {
            bg.a(getContext(), this.K, k.b(this.W), true);
        }
        Intent intent = new Intent(this, ArticleDetailActivity.class);
        Bundle bundle = this.h;
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("article_id", j);
        intent.putExtra("category_name", this.categoryName);
        intent.putExtra("EVENT_LAUNCH_SOURCE", this.A);
        intent.putExtra("INPUT_TAGS", this.lE);
        startActivity(intent);
    }

    @Override // com.freshchat.consumer.sdk.activity.b
    public void a(Context context, Intent intent) {
        if ("com.freshchat.consumer.sdk.actions.SolutionsUpdated".equalsIgnoreCase(intent.getAction())) {
            w();
        }
    }

    @Override // com.freshchat.consumer.sdk.activity.b
    public String[] a() {
        return new String[]{"com.freshchat.consumer.sdk.actions.SolutionsUpdated", "com.freshchat.consumer.sdk.actions.TokenWaitTimeout", "com.freshchat.consumer.sdk.actions.FAQApiVersionChanged"};
    }

    @Override // androidx.activity.ComponentActivity, com.freshchat.consumer.sdk.activity.b, com.freshchat.consumer.sdk.activity.a
    public void onBackPressed() {
        Menu menu;
        if (this.V) {
            finish();
        } else if (!this.J || (menu = this.R) == null) {
            super.onBackPressed();
        } else {
            MenuItem findItem = menu.findItem(R.id.freshchat_menu_item_search_solutions);
            if (findItem != null) {
                findItem.collapseActionView();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4, defpackage.ve, com.freshchat.consumer.sdk.activity.a
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.freshchat_activity_article_list);
        Intent intent = getIntent();
        a(intent);
        this.h = intent.getExtras();
        this.lE = intent.getStringArrayExtra("INPUT_TAGS");
        e(this.M);
        C();
        u();
        this.L = new a(this, this.W);
        bL();
        w();
        if (as.a(this.categoryId)) {
            v();
        }
        if (!this.V) {
            bg.a(getContext(), this.categoryId, this.categoryName, this.lE);
        }
        com.freshchat.consumer.sdk.j.b.a(getApplicationContext(), f.a.NORMAL);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.freshchat_articles_list, menu);
        this.R = menu;
        MenuItem findItem = menu.findItem(R.id.freshchat_menu_item_search_solutions);
        SearchView searchView = (SearchView) findItem.getActionView();
        this.O = searchView;
        searchView.setOnQueryTextListener(this.ad);
        this.O.setQueryHint(getString(R.string.freshchat_faq_search_query_hint));
        findItem.setOnActionExpandListener(new f8(this.aa));
        i.a(this.O, getSupportActionBar());
        if (this.V) {
            findItem.expandActionView();
        }
        aJ();
        return true;
    }

    @Override // defpackage.f0, defpackage.ve
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.freshchat.consumer.sdk.activity.a
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.freshchat_menu_item_contact_us) {
            return super.onOptionsItemSelected(menuItem);
        }
        r().aE();
        return true;
    }

    @Override // defpackage.f0, defpackage.ve
    public void supportInvalidateOptionsMenu() {
        this.U = true;
        super.invalidateOptionsMenu();
    }
}
