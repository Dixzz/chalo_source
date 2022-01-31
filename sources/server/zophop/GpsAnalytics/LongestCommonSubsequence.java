package server.zophop.GpsAnalytics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {
    public static ArrayList<String> lcs(List<String> list, List<String> list2) {
        int size = list.size();
        int size2 = list2.size();
        int[] iArr = new int[2];
        iArr[1] = size2 + 1;
        iArr[0] = size + 1;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
        for (int i = 0; i <= size; i++) {
            for (int i2 = 0; i2 <= size2; i2++) {
                if (i == 0 || i2 == 0) {
                    iArr2[i][i2] = 0;
                } else {
                    int i3 = i - 1;
                    int i4 = i2 - 1;
                    if (list.get(i3).equalsIgnoreCase(list2.get(i4))) {
                        iArr2[i][i2] = iArr2[i3][i4] + 1;
                    } else {
                        iArr2[i][i2] = Math.max(iArr2[i3][i2], iArr2[i][i4]);
                    }
                }
            }
        }
        int i5 = iArr2[size][size2];
        ArrayList<String> arrayList = new ArrayList<>(i5 + 1);
        for (int i6 = 0; i6 <= i5; i6++) {
            arrayList.add("");
        }
        while (size > 0 && size2 > 0) {
            int i7 = size - 1;
            int i8 = size2 - 1;
            if (list.get(i7).equalsIgnoreCase(list2.get(i8))) {
                arrayList.add(i5 - 1, list.get(i7));
                size--;
                size2--;
                i5--;
            } else if (iArr2[i7][size2] > iArr2[size][i8]) {
                size--;
            } else {
                size2--;
            }
        }
        return arrayList;
    }

    public static void main(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add("a");
        arrayList.add("g");
        arrayList.add("g");
        arrayList.add("t");
        arrayList.add("a");
        arrayList.add("b");
        arrayList2.add("g");
        arrayList2.add("x");
        arrayList2.add("t");
        arrayList2.add("x");
        arrayList2.add("a");
        arrayList2.add("y");
        arrayList2.add("b");
        System.out.println(lcs(arrayList, arrayList2));
    }
}
