package zophop.models.graph;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Graph implements Serializable {
    private HashMap<Label, ArrayList<Node>> nodeLabels = new HashMap<>();

    public static Graph deserialize(String str) throws ClassNotFoundException, IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Graph graph = (Graph) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return graph;
    }

    public static void serialize(Graph graph, String str) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(graph);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public Node createNode(Label label) {
        ArrayList<Node> arrayList;
        Node node = new Node(label);
        if (this.nodeLabels.containsKey(label)) {
            arrayList = this.nodeLabels.get(label);
        } else {
            arrayList = new ArrayList<>();
        }
        arrayList.add(node);
        this.nodeLabels.put(label, arrayList);
        return node;
    }

    public ArrayList<Node> getNodesWithLabel(Label label) {
        return this.nodeLabels.get(label);
    }
}
