class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int m=roads.length;
        HashMap<Integer,Integer>NodeToConnections = new HashMap<>();
        for(int i=0;i<m;i++)
        {
            int a=roads[i][0];
            int b=roads[i][1];
            if(NodeToConnections.containsKey(roads[i][0]))
                NodeToConnections.put(a,NodeToConnections.get(roads[i][0])+1);
            else
                NodeToConnections.put(a,1);
            if(NodeToConnections.containsKey(roads[i][1]))
                NodeToConnections.put(b,NodeToConnections.get(roads[i][1])+1);
            else
                NodeToConnections.put(b,1);
        }
        int ConnectionsToNodes[][]= new int[n][2]; int k=0;
        for(Integer Key:NodeToConnections.keySet())
        {
            ConnectionsToNodes[k][0]=NodeToConnections.get(Key);
            ConnectionsToNodes[k][1]=Key;
            k++;
        }
        Arrays.sort(ConnectionsToNodes, Comparator.comparingInt(a -> a[0]));
        // for(int i=0;i<ConnectionsToNodes.length;i++)
        //     System.out.println(ConnectionsToNodes[i][0]+" "+ConnectionsToNodes[i][1]);
        HashMap<Integer,Integer>mapping= new HashMap<>(); int score=1;
        for(int i=0;i<ConnectionsToNodes.length;i++)
        {     
            mapping.put(ConnectionsToNodes[i][1],score); score++;}
        long maxScore=0;
        for(int i=0;i<m;i++)
        {
            int a=roads[i][0];
            int b=roads[i][1];
            maxScore+=mapping.get(a);
            maxScore+=mapping.get(b);
        }
        return maxScore;
    }
}