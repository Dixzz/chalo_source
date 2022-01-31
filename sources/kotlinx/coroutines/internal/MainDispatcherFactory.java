package kotlinx.coroutines.internal;

import java.util.List;

/* compiled from: MainDispatcherFactory.kt */
public interface MainDispatcherFactory {
    ad6 createDispatcher(List<? extends MainDispatcherFactory> list);

    int getLoadPriority();

    String hintOnError();
}
