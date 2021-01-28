# day06

- vieworder.html

```html
<!DOCTYPE html>
<html>
    <head>
        <title>주문내역</title>
        <style>
            div.vieworder{
                box-sizing: border-box;
                width: 100%;
                height: 300px;
            }
            div.vieworder>table{
                width: 50%;
                height: 100%;
                border-collapse: collapse;
            }
            div.vieworder> table tr{

            }
            div.vieworder>table, div.vieworder>table th, div.vieworder>table td{
                border: 1px black solid;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="vieworder">
            <h1>주문내역</h1>
            <table>
                <tr><th>주문번호</th>       <th>주문일자</th>             <th>상품번호</th> <th>상품명</th>              <th>수량</th>  <th>가격</th> <th>금액</th></tr>
                <tr><td rowspan="2">15</td> <td rowspan="2">21/01/27</td> <td>C0003</td>    <td>돌체 콜드 브루</td>      <td>1</td>     <td>1,500</td><td>1,500</td></tr>
                <tr>                                                      <td>C0001</td>    <td>나이트로 바닐라 크림</td><td>3</td>     <td>1,000</td><td>3,000</td></tr>
                <tr><td>10</td>             <td>21/01/27</td>             <td>C0001</td>    <td>나이트로 바닐라 크림</td><td>1</td>     <td>1,000</td><td>1,000</td></tr>
                <tr><td rowspan="2">4</td>  <td rowspan="2">21/01/27</td> <td>C0002</td>    <td>돌체 콜드 브루</td>      <td>1</td>     <td>1,000</td><td>1,000</td></tr>
                <tr>                                                      <td>C0004</td>    <td>나이트로 콜드 브루</td>  <td>2</td>     <td>1,500</td><td>3,000</td></tr>
                <tr><td>2</td>              <td>21/01/27</td>             <td>C0001</td>    <td>나이트로 바닐라 크림</td><td>1</td>     <td>1,000</td><td>1,000</td></tr>
            </table>
        </div>
    </body>
</html>
```

실행결과>

![1](https://user-images.githubusercontent.com/63957819/106142909-67993200-61b5-11eb-96bb-87b154ee1de9.png)

---

- ordercss.html

```html
<!DOCTYPE html>
<html>
    <head>
        <!--외부스타일-->
        <link rel="stylesheet" href="./outer.css"> 

        <!--내부스타일-->
        <style> 
            body{
                background-color: pink;
                color: green; 
            }
            body>div.divclass1{
                border: 3px solid;
            }
            body>div.divclass2{
                width: 200px;
            }
            #divid{
                border: 10px dotted;
            }
        </style>
    </head>
    <body style="background-color: lightgray;"> <!--인라인스타일-->  
        CSS는 인라인, 외부, 내부스타일로 처리될 수 있다
        우선순위를 갖는다.
        <div id="divid" class="divclass1 divclass2">
            DIV
        </div>
    </body>
</html>
```

- outer.css

```css
/* outer.css */
body{
    background-color: blue;
    color: brown !important;
}
```

내부 스타일, 외부 스타일, 인라인 스타일 중 어느 것이 먼저 적용이 될까? 

html페이지를 읽을 때 위에서부터 아래로 읽어가면서 선택자들을 기억해내고 body태그를 만날 때 선택자에 해당하는 요소의 스타일이 반영이 돼야 하는데 왼쪽에서 오른쪽으로 읽고 먼저 작성한 스타일은 아래쪽 작성한 스타일에 의해 덮어쓰기가 된다. 그래서 가장 마지막에 지정한 인라인 스타일 표기법으로 최종 적용이 된다. 

!important로 설정하면 덮어쓰기가 되는 부분을 무시해버리고  important로 설정된 것이 우선이 된다.

id와 class 속성에 border가 적용되면 id 선택자와 class 선택자 중 id 선택자가 우선 순위가 더 높다.

실행결과>

![2](https://user-images.githubusercontent.com/63957819/106142913-68ca5f00-61b5-11eb-9bbd-bc26a33586be.png)

---

![3](https://user-images.githubusercontent.com/63957819/106142915-6962f580-61b5-11eb-9a74-1cb73a900f36.png)

- gridcss.html

```html
<!DOCTYPE html>
<html>
    <head>
        <style>
            header{
                display: grid;
                grid-template-areas: 'hh1 hh1   hnav hnav hnav';
                box-sizing: border-box;
                width: 100%;
                height: 100px;
            }
            header>h1{
                grid-area: hh1;
                background-color: bisque;
                height: 100%; /*%비율은 부모로 기준으로 한다*/
                margin: 10px;
            }
            header>nav{
                grid-area: hnav;
                background-color: cadetblue;
                height: 100%;
                margin: 10px;
            }
        </style>
    </head>
    <body>
        <header>
            <h1>제목</h1>
            <nav>메뉴1 메뉴2 메뉴3</nav>
        </header>
        <section>

        </section>
        <footer>

        </footer>
    </body>
</html>
```

실행결과 >

![4](https://user-images.githubusercontent.com/63957819/106142917-6962f580-61b5-11eb-9647-22fc2d6e351e.png)

---

## **자바스크립트**

자바스크립트는 데이터를 갖고 기능을 만드는 것이다. 렌더링 엔진하고 자바스크립터 해석기와 서로 커뮤니케이션을 한다. 

![5](https://user-images.githubusercontent.com/63957819/106142920-69fb8c00-61b5-11eb-81f0-227e644150a2.png)

자바스크립터 구문은 스크립트 태그를 만나면 자바스크립터 해석기에게 일을 넘긴다

자바스크립트의 처리 결과도 브라우저마다 다를 수 있다. 

단독 실행을 못하고 html 안쪽에서 실행이 되어야 한다.

JS에서 문자열은 " " 또는 ' ' 이다. 변수는 var a;

자바스크립트는 undefined, function이라는 자료형도 있다. undefined 자료형은 변수만 선언되어있고 값이 대입 되어있지 않은 경우이다. function 자료형 즉 함수도 하나의 자료형이다.  

- datatypejs.html

```html
<!DOCTYPE html>
<html>
    <head>
        <script>
            console.log("javascript입니다.");
            var a;
            console.log(typeof a); //undefined -> 변수만 선언되어있고 값이 대입 되어있지 않은경우

            a = 1;
            console.log(typeof a); //number

            a = 'hello';
            console.log(typeof a); //string

            a = true;
            console.log(typeof a); //boolean

            a = {};
            console.log(typeof a); //object ->js에서 {}는 객체를 의미

            a = function(){};
            console.log(typeof a); //function
        </script>
    </head>
</html>
```

![6](https://user-images.githubusercontent.com/63957819/106142924-69fb8c00-61b5-11eb-8ff4-6027c8892269.png)

검사에서 Console탭을 확인한다.

---

- operatorjs.html

```html
<!DOCTYPE html>
<html>
    <head>
        <script>
            /*
            산술연산자 +, -, *, /, %
            대입연산자 =, +=, -=, *=, /=, %=
            비교연산자 ==, !=, >, <, >=, <=
            논리연산자 &&, ||, !
            단항연산자 ++, --
            삼항연산자 ? :
            */

            //산술연산자 : 숫자형
            var num1, num2, num3;
            num1 = 1;
            num2 = 2;
            num3 = num1 + num2;
            console.log(num3); //3

            num3 = num1 / num2;
            console.log(num3); //0.5

            num3 = num1 / 0;
            console.log(num3); //Infinity
            console.log(num3 + 1); //Infinity

            num1 = undefined;
            num3 = num1 + num2;
            console.log(num3); //NaN -->undefined자료형이 연산이 되면 NaN발생

            //대입연산자
            num1 = 'hello';
            num1 = 1;
            num1 += 3; //num1 = num1 + 3;
            console.log(num1); //4

            //비교연산자
            console.log(1<10); //true
            console.log( 'A' < 'B' ); //true
            console.log( 'id10' < 'id2' ); //true --> id10이라는 문자값이 id2보다 더 작은 문자열이다.
            console.log( 12345 % 2 == 1 ); //true
            console.log( 12345 % 2 == 0 ); //false
            console.log( 12345 % 2 != 0 ); //true

            //논리연산자 && : AND 연산은 좌우가 모두 true일때 true를 반환한다. 그 외의 경우는 false를 반환
            //           || : OR 연산은 좌 또는 우가 true일때 true를 반환한다.
            //                          좌우가 모두 false일때 false를 반환한다.
            //            ! : NOT 연산은 반대
            num1 = 1;
            num2 = 10;
            console.log( num1 < num2 &&  'A' < 'B'); //true
            console.log( num1 > num2 &&  'A' < 'B'); //false
            console.log( num1 < num2 ||  'A' < 'B'); //true
            console.log( num1 > num2 ||  'A' < 'B'); //true
            console.log( !(num1 > num2) ); //true

            //단항연산자
            num1 = 1;
            num3 = num1++;
            console.log(num3); //1

            num1 = 1;
            num3 = ++num1;
            console.log(num3); //2

            //삼항연산자
            num1 = 1;
            var msg = num1%2 == 0? '짝수' : '홀수';
            console.log(msg);
        </script>
    </head>
</html>
```

자바와 자바스크립트에서 연산자는 비슷하다

자바에서 ..

산술 연산 시 정수와 정술 결과는 정수 ex)1/2 =⇒ 0

0을 0으로 나누면 ArithemeticException 발생

자바스크립트에서.. 

산술 연산 시 정수와 정술 결과는 실수 가능 ex) 1/2 =⇒ 0.5

0으로 나누는 결과는 Infinity

비교 연산자가 산술 연산자보다 우선순위가 높고 산술 연산자가 대입 연산자보다 높다

SQL에서..

산술 연산자는 나머지 값 구하는 연산자가 따로 없다. 

대입 연산자는 없지만 PLSQL에서는 := 대입 연산자의 역할을 한다. 

비교 연산자는 =, <>, >, <, >=, <= 

논리 연산자는 AND, PR, NOT 

단항 연산자와 삼항 연산자 없다.

---

- conditionjs.html

```html
<!DOCTYPE html>
<html>
    <head>
        <script>
            var num = 12;
            console.log(num%2==0?"짝수":"홀수");
            if(num%2 == 0){
                console.log("짝수");
                if(num > 10){
                    console.log("10보다 큰 값입니다.");
                }
            } else {
                console.log("홀수");
            }
            
            if(typeof(num) == 'number') {
                console.log("num변수는 숫자입니다.");
            } else if(typeof(num) == 'string') {
                console.log("num변수는 문자열입니다.");
            } else if(typeof(num) == 'boolean') {
                console.log("num변수는 논리형입니다.");
            }
            
            /*-----------------------*/
            var year = 2021;
            //년도에 해당하는 동물을 출력하시오
            //년도를 12로 나눈 나머지가 0이면 원숭이
            //                          1이면 닭, 2이면 개, 3이면 돼지, 4이면 쥐 
            //                          5이면 소, 6이면 호랑이, 7이면 토끼,
            //                          8이면 용, 9이면 뱀, 10이면 말, 11이면 양
            
            var mod = year % 12;
            if(mod == 0) {
                console.log("원숭이");
            } else if(mod == 1) {
                console.log("닭");
            } else if(mod == 2) {
                console.log("개");
            } else if(mod == 5) {
                console.log("소");
            } else {
                console.log("그외의 동물");
            }

            switch(mod) {
                case 0:
                    console.log("원숭이");
                    break;
                case 1:
                    console.log("닭");
                    break;
                case 2: 
                    console.log("개");
                    break;
                case 5:
                    console.log("소");
                    break;
                default: 
                    console.log("그외의 동물");
            }

            var score = 84;
            /*
            90 이상인 경우 A등급
            80 이상인 경우 B등급
            70 이상인 경우 C등급
            60 이상인 경우 D등급
            그외의 경우 F등급
            */
           if(score >= 90){
               console.log("A등급");
           } else if(score >=80) {
               console.log("B등급");
           } else if(score >= 70) {
               console.log("C등급");
           } else if(score >= 60) {
               console.log("D등급");
           } else {
               console.log("F등급");
           }
           //자바: 정수/정수 -> 정수
           //자바스크립트: 정수/정수 -> 정수, 실수
           console.log(score/10); //8.4

           console.log(parseInt(score/10)); //8

           switch(parseInt(score/10)) {
               case 10:
               case 9:
                    console.log("A등급");
                    break;
               case 8: 
                    console.log("B등급");
                    break;
               case 7: 
                    console.log("C등급");
                    break;
               case 6: 
                    console.log("D등급");
                    break;
               default:
                    console.log("F등급");
           }      
        </script>
    </head>
</html>
```

---

- loopjs.html

```html
<!DOCTYPE html>
<html>
    <head>
        <script>
            for(var i=0; i<10; i++) {
                console.log(i);
            }
            
            var num = 0;
            while(num < 10){
                console.log(num);
                num++;
            }

            num = 0;
            do{
                console.log(num);
                num++;
            } while(num < 10);

            num = 10;
            do{
                console.log(num);
                num++;
            } while(num < 10);
            console.log('*****3단~12단까지 구구단*****');
            outfor: for(var dan = 3; dan<=12; dan++){
                console.log("***" + dan + "***");
                infor: for(var i=1; i<=9; i++) {
                    //80이상의 값을 만나면 반복문 빠져나오기
                    if(dan*i >= 80){
                        //break; //가장 근접한 반복문을 빠져나오게 됨으로 80이상의 값을 만나게되면 단은 더 이상 출력되지 않는다.
                        break outfor;
                    }

                    //24의 배수는 출력안함
                    // if(dan*i % 24 != 0) { 
                    //     console.log(dan*i);
                    // }
                    if(dan*i %24 == 0){
                        continue; //조건 만족시 아래 구문(console.log(dan*i);)을 건너뛰기
                    }
                    console.log(dan*i);
                }
                console.log('****************');
            }
        </script>
    </head>
</html>
```

+는 문자열을 이어주는 역할도 한다.

![7](https://user-images.githubusercontent.com/63957819/106142926-6a942280-61b5-11eb-9261-c6acd4514945.png)

break는 가장 근접한 반복문을 빠져 나온다.

80이상의 값을 만나면 break가 되는데 label에 해당하는 반복문을 빠져 나오게 된다.

---

- arrayjs.html

```html
<!DOCTYPE html>
<html>
    <head>
        <script>
            //배열: 동일 자료형의 데이터 묶음
            var arr = ['사과', '포도', '귤'];
            console.log(arr[0]); //사과
            console.log(arr.length); //3

            arr = [];
            arr[0] = '바나나';
            console.log(arr[0]); //바나나
            arr[1] = '파인애플';
            console.log(arr[1]); //파인애플

            console.log(arr.length); //2
            arr.push("오렌지"); //끝에 요소 추가. push라는 메서드를 이용해 요소의 끝에 추가 할 수 있다.
            console.log(arr[2]); //오렌지
            console.log(arr.length); //3

            var orange = arr.pop(); //끝의 요소제거.
            console.log(orange); //오렌지
            console.log(arr.length); //2

            arr.unshift("키위"); //앞에 요소 추가

            for(var i=0; i<arr.length; i++){
                console.log(arr[i]);
            }
            var kiwi = arr.shift(); //앞에 요소 제거
            for(var i=0; i<arr.length; i++){
                console.log(arr[i]);
            }

            var position = arr.indexOf("파인애플"); // 파인애플 자리의 위치값을 반환
            console.log(position); //1

            position = arr.indexOf("수박");
            console.log(position); //-1 -> 없는 요소에 대한 반환은 -1

            //원본 : 바나나 파인애플
            var spliceArr = arr.splice(0, 1); //특정 위치에 해당하는 요소제거. 0,1 ->첫번째 요소 하나만 제거
            console.log(arr); //파인애플
            console.log(spliceArr); //바나나

            //반복처리
            arr.forEach( function(element, index){
                console.log(element + ":" + index);
            } );

            console.log("오름차순 정렬 : selection sort");
            arr = [1, 6, 3, 2, 7, 4];
            //오름차순하여 출력하시오 1 2 3 4 6 7
            var temp;
            for(var i=0; i<=arr.length; i++){
                for(var j=i+1; j<=arr.length; j++){
                    if(arr[j]<arr[i]){
                        temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                    }
                }
            }

            console.log("오름차순 정렬 결과");
            arr.forEach( function(element, index){
                console.log(element + ":" + index);
            });
        </script>
    </head>
</html>
```

자바에서는 자료형을 미리 결정하기 때문에 int[] arr 선언하지만, 자바스크립트는 자료형을 미리 결정하는 게 아니라 값에 따라 자동 결정이 된다.

unshift메서드는 앞에 요소 추가이다. 없는 요소에 대한 반환은 -1이 된다.

arr.forEach( function(element, index)){} → element 요소가 반복 처리되는 index위치

메서드의 인자로 함수가 전달될 수 있다. 이런 함수들은 자바스크립트에서는 콜백 함수라 부른다.

함수를 알리기 위해 function을 쓰고 괄호 열고 element(요소), index까지 제공이 된다. 각 요소값과 각 배열 요소의 인덱스가 출력 된다.
