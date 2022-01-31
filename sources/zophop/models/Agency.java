package zophop.models;

import java.io.BufferedReader;
import java.io.Serializable;
import java.util.HashMap;

public class Agency implements Serializable {
    private static final long serialVersionUID = 1;
    public String agency_id;
    public String agency_name;
    public String feed_id;
    public String transport_type;

    public static HashMap<String, String> getAgencyMap(String str) throws Exception {
        BufferedReader p = ec6.p(str);
        HashMap<String, Integer> q = ec6.q(p.readLine());
        HashMap<String, String> hashMap = new HashMap<>();
        while (true) {
            String readLine = p.readLine();
            if (readLine != null) {
                String[] split = readLine.split(",", -1);
                hashMap.put(split[q.get("agency_id").intValue()], split[q.get("agency_name").intValue()]);
            } else {
                p.close();
                return hashMap;
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Agency)) {
            return false;
        }
        Agency agency = (Agency) obj;
        if (agency.agency_id.equals(this.agency_id) && agency.transport_type.equals(this.transport_type)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.agency_id.hashCode();
    }
}
