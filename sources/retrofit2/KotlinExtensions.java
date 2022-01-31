package retrofit2;

/* compiled from: KotlinExtensions.kt */
public final class KotlinExtensions {
    public static final <T> Object await(Call<T> call, k66<? super T> k66) {
        sa6 sa6 = new sa6(hd3.B1(k66), 1);
        sa6.g(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new KotlinExtensions$await$2$2(sa6));
        Object u = sa6.u();
        if (u == p66.COROUTINE_SUSPENDED) {
            n86.e(k66, "frame");
        }
        return u;
    }

    public static final <T> Object awaitNullable(Call<T> call, k66<? super T> k66) {
        sa6 sa6 = new sa6(hd3.B1(k66), 1);
        sa6.g(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(call));
        call.enqueue(new KotlinExtensions$await$4$2(sa6));
        Object u = sa6.u();
        if (u == p66.COROUTINE_SUSPENDED) {
            n86.e(k66, "frame");
        }
        return u;
    }

    public static final <T> Object awaitResponse(Call<T> call, k66<? super Response<T>> k66) {
        sa6 sa6 = new sa6(hd3.B1(k66), 1);
        sa6.g(new KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new KotlinExtensions$awaitResponse$2$2(sa6));
        Object u = sa6.u();
        if (u == p66.COROUTINE_SUSPENDED) {
            n86.e(k66, "frame");
        }
        return u;
    }

    private static final <T> T create(Retrofit retrofit) {
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }
}
