package com.google.firebase.appindexing;

import android.os.Bundle;
import com.google.firebase.appindexing.builders.IndexableBuilder;
import com.google.firebase.appindexing.internal.zza;
import com.google.firebase.appindexing.internal.zzc;
import com.google.firebase.appindexing.internal.zzt;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public interface Action {

    /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
    public static class Builder {
        public static final String ACTIVATE_ACTION = "ActivateAction";
        public static final String ADD_ACTION = "AddAction";
        public static final String BOOKMARK_ACTION = "BookmarkAction";
        public static final String COMMENT_ACTION = "CommentAction";
        public static final String LIKE_ACTION = "LikeAction";
        public static final String LISTEN_ACTION = "ListenAction";
        public static final String SEND_ACTION = "SendAction";
        public static final String SHARE_ACTION = "ShareAction";
        public static final String STATUS_TYPE_ACTIVE = "http://schema.org/ActiveActionStatus";
        public static final String STATUS_TYPE_COMPLETED = "http://schema.org/CompletedActionStatus";
        public static final String STATUS_TYPE_FAILED = "http://schema.org/FailedActionStatus";
        public static final String VIEW_ACTION = "ViewAction";
        public static final String WATCH_ACTION = "WatchAction";
        private final String zzar;
        private final Bundle zzay = new Bundle();
        private String zzeg;
        private String zzeh;
        private String zzei;
        private zzc zzej;
        private String zzek;

        public Builder(String str) {
            this.zzar = str;
        }

        public Action build() {
            gj1.l(this.zzeg, "setObject is required before calling build().");
            gj1.l(this.zzeh, "setObject is required before calling build().");
            String str = this.zzar;
            String str2 = this.zzeg;
            String str3 = this.zzeh;
            String str4 = this.zzei;
            zzc zzc = this.zzej;
            if (zzc == null) {
                zzc = new Metadata.Builder().zzz();
            }
            return new zza(str, str2, str3, str4, zzc, this.zzek, this.zzay);
        }

        public final String getName() {
            if (this.zzeg == null) {
                return null;
            }
            return new String(this.zzeg);
        }

        public final String getUrl() {
            if (this.zzeh == null) {
                return null;
            }
            return new String(this.zzeh);
        }

        public Builder put(String str, String... strArr) {
            IndexableBuilder.zza(this.zzay, str, strArr);
            return this;
        }

        public Builder setActionStatus(String str) {
            Objects.requireNonNull(str, "null reference");
            this.zzek = str;
            return this;
        }

        public Builder setMetadata(Metadata.Builder builder) {
            Objects.requireNonNull(builder, "null reference");
            this.zzej = builder.zzz();
            return this;
        }

        public final Builder setName(String str) {
            Objects.requireNonNull(str, "null reference");
            this.zzeg = str;
            return put("name", str);
        }

        public Builder setObject(String str, String str2) {
            Objects.requireNonNull(str, "null reference");
            Objects.requireNonNull(str2, "null reference");
            this.zzeg = str;
            this.zzeh = str2;
            return this;
        }

        public Builder setResult(Indexable... indexableArr) throws FirebaseAppIndexingInvalidArgumentException {
            return put("result", indexableArr);
        }

        public final Builder setUrl(String str) {
            Objects.requireNonNull(str, "null reference");
            this.zzeh = str;
            return put("url", str);
        }

        public final String zzy() {
            return new String(this.zzek);
        }

        public Builder put(String str, Indexable... indexableArr) throws FirebaseAppIndexingInvalidArgumentException {
            IndexableBuilder.zza(this.zzay, str, indexableArr);
            return this;
        }

        public Builder put(String str, boolean... zArr) {
            IndexableBuilder.zza(this.zzay, str, zArr);
            return this;
        }

        public Builder put(String str, long... jArr) {
            IndexableBuilder.zza(this.zzay, str, jArr);
            return this;
        }

        public Builder put(String str, double... dArr) {
            Bundle bundle = this.zzay;
            Objects.requireNonNull(str, "null reference");
            Objects.requireNonNull(dArr, "null reference");
            if (dArr.length > 0) {
                if (dArr.length >= 100) {
                    zzt.zzn("Input Array of elements is too big, cutting off.");
                    dArr = Arrays.copyOf(dArr, 100);
                }
                bundle.putDoubleArray(str, dArr);
            } else {
                zzt.zzn("Double array is empty and is ignored by put method.");
            }
            return this;
        }

        public Builder setObject(String str, String str2, String str3) {
            Objects.requireNonNull(str, "null reference");
            Objects.requireNonNull(str2, "null reference");
            Objects.requireNonNull(str3, "null reference");
            this.zzeg = str;
            this.zzeh = str2;
            this.zzei = str3;
            return this;
        }
    }

    /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
    public interface Metadata {

        /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
        public static class Builder {
            private boolean zzel = true;
            private boolean zzem = false;

            public Builder setUpload(boolean z) {
                this.zzel = z;
                return this;
            }

            public final zzc zzz() {
                return new zzc(this.zzel, null, null, null, false);
            }
        }
    }
}
