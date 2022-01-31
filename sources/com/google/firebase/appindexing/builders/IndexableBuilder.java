package com.google.firebase.appindexing.builders;

import android.os.Bundle;
import android.os.Parcelable;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.google.firebase.appindexing.FirebaseAppIndexingInvalidArgumentException;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.appindexing.builders.IndexableBuilder;
import com.google.firebase.appindexing.internal.Thing;
import com.google.firebase.appindexing.internal.zzt;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public class IndexableBuilder<T extends IndexableBuilder<?>> {
    private final String type;
    private String url;
    private final Bundle zzay = new Bundle();
    private Thing.zza zzer;

    public IndexableBuilder(String str) {
        Objects.requireNonNull(str, "null reference");
        gj1.j(str);
        this.type = str;
    }

    public static void zza(Bundle bundle, String str, long... jArr) {
        Objects.requireNonNull(str, "null reference");
        Objects.requireNonNull(jArr, "null reference");
        if (jArr.length > 0) {
            if (jArr.length >= 100) {
                zzt.zzn("Input Array of elements is too big, cutting off.");
                jArr = Arrays.copyOf(jArr, 100);
            }
            bundle.putLongArray(str, jArr);
            return;
        }
        zzt.zzn("Long array is empty and is ignored by put method.");
    }

    public final Indexable build() {
        Bundle bundle = new Bundle(this.zzay);
        Thing.zza zza = this.zzer;
        if (zza == null) {
            zza = new Indexable.Metadata.Builder().zzaa();
        }
        return new Thing(bundle, zza, this.url, this.type);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.firebase.appindexing.builders.IndexableBuilder<T extends com.google.firebase.appindexing.builders.IndexableBuilder<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    public <S extends IndexableBuilder> T put(String str, S... sArr) {
        Objects.requireNonNull(str, "null reference");
        Objects.requireNonNull(sArr, "null reference");
        if (sArr.length > 0) {
            int length = sArr.length;
            Thing[] thingArr = new Thing[length];
            for (int i = 0; i < sArr.length; i++) {
                if (sArr[i] == null) {
                    StringBuilder sb = new StringBuilder(60);
                    sb.append("Builder at ");
                    sb.append(i);
                    sb.append(" is null and is ignored by put method.");
                    zzt.zzn(sb.toString());
                } else {
                    thingArr[i] = (Thing) sArr[i].build();
                }
            }
            if (length > 0) {
                zza(this.zzay, str, thingArr);
            }
        } else {
            zzt.zzn("Builder array is empty and is ignored by put method.");
        }
        return this;
    }

    public final T setDescription(String str) {
        Objects.requireNonNull(str, "null reference");
        return put("description", str);
    }

    public final T setImage(String str) {
        Objects.requireNonNull(str, "null reference");
        return put(ProductPromotionsObject.KEY_IMAGE, str);
    }

    public final T setKeywords(String... strArr) {
        return put("keywords", strArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.firebase.appindexing.builders.IndexableBuilder<T extends com.google.firebase.appindexing.builders.IndexableBuilder<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    public T setMetadata(Indexable.Metadata.Builder builder) {
        gj1.o(this.zzer == null, "setMetadata may only be called once");
        Objects.requireNonNull(builder, "null reference");
        this.zzer = builder.zzaa();
        return this;
    }

    public final T setName(String str) {
        Objects.requireNonNull(str, "null reference");
        return put("name", str);
    }

    public final T setSameAs(String str) {
        Objects.requireNonNull(str, "null reference");
        return put("sameAs", str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.firebase.appindexing.builders.IndexableBuilder<T extends com.google.firebase.appindexing.builders.IndexableBuilder<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final T setUrl(String str) {
        Objects.requireNonNull(str, "null reference");
        this.url = str;
        return this;
    }

    public static void zza(Bundle bundle, String str, Indexable... indexableArr) throws FirebaseAppIndexingInvalidArgumentException {
        Objects.requireNonNull(str, "null reference");
        Objects.requireNonNull(indexableArr, "null reference");
        Thing[] thingArr = new Thing[indexableArr.length];
        for (int i = 0; i < indexableArr.length; i++) {
            if (indexableArr[i] == null || (indexableArr[i] instanceof Thing)) {
                thingArr[i] = (Thing) indexableArr[i];
            } else {
                throw new FirebaseAppIndexingInvalidArgumentException("Invalid Indexable encountered. Use Indexable.Builder or convenience methods under Indexables to create the Indexable.");
            }
        }
        zza(bundle, str, thingArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.firebase.appindexing.builders.IndexableBuilder<T extends com.google.firebase.appindexing.builders.IndexableBuilder<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    public T put(String str, String... strArr) {
        zza(this.zzay, str, strArr);
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.firebase.appindexing.builders.IndexableBuilder<T extends com.google.firebase.appindexing.builders.IndexableBuilder<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    public T put(String str, Indexable... indexableArr) throws FirebaseAppIndexingInvalidArgumentException {
        zza(this.zzay, str, indexableArr);
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.firebase.appindexing.builders.IndexableBuilder<T extends com.google.firebase.appindexing.builders.IndexableBuilder<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    public T put(String str, boolean... zArr) {
        zza(this.zzay, str, zArr);
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.firebase.appindexing.builders.IndexableBuilder<T extends com.google.firebase.appindexing.builders.IndexableBuilder<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    public T put(String str, long... jArr) {
        zza(this.zzay, str, jArr);
        return this;
    }

    private static void zza(Bundle bundle, String str, Thing... thingArr) {
        Objects.requireNonNull(str, "null reference");
        Objects.requireNonNull(thingArr, "null reference");
        if (thingArr.length > 0) {
            int i = 0;
            for (int i2 = 0; i2 < thingArr.length; i2++) {
                thingArr[i] = thingArr[i2];
                if (thingArr[i2] == null) {
                    StringBuilder sb = new StringBuilder(58);
                    sb.append("Thing at ");
                    sb.append(i2);
                    sb.append(" is null and is ignored by put method.");
                    zzt.zzn(sb.toString());
                } else {
                    i++;
                }
            }
            if (i > 0) {
                bundle.putParcelableArray(str, (Parcelable[]) zza((Thing[]) Arrays.copyOfRange(thingArr, 0, i)));
                return;
            }
            return;
        }
        zzt.zzn("Thing array is empty and is ignored by put method.");
    }

    public static void zza(Bundle bundle, String str, String... strArr) {
        Objects.requireNonNull(str, "null reference");
        Objects.requireNonNull(strArr, "null reference");
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        if (strArr2.length > 0) {
            int i = 0;
            for (int i2 = 0; i2 < Math.min(strArr2.length, 100); i2++) {
                strArr2[i] = strArr2[i2];
                if (strArr2[i2] == null) {
                    StringBuilder sb = new StringBuilder(59);
                    sb.append("String at ");
                    sb.append(i2);
                    sb.append(" is null and is ignored by put method.");
                    zzt.zzn(sb.toString());
                } else {
                    int length = strArr2[i].length();
                    int i3 = Indexable.MAX_STRING_LENGTH;
                    if (length > 20000) {
                        StringBuilder sb2 = new StringBuilder(53);
                        sb2.append("String at ");
                        sb2.append(i2);
                        sb2.append(" is too long, truncating string.");
                        zzt.zzn(sb2.toString());
                        String str2 = strArr2[i];
                        if (str2.length() > 20000) {
                            if (Character.isHighSurrogate(str2.charAt(19999)) && Character.isLowSurrogate(str2.charAt(Indexable.MAX_STRING_LENGTH))) {
                                i3 = 19999;
                            }
                            str2 = str2.substring(0, i3);
                        }
                        strArr2[i] = str2;
                    }
                    i++;
                }
            }
            if (i > 0) {
                bundle.putStringArray(str, (String[]) zza((String[]) Arrays.copyOfRange(strArr2, 0, i)));
                return;
            }
            return;
        }
        zzt.zzn("String array is empty and is ignored by put method.");
    }

    public static void zza(Bundle bundle, String str, boolean... zArr) {
        Objects.requireNonNull(str, "null reference");
        Objects.requireNonNull(zArr, "null reference");
        if (zArr.length > 0) {
            if (zArr.length >= 100) {
                zzt.zzn("Input Array of elements is too big, cutting off.");
                zArr = Arrays.copyOf(zArr, 100);
            }
            bundle.putBooleanArray(str, zArr);
            return;
        }
        zzt.zzn("Boolean array is empty and is ignored by put method.");
    }

    private static <S> S[] zza(S[] sArr) {
        if (sArr.length < 100) {
            return sArr;
        }
        zzt.zzn("Input Array of elements is too big, cutting off.");
        return (S[]) Arrays.copyOf(sArr, 100);
    }
}
