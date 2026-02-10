import sys
input = sys.stdin.readline

n = int(input())

c = [0]*n
bslash = [0]*(2*(n-1)+1)
slash = [0]*(2*(n-1)+1)
cnt = 0

def dfs(k):
    global n, cnt
    if k == n:
        cnt+=1
        return 
    
    for i in range(n):
        if not c[i] and not bslash[k+i] and not slash[(n-1)+k-i]:
            c[i] = 1
            bslash[i+k] =1
            slash[(n-1)+k-i] = 1
            dfs(k+1)
            slash[(n-1)+k-i] = 0
            bslash[i+k] =0
            c[i] = 0

dfs(0)
print(cnt)

            
