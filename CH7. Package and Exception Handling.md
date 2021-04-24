# CH7. Package and Exception Handling

## 01 패키지란

- **패키지(package)**는 서로 관련된 클래스들을 하나로 묶을 수 있다.



### 패키지 구조를 사용하는 이유

- 서로 관련된 클래스들을 묶어서 조직화할 수 있다.
- 동일한 이름의 클래스라도 서로 다른 패키지에 속해있다면 사용할 수 있다.
- 패키지별로 접근에 제약을 가할 수 있다.



## 02 패키지 선언과 사용

## 패키지 선언하기

- 소스 코드 첫번째 줄에 `package` 문을 작성한다.

```java
package 패키지이름;
public class 클래스이름{
    
}
```

- 클래스 `클래스이름`은 패키지 `패키지이름`에 속하게 된다.
- 클래스의 정식 이름은 `패키지이름.클래스이름`이 된다.
- 패키지문을 사용하지 않는 경우, **디폴트 패키지(default package)**에 속하게 된다.



### 패키지 이름 짓기

- 일반적으로 소문자 이름을 사용한다. 클래스와 인터페이스 이름과의 중복을 피하기 위함이다.
- 인터넷 도메인 이름을 역순으로 사용한다. `com.company.test`라는 패키지 이름은 도메인 이름 `company.com`에서의 `test`라는 이름을 사용한다.
- 자바 언어 자체의 패키지는 `java`나 `javax`로 시작한다.



## 패키지 사용하기

### 패키지 안의 클래스와 인터페이스 사용하기

- 클래스에 패키지 이름을 앞에 붙여서 참조하기
- `import` 패키지

```java
import graphics.Cricle;
```



### 1: 클래스 이름에 패키지를 붙여 참조하기

```java
graphics.Cricle obj = new graphics.Cricle();
```



### 2: 클래스의 이름이 중복되는 경우

```java
import graphics.*;
// ...
Cricle myCircle = new Circle();
```

- `import` 문장을 사용한다.
  - 패키지문 다음에 위치해야한다.
  - `*`는 패키지 안의 모든 클래스를 포함한다는 뜻이다.
  - `import`문을 사용하면 (1)과 달리 패키지 이름을 생략할 수 있다.



## 03 소스 파일과 클래스 파일의 관리

### 소스 파일의 위치

- 많은 자바 구현에서 계층적인 파일 시스템을 이용한다.

```java
// Circle.java
package graphics;

public class Circle(){
    
}
```

- 소스파일은 다음의 경로에 저장되어야 한다.

```
<프로젝트 디렉토리>\graphics\Circle.java
```

- 이클립스에서는 다음과 같다.

```
<프로젝트 디렉토리>\src\graphics\Circle.java
```





### 클래스 파일의 위치

- 컴파일한 클래스 파일은 같은 경로에 저장된다.

```
<프로젝트 디렉토리>\graphics\Circle.class
```

- 이클립스에서는 다음과 같다.

```
<프로젝트 디렉토리>\src\graphics\Circle.class
```



## 클래스 경로

- 자바 가상 기계가 클래스 파일들을 찾는 경로를 **클래스 경로(class path)**라고 한다.
- 클래스 경로는 `CLASSPATH`라는 시스템 변수에 의해 설정된다.
- 컴파일러와 자방 가상 기계는 클래스 경로에 패키지 이름을 붙여 클래스 파일들을 찾는다.
- 클래스 경로의 기본값은 "."이다.
- `CLASSPATH` 환경 변수 또는 `-cp` 옵션을 지정하면 이 값이 변경된다.



**환경 변수 변경하기**

```
c:\> set CLASSPATH=C:\classes;c:\lib;.
```



**-cp로 디렉토리 지정하기**

```
C> java -cp C:classes;C:\lib;. graphics.Rectangle
```



### JAR 압축 파일

- 클래스 파일 또한 JAR(Java Archive) 파일 형태로 저장될 수 있다.
- JAR 파일은 여러 개의 클래스 파일을 디렉토리의 계층 구조를 유지한 채 압축하여 가진다.
- JAR 파일 안의 클래스 파일을 사용하려면 클래스 경로에 JAR 파일을 포함시키면 된다.

```
C:\> set CLASSPAT=C:\classes;C:\lib;C\test.jar;
```



## 04 자바 라이브러리 패키지

- 자바의 기본 패키지는 `java`로 시작한다.
- 자바의 확장 패키지는 `javax`로 시작한다.
- `String`, `System` 클래스는 `java.lang` 패키지에 포함된 클래스이다.



| 패키지          | 설명                                                |
| --------------- | --------------------------------------------------- |
| `java.applet`   | 애플릿을 생성하는데 필요한 클래스                   |
| `java.awt`      | 그래픽과 이미지를 위한 클래스                       |
| `java.io`       | 입력과 출력 스트림을 위한 클래스                    |
| `java.lang`     | 자바 프로그래밍 언어에 필수적인 클래스              |
| `java.math`     | 수학에 관련된 클래스                                |
| `java.net`      | 네트워킹 클래스                                     |
| `java.nio`      | 새로운 네트워킹 클래스                              |
| `java.security` | 보안 프레임워크를 위한 클래스와 인터페이스          |
| `java.sql`      | 데이터베이스에 저장된 데이터를 접근하기 위한 클래스 |
| `java.util`     | 날짜, 난수 생성기 등의 유틸리티 클래스              |
| `javax.imageio` | 자바 이미지 I/O API                                 |
| `javax.net`     | 네트워킹 애플리케이션을 위한 클래스                 |
| `javax.swing`   | 스윙 컴포넌트를 위한 클래스                         |
| `javax.xml`     | XML을 지원하는 패키지                               |



## 05 Object 클래스

- `Object` 클래스: `java.lang` 패키지에 들어있으며, 자바 클래스 계층 구조에서 맨 위에 위치하는 클래스이다.
- 클래스를 정의할 때 명시적으로 부모 클래스를 선언하지 않으면 `Object` 클래스가 부모 클래스가 된다.



### Object 클래스 안에 정의되어 있는 메서드

- 아래 메서드를 사용하기로 하였다면 용도에 맞도록 재정의해야한다.

| function                            | 설명                                       |
| ----------------------------------- | ------------------------------------------ |
| `public boolean equals(Object obj)` | `obj`와 같은지 비교하여 논리값을 반환한다. |
| `public String toString()`          | 객체의 문자열 표현을 반환한다.             |
| `protected Object clone()`          | 객체 자신의 복사본을 반환한다.             |
| `public int hashCode()`             | 객체에 대한 해쉬 코드를 반환하다.          |
| `protectd void finalize()`          | 가비지콜렉터에 의해 호출된다.              |
| `public void Class getClass()`      | 객체의 실행 클래스 정보를 반환한다.        |



### getClass() 메서드

- 객체가 어떤 클래스로 생성되었는지를 반환한다.
- **리플렉션**(**reflection**, 자신에 대한 질문을 던지는 것)을 구현

```java
class Car{}
public class CarTest{
    public static void main(String[] args){
        Car obj = new Car();
        Sysytem.out.println("obj is of type "+ obj.getClass().getName());
        System.out.println("obj의 해쉬코드="+obj.hashCode());
    }
}
```



### toString() 메서드

- 문자열로 변환될 때 호출되는 메서드이다.

```java
class Car{
	@Override
	public String toString() {
		return "This is Car";
	}
}
public class CarTest {

	public static void main(String[] args) {
		Car car = new Car();
		
		System.out.println(car);
	}

}
```

```
This is Car...
```



### equals() 메서드

- `==`로는 원하는 연산이 이루어지지 않을 수 있다.

```java
public class TestEqual{
    public static void main(String[] args){
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        
        if (s1 == s2) System.out.println("동일한 문자열이다.");
        else System.out.println("동일한 문자열이 아니다.")
    } 
}
```

```
동일한 문자열이 아니다.
```

- `s1`과 `s2`에 저장된 값은 객체의 참조값이다. 즉, `s1`과 `s2`은 서로 다른 객체를 가리키고 있으므로 `s1 == s2` 연산의 결과는 `false`이다.
- 의도한 대로 연산하기 위해서는 `equlas` 메서드를 사용해야한다.

```java
s1.equals(s2);
```



```java
class Circle{
    int radius;
    
    public Circle(int radius){
        this.radius = radius;
    }
   
    public boolean equals(Circle circle){
        if (radius == circle.radius) return true;
        else return false;
    }
}

class CircleTest{
    public static void main(String[] args){
        Circle c1 = new Circle(3);
        Circle c2 = new Circle(4);
        
        if (c1.equals(c2)) System.out.println("radius가 같다.");
        else System.out.println("radius가 같지 않다.");
    }
}
```



### finalize() 메서드

- `finalize()`는 콜백(callback) 메서드로, 객체가 소멸되기 직전에 호출된다.



## 06 Wrapper 클래스

- 자바에서 기초 자료형을 제외하고 모두 클래스이다.
- 기초 자료형도 객체로 포장해야할 경우, Wrapper 클래스를 사용한다.
  - 가령, `ArrayList`는 객체만을 요소로 가지므로, 기초 자료형을 객체로 포장한 후 요소로 추가해야한다.



### 기초 자료형에 해당하는 랩퍼 클래스

| 기초 자료형 | wrapper 클래스 |
| ----------- | -------------- |
| `boolean`   | `Boolean`      |
| `char`      | `Character`    |
| `byte`      | `Byte`         |
| `short`     | `Short`        |
| `int`       | `Integer`      |
| `long`      | `Long`         |
| `float`     | `Float`        |
| `double`    | `Double`       |



### Integer 클래스가 제공하는 메서드

| 메서드                         | 반환값           | 설명                                                 |
| ------------------------------ | ---------------- | ---------------------------------------------------- |
| `intValue()`                   | `static int`     | `int`형으로 반환한다.                                |
| `doubleValue()`                | `static double`  | `double`형으로 반환한다.                             |
| `floatValue()`                 | `static float`   | `float`형으로 반환한다.                              |
| `parseInt(String s)`           | `static int`     | 문자열을 `int`형으로 반환한다.                       |
| `toBinaryString(int i)`        | `static int`     | `int`형을 2진수 형태의 `String`형으로 반환한다.      |
| `toString(int i)`              | `static String`  | `int`형을 10진수 형태의 `String`형으로 반환한다.     |
| `valueOf(String s)`            | `static Integer` | 문자열 `s`를 `Integer` 객체로 반환한다.              |
| `valueOf(String s, int radix)` | `static Intger`  | 문자열 `s`를 `radix`진법의 `Integer`객체로 변환한다. |



### 값을 저장하고 꺼내기

- wrapper 객체에 기초 자료형의 값을 저장하고 꺼낸다.

```java
Integer integer = new Integer(100);
int intVal = integer.intValue();

Double doub = new Double(100.0);
double doubVal = doub.doubleValue();
```



### 기초 자료형을 문자열로 변환하기

```java
String s1 = Integer.toString(10);
String s2 = Float.toString(3.14);
String s3 = Double.toString(3.141592);
```



### 문자열을 기초 자료형으로 변환하기

```java
int i = Integer.parseInt("10");
int l = Long.ParseLong("10000");
float f = Float.ParseFloat("3.14");
double d = Double.ParseDouble("3.141592");
```



### 오토 박싱

- wrapper 객체와 기초 자료형 사이의 변환을 자동으로 하는 것.

```java
Integer box;
box = 10;	// boxing: 정수를 Integer 객체로 포장
System.out.println(box + 1);	// unboxing: box를 정수로 변환
```



## 07 String 클래스

### String 클래스의 메서드

| function              | 반환형    | 설명                                                         |
| --------------------- | --------- | ------------------------------------------------------------ |
| `charAt(int index)`   | `char`    | `index`의 요소를 `char`형으로 반환                           |
| `compareTo(String s)` | `int`     | 문자열을 비교하여 앞에 있으면 -1, 같으면 0, 뒤에 있으면 1을 반환한다. |
| `conact(String str)`  |           | 주어진 문자열을 붙인다.                                      |
| `equlas(Object obj)`  | `boolean` | 피연산자 `obj`과 문자열을 비교한다.                          |
| `isEmpty()`           | `boolean` | `length()`가 0이면 `false`를 반환한다.                       |
| `length()`            | `int`     | 문자열의 길이를 반환한다.                                    |
| `toLowerCase()`       |           | 문자열의 모든 문자들을 소문자로 바꾼다.                      |
| `toUpperCase()`       |           | 문자열의 모든 문자들을 대문자로 바꾼다.                      |



### String 객체의 생성

```java
String s1 = new String("Hello");
String s2 = "Hello";
```

- `s1`은 새로운 객체를 생성한다.
- `s2`는 문자열 상수에 있는 객체를 생성한다.



### 문자열의 기초 연산들

- 문자열의 메서드들 역시 `.`연산자로 호출한다.
- `concat()`메서드는 `+` 연산자로 대신할 수 있다.



### 문자열 비교하기

05 `Object` 클래스 - `toString()` 메서드 참고



### 문자열 안에서 단어 찾기

```java
String s = "The cat is on the table";
String cat = "cat";
int index = s.indexOf(cat);

System.out.println(index);
```



```
4
```



### 문자열을 분리하기

```java
String s = "Lana del rey";
String[] tokens = s.split(" ");

for (String token : tokens){
    System.out.println(token);
}
```

```
Lana
del
rey
```



### StringBuffer 클래스

```java
String s1 = "Hello";
String s2 = s1.concat(", World!");
```

- `concat`과 같은 메서드는 새로운 문자열을 반환한다.
- `StringBuffer`을 사용하면 변경가능한 문자열을 사용할 수 있다.

```java
StringBuffer sb = new StringBuffer();	// 16바이트의 공간이 할당됨
sb.append("Hello");						// 6바이트가 사용됨.
```

- 내부적으로 문자열 저장하는 버퍼를 가지고 있다. 버퍼의 크기는 자동으로 조절된다.
- `length()` 메서드로 현재 저장된 문자열의 길이를, `capacity()` 메서드로 버퍼의 크기를 반환한다.

```java
StringBuffer sb = new StringBuffer("Hello");
sb.append(", world!");
System.out.println(sb.length());
System.out.println(sb.capacity());
```

```java
13
21
```



- `append()` 메서드와 `insert()` 메서드는 중복정의된 메서드로 모든 타입의 데이터를 인수로 받을 수 있다. 인수를 문자열로 변환한후, 저장되어 있는 문자열에 넣는다.
  - `append(문자열)`: 저장된 문자열의 뒤에 붙인다.
  - `insert(인덱스, 문자열)`: `인덱스`에 문자열을 삽입한다.



## 08 기타 클래스들

### Math 클래스

```java
double x = Math.PI;
System.out.println(Math.sim(x));
System.out.println(Math.random());
```



### Random 클래스

- 난수를 생성하는데 쓰인다.
- 48 비트 길이의 시드(seed)를 사용한다.
- 알고리즘으로 변형된 선형 합동 수식을 이용한다.
- 동일한 시드를 이용한다면 동일한 난수를 발생시킨다.

```java
import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		Random random = new Random();
		
		for (int i = 0 ; i < 10; i++) {
			System.out.print(random.nextInt(100) + ", ");
		}
	}

}

```



### Arrays 클래스

```java
import java.util.Arrays;

public class ArraysTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 4, 2, 9, 10 };
		Arrays.sort(arr);
		printArray(arr);
		
		System.out.println("4가 있는 인덱스: "+ Arrays.binarySearch(arr, 4));
		
		Arrays.fill(arr, 1);
		printArray(arr);
	}

	private static void printArray(int[] arr) {
		System.out.print("[");
		for (int num : arr) {
			System.out.print(" "+num+ " ");
		}
		System.out.print("]\n");
	}
}
```

```
[ 2  3  4  9  10 ]
4가 있는 인덱스: 2
[ 1  1  1  1  1 ]
```



## Calendar 클래스

- 추상 클래스로, 날짜와 시간에 대한 정보와 특정 시각을 연도, 월, 일 등으로 변환하는 메서드를 가진다.
- 현재 시각을 나타내는 객체를 얻으려면 `getInstance()` 메서드를 사용한다.

```java
Calendar rightNow = Calendar.getInstance();
```



```java
import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int date = calendar.get(Calendar.DATE);
		
		System.out.println(calendar);
		System.out.println("\n"+year+"년, "+month+"월, "+date+"일"+"\n");

		calendar.set(Calendar.HOUR, 12);
		calendar.set(Calendar.MINUTE, 34);
		calendar.set(Calendar.SECOND, 12);
		System.out.println(calendar);
	}

}

```

```
java.util.GregorianCalendar[time=1619241860742,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2021,MONTH=3,WEEK_OF_YEAR=17,WEEK_OF_MONTH=4,DAY_OF_MONTH=24,DAY_OF_YEAR=114,DAY_OF_WEEK=7,DAY_OF_WEEK_IN_MONTH=4,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=24,SECOND=20,MILLISECOND=742,ZONE_OFFSET=32400000,DST_OFFSET=0]

2021년, 4월, 24일

java.util.GregorianCalendar[time=?,areFieldsSet=false,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2021,MONTH=3,WEEK_OF_YEAR=17,WEEK_OF_MONTH=4,DAY_OF_MONTH=24,DAY_OF_YEAR=114,DAY_OF_WEEK=7,DAY_OF_WEEK_IN_MONTH=4,AM_PM=1,HOUR=12,HOUR_OF_DAY=14,MINUTE=34,SECOND=12,MILLISECOND=742,ZONE_OFFSET=32400000,DST_OFFSET=0]

```



## 09 예외 처리란?

- **예외(excpetion)**란 "exceptional event"의 약자이다



## Try-catch 문

```java
try{
    // 예외가 발생할 수 있는 코드
}catch(예외종류 참조변수){
    // 예외를 처리하는 코드
} finally{
    // try-catch 블록이 끝나면 무조건 실행된다.
}
```

- `try` 블록에 예외가 발생할 수 있는 코드를 작성한다. 이 블록에서는 처음 발생하는 하나의 예외만 잡는다.
- `catch` 블록에 예외가 발생했을 경우 예외를 처리하는 코드를 작성한다. 예외마다 하나의 `catch` 블록을 지정해야한다.
- `finally` 블록은 `try-catch` 블록이 끝나면 무조건 실행한다. 즉, 예외가 실행되는지 여부에 관계없이 실행되어야하는 문장이다.



### 0으로 나누기 예외 처리하기

```java
import java.util.Scanner;

public class DivideTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		
		System.out.print("a / b 중 a를 입력하세요: ");
		a = sc.nextInt();
		System.out.print("a / b 중 b를 입력하세요: ");
		b = sc.nextInt();
		try {
			System.out.println("a / b = " + ( a / b ));
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없어요.");
			
			System.out.println("\n에러 메시지: "+e.getMessage() + "\n호출 스택 내용:");
			e.printStackTrace();
		}
	}

}

```

```
a / b 중 a를 입력하세요: 2
a / b 중 b를 입력하세요: 0
0으로 나눌 수 없어요.

에러 메시지: / by zero
호출 스택 내용:
java.lang.ArithmeticException: / by zero
	at Week7.DivideTest.main(DivideTest.java:16)
```



### 배열 인덱스 예외 처리하기

```java
public class ArrayIndexErrorTest {

	public static void main(String[] args) {
		int[] arr = { 3, 4, 1, 2, 10, 5 };
		int i  = 0;
		
		try {
			for (i = 0; i <= arr.length; i++) {
				System.out.println("배열의 "+i+"번째: "+arr[i]);
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("\n에러 메시지:"+ e.getMessage() + "\n호출 내용 스택:");
			e.printStackTrace();
		}
	}

}
```

```
배열의 0번째: 3
배열의 1번째: 4
배열의 2번째: 1
배열의 3번째: 2
배열의 4번째: 10
배열의 5번째: 5

에러 메시지:Index 6 out of bounds for length 6
호출 내용 스택:
java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 6
	at Week7.ArrayIndexErrorTest.main(ArrayIndexErrorTest.java:11)
```



## try-with-resources 문장

```java
try () {
    
}
```

- `try` 키워드 바로 다음에 소괄호가 있으면 자원으로 취급한다. 이 자원은 `try`블록 내에서만 그 범위가 유효하다.

```java
import java.io.*;

public class FileReaderTest{
	static public void main(String[] args) throws IOException {
		try(FileReader fr = new FileReader("error.txt");){
			char[] characters = new char[50];
			fr.read(characters);
			
			for (char character : characters) {
				System.out.print(character);
			}
		}catch (IOException e){
			e.printStackTrace();
		}
	
	}
}
```

에러가 발생하면 콘솔은 다음과 같이 출력된다.

```java
java.io.FileNotFoundException: error.txt (지정된 파일을 찾을 수 없습니다)
	at java.base/java.io.FileInputStream.open0(Native Method)
	at java.base/java.io.FileInputStream.open(FileInputStream.java:211)
	at java.base/java.io.FileInputStream.<init>(FileInputStream.java:153)
	at java.base/java.io.FileInputStream.<init>(FileInputStream.java:108)
	at java.base/java.io.FileReader.<init>(FileReader.java:60)
	at Week7.FileReaderTest.main(FileReaderTest.java:7)
```



## 참고사항

- `try`블록과 `catch`블록은 독립된 블록이다. 따라서 `try` 블록에서 정의된 변수는 `catch` 블록에서 사용할 수 없다.
- 최선의 방법은 예외가 일어나지 않게 하는 것이므로, 0으로 나누는 것과 같은 경우는 미리 `if`문으로 검사하는 것이 좋다.



## 예외의 종류

- `Error`: 너무 심각해서 통과할 수 없음. 자바 가상 기계 안에서 치명적인 오류가 발생
- `RuntimeException`: 프로그래밍 버그나 논리 오류에서 기인
  - 0으로 나눌 때
  - null을 참조할 때
  - 등등
- 그 외 : 회복할 수 있는 예외이므로 프로그램에서 반드시 처리해야함. 컴파일러가 체크한다는 의미이므로 체크 예외(checked exception)이라고 한다.



## 다형성과 예외

- 예외도 자바에서는 객체다.

```java
try{
    
}catch(NumberException e){
    
}
```

- `NumberException`만 받는다.

```java
try{
    
}catch(Excpetion e)
```

- 무슨 예외로 잡혔는지 알 수 없다.



## 예외를 기술하는 방법

- 예외를 잡아서 그 자리에서 처리하는 방법: `try-catch`
- <u>메서드가 예외를 발생시킨다고 기술하는 방법</u>: `throws`, 예외가 발생한 메서드에게 예외처리를 맡긴다.

```java
public void writeList() throws IOExcpetion, ArrayIndexOutOfBoundsException{
    // IOExpcetion 예외를 던질 수 있는 메서드임을 명시한다.
}
```



## 예외를 발생시키는 메서드를 정의하기

```java
int sub() throws a, b{
    
}
```

- 메서드의 실행 도중 해당 예외가 발생되면, 메서드의 실행이 종료된다.



## 예외 처리 과정

- 메서드 호출 스택을 거슬러가면서 예외 처리기가 있는 메서드를 찾는다.
- `printStackTrace()`로 호출 스택의 내용을 출력할 수 있다.



## 예외 생성하기

- 예외는 `throw` 문장을 이용하여 생성한다.

```java
if (index == -1) throw new NotFoundException();
```



## 연속적인 예외 발생

- 예외를 처리하면서 다른 예외를 발생시키면 `catch` 블록 안에서 `throw`로 새로운 예외를 던지면 된다.



## 사용자 정의 예외

```java
public class MyException extends Exception {
    public MyException(){
        super("사용자 정의 예외");
    }
}
```



```java
class NotFoundException extends Exception{
	public NotFoundException() {
		super("사용자 정의 예외");
	}
}

public class ExceptionTest {

	public static int searchArray(int[] arr, int key) throws NotFoundException {
		int index = -1;
		int i = 0;
		for (int num : arr) {
			if (num == key) {
				index = i;
				break;
			}
			i++;
		}
		if (index == -1) throw new NotFoundException();

		return index;
	}
	public static void main(String[] args) {
		int[] arr = { 3, 1, 5, 9, 6};
		int key = 4;
		int keyIndex = -1;
		
		try {
			keyIndex = searchArray(arr, key);
			System.out.println("찾는 키: "+ key+"는 arr의 "+ keyIndex + "에 있습니다.");
		}catch(NotFoundException e){
			System.out.println(e.getMessage() + "\n호출 스택 내용");
			e.printStackTrace();
			System.out.println("예외 테스트");
		}
	}

}
```

```
사용자 정의 예외
호출 스택 내용
Week7.NotFoundException: 사용자 정의 예외
	at Week7.ExceptionTest.searchArray(ExceptionTest.java:21)
	at Week7.ExceptionTest.main(ExceptionTest.java:31)
예외 테스트
```



## 예외 처리

- 오류가 발생하면 사용자에게 알려주고 모든 데이터를 저장하게 한 후에 사용자가 우아하게 프로그램을 종료할 수 있게 해줘야한다.