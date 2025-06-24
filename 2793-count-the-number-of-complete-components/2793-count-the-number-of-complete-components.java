class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build adjacency list
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        int completeComponents = 0;
        
        // Traverse each unvisited node
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Set<Integer> nodes = new HashSet<>();
                int edgeCount = dfs(graph, visited, i, nodes);
                
                // Check if component is complete
                int size = nodes.size();
                if (edgeCount / 2 == size * (size - 1) / 2) {
                    completeComponents++;
                }
            }
        }
        
        return completeComponents;
    }

    // DFS to explore the connected component
    private int dfs(List<List<Integer>> graph, boolean[] visited, int node, Set<Integer> nodes) {
        visited[node] = true;
        nodes.add(node);
        int edgeCount = 0;
        
        for (int neighbor : graph.get(node)) {
            edgeCount++;
            if (!visited[neighbor]) {
                edgeCount += dfs(graph, visited, neighbor, nodes);
            }
        }
        
        return edgeCount;
    }
}