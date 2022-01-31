package defpackage;

/* renamed from: do1  reason: default package */
/* compiled from: IntegerArrayAdapter */
public final class do1 implements wn1<int[]> {
    @Override // defpackage.wn1
    public String a() {
        return "IntegerArrayPool";
    }

    @Override // defpackage.wn1
    public int b() {
        return 4;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.wn1
    public int c(int[] iArr) {
        return iArr.length;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.wn1
    public int[] newArray(int i) {
        return new int[i];
    }
}
