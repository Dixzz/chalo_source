package com.freshchat.consumer.sdk.beans;

import org.json.JSONException;
import org.json.JSONObject;

public class Article {
    private static final String JSON_TAG_ARTICLE_ALIAS = "articleAlias";
    private static final String JSON_TAG_ARTICLE_ID = "articleId";
    private static final String JSON_TAG_CATEGORY_ID = "categoryId";
    private static final String JSON_TAG_CONTENT = "content";
    private static final String JSON_TAG_POSITION = "position";
    private static final String JSON_TAG_TITLE = "title";
    private static final String JSON_TAG_UPDATED_AT = "lastUpdatedAt";
    private String articleAlias;
    private String categoryId;
    private String description;
    private String id;
    private int position;
    private int rank = 0;
    private String title;
    private String updatedAt;

    public static Article getArticle(JSONObject jSONObject) throws JSONException {
        Article updatedAt2 = new Article().setId(jSONObject.getString(JSON_TAG_ARTICLE_ID)).setTitle(jSONObject.getString("title")).setDescription(jSONObject.getString("content")).setPosition(jSONObject.getInt(JSON_TAG_POSITION)).setCategoryId(jSONObject.getString("categoryId")).setUpdatedAt(jSONObject.getString(JSON_TAG_UPDATED_AT));
        if (jSONObject.has(JSON_TAG_ARTICLE_ALIAS)) {
            updatedAt2.setArticleAlias(jSONObject.getString(JSON_TAG_ARTICLE_ALIAS));
        }
        return updatedAt2;
    }

    public String getArticleAlias() {
        return this.articleAlias;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getDescription() {
        return this.description;
    }

    public String getId() {
        return this.id;
    }

    public int getPosition() {
        return this.position;
    }

    public int getRank() {
        return this.rank;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public Article setArticleAlias(String str) {
        this.articleAlias = str;
        return this;
    }

    public Article setCategoryId(String str) {
        this.categoryId = str;
        return this;
    }

    public Article setDescription(String str) {
        this.description = str;
        return this;
    }

    public Article setId(String str) {
        this.id = str;
        return this;
    }

    public Article setPosition(int i) {
        this.position = i;
        return this;
    }

    public Article setRank(int i) {
        this.rank = i;
        return this;
    }

    public Article setTitle(String str) {
        this.title = str;
        return this;
    }

    public Article setUpdatedAt(String str) {
        this.updatedAt = str;
        return this;
    }
}
