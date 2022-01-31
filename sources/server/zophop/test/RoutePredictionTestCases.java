package server.zophop.test;

import com.firebase.client.DataSnapshot;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import server.zophop.GpsAnalytics.Agency;
import server.zophop.GpsAnalytics.RoutePrediction;
import server.zophop.dataLayer.Firebase.FirebaseUtils;
import server.zophop.logging.LoggingConstants;
import server.zophop.logicLayer.DataContainer;
import server.zophop.models.FirebaseRef;
import server.zophop.models.Route;

public class RoutePredictionTestCases {
    private static DataContainer _container = null;
    private static Agency agency = Agency.mctsl;
    private static Map<String, String> vehiclesMap = new HashMap();

    private void initializeVehicles() {
        for (DataSnapshot dataSnapshot : FirebaseUtils.getSynchronizedDataSnapshot(FirebaseRef.getInstance().getVehiclesRef(agency.getCity()).child(agency.getCity().toLowerCase()).child("bus1").child(agency.getAgency().toLowerCase()).child("dispatch")).getChildren()) {
            if (((Boolean) ((Map) dataSnapshot.getValue()).get("checkedIn")).booleanValue()) {
                vehiclesMap.put(dataSnapshot.getKey(), (String) ((Map) dataSnapshot.getValue()).get(LoggingConstants.ROUTE_ID));
            } else {
                System.out.println("do nothing");
            }
        }
    }

    @Before
    public void initialize() throws UnirestException {
        initializeVehicles();
        _container = DataContainer.getDataContainer();
    }

    @Test
    public void predictRoute() throws Exception {
        boolean z;
        RoutePrediction routePrediction = new RoutePrediction();
        vehiclesMap.size();
        new HashMap();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (String str : vehiclesMap.keySet()) {
            String str2 = vehiclesMap.get(str);
            Route execute = routePrediction.execute(agency.getCity(), agency.getAgency(), "bus", str);
            ArrayList arrayList = new ArrayList();
            arrayList.add(execute);
            boolean z2 = true;
            if (arrayList.size() == 0) {
                System.out.println("not predictable");
                i++;
            } else if (arrayList.size() == 1) {
                Iterator it = arrayList.iterator();
                boolean z3 = false;
                boolean z4 = false;
                while (it.hasNext()) {
                    if (((Route) it.next()).getId().equalsIgnoreCase(str2)) {
                        System.out.println("route Matching");
                        i2++;
                        z3 = true;
                        z4 = true;
                    }
                }
                if (!z3) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        if (((Route) it2.next()).getReverseRouteId().equalsIgnoreCase(str2)) {
                            System.out.println(" reverse route matching");
                            i3++;
                            z4 = true;
                        }
                    }
                }
                z2 = z4;
            } else {
                if (arrayList.size() <= 3) {
                    Iterator it3 = arrayList.iterator();
                    z = false;
                    while (it3.hasNext()) {
                        Route route = (Route) it3.next();
                        if (route.getReverseRouteId().equalsIgnoreCase(str2) || route.getId().equalsIgnoreCase(str2)) {
                            i5++;
                            z = true;
                        }
                    }
                } else {
                    Iterator it4 = arrayList.iterator();
                    z = false;
                    while (it4.hasNext()) {
                        Route route2 = (Route) it4.next();
                        if (route2.getReverseRouteId().equalsIgnoreCase(str2) || route2.getId().equalsIgnoreCase(str2)) {
                            i6++;
                            z = true;
                        }
                    }
                }
                z2 = z;
            }
            if (!z2) {
                i4++;
                System.out.println("route not matching :(");
            }
            PrintStream printStream = System.out;
            printStream.println("matching count : " + i2);
            PrintStream printStream2 = System.out;
            printStream2.println("reverse matching count  " + i3);
            PrintStream printStream3 = System.out;
            printStream3.println("predictable count  " + i5);
            PrintStream printStream4 = System.out;
            printStream4.println("predictable but difficult count  " + i6);
            PrintStream printStream5 = System.out;
            printStream5.println("non predictedble count " + i);
            PrintStream printStream6 = System.out;
            printStream6.println("not matching count " + i4);
        }
    }
}
