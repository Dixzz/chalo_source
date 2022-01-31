package zophop.models.preproccessing;

import java.util.ArrayList;

public class UniqueStopSequence {
    public ArrayList<Long> node_ids;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UniqueStopSequence uniqueStopSequence = (UniqueStopSequence) obj;
        ArrayList<Long> arrayList = this.node_ids;
        if (arrayList == null) {
            if (uniqueStopSequence.node_ids != null) {
                return false;
            }
        } else if (!equals(arrayList, uniqueStopSequence.node_ids)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        ArrayList<Long> arrayList = this.node_ids;
        return 31 + (arrayList == null ? 0 : arrayList.size());
    }

    public boolean equals(ArrayList<Long> arrayList, ArrayList<Long> arrayList2) {
        if (arrayList.size() != arrayList2.size()) {
            return false;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).longValue() != arrayList2.get(i).longValue()) {
                return false;
            }
        }
        return true;
    }
}
