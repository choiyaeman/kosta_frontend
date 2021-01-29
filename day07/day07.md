# day07

숫자 - 문자라고 하면 문자 용 빼기 연산자라는 연산자는 없다. 그렇기 때문에 산술 연산하려고 노력할 것 이다. 문자가 숫자로 자동 형 변환 한다.

hello가 숫자로 자동 형 변환이 될 수 없다. 그러므로 숫자가 아닌 값을 연산에 참여 시키려 하면 NaN 결과가 나온다.

산술 연산을 만났을 때 논리 형이 숫자 형태로 자동 형 변환되는데 true일 때는 1, false일 때는 0 으로 자동 형 변환이 된다. 또한, 단항 연산자의 대상으로 쓰이게 되면 boolean타입이 숫자 형태로 형 변환이 된다.

비교 연산자의 결과는 논리 형이 되도록 구성이 되어 있다. 비교 연산자의 계산 결과가 boolean타입이기 때문에 true값으로 실행해도 문제가 없다. 근데 숫자 1값을 넣게 되면? 숫자가 논리로 자동 형 변환이(if(true)) 된다.

문자와 논리 형 사이에 더하기 연산을 만나게 되면, 문자열 용 더하기 연산자가 우선순위가 높다. 논리 형이 문자 형으로 변환될 것이다. 문자열에서는 빼기 연산자가 제공되지 않기 때문에 산술 연산자로 쓰이게 될 거다. 그래서 true는 숫자로 바뀔 것이고 문자열은 숫자로 바뀔 수 없으므로 결과는 NaN이 나오게 된다. 

자바스크립트는 함수가 클래스 안에 없어도 쓸 수 있다. 내장되어 있는 함수가 있다. 대표로 console.log가 있다. 자료형으로 함수가 쓰인다. 

- castjs.html

```html
<!DOCTYPE html>
<html>
    <head>
        <script>
            //자료형변환
            //숫자와 문자형 자동자료형변환
            var num1 = 1;
            var num2 = 2;
            var str1 = '3'; var str2 = 'hello';
            console.log(num1 + num2); //3
            console.log(num1 + str1); //문자열결합연산자 + : 13
                                      //숫자+문자는 서로 자료형이 일치하지않으므로 숫자가 문자로 자동 형 변환된것이다.
            console.log(str1 + num1); //문자열결합연산자 + : 31
                                      //문자+숫자는 서로 자료형이 일치하지않으므로 숫자가 문자로 자동 형 변환된것이다.

            console.log(num1 - num2); //-1
            console.log(num1 - str1); //산술연산자 - : 문자가 숫자로 자동형변환 : -2
            console.log(str1 - num1); //2
            console.log(str2 - num1); //hello는 숫자로 자동형변환안됨! : NaN

            //숫자와 논리형 자동형변환
            num1 = 1;
            var bool1 = true;
            console.log(num1 + bool1); //논리가 숫자로 자동형변환 true는 1, 
                                      //                          false는 0으로 자동형변환 : 2
            console.log(++bool1); //2

            if( num1 < num2 ){ }
            if( true ) { }
            if( 1 ) { //숫자가 논리로 자동형변환 if(true)
            }

            //문자와 논리형 자동형변환
            bool1 = true;
            str1 = 'hello';
            console.log(bool1 + str1); //문자열결합연산자 + : truehello
                                       //논리가 문자로 자동형변환
            console.log(bool1 - str1); //NaN

            str1 = '3';
            console.log(bool1 - str1); //-2

            num1 = 1;
            bool1 = true;
            str1 = '3';
            console.log(num1 - bool1 + str1); //'03'

            num1 = 1;
            str1 = '1';
            bool1 = true;

            console.log(num1 == str1); //값의 내용만 비교 : true
            console.log(num1 === str1); //자료형과 내용을 모두 비교 : false
            //--------------------------------------------------------------
            //강제형변환
            console.log(parseInt('123')); //문자->정수
            console.log(parseFloat('123.4567')); //문자->실수
            console.log(Number('123')); //정수, 실수 구분하지 않고 숫자형태로 변환
            console.log(Number('123.4567'));

            console.log(String(123)); //숫자->문자
            console.log(Boolean(1)); //숫자->논리

            console.log(String(true)); //논리->문자
            console.log(Number(true)); //논리->숫자
        </script>
    </head>
</html>
```

---

- fucntionjs.html

```html
<!DOCTYPE>
<html>
    <head>
        <script>
            //이름있는 함수
            function test(param1, param2) {
                console.log(param1 + ":" + param2);
                if(typeof param2 == 'undefined'){
                    console.log('두번째 매개변수가 지정되지 않았습니다. 0으로 강제 설정합니다.');
                    param2 = 0;
                    }
                    return param1 + param2;
                };

                var result = test(1, 2); //1:2
                console.log(result); //3

                result = test(1);
                console.log(result); //NaN, 1

                result = test(1,2,3,4);
                console.log(result); //3

            function test2() {
                console.log("test2함수가 호출 되었습니다.");
            };

            test2();

            result = test2();
            console.log(result); //undefined
            //-------------------------------------------------------
            //이름없는 함수. 익명함수
            var a = function(param1,  param2){
                console.log(param1 + ":" + param2);
                return param1 + param2;
            };

            result = a(1, 2);
            console.log(result); //3
            
            var b = a;
            result = b(1, 2);
            console.log(result); //3

            var c = function(param1, param2, param3){
               var result = param1(param2, param3);
               //var result = 0;
               //for(var i=0; i<10; i++){
               //   result += param1(param2, param3);
               //}
               return result * 100;
            };

            result = c(a, 1, 2);
            console.log(result);

            result = c(function(param1,  param2){
                        console.log(param1 + ":" + param2);
                        return param1 + param2;
                     }, 1, 2);
            console.log(result); //300
            </script>
    </head>
</html>
```

자바스크립트의 정책 자체가 변수에 저장되는 값에 따라서 자료형이 바뀔 수 있기 때문에 매개변수의 자료형을 따로 선언하지 않는다. 

자바스크립트 특성으로 자료형을 미리 결정할 수 없으므로 return 타입을 지정하지 않는다. 그리고 class없이도 함수를 만들 수 있다.

매개변수 두 개 짜리 위치에 한 개만 전달되면 첫 번째 매개변수부터 차례차례 대입이 된다. 두 번째 매개변수는 undefined 자료형이 된다.

리턴 값이 없다는 것은 반환 값이 없다는 뜻이다. 리턴 결과를 받아오려 하면 undefined값이 보인다.

이름 없는 함수는 기록이 되어있으나 이름이 없으니 사용할 수 없다. 그러므로 이름을 부여하는 방법으로 변수에 대입을 시킨다. 변수에 대입 되는 값이 함수가 대입이 되는 거다. 즉 변수는 함수의 자료형이 된다. 이름 없는 함수를 만들어 놓고 여러 변수를 대입해서 쓸 수 있으므로 확장성이 좋다.

![day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled.png](day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled.png)

함수의 매개변수가 3개가 있는데 첫 번째 매개변수의 자료형이 괄호 열고 닫고 쓰이려면 자료형이 함수 자료형이어야 된다. 그러면 매개변수 두 번째와 세 번째는 함수의 매개변수로 쓰인다.

![day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled%201.png](day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled%201.png)

이름 없는 함수가 param1에 인자로 전달이 되고 인자로 전달된 함수 안에서 언젠가 호출이 될 것이다.  이런 함수를 콜백 함수라 한다.

---

- variablescopejs.html

```html
<!DOCTYPE html>
<html>
    <head>
        <script>
            //변수선언 방법 : var 변수이름
            var a = 'global variable';
            console.log("window.a=" + window.a); //gloabl variable
            console.log("a=" + a); //global variable
            if(true){
                console.log("if블럭내부:" + a);
                var b = "if블럭변수";
            }
            console.log(b);
            for(var i=0; i<1; i++){
                console.log("for블럭내부:" + a);
                var c = "for블럭변수";
            }
            console.log(c);
            console.log(i);

            var d = function(param1){
                console.log("function블럭내부:" + a);
                var e = "function블럭변수"; //지역변수 function scope variable
            }
            d(10); //함수호출
            //console.log(e); //error -> console.log(window.e);
            //console.log(param1);
            //----------------------------------------------------------------------------
            // var f = function(param1, param2){
            //     console.log("---");
            //     var result = param1(param2); //함수 스콥에 저장된 result객체이다.
            //     console.log("---");
            //     return result;
            // };

            // var f1 = function(param1){
            //     var f1scope = "f1스코프 변수";
            //     return param1;
            // };

            // var f2 = function(){
            //     console.log("f2함수: f1scope=" + f1scope);
            //     console.log("반환함수 입니다.");
            // };

            // var result = f(f1, f2); //function scope variable하고 별개의 변수이다. window객체에 저장된 result객체이다.
            // console.log(result);
            // result();
            //----------------------------------------------------------
            var name = "최예만"; //window객체내에 선언
            // var f11 = function(){
            //     var f11scope = "f11스코프 변수";
            //     var name = "콩쥐";
            //     var f22 = function(){
            //         console.log("f22함수: f11scope=" + f11scope);
            //         console.log(name); //자기함수 밖에 가장 근접한 name변수가 사용된다.
            //         console.log("반환함수입니다");
            //     }
            //     //f22();
            //     return f22;
            // };
            // var f11result = f11();
            // f11result();

            var f11 = function(param) {
                var name = "콩쥐";
                console.log("in f11 name=" + name); //콩쥐
                param();
            }
						// var arg = function(){
            //     console.log(name); //최예만
            // }
            // f11(arg);

            f11(function(){
                console.log(name); //최예만
            });

        </script>
    </head>
</html>
```

해당 블록 밖에 선언되어 있는 변수는 블록 안에 언제든지 쓰일 수 있다. 

자바스크립트는 블록 안에서 선언한 변수가 블록 밖에서도 사용될 수 있다.

is not defined는 변수가 선언되어있지 않을 때 발생하는 거다. 변수 스콥이 다르다. a, b, c는 같은 메모리 공간에서 쓰이고 있으나 function에서 선언한 e변수하고 매개변수는 함수 내부에서만 쓰인다.

window객체는 자바스크립트의 내장된 객체이고 객체들 사이에 최상위 객체이다. window.은 생략할 수 있다. 그러나 함수 안에 쓰이는 매개변수는 함수 영역에 저장되는 것이다. 이런 변수를 function스콥 variable이라 한다. 즉 지역변수라 부른다.

![day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled%202.png](day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled%202.png)

f1의 내용이 첫 번째 인자로 f2의 내용이 두 번째 인자로 가고 param1함수가 호출이 되면서 param2가 전달이 된 거다. param1을 반환을 한다 반환 값은 param2 함수 내용이 반환이 되고 그 result를 다시 반환해서 함수 내용이 반환 되는 것을 볼 수 있다.

![day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled%203.png](day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled%203.png)

param1(param2); → f1함수의 인자로 f2를 전달해서 호출하도록 되어있다. 그러면 f1함수 안에 f2가 들어간 거나 마찬가지고 param1이 f2이니깐 f1에 선언한 변수를 사용할 수 있을 것처럼 보이나 아니다!!

![day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled%204.png](day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled%204.png)

![day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled%205.png](day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled%205.png)

자바는 실행 시에 메모리에 할당하는 반면, 자바 스크립트에서 변수들은 선언 시에 메모리에 할당이 된다. 함수 선언 시에 메모리가 할당이 되고 실행 할 때 메모리를 이용해서 실행을 한다.

window 최상위 객체가 있다. 그리고 window객체 안에 a변수로 선언되어 있고 f11도 결국에는 var선언을 했으므로 window객체의 변수라고 봐야 한다. a변수는 string타입이고 f11변수는 함수 타입이다. 그리고 그 안에  scope으로 f11scope변수가 선언되어 있고 또 그 안쪽에 f22변수가 선언이 되어있다. 그 f22변수 자료형은 함수 타입이다. console.log로 f11scope변수의 값을 호출해라 되어있다. 그 밑에 코드 f11함수 호출하러 가서 호출이 되면 f22함수가 호출이 된다. f11스코프 문자열이 출력 될 것이다. 

f11스콥변수와 f22변수 스콥변수를 갖고 있는데 f22함수 안쪽에서 바깥쪽에 선언되어있는 변수를 사용할 수 있는 것을 볼 수 있다. 

window객체 안에 f11변수, f22변수가 있는 거고 f11함수 안에 f22함수가 있는 거다. f22변수 내용이 함수인 거다.  f11(); → var f11result = f11(); 변경

result 변수는 f22함수와 같은 내용이 되는 거다. f11result()해야 함수가 호출이 된다. 

f11result나 f22가 같은 효과이다. 

![day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled%206.png](day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled%206.png)

자바스크립트는 특이하게도 변수들이 선언, 함수들이 선언될 때 메모리에 탑재가 된다.

window객체가 있고 그 윈도우라는 자바스크립트 내장 객체 중에 a, name, f11변수가 있다.

f11함수 안에 name이라는 변수가 다시 선언 되어 있고 name출력, param함수 호출해라의 역할을 한다.

이 인자로 사용된 콜백함수는 f11과 관계없는 이름 없는 함수일 뿐이다. 그 안쪽에 console.log로 네임을 출력하라로 되어있다. 함수 타입으로 이름이 없을 뿐이다.  윈도우 객체에 이름 없는 함수로 선언되어있는 거다. 필요한 콜백함수 메모리 할당되고 실행하면 f11함수 호출하러 가고 이동혁이 출력 되고 그리고 전달된 param이 콜백함수로 전달이 됐으니까 그 param을 호출하게 되면 window객체가 갖고 있는 이름 없는 함수가 호출이 됨으로 window객체의 name이 호출이 된다.

---

- objectjs.html

```html
<!DOCTYPE html>
<html>
    <head>
        <script>
            var customer1 = {
                id: 'id1',
                pwd: 'p1',
                name: 'n1'
            };
            var customer2 = {
                id: 'id2',
                pwd: 'p2',
                name: 'n2'
            };
            var p1 = {
                no: 'C0001',
                name : '나이트로 바닐라 크림',
                price: 1000,
                display: function() { //객체가 갖는 function을 메서드라 한다.
                    console.log("상품 정보입니다.");
                    console.log(this.no + ":" + this.name + ":" + this.price); //현재객체의 상품번호 C0001
                }
            };

            console.log("첫 번째 고객의 이름" + customer1.name); //customer1객체의 name 속성
            console.log("첫 번째 고객의 이름" + customer2.name);
            p1.display(); //p1객체의 display메서드 호출

            console.log(this); //window객체
        </script>
    </head>
</html>
```

{} → 객체

---

- eventjs.html

```html
<!DOCTYPE html>
<html>
    <head>

    </head>
    <body>
        <input type="text" placeholder="아이디를 입력하세요" style="background-color: black;"><br>
        <input type="text" value="bbb"><br>
        <input type="button" value="버튼"><br>
        <!-- <input type="button" class="bt2" value="버튼2" onclick="f2();"> -->

        <div id="d1">HELLO</div>

        <input type="checkbox" checked>ONE&nbsp;&nbsp;
        <input type="checkbox">TWO&nbsp;&nbsp;
        <input type="checkbox" checked>THREE
        <script>
            //DOM트리에서 input객체찾기
            var inputObj = window.document.querySelector("input"); //window는 생략가능
            console.log(inputObj);
            console.log(inputObj.value + ":" + inputObj.placeholder) // :아이디를 입력하세요. -> value속성값은 없으므로 빈 문자열. 속성 value는 존재하나 아무값이 설정 안되었다는 뜻
            console.log("-----------");
            //input객체에서 키보드가 눌리면 input객체의 value속성값을 console에 출력한다.
            // inputObj.addEventListener("keyup", function(){
            //     console.log(inputObj.value);
            // });

            //input객체에서 키보드가 눌리면 input객체의 value속성값을 모두 대문자로 바꿔서 콘솔에 출력한다.
            inputObj.addEventListener("keyup", function(){
                var str = inputObj.value;
                //console.log(str.toUpperCase());
                alert(str.toUpperCase()); //경고창
            });

            //input객체의 value속성값이 바뀐상태에서 focusout되었을때 콘솔에 출력한다
            inputObj.addEventListener("change", function(){
                console.log("값이 바뀌었습니다. " + inputObj.value)
            });

            //input객체에 focusin되었을때
            inputObj.addEventListener("focus", function(){
                inputObj.style.backgroundColor = 'yellow';
            });

            //DOM트리에서 p객체찾기
            console.log(document.querySelector("p")); //반환값: null -> DOM트리에서 p객체가 없다라는 의미.

            //DOM트리에서 type속성값이 button인 객체찾기
            var btObj = document.querySelector("input[type=button]");
            console.log(btObj);
            //DOM트리에서 객체찾기용 메서드 : document.getElementById("d1");
            //                                document.getElementByName();
            
            //button객체에서 클릭 이벤트가 발생했을때 콘솔에 메시지출력한다
            btObj.addEventListener("click", function(){
                console.log("클릭 되었습니다");
            });
            // btObj.onclick = function() { //객체.속성을 찾아서 콜백함수 이용하는 방법도 있다.
            //     console.log("클릭 되었습니다");
            // };
            function f2(){
                console.log("클릭되었습니다.");
            }

            //DOM트리에서 type속성이 checkbox인 객체들 찾기
            var chkboxObjArr = document.querySelectorAll("input[type=checkbox]"); // querySelectorAll메서드는 하나이면 return타입이 객체형태, 여러개일경우 배열형태로 반환. 배열타입이다 모든 선택자에 해당하는 객체를 찾는것
            /*chkboxObjArr.forEach(function(element, index){
                console.log(element + ":" + index); 
                console.log(element.checked + ":" + index); //객체입장에서 선택 되어있는것은 true, 선택 안되어있는것은 false가 된다.
                //각 요소마다 클릭이벤트가 발생했을때 체크된 경우에는 "선택되었습니다" 경고창에 출력한다
                //                                         안된 경우에는 "선택해제되었습니다"
                element.addEventListener("click", function(){ //클릭 되었을 때 밑에있는 할일을 해라~
                    if(element.checked){
                        alert("선택 되었습니다.");
                    } else {
                        alert("선택해제 되었습니다.");
                    }
                });
            });*/
            for(var i=0; i<chkboxObjArr.length; i++) { //i변수는 window객체에서 선언되어있다.
                chkboxObjArr[i].addEventListener("click", function(){ //클릭 되었을 때 밑에있는 할일을 해라~
                    if(chkboxObjArr[i].checked){ //3번 인덱스는 없기 때문에 error난다!
                        alert("선택 되었습니다.");
                    } else {
                        alert("선택해제 되었습니다.");
                    }
                });
            }

        </script>
    </body>
</html>
```

![day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled%207.png](day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled%207.png)

버튼을 클릭해도 효과가 나타나지 않는다. 이벤트 처리를 자바스크립트로 해보자~

자바스크립트 해석기가 렌더링 엔진에서 해석한 요소들을 사용하려면 렌더링 엔진이 해석한 내용이 객체로 기억되어야 한다.

Html의 body태그를 자바스크립트 해석기가 객체로 관리하고 body안에  input태그를 자바스크립트 해석기가 객체로 관리를 한다. 근데 body객체의 하위 요소 객체로 관리를 한다. input태그 용 객체 안에 type, vlaue속성을 가진다. 이런 것을 트리구조의 관리 기법이라 한다.

자바스크립트에서 html태그를 handling을 해서 발생되는 이벤트를 감시하고 싶은 거다.

문서의 모든 내용을 객체로 관리하는 것을 DocumentObjectModel이라 불린다.

DOM트리를 구성하는 객체 종류에는 Element객체, Attribute객체, Text 객체가 있다. 

객체의 프로퍼티로는 name, value가 있다. Element객체에서는 value프로퍼티가 없다 Attribute객체에는 다 있고, Text객체에는 name 프로퍼티가 없다.

script태그를 왜 body태그 끝에 넣는 이유?? DOM트리가 완성이 되어야 그 객체들을 script태그로 쓸 수 있다.

DOM트리에서 해당 객체를 찾을 때 자바스크립트에서도 선택자가 사용된다. window.document는 dom트리를 알리는 작업을 한다. querySelector 메서드를 사용하면 객체를 하나밖에 못 찾아 온다.

![day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled%208.png](day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled%208.png)

![day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled%209.png](day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled%209.png)

null은 찾는 객체가 없다라는 의미이다. 버튼 클릭 시 콘솔창에 나오는 것을 볼 수 있다

addEventListener로 호출하는데 첫  번째 인자는 이벤트 종류, 두 번째 인자는 이벤트가 발생할 때 할일을 콜백function으로 전달하는 거다.

또 다른 방법으로는 태그에 onclick속성을 지정해서 onclick속성에 함수 호출하라는 표시를 해주면 된다. 함수가 당연히 자바스크립트 쪽에 존재 해야 한다. 

html태그에 속성 중에 onclick속성을 사용해서 자바스크립트 용 함수를 사용하는 것은 유지 보수성이 떨어진다. html태그를 만드는 쪽과 자바스크립트 만드는 쪽이 서로 분리되어 있으면 유지하기 어렵고 함수가 엄청 많아지게 된다. 좀 더 익히고 나서 그 때 이런 방법을 쓰는 게 좋다.

inputObj.value값은 문자열 타입으로 출력이 된다.

스타일 프로퍼티 지정할 때 -을 쓸 수 있는 영역이 css영역이고, 자바스크립트에서 input객체의 스타일 프로퍼티를 지정할 때 -를 쓰면 안되고 카멜케이스로 처리해주어야 한다.

![day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled%2010.png](day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled%2010.png)

input 객체가 갖고 있는 Properties 확인 해보자

![day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled%2011.png](day07%2037281dabd1ae47a3a29cbbbb36127feb/Untitled%2011.png)

반복문 for문으로 세번 반복하는데 i변수가 window객체에 i변수가 선언이 되어있다. 현재 i변수 0이고 반복문 for문에서 콜백함수가 만들어져 있다 반복 세번 도니까 세번 만들어진다. 똑같이 생긴 콜백함수가 세개 만들어진다. 이 반복문 세번 돌 때 함수가 한번, 두번, 세번 만들어졌다. 그래 놓고 클릭  안 해도 반복문이 세번 돌았기 때문에 i변수는 0→1→2→3까지 증가가 된다.  

사용자가 필요할 때 클릭 되면 해당 콜백함수가 호출이 되어야 하는데 chkObjArr[i] 표현이 실행 시에 3번 인덱스가 되는데.  3번 인덱스는 없는데 사용하라고 한다 그래서 에러가 난다.. 그러므로 forEach함수 사용하는 걸 권장한다. element는 이미 해당하는 위치에 찾아온 요소이기 때문에 에러가 발생하지 않는다.