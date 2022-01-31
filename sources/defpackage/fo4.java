package defpackage;

/* renamed from: fo4  reason: default package */
/* compiled from: CutCornerTreatment */
public class fo4 extends eo4 {
    @Override // defpackage.eo4
    public void a(no4 no4, float f, float f2, float f3) {
        no4.e(0.0f, f3 * f2, 180.0f, 180.0f - f);
        double d = (double) f3;
        double d2 = (double) f2;
        no4.d((float) (Math.sin(Math.toRadians((double) f)) * d * d2), (float) (Math.sin(Math.toRadians((double) (90.0f - f))) * d * d2));
    }
}
