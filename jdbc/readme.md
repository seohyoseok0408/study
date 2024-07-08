


<p align="center"><img width="700" alt="내장객체" src="https://github.com/seohyoseok0408/study/assets/73714589/23696ff0-90b2-46a6-8d26-f6fcceeb21f8">  

- Oracle과 MS SQL의 기능은 같지만, 함수들도 다를 수 있다.
- SQL이 동일한 코드라고 해도, DB에 연결하기 위한 API 자체에 차이가 있기 때문에 Oracle에 연결했다가 MS SQL로 연결하려고 하면, 함수명이 달라서 다 고쳐야하는 번거로움 발생.
- 똑같은 문장의 SQL문을 실행하더라도, 데이터베이스에 연결하기 위한 내용의 차이 때문에 특정 DBMS가 갖고 있는 기능을 알고있어야 한다. -> 번거로움.
- 그래서 등장한게 JDBC


<p align="center"><img width="700" alt="내장객체" src="https://github.com/seohyoseok0408/study/assets/73714589/c8afc1c6-d476-4989-9b27-e747c0ea4cdc"> 

- Oracle을 접속하기 위한 도구들을 어플리케이션을 만드는 사람들이 직접쓰지 않게 하기 위함.
- JDBC Driver은 실제 구동 코드를 갖고 있다.
- 직접쓰지 않고 단일화 시키기 위한 도구가 JDBC(Java Database Connectivity)
  - 코드를 바꿀 일이 없어진다.

## JDBC를 사용하기 위한 단계
1. 드라이버 로드하기
2. 연결 생성하기
3. 문장 실행하기
4. 결과집합 사용하기  
---
1. Class.forName("oracle.jdbc.driver.OracleDriver");
   2. OracleDriver 클래스를 객체화
   3. new라는 연산자를 통해 객체화 하는 것이 아닌, Class.forName이라는 특별한 유틸리티로 객체화 시킨다.
   4. 메모리 상에 드라이버가 올라간다.
2. Connection con = DriverManager.getConnection(...);
   3. 연결이 확립된다.
3. Statement st = con.createStatement();
   4. Statement 객체 생성
   5. 사용자로부터 요구받은 쿼리를 실행
4. ResultSet rs = st.executeQuery(sql);
   5. 쿼리 실행한 것에 대한 결과집합이 생성됨. 
   6. 결과집합을 사용자에게 다 돌려주는게 아니라, 결과집합은 서버에 있고, 클라이언트는 레코드 단위로 하나씩 받게 된다.
   7. 하나씩 돌려주기 위한 cursor가 존재. rs
8. rs.next();
9. String title = rs.getString("title");