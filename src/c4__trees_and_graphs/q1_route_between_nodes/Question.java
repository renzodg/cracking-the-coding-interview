package c4__trees_and_graphs.q1_route_between_nodes;

import java.util.LinkedList;
import java.util.Queue;

public class Question {
	public static void main(String a[]) {
		Graph g = createNewGraph();
		Node[] n = g.getNodes();
		Node start = n[0]; // Node("d")
		Node end = n[5]; // Node("f")
		boolean result = routeBetweenNodes(g, start, end);
		System.out.println(result);
	}

	public static Graph createNewGraph() {
		Graph g = new Graph();
		Node[] vertices = new Node[6];

		vertices[0] = new Node("a", 3);
		vertices[1] = new Node("b", 0);
		vertices[2] = new Node("c", 0);
		vertices[3] = new Node("d", 1);
		vertices[4] = new Node("e", 1);
		vertices[5] = new Node("f", 0);

		vertices[0].addAdjacent(vertices[1]);
		vertices[0].addAdjacent(vertices[2]);
		vertices[0].addAdjacent(vertices[3]);
		vertices[3].addAdjacent(vertices[4]);
		vertices[4].addAdjacent(vertices[5]);
		for (int i = 0; i < 6; i++) {
			g.addNode(vertices[i]);
		}
		return g;
	}

	public static boolean routeBetweenNodes(Graph g, Node start, Node end) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(start);
		
		while (!queue.isEmpty()) {
			Node current = queue.remove();
			for (Node neighboor : current.getAdjacent()) {
				if (neighboor.visited) {
					continue;
				}

				if (neighboor == end) {
					return true;
				}

				queue.add(neighboor);
			}
			current.visited = true;
		}
		return false;
	}
}