# day02

하이퍼 텍스트는 일반 텍스트의 구성과 달리 특정 데이터를 찾아갈 때 링크를 꾹 누르게 되면 즉시 찾아갈 수 있다 

### **태그와 요소**

요소(Element) - HTML페이지를 구성하는 각 부품(제목, 본문, 이미지 등)

태그- 요소를 만들 때 사용하는 작성 방법

내용을 가질 수 있는 요소 <요소 이름>내용</요소이름> 

내용을 가질 수 없는 요소 <요소이름>

→ Element는 body를 가질 수도 있고 안 가질 수 도 있다라는 의미.

### **속성(Attribute)**

태그에 - 태그에 추가 정보를 부여할 때 사용하는 것

객체의 속성은 property라 부르지만 태그에서의 속성은 attribute라 읽는다!

ex) <h1 title="header">Hello HTML5</h1> 

속성 값을 줬을 때는 큰 따옴표로 열고 닫고 해줘야 한다.

여러 속성을 나열할 때는 줄 바꿈을 사용해서 표현하는 게 좋다.

### 주석(Comment)

<!— 주석 —>

## HTML5 페이지의 구조
```html
<!DOCTYPE html>

<html>

<head>

<title>Hello ~</title>

</head>

<body>

</body>

</html>
```
1.웹 브라우저에 HTML5 문서라는 것을 알리기 위해 반드시 첫 행에 나와야 한다.

2.body 태그에 필요한 스타일시트와 자바스크립트를 제공

3.웹 브라우에 표시하는 제목을 지정

4.사용자에게 실제로 보이는 부분을 작성

5.모든 HTML 페이지의 기본 요소로, 모든 태그는 이 html 태그 내부에 작성

### <html> 태그

웹 페이지의 사용 언어를 구글 검색 엔진에 제공

버전 호환성을 고려해봤을 때 태그 이름은 소문자로 쓰는 게 좋다.

**head태그 내부에 넣을 수 있는 태그**

meta 태그 : 웹 페이지에 추가 정보 전달

title 태그 : 페이지 제목 지정

- first.html

```html
<!DOCTYPE html>
<html>
    <head>
        <title>제목</title>
    </head>
    <body>
        <h1 id="first">WELCOME!~</h1>  <!--속성값은 대소문자 구분해야한다.-->
        <hr>
        <h6>Yaeman</h6>'s WebPage
        <p id="second"
           style="border: 1px;border-style: solid;border-color:brown; width: 300px;"></p>
        >HTML, CSS, JS는 FrontEND기술입니다.<br>
            HTML은 데이터<br>
            CSS는 표현<br>
            JS는 기능을 담당한다.
        </p>
        <p id="third">
            <h3>JSP, Servlet은 BackEND기술입니다.</h3>
            JSP는 JavaServerPage로서 ASP와 비슷<br>
            Servlet은 Java언어 기반이다
        </p>

        <p>
            <a href="http://www.naver.com">네이버</a>&nbsp;&nbsp;&nbsp;
            <a href="http://www.daum.com">다음</a>&nbsp;&nbsp;&nbsp;
            <a href="http://www.google.com">구글</a>
            <hr>
            <a href="./sub.html">SUB</a> <!--./는 같은경로라 보면된다. 상대경로 활용: .현재경로, ..상위경로-->
            <hr>
            <a href="#first">TOP</a>&nbsp;&nbsp;&nbsp; <!--같은 PAGE의 특정 영역으로 이동 id속성 활용 : #. #은 id값을 의미한다. 같은 문서에 있는 id가 first영역으로 이동하라-->
            <a href="#second">FRONT END</a>&nbsp;&nbsp;&nbsp;
            <a href="#third">BACK END</a>
        </p>

        <p>
            <ol> <!--ordered list: 순서있는 목록-->
                <li>아반테</li> <!--list item: 목록의 아이템-->
                <li>소나타</li>
                <li>그랜저</li>
            </ol>

            <ul> <!--unordered list: 번호가 없는 태그-->
                <li>아반테</li>
                <li>소나타</li>
                <li>그랜저</li>
            </ul>

            <p>
                <table border="1" width="500" height="700"> <!--표에 관련된 태그-->
                    <!-- <thead> -->
                        <tr> <!--table row: 행-->
                            <td>상품번호</td><td>상품명</td><td>가격</td> <!--td: 열-->
                        </tr>
                    <!-- </thead> -->
                    <!-- <tbody> -->
                        <tr><td>1</td><td>아메리카노</td>           <td>1000</td></tr>
                        <tr><td>2</td><td>아이스아메리카노</td>     <td>1000</td></tr>
                        <tr><td>3</td><td>라테</td>                 <td>1500</td></tr>
                        <tr><td>4</td><td>아이스라테                </td><td>1500</td></tr>
                        <tr><td rowspan="2">5</td> <!--rowsapn: 행 결합-->
                                       <td>오렌지 쥬스</td>         <td>2000</td></tr>
                        <tr>           <td>오렌지 쥬스
                                           얼음추가</td>            <td>2500</td></tr>
                    <!-- </tbody> -->
                    <!--<tfoot> --> <!--꼬릿말의 역할-->
                        <!-- <tr><td> </td><td>          </td><td>총액:5000</td></tr> -->
                        <tr><td colspan="3">총액 : 5000</td><tr> <!--colspan: 열 결합-->        
                    <!-- </tfoot> -->
                </table>
            </p>
            <p>
                <img src="./images/movie_image.jpg" alt="빅풋 주니어2: 패밀리가 떴다"><br> <!--src는 이미지의 resource를 넣어준다. alt속성값은 웹 접근성을 위해 반드시 필요-->
                <img src="./images/movie_image.jpg" 
                     alt="빅풋 주니어2: 패밀리가 떴다"
                     width="200"
                     height="300"        
                ><br>
                <img src="./images/movie_image.jpg" 
                     alt="빅풋 주니어2: 패밀리가 떴다"
                     width="200"        
                >
                <img src="https://movie-phinf.pstatic.net/20210107_160/1609984702837oNdmw_JPEG/movie_image.jpg" 
                     alt="소울"
                >
            </p>
        </p>
    </body>
</html>
```

- sub.html

```html
<!DOCTYPE html>
<html>
    <head>
        <title>sub.html입니다.</title>
    </head>
    <body>
        <h1>SUB</h1>
    </body>
</html>
```

![1](https://user-images.githubusercontent.com/63957819/105465349-2648e400-5cd6-11eb-8a07-41148059bdf2.png)

웹브라우저 내부에 있는 렌더링 엔진이 html을 파싱하고 결과를 예쁘게 렌더링 해준다.

렌더링 엔진의 종류는 서로 다르므로 파싱하는 방법이 다를 수 있다. 즉 결과가 다르게 보일 수 있다.

이 문제를 어찌 해결할 것 인가? 

1. 웹 표준화 : 표준화 된 태그 사용
2. 웹 접근성 ↑ : css도입

제목에 관련된 태그들은 자동 줄 바꿈이 된다.

p태그는 단락을 구분하게 한다.

hr태그는 수평선 알리는 태그이다.

br태그는 한 줄 바꿈을 의미한다. 끝나는 태그를 따로 만들지 않는다!

ol태그는 순서 있는 목록

ul태그는 번호가 없는 태그

li태그는 목록의 아이템

tr태그는 행

td태그는 열

tfoot태그는 꼬릿말

데이터 구조화하기 위해 의미만 담은 태그를 시멘틱 태그라 한다.

데이터들의 구조만 나타내기 위한 태그들이 필요한데 thead tbody tfoot 태그가 있다.

![2](https://user-images.githubusercontent.com/63957819/105465353-26e17a80-5cd6-11eb-89e7-02da2c2b019f.png)

table태그를 만나고 어떤 태그가 중간에 끼어 들어가게 되냐면 렌더링에 의해서 tbody태그가 자동 추가가 된다. thead나 tfoot는 몰라도 tbody태그는 자동 추가 됨.

![3](https://user-images.githubusercontent.com/63957819/105465355-277a1100-5cd6-11eb-9df9-08e26530b0d4.png)

이미지는 따로 이미지 파일을 만들어 넣어두자

width만 지정해서 설정하면 height 크기는 알아서 자동 비율 지정이 된다. 즉 찌그러지지 않는 비율로 자동 설정이 된다. 일반적인 경우에는 width만 설정하여 이미지가 찌그러지지 않게 한다.

h태그는 자동 줄 바꿈이 되고 a태그는 안되고 목록에 관련된 li태그는 자동 줄 바꿈이 되고 ol, ul도 되고  표에 관련된 태그들도 자동 줄 바꿈이 되고 td태그는 자동 줄 바꿈 x, 이미지 태그도 자동 줄 바꿈 x

p태그는 borer속성이 없고 style이라는 속성으로 테두리를 그릴 수 있다. style속성 안에 border는 스타일의 속성의 property이름이라고 한다.

- formtest.html

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>입력양식 실습</title>
    </head>
    <body>
        <form method="GET" action="http://www.naver.com"> <!-- <form>과 같음-->
            <label>text: <input type="text" name="t" value="test"></label><br> <!--기본값을 보여주려면 value값을 쓰면된다.--> <!--label은 text클릭시 input태그로 커서가 이동하게 해준다. -->
            <label>password: <input type="password" name="p" value="p"></label><br>
            <fieldset> <!-- fiedlset 태그는 입력 양식들을 묶음처리 Grouping-->
            <legend>다중선택</legend> <!--legend 태그는 title역할을 해줌-->    
                <label><input type="checkbox" name="c" value="c1" checked>ONE&nbsp&nbsp</label><!--checkbox는 다중 선택의 의미를 담고 있다-->
                <label><input type="checkbox" name="c" value="c2">TWO&nbsp&nbsp</label>
                <label><input type="checkbox" name="c" value="c3" checked>THREE</label> <!--checked="checked" 경우에 chekced는 속성명과 속성값이 같기 때문에 속성명만 적어줘도 된다-->
            </fieldset>
            <fieldset>
            <legend>단일선택</legend>
                <label><input type="radio" name="r" value="r1">ONE&nbsp;&nbsp;</label> <!--radio는 단일 선택의 의미만 담고있다.-->
                <label><input type="radio" name="r" value="r2">TWO&nbsp;&nbsp;</label>
                <label><input type="radio" name="r" value="r3" checked>THREE</label>
            </fieldset>
            <input type="hidden" name="h" value="hvalue"> <!--hidden은 브라우저에 보이지는 않지만 전달될 때 hidden에 해당하는 이름과 값은 제출이 된다-->
            
            <select><!--select 태그는 값을 선택할 때 사용. 하위태그로 option을 갖는다-->
                <option>ONE</option>
                <option>TWO</option>
                <option selected>THREE</option>
            </select>
<textarea rows="3" cols="10">
ABCDEFGHIGKLMNO
PQRSTUVWXYZ
</textarea><!--textarea는 여러 줄 입력가능.-->
            <input type="submit">
        </form>

        <hr>
        <h1>HTML5에서 제공하는 TYPE속성값들</h1>
        <form>
            <input type="number" value="5" step="2"> <!--기본값을 5로하고 2씩 증가 되도록-->
            <input type="tel" value="01012345678">
            <input type="search"> <!--search는 작은 device에서 쉽게 제거할수 있도록 제공-->
            <input type="date">
            <input type ="range"> <!--range는 값의 범위를 조절을 제공-->
            <input type="url">
        </form>

        <hr>
        <h1>HTML5에서 제공하는 input태그의 속성들</h1>
        <form action="http://www.naver.com" autocomplete="off"> <!--보안상 자동 완성 기능을 키면 안되는데 끄는 게 autocomplete이다.-->
            <input type="text" placeholder="아이디"> <!--placeholder는 도움말, 힌트를 주는 속성.-->
            <input type="text" placeholder="카드번호" name="no"> <!--각 태그별 autocomplete="off"가능-->
            <input type="text" value="읽기전용" readonly> <!--readonly는 읽기전용-->
            <input type="text" value="비활성화" disabled> <!--disabled는 비활성화. 이전버전에서 제공 됨-->
            <input type="submit">
        </form>

        <input name="test" value="outofform" form="f1"> <!--input요소가 form태그의 안쪽으로 옮겨지는 효과가 난다-->
        <form id="f1" action="http://www.naver.com">
            <input type="submit">
        </form>
    </body>
</html>
```

구조화 태그가 시멘틱 태그를 의미한다.

사용자로부터 값을 입력 받을 수 있도록 하는 태그들을 알아보자.

입력 양식이란 사용자에게 정보를 입력 받는 요소를 의미한다.

<form>태그: 영역 생성

method속성의 방식으로 action 속성 장소에 데이터 전달

GET 방식 - 주소에 데이터를 입력해서 전달

POST 방식 - 주소 변경 없이 비밀스럽게 데이터 전달

input태그는 form태그의 하위 요소이다. 

![4](https://user-images.githubusercontent.com/63957819/105465356-277a1100-5cd6-11eb-8b91-9e73f5ade72d.png)

웹 브라우저가 주소 url을 http프로토콜을 이용하여 웹 서버로 요청할 수 있다. 그리고 서버에서 결과를 응답을 해준다.  

a.html을 요청했다 하면 네이버 서버에 있어야 하고 응답하는 구조로 보자. 요청 시에 가장 먼저 서버로 전송되는 데이터 요청 방식이 주소창에다 엔터 를 딱 누르는 get방식이다. 링크를 클릭해서 요청하는 방식도 GET방식의 요청이다. 두 번째로 전송되는 것은 url 그 다음 요청 HEADERS들이 클라이언트 컴퓨터에서 SERVER컴퓨터로 전송된다. 그 다음 요청바디가 클라이언트에서 서버 컴퓨터로 전송된다.

요청 방식에는 GET, POST가 있는데 GET은 요청바디를 사용하지 않고 POST는 사용한다.

![5](https://user-images.githubusercontent.com/63957819/105465357-2812a780-5cd6-11eb-9e76-0d55304632f9.png)

form태그에 속성을 action속성이 네이버닷컴이 설정 되어 있다면 제출이라는 버튼을 클릭하게 되면 입력한 값이 네이버에게 전송이 된다. 네이버에게 전달될 때 이름과 값을 전달해줘야 한다. 입력한 값이 어떤 종류의 값인가 알려주기 위해 이름과 맵핑 되는 search에 해당하는 값이야라고 알려준다.

GET방식은 body를 사용하지 않다 보니 주소 url의 뒷 부분에 이름과 값이 맵핑이 되어서 데이터가 따라간다.  만약 사용자가 입력한 값이 주민 번호, 카드라면 웹 브라우저 주소 url에 쿼리스트링으로 유출이 되어 보안상에 문제가 생긴다.  즉 보안에 취약하다. 그러므로 보안상 안전한 POST방식으로 써야 한다.

GET은 가져온다 POST는 보낸다 의미라고 보면 된다.

![6](https://user-images.githubusercontent.com/63957819/105465362-28ab3e00-5cd6-11eb-9541-82e952f855e2.png)

![7](https://user-images.githubusercontent.com/63957819/105465364-28ab3e00-5cd6-11eb-9a7e-860d7ef3cc64.png)

form태그의 action요청으로  ?이후부터는 쿼리스트링이 보인다. 이것은 GET방식의 요청이라는 것을 알 수 있다. 전송할 데이터가 그렇게 중요하지 않으면 GET방식을 쓰면 되는데 주로 검색할 때 사용한다. 전송할 데이터가 중요한 거를 추가할 때는 예를 들어 가입이나 로그인할 때 POST방식으로 요청한다.

<input type="text"> → 타입 속성의 기본 값은 텍스트이다 의미.

method속성이 쓰여있지 않으면 기본 값으로 GET이다.

![8](https://user-images.githubusercontent.com/63957819/105465367-2943d480-5cd6-11eb-97d0-89ed55e18ec0.png)

각 브라우저마다 서로 다르다. 렌더링이 다르게 해석되어서 보여진다.

![9](https://user-images.githubusercontent.com/63957819/105465368-29dc6b00-5cd6-11eb-9f95-4915d3b8ad96.png)

![10](https://user-images.githubusercontent.com/63957819/105465369-29dc6b00-5cd6-11eb-8527-cae86e71e9fb.png)

    핸드폰으로 확인해보기

[https://www.w3schools.com/](https://www.w3schools.com/) 에서 다양한 예제와 문법 정리가 되어있다.

form태그 안에 있는 아이디 속성 값을 이용해서 input에 적어주고 input요소가 form태그 안쪽으로 들어가는 효과가 난다.

- sementic.html

```html
<!--semantic.html-->
<!DOCTYPE html>
<html>
    <head>
        <title>시멘틱태그</title>
    </head>
    <body>
        <p>
            <!--블럭용 태그 : div-->
            <div> <!--머리말-->
                <h1>스타벅스</h1>
                <div> <!--메뉴-->
                    <a href="#">로그인</a>
                    <a href="#">가입</a>
                </div>
            </div>
            <div><!--본문-->
                스타벅스만의 특별한 혜택, 스타벅스 리워드
스타벅스 회원이세요? 로그인을 통해 나만의 리워드를 확인해보세요.
스타벅스 회원이 아니세요? 가입을 통해 리워드 혜택을 즐기세요.

                <div> <!--광고-->
                    나의 큐피트를 받아줘.
                    현대카드.
                </div>
            </div>
            <div><!--맺음말-->
                사업자등록번호 : 201-81-21515 (주)스타벅스커피 코리아 대표이사 : 송 데이비드 호섭 TEL : 1522-3232 개인정보 책임자 : 장석현
ⓒ 2021 Starbucks Coffee Company. All Rights Reserved.
            </div>
        </p>
        <p>
            <header>
                <h1>스타벅스</h1>
                <nav> <!--nav는 주로 메뉴를 작성-->
                    <a href="#">로그인</a>
                    <a href="#">가입</a> 
                </nav> 
            </header>
            <section>
                <article> <!--article은 여러 기사라고 보면되고 section 안쪽에 여러개 들어갈 수 있다.-->
                    스타벅스만의 특별한 혜택, 스타벅스 <mark>리워드</mark>
스타벅스 회원이세요? 로그인을 통해 나만의 리워드를 확인해보세요.
스타벅스 회원이 아니세요? 가입을 통해 리워드 혜택을 즐기세요.
                </article>
                <article>
                    활기찬 새해를 열어줄 멕시코 오악사카. 풍부하고 달콤한 카라멜 향과 살구처럼 상큼하고 향긋한 단맛이 매력적인 원두
                </article>
                <aside>
                    나의 큐피트를 받아줘.
                    현대카드.
                </aside>
            </section>
            <footer>
                사업자등록번호 : 201-81-21515 (주)스타벅스커피 코리아 대표이사 : 송 데이비드 호섭 TEL : 1522-3232 개인정보 책임자 : 장석현
ⓒ 2021 Starbucks Coffee Company. All Rights Reserved.
        </p>
    </body>
</html>
```

![11](https://user-images.githubusercontent.com/63957819/105465370-2a750180-5cd6-11eb-8940-bf2691a18095.png)

footer는 맺음말이구나 구조상 끝에 오겠다라고 이해하면 된다.

머리말은 header, 본문은 section, 꼬리말은 footer에 해당한다. 이러한 태그들을 시멘틱태그라 불린다.

![12](https://user-images.githubusercontent.com/63957819/105465372-2a750180-5cd6-11eb-9b19-f75e3fd649ba.png)

div태그보다 시멘틱태그를 적극 사용해라!
