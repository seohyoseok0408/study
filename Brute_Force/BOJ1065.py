# 어떤 양의 정수 X의 각 자리가 등차수열을 이루면, 그 수를 한수라고 함
# N이 주어짐 -> 1보다 크거나 같고, N보다 작거나 같은 한수의 개수 출력

n = int(input())
ctn = 0 # 한수의 개수

for i in range(1, n+1): 
  num_list = list(map(int, str(i)))
  if len(num_list) != 1:
    d = set() # 중복X리스트
    for j in range(len(num_list)-1):
      d.add(num_list[j] - num_list[j+1])
    if len(d) == 1: # 등차수열이란 의미
        ctn += 1
  else: # 1~9 경우 - 모두 한수
    ctn += 1
    
print(ctn)