# CH3. Selection and Iteration

## 01 If-else문

```java
if (조건식) {
	// A
} else {
	// B
}
```

- `조건식`을 계산하여 그 결과값이 `true`이면 `A`를, 아니면 `B`를 실행한다.
- 실행되는 문장이 하나이면 중괄호는 생략이 가능하다.
- `else` 이하는 생략이 가능하다.



## 난수 생성하기

```java
int r = (int)(Math.random() * n);
// n개의 숫자, 0 ~ n-1 까지의 숫자 중 하나를 랜덤으로 생성
```

```java
Math.random() * a + b
```

- a개의 숫자 중 랜덤하게 선택
- b ~ a+b-1 중 랜덤하게 선택



## 상수의 선언

```java
final int COUNT_COLORS = 3;
```

- `final` 키워드를 붙여서 상수를 선언한다.



## 02 switch 문

- 실행 경로가 여러 개인 경우 `switch` 문을 사용한다.
- 변수와 일치하는 **값**을 가진 `case` 절이 실행된다. **<u>정수 혹은 문자열만 가능하다.</u>**
  - 즉, 수식(expression)이 `case` 뒤에 들어가지 않는다.
- `break`가 없으면 계속 실행된다.
- JDK 7부터는 condition에 `String`도 가능하다.

```java
switch(변수)
{
    case 값:
        처리문장;
        break;
    ...
    default:
        처리문장;
        break;
}
```



## 03 while 문

```java
while (조건식)
{
    
}
```

- `조건식`이 참이면 루프를 반복한다.



### do while 문

```java
do {

} while (조건);
```

- `조건식`을 루프가 끝나고 검사한다. 즉, 블록 안의 문장이 적어도 한 번 실행된다.
- `;`로 끝난다.



## 04 for 문

```java
for (초기식; 조건식; 증감식) {
    
}
```

- `초기식`에서 제어 변수를 초기화할 수 있다. 반복 루프를 시작하기 전 한번 실행된다. 여기서 선언된 변수의 범위는 선언된 `for`문의 블록 안으로 한정된다.
- `조건식`이 `false`가 되면 루프를 끝낸다.
- `증감식`은 한 번의 루프 실행이 끝나면 실행된다.



## 05 중첩 반복문

```java
for (초기식;조건식;증감식){		// 외부 반복문
    for (초기식;조건식;증감식) {	// 내부 반복문
        
    }
}
```



## 06 break와 continue

### break 문

`break`로 루프 실행 도중에 `for` 혹은 `while`문을 빠져나온다.

```java
while(true){
    if (i == 0)
        break;
}
```



### continue 문

`for` 혹은 `while`문에서 `continue`로 실행을 멈추고 그 다음 루프를 실행한다.

```java
while(true){
    if (i == 0)
        continue;
}
```



### 레이블로 중첩 반복문 빠져나오기

```java
outer_loop:
while(true) {
    while(true) {
		if (i == 1)
            break outer_loop;
    }
}

// 여기로 간다.
```



## 07 배열

- **배열(array)**은 참조형 변수이다. 즉 주소값이 담겨있다.
- <u>동일한 타입의 데이터를 담는다.</u>
- **인덱스(index)**로 각각의 요소에 접근한다.



### 배열의 선언과 할당

```java
int[] s;
s = new int[10];
```

- 배열 참조 변수를 선언
- `new` 연산자를 사용하여 배열을 생성하고 참조 변수에 할당

```java
<T>[] array_name;
array_name = new <T>[array_size];
```



### C언어와 유사하게 배열 참조 변수 선언하기

```java
int values[];
```



### 배열의 초기값

- 숫자들의 배열은 `0`으로 초기화된다.
- `boolean` 배열은 `false`로 초기화된다.
- 문자열 배열은 `null`로 초기화된다.



### 배열 선언 동시에 초기화

```java
int[] scores = { 10, 20, 30, 40 };
```

- `{}`안에 배열의 요소를 나열하여 초기화한다.



### 배열의 인덱스

- 배열 요소마다 인덱스가 있다.
- 첫번째 요소의 인덱스는 0이다.



### 배열의 길이

```java
arr = new int[10];
System.out.println(arr.length);		// 10
```

- `length` 메서드는 배열의 길이를 반환한다. 
- 배열은 한 번 생성되면 그 길이를 바꿀 수 없다.



### Array.toString()

```java
String[] colors = {"blue", "yellow"};
System.out.println(Array.toString(colors));
// [blue, yellow]
```



### 문자열 배열

```java
String[] colors = {"blue", "yellow", "purple"};
```



### for-each 루프

```java
for (변수 : 배열){
    
}
```

- `배열`의 모든 요소가 차례로 `변수`에 대입된다.

```java
String[] colors = {"blue", "yellow", "purple"};
for(String color : colors){
    System.out.println(color);
}
```



## 08 2차원 배열

### 2차원 배열의 선언

```java
int[][] s = new int[3][5];
```



### 2차원 배열의 초기화

```java
int[][] arr = {
    {1, 2, 3, 4, 5},
    {2, 3, 4, 5, 6},
}
```



### 2차원 배열과 이중 반복문

```java
for (int r = 0; r < arr.length; r++)
{
    for (int c = 0; c < arr[r].length; c++)
    {
        
    }
}
```

- 2차원 배열에서, <u>모든 열의 개수는 같지 않아도 된다</u>.



## 09 ArrayList

- 배열의 크기가 런타임 중에 자동으로 변경되는 배열
- `add()`: 배열에 요소를 추가
- `get(인덱스)`: 인덱스의 배열 요소를 가져오기
- `remove()`: 배열 요소를 삭제



### import ArrayList

```java
import java.util.*;			// 혹은
import java.util.ArrayList;
```



### ArrayList 생성하기

```java
ArrayList<String> list = new ArrayList<>();
```

