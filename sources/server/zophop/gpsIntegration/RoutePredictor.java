package server.zophop.gpsIntegration;

import androidx.appcompat.widget.RtlSpacingHelper;
import java.util.ArrayList;
import java.util.List;

public class RoutePredictor {
    private List<Integer> getLongestIncreaseSubsequence(List<Integer> list) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = 1;
        }
        for (int i2 = 1; i2 < size; i2++) {
            int i3 = 0;
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                if (list.get(i4).intValue() < list.get(i2).intValue()) {
                    i3 = Math.max(i3, iArr[i4]);
                }
            }
            iArr[i2] = i3 + 1;
        }
        int i5 = RtlSpacingHelper.UNDEFINED;
        for (int i6 = 0; i6 < size; i6++) {
            if (iArr[i6] > i5) {
                i5 = iArr[i6];
            }
        }
        int[] iArr2 = new int[(i5 + 1)];
        iArr2[0] = list.size() - 1;
        return iterateLIS(iArr2, 0, iArr, list, i5);
    }

    private List<Integer> iterateLIS(int[] iArr, int i, int[] iArr2, List<Integer> list, int i2) {
        ArrayList arrayList = new ArrayList();
        if (i == i2) {
            while (i2 >= 1) {
                arrayList.add(list.get(iArr[i2]));
                i2--;
            }
            return arrayList;
        }
        int i3 = i + 1;
        int[] iArr3 = new int[list.size()];
        int i4 = i3 - 1;
        int i5 = 0;
        for (int i6 = iArr[i4]; i6 >= 0; i6--) {
            if (iArr2[i6] == (i2 - i3) + 1 && (list.get(i6).intValue() < list.get(iArr[i4]).intValue() || iArr2[i6] == i2)) {
                iArr3[i5] = i6;
                i5++;
            }
        }
        iArr[i3] = iArr3[0];
        return iterateLIS(iArr, i3, iArr2, list, i2);
    }

    public static void main(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(4);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(4);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(7);
        new RoutePredictor().extractUiqueValidIdxs(rev(arrayList));
    }

    private static List<Integer> rev(List<Integer> list) {
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            arrayList.add(list.get(size));
        }
        return arrayList;
    }

    public List<Integer> extractUiqueValidIdxs(List<Integer> list) {
        return getLongestIncreaseSubsequence(list);
    }
}
