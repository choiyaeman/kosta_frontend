# day08

![1](https://user-images.githubusercontent.com/63957819/106431113-21dbb280-64b0-11eb-910e-672b2345816d.png)

체크 박스에서 클릭이벤트처리하겠다 의미는 체크 박스 선택 or 해제를 하겠다는 의미이다.

querySelectorAll메서드를 사용해서 여러 객체를 찾아올 때는 일반 for문보다 배열의 대표 메서드인 forEach 메서드를 쓰는 걸 권장한다. 

반복문 for문이 왜 문제가 될까? 반복문 for문이 실행할 때 var로 변수 선언하는데 window라는 내장 객체에 var선언한 변수가 할당된다. 값이 채워 졌으니 깐 number타입으로 채워진다. 변수도 선언 절차가 있고 대입 절차가 있다. 근데 자바스크립트에서는 선언 시에 메모리가 할당이 된다. 할당이 되고나서 i변수가 비교를 하고 조건부의 결과가 true이면 블록이 수행이 된다. 블록에서 addEventListener함수 호출하러 가는데 선언과 호출이라는 절차로 나누어지는데 이미 제공되는 함수 선언이 있으므로 호출만 하면 된다. 첫 번째 체크 박스 객체에서 click이벤트가 발생하면 이런 함수를 호출하라고 정의를 내려준다. 즉 해당 객체에게 click이벤트 발생 시 처리할 감시자를 등록하는 절차이다. 두 번째 인자로 전달된 콜백 함수가 만들어지고 콜백 함수가 지금 당장 실행되는 것이 아니라 이런 함수로 선언되어 있을 뿐이다. 체크 박스 객체가 클릭 되면 연결된 새로 만든 함수가 실행되는 것 이다. click이벤트가 발생할 시 함수 호출하는 것이 아니고 등록만 하는 것이다. 두 번째 체크박스 함수가 또 새로 만들어지고 호출은 안되고 등록만 된다. 

조건이 false이면 반복이 다 끝나고 랜더링이 된 후 클릭 되었을 때 함수들이 호출 된다. window객체에 있는 글로벌 변수를 사용하다 보니 자기보다 범위가 넓은 곳을 갖다 쓰게 되면 배열의 범위가 벗어나서 에러가 나는 것이다. 해결하는 방법은 콜백함수용 스콥 범위에 i변수를 하나 더 만들면 되지만 forEach를 쓰는 걸 권장한다.

- letjs.html

```html
<html>
    <head>
        <script>
            //C,JAVA언어: 변수는 선언후 사용한다.
            //console.log(a); //Uncaught ReferenceError: a is not defined

            //호이스팅
            //JS: 변수사용코드보다 변수선언코드가 뒤에 나오면
            //    변수선언코드를 자동 사용코드 앞으로 이동시킨다.
            //var은 호이스팅 됨. let은 호이스팅 안됨
            console.log(a); //undefined -> 선언만 되어있고 값이 대입x
            var a = 1; //var로 변수를 선언하게되면 호이스팅이 된다.
            //-->JS해석기에 의해 아래와 같이 바뀜
            /*
            var a;
            console.log(a);
            a = 1;
            */
            /*
            console.log(b); //사용 Uncaught ReferenceError: Cannot access 'b' before initialization
            let b = 1; //선언
            */
            //--------------------------------------
            //변수 재선언 var은 재선언 됨, let은 재선언 안됨
            var a = 'hello';
            console.log(a);
            /*
            let b = 1;
            let b = 'hello'; //Uncaught SyntaxError: Identifier 'b' has already been declared
            */

            //scope
            var a = 'global variable';
            let b = 'let variable';
            console.log(a + ":" + window.a); //global variable:global variable
            console.log(b + ":" + window.b); //let variable:undefined
            var fa = function() {
                var la = '지역변수 var';
                let lb = '지역변수 let';
                console.log(la + ":" +lb);
                c = "지역변수 var없음"; //var없이 변수 사용하면 함수바깥 스코프에 자동 선언
                console.log(c);
            };
            fa();
           //console.log(la + ":" +lb); //Uncaught ReferenceError: la is not defined -> 함수 안에서 선언된 변수는 함수밖에서 사용x
           console.log("out of fa(): " + c + ":" + window.c);
        </script>
    </head>
</html>
```

let은 호이스팅 되지 않는다. 변수 재선언 불가능. 왠만하면 let으로 변수 선언하는 것을 권장한다.

var은 호이스팅이 된다. 변수 재선언이 가능하다. 그러므로 변수를 선언할 때 정확한 스콥을 위해서 let사용 권장

---

- windowjs.html

```html
<!DOCTYPE html>
<html>
    <head>

    </head>
    <body>
        <input class="popup" type="button" value="새창띄우기">
        <input class="close" type="button" value="새창닫기">
        <br>
        <input class="interval" type="button" value="3초마다 콘솔 출력하기">
        <input class="clearInterval" type="button" value="3초마다 콘솔 출력 중지">
        <br>
        <input class="timeout" type="button" value="10초후에 경고창 띄우기">
        <input class="clearTimeout" type="button" value="타이머 중지">

        <script>
            //DOM트리에서 class속성값이 popup인 input객체 찾기
            var btPopupObj = document.querySelector("input[class=popup]");

            var w1;
            //popup인 input객체가 클릭되었을때 새창띄우기
            btPopupObj.addEventListener("click", function(){
                var url = "./popupjs.html";
                var target = "first"; //window창 이름. first타깃이라는 이름을 갖는 창은 한개
                var feature = "width=300 height=300";
                w1 = window.open(url, target, feature);
            });

            var btCloseObj = document.querySelector("input[class=close]");
            btCloseObj.addEventListener("click", function(){
                w1.close();
            });

            var btIntervalObj = document.querySelector("input[class=interval]");
            btIntervalObj.addEventListener('click', function(){
                intervalId = window.setInterval(function(){ //간격 설정하는 메서드
                    console.log("오늘날짜" + new Date());
                }, 3*1000); 
            });

            var btClearIntervalObj = document.querySelector("input[class=clearInterval]");
            btClearIntervalObj.addEventListener('click', function(){
                window.clearInterval(intervalId); //간격을 취소하는 메서드
            });

            var btTimeoutObj = document.querySelector("input[class=timeout]");
            var timerId;
            btTimeoutObj.addEventListener('click', function(){
                //window.alert();
                timerId = window.setTimeout(function(){
                    window.alert("10초가 지났습니다.");
                }, 10*1000);
            });

            var btClearTimeoutObj = document.querySelector("input[class=clearTimeout]");
            btClearTimeoutObj.addEventListener('click', function(){
                window.clearTimeout(timerId);
            });
        </script>
    </body>
</html>
```

- popupjs.html

```html
<!DOCTYPE html>
<html>
    <head>

    </head>
    <body>
        스트로베리 프로모션2021-01-26 ~ 2021-02-15페이스북<br>
        <input type="button" value="닫기">
        <script>
            var btCloseObj = document.querySelector("input[type=button]");
            btCloseObj.addEventListener("click", function(){
                window.self.close(); //자기 창 닫기
            });
        </script>
    </body>
</html>
```

---

![2](https://user-images.githubusercontent.com/63957819/106431118-230cdf80-64b0-11eb-9db4-752a1252f1fd.png)

bom이란 browser object model이라 한다. 웹 브라우저에서 쓰이는 창 하나 그 안에 들어가 있는 location, document, history 객체가 있다.

- documnetjs.html

```html
<!DOCTYPE html>
<html>
    <head>
        
    </head>
    <body>
        <div>DIV1</div>
            <input type="text" value="id1">
            <ul>
                <li>ONE</li>
                <li>TWO</li>
                <li>THREE</li>
            </ul>

            <script>
                //DOM트리에 접근하려면 document객체가 필요
                document.write("<h1>제목</h1>"); //DOM에 객체 추가
                var divObj = document.querySelector("div");
                console.log( divObj.innerHTML ); //DIV1

                var inputObj = document.querySelector("input");
                console.log(inputObj.innerHTML); //빈문자열. 아무효과없다
                console.log( inputObj.value ); //기본값 or 사용자가 입력한 값

                var ulObj = document.querySelector("ul");
                console.log(ulObj.innerHTML); /*<li>ONE</li>
                <li>TWO</li>
                <li>THREE</li>*/
                console.log(ulObj.innerText); /*ONE TWO THREE */
                //------------------------------------------------
                //기존객체에 하위객체추가
                //1)하위객체생성, 2)기존객체에 하위객체로 추가
                // let liObj = document.createElement("li"); //1)객체생성
                // ulObj.appendChild(liObj);//2)기존객체에 하위객체로 추가

                // let textObj = document.createTextNode("FOUR"); //1)객체생성
                // liObj.appendChild(textObj);//2)기존객체에 하위객체로 추가

                ulObj.innerHTML += "<li>FOUR</li>"; //ul객체의 바디내용에 li내용이 추가 되는 것

                //하위객체 제거
                //ulObj.removeChild(liObj);
                let liOneObj = document.querySelector("ul>li:first-child");
                console.log(liOneObj);
                ulObj.removeChild(liOneObj);      
            </script>       
    </body>
</html>
```

- locationjs.html

```html
<html>
    <head></head>
    <body>
        <h1>locationjs.html입니다</h1>
        <hr>
        5초 후 documentjs.html로 이동합니다.
        <script>
            window.setTimeout(function(){
                location.href = "./documentjs.html";
            }, 5*1000);
        </script>
    </body>
</html>
```

- historyjs.html

```html
<html>
    <head>

    </head>
    <body>
        <h1>historyjs.html입니다.</h1>
        <a href="#">뒤로</a>
        <script>
            var aObj = document.querySelector("a");
            aObj.addEventListener("click", function(){
                alert("뒤로가기가 클릭 되었습니다.");
                history.go(-1);//back();과 같음
            });
        </script>
    </body>
</html>
```

---

- defaulthandlerjs.html

```html
<html>
    <head></head>
    <body>
        <div style="width: 400; height: 300px; border:1px solid;">
            <a href="http://www.naver.com">네이버</a>
        </div>
        <form action="http://www.naver.com" method="get">
            <input type="text" name="t"><br>
            <input type="submit" value="전송">
        </form>
    <script>
        var aObj = document.querySelector("div>a");
        aObj.addEventListener("click", function(event){
            //alert("a태그가 클릭 되었습니다");
            aObj.style.backgroundColor = "yellow";
            event.preventDefault(); //기본 이벤트 처리를 막는다.
            event.stopPropagation(); //이벤트전파를 중지한다.
        });

        var divObj = document.querySelector("div");
        divObj.addEventListener("click", function(){
            divObj.style.backgroundColor = "pink";
        });

        var formObj = document.querySelector("form");
        var btSubmitObj = document.querySelector("form>input[type=submit]");
        formObj.addEventListener("submit", function(event) { //발생순서 : 2
            //alert("form submit이벤트 발생");
            event.preventDefault(); //기본 이벤트 처리를 막는다.
            
        });

        btSubmitObj.addEventListener("click", function() {
            //alert("서브밋버튼 click이벤트 발생"); //발생순서 : 1
        });
    </script>
    </body>
</html>
```

submit버튼은 클릭 이벤트가 발생이 되면 거기서 끝나는 게 아니라 submit버튼을 포함하고 있는 from객체의 submit이벤트가 자동 발생한다. form객체에도 기본 이벤트 처리가 있다.

자식에서 이벤트가 발생하면 그 이벤트가 부모 쪽에 고스란히 전파가 된다. 이런 것을 이벤트 버블링이라 한다.

기본 이벤트 처리만 하겠어 하면 사용자 이벤트 처리기를 만들지 마라~

---

- thistargetjs.html

```html
<html>
    <body>
        <input type="text">
        <input type="button">
        <script>
            var inputTextObj = document.querySelector("input[type=text]");
            inputTextObj.addEventListener("focus", function(){
                // inputTextObj.style.backgroundColor = 'yellow';
                //this.style.backgroundColor = 'yellow'; //this는 콜백function을 포함하고있는 객체를 의미 -> inputTextObj
                event.target.style.backgroundColor = 'yellow'; //event는 이벤트가 발생된 곳 즉 focus이벤트가 발생된 객체
            });
        </script>
    </body>
</html>
```

---

- canvasjs.html

```html
<!DOCTYPE html>
<html>
    <body>
    <canvas id="myCanvas" width="500" height="500" style="border:1px solid #d3d3d3;">
    Your browser does not support the HTML canvas tag.
    </canvas>
        <script>
            var c = document.querySelector("canvas");
            var ctx = c.getContext("2d"); //2d영역얻기
            ctx.moveTo(50,50); //moveTo(left, top); 시작점
            ctx.lineTo(200,100); //lineTo(left, top); 끝점
            ctx.strokeStyle = 'red';
            ctx.stroke(); //선긋기

            //사각형 그리기
            ctx.beginPath();
            var x = 200;
            var y = 100;
            var w = 50;
            var h = 70;
            //ctx.fillRect(x, y, w, h); //해당 컬러로 채워지는 사각형
            ctx.strokeRect(x, y, w, h); //색이 채워지지않은 사각형

            ctx.beginPath();
            x += 100;
            y = 85;
            ctx.strokeRect(x, y, w, h);

            //화면 지우기
            ctx.beginPath();
            ctx.clearRect(0, 0, 500, 500); // 캔버스의 크기만큼 다 지우자

            //원 그리기
            ctx.beginPath();
            x = 100;
            y = 250;
            var radius = 50;
            startAngle = 0; //시작각도
           // endAngle = Math.PI; //끝각도. 라디안 표기법 Math.PI : 180도, Math.PI*2 : 360도
            endAngle = Math.PI /2;
            var antiClockwise = true; //시계반대방향
            ctx.arc(x, y, radius, startAngle, endAngle, antiClockwise); // 0도 부터 시계반대 방향으로 90도까지 회전한것
            ctx.stroke();
            //ctx.fill();
        </script>
    </body>
</html>
```

![3](https://user-images.githubusercontent.com/63957819/106431119-23a57600-64b0-11eb-96e1-a880d8154189.png)

시작 경로에서 부터 끝 경로까지 이어진 것을 path라 부른다 .

또 다른 beginPath 만나면 강제 종료가 되고 새로운 선을 이어 간다.

![4](https://user-images.githubusercontent.com/63957819/106431122-23a57600-64b0-11eb-87fa-acc76b8a249c.png)

![5](https://user-images.githubusercontent.com/63957819/106431124-23a57600-64b0-11eb-9d9c-ab8f0cd3d981.png)

<input type="button">, <button type="button"> 둘 다 효과는 똑같은데 input type 버튼을 자바스크립트에서 객체를 찾는다면 document.querySelector("input[type=button]");로 선택자를 찾으면 되고 button은 선택자를 "button"로 찾는다. type을 생략한 버튼 태그로  button으로 객체 찾는 게 더 쉽게 찾을 수 있다.
