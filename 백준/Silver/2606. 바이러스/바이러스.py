def search(graph,visited,node):
    visited[node] = True
    for i in graph[node]:
        if visited[i]==False:
            search(graph,visited,i)
            #visited[i]=False
    return

N=int(input())
Line=int(input())
graph=[[]for _ in range(N+1)]
for i in range(Line):
    u,v =map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)

visited=[False]*(N+1)
search(graph,visited,1)
#print(visited)
print(visited.count(True)-1)