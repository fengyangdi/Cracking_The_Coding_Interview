import java.util.*;

/*
public class UndirectedGraphNode {
    int label = 0;
    UndirectedGraphNode left = null;
    UndirectedGraphNode right = null;
    ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

    public UndirectedGraphNode(int label) {
        this.label = label;
    }
}*/

/**
 * 求解两个节点是否相连
 */
public class Path {
    public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
        return check(a,b) || check(b,a);
    }

    public boolean check(UndirectedGraphNode a, UndirectedGraphNode b) {
        // TODO Auto-generated method stub
        if(a == null || b == null){
            return false;
        }
        if(a == b){
            return true;
        }
        Map<UndirectedGraphNode, Boolean> checkedMap = new HashMap<UndirectedGraphNode, Boolean>();
        LinkedList<UndirectedGraphNode> searchQueue = new LinkedList<UndirectedGraphNode>();
        searchQueue.push(a);
        checkedMap.put(a, true);
        while(!searchQueue.isEmpty()){
            UndirectedGraphNode currentNode = searchQueue.pop();
            if(currentNode.neighbors != null){
                for(int i = 0; i < currentNode.neighbors.size(); i++){
                    UndirectedGraphNode neib = currentNode.neighbors.get(i);
                    if(neib != null){
                        if(neib == b){
                            return true;
                        }
                        if(checkedMap.get(neib) == null || !checkedMap.get(neib)){
                            searchQueue.push(neib);
                            checkedMap.put(neib, true);
                        }
                    }
                }
            }
        }
        return false;
    }
}