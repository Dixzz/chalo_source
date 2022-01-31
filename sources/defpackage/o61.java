package defpackage;

import app.zophop.models.Route;
import app.zophop.models.Stop;
import app.zophop.models.StreamInfo;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: o61  reason: default package */
/* compiled from: LiveStopPositionHandler */
public class o61 {

    /* renamed from: a  reason: collision with root package name */
    public List<StreamInfo> f2654a = new ArrayList();
    public final Route b;
    public final HashMap<String, String> c = new HashMap<>();

    /* renamed from: o61$a */
    /* compiled from: LiveStopPositionHandler */
    public enum a {
        ENTRY,
        EXIT,
        MIDDLE
    }

    public o61(Route route) {
        this.b = route;
    }

    public String a(Stop stop, a aVar) {
        for (StreamInfo streamInfo : this.f2654a) {
            if (f(stop, streamInfo, aVar)) {
                return streamInfo.getVehicleNumber();
            }
        }
        return null;
    }

    public String b(Stop stop, a aVar) {
        for (StreamInfo streamInfo : this.f2654a) {
            if (f(stop, streamInfo, aVar)) {
                return String.valueOf((System.currentTimeMillis() - streamInfo.getTimeStamp()) / DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL);
            }
        }
        return null;
    }

    public final String c(String str, String str2) {
        return hj1.T(str, ProductDiscountsObject.KEY_DELIMITER, str2);
    }

    public final Stop d(Stop stop) {
        List<Stop> stopSequence = this.b.getStopSequence();
        for (int i = 1; i < stopSequence.size(); i++) {
            if (stopSequence.get(i).equals(stop)) {
                return stopSequence.get(i - 1);
            }
        }
        return stop;
    }

    public boolean e(Stop stop, a aVar) {
        for (StreamInfo streamInfo : this.f2654a) {
            if (f(stop, streamInfo, aVar)) {
                return true;
            }
        }
        return false;
    }

    public final boolean f(Stop stop, StreamInfo streamInfo, a aVar) {
        String str;
        Stop stop2;
        String str2 = this.c.get(streamInfo.getStreamId());
        if (aVar.equals(a.MIDDLE)) {
            str = stop.getId();
        } else if (aVar.equals(a.ENTRY)) {
            str = c(d(stop).getId(), stop.getId());
        } else {
            List<Stop> stopSequence = this.b.getStopSequence();
            int i = 0;
            while (true) {
                if (i >= stopSequence.size() - 1) {
                    stop2 = stop;
                    break;
                } else if (stopSequence.get(i).equals(stop)) {
                    stop2 = stopSequence.get(i + 1);
                    break;
                } else {
                    i++;
                }
            }
            str = c(stop.getId(), stop2.getId());
        }
        return str.equals(str2);
    }

    public void g(List<StreamInfo> list) {
        Stop stop;
        ArrayList<StreamInfo> arrayList = new ArrayList(list);
        this.f2654a = arrayList;
        for (StreamInfo streamInfo : arrayList) {
            String nextStopId = streamInfo.getNextStopId();
            Iterator<Stop> it = this.b.getStopSequence().iterator();
            while (true) {
                if (!it.hasNext()) {
                    stop = null;
                    break;
                }
                stop = it.next();
                if (stop.getId().equals(nextStopId)) {
                    break;
                }
            }
            this.c.put(streamInfo.getStreamId(), c(d(stop).getId(), nextStopId));
        }
    }
}
