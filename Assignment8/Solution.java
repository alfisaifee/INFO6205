import java.util.*;

public class Solution {

    //1) Dijkstra's Algorithm for shortest path
    //solution in Graph class.
    /*---------------------------------------------------------------------------------------------------------*/


    //2) Course Schedule
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<prerequisites.length; i++){
            if(!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1], new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; ++i){
            if(hasCycle(i, visiting, visited, map)){
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int course, Set<Integer> visiting, Set<Integer> visited,
                             Map<Integer, List<Integer>> map){
        visiting.add(course);
        if(map.get(course) != null) {
            for (int nextCourse : map.get(course)) {
                if (visited.contains(nextCourse))
                    continue;
                if (visiting.contains(nextCourse))
                    return true;
                if (hasCycle(nextCourse, visiting, visited, map))
                    return true;
            }
        }
        visiting.remove(course);
        visited.add(course);
        return false;
    }

    /*---------------------------------------------------------------------------------------------------------*/

    //3) Word Ladder
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return 0;
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        int len = 0;

        while(!queue.isEmpty()){
            len++;
            int size = queue.size();
            for(int i=0; i<size; i++){
                String currWord = queue.remove();
                char[] curr = currWord.toCharArray();
                for(int j=0; j<curr.length; j++){
                    for(char k = 'a'; k<= 'z'; k++){
                        curr[j] = k;
                        String temp = new String(curr);
                        if(set.contains(temp)){
                            queue.add(temp);
                            set.remove(temp);
                        }
                        if(temp.equals(endWord)){
                            return ++len;
                        }
                    }
                    curr[j] = currWord.charAt(j);
                }
            }
        }
        return 0;
    }

    /*---------------------------------------------------------------------------------------------------------*/

    //4) Number of Islands
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int numIslands = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0')
            return;
        grid[row][col] = '0';
        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
    }

    /*------------------------------------------------Test Cases----------------------------------------------------------*/


    public static void main(String[] args){
        Solution sol = new Solution();

        System.out.println("\nQuestion 1 - Test Case");
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addEdges("A","B", 3);
        graph.addEdges("A","D", 2);
        graph.addEdges("A","C", 4);
        graph.addEdges("B","E", 1);
        graph.addEdges("D","E", 5);
        graph.addEdges("B","D", 6);
        graph.addEdges("C","D", 1);
        graph.printAllShortestPaths("A");

        System.out.println("\nQuestion 2 - Test Case");
        int[][] prerequisites = {{1,4},{2,4},{3,1},{3,2}};
        int[][] prerequisites2 = {{1,0},{2,1},{2,3},{3,2}};
        System.out.println("Can Finish : " + sol.canFinish(5, prerequisites));
        System.out.println("Can Finish : " + sol.canFinish(4, prerequisites2));

        System.out.println("\nQuestion 3 - Test Case");
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println("Ladder Length : " + sol.ladderLength("hit", "cog", wordList));

        System.out.println("\nQuestion 4 - Test Case");
        char[][] grid = {{'1','1','0','1','1'},
                         {'1','1','0','0','1'},
                         {'0','0','1','0','0'},
                         {'1','0','0','1','1'}};
        System.out.println("Number of Islands : " + sol.numIslands(grid));
    }
}
