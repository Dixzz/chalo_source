package defpackage;

/* renamed from: r7  reason: default package */
/* compiled from: TextDirectionHeuristicsCompat */
public final class r7 {

    /* renamed from: a  reason: collision with root package name */
    public static final q7 f3050a = new d(null, false);
    public static final q7 b = new d(null, true);
    public static final q7 c;
    public static final q7 d;

    /* renamed from: r7$a */
    /* compiled from: TextDirectionHeuristicsCompat */
    public static class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f3051a = new a();

        @Override // defpackage.r7.b
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                byte directionality = Character.getDirectionality(charSequence.charAt(i));
                q7 q7Var = r7.f3050a;
                if (directionality != 0) {
                    if (!(directionality == 1 || directionality == 2)) {
                        switch (directionality) {
                            case 14:
                            case 15:
                                break;
                            case 16:
                            case 17:
                                break;
                            default:
                                i4 = 2;
                                break;
                        }
                        i++;
                    }
                    i4 = 0;
                    i++;
                }
                i4 = 1;
                i++;
            }
            return i4;
        }
    }

    /* renamed from: r7$b */
    /* compiled from: TextDirectionHeuristicsCompat */
    public interface b {
        int a(CharSequence charSequence, int i, int i2);
    }

    /* renamed from: r7$c */
    /* compiled from: TextDirectionHeuristicsCompat */
    public static abstract class c implements q7 {

        /* renamed from: a  reason: collision with root package name */
        public final b f3052a;

        public c(b bVar) {
            this.f3052a = bVar;
        }

        public abstract boolean a();

        public boolean b(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            }
            b bVar = this.f3052a;
            if (bVar == null) {
                return a();
            }
            int a2 = bVar.a(charSequence, i, i2);
            if (a2 == 0) {
                return true;
            }
            if (a2 != 1) {
                return a();
            }
            return false;
        }
    }

    /* renamed from: r7$d */
    /* compiled from: TextDirectionHeuristicsCompat */
    public static class d extends c {
        public final boolean b;

        public d(b bVar, boolean z) {
            super(bVar);
            this.b = z;
        }

        @Override // defpackage.r7.c
        public boolean a() {
            return this.b;
        }
    }

    static {
        a aVar = a.f3051a;
        c = new d(aVar, false);
        d = new d(aVar, true);
    }
}
