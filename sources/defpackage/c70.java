package defpackage;

import android.text.TextUtils;
import defpackage.n00;
import defpackage.yj1;
import org.json.JSONArray;

/* renamed from: c70  reason: default package */
/* compiled from: UserProfileGZipJsonArrayRequest */
public class c70 extends ge1<JSONArray> {

    /* renamed from: c70$a */
    /* compiled from: UserProfileGZipJsonArrayRequest */
    public class a implements yj1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f528a;
        public final /* synthetic */ n00.z0 b;

        public a(String str, n00.z0 z0Var) {
            this.f528a = str;
            this.b = z0Var;
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            if (!TextUtils.isEmpty(dk1.getMessage()) && dk1.getMessage().contains("ssl")) {
                ed1 ed1 = new ed1("ssl error with url", Long.MIN_VALUE);
                hj1.K0(ed1, "uri", this.f528a, ed1);
            }
            this.b.a(dk1);
        }
    }

    public c70(String str, yj1.b<JSONArray> bVar, n00.z0 z0Var) {
        super(0, str, null, bVar, new a(str, z0Var));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.ge1
    public JSONArray D(String str) throws Exception {
        return new JSONArray(str);
    }
}
