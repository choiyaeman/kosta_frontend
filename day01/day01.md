# day01

FrontEndWeb

1) HTML

2) CSS

3) JavaScript

4) jQuery

5) Vue.js, Angular, React.js

---

WorldWideWeb = WWW = WEB

표준단체 : W3C

HTML(HyperText Markup Language) 

마크업언어 : 태그로 구성된 언어 (ex) <table> </table>) 

마크업언어 종류

- HTML : 데이터 표현담당
- XML : 데이터 구조담당

HTML과 XML은 SGML의 서브셋이다.

ex) 오늘의 날씨 정보는 기상청에서 제공

제공 방식을 .txt

               .doc

               .xls

               .hwp

그중 .txt인 경우 파일 내용은 서울:송파구:잠실:12:3:40:90 

                                               서울:강남구:대치:12:4:50:85 

        .xml인 경우                   <지역>

                                                  <시>서울

                                                               <구>송파

                                                               <동>잠실</동>

                                                               </구>

                                                  </시>    

                                               </지역> 

xml인 경우 누구든 볼 수 있는 자료이면서 데이터를 구조화인 상태인 xml형태로 데이터를 제공한다.

---

                            [90년 후~]

html1 →2→3→4→xhtml

                                   WHAT workgroup : 브라우저기능 사용 가능한 표준화

                                             크롬

                                             사파리

                                              오페라

W3C는 브라우저 기능 사용 가능한 표준화 승인 : html5

1버전부터 4버전까지 진행하다가 xml화 시키자 하자고 나온 게 xhtml인거다. 즉 데이터 양이 많아지니까 그 데이터를 어떻게 구조화할지 같이 생각해보자 해서 xhtml이 만들어진 거다.

2000년대 초반에 구글에서 만들어낸 브라우저인 크롬이라는 브라우저가 출시된다. 그리고 브라우저가 플랫폼의 역할을 하자는 개념이 도입이 된다. 

W3C가 xhtml은 데이터를 어찌 구조화 할가가 고민인 거다. 그 사이에 브라우저들이 많이 출시가 되면서 플랫폼의 역할을 할 수 있게 되었는데 브라저우가 갖고 있는 작업을 html에서 제공하지 않았다. html에서는 그 브라우저의 기능을 사용할 수 있는 제공하지 않았기 때문에 사용할 수 있는 사용법을 나름대로 제시 해주었다.  그러나 사용법이 서로 다르게 만들어져서 개발자가 너무 힘들다. 그래서 브라우저사들끼리 단체를 만들었다. 그 단체 이름이 workgroup이다. 이 단체에서 해당 브라우저사들끼리 모여서 표준환을 만들었다. 그러나 또 표준환을 사용하려면  표준 사용법을 익혀야 한다. 사용법을 봐야 하는 곳이 이곳저곳이 생겨서 이 표준환을 W3C가 승인을 해준다. 

이렇게 데이터를 구조화를 계속 유지하면서 브라우저 기능 사용 가능한 표준화 두 개가 합쳐진 게 html5이라 한다. 

---

![1](https://user-images.githubusercontent.com/63957819/105342208-7155ef00-5c23-11eb-9a2f-61255f76b541.png)

일반 c/s프로그램은 각각 Client, Server가 있어야 하고 1차 버전 → 2차 버전으로 업그레이드 돼야 한다 하면 프로그램의 기능이 더 추가된다 즉 컴퓨터의 자원을 많이 사용한다. c/s프로그램은 무거워지면 제대로 실행이 안 될 수 있다. 이런 것을 FAT Client라 부른다.

WEB프로그램은 Client프로그램이 따로 필요 없이 WB가 클라이언트를 담당한다. WB에서 WebServer를 요청하고 WebServer에서 WB로 응답하는 구조로 구성되어있다. 웹 서버 종류로는 아파치, IIS, 웹로직, 웹스피어, 제우스등이 있다. 

데이터 송신을 해서 수신을 받는 A, B개발자가 있다고 하자. 서버가 요구하는 프로토콜대로 송신, 수신 해야 한다. 그래서 일반 c/s프로그램은 보안상 안전하다. 반면 WEB에서는 보안이 취약하다.

웹에서 쓰이는 기술은 크게 두 개가 있다. ClientSide, ServerSide에서 실행되는 기술로 나뉜다. 

ClientSide에서 실행되는 기술은 HTML, CSS, JS가 있고, ServerSide에서 실행되는 기술은 ASP, JSP, Servlet, PHP로 나뉜다.  ClientSide는 프론트, ServerSide는 백앤드라 불린다.

Rendering engine(=브라우저 엔진)놈은 WebBrowser에 내장이 되어있고 html, css페이지 내용을 읽어서 해석하고 화면을 예쁘게 보여준다. 

렌더링 엔진 종류 중에는 웹키트엔진이 있다. 

자바 기반의 웹 기술을 공부하려면 웹로직, 웹스피어, 제우스를 써야 한다. 그러나 너무 무겁고 고가이다. 그래서 이 제품들을 쓰지 않고 Tomcat 제품을 쓸 거다. 서버를 Tomcat서버를  쓰자~

웹 브라우저 내에 있는 html, css 는 렌더링 엔진이 처리하고 Js는 js해석기에서 할 거다.

![2](https://user-images.githubusercontent.com/63957819/105342215-72871c00-5c23-11eb-9f3e-5f8bd6f87d33.png)

file프로토콜 사용

인터넷 사용 X ex) 스마트TV, 냉장고

![3](https://user-images.githubusercontent.com/63957819/105342218-731fb280-5c23-11eb-8b56-c6cb2d193422.png)

다른 컴퓨터 서버에 있는 자원을 사용하려면 http프로토콜을 사용

요청하고 응답 받고 응답 받은 내용을 렌더링해서 보여준다.

인터넷 사용하는 구조. 

---

 apche검색 후[https://www.apache.org/](https://www.apache.org/)  사이트로 들어가서 먼저 Version 확인

![4](https://user-images.githubusercontent.com/63957819/105342219-73b84900-5c23-11eb-8890-221aaae7b818.png)

지금 설치되어 있는 자바 버전이 8버전 이므로 Apache Tomcat9버전을 깔자

![5](https://user-images.githubusercontent.com/63957819/105342220-73b84900-5c23-11eb-9aa5-3d341de02e7f.png)

안전하게 zip형태로 다운 받자

![6](https://user-images.githubusercontent.com/63957819/105342223-7450df80-5c23-11eb-81c7-50ec40d2ce34.png)

SW에 파일을 넣어주자

![7](https://user-images.githubusercontent.com/63957819/105342227-7450df80-5c23-11eb-9ff8-d17daa497bde.png)

bin디렉토리 안에 startup.bat실행

똑같은 포트 번호를 쓰려 하니깐 에러..한글이 막 깨져 있어 관리하기 힘들다. 그래서 eclipse에서 쉽게 관리할 수 있도록 하자!

Open Perspective클릭해서 Java EE로 바꾸자

Window> Preferences> Web> CSS Files, HTML, JSP 다 UTF-8로 설정

![8](https://user-images.githubusercontent.com/63957819/105342228-74e97600-5c23-11eb-9f52-555e0d3535c3.png)

Servers 클릭> 밑에 No servers are~ 클릭

![9](https://user-images.githubusercontent.com/63957819/105342229-74e97600-5c23-11eb-80ff-eeaea39b94c8.png)

설치한 Tomcat 9버전 선택 후 Next

![10](https://user-images.githubusercontent.com/63957819/105342231-75820c80-5c23-11eb-8dca-94513dccf667.png)

bin디렉토리를 포함하고 있는 파일이 경로가 되도록 해야 한다. Next 후 Finish하자

![11](https://user-images.githubusercontent.com/63957819/105342234-75820c80-5c23-11eb-8acf-5954b813b5ee.png)

TomcatServer 더블클릭

![12](https://user-images.githubusercontent.com/63957819/105342235-761aa300-5c23-11eb-9cbe-3dacf91dc957.png)

Http 포트번호를 8888로 바꾸자

Server Locations에서 두 번째 항목으로 체크. 즉 직접 운영서버에서 만들거라는 의미.

원래는 첫 번째 항목인 테스트 서버로 만들어야 한다. 그러나 수업 시간에는 운영 서버와 테스트 서버를 같이 두자 

![13](https://user-images.githubusercontent.com/63957819/105342236-761aa300-5c23-11eb-9641-47f5d2a61ea7.png)

저장하고 나서 TomcatServer 오른쪽 클릭 start 실행 시켜준다.
