package com.freshchat.consumer.sdk.beans;

import org.json.JSONException;
import org.json.JSONObject;

public class Category implements ICategory {
    private static final String JSON_TAG_CATEGORY_ALIAS = "categoryAlias";
    private static final String JSON_TAG_CATEGORY_ID = "categoryId";
    private static final String JSON_TAG_DESCRIPTION = "description";
    private static final String JSON_TAG_POSITION = "position";
    private static final String JSON_TAG_TITLE = "title";
    private static final String JSON_TAG_UPDATED_AT = "lastUpdatedAt";
    private static final String JSON_TAG_URL = "icon";
    private String categoryAlias;
    private String description;
    private String iconUrl;
    private String id;
    private int position;
    private String title;
    private long updatedAt;

    public static Category getCategory(JSONObject jSONObject) throws JSONException {
        Category updatedAt2 = new Category().setId(jSONObject.getString("categoryId")).setTitle(jSONObject.getString("title")).setDescription(jSONObject.optString(JSON_TAG_DESCRIPTION)).setIconUrl(jSONObject.optString(JSON_TAG_URL)).setPosition(jSONObject.getInt(JSON_TAG_POSITION)).setUpdatedAt(jSONObject.getLong(JSON_TAG_UPDATED_AT));
        if (jSONObject.has(JSON_TAG_CATEGORY_ALIAS)) {
            updatedAt2.setCategoryAlias(jSONObject.getString(JSON_TAG_CATEGORY_ALIAS));
        }
        return updatedAt2;
    }

    @Override // com.freshchat.consumer.sdk.beans.ICategory
    public String getCategoryAlias() {
        return this.categoryAlias;
    }

    @Override // com.freshchat.consumer.sdk.beans.ICategory
    public String getCategoryId() {
        return this.id;
    }

    @Override // com.freshchat.consumer.sdk.beans.ICategory
    public String getDescription() {
        return this.description;
    }

    @Override // com.freshchat.consumer.sdk.beans.ICategory
    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getId() {
        return this.id;
    }

    public int getPosition() {
        return this.position;
    }

    @Override // com.freshchat.consumer.sdk.beans.ICategory
    public String getTitle() {
        return this.title;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public Category setCategoryAlias(String str) {
        this.categoryAlias = str;
        return this;
    }

    public Category setDescription(String str) {
        this.description = str;
        return this;
    }

    public Category setIconUrl(String str) {
        this.iconUrl = str;
        return this;
    }

    public Category setId(String str) {
        this.id = str;
        return this;
    }

    public Category setPosition(int i) {
        this.position = i;
        return this;
    }

    public Category setTitle(String str) {
        this.title = str;
        return this;
    }

    public Category setUpdatedAt(long j) {
        this.updatedAt = j;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Category{");
        sb.append("id='");
        hj1.U0(sb, this.id, '\'', ", title='");
        hj1.U0(sb, this.title, '\'', ", description='");
        hj1.U0(sb, this.description, '\'', ", iconUrl='");
        hj1.U0(sb, this.iconUrl, '\'', ", position='");
        sb.append(this.position);
        sb.append('\'');
        sb.append(", categoryAlias='");
        sb.append(this.categoryAlias);
        sb.append('\'');
        sb.append(", updatedAt=");
        sb.append('}');
        return sb.toString();
    }
}
