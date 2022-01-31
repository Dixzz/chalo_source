package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();
    public final String f;
    public final CharSequence g;
    public final CharSequence h;
    public final CharSequence i;
    public final Bitmap j;
    public final Uri k;
    public final Bundle l;
    public final Uri m;
    public Object n;

    public static class a implements Parcelable.Creator<MediaDescriptionCompat> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.a(MediaDescription.CREATOR.createFromParcel(parcel));
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    }

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f = str;
        this.g = charSequence;
        this.h = charSequence2;
        this.i = charSequence3;
        this.j = bitmap;
        this.k = uri;
        this.l = bundle;
        this.m = uri2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.v4.media.MediaDescriptionCompat a(java.lang.Object r15) {
        /*
            r0 = 0
            if (r15 == 0) goto L_0x0061
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = r15
            android.media.MediaDescription r2 = (android.media.MediaDescription) r2
            java.lang.String r4 = r2.getMediaId()
            java.lang.CharSequence r5 = r2.getTitle()
            java.lang.CharSequence r6 = r2.getSubtitle()
            java.lang.CharSequence r7 = r2.getDescription()
            android.graphics.Bitmap r8 = r2.getIconBitmap()
            android.net.Uri r9 = r2.getIconUri()
            android.os.Bundle r3 = r2.getExtras()
            java.lang.String r10 = "android.support.v4.media.description.MEDIA_URI"
            if (r3 == 0) goto L_0x0032
            android.support.v4.media.session.MediaSessionCompat.a(r3)
            android.os.Parcelable r11 = r3.getParcelable(r10)
            android.net.Uri r11 = (android.net.Uri) r11
            goto L_0x0033
        L_0x0032:
            r11 = r0
        L_0x0033:
            if (r11 == 0) goto L_0x004c
            java.lang.String r12 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r13 = r3.containsKey(r12)
            if (r13 == 0) goto L_0x0046
            int r13 = r3.size()
            r14 = 2
            if (r13 != r14) goto L_0x0046
            r10 = r0
            goto L_0x004d
        L_0x0046:
            r3.remove(r10)
            r3.remove(r12)
        L_0x004c:
            r10 = r3
        L_0x004d:
            if (r11 == 0) goto L_0x0050
            goto L_0x0059
        L_0x0050:
            r3 = 23
            if (r1 < r3) goto L_0x0058
            android.net.Uri r0 = r2.getMediaUri()
        L_0x0058:
            r11 = r0
        L_0x0059:
            android.support.v4.media.MediaDescriptionCompat r0 = new android.support.v4.media.MediaDescriptionCompat
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            r0.n = r15
        L_0x0061:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return ((Object) this.g) + ", " + ((Object) this.h) + ", " + ((Object) this.i);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        Object obj = this.n;
        if (obj == null) {
            MediaDescription.Builder builder = new MediaDescription.Builder();
            builder.setMediaId(this.f);
            builder.setTitle(this.g);
            builder.setSubtitle(this.h);
            builder.setDescription(this.i);
            builder.setIconBitmap(this.j);
            builder.setIconUri(this.k);
            Bundle bundle = this.l;
            if (i3 < 23 && this.m != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                    bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                }
                bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.m);
            }
            builder.setExtras(bundle);
            if (i3 >= 23) {
                builder.setMediaUri(this.m);
            }
            obj = builder.build();
            this.n = obj;
        }
        ((MediaDescription) obj).writeToParcel(parcel, i2);
    }
}
