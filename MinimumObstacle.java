import java.util.PriorityQueue;

class Pair{
    int x;
    int y;
    int cost;
    public Pair(int x,int y,int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}

public class MinimumObstacle {
    int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost,b.cost));
        boolean vis[][] = new boolean[m][n];
        pq.add(new Pair(0,0,0));
        vis[0][0] = true;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int x = curr.x;
            int y = curr.y;
            int cost = curr.cost;
            if(x == m-1 && y == n-1)  return cost;
            for(int i=0;i<4;i++){
                int new_x = x + dir[i][0];
                int new_y = y + dir[i][1];
                if(new_x < m && new_x >=0 && new_y < n && new_y >= 0 && !vis[new_x][new_y]){
                    vis[new_x][new_y] = true;
                    if(grid[new_x][new_y] == 1) pq.add(new Pair(new_x,new_y,cost+1));
                    else pq.add(new Pair(new_x,new_y,cost));
                }
            }
        }
        return 0;
    }
}
