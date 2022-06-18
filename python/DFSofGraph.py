class Solution:
    #Function to return a list containing the DFS traversal of the graph.
    def dfs(self, start, adj):
        if start in self.visited:
            return
        self.visited.append(start)

        for i in adj[start]:
            self.dfs(i, adj)
            
    
    def dfsOfGraph(self, V, adj):
        self.visited = []
        self.dfs(0, adj)
        return list(self.visited)
    

#{ 
#  Driver Code Starts
if __name__ == '__main__':
    T=int(input())
    for i in range(T):
        V, E = map(int, input().split())
        adj = [[] for i in range(V)]
        for _ in range(E):
            u, v = map(int, input().split())
            adj[u].append(v)
            adj[v].append(u)
        ob = Solution()
        ans = ob.dfsOfGraph(V, adj)
        for i in range(len(ans)):
            print(ans[i], end = " ")
        print()
        

# } Driver Code Ends
# input
# 2
# 5 4
# 0 1
# 0 2
# 0 4
# 4 3
# 4 3
# 0 1
# 1 2
# 0 3
