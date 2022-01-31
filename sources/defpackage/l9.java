package defpackage;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

/* renamed from: l9  reason: default package */
/* compiled from: InputContentInfoCompat */
public final class l9 {

    /* renamed from: a  reason: collision with root package name */
    public final c f2187a;

    /* renamed from: l9$b */
    /* compiled from: InputContentInfoCompat */
    public static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f2189a;
        public final ClipDescription b;
        public final Uri c;

        public b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f2189a = uri;
            this.b = clipDescription;
            this.c = uri2;
        }

        @Override // defpackage.l9.c
        public Uri a() {
            return this.f2189a;
        }

        @Override // defpackage.l9.c
        public void b() {
        }

        @Override // defpackage.l9.c
        public Uri c() {
            return this.c;
        }

        @Override // defpackage.l9.c
        public Object d() {
            return null;
        }

        @Override // defpackage.l9.c
        public ClipDescription getDescription() {
            return this.b;
        }
    }

    /* renamed from: l9$c */
    /* compiled from: InputContentInfoCompat */
    public interface c {
        Uri a();

        void b();

        Uri c();

        Object d();

        ClipDescription getDescription();
    }

    public l9(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.f2187a = new a(uri, clipDescription, uri2);
        } else {
            this.f2187a = new b(uri, clipDescription, uri2);
        }
    }

    /* renamed from: l9$a */
    /* compiled from: InputContentInfoCompat */
    public static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final InputContentInfo f2188a;

        public a(Object obj) {
            this.f2188a = (InputContentInfo) obj;
        }

        @Override // defpackage.l9.c
        public Uri a() {
            return this.f2188a.getContentUri();
        }

        @Override // defpackage.l9.c
        public void b() {
            this.f2188a.requestPermission();
        }

        @Override // defpackage.l9.c
        public Uri c() {
            return this.f2188a.getLinkUri();
        }

        @Override // defpackage.l9.c
        public Object d() {
            return this.f2188a;
        }

        @Override // defpackage.l9.c
        public ClipDescription getDescription() {
            return this.f2188a.getDescription();
        }

        public a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f2188a = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    public l9(c cVar) {
        this.f2187a = cVar;
    }
}
