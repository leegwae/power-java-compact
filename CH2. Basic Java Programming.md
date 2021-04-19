# CH2 자바 프로그래밍 기초

## 01 자바 프로그램의 일반적인 구조

### 클래스

- 기본 빌딩 블록은 클래스(class)이다.



### 클래스의 정의

```java
public class Hello {
    
}
```



### Main 메서드

```java
public static void main(String[] args){
    
}
```

- 하나의 자바 프로그램에는 `main` 메서드를 가진 클래스가 반드시 하나는 있어야 한다.
- `main` 메서드에서 자바 프로그램의 실행이 시작된다.



### 소스 파일과 클래스 이름

- 소스 안에 `public` class가 있을 때, 소스 파일의 이름은 반드시 해당 `public` class의 이름과 일치해야한다.
- 따라서, 하나의 소스 파일 안에 `public` class가 2개 이상 있으면 compile error가 발생한다.



### 주석

```java
/* 주석(TEXT)  
// 한 줄 짜리 주석
/** 여러줄 짜리 주석(DOCUMENTATION)*/
```



### 변수와 문장

- variable은 data를 담아두는 상자(값을 담아두는 상자)
- statement는 프로그램을 이루는 가장 기초적인 단위로, 항상 세미콜론으로 끝나야한다.



## 02 변수와 자료형

### 변수의 선언

```java
자료형 변수이름;
```

- 변수의 선언도 하나의 statement이다.
- 변수가 선언되면 변수의 값은 아직 정의되지 않은 상태가 된다.



### 변수의 이름

- 변수의 이름은 그 값을 지칭하기 위한 **식별자(identifier)**이다.
- 변수의 이름을 짓는 규칙은 다음과 같다.
  - 알파멧 문자, 수사, 밑줄 문자(_), 한글
  - 첫글자는 반드시 알파벳 또는 _이다.
  - 대문자와 소문자는 구별한다.
  - 자바 언어 키워드는 사용할 수 없다.



### 자료형

- 변수에 저장되는 데이터의 타입



### 자료형의 종류

- **primitive type**(기초형) : 실제 값을 저장한다.
  - 정수형: `byte`, `short`, `int`, `long`
  - 실수형: `float`, `double`
  - 논리형: `boolean`
  - 문자형: `char`
- **reference type**(참조형) : 실제 객체를 가리키는 주소를 저장한다.
  - `class`
  - `interface`
  - 배열



### primitive type

| 자료형  | 설명          | 크기(바이트) |
| ------- | ------------- | ------------ |
| byte    | 부호있는 정수 | 1            |
| short   |               | 2            |
| int     |               | 4            |
| long    |               | 8            |
| float   | 실수형        | 4            |
| double  |               | 8            |
| char    | 문자형        | 2            |
| boolean | 논리형        | 1            |



### 리터럴

- **리터럴(literal)**은 값이다.
- 리터럴에는 정수형, 실수형, 문자형, 논리형이 있다.



### 정수형 리터럴

| 진수                | 표현      |
| ------------------- | --------- |
| 10진수(decimal)     | 14, 16    |
| 8진수(octal)        | 016, 018  |
| 16진수(hexadecimal) | 0xe, 0x10 |
| 2진수(binary)       | 0b1100    |

- JDK 7부터 정수형 리터럴 안에 밑줄 기호가 포함될 수 있다. 컴파일러는 밑줄 기호를 무시한다.

```java
int x = 123_456;	// x에 123456이 할당된다.
```



### 실수형 리터럴

- 일반 표기법: 123.45
- 지수 표기법: 1.2345E+2
- 부동소수점형 리터럴은 `double`형이 기본이므로, `float`형 변수에 부동소수점형 리터럴을 할당하면 오류이다.

```java
float temp = 12.3; 	// 12.3은 double이므로 오류
```

- `float`형 리터럴에는 `f`나 `F`를 붙인다.

```java
float temp = 12.3f;
```



### 문자형 리터럴

- `char`에는 하나의 문자를 저장할 수 있다.
- 자바는 유니코드 UTF-16 규격을 사용하므로, 문자 하나가 16비트(2바이트)로 표현된다.

```java
char ch1 = '가';
char ch2 = '\uac00';
```

- 특수문자들은 문자 앞에 `\`를 삽입한다.



### 논리형 리터럴

```java
boolean flag = true;
boolean x = 1 < 2;
```

- 논리형은 `true` 또는 `false`라는 값만 가질 수 있다.
- 논리형은 논리 연산의 결과값이다.



### 기호 상수, 상수 선언하기

- **상수(constant)**란 프로그램이 실행되는 동안 값이 변하지 않는 수 또는 변경 불가능한 수이다.
- 리터럴도 상수의 일종이다.
- `final` 키워드를 붙여 변수를 선언하면 리터럴을 **기호상수**로 나타낼 수 있다.

```java
const double PI = 3.141592;
```



### 예제: 원의 면적 계산하기

```java
public class AreaTest {
	public static void main(String args[]) {
		final double PI = 3.141592;
		double radius, area;
		
		radius = 5.0;
		area = PI * radius * radius;
		System.out.println("반지름이 5인 원의 면적은 " + area);
	}
}
```

- 연산에서 다른 data type끼리 자동 형변환이 일어난다.



## 03 문자열

- **문자열(string)**은 문자들의 모임이다.
- 자바에는 내장된 문자열 자료형이 없으며, `String` class가 제공된다.

```java
String name = 'lana';
```



### 문자열과 + 연산

- `String` 객체들은 `+` 연산으로 이을 수 있다.

```java
System.out.println("문자열1"+"문자열2");		// 문자열1문자열2
```



## 04 형변환

- **형변환(type conversion)**은 하나의 자료형을 다른 자료형으로 변환하는 것이다.



### 묵시적 형변환

- 산술 연산 시, 한 피연산자가 더 넓은 피연산자의 타입으로 변환된다.

```java
double sum = 1.2 + 3;		// 1.3+3.0으로 변환된다.
```



### 명시적 형변환

- 형변환을 명시적으로 하려면, 형변환 연산자를 사용한다.
- 변환하고자 하는 값의 앞에 `(자료형)`을 삽입한다.

```java
int x = 3;
double y = (double) x;		// 3.0
```

- 더 작은 크기의 자료형에 값을 저장한다면 정보의 손실이 있을 수 있다. 이러한 변환을 축소 변환이라고 한다.

```java
int x = 12.25;			// x = 12
```



### 예제: 연산과 형변환

```java
int i;
double f;

f = 5 / 4;					// 1.0
f = (double) 5 / 4;			// 1.25
i = (int) 1.3 + (int) 1.8	// 2
```

- `5 / 4`의 연산결과는 `1`이나, `f`의 자료형의 `double`이므로 `double`로 형변환되어 `1.0`이 할당된다.
- `(double) 5 /4`의 연산결과는 `1.25`로, `(double)` 연산자로 인해 `5.0 / 4`가 되어 최종적으로는 `5.0 / 4.0`이 된다.



## 05 콘솔에서 입력받기

### 입력하기

- `System.in`으로 콘솔에서 사용자의 입력을 읽는다.



## Scanner : 사용자 입력 받기

### import Scanner

```java
import java.util.Scanner;	// java.util의 Scanner class만 import (혹은)
import java.util.*;			// java.util의 모든 class를 import
```



### Scanner 객체 선언하기

```java
Scanner sc = new Scanner(System.in);
```



### Scanner.nextLine()

```java
import java.util.*;
// =================================================

Scanner input = new Scanner(System.in);		// Scanner 객체 선언하기
String line;

System.out.println("문장을 입력하세요");

line = input.nextLine();					// line에 키보드 입력 받기
System.out.println(line);
```

- `Scanner.nextLine()`은 `string`을 입력받아 반환한다.
- 한 줄의 문자열을 읽는다.



### Scanner.nextInt()

```java
Scanner input = new Scanner(System.in);
int x, y;
int sum;
		
System.out.println("첫번째 숫자를 입력하세요: ");
x = input.nextInt();

System.out.println("두번째 숫자를 입력하세요");
y = input.nextInt();

System.out.println(x + y);
```

- `Scanner.nextInt`는 `int`를 입력받아 반환한다.



### Scanner.nextDouble()

- 실수를 읽는다.



### Scanner.next()

- 단어를 읽는다.



## 06 수식과 연산자

- **수식(expression)**은 상수나 변수, 함수와 같은 피연산자들과 연산자의 조합이다.
- 연산자(operator)는 연산을 나타내는 기호이다. 피연산자(operand)는 연산의 대상이다.



### 연산자의 우선순위와 결합 규칙

- 대입 연산자와 단항 연산자는 오른쪽에서 왼쪽으로 계산된다.



### 산술 연산자

| 연산자 | 의미   |
| ------ | ------ |
| `+`    | 덧셈   |
| `-`    | 뺄셈   |
| `*`    | 곱셈   |
| `/`    | 나눗셈 |
| `%`    | 나머지 |



### 증감 연산자

| 연산자       | 의미            |
| ------------ | --------------- |
| `++X`, `--X` | 연산=> 값 사용  |
| `X++`, `X--` | 값 사용 => 연산 |



```java
int num = 3;
int x, y;
x = num++;		// 4
y = ++num;		// 4
```



### 관계 연산자

- **관계 연산(relational operator)**은 두 개의 피연산자를 비교하는 데 쓰인다.
- 관계 연산의 값은 `boolean` 타입(`true` 혹은 `false`)이다.

| 연산자 | 의미          |
| ------ | ------------- |
| `==`   | 같은가        |
| `!=`   | 다른가        |
| `>`    | 큰가          |
| `<`    | 작은가        |
| `>=`   | 크거나 같은가 |
| `<=`   | 작거나 같은가 |

- 왼쪽의 피연산자를 기준으로 의미를 해석한다.



### 논리 연산자

| 연산자기호 | 의미                               |
| ---------- | ---------------------------------- |
| &&         | 피연산자 모두 참일 때 true         |
| \|\|       | 피연산자 둘 중 하나가 참일 때 true |
| !          | 피연산자가 거짓이면 true           |



### 비트 연산자

- 비트끼리 논리 연산

| 연산자 | 의미                                                   |
| ------ | ------------------------------------------------------ |
| ~      | 비트 NOT                                               |
| &      | 비트 AND                                               |
| ^      | 비트 XOR                                               |
| \|     | 비트 OR                                                |
| <<     | 비트 왼쪽 이동                                         |
| >>     | 비트 오른쪽 이동, 왼쪽 비트가 부호비트로 채워진다.     |
| >>>    | 비트 오른쪽 이동(unsigned), 왼쪽비트가 0으로 채워진다. |

