package com.freshchat.consumer.sdk.k;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.b.m;
import com.freshchat.consumer.sdk.beans.FAQ;
import com.freshchat.consumer.sdk.beans.reqres.FAQFetchResponse;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.b;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.Status;
import com.freshchat.consumer.sdk.service.e.am;
import com.freshchat.consumer.sdk.service.e.an;
import java.util.regex.Pattern;

public class u extends n {
    private String categoryId;
    private String categoryName;
    private FAQ faq;
    private String faqId;
    private final String rA;
    private Status rr;
    private final m rz;
    private String s = "HL_ARTICLE_TITLE";
    private final String t;
    private String title;
    private final String u;
    private boolean y;
    private String z;

    public u(Context context) {
        super(context);
        String a0 = hj1.a0(hj1.i0("<head><link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_res/raw/normalize.css\"/><script src='file:///freshchat_assets/freshchat_hacks.js'></script><title>"), this.s, "</title></head>");
        this.t = a0;
        this.u = hj1.T("<!DOCTYPE html>\t<html>", a0, "<body onload='correctIframe()'> <bdi>");
        this.rA = "</bdi></body></html>";
        this.rz = new m(getContext());
    }

    private void d(Status status) {
        this.rr = status;
    }

    private boolean jA() {
        FAQ faq2 = this.faq;
        if (faq2 == null) {
            return false;
        }
        return this.rz.c(this.categoryId, this.faqId, faq2.getLastUpdatedAt());
    }

    private boolean jz() {
        FAQ faq2 = this.faq;
        if (faq2 == null) {
            return false;
        }
        return this.rz.d(this.categoryId, this.faqId, faq2.getLastUpdatedAt());
    }

    public void a(am.a aVar) {
        b.a(getContext(), this.categoryId, this.faqId, aVar, this.faq.getLanguage(), this.faq.getLastUpdatedAt());
        this.z = this.faqId;
        b(aVar);
    }

    public void b(am.a aVar) {
        bg.a(getContext(), this.categoryId, this.categoryName, this.faqId, this.title, aVar == am.a.THUMBS_UP);
    }

    public Status g(Bundle bundle) {
        if (bundle != null) {
            try {
                FAQFetchResponse fAQFetchResponse = (FAQFetchResponse) bundle.getParcelable("RESPONSE");
                if (fAQFetchResponse != null) {
                    this.faq = fAQFetchResponse.getFaq();
                    d(fAQFetchResponse.getStatus());
                    return this.rr;
                }
                throw new IllegalArgumentException("faqFetchResponse cannot be null in FAQDetailViewModel::processResponse()");
            } catch (Exception e) {
                d(Status.ERROR);
                q.a(e);
            }
        } else {
            throw new IllegalArgumentException("bundle cannot be null in FAQDetailViewModel::processResponse()");
        }
    }

    public boolean h(Bundle bundle) {
        return bundle != null && bundle.containsKey("article_id") && !as.isEmpty(bundle.getString("article_id")) && bundle.containsKey("category_id") && !as.isEmpty(bundle.getString("category_id"));
    }

    public String hV() {
        return getContext().getString(R.string.freshchat_no_articles_found);
    }

    public boolean i(Bundle bundle) {
        an anVar;
        if (bundle == null || (anVar = (an) bundle.getParcelable("RESPONSE")) == null) {
            return false;
        }
        return Status.SUCCESS.equals(anVar.getStatus());
    }

    @Override // com.freshchat.consumer.sdk.k.n
    public void j(Intent intent) {
        super.j(intent);
        if (intent.hasExtra("article_id")) {
            this.faqId = intent.getStringExtra("article_id");
        }
        if (intent.hasExtra("category_id")) {
            this.categoryId = intent.getStringExtra("category_id");
        }
        if (intent.hasExtra("EXTRA_FAQ_VIEW_TITLE")) {
            this.title = intent.getStringExtra("EXTRA_FAQ_VIEW_TITLE");
        }
        if (intent.hasExtra("category_name")) {
            this.categoryName = intent.getStringExtra("category_name");
        }
        if (intent.hasExtra("LAUNCHED_FROM_CONVERSATION")) {
            this.y = intent.getBooleanExtra("LAUNCHED_FROM_CONVERSATION", false);
        }
    }

    public boolean jB() {
        String str = this.z;
        if (str == null || !str.equals(this.faqId)) {
            return !jz();
        }
        return false;
    }

    public boolean jC() {
        if (shouldShowContactUsOnFaqNotHelpful()) {
            return jA();
        }
        return false;
    }

    public boolean jD() {
        return this.y;
    }

    @Override // com.freshchat.consumer.sdk.k.n
    public void jc() {
        this.faq = null;
    }

    @Override // com.freshchat.consumer.sdk.k.n
    public Status jd() {
        Status status;
        if (al.aS(getContext())) {
            b.h(getContext(), this.faqId, this.categoryId);
            status = Status.INIT_LOADING;
        } else {
            status = Status.NO_INTERNET;
        }
        d(status);
        return this.rr;
    }

    public Status jm() {
        if (al.aS(getContext()) && this.rr == Status.NO_INTERNET) {
            jd();
            d(Status.INIT_LOADING);
        }
        return this.rr;
    }

    public Status jv() {
        return jd();
    }

    public String jw() {
        return as.isEmpty(this.categoryName) ? getContext().getString(R.string.freshchat_activity_title_article_detail) : this.categoryName;
    }

    public String jx() {
        String str;
        if (this.faq == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String replaceAll = this.faq.getContent().replaceAll("src=\"//", "src=\"http://").replaceAll("value=\"//", "value=\"http://");
        Pattern compile = Pattern.compile("<\\s*(img|iframe).*?src\\s*=[ '\"]+http[s]?:\\/\\/.*?>");
        if (al.aS(getContext()) || !compile.matcher(replaceAll).find()) {
            str = "";
        } else {
            StringBuilder i0 = hj1.i0("<div class='offline-article-message'>");
            i0.append(getContext().getString(R.string.freshchat_faq_rich_media_content_cannot_be_displayed));
            i0.append("</div>");
            str = i0.toString();
        }
        sb.append(this.u);
        sb.append("<div class=\"article-title\";><h3 >");
        sb.append(this.faq.getTitle());
        sb.append("</h3></div>");
        sb.append(str);
        sb.append("<div class=\"article-body\">");
        String b0 = hj1.b0(sb, replaceAll, "</div>", "</bdi></body></html>");
        return !as.isEmpty(this.faq.getCategoryName()) ? b0.replace(this.s, this.faq.getCategoryName()) : b0;
    }

    public void jy() {
        bg.a(getContext(), this.categoryId, this.categoryName, this.faqId, this.title, this.lE);
    }
}
