package zophop.models.preproccessing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class PreProcessedIndex implements Serializable {
    public HashMap<String, HashMap<String, ArrayList<PreProcessedRoute>>> index = new HashMap<>();

    public static PreProcessedIndex deserialize(String str) throws ClassNotFoundException, IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        PreProcessedIndex preProcessedIndex = (PreProcessedIndex) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return preProcessedIndex;
    }

    public static void serialize(PreProcessedIndex preProcessedIndex, String str) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(preProcessedIndex);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}
