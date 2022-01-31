package retrofit2;

import java.io.IOException;

public interface Call<T> extends Cloneable {
    void cancel();

    @Override // java.lang.Object
    Call<T> clone();

    void enqueue(Callback<T> callback);

    Response<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    ji6 request();
}
