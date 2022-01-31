package defpackage;

import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;

/* renamed from: qe5  reason: default package */
/* compiled from: ContactsPhotoRequestHandler */
public class qe5 extends lf5 {
    public static final UriMatcher b;

    /* renamed from: a  reason: collision with root package name */
    public final Context f2936a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        b = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "display_photo/#", 4);
    }

    public qe5(Context context) {
        this.f2936a = context;
    }

    @Override // defpackage.lf5
    public boolean c(jf5 jf5) {
        Uri uri = jf5.c;
        return "content".equals(uri.getScheme()) && ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && b.match(jf5.c) != -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c  */
    @Override // defpackage.lf5
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public defpackage.lf5.a f(defpackage.jf5 r5, int r6) throws java.io.IOException {
        /*
            r4 = this;
            android.content.Context r6 = r4.f2936a
            android.content.ContentResolver r6 = r6.getContentResolver()
            android.net.Uri r5 = r5.c
            android.content.UriMatcher r0 = defpackage.qe5.b
            int r0 = r0.match(r5)
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L_0x002d
            r3 = 2
            if (r0 == r3) goto L_0x0028
            r3 = 3
            if (r0 == r3) goto L_0x0035
            r1 = 4
            if (r0 != r1) goto L_0x001c
            goto L_0x0028
        L_0x001c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Invalid uri: "
            java.lang.String r5 = defpackage.hj1.N(r0, r5)
            r6.<init>(r5)
            throw r6
        L_0x0028:
            java.io.InputStream r5 = r6.openInputStream(r5)
            goto L_0x0039
        L_0x002d:
            android.net.Uri r5 = android.provider.ContactsContract.Contacts.lookupContact(r6, r5)
            if (r5 != 0) goto L_0x0035
            r5 = r2
            goto L_0x0039
        L_0x0035:
            java.io.InputStream r5 = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(r6, r5, r1)
        L_0x0039:
            if (r5 != 0) goto L_0x003c
            return r2
        L_0x003c:
            lf5$a r6 = new lf5$a
            java.lang.String r0 = "$this$source"
            defpackage.n86.f(r5, r0)
            gn6 r0 = new gn6
            rn6 r1 = new rn6
            r1.<init>()
            r0.<init>(r5, r1)
            com.squareup.picasso.Picasso$d r5 = com.squareup.picasso.Picasso.d.DISK
            r6.<init>(r0, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qe5.f(jf5, int):lf5$a");
    }
}
