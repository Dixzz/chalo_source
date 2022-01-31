package com.freshchat.consumer.sdk.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.FreshchatWebViewListener;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.activity.c;
import com.freshchat.consumer.sdk.b.j;
import com.freshchat.consumer.sdk.beans.Article;
import com.freshchat.consumer.sdk.beans.Category;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ah;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.aw;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.u;
import com.freshchat.consumer.sdk.j.v;
import com.freshchat.consumer.sdk.service.d.b;
import com.freshchat.consumer.sdk.service.e.f;
import com.freshchat.consumer.sdk.service.e.n;
import defpackage.ii;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.regex.Pattern;

public class ArticleDetailActivity extends b implements ii.a<Article>, c.b {
    private static String l = "isArticleVoted";
    private static String s = "HL_ARTICLE_TITLE";
    private static final String t;
    private static final String u;
    private static String z;
    private String A = "article_list";
    private boolean B = false;
    public WebViewClient C = new v(this);
    public View.OnClickListener D = new x(this);
    public View.OnClickListener E = new aa(this);
    private String categoryId;
    private String categoryName;
    public FaqOptions g = new FaqOptions();
    private Bundle h = null;
    private View i;
    private View j;
    private c k;
    private String[] lE;
    private RelativeLayout m;
    private View n;
    private View o;
    private View p;
    private View q;
    private j r;
    private String title;
    private String v;
    private boolean w;
    private boolean x = false;
    private boolean y;

    static {
        String a0 = hj1.a0(hj1.i0("<head><link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_res/raw/normalize.css\"/><script src='file:///freshchat_assets/freshchat_hacks.js'></script><title>"), s, "</title></head>");
        t = a0;
        u = hj1.T("<!DOCTYPE html>\t<html>", a0, "<body onload='correctIframe()'> <bdi>");
    }

    private String a(Article article) {
        String str;
        if (article == null) {
            return null;
        }
        this.categoryId = article.getCategoryId();
        StringBuilder sb = new StringBuilder();
        String replaceAll = article.getDescription().replaceAll("src=\"//", "src=\"http://").replaceAll("value=\"//", "value=\"http://");
        Pattern compile = Pattern.compile("<\\s*(img|iframe).*?src\\s*=[ '\"]+http[s]?:\\/\\/.*?>");
        if (al.aS(this) || !compile.matcher(replaceAll).find()) {
            str = "";
        } else {
            StringBuilder i0 = hj1.i0("<div class='offline-article-message'>");
            i0.append(getString(R.string.freshchat_faq_rich_media_content_cannot_be_displayed));
            i0.append("</div>");
            str = i0.toString();
        }
        this.title = article.getTitle();
        sb.append(u);
        sb.append("<div class=\"article-title\";><h3 >");
        hj1.V0(sb, this.title, "</h3></div>", str, "<div class=\"article-body\">");
        String b0 = hj1.b0(sb, replaceAll, "</div>", "</bdi></body></html>");
        return !as.isEmpty(this.categoryName) ? b0.replace(s, this.categoryName) : b0;
    }

    private void a(Intent intent) {
        if (!intent.hasExtra("article_id")) {
            Toast.makeText(this, R.string.freshchat_faq_failed_to_load, 0).show();
            finish();
        }
        long longExtra = intent.getLongExtra("article_id", -1);
        if (longExtra > 0) {
            this.v = Long.toString(longExtra);
        } else {
            Toast.makeText(this, R.string.freshchat_faq_failed_to_load, 0).show();
            finish();
        }
        if (intent.hasExtra("category_id")) {
            this.categoryId = intent.getStringExtra("category_id");
        }
        if (intent.hasExtra("category_name")) {
            this.categoryName = intent.getStringExtra("category_name");
        }
        if (intent.hasExtra("EVENT_LAUNCH_SOURCE")) {
            this.A = intent.getStringExtra("EVENT_LAUNCH_SOURCE");
        }
        if (intent.hasExtra("LAUNCHED_FROM_CONVERSATION")) {
            this.y = intent.getBooleanExtra("LAUNCHED_FROM_CONVERSATION", false);
        }
        this.lE = intent.getStringArrayExtra("INPUT_TAGS");
    }

    private void a(Bundle bundle) {
        this.w = bundle != null ? bundle.getBoolean(l) : false;
    }

    /* access modifiers changed from: private */
    public void a(n.a aVar) {
        n.a aVar2 = n.a.Upvote;
        bg.a(getContext(), this.categoryId, this.categoryName, this.v, this.title, aVar == aVar2);
        new b(getApplicationContext(), aVar == aVar2 ? b.a.faq_upvote_article : b.a.faq_downvote_article).g("article_id", this.v).g("category_id", this.categoryId).g("article_name", this.title).dB();
    }

    private void b() {
        bg.a(getContext(), this.categoryId, this.categoryName, this.v, this.title, this.lE);
        if (!this.B) {
            new b(getApplicationContext(), b.a.faq_open_article).g("category_id", this.categoryId).g("category_name", this.categoryName).g("article_id", this.v).g("article_name", this.title).g("source", this.A).dB();
            this.B = true;
        }
    }

    private void c() {
        this.p = findViewById(R.id.freshchat_upvote);
        this.q = findViewById(R.id.freshchat_downvote);
        this.n = findViewById(R.id.freshchat_voting_view);
        this.o = findViewById(R.id.freshchat_contact_us_group);
        this.m = (RelativeLayout) findViewById(R.id.freshchat_solution_article_root_layout);
        ((TextView) findViewById(R.id.freshchat_contact_us_btn)).setText(R.string.freshchat_faq_not_helpful_contact_us);
    }

    private void d() {
        Bundle bundle = new Bundle();
        bundle.putString("article_id", this.v);
        if (as.isEmpty(this.categoryName)) {
            bundle.putBoolean("EXTRA_FETCH_CATEGORY_INFO", true);
        }
        getSupportLoaderManager().c(0, bundle, this);
    }

    private void e() {
        this.p.setOnClickListener(this.D);
        this.q.setOnClickListener(this.D);
        this.o.setOnClickListener(this.E);
    }

    private void f() {
        int i2;
        View view;
        if (!this.g.shouldShowContactUsOnFaqNotHelpful() || !this.w || !g().bj(this.v)) {
            view = this.o;
            i2 = 8;
        } else {
            this.o.bringToFront();
            view = this.o;
            i2 = 0;
        }
        view.setVisibility(i2);
    }

    /* access modifiers changed from: private */
    public void l() {
        new b(getApplicationContext(), b.a.channels_launch).g("source", "article_not_helpful").g("article_id", this.v).g("category_id", this.categoryId).dB();
    }

    private void m() {
        if (!this.w) {
            String str = z;
            if (str == null || !str.equals(this.v)) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.freshchat_slide_up);
                this.n.bringToFront();
                this.n.startAnimation(loadAnimation);
                this.n.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        if (!this.w) {
            this.n.startAnimation(AnimationUtils.loadAnimation(this, R.anim.freshchat_slide_down));
            this.n.setVisibility(8);
        }
    }

    private void o() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
    }

    private void q() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().B();
        }
    }

    /* access modifiers changed from: private */
    public v r() {
        return aa.a(getContext(), this.g);
    }

    private void s() {
        this.k.postDelayed(new ab(this), 500);
    }

    @Override // com.freshchat.consumer.sdk.activity.b
    public void a(Context context, Intent intent) {
    }

    /* renamed from: a */
    public void onLoadFinished(li<Article> liVar, Article article) {
        Category dk;
        String a2 = a(article);
        if (as.a(a2)) {
            if ((liVar instanceof com.freshchat.consumer.sdk.g.j) && (dk = ((com.freshchat.consumer.sdk.g.j) liVar).dk()) != null) {
                String title2 = dk.getTitle();
                this.categoryName = title2;
                a2 = a2.replace(s, title2);
            }
            this.k.loadDataWithBaseURL(null, a2, "text/html", "utf-8", null);
        }
        b();
    }

    @Override // com.freshchat.consumer.sdk.activity.b
    public String[] a() {
        return new String[]{"com.freshchat.consumer.sdk.actions.TokenWaitTimeout", "com.freshchat.consumer.sdk.actions.FAQApiVersionChanged"};
    }

    public j g() {
        if (this.r == null) {
            this.r = new j(this);
        }
        return this.r;
    }

    @Override // com.freshchat.consumer.sdk.activity.c.b
    public void h() {
        m();
    }

    @Override // com.freshchat.consumer.sdk.activity.c.b
    public void i() {
        n();
    }

    @Override // com.freshchat.consumer.sdk.activity.c.b
    public void j() {
        o();
        this.x = true;
        this.n.setVisibility(8);
    }

    @Override // com.freshchat.consumer.sdk.activity.c.b
    public void k() {
        q();
        s();
        this.x = false;
    }

    @Override // defpackage.f0, defpackage.ve
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.x) {
            s();
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4, defpackage.ve, com.freshchat.consumer.sdk.activity.a
    public void onCreate(Bundle bundle) {
        FreshchatWebViewListener webviewListener;
        super.onCreate(bundle);
        Locale bb = ah.bb(this);
        a(bundle);
        Intent intent = getIntent();
        a(intent);
        Bundle extras = intent.getExtras();
        this.h = extras;
        this.g = u.d(extras);
        d();
        setContentView(R.layout.freshchat_activity_article_detail);
        C();
        e(!as.isEmpty(this.g.getFilteredViewTitle()) ? this.g.getFilteredViewTitle() : as.isEmpty(this.categoryName) ? getString(R.string.freshchat_activity_title_article_detail) : this.categoryName);
        c();
        com.freshchat.consumer.sdk.j.b.a(getApplicationContext(), f.a.NORMAL);
        e();
        this.w = g().P(this.v);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(10, -1);
        this.j = LayoutInflater.from(this).inflate(R.layout.freshchat_partial_article_progress, (ViewGroup) null);
        c cVar = new c(this);
        this.k = cVar;
        cVar.setWebViewClient(this.C);
        this.k.a(this, 85);
        this.m.addView(this.k.getLayout(), layoutParams2);
        this.m.addView(this.j, layoutParams);
        if (bundle != null) {
            this.k.restoreState(bundle);
        }
        this.i = this.k;
        Locale bb2 = ah.bb(this);
        if (bb != null && bb2 != null && as.p(bb.getLanguage(), bb2.getLanguage()) && (webviewListener = Freshchat.getInstance(this).getWebviewListener()) != null) {
            webviewListener.onLocaleChangedByWebView(new WeakReference<>(this));
        }
    }

    @Override // defpackage.ii.a
    public li<Article> onCreateLoader(int i2, Bundle bundle) {
        return new com.freshchat.consumer.sdk.g.j(getApplicationContext(), bundle.getString("article_id"), bundle.containsKey("EXTRA_FETCH_CATEGORY_INFO"));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.freshchat_article_detail_list, menu);
        return true;
    }

    @Override // defpackage.f0, defpackage.ve
    public void onDestroy() {
        super.onDestroy();
        c cVar = this.k;
        if (cVar != null) {
            cVar.destroy();
        }
    }

    @Override // defpackage.f0
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || !this.k.az()) {
            return super.onKeyDown(i2, keyEvent);
        }
        this.k.aA();
        return true;
    }

    @Override // defpackage.ii.a
    public void onLoaderReset(li<Article> liVar) {
    }

    @Override // com.freshchat.consumer.sdk.activity.a
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // defpackage.ve, com.freshchat.consumer.sdk.activity.b
    @TargetApi(11)
    public void onPause() {
        super.onPause();
        if (aw.fb() && aw.eS()) {
            this.k.onPause();
        } else if (aw.eM()) {
            this.k.aB();
        }
    }

    @Override // defpackage.ve, com.freshchat.consumer.sdk.activity.b, com.freshchat.consumer.sdk.activity.a
    @TargetApi(11)
    public void onResume() {
        super.onResume();
        this.w = g().P(this.v);
        f();
        if (aw.fb() && aw.eS()) {
            this.k.onResume();
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4, com.freshchat.consumer.sdk.activity.a
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(l, this.w);
        super.onSaveInstanceState(bundle);
    }

    @Override // defpackage.f0, defpackage.ve
    public void onStart() {
        super.onStart();
        if (aw.fc()) {
            this.k.onResume();
        }
    }

    @Override // defpackage.f0, defpackage.ve
    public void onStop() {
        super.onStop();
        if (aw.fc()) {
            this.k.onPause();
        }
        this.k.stopLoading();
    }
}
