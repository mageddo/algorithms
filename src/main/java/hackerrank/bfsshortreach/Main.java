//package hackerrank.bfsshortreach;
//
//import java.util.Deque;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.List;
//
//public class Main {
//
//
//	static class Graph {
//
//		private int vertices;
//		private List<Integer>[] adjacencyList;
//
//		public Graph(int vertices) {
//			this.vertices = vertices;
//			this.adjacencyList = new LinkedList[this.vertices];
//			for (int i = 0; i < this.adjacencyList.length; i++) {
//				this.adjacencyList[i] = new LinkedList<>();
//			}
//		}
//
//		// nova aresta
//		public void addEdge(int vertice, int edge){
//			this.adjacencyList[vertice].add(edge);
//		}
//
//		public int findDistanceTo(final int fromEdge, final int toEdge){
//
//			final boolean[] visited = new boolean[this.vertices];
//			final Deque<Integer> queue = new LinkedList<>();
//			visited[fromEdge] = true;
//			queue.add(fromEdge);
//
//			while(!queue.isEmpty()){
//				final Integer item = queue.poll();
//				Iterator<Integer> verticeEdgesIt = this.adjacencyList[fromEdge].iterator();
//				while(verticeEdgesIt.hasNext()){
//
//					final Integer vertice = verticeEdgesIt.next();
//					if(!visited[vertice]){
//						visited[vertice] = true;
//						queue.add(vertice);
//					}
//
//				}
//			}
//
//		}
//	}
//}
