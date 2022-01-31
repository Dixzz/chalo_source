package com.freshchat.consumer.sdk.beans;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class FCLocale {
    private String country;
    private String direction;
    private String displayCode;
    private String displayName;
    private String extension;
    private String language;
    private long localeId;
    private String region;
    private String script;
    private String variant;

    public static FCLocale fromString(String str) {
        try {
            return (FCLocale) new Gson().fromJson(str, FCLocale.class);
        } catch (JsonSyntaxException unused) {
            return null;
        }
    }

    public String getCountry() {
        return this.country;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getDisplayCode() {
        return this.displayCode;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getExtension() {
        return this.extension;
    }

    public String getLanguage() {
        return this.language;
    }

    public long getLocaleId() {
        return this.localeId;
    }

    public String getRegion() {
        return this.region;
    }

    public String getScript() {
        return this.script;
    }

    public String getVariant() {
        return this.variant;
    }

    public FCLocale setCountry(String str) {
        this.country = str;
        return this;
    }

    public FCLocale setDirection(String str) {
        this.direction = str;
        return this;
    }

    public FCLocale setDisplayCode(String str) {
        this.displayCode = str;
        return this;
    }

    public FCLocale setDisplayName(String str) {
        this.displayName = str;
        return this;
    }

    public FCLocale setExtension(String str) {
        this.extension = str;
        return this;
    }

    public FCLocale setLanguage(String str) {
        this.language = str;
        return this;
    }

    public FCLocale setLocaleId(long j) {
        this.localeId = j;
        return this;
    }

    public FCLocale setRegion(String str) {
        this.region = str;
        return this;
    }

    public FCLocale setScript(String str) {
        this.script = str;
        return this;
    }

    public FCLocale setVariant(String str) {
        this.variant = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FCLocale{");
        sb.append("localeId='");
        sb.append(this.localeId);
        sb.append('\'');
        sb.append(", language='");
        hj1.U0(sb, this.language, '\'', ", script='");
        hj1.U0(sb, this.script, '\'', ", region='");
        hj1.U0(sb, this.region, '\'', ", country='");
        hj1.U0(sb, this.country, '\'', ", variant='");
        hj1.U0(sb, this.variant, '\'', ", extension='");
        hj1.U0(sb, this.extension, '\'', ", displayCode='");
        hj1.U0(sb, this.displayCode, '\'', ", displayName='");
        hj1.U0(sb, this.displayName, '\'', ", direction='");
        sb.append(this.direction);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
