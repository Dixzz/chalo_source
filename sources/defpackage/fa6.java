package defpackage;

/* renamed from: fa6  reason: default package */
/* compiled from: Strings.kt */
public final class fa6 extends o86 implements w76<CharSequence, Integer, m56<? extends Integer, ? extends Integer>> {
    public final /* synthetic */ char[] f;
    public final /* synthetic */ boolean g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public fa6(char[] cArr, boolean z) {
        super(2);
        this.f = cArr;
        this.g = z;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public m56<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
        CharSequence charSequence2 = charSequence;
        int intValue = num.intValue();
        n86.e(charSequence2, "$receiver");
        int o = ea6.o(charSequence2, this.f, intValue, this.g);
        if (o < 0) {
            return null;
        }
        return new m56(Integer.valueOf(o), 1);
    }
}
