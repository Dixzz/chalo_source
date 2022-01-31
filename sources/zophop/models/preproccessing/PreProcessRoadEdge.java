package zophop.models.preproccessing;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import zophop.models.Data;
import zophop.models.SpatialRecord;
import zophop.models.Stop;

public class PreProcessRoadEdge implements Callable {
    public static oo6 utils;
    public Data data;
    public int id;
    public HashMap<String, ArrayList<RoadConnection>> map;
    public ArrayList<Stop> stops;

    public PreProcessRoadEdge(int i, Data data2, HashMap<String, ArrayList<RoadConnection>> hashMap, ArrayList<Stop> arrayList) {
        this.id = i;
        this.data = data2;
        this.map = hashMap;
        this.stops = arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v2, resolved type: java.util.HashMap<java.lang.String, java.util.ArrayList<zophop.models.preproccessing.RoadConnection>> */
    /* JADX WARN: Multi-variable type inference failed */
    public static HashMap<String, ArrayList<RoadConnection>> getRoadEdge(Data data2, oo6 oo6, int i) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(i, new ThreadFactoryBuilder().setNameFormat("pre-processed-road-edge-%d").setDaemon(true).build());
        HashMap hashMap = new HashMap();
        int i2 = 0;
        for (Stop stop : data2.getAllStops()) {
            if (hashMap.containsKey(Integer.valueOf(i2))) {
                arrayList = (ArrayList) hashMap.get(Integer.valueOf(i2));
            } else {
                arrayList = new ArrayList();
            }
            arrayList.add(stop);
            hashMap.put(Integer.valueOf(i2), arrayList);
            i2 = (i2 + 1) % i;
        }
        ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 < i; i3++) {
            HashMap hashMap2 = new HashMap();
            arrayList2.add(hashMap2);
            arrayList3.add(newFixedThreadPool.submit(new PreProcessRoadEdge(i3, data2, hashMap2, (ArrayList) hashMap.get(Integer.valueOf(i3)))));
        }
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            try {
                System.out.println(((Future) it.next()).get());
            } catch (ExecutionException e) {
                try {
                    e.printStackTrace();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        newFixedThreadPool.shutdown();
        try {
            newFixedThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e3) {
            System.out.println(e3.toString());
        }
        HashMap<String, ArrayList<RoadConnection>> hashMap3 = new HashMap<>();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            for (Map.Entry entry : ((HashMap) it2.next()).entrySet()) {
                hashMap3.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap3;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        ro6 ro6 = new ro6();
        Iterator<Stop> it = this.stops.iterator();
        while (it.hasNext()) {
            Stop next = it.next();
            double stop_lat = next.getStop_lat();
            double stop_lon = next.getStop_lon();
            Data data2 = this.data;
            qo6 qo6 = new qo6(ro6);
            Iterable<Stop> allStops = data2.getAllStops();
            ArrayList arrayList = new ArrayList();
            for (Stop stop : allStops) {
                ArrayList<String> arrayList2 = stop.owners;
                if (arrayList2 == null || arrayList2.contains(SettingsJsonConstants.APP_KEY)) {
                    Double valueOf = Double.valueOf(oo6.a(stop_lat, stop_lon, stop.getStop_lat(), stop.getStop_lon()));
                    if (valueOf.doubleValue() <= 2000.0d) {
                        if (!valueOf.isNaN()) {
                            arrayList.add(new SpatialRecord(stop, valueOf.doubleValue()));
                        } else {
                            throw new Exception();
                        }
                    }
                    qo6 = qo6;
                    arrayList = arrayList;
                    ro6 = ro6;
                    it = it;
                }
            }
            Collections.sort(arrayList, qo6);
            ArrayList<RoadConnection> arrayList3 = new ArrayList<>();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Stop stop2 = ((SpatialRecord) it2.next()).getStop();
                if (!stop2.getStop_id().equals(next.getStop_id())) {
                    next.getStop_lat();
                    next.getStop_lon();
                    stop2.getStop_lat();
                    stop2.getStop_lon();
                    throw null;
                }
            }
            this.map.put(next.getStop_id(), arrayList3);
            ro6 = ro6;
            it = it;
        }
        System.out.println("Count : 0");
        return null;
    }
}
