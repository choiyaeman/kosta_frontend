# day04

- singup.html

```html
<!DOCTYPE html>
<html>
    <head>
        <title>고객 가입</title>
    </head>
    <body>
        <form>
            <label>아이디: <input type="text" name="id" placeholder="아이디를 입력하세요"></label>
            <input type="button" value="중복확인"><br>
            
            <lable>비밀번호: <input type="password" name="pwd" placeholder="비밀번호를 입력하세요"></lable><br>
            <lable>비밀번호확인: <input type="password" placeholder="비밀번호를 확인하세요"></lable><br>
            
            <label>이름: <input type="text" name="name" placeholder="이름을 입력하세요"></label><br>
            
            <label>우편번호: <input type="text" readonly size="5"></label>
            <input type="button" value="우편번호검색"><br>
            <input type="hidden" name="bulidingno" value="123456789012345678901234">
            <input type="text" readonly value="서울시 중구 광화문로 세종대로"><br>
            <input type="text" name="addr1" placeholder="상세주소를 입력하세요"><br>

            <input type="submit" value="가입">
            <input type="reset" value="CLEAR">
        </form>
    </body>
</html>
```

첫 번째 비밀번호는 name 을 서버로 전송해야 하고 두 번째 비밀번호는 서버로 전송 없이 향후 자바스크립트 작업할 때 첫 번째랑 두 번째 비교 작업을 한다.

우편번호는 사실 상 내 주소를 식별해줄 수 있는 식별자가 아니다. 그래서 굳이 서버로 가서 저장할 이유가 없기 때문에 서버로 전송할 자료가 아니다.

![day04%209da4673fb6b6469fb3b9f3e7d8e8e497/Untitled.png](day04%209da4673fb6b6469fb3b9f3e7d8e8e497/Untitled.png)

`margin` 테두리와 다른 태그 사이의 테두리 바깥쪽 여백

`border` 테두리

`padding` 테두리와 글자 사이의 테두리 안쪽 여백, 배경색은 padding 영역까지만 적용

`width` 글자를 감싸는 영역의 가로 크기

`height` 글자를 감싸는 영역의 세로 크기

글자에 관련된 속성들은 순서를 주의 해야 한다.

css에서 네 방향 속성을 지정할 때 시계 방향 순서이다.

ex) margin: 0 30px 0 30px; →0은 사용하지 않겠다 의미.

inline-block(인라인 + 블록) : 줄 바꿈 안되고 크기 지정 가능

display, visiblity 속성은 둘 다 화면에서 안보이게 하는 방법이다.

hidden으로 하면 영역은 유지하되 그 내용이 안 보이는 것 뿐이다

#box → id 속성 값이 box인 요소 선택 하라는 의미

`repeat-x` : x축 방향으로만 이미지 반복

`repeat-y` : y축 방향으로만 이미지 반복

배경 이미지 반복 안 하려면 `no-repeat`주면 된다.

`background-attachment` : 배경 이미지를 화면에 고정

- boxcss.html

```html
<!DOCTYPE html>
<html>
    <head>
        <style>
            div:first-child{
                width: 100px; /* 내용의 넓이 */
                height: 100px; /* 내용의 높이 */
                padding: 10px; /* 테두리와 컨텐트의 간격 */
                border: 1px black solid;
                margin: 1px;
            }
            div:last-child{
                box-sizing: border-box;
                width: 100px; /* 실제 넓이 */
                height: 100px; /* 실제 높이 */
                padding: 10px;
                border: 1px blue dotted;
                margin: 1px;
            }
        </style>
    </head>
    <body>
        <div>
            DIV1
        </div>
        <div>
            DIV2
        </div>
    </body>
</html>
```

first-child = nth-child(1)

![day04%209da4673fb6b6469fb3b9f3e7d8e8e497/Untitled%201.png](day04%209da4673fb6b6469fb3b9f3e7d8e8e497/Untitled%201.png)

- displaycss.html

```html
<!DOCTYPE html>
<html>
    <head>
        <style>
            div{
                box-sizing: border-box;
                width: 100px;
                border: 1px solid;
                margin: 5px;
            }
            div:nth-child(2n){ /* css에서는 1부터 시작 */
               /*  display: none; */
               visibility: hidden; /* 영역은 남아있고 화면에 안보이기만 한다 */
            }
            div:first-child{
                display:inline; /* inline으로 바꾸게 되면 width가 효과가 없다 */
            }
        </style>
    </head>
    <body>
        <div>
            DIV1
        </div>
        <div>
            DIV2
        </div>
        <div>
            DIV3
        </div>
        <div>
            DIV4
        </div>
    </body>
</html>
```

- backgroundcss.html

```html
<!DOCTYPE html>
<html>
    <head>
        <style>
            div{
                box-sizing: border-box;
                width: 600px;
                height: 500px;
                border: 1px solid;
                padding: 10px;
                background-image: url('./images/movie_image.jpg');
                /*background-image: url('https://www.starbucks.co.kr/common/img/common/logon.png');*/
                background-repeat: no-repeat; /* repeat-x : x축 방향으로만 이미지 반복 */
                background-position: right top;
                background-attachment: fixed; /* 위치고정 */
            }
        </style>
    </head>
    <body>
        <div>
            DIV1
        </div>
    </body>
</html>
```

`text-align` : 글자 정렬

`text-align` : 글자 수평 정렬

`line-hegiht` : 글자 수직 중앙 정렬

바깥쪽 요소의 크기만큼 안쪽 요소의 line-height값을 같은 값을 주면 된다.

position : 요소의 위치 지정 형식 설정

- 절대 위치 좌표 : absolute, fixed
- 상대 위치 좌표 : relative, static

`**absolute**` : 절대 위치 좌표 설정(절대)

`**relative**` : 초기 위치에서 상하좌우로 위치 이동(상대)

`fixed` : 화면을 기준으로 절대 위치 좌표 설정

`static` : 위쪽에서 아래쪽으로 순서대로 배치

![day04%209da4673fb6b6469fb3b9f3e7d8e8e497/Untitled%202.png](day04%209da4673fb6b6469fb3b9f3e7d8e8e497/Untitled%202.png)

absolute 줄 때에는 적합하게 left, top, right, bottom 위치 지정을 해주자

`z-index` : 숫자를 입력하면 숫자가 클수록 앞에 위치

`overflow`

- 내용이 요소 크기를 벗어나 모두 보여 주기 힘들 때 어떻게 보여 줄지 지정
- float 속성과 함께 자주 사용

:hidden : 영역을 벗어나는 부분 감춤

:scroll 영역을 벗어나는 부분을 스크롤로 만듦

overflow를 auto로 주는 게 훨씬 좋다. 좌, 우 스크롤이 내용에 따라서 보여질 거다.

`float` 

- 웹 페이지의 레이아웃을 잡을 때 많이 사용
- 웹 브라우저 크기에 상관없이 공지 등을 일정한 위치에 고정할 때 적합

:left 태그를 왼쪽에 붙임

:right 태그를 오른쪽에 붙임

left값을 주면 왼쪽에 정렬을 시키는 것이고 right값을 주면 오른쪽에 정렬을 시킨다는 의미이다

![day04%209da4673fb6b6469fb3b9f3e7d8e8e497/Untitled%203.png](day04%209da4673fb6b6469fb3b9f3e7d8e8e497/Untitled%203.png)

![day04%209da4673fb6b6469fb3b9f3e7d8e8e497/Untitled%204.png](day04%209da4673fb6b6469fb3b9f3e7d8e8e497/Untitled%204.png)

float에서는 블럭 요소에 관계없이 둥둥 떠다니다가 기본 레이어에 갖다 붙인다.

- textcss.html

```html
<!DOCTYPE html>
<html>
    <head>
        <style>
            div{
                font-family: 'Courier New', Courier, monospace; /* Courier New 글꼴을 사용하되 없으면 Courier 없으면 monospace를 사용할거다 의미*/
                font-size: 1.5em;
                font-weight: bold;
                font-style: italic;
                width: 300px;
                height: 300px;
                border: 1px solid;
            }
            div:first-child{
                text-align: center;
                text-decoration: underline;
                line-height: 300px;
            }
            div:last-child{
                /* overflow: hidden; */
                /* overflow: scroll; */
                /* overflow: auto; 내용이 차고 넘칠때에만 스크롤이 나타난다 */
                width: 100%;
                overflow: hidden;
                text-overflow:  ellipsis; /* 잘린 텍스트를 생략부호(...)로 표시함 */
                white-space: nowrap; /* 텍스트 길어도 줄바꿈 되지 않음 */
            }
        </style>
    </head>
    <body>
        <div>
            HELLO~~:)
        </div>
        <div>
            출신학교 차별없는 채용문화 운동을 벌이고 있는 시민단체 교육의봄은 26일 대학 졸업 3년이 지나면 대기업 취업이 어렵다고 밝혔다.

교육의봄이 연 채용포럼에 참여한 한국직업능력개발원 연구진과 전현직 대기업 채용 관계자들은 채용 과정에서 스펙은 과거에 비해 중요도가 줄어들고는 있지만, 여전히 중요한 위치를 차지하고 있다고 주장했다.

한국직업능력개발원의 채창균 박사는 “우리나라의 매출액 기준 500대 기업의 경우 1차 서류 전형을 통과하기 위해서는 학점, 전공, 출신학교 등 전통적으로 강조되어온 스펙이 여전히 중요하다”면서 “서류 통과를 위해서 기업이 중요시하는 4가지 요인으로 졸업 시점, 출신학교, 전공, 학점”이라며 이가운데 하나라도 부족하면 대기업 취업이 어렵다고 강조했다.

정민홍 화승 R&A 팀장은 “우리나라 대기업의 인력 채용은 부적격자를 걸러내는 데에 더 초점을 맞춘 ‘네거티브’ 방식”이라며 “각 직무에 필요한 사람을 뽑는 ‘포지티브’ 방식으로 가야 한다”고 제안했다.

채 박사는 대기업이 서류단계에서 최종학교 졸업 시점을 가장 중요한 평가의 요소로 간주하고 있다고 설명했다. 대기업은 졸업 예정자나 졸업 후 1년까지의 구직자를 선호하고, 졸업 후 1년이 지난 구직자에 대해서는 선호도가 점차 하락하다가 3년이 지나면 급감하는 것으로 조사됐다. 졸업 후 시간이 오래되었다는 것을 취업 역량이 떨어지는 것의 신호로 여긴다고 분석했다.

졸업시점에 이어 졸업 평점, 전공의 직무 적합성, 출신학교 등의 순으로 서류 평가에서 중요성을 부여하고 있는 것으로 나타났다. 반면 어학 능력과 각종 자격증의 경우는 직무에 꼭 필요한 경우가 아니면 중요도가 떨어지는 것으로 나타났다.

면접단계에서는 지원자의 도덕성과 인성을 주로 보는 것으로 조사됐다.

한편 인문계와 이공계의 취업 시장 현황이 현저하게 차이가 나서 취업 시장에서 스펙 경쟁이 치열한 것은 대부분 인문계열 학생들의 경우다. 한 공기업 채용에서 이공계는 경쟁률이 1.1대 1도 안 되지만 경상계열은 65대 1이 되는 예도 있었다.

또 취업난 증가와 함께 신입 직원의 중도퇴사율도 높아졌다. 2019년 구인·구직 플랫폼인 사람인이 기업 576곳을 대상으로 조사한 결과에 따르면, 입사 1년 차 신입사원의 퇴사율은 48.6%에 이르렀다.

이병철 시너지 컨설팅 대표는 “지원자들의 직무능력과 적합성을 확인하기 위해 활용하는 역량면접의 경우 1인당 90분이 확보되어야 하는데, 실제 우리나라 면접시간이 민간기업의 경우 12분 정도에 불과하다”며 신입 직원의 높은 퇴사율 원인 가운데 하나로 지적했다.

코로나 대유행의 장기화로 공채 폐지와 수시채용의 확대 등 대기업의 채용 규모는 점점 줄어들고 있는 가운데 성장 산업의 4가지 키워드는 BBIG(바이오, 배터리, 인터넷, 게임)으로 제시돼 인문계열 학생들의 취업난 심화가 전망됐다.
        </div>
    </body>
</html>
```

text-overflow:  ellipsis;, white-space: → 같이 써야 한다.

- positioncss.html

```html
<!DOCTYPE HTML>
<html>
    <head>
        <style>
            /*img{
                float:
            }
            div{
                width:100px;
                height:100px;
            }
            
           div:nth-child(1){
                float:left;
            }
            
            div:nth-child(2){
                float:left;
            }
            div:nth-child(3){
                float:left;
            } */
            :nth-child(1){
                float : left;
            }
            :nth-child(2){
                float : left
            }
            :nth-child(3){
                float : left
            }
            :nth-child(4){
                float: left;
            }
        </style>
    </head>
    <body>
        <img src="images/movie_image.jpg">
        <div class="red" style="background:red">RED</div>
        <div class="green" style="background:green">GREEN</div>
        <div class="blue" style="background:blue">BLUE</div>        
    </body>
</html>
```

img태그는 인라인 요소이어서 자동 줄 바꿈이 안된다, div는 블럭 요소이어서 자동 줄 바꿈이 된다.

실행 결과>

![day04%209da4673fb6b6469fb3b9f3e7d8e8e497/Untitled%205.png](day04%209da4673fb6b6469fb3b9f3e7d8e8e497/Untitled%205.png)

- nth-childcss.html

```html
<!DOCTYPE HTML>
<html>
    <head>
        <style>
            p:nth-child(1){
                background-color: yellow;
            }
            p:nth-child(2){
                background-color: blue;
                color:white;
            }
            p:nth-child(3){
                background-color:red;
                color:white;
            }
            p:nth-child(4){
                color : green;
            }
        </style>
    </head>
    <body>
        <div>
            <p>ONE</p>
            <p>TWO</p>
            <p>THREE</p>
        </div>
        <p>FOUR</p>
        
    </body>
</html>
```

실행결과>

![day04%209da4673fb6b6469fb3b9f3e7d8e8e497/Untitled%206.png](day04%209da4673fb6b6469fb3b9f3e7d8e8e497/Untitled%206.png)

![day04%209da4673fb6b6469fb3b9f3e7d8e8e497/Untitled%207.png](day04%209da4673fb6b6469fb3b9f3e7d8e8e497/Untitled%207.png)

html 하위 요소 body가 있고 body 하위 요소로 div, p요소가 있다

div요소 밑에 p요소 첫 번째, 두 번째, 세 번째가 있다. div태그가 끝나면 p요소가 다시 한번 열린다

위에서 아래로 읽어가면서 그 요소들의 계층 구조를 트리 계층 구조라 한다. p요소를 찾을 건데 첫 번째 자식 요소를 쓰이는 p요소를 찾는다. 그리고 두 번째 자식 역할 하는 p를 찾는데 두 번째 요소를 찾는 p요소가 두 번이다.  세 번째 자식 역할 하는 p요소 찾아가고 네 번째 자식 역할 하는 p요소는 없다. 

![day04%209da4673fb6b6469fb3b9f3e7d8e8e497/Untitled%208.png](day04%209da4673fb6b6469fb3b9f3e7d8e8e497/Untitled%208.png)

div:nth-child(2)는 선택된 게 없으므로 효과가 나타나지 않는다.

- positioncss.html

```html
<!DOCTYPE HTML>
<html>
    <head>
        <style>
            /*
            :nth-child(1){
                float : right;
            }
            :nth-child(2){
                float : right;
                clear : both; 
            }
            :nth-child(3){
                float : left;
            }
            :nth-child(4){
                float: right;
            }
            */
            /* 절대 위치 지정 */
            /*
            div{
                width: 100px;
                height: 100px;
            }
            div.red{
                position: absolute; 
                left: 50px;
                top: 70px;
                z-index: 1;
            }
            div.green{
                position: absolute; 
                left: 70px;
                top: 70px;
                z-index: 4;
            }
            div.blue{
                position: absolute; 
                left: 90px;
                top: 70px;
                z-index: 3;
            }
            */
            img {
                width: 10px;
                height: 10px;
            }
            div{
                width: 100px; 
                height: 100px;
            }
            div.red{
                position: relative;
                top: 70px;
                left: 50px;
            }
        </style>
    </head>
    <body>
        <img src="images/movie_image.jpg">
        <br>
        <img src="images/movie_image.jpg">
        <div>
            <div class="red" style="background:red">RED</div>
            <div class="green" style="background:green">GREEN</div>
            <div class="blue" style="background:blue">BLUE</div>  
        </div>
    </body>
</html>
```

clear : both; /* 이전 요소 하고는 관계없이 새롭게 float을 하겠다 의미 */

이전 요소의 위치에 따라 해당 요소의 위치가 상대적으로 바뀌는 것을 `relative` 포지션이라 한다.

![day04%209da4673fb6b6469fb3b9f3e7d8e8e497/Untitled%209.png](day04%209da4673fb6b6469fb3b9f3e7d8e8e497/Untitled%209.png)

로그를 클릭하면 메인으로 돌아가게 할 것 이다. 메뉴들이 로그인, 가입 메뉴, 상품 목록, 장바구니가 있는데 오른쪽에 보이도록 한다. aside가 오른쪽에 보이도록 영역 분리해주자