package app.zophop.models;

import com.google.firebase.perf.util.Constants;
import com.rabbitmq.client.AMQP;

public class TripOptions {
    public boolean _ac = true;
    public int _maxAutoCabDistance = Constants.MAX_URL_LENGTH;
    public int _maxWalkDistance = AMQP.REPLY_SUCCESS;
    public boolean _nonAc = true;
    public final l90 _tabItem;

    public TripOptions(l90 l90) {
        this._tabItem = l90;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TripOptions)) {
            return false;
        }
        TripOptions tripOptions = (TripOptions) obj;
        if (this._ac == tripOptions._ac && this._maxAutoCabDistance == tripOptions._maxAutoCabDistance && this._maxWalkDistance == tripOptions._maxWalkDistance && this._nonAc == tripOptions._nonAc && this._tabItem == tripOptions._tabItem) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this._tabItem.hashCode() * 31) + this._maxWalkDistance) * 31) + this._maxAutoCabDistance) * 31) + (this._ac ? 1 : 0)) * 31) + (this._nonAc ? 1 : 0);
    }
}
