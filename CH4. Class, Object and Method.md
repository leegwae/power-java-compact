# CH4. Class, Object and Method

## 01 객체 지향 프로그래밍이란

- **객체 지향 프로그래밍**(OOP: object-oriented programming)은 실제 세계와 비슷하게 소프트웨어를 작성해보자는 방법이다.



### 객체란

- 객체는 상태와 동작을 가진다.
- 객체의 **상태(state)**는 개체의 특징값(속성)이다.
- 객체의 **동작(behavior)** 또는 행동은 객체가 취할 수 있는 동작이다.
- 멤버 변수를 **필드(field)**, 멤버 함수를 **메서드(method)**라고 한다.



## 02 절차 지향과 객체 지향

- 절차지향 프로그래밍(procedural programming): 프로시저(procedure)를 중요하게 생각함. 문제를 더 작은 서브 프로시저로 분해하는 하향식 설계 방법. 데이터와 함수가 분리됨.
- 객체지향 프로그래밍: 데이터와 절차를 하나의 덩어리(객체)로 묶어서 생각하는 방법.



## 03 객체 지향 프로그래밍의 특징

- 캡슐화
- 상속
- 다양성



### 캡슐화(Encapsulation)

- **캡슐화(encapsulation)**: 관련된 데이터와 알고리즘(함수)이 하나의 묶음(클래스)으로 정리되어 있는 것
  - 재사용하기 용이함: 관련 있는 데이터와 알고리즘이 묶여 있으므로 재사용하기 용이함
  - 정보 은닉: 객체의 실제 구현 내용을 외부에 감춤.



### 상속

- 자식 클래스는 부모 클래스로부터 모든 속성과 동작을 물려받는다.



### 다형성(Polymorphism)

- 객체가 취하는 동작이 상황에 따라서 달라지는 것. <u>객체의 실제 동작은 실행 시간에 결정된다.</u>
- 하나의 이름(방법)으로 많은 상황에 대처하는 기법
- 개념적으로 동일한 작업을 하는 멤버 함수들에 똑같은 이름을 부여할 수 있으므로 코드가 더 간단해진다.



### 추상화(abstraction)

- 추상화는 필요한 것만 남겨놓는 것
- 불필요한 정보는 숨기고 중요한 정보만 표현한느 것.



### 객체 지향의 장점

- 신뢰성 있는 소프트웨어를 쉽게 작성할 수 있다.
- 코드를 재사용하기 쉽다.
- 업그레이드가 쉽다.
- 디버깅이 쉽다.



## 04 클래스

- **클래스(class)**
- **인스턴스(instance):** 클래스로부터 만들어지는 각각의 객체
- 클래스의 멤버: 필드와 메서드



### 클래스의 작성

```java
public class 클래스 이름{
    자료형 변수이름1;
    
    반환형 메소드이름(){
        
    }
}
```



### 객체 생성하고 필드와 메서드에 접근하기

- `.`을 이용하여 접근할 수 있다.

```java
class Circle {				// 클래스 정의
    public int radius;
    
    public void print(){
        System.out.println("In the Print Method...");
    }
}

publilc class CircleTest{
    public static void main(String[] args){	
   		Circle obj;								// 참조 변수 선언
        obj = new Circle();						// 객체 생성하고 참조 변수에 할당
    	
    	System.out.println(obj.radius);			// 필드 접근
        obj.print();							// 메서드 접근
	}  
}

```

- `new` 연산자: <u>객체를 **히프 메모리**에 생성한 후 객체의 참조값을 반환한다.</u>



### 변수의 종류

- **기초 변수(primitive variable)**: 실제 데이터값이 저장된다.
- **참조 변수(reference variable)**: 객체를 참조할 때 사용되는 변수, 객체의 참조값이 저장된다. 객체의 주소가 저장된다. 실제 값은 heap 영역에 저장된다.



## 05 메소드

- **메서드(method)**는 입력을 받아 처리하고 결과를 반환한다.



### 메소드의 정의

```java
반환형 메소드이름(매개변수자료형 매개변수){
    
}
```



### 메소드 오버로딩

- **메소드 오버로딩(메소드 중복 정의, method overloading)**: 같은 이름의 메서드를 여러 개 정의하는 것이다. 단, <u>**파라미터의 자료형이 달라야 한다.**</u> 반환형은 달라도 상관없다.



## 06 생성자

- **생성자(constructor)**: 객체를 초기화하는 메서드
- <u>**클래스의 이름과 이름이 같으며, 반환형이 없다.**</u>

```java
Class Album{
    private String writer;
    private int songs;
    
    Albumn(String w, int s){
        writer = w;
        songs = s;
    }
    
    public void print(){
		System.out.println(writer + " "+ songs);
    }
}
```

- 생성자 호출: `new` 키워드와 함께 생성자를 호출한다.

```java
Obj obj = new Obj();
```



### 기본 생성자

- <u>**기본 생성자(default constructor)**: 매개변수가 없는 생성자</u>. 
- <u>자바 컴파일: 생성자가 정의되어 있지 않으면 아무 일도 하지 않는 기본 생성자를 만들어준다.</u> 필드를 다음과 같은 같들로 초기화해준다.
  - `int`와 같은 숫자형: `0`
  - 참조형: `null`
  - `boolean`: `false`



### this 참조 변수

- `this`: 객체의 필드를 가리킨다.

```java
public class Circle{
    int radius;						// radius: (1) 객체의 필드
    
    public Circle(int radius){		// radius: (2) 지역 변수
        radius = radius;			// 좌변은 (2)를 가리킨다
    }
}
// ==================================================================
public class Circle{
    int radius;
    
    public Circle(int radius){
        this.radius = radius;		// 좌변은 (1)을 가리킨다.
    }
}
```



### this()

- `this()`: 생성자 내에서 호출되면, 해당 생성자가 아닌 생성자를 호출한다.
- 가장 복잡한 생성자를 먼저 작성한 후 다른 생성자가 이 복잡한 생성자를 호출하는데 흔히 쓰인다.

```java
public class Circle{
    int radius;
    
    public Circle(int radius){
        this.radius = radius;
    }
    
    public Circle(){
        this(0);					// Cricle(0)을 호출한다.
    }
}
```



## 07 접근 제어

- **접근 제어(access control)**: 클래스의 멤버에 접근하는 것을 제어하는 것이다.
  - `private` : 해당 클래스에서만 접근 가능
  - `public`: 외부에서도 접근 가능
  - `protected`: 상속 관계에서만 접근 가능
  - 디폴트(default): 같은 패키지 내에서는 접근 가능



| 접근 지정자 | 클래스 | 패키지 | 자식 클래스 | 전체 세계 |
| ----------- | ------ | ------ | ----------- | --------- |
| `public`    | O      | O      | O           | O         |
| `protected` | O      | O      | O           | X         |
| 없음        | O      | O      | X           | X         |
| `private`   | O      | X      | X           | X         |



### getter, setter

- 객체 지향의 정보 은닉을 지키기 위해, 변수는 `private`으로, 메서드를 `public`으로 선언하는 것이 좋다.
- 클래스 외부에서 `private` 필드에 접근하기 위해 객체 지향의 개념을 따르는 메서드를 선언한다.
  - **접근자(getter)**: 필드값을 반환한다.
  - **설정자(setter)**: 필드값을 설정한다.

```java
public class Account {
	private String name;
	private int num;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public static void main(String[] args) {
		Account obj = new Account();
		
		obj.setName("lana");
		System.out.println(obj.getName());
	}

}
```

```java
public class Account {
	private String name;
	private int num;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public static void main(String[] args) {
		Account obj = new Account();
		
		obj.setName("lana");
		System.out.println(obj.getName());
	}

}
```



## 08 String 클래스



### 객체의 생성

- 객체는 `new` 연산자로만 생성할 수 있다. `String`은 예외적으로 문자열 상수를 할당하여 객체를 생성할 수 있다.

```java
public class StringTest {

	public static void main(String[] args) {
		String s1 = new String("lana");
		String s2 = new String("lana");
		
		String s3 = "lana";
		String s4 = "lana";
	
		String s5 = "Hello, world!";
		System.out.println("indexOf 메서드");
		int idx = s5.indexOf("world");
		System.out.println("idx: "+ idx);
		
		System.out.println("compareTo 메서드");
		System.out.println("s1.compareTo(s5): " + s1.compareTo(s5));
		System.out.println("s5.compareTo(s1): " + s5.compareTo(s1));
		
		System.out.println();
		
		System.out.println("toLowerCase 메서드");
		System.out.println("s1.toLowerCase(): "+ s1.toLowerCase());
		
		System.out.println("toUpperCase 메서드");
		System.out.println("s1.toUpperCase(): "+ s1.toUpperCase());

		System.out.println();
		
		System.out.println("equals 메서드");
		System.out.println("s1.equlas(s2): "+ s1.equals(s2));
		System.out.println("s1.equlas(s3): "+ s1.equals(s3));
		
		System.out.println("== 연산자");
		System.out.println("s1 == s2: "+ (s1 == s2));
		System.out.println("s1 == s3: "+ (s1 == s3));
		System.out.println("s3 == s4: "+ (s3 == s4));
	}
}
```



### 문자열의 비교

```java
String s1 = "Lana";
String s2 = "Lana";
String s3 = new String("Lana");
String s4 = new String("Lana");

System.out.println("equals 메서드");
System.out.println("s1.equlas(s2): "+ s1.equals(s2));		// true
System.out.println("s1.equlas(s3): "+ s1.equals(s3));		// true
		
System.out.println("== 연산자");
System.out.println("s1 == s2: "+ (s1 == s2));				// true
System.out.println("s1 == s3: "+ (s1 == s3));				// false
System.out.println("s3 == s4: "+ (s3 == s4));				// false
```

- `==` : <u>**객체는 완전히 같은지 검사. 즉 주소값을 검사한다**</u>. `s3, s4`는 상수 영역에 하나로 있으므로(같은 것을 가리키므로) `true`
- `eqauls`: 문자열이 같은지만 검사한다.



## 09 화면에 윈도우 만들어보기

```java
import javax.swing.*;

public class FrameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame f= new JFrame("Frame Test");
		f.setSize(300,200);
		f.setLocation(1*30,20);
		f.setVisible(true);
	}
}
```

- `setSize(가로, 세로)`: 윈도우 크기
- `setLocation(x, y)`: 위치 정하기
- `setVisible(bool)`: 보일지 말지

