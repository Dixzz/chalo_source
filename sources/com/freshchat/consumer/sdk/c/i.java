package com.freshchat.consumer.sdk.c;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.freshchat.consumer.sdk.beans.Article;
import com.freshchat.consumer.sdk.beans.Category;
import com.freshchat.consumer.sdk.beans.Tag;
import com.freshchat.consumer.sdk.c.a.a;
import com.freshchat.consumer.sdk.c.a.d;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.aw;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class i extends b {
    public static final Uri en = Uri.parse("sqlite://com.freshchat.consumer.sdk.model/articles");
    private static final String[] eo = new a().cR();
    private static final String[] ep = new d().cR();
    private Context context;

    public i(Context context2) {
        super(context2);
        this.context = context2.getApplicationContext();
    }

    private Cursor ac(String str) {
        return cs().query("articles", eo, "_id=?", new String[]{str}, null, null, null);
    }

    private Cursor cL() {
        return cs().query("articles", eo, null, null, null, null, "position");
    }

    private List<Article> g(Cursor cursor) {
        return b.b(cursor) ? j(cursor, i(cursor)) : new ArrayList();
    }

    private List<Category> h(Cursor cursor, Map<String, Integer> map) {
        ArrayList arrayList = new ArrayList();
        if (b.d(cursor)) {
            do {
                Category category = new Category();
                category.setId(cursor.getString(map.get("_id").intValue()));
                category.setTitle(cursor.getString(map.get(ProductPromotionsObject.KEY_TITLE).intValue()));
                category.setPosition(cursor.getInt(map.get("position").intValue()));
                category.setIconUrl(cursor.getString(map.get("icon_url").intValue()));
                category.setDescription(cursor.getString(map.get("description").intValue()));
                category.setCategoryAlias(cursor.getString(map.get("category_alias").intValue()));
                arrayList.add(category);
            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    private Map<String, Integer> h(Cursor cursor) {
        HashMap hashMap = new HashMap();
        if (b.d(cursor)) {
            hashMap.put("_id", Integer.valueOf(cursor.getColumnIndex("_id")));
            hashMap.put("category_alias", hj1.r(hashMap, "description", hj1.r(hashMap, "icon_url", hj1.r(hashMap, "position", hj1.r(hashMap, ProductPromotionsObject.KEY_TITLE, Integer.valueOf(cursor.getColumnIndex(ProductPromotionsObject.KEY_TITLE)), cursor, "position"), cursor, "icon_url"), cursor, "description"), cursor, "category_alias"));
        }
        return hashMap;
    }

    private List<String> i(Cursor cursor, Map<String, Integer> map) {
        ArrayList arrayList = new ArrayList();
        if (b.d(cursor)) {
            do {
                arrayList.add(cursor.getString(map.get("_id").intValue()));
            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    private Map<String, Integer> i(Cursor cursor) {
        HashMap hashMap = new HashMap();
        if (b.d(cursor)) {
            hashMap.put("_id", Integer.valueOf(cursor.getColumnIndex("_id")));
            hashMap.put("article_alias", hj1.r(hashMap, "content", hj1.r(hashMap, ProductPromotionsObject.KEY_TITLE, hj1.r(hashMap, "category_id", Integer.valueOf(cursor.getColumnIndex("category_id")), cursor, ProductPromotionsObject.KEY_TITLE), cursor, "content"), cursor, "article_alias"));
        }
        return hashMap;
    }

    private Cursor j(List<String> list) {
        if (k.isEmpty(list)) {
            return null;
        }
        StringBuilder i0 = hj1.i0(" SELECT DISTINCT a.*  FROM articles as a  INNER JOIN categories as c  ON (a.category_id = c._id), (SELECT *  FROM tags WHERE ");
        int b = k.b(list);
        Tag.TaggedType taggedType = Tag.TaggedType.CATEGORY;
        Tag.TaggedType taggedType2 = Tag.TaggedType.ARTICLE;
        hj1.V0(i0, j.a(b, taggedType, taggedType2), ") AS matching_tags  WHERE  (  matching_tags.", "tagged_type", " = '");
        i0.append(taggedType2.asInt());
        i0.append("' AND  matching_tags.");
        i0.append("tagged_id");
        i0.append(" = a.");
        hj1.V0(i0, "_id", " )  OR  (  matching_tags.", "tagged_type", " = '");
        i0.append(taggedType.asInt());
        i0.append("' AND  matching_tags.");
        i0.append("tagged_id");
        i0.append(" = a.");
        hj1.V0(i0, "category_id", " )  ORDER BY c.", "position", ",a.");
        i0.append("position");
        return cs().rawQuery(i0.toString(), (String[]) list.toArray(new String[0]));
    }

    private List<Article> j(Cursor cursor, Map<String, Integer> map) {
        ArrayList arrayList = new ArrayList();
        if (b.d(cursor)) {
            do {
                arrayList.add(l(cursor, map));
            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    private List<String> k(Cursor cursor, Map<String, Integer> map) {
        ArrayList arrayList = new ArrayList();
        if (b.d(cursor)) {
            do {
                Article l = l(cursor, map);
                if (l != null) {
                    arrayList.add(l.getId());
                }
            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    private Article l(Cursor cursor, Map<String, Integer> map) {
        if (!b.d(cursor)) {
            return null;
        }
        String string = cursor.getString(map.get("_id").intValue());
        String string2 = cursor.getString(map.get("category_id").intValue());
        String string3 = cursor.getString(map.get(ProductPromotionsObject.KEY_TITLE).intValue());
        String string4 = cursor.getString(map.get("content").intValue());
        String string5 = cursor.getString(map.get("article_alias").intValue());
        Article article = new Article();
        article.setId(string);
        article.setCategoryId(string2);
        article.setTitle(string3);
        article.setDescription(string4);
        article.setArticleAlias(string5);
        return article;
    }

    private Cursor m(List<String> list) {
        if (k.isEmpty(list)) {
            return null;
        }
        StringBuilder i0 = hj1.i0(" SELECT DISTINCT c.*  FROM categories as c  INNER JOIN articles as a  ON ( c._id = a.category_id), (SELECT DISTINCT tagged_id FROM tags WHERE ");
        hj1.V0(i0, j.a(k.b(list), Tag.TaggedType.CATEGORY), ") AS matching_tags  WHERE matching_tags.", "tagged_id", " = c.");
        return cs().rawQuery(hj1.b0(i0, "_id", " ORDER BY c.", "position"), (String[]) list.toArray(new String[0]));
    }

    private void n(List<Article> list) {
        SQLiteStatement compileStatement = cs().compileStatement(new a().cS());
        for (Article article : list) {
            compileStatement.clearBindings();
            compileStatement.bindString(1, article.getId());
            compileStatement.bindString(2, article.getCategoryId());
            compileStatement.bindString(3, article.getTitle());
            compileStatement.bindString(4, article.getDescription());
            compileStatement.bindString(5, Integer.toString(article.getPosition()));
            compileStatement.bindString(6, article.getUpdatedAt());
            compileStatement.bindString(7, article.getArticleAlias() == null ? "" : article.getArticleAlias());
            compileStatement.execute();
        }
        b.a(compileStatement);
    }

    private void o(List<Category> list) {
        SQLiteStatement compileStatement = cs().compileStatement(new d().cS());
        for (Category category : list) {
            compileStatement.clearBindings();
            compileStatement.bindString(1, category.getId());
            compileStatement.bindString(2, category.getTitle());
            compileStatement.bindString(3, category.getDescription());
            String str = "";
            compileStatement.bindString(4, category.getIconUrl() == null ? str : category.getIconUrl());
            compileStatement.bindString(5, Integer.toString(category.getPosition()));
            compileStatement.bindString(6, Long.toString(category.getUpdatedAt()));
            if (category.getCategoryAlias() != null) {
                str = category.getCategoryAlias();
            }
            compileStatement.bindString(7, str);
            compileStatement.execute();
        }
        b.a(compileStatement);
    }

    public Category Y(String str) {
        Cursor cursor;
        Throwable th;
        Exception e;
        try {
            if (as.isEmpty(str)) {
                b.c(null);
                return null;
            }
            cursor = cs().query("categories", ep, "_id=?", new String[]{str}, null, null, null);
            try {
                if (b.b(cursor)) {
                    List<Category> h = h(cursor, h(cursor));
                    if (k.a(h)) {
                        Category category = h.get(0);
                        b.c(cursor);
                        return category;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    q.a(e);
                    b.c(cursor);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    b.c(cursor);
                    throw th;
                }
            }
            b.c(cursor);
            return null;
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            q.a(e);
            b.c(cursor);
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            b.c(cursor);
            throw th;
        }
    }

    @Override // com.freshchat.consumer.sdk.c.b
    public Map<String, Integer> a(Cursor cursor) {
        return null;
    }

    public void a(List<Category> list, List<Article> list2, List<Tag> list3) {
        SQLiteDatabase cs = cs();
        cs.beginTransaction();
        try {
            cs.delete("articles", null, null);
            cs.delete("categories", null, null);
            j jVar = new j(this.context);
            jVar.a(Tag.TaggedType.CATEGORY);
            jVar.a(Tag.TaggedType.ARTICLE);
            if (k.a(list)) {
                o(list);
                if (k.a(list2)) {
                    n(list2);
                }
                if (k.a(list3)) {
                    jVar.f(list3);
                }
            }
            cs.setTransactionSuccessful();
            cs.endTransaction();
        } catch (Exception e) {
            q.a(e);
            throw e;
        } catch (Throwable th) {
            cs.endTransaction();
            throw th;
        }
    }

    public Article ab(String str) {
        Cursor cursor;
        Throwable th;
        Exception e;
        Article article = null;
        try {
            cursor = ac(str);
            try {
                if (b.b(cursor)) {
                    article = l(cursor, i(cursor));
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    q.a(e);
                    b.c(cursor);
                    return article;
                } catch (Throwable th2) {
                    th = th2;
                    b.c(cursor);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            q.a(e);
            b.c(cursor);
            return article;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            b.c(cursor);
            throw th;
        }
        b.c(cursor);
        return article;
    }

    public List<Category> cJ() {
        List<Category> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = cs().rawQuery("SELECT * FROM categories WHERE _id IN (SELECT DISTINCT category_id FROM articles) ORDER BY position", null);
            if (b.b(cursor)) {
                arrayList = h(cursor, h(cursor));
            }
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }

    public List<Article> cK() {
        List<Article> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = cL();
            arrayList = g(cursor);
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            b.c(cursor);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }

    public void cM() {
        if (aw.fI()) {
            this.context.getContentResolver().notifyChange(en, null);
        }
    }

    public List<String> h(List<String> list) {
        List<String> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = j(list);
            if (b.b(cursor)) {
                arrayList = k(cursor, i(cursor));
            }
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }

    public List<Article> i(List<String> list) {
        List<Article> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = j(list);
            arrayList = g(cursor);
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            b.c(cursor);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }

    public List<String> k(List<String> list) {
        List<String> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = m(list);
            if (b.b(cursor)) {
                arrayList = i(cursor, h(cursor));
            }
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }

    public List<Category> l(List<String> list) {
        List<Category> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = m(list);
            if (b.b(cursor)) {
                arrayList = h(cursor, h(cursor));
            }
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            b.c(null);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }

    public List<Article> v(List<String> list) {
        String str = " SELECT * FROM articles WHERE category_id IN ( " + as.a("?", ",", k.b(list)) + " ) ORDER BY " + "position";
        List<Article> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = cs().rawQuery(str, (String[]) list.toArray(new String[0]));
            arrayList = g(cursor);
        } catch (Exception e) {
            q.a(e);
        } catch (Throwable th) {
            b.c(cursor);
            throw th;
        }
        b.c(cursor);
        return arrayList;
    }
}
