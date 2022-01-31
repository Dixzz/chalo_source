package zophop.models.preproccessing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class PreProcessedDbObject implements Serializable {
    private static final long serialVersionUID = 1;
    public String id;
    public ArrayList<PreProcessedRoute> routes = new ArrayList<>();

    public static PreProcessedDbObject deserialize(String str) throws ClassNotFoundException, IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        PreProcessedDbObject preProcessedDbObject = (PreProcessedDbObject) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return preProcessedDbObject;
    }

    public static void serialize(PreProcessedDbObject preProcessedDbObject, String str) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(preProcessedDbObject);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public PreProcessedDbObject cloneWithOutVisitedStopsAndRoutes() {
        PreProcessedDbObject preProcessedDbObject = new PreProcessedDbObject();
        preProcessedDbObject.id = this.id;
        Iterator<PreProcessedRoute> it = this.routes.iterator();
        while (it.hasNext()) {
            PreProcessedRoute preProcessedRoute = new PreProcessedRoute();
            Iterator<LegTuple> it2 = it.next().legs.iterator();
            while (it2.hasNext()) {
                preProcessedRoute.legs.add(it2.next());
            }
            preProcessedDbObject.routes.add(preProcessedRoute);
        }
        return preProcessedDbObject;
    }
}
