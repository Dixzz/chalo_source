package defpackage;

/* renamed from: jl1  reason: default package */
/* compiled from: MemoryCategory */
public enum jl1 {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);
    
    private float multiplier;

    private jl1(float f) {
        this.multiplier = f;
    }

    public float getMultiplier() {
        return this.multiplier;
    }
}
