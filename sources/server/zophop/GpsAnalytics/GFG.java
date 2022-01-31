package server.zophop.GpsAnalytics;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.List;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import j$.util.stream.Stream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Spliterator;

public class GFG extends ArrayList<String> implements List {
    public static void main(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        try {
            System.out.println(arrayList.subList(1, 3));
            PrintStream printStream = System.out;
            printStream.println("The stack after using removeRange:" + arrayList);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream parallelStream() {
        return Collection.CC.$default$parallelStream(this);
    }

    @Override // j$.util.Collection
    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    @Override // j$.util.List
    public /* synthetic */ void replaceAll(UnaryOperator unaryOperator) {
        List.CC.$default$replaceAll(this, unaryOperator);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
    @Override // j$.util.List, java.util.ArrayList, java.util.List
    public /* synthetic */ void sort(Comparator<? super String> comparator) {
        List.CC.$default$sort(this, comparator);
    }

    /* Return type fixed from 'j$.util.Spliterator' to match base method */
    @Override // j$.util.Collection, java.util.Collection, j$.util.List, java.lang.Iterable, java.util.ArrayList, java.util.List, j$.lang.Iterable
    public /* synthetic */ Spliterator<String> spliterator() {
        return List.CC.$default$spliterator(this);
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream stream() {
        return Collection.CC.$default$stream(this);
    }
}
