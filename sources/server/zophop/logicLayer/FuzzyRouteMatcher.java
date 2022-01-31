package server.zophop.logicLayer;

import com.rabbitmq.client.ConnectionFactory;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.xdrop.fuzzywuzzy.FuzzySearch;
import server.zophop.models.Route;

public class FuzzyRouteMatcher {
    public static void main(String[] strArr) {
        System.out.println(new FuzzyRouteMatcher().match("3D/1", null, DataContainer.getDataContainer().getAllBusRoutes("kolkata", "jcbs")).getId());
    }

    private Route matchRoute(List<Route> list, String str) {
        HashMap hashMap = new HashMap();
        for (Route route : list) {
            hashMap.put(route.getLastStop(), route);
        }
        return (Route) hashMap.get(FuzzySearch.extractOne(str, hashMap.keySet()).getString());
    }

    private String matchRouteName(String str, List<String> list) {
        String trimExpression = trimExpression(str);
        System.out.println("atmesh aaaa");
        System.out.println(trimExpression);
        String string = FuzzySearch.extractOne(trimExpression, list).getString();
        PrintStream printStream = System.out;
        printStream.println("expr - " + trimExpression + " and match is " + string);
        return string;
    }

    private String trimExpression(String str) {
        return str.replace("-", "").replaceAll(ConnectionFactory.DEFAULT_VHOST, "");
    }

    public Route match(String str, String str2, Map<String, List<Route>> map) {
        System.out.println(map.keySet());
        List<Route> list = map.get(matchRouteName(str, new ArrayList(map.keySet())));
        if (str2 == null) {
            return list.get(0);
        }
        Route matchRoute = matchRoute(list, str2);
        PrintStream printStream = System.out;
        StringBuilder i0 = hj1.i0("ID ");
        i0.append(matchRoute.getId());
        i0.append(" Name ");
        i0.append(matchRoute.getName());
        i0.append("LastStop ");
        i0.append(matchRoute.getLastStop());
        printStream.println(i0.toString());
        return matchRoute;
    }
}
