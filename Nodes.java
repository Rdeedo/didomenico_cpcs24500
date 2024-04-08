package a6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import a6.NodeFactory;

public class Nodes {
	
	private ArrayList<Node> nodes;

	public Nodes() {
		nodes = new ArrayList<Node>();
	}
	
	public void fill(int size) throws Exception {
		Random r = new Random();
		for (int i = 0; i < size; i++) {			
			if (r.nextDouble(1) > .5) {
				ThreeDNode node = NodeFactory.getThreeDNode();
				nodes.add(node);
			} else {
				Node node = NodeFactory.getNode();
				nodes.add(node);
			}
		}
	}
	
	public void clear() {
		if (nodes.size() != 0) {
			for (int i = nodes.size(); i >= 0; i--) {
				nodes.remove(i);
			}
		}
	}
	
	public int countNodes() {
		int n = countThreeDNodes();
		return nodes.size() - n;
	}
	
	public int countThreeDNodes() {
		int n = 0;
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i) instanceof ThreeDNode) {
				n++;
			} 
		}
		return n;
	}
	
	public void sort() {
		Collections.sort(nodes, new Sorter());
	}
	
	public String toString() {
		String list = "";
		for (int i = 0; i < nodes.size(); i++) {
			list += nodes.get(i) + "\n";
		}
		return list;
	}
	
	public static void main(String[] args) throws Exception {
		Nodes nodes = new Nodes();
		nodes.fill(10);
		System.out.println(nodes);
		nodes.sort();
		System.out.println(nodes);
	}
}

class Sorter implements Comparator<Node>{
	
	@Override
	public int compare(Node a, Node b) {
        int sum1 = a.getX() + a.getY();
        int sum2 = b.getX() + b.getY();
        if (a instanceof ThreeDNode && b instanceof ThreeDNode) {
            ThreeDNode threeDNode1 = (ThreeDNode) a;
            ThreeDNode threeDNode2 = (ThreeDNode) b;
            sum1 += threeDNode1.getZ();
            sum2 += threeDNode2.getZ();
        }
        return Integer.compare(sum1, sum2);
	}
}