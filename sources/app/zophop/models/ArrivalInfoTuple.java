package app.zophop.models;

import java.util.Objects;

public class ArrivalInfoTuple {
    public k20 destInfo;
    public final String destinationStopId;

    public ArrivalInfoTuple(String str, k20 k20) throws NullPointerException {
        this.destInfo = k20;
        this.destinationStopId = str;
        Objects.requireNonNull(str);
        if (k20 == null) {
            this.destInfo = ii1.j();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ArrivalInfoTuple)) {
            return false;
        }
        ArrivalInfoTuple arrivalInfoTuple = (ArrivalInfoTuple) obj;
        if (!this.destinationStopId.equals(arrivalInfoTuple.destinationStopId)) {
            return false;
        }
        k20 k20 = this.destInfo;
        if (k20 != null) {
            return k20.equals(arrivalInfoTuple.destInfo);
        }
        if (arrivalInfoTuple.destInfo == null) {
            return true;
        }
        return false;
    }
}
