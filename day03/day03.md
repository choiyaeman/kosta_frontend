# day03

일반 button은 클릭되도 아무 효과가 없고 submit 버튼은 클릭을 하면 서버로 데이터로 전송하여 제출이 된다.

reset버튼은 클릭했을 때 이제껏 사용자들이 입력했던 값들이 기본 값으로 다 초기화 된다.

width, hegitht속성은 table, img태그에만 쓰되 다른 태그에서 쓰려면 style이라는 속성이 필요하다

블록요소는 크기 지정 가능하나 인라인 요소는 크기 지정 못한다. 인라인 요소는 크기가 요소에 따라 자동 조절된다. 

- blockinline.html

```html
<!DOCTYPE html>
<html>
    <haed>
        <title>블록요소와 인라인요소</title>
    </haed>
    <body>
        <!--블록요소: 1줄을 모두 사용하는 요소. 자동 줄바꿈 됨
        h1~h6, p, ol, ul, li, table, tr, form, fieldset, legend
        div, header, section, nav, article, aside, footer
        -->
        <div style="width:300px; height:100px; border:1px solid;margin-bottom: 10px;">DIV1</div> 
        <div style="width:300px; height:100px; border:1px solid;margin-top: 20px;">DIV2</div>
        <div style="width:300px; height:100px; border:1px solid;">DIV3</div>
        <!--인라인요소: 크기가 요소의 내용에 따라 자동 조절됨
            width, height, margin-bottom, margin-top무시 됨!
        a, th, td, img, input, select, textarea
        -->
        <span style="width:300px; height:100px; border:1px solid;margin-bottom: 10px;">SPAN1</span>
        <span style="width:300px; height:100px; border:1px solid;margin-top: 20px;">SPAN2</span>
        <span style="width:300px; height:100px; border:1px solid;">SPAN3</sapn>

        <!--인라인-블럭요소: 줄바꿈 안됨. 크기조절가능-->
        <img src="./images/movie_image.jpg" width="200px">
        <span></span>
    </body>
</html>
```

![1](https://user-images.githubusercontent.com/63957819/105680163-b6836500-5f32-11eb-997f-a110979ac863.png)

DIV1 검사하면 블록 요소인 것을 확인 할 수 있다.

![2](https://user-images.githubusercontent.com/63957819/105680169-b7b49200-5f32-11eb-9ba6-c8ca82f703ee.png)

다른 요소 사이의 간격 설정을 할 수 있는데 그것을 마진이라 한다.

마진 값이 서로 겹칠 때는 전체 마진 값이 더해지는 게 아니라 최대 값으로 설정이 된다.

---

**CSS(Cascade StyleSheet)**

:점진적인 순차적인 의미를 담고 있기 때문에 아래쪽에 있는 것이 최종 상태이므로 덮어쓰기가 된다.

페이지 내용이 많을 시 랜더링 엔진이 처리할 내용이 많아지므로 웹 브라우저 화면이 느리게 나온다.

각 요소의 속성들도 중복되어 있기 때문에 중복된 속성들을 하나로 관리하자고 한다면 스타일 처리 용 문법을 공부해야 한다.

```html
<style>
	div{
	     width: 300px;
       height: 100px;
  }
</style>
```

인라인 스타일 표기법 그리고 그냥 스타일 표기법으로 작성하는 방법이 있다.

- css.html

```html
<!DOCTYPE html>
<html>
    <head>
        <style>
            body { background-color: cornsilk;}
            /* div {border: 1px solid;} 모든 div요소에 스타일이 적용됨! */
            #div2 {border: 1px solid;} /* id속성값이 div2인 요소를 선택해서 스타일 적용 */
            p, li {color: red;} /* p요소와 li요소들을 선택해서 스타일 적용됨 */
            .green {color: green} /* class속성값이 green인 요소들을 선택해서 스타일 적용 */
            table tr>td {background-color: darkgray;} /* 후손선택자: 공백
                                                            자식선택자: >
                                                        */
        </style>
    </head>
    <body>
        <div>
            <div>
                <p style="color: blue;"> <!-- 인라인 스타일이 내부 style보다 우선순위 높다-->
                    단락1
                </p>
            </div>
            <div>
                <ul>
                    <li style="color: blue">ONE</li>
                    <li>TWO</li>
                    <li>THREE</li>
                </ul>
            </div>
            <div style="color:blue">

            </div>
        </div>
        <div id="div2"> <!--id속성값은 중복되면 안됨!-->
            <div>
                <p class="green"> <!--class속성값은 중복가능!-->
                    단락1
                </p>
            </div>
            <div>
                <ul>
                    <li class="green">ONE</li>
                    <li>TWO</li>
                    <li class="green">THREE</li>
                </ul>
            </div>
            <div>
                <table>
                    <tr>
                        <td>AAA</td>
                        <td>BBB</td>
                        <td>CCC</td>
                    </tr>
                    <tr>
                        <td>DDD</td>
                        <td>EEE</td>
                        <td>FFF</td>
                    </tr>
                </table>
            </div>
				</div>
    </body>
</html>
```

인라인 스타일이 내부 style보다 우선순위 높다

여러 스타일 속성을 구분 하려면 새미콜론을 붙이면 된다. 다른 프로퍼티를 설정 안 하는 경우에는 새미콜론을 안 붙여도 된다.

아이디 속성은 중복되지 않은 값으로 할당되어야 한다.

![3](https://user-images.githubusercontent.com/63957819/105680172-b84d2880-5f32-11eb-842c-0be841c464c0.png)

name속성은 서버로 제출하는 용도, 제출하지 않으려면 안 적으면 된다.class 속성은 css 관련된 속성이고 id속성도 css와 관련이 있지만 js와도 관련이 많다.

![4](https://user-images.githubusercontent.com/63957819/105680174-b84d2880-5f32-11eb-9b49-2d00cd457696.png)

`>`는 **자식 선택자**를 의미한다. 

`공백 한 칸`은 **후손 선택자**

![5](https://user-images.githubusercontent.com/63957819/105680177-b8e5bf00-5f32-11eb-967a-3249570dace4.png)

table태그의 자식으로 tbody라는 태그를 중간에 끼어 넣는다. 그러므로 자식 선택자를 이용하여 table>tbody 를 해주면 되나 브라우저마다 다르므로 table과 tr사이에 선택자를 골라주는데 후손 선택자로 설정 해줘야 한다. table의 후손 요소로 tr요소를 찾아가게 된다.

![6](https://user-images.githubusercontent.com/63957819/105680179-b8e5bf00-5f32-11eb-8b1d-9ba8b5fd7d7f.png)

이런 형식으로 만들어보자

- sementiccss.html

```html
<!--semantic.html-->
<!DOCTYPE html>
<html>
    <head>
        <title>시멘틱태그-CSS</title>
        <style>
            * { color : #000000; }
            header { background: #f6f5ef; margin: 5px auto;} 
            section{background-color:#eef2f3; height:500px; margin-bottom: 5px;}
            section>article.one{background-color: #b3ffd9}
            section>article.two{background-color: #1e3932;color:white;}
            footer{ background-color: #2C2A29;  color:#fff;  }
            header, footer { height:100px; }
        </style>
    </head>
    <body>
        <header>
            <h1>스타벅스</h1>
            <nav >
                <a href="login.html">로그인</a>
                <a href="signup.html">가입</a>
            </nav>

        </header>
        <section>
            <article class="one">
            스타벅스만의 특별한 혜택, 스타벅스 <mark>리워드</mark>
스타벅스 회원이세요? 로그인을 통해 나만의 리워드를 확인해보세요.
스타벅스 회원이 아니세요? 가입을 통해 리워드 혜택을 즐기세요.
            </article>
            <article class="two">
                푸드 간편하지만 든든하게 채워지는 만족감을 느껴보세요. 신선함과 영양이 가득한 스타벅스 푸드가 완벽한 하루를 만들어 드립니다.
            </article>
            <aside>
                나의 큐피트를 받아줘.
                현대카드.
            </aside>
        </section>
        <footer>
            사업자등록번호 : 201-81-21515 (주)스타벅스커피 코리아 대표이사 : 송 데이비드 호섭 TEL : 1522-3232 개인정보 책임자 : 장석현
ⓒ 2021 Starbucks Coffee Company. All Rights Reserved.
        </footer>        
    </body>
</html>
```

실행 결과>>

![7](https://user-images.githubusercontent.com/63957819/105680181-b97e5580-5f32-11eb-8389-4be853846030.png)

**속성 선택자**

`선택자[속성]` : 특정한 속성이 있는 태그 선택

`선택자[속성=값]` : 특정한 속성 내부 값이 특정 값과 같은 태그 선택

![8](https://user-images.githubusercontent.com/63957819/105680185-ba16ec00-5f32-11eb-8bb6-fa19ae5e8573.png)

→ 로그인

![9](https://user-images.githubusercontent.com/63957819/105680186-ba16ec00-5f32-11eb-991c-0b3448c9d326.png)

→ 가입

- login.html

```html
<!DOCTYPE html>
<html>
    <head>
        <style>
            input[name="id"]{ background-color: yellow; }
            input:not([type ="text"]) { background-color: green; color: white; }
            /* form span.saveid{ color: blue; font-weight: bold;} */
            /* form>label>input[type=checkbox]+span.saveid { color: blue; font-weight: bold; } */
            form>label>input[type=checkbox]~span.saveid{ color: blue; font-weight: bold; }
        </style>
    </head>
    <body>
        <form>
            <label>아이디<input type="text" name="id" size="10" maxlength="5"></label><br>
            <label>비밀번호<input type="password" name="pwd" maxlength="5"></label><br>
            <label><input type="checkbox" id="saveid"><span class="saveid">아이디 저장</span></label>
            <input type="submit" value="로그인">
        </form>
    </body>
</html>
```

input태그는 클로징 태그를 안 만들어도 된다.

아이디 저장은 input요소의 바디가 아니고 형제인 거다. 아이디 저장이라는 내용을 선택자로 찾아갈 때 가장 좋은 방법은 label의 자식인 span요소로 찾아가는 게 좋다. 후손 선택자 사용

![10](https://user-images.githubusercontent.com/63957819/105680188-baaf8280-5f32-11eb-8452-48dbcd7ada4c.png)

id라는 컬럼이 최대 다섯 자리로 설정되어 있다. 그래서 maxlength를 5로 설정

input:not해줄 경우, 인풋 요소들 중에서 type=text가 아닌 password, checkbox, submit인 얘들을 찾을 것이다.

`E+F`는 E요소의 바로 다음에 나오는 형제 요소를 찾는 선택자

`E~F`는 바로 다음에 나오는 형제가 아니라도 형제 요소를 찾아주는 선택자

![11](https://user-images.githubusercontent.com/63957819/105680189-baaf8280-5f32-11eb-9a4f-820c70ad5a5d.png)

- semanticcss.html

```html
<!--semantic.html-->
<!DOCTYPE html>
<html>
    <head>
        <title>시멘틱태그-CSS</title>
        <style>
            * { color : #000000; 
                /* font-size: 1.25em; */
            }
            header { background: #f6f5ef; margin: 5px auto;} 
            section{background-color:#eef2f3; height:500px; margin-bottom: 5px;}
            section>article.one{background-color: #b3ffd9}
            section>article.two{background-color: #1e3932;color:white;}
            footer{ background-color: #2C2A29;  color:#fff;  }
            header, footer { height:100px; }
            header>nav>ul{ list-style-type: none; padding: 0px; }
            header>nav>ul>li {
             width:100px; 
             display: inline-block; 
             margin: 0px 10px; 
             text-align: center; 
            }

            header>nav>ul>li>a{
                text-decoration: none;
            }
            header>nav>ul>li>a:hover{
                background-color: black;
                color: white;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <header>
            <h1>스타벅스</h1>
            <nav>
                <ul>
                    <li><a href="login.html">로그인</a></li>
                    <li><a href="signup.html">가입</a></li>
                </ul>
            </nav>

        </header>
        <section>
            <article class="one">
            스타벅스만의 특별한 혜택, 스타벅스 <mark>리워드</mark>
스타벅스 회원이세요? 로그인을 통해 나만의 리워드를 확인해보세요.
스타벅스 회원이 아니세요? 가입을 통해 리워드 혜택을 즐기세요.
            </article>
            <article class="two">
                푸드 간편하지만 든든하게 채워지는 만족감을 느껴보세요. 신선함과 영양이 가득한 스타벅스 푸드가 완벽한 하루를 만들어 드립니다.
            </article>
            <aside>
                나의 큐피트를 받아줘.
                현대카드.
            </aside>
        </section>
        <footer>
            사업자등록번호 : 201-81-21515 (주)스타벅스커피 코리아 대표이사 : 송 데이비드 호섭 TEL : 1522-3232 개인정보 책임자 : 장석현
ⓒ 2021 Starbucks Coffee Company. All Rights Reserved.
        </footer>        
    </body>
</html>
```

![12](https://user-images.githubusercontent.com/63957819/105680190-bb481900-5f32-11eb-8922-e3f0f0503022.png)

**반응 선택자**

`:hove` 사용자가 마우스 커서를 올린 태그 선택

`:active` 사용자가 마우스로 클릭한 태그 선택

**상태 선택자**

`:checked` 체크 상태의 input 태그 선택

`:focus` 포커스를 맞춘 input 태그 선택 → 커서가 클릭 되어져 있는 곳을 의미

`:enabled` 사용 가능한 input태그 선택

`:disabled` 사용 불가능한 input 태그 선택 → 비활성화를 의미

`margin`은 다른 요소와의 간격

`padding`은 실제 내용하고 테두리 사이의 간격

**구조 선택자**

`:first-child` 형제 관계어서 첫 번째로 등장하는 태그 선택

`:last-child` 형제 관계에서 마지막으로 등장하는 태그 선택

`:nth-child(수열)` 형제 관계에서 앞에서 수열 번째로 등장하는 태그 선택

ex) nth-child(2n); → 짝수 0,2,4,~

`:nth-last-child(수열)` 형제 관계에서 뒤에서 수열 번째로 등장하는 태그 선택

li요소가 줄 바꿈 되면서 a요소들이 줄 바꿈 되는 것처럼 보이는 거다. li요소들이 기본 블록 요소이기 때문에 자동 줄 바꿈이 되어서 메뉴가 아래로 내려간다. 블록 요소가 아닌 인라인 요소로 바꾸겠다 하면 display속성을 사용하면 된다.

li요소가 블록 요소로 크기 지정 가능한데 인라인 요소로 바뀌어서 크기 설정을 해도 바뀌가 않는다. li요소마다 각각 줄이 아니라 같은 줄에 li요소들이 있기를 원하고 각 li요소에 크기 지정을 하고 싶다. 인라인+블록 효과를 내고 싶다 하면 display속성을 inline-block으로 해주면 된다. 화면에 나타나지 않게 하려면 non값을 주면 된다. 영역에 있긴 하지만 화면에 나타나지 않는 것 뿐이다.

**크기 단위**

`%`  : 백분율 단위

`em` : 배수 단위

`px` : 픽셀 단위

ex) em단위 적용하기

em이라는 것은 대문자M 문자 기준으로 100%크기로 == 1EM으로 보고 2EM이면 200%크기로 본다.

`font-size` : 글꼴의 크기

**색상 단위**

`RGB 색상`

ex) rgb(red, green, blue)

`RGBA 색상`

ex) rgba(red, green, blue, alpha) 

여기서 alpha는 투명도를 나타낸다. 

0.0은 완전 투명 상태, 1.0은 완전 불투명 상태

`HEX코드` 

ex) #000000
