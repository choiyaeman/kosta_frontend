# day10

`val()` : 입력 양식의 값을 가져오는 메소드

`append(), prepend(), after(), before()` : 자식, 형제 추가

`remove()` : 자신의 요소 자체를 지우는 것  `empty()` : 내용을 지우는 것 

$("li"); : 선택자로 객체 찾기, $("<li>TEST</li>"); : 객체 생성

`parent()` : 부모 `parents()`: 조상, `parentsUntil()` : 특정 조건까지만 조상 찾기

`children()` : 자식  `find()` : 후손`

`siblings(), next(), nextAll(), nexttUntil() , prev(), prevAll(), prevUntil()`

`first(), last(), eq(), not()`

---

- semanticcssjq.html

```html
<!DOCTYPE html>
<html>
    <head>
        <title>시멘틱태그-CSS-jQuery</title>
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
            section>article{
                width: 60%;
                height: 100%;
                float: left;
            }
            /* section>div{
                width: 60%;
                height: 100%;
                float: left;
            } */
            /* section>div>article.one{background-color: #b3ffd9;
                width: 100%;
                height:40%;
            } */
            /* section>div>article.two{background-color: #1e3932;color:white;
                width: 100%;
                height:40%;
            } */
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
        <!--jquery사용-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
            $(function(){
                //DOM트리에서 메뉴객체들 모두찾기
                var $menuObj = $("header>nav>ul>li>a");
                //메뉴가 클릭되면 
                $menuObj.click(function(){
                    $("section>article").empty(); //article영역 지우기
                    //메뉴객체의 href속성값 얻기
                    //var hrefValue = $menuObj.attr("href"); // (X) 배열의 무조건 0번index객체
                    //var hrefValue = $(this).attr("href");
                    var hrefValue = $(event.target).attr("href");//ex)login.html, signup.html
                    console.log(hrefValue);

                    //AJAX
                    $.ajax({
                        url: "login.html", //요청URL
                        method: "get", //요청방식.   method속성은 생략가능하다 그러면 무조건 get방식이 되는거다. post방식으로 요청하려면 method속성값을 post라 쓰면 된다.
                        success: function(){ //성공응답
                            alert("AJAX요청응답 성공");
                        },
                        error: function(){ //실패응답
                            alert("AJAX요청응답 실패");
                        } 
                    });
                    return false; //event.preventDefault();와 event.stopPropagation(); 실행한것과 같음
                });
            });
        </script>
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
            <article>article...</article>
            <!-- <div>
                <article class="one">
                스타벅스만의 특별한 혜택, 스타벅스 <mark>리워드</mark>
    스타벅스 회원이세요? 로그인을 통해 나만의 리워드를 확인해보세요.
    스타벅스 회원이 아니세요? 가입을 통해 리워드 혜택을 즐기세요.
                </article>
                <article class="two">
                    푸드 간편하지만 든든하게 채워지는 만족감을 느껴보세요. 신선함과 영양이 가득한 스타벅스 푸드가 완벽한 하루를 만들어 드립니다.
                </article>
            </div> -->
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

![day10%202b683c519a1947499514637df7023237/Untitled.png](day10%202b683c519a1947499514637df7023237/Untitled.png)

클라이언트가 요청하고 서버가 응답한다. 브라우저 내의 Networking을 통해 이루어지는 거다. 

네트워킹이 서버로부터 응답 받은 내용을 받아와서 렌더링 엔진에게 준다. 렌더링 엔진이 응답 받은 내용을 한 줄 한 줄 읽는다. html내용 해석하고 **기존 화면을 지우고** 해석된 내용을 렌더링 한다.

네비게이터를 장착하고 차를 타서 해당 페이지를 요청하고 위 경도 값을 가져가서 지도를 보여주는 작업이라 한다면 기존 화면 지우고 새로 지도 지우고  또 기존 화면 지우고 새로 지도 지우고.. 이렇게 되면 화면이 깜빡 거림이 나타나고 점점 심해지면 스피닝 현상이 나타난다. 이걸 해결하기 위해 자바스크립트가 도와준다. 내장되어 있는 객체 중에 XMLHTTPRequest객체가 있는데 자기 나름대로 요청해서 응답을 할 수 있다. xmlhttprequest객체가 요청 진행을 할 수 있다. 응답도 xmlhttprequest객체가 받는다. 이 렌더링엔진 기본 절차를 거치지 않아서 기존 화면 clear되는 기본 작업을 피할 수 있다. 

DOM객체에 html메소드라든가 응답 된 내용을 보여주기 할 수 있다. 응답을 끝까지 기다리지 않고 다른 이벤트 처리를 충분히 할 수 있다. 이런 것을 비동기일처리(Asynchron)라 한다. 그래서 AJAX라 불린다.

기존 페이지를 다 지우지 않으려면 AJAX를 써야 한다. $를 이용해서 jQuery문법을 써야 한다.

![day10%202b683c519a1947499514637df7023237/Untitled%201.png](day10%202b683c519a1947499514637df7023237/Untitled%201.png)

ajax를 이용하여 요청하고 응답을 받기 위해서 전제 조건으로는 서버로 구성이 되어 있어야 한다.

근데 지금 주소 url이 file프로토콜을 쓰고 있다. 웹 서버에 서비스를 해두어야 ajax기술을 사용할 수 있는 거다. 

---

---

![day10%202b683c519a1947499514637df7023237/Untitled%202.png](day10%202b683c519a1947499514637df7023237/Untitled%202.png)

웹 서버를 톰캣을 사용 할 거고 톰캣에 semanticcssjq.html, login.html을 서비스 한다면, 서버 아이피가 a.b.c.d 이고 포트 번호가 8888이라 하자 그럼 http://a.b.c.d:8888/myFront/semanticcssjq.html  여러 개의 프로젝트가 있다 가정하면 정확히 프로젝트 path이름을 적어줘야 한다. 요청하고 응답하면 기존 내용 지우고 응답 되었다. 자바스크립트의 xmlhttpRequest 내장 객체의 도움을 받아서 login.html요청해서 결과를 받는다.

![day10%202b683c519a1947499514637df7023237/Untitled%203.png](day10%202b683c519a1947499514637df7023237/Untitled%203.png)

MyEE파일 새로 만들고 eclipse 경로로 지정 후 Window> preference에 들어가서 

General workspace → utf-8로 설정

WEB에 css, html, jsp file → utf-8로 설정

![day10%202b683c519a1947499514637df7023237/Untitled%204.png](day10%202b683c519a1947499514637df7023237/Untitled%204.png)

경로는 bin을 포함하고 있는 path로 지정한다.

![day10%202b683c519a1947499514637df7023237/Untitled%205.png](day10%202b683c519a1947499514637df7023237/Untitled%205.png)

맨 밑에 시작되었습니다하면 성공한 것!!

![day10%202b683c519a1947499514637df7023237/Untitled%206.png](day10%202b683c519a1947499514637df7023237/Untitled%206.png)

new> dynamic web project 이름 지정해주기

![day10%202b683c519a1947499514637df7023237/Untitled%207.png](day10%202b683c519a1947499514637df7023237/Untitled%207.png)

![day10%202b683c519a1947499514637df7023237/Untitled%208.png](day10%202b683c519a1947499514637df7023237/Untitled%208.png)

WebContent에 WebFrontEnd에서 이제까지 했던 파일들을 다 복사 붙여 넣기 하자~!

![day10%202b683c519a1947499514637df7023237/Untitled%209.png](day10%202b683c519a1947499514637df7023237/Untitled%209.png)

Server에 오른쪽 클릭 >Add and remove

왼쪽은 eclipse프로젝트, 오른쪽은 tomcat서버에 배포하겠다는 뜻

![day10%202b683c519a1947499514637df7023237/Untitled%2010.png](day10%202b683c519a1947499514637df7023237/Untitled%2010.png)

Server시작해서 오류 있는지 check~

![day10%202b683c519a1947499514637df7023237/Untitled%2011.png](day10%202b683c519a1947499514637df7023237/Untitled%2011.png)

![day10%202b683c519a1947499514637df7023237/Untitled%2012.png](day10%202b683c519a1947499514637df7023237/Untitled%2012.png)

[http://localhost:8888/myfront/semanticcssjq.html](http://localhost:8888/myfront/semanticcssjq.html) 접속해보자

한글 깨짐은 meta태그에 encoding을 utf-8로 설정 해주면 된다. → <meta charset="UTF-8">

![day10%202b683c519a1947499514637df7023237/Untitled%2013.png](day10%202b683c519a1947499514637df7023237/Untitled%2013.png)

중복됨으로 myFrontWeb 파일을 과감히 지우고 eclipse에서 쓰일 디렉토리만 남겨두자! MyEE workspace 안쪽에서 관리하자~

여기서 주의해야 할 점! vs code 소스코드가 바뀌면 eclipse코드는 이전 코드로 남아있으므로 tocamt서버에 반영하려면 새로 고침(Refresh)을 해줘야 한다.

404error는 파일 자원을 찾지 못했을 때 발생한다.

- semanticcssjq.html

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>시멘틱태그-CSS-jQuery</title>
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
            section>article{
                width: 60%;
                height: 100%;
                float: left;
            }
            /* section>div{
                width: 60%;
                height: 100%;
                float: left;
            } */
            /* section>div>article.one{background-color: #b3ffd9;
                width: 100%;
                height:40%;
            } */
            /* section>div>article.two{background-color: #1e3932;color:white;
                width: 100%;
                height:40%;
            } */
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
        <!--jquery사용-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
            $(function(){
                //DOM트리에서 메뉴객체들 모두찾기
                var $menuObj = $("header>nav>ul>li>a");
                //메뉴가 클릭되면 
                $menuObj.click(function(){
                    $("section>article").empty(); //article영역 지우기
                    //메뉴객체의 href속성값 얻기
                    //var hrefValue = $menuObj.attr("href"); // (X) 배열의 무조건 0번index객체
                    //var hrefValue = $(this).attr("href");
                    var hrefValue = $(event.target).attr("href");//ex)login.html, signup.html
                    console.log(hrefValue);

                    //AJAX
                    $.ajax({
                        url: hrefValue, //요청URL
                        method: "get", //요청방식.   method속성은 생략가능하다 그러면 무조건 get방식이 되는거다. post방식으로 요청하려면 method속성값을 post라 쓰면 된다.
                        success: function(data){ //성공응답 data는 응답내용
                           //alert("AJAX요청응답 성공");
                           //console.log(data);
                           //article의 영역의 innterHTML로 설정
                           $("section>article").html(data);
                        },
                        error: function(jqXHR){ //실패응답 jqXHR는 jquery xmlRequest객체
                            alert("AJAX요청응답 실패 : 에러코드=" + jqXHR.status);
                        } 
                    });
                    return false; //event.preventDefault();와 event.stopPropagation(); 실행한것과 같음
                });
            });
        </script>
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
            <article>article...</article>
            <!-- <div>
                <article class="one">
                스타벅스만의 특별한 혜택, 스타벅스 <mark>리워드</mark>
    스타벅스 회원이세요? 로그인을 통해 나만의 리워드를 확인해보세요.
    스타벅스 회원이 아니세요? 가입을 통해 리워드 혜택을 즐기세요.
                </article>
                <article class="two">
                    푸드 간편하지만 든든하게 채워지는 만족감을 느껴보세요. 신선함과 영양이 가득한 스타벅스 푸드가 완벽한 하루를 만들어 드립니다.
                </article>
            </div> -->
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

실행결과>

![day10%202b683c519a1947499514637df7023237/Untitled%2014.png](day10%202b683c519a1947499514637df7023237/Untitled%2014.png)

login, signup, productlist, viewcart 모두 보이는 것을 볼 수 있다.

![day10%202b683c519a1947499514637df7023237/Untitled%2015.png](day10%202b683c519a1947499514637df7023237/Untitled%2015.png)

title값은 head태그 안에 들어있는 값이 처리 되는 거지 section의 article안에 있는 title값이 처리 되는 게 아니다. 그러므로 vscode에서 주석 처리해주자~

![day10%202b683c519a1947499514637df7023237/Untitled%2016.png](day10%202b683c519a1947499514637df7023237/Untitled%2016.png)

로그인을 해서 응답 받는 결과란 결과는 두 개 밖에 없다. 로그인이 성공 되거나 실패 되거나 두 개로 나누어진다. /myfront/login이라는 페이지를 요청하게 되면 서버에 로그인이라는 url을 처리해줄 프로그램이 필요하다. 프로그램이 dv하고 일을 해줄 구문인데 프론트 단에서는 db하고 일을 해줄 url을 요청을 해서 응답만 받으면 된다. 요청 방식은 post방식, 응답 되는 내용은 응답 성공 시 응답 내용을 경고 창에 출력, 응답이 실패 된 경우에는 응답 오류 코드를 경고 창에 보여주자 

![day10%202b683c519a1947499514637df7023237/Untitled%2017.png](day10%202b683c519a1947499514637df7023237/Untitled%2017.png)

- LoginController.java

```html
package com.my.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("로그인 실패");
	}
}
```

요청 방식인 post를 처리해줄 자바 메서드는 doPost 메서드가 된다.

- login.html

```html
<!DOCTYPE html>
<html>
    <head>
        <!-- <title>jQuery로 작성한 로그인</title> -->
        <!--jQuery사용-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <script>
            $(function(){ //jQuery(document).ready(function(){})
                //localStorage에 id라는 이름의 아이템이 있으면 그 값을 아이디 입력란에 보여준다.
                let idValue = localStorage.getItem("id");
                if(idValue != null || idValue != '') {
                    //document.querySelector("input[name=id]").value = idValue;
                    //$document.querySelector("input[name=id]").value(idValue);
                    $("input[name=id]").val(idValue);
                 }
                 //DOM트리에서 type속성값이 checkbox인 input객체 찾기
                 let $chkObj = $("input[type=checkbox]");

                 //로그인버튼에서 클릭이벤트 발생하면 폼에서 서브밋 이벤트가 자동 발생한다.
                 //DOM트리에서 form객체 찾기
                 let $formObj = $("form");
                 $formObj.submit(function(event) { //event기술한 목적은 기본 이벤트 처리기를 막기위해서이다.
                     //checkbox가 선택되었는가 localstorage에 아이디값을 저장한다.
                     //if($chkObj.checked){
                     if($chkObj.prop("checked")) { //!주의. 체크박스가 선택되었는지 안되었는지 구분하려면 .prop메서드의 인자로 checked를 써야한다 그래야 선택여부를 확인 할 수있다
                        let $idObj = $("input[name=id]");
                        localStorage.setItem("id", $idObj.val());
                    } else {
                        //checkbox가 선택안되면 localstorage의 아이디값을 제거한다.
                        localStorage.removeItem("id");
                    }
                    $.ajax({
                       url:"./login", //'http://localhost:8888/myfront/login',
                       method:"post",
                       success:function(data){
                          alert(data);
                       },
                       error:function(jqXHR){
                          alert(jqXHR.status);
                       }
                    });
                    //event.preventDefault(); //기본이벤트 처리 막자 
                    return false; //!주의. event.preventDefault(); event.stopPropagation(); 두개의 효과를 다 포함하는 것이 return false이다.
                 });
            });
        //     window.addEventListener("load", function() { //load이벤트가 발생 했다는 것은 dom트리가 완성됐다는 뜻
        //         //localStorage에 id라는 이름의 아이템이 있으면 그 값을 아이디 입력란에 보여준다.
        //         let idValue = localStorage.getItem("id");
        //         if(idValue != null || idValue != '') {
        //             document.querySelector("input[name=id]").value = idValue;
        //         }
        
        //         //DOM트리에서 type속성값이 checkbox인 input객체 찾기
        //         let chkObj = document.querySelector("input[type=checkbox]");
        
        //         //로그인버튼에서 클릭이벤트 발생하면 폼에서 서브밋 이벤트가 자동 발생한다. 
        //         //DOM트리에서 form객체 찾기
        //         let formObj = document.querySelector("form");
        
        //         formObj.addEventListener("submit", function(event) {
        //             //checkbox가 선택되었는가 localstorage에 아이디값을 저장한다.
        //             if(chkObj.checked) { //if(chkObj.checked == true){
        //                 let idObj = document.querySelector("input[name=id]");
        //                 localStorage.setItem("id", idObj.value);
        //             } else {
        //                 //checkbox가 선택안되면 localstorage의 아이디값을 제거한다.
        //                 localStorage.removeItem("id");
        //             }
        //             event.preventDefault(); //기본이벤트 처리 막자  
        //         });
        //     });
        // </script>

        <style>
             input[name="id"]{ background-color: yellow; }
             input:not([type ="text"]) { background-color: green; color: white; }
             /* form span.saveid{ color: blue; font-weight: bold;} */
             /* form>label>input[type=checkbox]+span.saveid { color: blue; font-weight: bold; } */
             form>label>input[type=checkbox]~span.saveid{ color: blue; font-weight: bold; }
        </style>
    </head>
    <body>        
    <div class="login">
        <form>
            <label>아이디<input type="text" name="id"></label><br>
            <label>비밀번호<input type="password" name="pwd" maxlength="5"></label><br>
            <label><input type="checkbox" checked>아이디 저장</label>
            <input type="submit" value="로그인">
        </form>
    </div>
    </body>
</html>
```

실행결과>

![day10%202b683c519a1947499514637df7023237/Untitled%2018.png](day10%202b683c519a1947499514637df7023237/Untitled%2018.png)

---

- login.html

```html
<!DOCTYPE html>
<html>
    <head>
        <!-- <title>jQuery로 작성한 로그인</title> -->
        <!--jQuery사용-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <script>
            $(function(){ //jQuery(document).ready(function(){})
                //localStorage에 id라는 이름의 아이템이 있으면 그 값을 아이디 입력란에 보여준다.
                let idValue = localStorage.getItem("id");
                if(idValue != null || idValue != '') {
                    //document.querySelector("input[name=id]").value = idValue;
                    //$document.querySelector("input[name=id]").value(idValue);
                    $("input[name=id]").val(idValue);
                 }
                 //DOM트리에서 type속성값이 checkbox인 input객체 찾기
                 let $chkObj = $("input[type=checkbox]");

                 //로그인버튼에서 클릭이벤트 발생하면 폼에서 서브밋 이벤트가 자동 발생한다.
                 //DOM트리에서 form객체 찾기
                 let $formObj = $("form");
                 $formObj.submit(function(event) { //event기술한 목적은 기본 이벤트 처리기를 막기위해서이다.
                     //checkbox가 선택되었는가 localstorage에 아이디값을 저장한다.
                     //if($chkObj.checked){
                     if($chkObj.prop("checked")) { //!주의. 체크박스가 선택되었는지 안되었는지 구분하려면 .prop메서드의 인자로 checked를 써야한다 그래야 선택여부를 확인 할 수있다
                        let $idObj = $("input[name=id]");
                        localStorage.setItem("id", $idObj.val());
                    } else {
                        //checkbox가 선택안되면 localstorage의 아이디값을 제거한다.
                        localStorage.removeItem("id");
                    }

                    //입력된 아이디값
                    var idValue = $("input[name=id]").val(); //서버로 전송될 id값

                    //입력된 비밀번호값
                    var pwdValue = $("input[name=pwd]").val(); //서버로 전송될 pwd값

                    $.ajax({
                       url: "./login", //'http://localhost:8888/myfront/login',  //요청URL
                       method:"post", //요청방식
                       //data : "id=" + idValue + "&pwd=" + pwdValue, // data : 서버로 전송할 데이터를 의미 //요청시 전달 데이터. 쿼리 스트링 형태로 전달
                       data : {"id": idValue, "pwd": pwdValue}, // 문자열이 아니라 객체형태로 만들어서 전달
                       success:function(data){ // data : 응답결과를 의미
                          alert(data);
                       },
                       error:function(jqXHR){
                          alert(jqXHR.status);
                       }
                    });
                    //event.preventDefault(); //기본이벤트 처리 막자 
                    return false; //!주의. event.preventDefault(); event.stopPropagation(); 두개의 효과를 다 포함하는 것이 return false이다.
                 });
            });
        //     window.addEventListener("load", function() { //load이벤트가 발생 했다는 것은 dom트리가 완성됐다는 뜻
        //         //localStorage에 id라는 이름의 아이템이 있으면 그 값을 아이디 입력란에 보여준다.
        //         let idValue = localStorage.getItem("id");
        //         if(idValue != null || idValue != '') {
        //             document.querySelector("input[name=id]").value = idValue;
        //         }
        
        //         //DOM트리에서 type속성값이 checkbox인 input객체 찾기
        //         let chkObj = document.querySelector("input[type=checkbox]");
        
        //         //로그인버튼에서 클릭이벤트 발생하면 폼에서 서브밋 이벤트가 자동 발생한다. 
        //         //DOM트리에서 form객체 찾기
        //         let formObj = document.querySelector("form");
        
        //         formObj.addEventListener("submit", function(event) {
        //             //checkbox가 선택되었는가 localstorage에 아이디값을 저장한다.
        //             if(chkObj.checked) { //if(chkObj.checked == true){
        //                 let idObj = document.querySelector("input[name=id]");
        //                 localStorage.setItem("id", idObj.value);
        //             } else {
        //                 //checkbox가 선택안되면 localstorage의 아이디값을 제거한다.
        //                 localStorage.removeItem("id");
        //             }
        //             event.preventDefault(); //기본이벤트 처리 막자  
        //         });
        //     });
        // </script>

        <style>
             input[name="id"]{ background-color: yellow; }
             input:not([type ="text"]) { background-color: green; color: white; }
             /* form span.saveid{ color: blue; font-weight: bold;} */
             /* form>label>input[type=checkbox]+span.saveid { color: blue; font-weight: bold; } */
             form>label>input[type=checkbox]~span.saveid{ color: blue; font-weight: bold; }
        </style>
    </head>
    <body>        
    <div class="login">
        <form>
            <label>아이디<input type="text" name="id"></label><br>
            <label>비밀번호<input type="password" name="pwd" maxlength="5"></label><br>
            <label><input type="checkbox" checked>아이디 저장</label>
            <input type="submit" value="로그인">
        </form>
    </div>
    </body>
</html>
```

- LoginController.java

```html
package com.my.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String idValue = request.getParameter("id");
		String pwdValue = request.getParameter("pwd");
		out.write(idValue +" 로그인 실패");
	}
}
```

실행결과>

![day10%202b683c519a1947499514637df7023237/Untitled%2019.png](day10%202b683c519a1947499514637df7023237/Untitled%2019.png)

---

![day10%202b683c519a1947499514637df7023237/Untitled%2020.png](day10%202b683c519a1947499514637df7023237/Untitled%2020.png)

상품 목록 페이지를 요청해서 응답 받는 내용이 상품 번호, 상품 이름, 가격...이 많은 텍스트들이 클라이언트에게 응답이 되면 분석을 해야 하는데 ,로 파싱을 하는데 복잡하다. 이런 것을 응답한 내용이 점점 많아질수록 구조화해서 즉 XML 형태로 응답해야 한다. 근데 하기가 어렵다. 그래서  

html형태 아님 text형태로 응답하는 방식이 있는데 text형태는 유지는 할 건데 약간 가공된 형태로 구조화된 형태로 유지를 할 거다. 즉, JSON(JavaScriptObject Notification)형태로 응답 할 거다.

텍스트가 자바스크립트 객체 형태로 유지한다. →  "[ {"prod_no " : "c0001"}, { }]"

xml형태로 응답 되는 것은 주로 공공데이터에서 쓴다. 그러나 요즘 JSON형태로도 많이 취한다.

응답 받은 내용을 자바스크립트 쪽에서 json형태 응답 내용을 분석할 수 있어야 한다.

문자열을 큰따옴표로 알리려면 \(백슬래쉬)를 표시하면 된다.

- LoginController.java

```java
package com.my.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		
//		String idValue = request.getParameter("id");
//		String pwdValue = request.getParameter("pwd");
//		out.write(idValue +" 로그인 실패");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String msg;
		msg = "{\"status\":1}"; //JSON형태의 문자열. JSON형태를 만들때 객체의 프로퍼티 이름은 반드시 큰 따옴표로 처리 해야한다.
		out.write(msg);
	}
}
```

- login.html

```html
<!DOCTYPE html>
<html>
    <head>
        <!-- <title>jQuery로 작성한 로그인</title> -->
        <!--jQuery사용-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <script>
            $(function(){ //jQuery(document).ready(function(){})
                //localStorage에 id라는 이름의 아이템이 있으면 그 값을 아이디 입력란에 보여준다.
                let idValue = localStorage.getItem("id");
                if(idValue != null || idValue != '') {
                    //document.querySelector("input[name=id]").value = idValue;
                    //$document.querySelector("input[name=id]").value(idValue);
                    $("input[name=id]").val(idValue);
                 }
                 //DOM트리에서 type속성값이 checkbox인 input객체 찾기
                 let $chkObj = $("input[type=checkbox]");

                 //로그인버튼에서 클릭이벤트 발생하면 폼에서 서브밋 이벤트가 자동 발생한다.
                 //DOM트리에서 form객체 찾기
                 let $formObj = $("form");
                 $formObj.submit(function(event) { //event기술한 목적은 기본 이벤트 처리기를 막기위해서이다.
                     //checkbox가 선택되었는가 localstorage에 아이디값을 저장한다.
                     //if($chkObj.checked){
                     if($chkObj.prop("checked")) { //!주의. 체크박스가 선택되었는지 안되었는지 구분하려면 .prop메서드의 인자로 checked를 써야한다 그래야 선택여부를 확인 할 수있다
                        let $idObj = $("input[name=id]");
                        localStorage.setItem("id", $idObj.val());
                    } else {
                        //checkbox가 선택안되면 localstorage의 아이디값을 제거한다.
                        localStorage.removeItem("id");
                    }

                    //입력된 아이디값
                    var idValue = $("input[name=id]").val(); //서버로 전송될 id값

                    //입력된 비밀번호값
                    var pwdValue = $("input[name=pwd]").val(); //서버로 전송될 pwd값

                    $.ajax({
                       url: "./login", //'http://localhost:8888/myfront/login',  //요청URL
                       method:"post", //요청방식
                       //data : "id=" + idValue + "&pwd=" + pwdValue, // data : 서버로 전송할 데이터를 의미 //요청시 전달 데이터. 쿼리 스트링 형태로 전달
                       data : {"id": idValue, "pwd": pwdValue}, // 문자열이 아니라 객체형태로 만들어서 전달
                       success:function(data){ // data는 응답내용, 자료형은 string
                          //alert(data);
                          var responseObj = JSON.parse(data); // 반환값은 객체 타입이 된다. string값을 object로 변환
                          if(responseObj.status == 1) {
                              alert("로그인 성공");
                          } else {
                              alert("로그인 실패");
                          }
                       },
                       error:function(jqXHR){
                          alert(jqXHR.status);
                       }
                    });
                    //event.preventDefault(); //기본이벤트 처리 막자 
                    return false; //!주의. event.preventDefault(); event.stopPropagation(); 두개의 효과를 다 포함하는 것이 return false이다.
                 });
            });
        //     window.addEventListener("load", function() { //load이벤트가 발생 했다는 것은 dom트리가 완성됐다는 뜻
        //         //localStorage에 id라는 이름의 아이템이 있으면 그 값을 아이디 입력란에 보여준다.
        //         let idValue = localStorage.getItem("id");
        //         if(idValue != null || idValue != '') {
        //             document.querySelector("input[name=id]").value = idValue;
        //         }
        
        //         //DOM트리에서 type속성값이 checkbox인 input객체 찾기
        //         let chkObj = document.querySelector("input[type=checkbox]");
        
        //         //로그인버튼에서 클릭이벤트 발생하면 폼에서 서브밋 이벤트가 자동 발생한다. 
        //         //DOM트리에서 form객체 찾기
        //         let formObj = document.querySelector("form");
        
        //         formObj.addEventListener("submit", function(event) {
        //             //checkbox가 선택되었는가 localstorage에 아이디값을 저장한다.
        //             if(chkObj.checked) { //if(chkObj.checked == true){
        //                 let idObj = document.querySelector("input[name=id]");
        //                 localStorage.setItem("id", idObj.value);
        //             } else {
        //                 //checkbox가 선택안되면 localstorage의 아이디값을 제거한다.
        //                 localStorage.removeItem("id");
        //             }
        //             event.preventDefault(); //기본이벤트 처리 막자  
        //         });
        //     });
        // </script>

        <style>
             input[name="id"]{ background-color: yellow; }
             input:not([type ="text"]) { background-color: green; color: white; }
             /* form span.saveid{ color: blue; font-weight: bold;} */
             /* form>label>input[type=checkbox]+span.saveid { color: blue; font-weight: bold; } */
             form>label>input[type=checkbox]~span.saveid{ color: blue; font-weight: bold; }
        </style>
    </head>
    <body>        
    <div class="login">
        <form>
            <label>아이디<input type="text" name="id"></label><br>
            <label>비밀번호<input type="password" name="pwd" maxlength="5"></label><br>
            <label><input type="checkbox" checked>아이디 저장</label>
            <input type="submit" value="로그인">
        </form>
    </div>
    </body>
</html>
```

응답을 받아와서 객체화 시킨다. status값에 다라서 서로 다른 일을 정할 수 있다.

복잡한 메시지가 응답 될 경우에는 일반 문자열로 응답하는 거 보다 json형태로 구조화해서 응답하는 것이 훨씬 관리하기 편하다. 

사용자에게 보여줄 것은 프론트가 결정, 사용자가 보게 되는 기준점은 백엔드가 잡아준다.

실행결과>

![day10%202b683c519a1947499514637df7023237/Untitled%2021.png](day10%202b683c519a1947499514637df7023237/Untitled%2021.png)