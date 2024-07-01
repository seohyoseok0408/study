# (3<= n)

n = int(input())

if n % 5 == 0: # 5로 나눠 떨어지는 경우가 가장 적은 봉지 개수
  print(n//5)
else: # 5로 나눠떨어지지 않는 경우   -> 3으로 나눠지거나 둘다 안되는 경우가 있다
  p = 0 # 필요한 봉투개수
  while n > 0: 
    n -= 3  
    p += 1 
    if n % 5 == 0:
      p += n // 5
      print(p)
      break
    elif n == 1 or n == 2:
      print (-1)
      break
    elif n == 0:
      print(p)
      break
    