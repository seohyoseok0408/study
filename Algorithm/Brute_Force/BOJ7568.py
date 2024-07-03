# 55 185
# 58 183
# 88 186
# 60 175
# 46 155

# 2 2 1 2 5

# N명의 집단에서 각 사람의 덩치 등수는 자신보다 더 "큰 덩치"의 사람의 수로 정해진다.
# 만일 자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1이 된다. 
# 이렇게 등수를 결정하면 같은 덩치 등수를 가진 사람은 여러 명도 가능하다. 


n = int(input())

list = []
rank = []

for i in range(n):
  h, w = map(int, input().split())

  list.append([h,w])


for i in list: #첫 번째 사람 기준 55 185
  k = 0
  for j in list: #한사람 기준 잡고 모든 인원 다 돌림
    if i!=j: # 55 185 == 55 185 인 경우는 제외 (나와 나, or 나랑 같은 놈)
      if j[0] > i[0]:
        if j[1] > i[1]:
          k += 1
  rank.append(k+1)

for i in rank:
  print(i, end=" ")