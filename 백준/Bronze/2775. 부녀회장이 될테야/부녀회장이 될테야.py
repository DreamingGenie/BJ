def apart(a,b,board):
    people=0
    if board[b][a]!=0:
        return board[b][a]
    if a==0:
        for i in range(1,b+1):
            people=i
    else:
        for i in range(1,b+1):
            people+=apart(a-1,i,board)
    board[b][a]=people
    return people
T=int(input())
for test_case in range(1,T+1):
    a=int(input())
    b=int(input())
    board=[[0 for _ in range(a+1)]for _ in range(b+1)]
    print(apart(a,b,board))