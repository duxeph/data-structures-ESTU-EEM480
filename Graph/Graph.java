/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph;

import HashMap.HashMap;
import HashMap.HashNode;
import LinkedList.LinkedList;
import Queue.Queue;

/**
 *
 * @author kagan
 */
public class Graph {
    private HashMap<HashMap<Double>> map = new HashMap<>();
    
    // node
    public void addVertex(String s) {
        map.add(s);
    }
    
    public void traverse(String startVertex) {
        LinkedList<String> visitList = new LinkedList<>();
        
        String key;
        HashNode<String, HashMap<Double>> temp;
        
        HashMap<Double> colors = new HashMap<>();
        for(int i=0; i<map.load; i++) {
            colors.add(map.getKeys().Peek(i));
        }
        Queue<HashNode<String, HashMap<Double>>> vertices = new Queue<>();
        vertices.enqueue(map.searchFor(startVertex));
        
        while(!vertices.isEmpty()) {
            temp = vertices.dequeue();
            visitList.Insert(temp.key, visitList.size);
            colors.changeFor(temp.key, 0.);
            
            if(temp.value!=null) {
                for(int i=0; i<temp.value.load; i++) {
                    key = temp.value.getKeys().Peek(i);
                    System.out.println("from "+temp.key+" to "+key+" for "+temp.value.searchFor(key).value);

                    if(colors.searchFor(key).value==null) {
                        vertices.enqueue(map.searchFor(key));
                    }
                }
            }
        }
        System.out.println(visitList.toString());
    }
    
    // height
    public void addEdge(String source, String destination, Integer weight) {
        addEdge(source, destination, Double.valueOf(weight));
    }
    public void addEdge(String source, String destination, Double weight) {
        if(map.searchFor(source)==null)
            addVertex(source);
        
        HashMap<Double> temp = map.searchFor(source).value;
        if(temp == null)
            temp = new HashMap<>();
        temp.add(destination);
        temp.changeFor(destination, weight);
        
        map.changeFor(source, temp);
    }
    public void setWeight(String source, String destination, Double weight) {
        HashMap<Double> temp = map.searchFor(source).value, temp2 = map.searchFor(destination).value;
        if(temp==null || temp.searchFor(destination)==null)
            return;
        if(temp2.searchFor(source)!=null) {
            temp2 = map.searchFor(source).value;
            temp2.changeFor(source, weight);
            map.changeFor(destination, temp2);
        }
        temp = map.searchFor(destination).value;
        temp.changeFor(destination, weight);
        map.changeFor(source, temp);
    }
    
    public void print() {
        String dest_key;
        LinkedList<String> vertexkeys = map.getKeys(), vertexedge;
        for(int i=0; i<vertexkeys.size; i++) {
            String vertex = vertexkeys.Peek(i);
            if(map.searchFor(vertex).value==null)
                continue;
            vertexedge = map.searchFor(vertex).value.getKeys();
            for(int j=0; j<vertexedge.size; j++) {
                String edge = vertexedge.Peek(j);
                dest_key = map.searchFor(vertex).value.searchFor(edge).key;
                System.out.println(
                        vertex+" -["+map.searchFor(vertex).value.searchFor(edge).value+"]-> "+dest_key);
                        // "source vertex: "+vertex+
                        // ", destination vertex: "+dest_key+
                        // ", edge weight: "+map.searchFor(vertex).value.searchFor(edge).value);
            }
        }
    }
}
