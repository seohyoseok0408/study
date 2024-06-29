# 도시의 크기 n*n
# m : 수익을 많이 낼 수 있는 치킨집의 개수
# 도시 정보 : 0빈칸, 1집, 2치킨집

from itertools import combinations

N, M = map(int, input().split())
city = [list(map(int, input().split())) for _ in range(N)]

house = [] 
chicken = []

for r in range(N):
  for c in range(N):
    if city[r][c] == 1:
      house.append([r, c]) # 집들 좌표
    elif city[r][c] == 2:
      chicken.append([r, c]) # 치킨집들 좌표

result = 1e9
for i in combinations(chicken, M): # 치킨집 여러개 중 M개 조합한 경우들
  city_dist = 0
  for h in house: # 전체집 순회
    house_dist = 1e9 
    for k in i: # 집별로 치킨집 순회
      house_dist = min(house_dist, abs(h[0]-k[0])+abs(h[1]-k[1])) # 집에서 치킨집 최소인 거리
    city_dist += house_dist # 도시치킨거리 += 집에서 가장 가까운 치킨집 거리
  result = min(result, city_dist) # 치킨집 M개 조합마다 도시치킨거리들 중 최소

print(result)