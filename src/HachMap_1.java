import java.util.Arrays;

import static java.util.Objects.hash;

public class HachMap_1 {

    private static final int NUMBER = 17;
    private Node[] nodes;
    private int size;

    private static class Node {
        private Integer key;
        private Integer value;
        private Node node_1;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.node_1 = null;
        }
    }

    public HachMap_1(){
        nodes = new Node[NUMBER];
        size = 0;
    }

    public Object put(Integer key, Integer value){
        int index = hash(key);
        if(nodes[index] == null){
            nodes[index] = new Node(key, value);
            size++;
            return null;
        }

        Node node = nodes[index];
        while ( node != null){
            if(node.key.equals(key)){
                Object value_1 = node.value;
                node.value = value;

                return value_1;
            }
            node = node.node_1;
        }
        Node nNode = new Node(key,value);
        nNode.node_1 = nodes[index];
        nodes[index] = nNode;
        size++;
        return null;
    }
    public Object get(Integer key){
        int index = hash(key);
        Node node = nodes[index];
        while (node != null){
            if(node.key.equals(key)){
                return node.value;
            }
            node = node.node_1;
        }
        return null;
    }

    public Object remove(Integer key) {
        int index = hash(key);
        Node node = nodes[index];
        Node n = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (n == null) {
                    nodes[index] = node.node_1;
                } else {
                    n.node_1 = node.node_1;
                }
                size--;
                return node.value;
            }
            n = node;
            node = node.node_1;
        }
        return null;
    }
    public Object replace(Integer key, Integer value) {
        int index = hash(key);
        Node node = nodes[index];
        while (node != null) {
            if (node.key.equals(key)) {
                Object value1 = node.value;
                node.value = value;
                return value1;
            }
            node = node.node_1;
        }
        return null;
    }

    public int size() {
        return size;
    }
    public boolean containsKey(Integer key) {
        int index = hash(key);
        Node node = nodes[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return true;
            }
            node = node.node_1;
        }
        return false;
    }

    public boolean containsValue(Integer value) {
        for (int i = 0; i < nodes.length; i++) {
            Node node = nodes[i];
            while (node != null) {
                if (node.value.equals(value)) {
                    return true;
                }
                node = node.node_1;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "HachMap_1{" +
                "nodes=" + Arrays.toString(nodes) +
                ", size=" + size +
                '}';
    }
}
