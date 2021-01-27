# day05

- sortcss.html

```html
<!DOCTYPE html>
<html>
    <head>
        <style>
        div{
            border: 1px solid;
        }
        div.out{ /* class속성값이 out인 요소를 선택 */
            width: 200px;
            height: 200px;
            /* line-height: 200px; */
        }
        div.in{ /* 블럭요소는 자신의 크기와 위치 지정 가능하다 */
            width: 80px;
            height: 80px;
            margin: 60px auto; /* 상하마진으로 수직중앙정렬 
                                  좌우마진 auto로 수평중앙정렬 */
        }

        div.out1{ /* 부모 */
            width: 200px;
            height: 200px;
            text-align: center; /* 자식인라인요소의 수평정렬 */
            line-height: 200px; /* height값과 동일하게 설정하면
                                   자식인라인요소의 수직중앙정렬 */
        }
        span.in1{ /* 인라인요소는 자신의 크기와 위치지정 불가능하다. 
                     크기는 내용에 따라 결정
                     위치는 부모요소에 의해 결정*/
            width: 80px; /* 효과없음 */
            height: 80px; /* 효과없음 */
            border: 1px solid;
        }
        </style>
    </head>
    <body>
        <div class="out"> <!--블럭요소-->
            <div class="in">DIV1</div> <!--블럭요소-->
        </div>
        <div class="out1"> <!--블럭요소-->
            <span class="in1">SPAN1</span> <!--인라인요소-->
        </div>
    </body>
</html>
```

블럭요소는 한 줄을 다 차지하려 한다. 크기 지정 가능하며 위치를 지정 안해주면 좌측 상단에 가려는 구조로 되어있다. 블럭요소는 자기 크기를 지정할 수 있는 특성이 있기 때문에 안쪽에 있는 블럭 요소의 크기를 지정함으로써 수평, 수직 징렬을 할 수 있다.

margin 10px auto → 상하 10px 좌측 우측을 auto로 설정했다는 뜻

수직 정렬인 line-height를 height하고 같은 값을 주면 text의 줄 간격을 중앙에 위치 되도록 하는 것 뿐이다. 텍스트는 수직 중앙에 위치는 했으나 블럭요소 테두리는 계속 현재의 상단 위치에 계속 머물러 있다. 그래서 텍스트에서만 효과가 난다. 이럴 때는 위쪽 마진하고 아래쪽 마진을 똑같이 분배해서 설정하는 것이 수직 정렬을 하는 가장 좋은 방법이다. 200-140(80+80)=60 → margin을 60px로 지정

블럭 요소가 아닌 인라인 요소 → span. 인라인 요소의 수평 정렬은 자기가 직접 크기 지정을 할 수 없다. 크기가 자동 결정이 된다. 누가 크기 지정 해야 되는가? 인라인 요소를 담고 있는 부모 요소의 크기 지정을 통해서 정렬을 해줘야 한다. 바깥쪽 div블럭이 span을 포함하고 있는 부모 요소인데 그 부모 요소에 text-align 해주면 수평 정렬을 해준다. 부모 쪽에 설정을 해주면 된다. 그리고 line-height를 height와 같은 값을 주어 수직 정렬도 해줄 수 있다.

실행결과 >

![day05%2074a7e086d4d24e799439c83c0c522784/Untitled.png](day05%2074a7e086d4d24e799439c83c0c522784/Untitled.png)

---

- unitcss.html

```html
<!DOCTYPE html>
<html>
    <head>
        <style>
            p {
              font-size: 16px;
              line-height: 2em;
            }
            
            div {
              font-size: 30px;
              border: 1px solid black;
            }
            
            span {
              font-size: 0.5em;
            }
            </style>
    </head>
    <body>
        <div style="width: 300px; height: 300px; border: 1px solid">
            <div style="border:1px dotted;
                        /* width: 150px; */
                        width: 50%;
                       ">DIV1</div>
            <img src="images/coffee-34251_640.png"
                 width="40%"
            >
        </div>
        
        <!--em단위 : 기본글꼴의 16px단위 대문자 M을 기준으로한 단위-->
        <p>These paragraphs have a calculated line-height of: 2x16px = 32px.</p>
        <p>These paragraphs have a calculated line-height of: 2x16px = 32px.</p>
        <p>These paragraphs have a calculated line-height of: 2x16px = 32px.</p>
        <div>The font-size of the div element is set to 30px. <span>The span element inside the div element has a font-size of 0.5em, which equals to 0.5x30 = 15px</span>.</div>
    </body>
</html>
```

부모를 기준 한 % 비율이다.

width="" 방법과 style="width: " 방법이 있다.

width의 이미지를 100%하면 부모에 해당하는 100%가 되는 거다. 비율 지정 할 때에는 부모가 기준이 된다. 원래 크기 그대로 사용하려면 auto로 설정 해주면 된다.

1em 16px기준으로 설정하면 2em은 두 배인 32px기준이 되어버린다. 16px로 웹 브라우저에서 기본 채택하고 있다

---

- positioncss1.html

```html
<!DOCTYPE html>
<html>
    <head>

    </head>
    <body>
        <!-- <div style="background-color: lightgray; 
                    margin: 30px;
                    width:280px; height:300px;">
            <div style="background-color: red; 
                        position: absolute;
                        left: 20px;
                        top: 20px;
                        width:50px; height:50px;">RED</div>
            <div style="background-color: green; width:50px; height:50px;">GREEN</div>
            <div style="background-color: blue; width:50px; height:50px;">BLUE</div>
        </div> -->

        <div style="background-color: lightgray; 
                    margin: 30px;
                    position: relative;
                    width:280px; height:300px;">
            <div style="background-color: red; 
                        position: absolute;
                        left: 20px;
                        top: 20px;
                        width:50px; height:50px;">RED</div>
            <div style="background-color: green; width:50px; height:50px;">GREEN</div>
            <div style="background-color: blue; 
                        position: fixed;
                        bottom: 10px;
                        right: 10px;
                        width:50px; height:50px;">BLUE</div>
        </div>
    </body>
</html>
```

![day05%2074a7e086d4d24e799439c83c0c522784/Untitled%201.png](day05%2074a7e086d4d24e799439c83c0c522784/Untitled%201.png)

position을 relative로 설정하면 상대 위치로 지정하겠다는 의미를 한다. 자식이 absolute일 경우 left가 20px이면 부모 영역에서부터 20px이다. 부모 기준 절대 위치가 되는 거다. relative를 안주면 부모 기준이 아니라 브라우저 기준이 된다.

fixed라는 포지션을 쓰게 되면 스크롤이 움직여도 따라가지 않고 항상 고정된 위치를 유지한다.

---

- semanticss1.html

```html
<!DOCTYPE html>
<html>
    <head>
        <title>시멘틱태그-CSS</title>
        <style>
            * { 
                box-sizing: border-box;

                color : #000000; 
                /* font-size: 1.25em; */
            }
            header { background: #f6f5ef; 
                     margin: 5px auto;
                     position: relative;
            } 
            /*section{background-color:#eef2f3; height:500px; margin-bottom: 5px;}
            section>article.one{background-color: #b3ffd9}
            section>article.two{background-color: #1e3932;color:white;}*/
            
	footer{ background-color: #2C2A29;  color:#fff;  }
            header, footer { height:100px; width: 1100px;  }
            header>nav>ul{ list-style-type: none; padding: 0px;}
            header>nav>ul>li{ 
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
            
            header>h1{
                width: 30%;    
                margin: 0 auto;
                height: 100%;
                display: inline-block;
                position: relative;
                border: 1px solid;
            }
            /* 이미지 로고 */
            header>h1>a{
                display: block;
                width : 100%;
                height:100%;
                margin: 0;
                padding: 0;
                
                position: absolute;
                top: 10px;
                left: 0px;
                
                background-image: url('./images/logo.png');
                background-repeat: no-repeat;
            }
            header>nav{
                display: inline-block;
                width : 60%;
                height: 100%;
                border: 1px solid;
                position: absolute;
                top: 0px;
                right: 0px;
            }
            section{background-color:#eef2f3; 
                width: 1100px;
                height:500px; 
                margin-bottom : 5px;
            }
            section>div{
                width: 60%;
                height: 100%;
                float: left;
            }
            section>div>article.one{background-color: #b3ffd9;
                width: 100%;
                height:40%;
                
            }
            section>div>article.two{background-color: #1e3932;color:white;
                width: 100%;
                height:40%;
            }
            section>aside{
                width: 30%;
                height:100%;
                float: right;               
            }
            /* 광고이미지 반응*/
            section>aside .pc-badge{
                display: block;
            }
            section>aside .mobile-badge {
                display: none;
            }
            
            @media screen and (max-width: 960px){
                section>aside .pc-badge {
                    display: none;
                }
               section>aside .mobile-badge {
                   display: block;
                }
            }

            /*메뉴 반응*/
            header>nav.small{
                display:none;
            }
            @media screen and (min-width: 641px) and (max-width: 960px){
                header>nav.small{
                    display:inline-block;
                }
                header>nav.large{
                    display:none;
                }
            }
        </style>
    </head>
    <body>
        <header>
            <!--<h1>스타벅스</h1>-->
            <h1><a href="#"></a></h1>
            <nav class="large">
                <ul>
                    <li><a href="login.html">로그인</a></li>
                    <li><a href="signup.html">가입</a></li>
                    <li><a href="productlist.html">상품목록</a></li>
                    <li><a href="viewcart.html">장바구니</a></li>
                </ul>
            </nav>
            <nav class="small">
                <ul>
                    <li><a href="login.html">로그인</a></li>
                    <li><a href="signup.html">가입</a></li>                    
                </ul>
            </nav>

        </header>
        <section>
            <div>
                <article class="one">
                스타벅스만의 특별한 혜택, 스타벅스 <mark>리워드</mark>
    스타벅스 회원이세요? 로그인을 통해 나만의 리워드를 확인해보세요.
    스타벅스 회원이 아니세요? 가입을 통해 리워드 혜택을 즐기세요.
                </article>
                <article class="two">
                    푸드 간편하지만 든든하게 채워지는 만족감을 느껴보세요. 신선함과 영양이 가득한 스타벅스 푸드가 완벽한 하루를 만들어 드립니다.
                </article>
            </div>
            <aside>
                <div class="strawberry">
                    <a href="https://www.starbucks.co.kr/whats_new/newsView.do?seq=4012" title="자세히 보기">
                        <img src="https://image.istarbucks.co.kr/upload/common/img/main/2021/strawberrymd_pc_210112.png" alt="" class="pc-badge">
                        <img src="https://image.istarbucks.co.kr/upload/common/img/main/2021/strawberrymd_mo_210112.png" alt="" class="mobile-badge">
                    </a>
                </div>
                <div class="plcc">      
                    <a href="/plcc/promotionView.do?eventCode=STH02" title="hyundai card + starbucks">
                        <img src="https://image.istarbucks.co.kr/upload/common/img/main/2020/plcc_badge_pc.png" alt="" class="pc-badge">
                        <img src="https://image.istarbucks.co.kr/upload/common/img/main/2020/plcc_badge_mobile.png" alt="" class="mobile-badge">
                    </a>
                </div>
            </aside>
        </section>
        <footer>
            사업자등록번호 : 201-81-21515 (주)스타벅스커피 코리아 대표이사 : 송 데이비드 호섭 TEL : 1522-3232 개인정보 책임자 : 장석현
ⓒ 2021 Starbucks Coffee Company. All Rights Reserved.
        </footer>        
    </body>
</html>
```

![day05%2074a7e086d4d24e799439c83c0c522784/Untitled%202.png](day05%2074a7e086d4d24e799439c83c0c522784/Untitled%202.png)

article 기사 두 개를 각각 float:left해주면 article이 붙여서 나온다. 그렇게 하면 안되고 동시에 합쳐진 상태로 왼쪽으로 가게 하려면 article 두 개를 포함하고 있는 영역을 만드는 게 좋다 

내용 크기만큼 a요소의 크기가 자동 결정된다. 실제 화면에 보여줄 때는 스타벅스 타이틀을 보고 싶지 않다. 배경 이미지만 보고 싶지 내용은 보고 싶지 않다 텍스트 내용을 지우면 내용이 없으면 가로, 넓이가 없어져 배경 이미지도 안 보인다. 

a요소 같은 경우 자동 크기가 되는 요소이니깐 a요소를 강제로 블록요소로 바꾸게 되면 width, hegiht 설정도 할 수 있다. 그렇게 되면 가로,세로 넓이가 공간이 마련이 됨으로 배경 이미지도 보이게 된다.

nav태그는 float을 right를 줘서 오른쪽으로 붙여주면 된다.

footer가 항상 고정되기 원한다면 position을 fixed로 설정 해주면 된다.

---

> **반응형 웹**

웹 페이지 하나로도 데스크톱, 태블리pc, 스마트폰에 맞게 디자인이 자동으로 반응해서 변경되는 웹 페이지

**뷰포트 설정**

meta 태그 : 추가적인 웹 페이지 정보를 제공

meta태그는 closing태그가 없다. 태그가 열리기만 해야 한다. meta태그를 이용해 반응형 웹을 만들 수 있다. name속성, content속성을 지정 해주면 된다.

`initial-scale` : 초기 확대 비율

 `maximum-scal` : 최대 확대 비율 

`user-scalabe` : 확대 및 축소 가능 여부

initial-scale=1 → 휴대폰에서 가장 최적화된 상태로 보여준다.

@media 미디어타입 and ( 조건 ) { 

프로퍼티명 : 값;.... 

}

정렬할 때 왼쪽으로 하고 싶다면? 

1. float을 left로 주는 방법 

2. display 속성을 inline-block으로 설정하면 된다.

![day05%2074a7e086d4d24e799439c83c0c522784/Untitled%203.png](day05%2074a7e086d4d24e799439c83c0c522784/Untitled%203.png)

![day05%2074a7e086d4d24e799439c83c0c522784/Untitled%204.png](day05%2074a7e086d4d24e799439c83c0c522784/Untitled%204.png)

singn in 검사해서 nav태그의 스타일을 보자 줄이게 되면 display:none이 되는 것을 볼 수 있다.

- productlist.html

```html
<!DOCTYPE html>
<html>
    <head>
        <title>상품목록</title>
        <style>
            *{
                box-sizing: border-box; /* width값이 전체 너비 */
                padding: 0;
                margin: 0;
            }
            div.productlist{
                background-color: white;
                width: 100%;
                height: 600px;
                /* margin: 10px; */
                overflow: auto;
            }
            div.productlist>div.product{
                width: 320px;
                height: 400px;
                border: 1px solid;
                float: left;
            }
            div.productlist>div.product>ul{
                list-style-type: none;
                padding-left: 0;
            }
        </style>
    </head>
    <body>
        <div class="productlist">
        <!-- 하나의 상품 -->
            <div class="product">
                <ul>
                    <li><img src="./images/C0001.jpg" alt="나이트로 바닐라 크림"></li>
                    <li>나이트로 바닐라 크림</li>
                    <li>1,000</li>
                </ul>
            </div>

            <div class="product">
                <ul>
                    <li><img src="./images/C0002.jpg" alt="나이트로 콜드 브루"></li>
                    <li>나이트로 콜드 브루</li>
                    <li>1,000</li>
                </ul>
            </div>

            <div class="product">
                <ul>
                    <li><img src="./images/C0003.jpg" alt="돌체 콜드 브루"></li>
                    <li>돌체 콜드 브루</li>
                    <li>1,000</li>
                </ul>
            </div>

            <div class="product">
                <ul>
                    <li><img src="./images/C0004.jpg" alt="제주 비자림 콜드 브루"></li>
                    <li>제주 비자림 콜드 브루</li>
                    <li>1,000</li>
                </ul>
            </div>

            <div class="product">
                <ul>
                    <li><img src="./images/C0005.jpg" alt="콜드 브루 몰트"></li>
                    <li>콜드 브루 몰트</li>
                    <li>1,000</li>
                </ul>
            </div>

            <div class="product">
                <ul>
                    <li><img src="./images/C0006.jpg" alt="바닐라 크림 콜드 브루"></li>
                    <li>바닐라 크림 콜드 브루</li>
                    <li>1,000</li>
                </ul>
            </div>

            <div class="product">
                <ul>
                    <li><img src="./images/C0007.jpg" alt="콜드 브루 플로트"></li>
                    <li>콜드 브루 플로트</li>
                    <li>1,000</li>
                </ul>
            </div>

        </div>
    </body>
</html>
```

- productdetail.html

```html
<!DOCTYPE html>
<html>
    <head>
        <title>상품상세목록</title>
        <style>
             div.productdetail{
                 box-sizing: border-box; /* 전체 넓이가 될 수 있다 */
                 width: 100%;
                 height: 300px;
             }
             div.productdetail>div.productdetail_img{
                 width: 35%;
                 float: left;
             }
             div.productdetail>div.productdetail_img>img{
                 width: 100%;
             }
             div.productdetail>div.productdetail_info{
                 width: 60%;
                 float: right;
             }
             div.productdetail>div.productdetail_info>form>ul{
                 list-style-type: none;
                 padding-left: 10px;
             }
        </style>
    </head>
    <body>
        <div class="productdetail">
            <div class="productdetail_img">
                <img src="./images/C0001.jpg" alt="나이트로 바닐라 크림">
            </div>
            <div class="productdetail_info">
                <h1>나이트로 바닐라 크림</h1>
                <hr>
                <form>
                    <input type="hidden" name="prod_no" value="C0001">
                    <ul>
                        <li>부드러운 목넘김의 나이트로 커피와 바닐라 크림의 매력을 한번에 느껴보세요!</li>
                        <li>가격: 1,000</li>
                        <li>수량: <input name="quantity" type="number" min="1" max="99" step="1" value="1" ></li>
                        <li><input type="submit" value="장바구니넣기"></li>
                    </ul>
                </form>
            </div>
        </div>
    </body>
</html>
```

![day05%2074a7e086d4d24e799439c83c0c522784/Untitled%205.png](day05%2074a7e086d4d24e799439c83c0c522784/Untitled%205.png)

- viewcart.html

```html
<!DOCTYPE html>
<html>
    <head>
        <title>장바구니</title>
        <style>
            div.viewcart{
                box-sizing: border-box;
                width: 100%;
                height: 300px;  /*부모쪽에 절대영역 크기 지정 */
                /* height: 100%; 부모의 body에 크기가 지정 되어있지 않으므로 아무 효과가 안일어난다. */
            }
            div.viewcart>table{
                width: 50%;
                height: 100%; /* 부모영역 300px를 다 사용하겠다 의미 */
                border-collapse: collapse; /* 하나의 테두리로 설정 */
            }

            div.viewcart>table, div.viewcart>table td, div.viewcart>table th{ /* 세개 요소를 선택하는거다..table요소하고 테이블 요소의 후손으로 td,tr요소를 선택해라*/
                border: 1px solid;
            }
            div.viewcart>table tr{
                vertical-align: bottom;
            }
            div.viewcart>table td.prod_price,
            div.viewcart>table td.quantity,
            div.viewcart>table td.amount,
            div.viewcart>table td.total_amount{
                text-align: right;
            }
            div.viewcart>table td.total_amount{
                    font-weight: bold;
                    color: red;
                    border-color : black;
            }
        </style>
    </head>
    <body>
        <div class="viewcart">
            <h1>장바구니</h1>
            <table>
                <tr><th>상품번호</th>
                    <th>상품명</th>
                    <th>가격</th>
                    <th>수량</th>
                    <th>금액</th>
                </tr>
                <tr><td>C0001</td>
                    <td>나이트로 바닐라 크림</td>
                    <td class="prod_price">1,000</td>
                    <td class="quantity">3</td>
                    <td class="amount">3,000</td>
                </tr>
                <tr><td>C0003</td>
                    <td>돌체 콜드 브루</td>
                    <td class="prod_price">1,500</td>
                    <td class="quantity">1</td>
                    <td class="amount">1,500</td>
                </tr>
                <tr>
                    <td colspan="5" class="total_amount">총금액: 4,500</td>
                </tr>
            </table>
            <form>
                <input type="submit" value="주문하기">
            </form>
        </div>
    </body>
</html>
```

부모의 크기가 지정되어있지 않으면 자식에서 비율로 크기 지정 못한다. 부모 쪽에 반드시 크기가 지정되어 있어야 자식 쪽에서 찾아갈 수 있는 거다.

블럭요소가 중앙에 배치되려면 수평 정렬하려면 좌우 margin 을 auto 로, 수직 정렬을 하려면 상하 margin을 잘 조절하면 된다. 

인라인 요소에 수평 정렬하는 방법은 인라인의 부모 요소 입장에서 위치 조정을 해줘야 한다. 수평 정렬하기 위해서는 text-align 그리고 수직 정렬을 하려면 line-height값과 height을 같은 값을 주면 된다.

tr요소는 블럭 요소이다. 크기 지정이 가능하다. 자동 줄 바꿈이 된다.  tr요소에 td많이 들어가다 보니 중앙 정렬 할 때 방법이 블럭, 인라인 요소와 달리 수평 정렬할 때에는 text-align을 사용하고 행의 수직 정렬을 하고 싶다면 vertical-align을 해준다.

장바구니는 클라인어트 쪽이 갖고 있는 게 아니라 서버에 기억이 되고 있는 거다.

그러므로 서버 쪽의 장바구니 내용을 갖고 주문하기 작업을 하면 된다.

![day05%2074a7e086d4d24e799439c83c0c522784/Untitled%206.png](day05%2074a7e086d4d24e799439c83c0c522784/Untitled%206.png)

- vieworder.html 내가 한 소스코드

    ```html
    <!DOCTYPE html>
    <html>
        <head>
            <title>주문내역</title>
            <style>
                div.vieworderlist{
                    box-sizing: border-box;
                    width: 100%;
                    height: 300px;
                }
                div.vieworderlist>table{
                    width: 50%;
                    height: 100%;
                    border-collapse: collapse;
                }
                div.vieworderlist>table, div.vieworderlist>table th, div.vieworderlist>table td{
                    border: 1px black solid;
                    text-align: center;
                }
            </style>
        </head>
        <body>
            <div class="vieworderlist">
                <h1>주문내역</h1>
                <table>
                    <tr><th>주문번호</th>
                        <th>주문일자</th>
                        <th>상품번호</th>
                        <th>상품명</th>
                        <th>가격</th>
                        <th>수량</th>
                        <th>금액</th>
                    </tr>
                    <tr><td rowspan="2">15</td>
                        <td rowspan="2">21/01/27</td>
                        <td>C0003</td>
                        <td>돌체 콜드 브루</td>
                        <td>1,500</td>
                        <td>1</td>
                        <td>1,500</td>
                    </tr>
                    <tr><td>C0001</td>
                        <td>나이트로 바닐라 크림</td>
                        <td>1,000</td>
                        <td>3</td>
                        <td>3,000</td>
                    </tr>
                    <tr><td>10</td>
                        <td>21/01/24</td>
                        <td>C0001</td>
                        <td>나이트로 바닐라 크림</td>
                        <td>1,000</td>
                        <td>1</td>
                        <td>1,000</td>
                    </tr>
                    <tr><td rowspan="2">4</td>
                        <td rowspan="2">21/01/10</td>
                        <td>C0002</td>
                        <td>나이트로 콜드 브루</td>
                        <td>1,000</td>
                        <td>1</td>
                        <td>1,000</td>
                    </tr>
                    <tr><td>C0004</td>
                        <td>제주 비자림 콜드 브루</td>
                        <td>1,500</td>
                        <td>2</td>
                        <td>3,000</td>
                    </tr>
                    <tr><td>2</td>
                        <td>21/01/10</td>
                        <td>C0001</td>
                        <td>나이트로 바닐라 크림</td>
                        <td>1,000</td>
                        <td>1</td>
                        <td>1,000</td>
                    </tr>
                </table>
            </div>
        </body>
    </html>
    ```