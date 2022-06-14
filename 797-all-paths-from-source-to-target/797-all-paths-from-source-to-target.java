class Solution {
    List<List<Integer>>result = new ArrayList<List<Integer>>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;ArrayList<Integer>li = new ArrayList<>();
        li.add(0);
        dfs(0,graph,n,li);
        return result;
        
    }
    private void dfs(int curr,int[][] graph,int n,ArrayList<Integer>li)
    {
        if(curr==n-1)
        {
            result.add(new ArrayList<>(li));
            return;
        }
        for(int i=0;i<graph[curr].length;i++)
        {
            li.add(graph[curr][i]);
            dfs(graph[curr][i],graph,n,li);
            li.remove(li.size()-1); 
        } 
    }
}