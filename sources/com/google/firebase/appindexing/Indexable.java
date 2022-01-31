package com.google.firebase.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.google.firebase.appindexing.builders.IndexableBuilder;
import com.google.firebase.appindexing.internal.Thing;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public interface Indexable {
    public static final int MAX_BYTE_SIZE = 30000;
    public static final int MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL = 1000;
    public static final int MAX_NESTING_DEPTH = 5;
    public static final int MAX_NUMBER_OF_FIELDS = 20;
    public static final int MAX_REPEATED_SIZE = 100;
    public static final int MAX_STRING_LENGTH = 20000;
    public static final int MAX_URL_LENGTH = 256;

    /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
    public static class Builder extends IndexableBuilder<Builder> {
        public Builder() {
            this("Thing");
        }

        public Builder(String str) {
            super(str);
        }
    }

    /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
    public interface Metadata {

        /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
        public static final class Builder {
            private int score = dl3.m().j();
            private final Bundle zzay = new Bundle();
            private boolean zzeo = dl3.m().k();
            private String zzep = dl3.m().l();

            public final Builder setScope(int i) {
                boolean z = i > 0 && i <= 3;
                StringBuilder sb = new StringBuilder(69);
                sb.append("The scope of this indexable is not valid, scope value is ");
                sb.append(i);
                sb.append(".");
                gj1.c(z, sb.toString());
                IndexableBuilder.zza(this.zzay, "scope", (long) i);
                return this;
            }

            public final Builder setScore(int i) {
                boolean z = i >= 0;
                StringBuilder sb = new StringBuilder(53);
                sb.append("Negative score values are invalid. Value: ");
                sb.append(i);
                gj1.c(z, sb.toString());
                this.score = i;
                return this;
            }

            public final Builder setSliceUri(Uri uri) {
                Objects.requireNonNull(uri, "null reference");
                IndexableBuilder.zza(this.zzay, "grantSlicePermission", true);
                IndexableBuilder.zza(this.zzay, "sliceUri", uri.toString());
                return this;
            }

            public final Builder setWorksOffline(boolean z) {
                this.zzeo = z;
                return this;
            }

            public final Thing.zza zzaa() {
                return new Thing.zza(this.zzeo, this.score, this.zzep, this.zzay);
            }
        }
    }
}
