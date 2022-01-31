package zophop.models;

import java.util.HashMap;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public class GraphDatabaseBundle {
    public GraphDatabaseService graphDb;
    public HashMap<String, Node> offboardMap = new HashMap<>();
    public HashMap<String, Node> onboardMap = new HashMap<>();
}
