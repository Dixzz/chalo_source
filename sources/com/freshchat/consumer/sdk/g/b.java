package com.freshchat.consumer.sdk.g;

import android.content.Context;
import com.freshchat.consumer.sdk.b.g;
import com.freshchat.consumer.sdk.beans.Article;
import com.freshchat.consumer.sdk.c.i;
import com.freshchat.consumer.sdk.j.k;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class b extends c<Article> {
    private final i eL;
    private List<String> eM;
    private String eN;
    private List<Article> eO;
    private List<String> mw;
    private boolean mx;

    private b(Context context) {
        super(context);
        this.eL = new i(context);
    }

    public b(Context context, String str, boolean z, List<Article> list, boolean z2) {
        this(context);
        this.eN = str;
        this.eO = list;
        this.mx = z2;
    }

    public b(Context context, List<Article> list) {
        this(context);
        this.eO = list;
    }

    public b(Context context, List<Article> list, List<String> list2, List<String> list3, String str, boolean z) {
        this(context, list);
        if (k.a(list2)) {
            this.eM = list2;
        }
        if (k.a(list3)) {
            this.mw = list3;
        }
        this.eN = str;
        this.mx = z;
    }

    public ArrayList<Article> a(ArrayList<Article> arrayList) {
        ArrayList<Article> arrayList2 = new ArrayList<>(arrayList);
        Collections.sort(arrayList2, new Object() {
            /* class com.freshchat.consumer.sdk.g.b.AnonymousClass1 */

            /* renamed from: a */
            public int compare(Article article, Article article2) {
                if (article2.getRank() > article.getRank()) {
                    return 1;
                }
                return article2.getRank() < article.getRank() ? -1 : 0;
            }

            /* Return type fixed from 'java.util.Comparator' to match base method */
            @Override // j$.util.Comparator, java.util.Comparator
            public /* synthetic */ Comparator<Article> reversed() {
                return Comparator.CC.$default$reversed(this);
            }

            @Override // j$.util.Comparator
            public /* synthetic */ java.util.Comparator thenComparing(Function function) {
                return Comparator.CC.$default$thenComparing(this, function);
            }

            @Override // j$.util.Comparator
            public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
                return Comparator.CC.$default$thenComparing(this, function, comparator);
            }

            /* Return type fixed from 'java.util.Comparator' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
            @Override // j$.util.Comparator, java.util.Comparator
            public /* synthetic */ java.util.Comparator<Article> thenComparing(java.util.Comparator<? super Article> comparator) {
                return Comparator.CC.$default$thenComparing(this, comparator);
            }

            @Override // j$.util.Comparator
            public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
                return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
            }

            @Override // j$.util.Comparator
            public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
                return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
            }

            @Override // j$.util.Comparator
            public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
                return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
            }
        });
        return arrayList2;
    }

    @Override // com.freshchat.consumer.sdk.g.c
    public List<Article> dd() {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        if (k.a(this.eO)) {
            arrayList2.addAll(this.eO);
            arrayList = arrayList2;
        } else {
            ArrayList v = k.a(this.mw) ? this.eL.v(this.mw) : k.a(this.eM) ? this.eL.i(this.eM) : this.eL.cK();
            this.eO.addAll(v);
            arrayList = v;
        }
        return this.eN != null ? p(this.eO) : arrayList;
    }

    public boolean gE() {
        return this.mx;
    }

    @Override // com.freshchat.consumer.sdk.g.c, defpackage.li
    public void onReset() {
        super.onReset();
    }

    @Override // com.freshchat.consumer.sdk.g.c, defpackage.li
    public void onStartLoading() {
        super.onStartLoading();
    }

    public ArrayList<Article> p(List<Article> list) {
        ArrayList<Article> arrayList = new ArrayList<>();
        String str = this.eN;
        if (str == null || str.trim().length() == 0) {
            arrayList.addAll(list);
            return arrayList;
        }
        String[] split = this.eN.split("\\s+");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new g(this.eN.trim()));
        if (split.length > 1) {
            for (String str2 : split) {
                arrayList2.add(new g(str2));
            }
        }
        for (Article article : list) {
            String description = article.getDescription();
            String title = article.getTitle();
            Iterator it = arrayList2.iterator();
            int i = 0;
            while (it.hasNext()) {
                i += ((g) it.next()).a(title, description);
            }
            article.setRank(i);
            if (article.getRank() != 0) {
                arrayList.add(article);
            }
        }
        return a(arrayList);
    }
}
