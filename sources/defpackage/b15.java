package defpackage;

import java.nio.charset.Charset;

/* renamed from: b15  reason: default package */
/* compiled from: ManifestSchemaFactory */
public final class b15 implements y15 {
    public static final i15 b = new a();

    /* renamed from: a  reason: collision with root package name */
    public final i15 f365a;

    /* renamed from: b15$a */
    /* compiled from: ManifestSchemaFactory */
    public static class a implements i15 {
        @Override // defpackage.i15
        public h15 a(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // defpackage.i15
        public boolean b(Class<?> cls) {
            return false;
        }
    }

    /* renamed from: b15$b */
    /* compiled from: ManifestSchemaFactory */
    public static class b implements i15 {

        /* renamed from: a  reason: collision with root package name */
        public i15[] f366a;

        public b(i15... i15Arr) {
            this.f366a = i15Arr;
        }

        @Override // defpackage.i15
        public h15 a(Class<?> cls) {
            i15[] i15Arr = this.f366a;
            for (i15 i15 : i15Arr) {
                if (i15.b(cls)) {
                    return i15.a(cls);
                }
            }
            StringBuilder i0 = hj1.i0("No factory is available for message type: ");
            i0.append(cls.getName());
            throw new UnsupportedOperationException(i0.toString());
        }

        @Override // defpackage.i15
        public boolean b(Class<?> cls) {
            for (i15 i15 : this.f366a) {
                if (i15.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public b15() {
        i15 i15;
        i15[] i15Arr = new i15[2];
        i15Arr[0] = p05.f2754a;
        try {
            i15 = (i15) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            i15 = b;
        }
        i15Arr[1] = i15;
        b bVar = new b(i15Arr);
        Charset charset = s05.f3160a;
        this.f365a = bVar;
    }
}
