'''
dfs + 백트래킹
3시간
'''

import sys
input = sys.stdin.readline

n,m = map(int, input().split())
graph = []
for _ in range(n):
    arr = list(input().rstrip())
    graph.append(arr)

'''
지나온 알파벳을 표시하기 위한 배열 만들기
그리고 다음 칸으로 갈때 그 배열에 해당 알파벳이 이미 있다면 못지나감

depth를 설정하고 그 depth의 최대값 구하기
'''

dx = [0,1,0,-1]
dy = [1,0,-1,0]

depth = 1
max_depth = 0
visited = [0]*26

def dfs(x,y,depth):
    global max_depth
    max_depth = max(max_depth, depth)
    for k in range(4):
        nx = x +dx[k]
        ny = y +dy[k]
        if 0<=nx<n and 0<=ny<m and visited[ord(graph[nx][ny])-65] == 0:
            visited[ord(graph[nx][ny])-65] = 1
            max_depth = max(depth+1,max_depth)
            dfs(nx,ny,depth+1)
            visited[ord(graph[nx][ny])-65] = 0
   
    return max_depth

'''
문제는 한칸 뒤로 빽했을때 이미 알파벳에 그 문자가 들어가있을 수 있다는 것 
알파벳에 변동을 줘야함 
그럼 visited처리 어케 해줘야하지?
'''

visited[ord(graph[0][0])-65] = 1
ans = dfs(0,0,depth)
print(ans)