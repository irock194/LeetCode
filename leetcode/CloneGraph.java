package leetcode;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/problems/clone-graph/

public class CloneGraph {
	
	//O(n)
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        HashSet<Node> visited = new HashSet<Node>();
        HashMap<Integer, Node> newNodes = new HashMap<Integer, Node>();
        DFS(node, visited, newNodes);
        visited.clear();
        createGraph(node, visited, newNodes);
        return newNodes.get(1);
    }
    
    void DFS(Node node, HashSet<Node> visited, HashMap<Integer, Node> newNodes){
        if(visited.contains(node)){
            return;
        }
        newNodes.put(node.val, new Node(node.val));
        visited.add(node);
        for(Node currentNode : node.neighbors){
            DFS(currentNode, visited, newNodes);
        }
        return;
    }
    
    void createGraph(Node node, HashSet<Node> visited, HashMap<Integer, Node> newNodes){
        if(visited.contains(node)){
            return;
        }
        visited.add(node);
        Node addEdgesToNode = newNodes.get(node.val);
        for(Node nodesToAdd : node.neighbors){
            addEdgesToNode.neighbors.add(newNodes.get(nodesToAdd.val));
        }
        for(Node currentNode : node.neighbors){
            createGraph(currentNode, visited, newNodes);
        }
        return;
    }
    
    //single traverse O(n)
//    public Node cloneGraph(Node node) {
//        if(node == null){
//            return null;
//        }
//        HashMap<Integer, Node> newNodes = new HashMap<Integer, Node>();
//        return DFS(node, newNodes);
//    }
//    
//    Node DFS(Node node, HashMap<Integer, Node> newNodes){
//        if(newNodes.containsKey(node.val)){
//            return newNodes.get(node.val);
//        }
//        Node newNode = new Node(node.val);
//        newNodes.put(node.val, newNode);
//        for(Node currentNode : node.neighbors){
//            if(newNodes.containsKey(currentNode.val)){
//                newNode.neighbors.add(newNodes.get(currentNode.val));
//                continue;
//            }
//            newNode.neighbors.add(DFS(currentNode, newNodes));
//        }
//        return newNode;
//    }

}
