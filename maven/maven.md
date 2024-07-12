# Maven

## Maven?

- 프로젝트를 빌드할 때 사용되는 도구.
- 내부는 굉장히 복잡할지라도, 사용하기엔 쉽다.

## 빌드 과정

1. 프로젝트 생성
2. 라이브러리 생성
3. 코드 작업
4. 컴파일
5. 테스트
6. 패키지 만들기
7. 배포
8. 레포팅

- 위 작업 과정에서 반복되는 내용을 효율적으로 도와주는 도구가 Maven
  - 빌드 과정을 경량화
- Maven은 특정 IDE에 종속된 것이 아닌, 빌드를 도와주는 역할자

## Maven 설치

- [maven 설치] https://maven.apache.org/download.cgi
- M2_HOME 으로 환경변수 설정 후 Path에 추가
- cmd에 mvn -version 입력 시 버전 나오는거 확인.

## Maven으로 자바 프로젝트 생성하기

- mvn archetype:generate -DgroupId=com.hyoseok -DartifactId=javaprj -DarchetypeArtifactId=maven-archetype-quickstart
  - -D는 구분자
  - 프로젝트가 충돌나지 않기 위해 식별하기 위한 그룹명 설정 com.hyoseok

## 컴파일과 실행

- javaprj 루트 디렉터리에서 mvm compile 입력
- C:\Users\maven\javaprj>mvn compile
  - target\classes/com/hyoseok 안에 App.class 생성됨
- mvn package -> 패키지 생성 = jar 파일 생성
  - java -cp target\javaprj-1.0-SNAPSHOT.jar com.hyoseok.App 로 실행

## Defalut LifeCycle

<img src="https://github.com/user-attachments/assets/56aea509-03f8-48c0-b3e0-6b7163060fc6">

- POM.xml에 있는 패키징에 따라 다르다.
  - POM(Project Object Model) 프로젝트를 구성하고 있는 내용에 대한 것을 모델로 갖고 있음.
- mvn compile 하면 compile 단계까지 실행해달라는 것이다.
- 근데, 단계들이 정적으로 실행되는 내용이 정해져있진 않다.
- Maven은 단계별로 플러그인 방식으로 다 끊어놨다. 즉, 구성하는 단계는 있으나 무조건 실행되는 건 아니다.
- 만약, compile이면 compile을 해주는 프로그램이 따로 있다. 다른 것들도 마찬가지.
- 모든 단계마다 단계를 실행하는 프로그램을 나눠놔서 플러그인처럼 뺐다 꽃았다 할 수 있다.

## 단계별 실행을 담당하는 플러그인들

<img src="https://github.com/user-attachments/assets/b79689bc-279f-445e-a6ed-2f90ee38f268">

- 단계에 해당되는 프로그램이 매핑이 되어있는 모습.
- 단계를 실행할 때 사용되는 프로그램을 플러그인이라고 한다.
- 플러그인이 여러개의 작은 단위의 플러그인을 가질 수 있다. 그것이 Goal
  - 단계마다 동일한 플러그인 사용가능. 그 안에서 작은 Goal들이 그 단계를 책임지는 실질적인 역할을 한다. (compile과 test-compile)
- validate은 연결되어 있지 않은 상태. 연결하려면 POM.XML에서 한다.
- compile 단계의 플러그인의 버전을 바꾸려면 POM.XML에서 한다.
- 프로젝트 터미널에서 mvn help:describe -Dcmd=compile 입력 시 확인이 가능하다.

##
