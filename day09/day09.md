# day09

navigator는 window의 프로퍼티이고 geolocation는 navigator의 프로퍼티이므로 window.navigator.geolocation이다.

브라우저가 위치 정보API를 지원할 경우 지원 한다면 `getCurrentPosition()`메서드를 사용하면 현재 위치 정보 값을 알아낼 수 있다. 위치 정보 값을 그 즉시 알아낼 수 있는 거는 아니고 콜백함수를 인자로 쓰이고 있다. 콜백함수에는 위도와 경도 정보를 알고 있어야 하기 때문에 position이라는 매개변수를 이용해서 latitude(위도), longitude(경도)는 coords의 프로퍼티이므로 position.coords.latitude, position.coords.longitude이다.

`watchPosition()` 함수는 바뀐 곳의 현재 위치 값을 알려주는 함수이다. 변경된 위치 정보 값을 계속 반환해준다. 

https: 프로토콜만 위치 정보 권한 허용 가능하다.

`removeItem()` : 데이터 제거 `getItem()` : 데이터 조회 `setItem()` : 데이터 저장

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
    <div class="login">
        <form>
            <label>아이디<input type="text" name="id"></label><br>
            <label>비밀번호<input type="password" name="pwd" maxlength="5"></label><br>
            <label><input type="checkbox" checked>아이디 저장</label>
            <input type="submit" value="로그인">
        </form>
    </div>

    <script>
        //localStorage에 id라는 이름의 아이템이 있으면 그 값을 아이디 입력란에 보여준다.
        let idValue = localStorage.getItem("id");
        if(idValue != null || idValue != '') {
            document.querySelector("input[name=id]").value = idValue;
        }

        //DOM트리에서 type속성값이 checkbox인 input객체 찾기
        let chkObj = document.querySelector("input[type=checkbox]");

        //로그인버튼에서 클릭이벤트 발생하면 폼에서 서브밋 이벤트가 자동 발생한다.

        //DOM트리에서 form객체 찾기
        let formObj = document.querySelector("form");

        formObj.addEventListener("submit", function(event) {
            //checkbox가 선택되었는가 localstorage에 아이디값을 저장한다.
            if(chkObj.checked) { //if(chkObj.checked == true){
                let idObj = document.querySelector("input[name=id]");
                localStorage.setItem("id", idObj.value);
            } else {
                //checkbox가 선택안되면 localstorage의 아이디값을 제거한다.
                localStorage.removeItem("id");
            }
            event.preventDefault(); //기본이벤트 처리 막자  
        });
    </script>
    </body>
</html>
```

![day09%201d8687832ade47e1be25db5b70e1d884/Untitled.png](day09%201d8687832ade47e1be25db5b70e1d884/Untitled.png)

Application에 Local Storage를 보면 id값이 저장되어있는 것을 볼 수 있다.

로그인 버튼 클릭했을 때 체크 박스가 선택되어있으면 id값을 localStorage에 세이브 시키고 체크 박스 선택 안 하면 사용자 아이디 값을 localStorage에 저장하지 않고 제거 해준다.

---

SSE(Server-Sent Event)란 웹페이지하고 서버하고 값을 계속 교환하는 작업인데 결론은 서버로부터 클라이언트가 데이터를 계속 받는 작업을 말한다.

http는 요청과 응답으로 구성이 되어있다. 클라이언트가 요청을 안 하면 응답 못해준다. 그러므로 응답만 계속 못해준다. 

Polling방법은 요청해서 응답 받고 이런 구조를 계속 유지 시켜준다. windows의 setInterval아님 SSE써서 사용한다. 

---

자바스크립트 기반의 제이쿼리 라이브러리를 사용하면 훨씬 사용하기 편리하다. 

여기서 주의해야 할 것은 제이쿼리는 vue.js하고 충돌이 난다. 그래서 제이쿼리를 쓸 때 Angular아님 React랑 쓰면 된다. 

- login.html

```html
<!DOCTYPE html>
<html>
    <head>
        <script>
            window.addEventListener("load", function() { //load이벤트가 발생 했다는 것은 dom트리가 완성됐다는 뜻
                //localStorage에 id라는 이름의 아이템이 있으면 그 값을 아이디 입력란에 보여준다.
                let idValue = localStorage.getItem("id");
                if(idValue != null || idValue != '') {
                    document.querySelector("input[name=id]").value = idValue;
                }
        
                //DOM트리에서 type속성값이 checkbox인 input객체 찾기
                let chkObj = document.querySelector("input[type=checkbox]");
        
                //로그인버튼에서 클릭이벤트 발생하면 폼에서 서브밋 이벤트가 자동 발생한다.
        
                //DOM트리에서 form객체 찾기
                let formObj = document.querySelector("form");
        
                formObj.addEventListener("submit", function(event) {
                    //checkbox가 선택되었는가 localstorage에 아이디값을 저장한다.
                    if(chkObj.checked) { //if(chkObj.checked == true){
                        let idObj = document.querySelector("input[name=id]");
                        localStorage.setItem("id", idObj.value);
                    } else {
                        //checkbox가 선택안되면 localstorage의 아이디값을 제거한다.
                        localStorage.removeItem("id");
                    }
                    event.preventDefault(); //기본이벤트 처리 막자  
                });
            });
        </script>

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

script태그가 body 태그의 뒤쪽에 가면 항상 스크롤을 내려서 끝으로 가야 분석할 수 있으므로 유지 보수가 어렵다. 처리 속도 상 body태그 끝에 있는 게 빠르나 유지 보수하기에는 떨어진다. 그래서 아에 스크립트 태그를 head태그에 빼버리는 거다. 그러면 head와 body가 완벽히 분리가 되니깐 body에는 html태그 head에는 css, script태그로 구성된다. 

문제점은 Dom트리가 만들어지지 않은 상태에서 script태그를 쓰는 것이므로 객체를 못 찾는다.

Dom트리가 완성 될 때까지 기다리다가 할 일을 해야 한다. body태그가 처음부터 끝까지 진행이 되고 html 태그들이 다 읽어서 dom이 완성이 되고 화면이 랜더링 할 준비가 된 상태에서 window객체에서 load이벤트가 발생하는 시점 자바스크립트가 하고 싶은 일을 하면 된다.

---

$("#id01") 하고 document.querySelectorAll("#id01")랑 같다.  jQuery에서 모든 요소를 찾는 방법인 $표현법이다. JQuery는 JS보다 사용법이 훨씬 단순하다는 장점이 있다.

![day09%201d8687832ade47e1be25db5b70e1d884/Untitled%201.png](day09%201d8687832ade47e1be25db5b70e1d884/Untitled%201.png)

jQuery에서는 innertHTML을 대신해 html로 사용한다.

![day09%201d8687832ade47e1be25db5b70e1d884/Untitled%202.png](day09%201d8687832ade47e1be25db5b70e1d884/Untitled%202.png)

jQuery에서는 style에 관련된 대표 메서드가 hide(), show(), toggle() 제공된다.

![day09%201d8687832ade47e1be25db5b70e1d884/Untitled%203.png](day09%201d8687832ade47e1be25db5b70e1d884/Untitled%203.png)

style에 관련된 css라는 jQuery메서드를 사용해 문자열로 프로퍼티이름하고 값을 주면 된다.

객체 제거 메서드를 간단히 jQuery에서는 remove메서드만 호출하면 알아서 요소가 제거된다. 자바스크립트에서는 부모를 찾아서 자식을 제거하는데 자기 자신객체를 제거하는 절차가 복잡하다.

Dom을 처리하는 기법도 jQuery가 훨씬 쓰기가 유연하다.

jQuery 용 라이브러리가 여러 곳에 분산되서 분포해 있다. 이런 기법을 CDN기법이라 한다.

CDN 호스트 연결하거나, jquery사이트에가서 다운 받고 다운된 경로를 지정해서 쓰는 방법이 있다.

`$(selector).action()` : $(객체이름) → $ 대신에 jQuery를 사용할 수 있다.  객체 이름을 쓸 때는 ""없이 쓰는 거다. 점을 찍고 jQuery용 메서드 사용한다. 점 연산자 다음부터는 제이쿼리 용 메서드가 호출 하는 거다.

![day09%201d8687832ade47e1be25db5b70e1d884/Untitled%204.png](day09%201d8687832ade47e1be25db5b70e1d884/Untitled%204.png)

문서가 준비되었을 때 그때서 콜백함수 내용이 처리가 된다. 그래서 $(document).ready(function(){}); 는 window.addEventListener("load", function(){}); 와 같다. 단 차이는 window에 로드 이벤트는 이미지나 동영상 같은 큰 메모리  처리, document의 로드 이벤트는 아주 큰 이미지 파일이 있을 경우에는 리소스가 준비되지 않을 수가 있다.

&(document).ready 생략 가능 ==  &(function(){

![day09%201d8687832ade47e1be25db5b70e1d884/Untitled%205.png](day09%201d8687832ade47e1be25db5b70e1d884/Untitled%205.png)

document.querySelectorAll("p") == $("p")   forEach라는 반복문 필요 없이 $("p").hid(); 하면 모든p요소를 찾아 사라지게 한다.

![day09%201d8687832ade47e1be25db5b70e1d884/Untitled%206.png](day09%201d8687832ade47e1be25db5b70e1d884/Untitled%206.png)

제이쿼리에서는 이벤트용 메서드가 각각 제공이 된다.  ex) $("p").click();

![day09%201d8687832ade47e1be25db5b70e1d884/Untitled%207.png](day09%201d8687832ade47e1be25db5b70e1d884/Untitled%207.png)

toggle메서드는 사라졌다 보여졌다 반복하는 작업을 한다. if~else를 대신 해준다.

Callback 함수란 메서드나 함수의 인자로 사용되는 함수라 한다. 

1번이 정답. 이름 있는 함수는 a()는 함수의 인자로 콜백함수 이름만 적어주는 거다. 함수 호출 후에 인자로 전달 되는 게 아니다.

![day09%201d8687832ade47e1be25db5b70e1d884/Untitled%208.png](day09%201d8687832ade47e1be25db5b70e1d884/Untitled%208.png)

아이디가 p1인 객체 찾기의 작업인데 css메서드를 적용해서 반환 값이 그 객체(p1) 한 객체를 이용해서 점을 이어가서 사용한다.

- jq.html

```html
<!DOCTYPE html>
<html>
    <head>
        <!--jquery사용 CDN호스트 연결-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
            //DOM트리 완성되고 화면에 보여줄 준비가 된 경우 :  document객체의 ready이벤트
            //jQuery(document).ready(function(){ });
            //$(document).ready(function(){ });
            $(function(){ 
                var $divObj = $("div"); //DOM트리에서 div객체들 모두 찾아 jquery전용객체로 반환. 일반 자바스크립트 객체가 아니고 제쿼리용 객체라고 $로 표현 해준거다.
                $divObj.html("<h1>Hello</h1>"); // 내용 채우기. 자바스크립트의 innerHTML 표현과 같다

                //자바스크립트 객체를 jquery전용객체로 변환 $(자바스크립트 객체)
                /*var divObj = document.querySelector("div");
                //divObj.html("<h1>HELLO</h1>");
                $(divObj).html("<h1>HELLO</h1>");
                */

                // var divObj = document.querySelectorAll("div"); -> divObj. 하면 제공되는 메서드의 목록이 다르다. 그래서 제이쿼리의 객체를 알리려고 $를 써야한다.
                // divObj.forEach(function(element){
                //    element.innerHTML = "<h1>Hello</h1>";
                //});

                //DOM트리에서 type속성값이 text인 input객체들 찾기. 반복문을 안써도 포커스 이벤트 처리는되는 것을 볼 수 있다.
                var $inputTextObj = $("input[type=text]"); // $inputTextObj는 jquery형태의 배열객체이다
                $inputTextObj.focus(function(event){
                    //alert("포커스를 받음");
                    console.log("포커스를 받음 this:" + this); //this:[object HTMLInputElement]. 현재객체
                    console.log("포커스를 받음 $(this):" + $(this)); //$(this):[object Object]. 자바스크립트 객체를 제이쿼리용 객체로 변환
                    console.log("포커스를 받음 event.target:" + event.target); //event.target:[object HTMLInputElement]
                    console.log("포커스를 받음 $inputTextObj:" + $inputTextObj); //$inputTextObj:[object Object] : 배열용 객체
                    alert($(this).val() + ":" + $(event.target).val() + ":" + $inputTextObj.val()); //this.value랑 같다. jquery에서는 val메서드를 사용하면된다. $inputTextObj는 이미 제이쿼리용 객체이므로 ()안해도 된다.
                });
            });
        </script>
    </head>
    <body>
        <div></div>
        <input type="text" value="첫번째 입력양식">
        <input type="text">
    </body>
</html>
```

jquery 문법은 head태그에다 넣는다.

![day09%201d8687832ade47e1be25db5b70e1d884/Untitled%209.png](day09%201d8687832ade47e1be25db5b70e1d884/Untitled%209.png)

htmlinputelement는 일반 자바스크립트 객체 object는 제이쿼리용 객체이다.

this객체란 input객체 각각을 의미한다. **$inputTextObj는 배열 형태이고 this는 배열에 들어있는 각 요소를 의미하므로 다르다.**

![day09%201d8687832ade47e1be25db5b70e1d884/Untitled%2010.png](day09%201d8687832ade47e1be25db5b70e1d884/Untitled%2010.png)

두 번째 입력양식에는 값이 현재 없다. 왜냐하면 배열 타입이므로 첫 번째 배열 값이 보이는 거다. 현재 객체를 정확히 가리키는게 아니라 배열 전체 요소를 가리키게 되는 거다.  제이쿼리에서는 포커스 같은 이벤트 용 함수 앞에 객체의 형태가 배열 타입일 수 있다. 배열 객체 자체이기 때문에 val메서드를 호출하게 되면 배열 모든 값이 된다. 그러니깐 절대로 $inputTextObj.val() 표현법을 쓰면 안된다. focus함수명을 포함하고 있는 객체 명을 쓰면 안된다. 왜냐? 배열이라서 배열의 모든 정보를 다 갖고 있기 때문이다. 즉, **이벤트 용 콜백함수 안쪽에서는 이벤트 용 함수를 포함하고 있는 객체를 직접 사용하지 않는다.**

---

- login.html - jQuery로 작성한 로그인

```html
<!DOCTYPE html>
<html>
    <head>
        <title>jQuery로 작성한 로그인</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <script>
            $(function(){
                //localStorage에 id라는 이름의 아이템이 있으면 그 값을 아이디 입력란에 보여준다.
                let idValue = localStorage.getItem("id");
                if(idValue != null || idValue != '') {
                    //document.querySelector("input[name=id]").value = idValue;
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

---

![day09%201d8687832ade47e1be25db5b70e1d884/Untitled%2011.png](day09%201d8687832ade47e1be25db5b70e1d884/Untitled%2011.png)

jQuery메서드는 메서드 이름 하나를 가지고  set,get 역할을 한다.

매개변수의 개수로 조작 매개변수 작은 것이 get역할, 큰 것이 set역할이다.

![day09%201d8687832ade47e1be25db5b70e1d884/Untitled%2012.png](day09%201d8687832ade47e1be25db5b70e1d884/Untitled%2012.png)

html, val메서드 차이점은? 태그가 서로 다르다. 

html, body메서드 차이점은 ? html()는 body내용 전체, text()는 body내용중에 text내용만 가져온다.

![day09%201d8687832ade47e1be25db5b70e1d884/Untitled%2013.png](day09%201d8687832ade47e1be25db5b70e1d884/Untitled%2013.png)

![day09%201d8687832ade47e1be25db5b70e1d884/Untitled%2014.png](day09%201d8687832ade47e1be25db5b70e1d884/Untitled%2014.png)

`prepend()`는 앞에 `append()` 뒤에 추가한다는 뜻

![day09%201d8687832ade47e1be25db5b70e1d884/Untitled%2015.png](day09%201d8687832ade47e1be25db5b70e1d884/Untitled%2015.png)

<>는 선택자가 아니라 객체를 하나 새로 만들라는 뜻이다.

지금 dom트리에 없는 새로 만든 객체를 찾아서 마지막 막내 자식으로 추가해라

`remove()` : 그 안에 들어있는 child까지 다 없앤다

`empty()` : 요소를 제거하는 게 아니라 요소의 내용을 지워버리는 거다.

`css("propertyname", "value");`

`css({"propertyname":"value","propertyname":"value",...});` : 객체 형태로 css메서드를 인자로 전달할 수 있다

![day09%201d8687832ade47e1be25db5b70e1d884/Untitled%2016.png](day09%201d8687832ade47e1be25db5b70e1d884/Untitled%2016.png)

jQuery Traversing에서 dom트리를 어떻게 찾아갈것인가?

첫 번째 li요소를 찾는다면 제이쿼리에서  var o = $("div>ul>li:first-child");

객체를 기준으로 해서 부모 조상 자식 후손 형제 찾는 방법에 대해 알아보자 하는 얘기 이다.

- Ancestors

 `parent()` : 부모 객체 찾는 작업, `parents()` : 조상들을 찾는 작업

- Descendants

`children()` : 자식 객체 찾는 `find()` : 작업 후손 객체들을 찾는 작업

- Siblings →형제들을 찾아내는 것

`next()` : 형제 요소 객체의 바로 다음에 나오는 객체

`prev()` : 형제 객체를 기준 삼아서 바로 앞에 나오는 형제 객체

```html
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  //$("div").first().css("background-color", "yellow");
  $("div:first-child").first().css("background-color", "yellow"); //first-child = nth-child(1)
});
</script>
</head>
<body>
  <h1>Welcome to My Homepage</h1>

  <p>This is a paragraph.</p>

  <div style="border: 1px solid black;">
    <p>A paragraph in a div.</p>
    <p>Another paragraph in a div.</p>
  </div>
  <br>

  <div style="border: 1px solid black;">
    <div style="color: red; width: 100px;">두번째 DIV안에 있는 DIV입니다.</div>
  </div>
  <br>

  <div style="border: 1px solid black;">
    <p>A paragraph in another div.</p>
    <p>Another paragraph in another div.</p>
  </div>
 </body>
</html>
```

first-child하고 jQuery의 first() 하고는 다르다

실행결과>

![day09%201d8687832ade47e1be25db5b70e1d884/Untitled%2017.png](day09%201d8687832ade47e1be25db5b70e1d884/Untitled%2017.png)

---

---

```html
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  //$("p").eq(1).css("background-color", "yellow");
  $("p:nth-child(2)").css("background-color", "yellow");
});
</script>
</head>
<body>

<h1>Welcome to My Homepage</h1>

<p>My name is Donald (index 0).</p>
<p>Donald Duck (index 1).</p>
<p>I live in Duckburg (index 2).</p>
<p>My best friend is Mickey (index 3).</p>

</body>
</html>
```

`eq()` : 인덱스 번호를 반환한다. 

eq(1) p객체들 중에서 1번 인덱스 역할 하는 p객체를 찾으라는 의미

nth-child(2) 두 번째 자식으로써 역할을 하는 p객체를 찾으라는 의미

eq와 nth-child는 서로 다르므로 주의~

실행결과>

![day09%201d8687832ade47e1be25db5b70e1d884/Untitled%2018.png](day09%201d8687832ade47e1be25db5b70e1d884/Untitled%2018.png)

`not()` : 반대 개념이다.

---

실습

![day09%201d8687832ade47e1be25db5b70e1d884/Untitled%2019.png](day09%201d8687832ade47e1be25db5b70e1d884/Untitled%2019.png)