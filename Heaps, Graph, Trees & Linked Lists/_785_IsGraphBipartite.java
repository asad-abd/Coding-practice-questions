//not my code.
//this is the code that I debugged for another user.
class _785_IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        return isBipartiteCheck(graph);
    }

    public boolean isBipartiteCheck(int[][] graph) {
        // colors
        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }

        // check for all vertices
        for (int v = 0; v < n; v++) {
            if (color[v] == -1) {
                if (isBipartiteUtil(graph, color, v) == false)
                    return false;
            }
        }

        return true;
    }

    public boolean isBipartiteUtil(int[][] graph, int[] color, int src) {

        color[src] = 1;

        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : graph[u]) {

                if (color[v] == -1) {
                    color[v] = 1 - color[u];
                    q.offer(v);
                } else if (color[v] == color[u]) {
                    return false;
                }

            }
        }

        return true;
    }
}
