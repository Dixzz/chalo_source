package server.zophop.utils;

import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import server.zophop.models.Point;

public class SortUtils {
    /* access modifiers changed from: private */
    public static int comparePoints(Point point, Point point2) {
        if (point.getTime() > point2.getTime()) {
            return 1;
        }
        return point.getTime() < point2.getTime() ? -1 : 0;
    }

    public static List<Point> sortPoints(List<Point> list) {
        Collections.sort(list, new Object() {
            /* class server.zophop.utils.SortUtils.AnonymousClass1 */

            /* Return type fixed from 'java.util.Comparator' to match base method */
            @Override // j$.util.Comparator, java.util.Comparator
            public /* synthetic */ Comparator<Point> reversed() {
                return Comparator.CC.$default$reversed(this);
            }

            @Override // j$.util.Comparator
            public /* synthetic */ java.util.Comparator thenComparing(Function function) {
                return Comparator.CC.$default$thenComparing(this, function);
            }

            @Override // j$.util.Comparator
            public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
                return Comparator.CC.$default$thenComparing(this, function, comparator);
            }

            /* Return type fixed from 'java.util.Comparator' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
            @Override // j$.util.Comparator, java.util.Comparator
            public /* synthetic */ java.util.Comparator<Point> thenComparing(java.util.Comparator<? super Point> comparator) {
                return Comparator.CC.$default$thenComparing(this, comparator);
            }

            @Override // j$.util.Comparator
            public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
                return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
            }

            @Override // j$.util.Comparator
            public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
                return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
            }

            @Override // j$.util.Comparator
            public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
                return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
            }

            public int compare(Point point, Point point2) {
                return SortUtils.comparePoints(point, point2);
            }
        });
        return list;
    }
}
