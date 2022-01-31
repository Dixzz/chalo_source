package defpackage;

import java.nio.charset.Charset;

/* renamed from: vc  reason: default package */
/* compiled from: ManifestSchemaFactory */
public final class vc implements sd {
    public static final cd b = new a();

    /* renamed from: a  reason: collision with root package name */
    public final cd f3628a;

    /* renamed from: vc$a */
    /* compiled from: ManifestSchemaFactory */
    public static class a implements cd {
        @Override // defpackage.cd
        public bd a(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // defpackage.cd
        public boolean b(Class<?> cls) {
            return false;
        }
    }

    /* renamed from: vc$b */
    /* compiled from: ManifestSchemaFactory */
    public static class b implements cd {

        /* renamed from: a  reason: collision with root package name */
        public cd[] f3629a;

        public b(cd... cdVarArr) {
            this.f3629a = cdVarArr;
        }

        @Override // defpackage.cd
        public bd a(Class<?> cls) {
            cd[] cdVarArr = this.f3629a;
            for (cd cdVar : cdVarArr) {
                if (cdVar.b(cls)) {
                    return cdVar.a(cls);
                }
            }
            StringBuilder i0 = hj1.i0("No factory is available for message type: ");
            i0.append(cls.getName());
            throw new UnsupportedOperationException(i0.toString());
        }

        @Override // defpackage.cd
        public boolean b(Class<?> cls) {
            for (cd cdVar : this.f3629a) {
                if (cdVar.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public vc() {
        cd cdVar;
        cd[] cdVarArr = new cd[2];
        cdVarArr[0] = jc.f1902a;
        try {
            cdVar = (cd) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            cdVar = b;
        }
        cdVarArr[1] = cdVar;
        b bVar = new b(cdVarArr);
        Charset charset = mc.f2352a;
        this.f3628a = bVar;
    }
}
