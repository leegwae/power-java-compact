# CH6. Inheritance

# 6.1 상속

- 부모 클래스의 멤버, 즉 필드와 메서드를 상속받을 수 있다.
- `extends`: 부모 클래스를 확장하여 자식 클래스를 작성한다.

```java
class Child extends Parent{
    
}
```

- 부모 클래스는 슈퍼클래스(superclass), 자식 클래스는 서브클래스(subclass)라고 한다.



## 상속받은 멤버의 사용

- 멤버 연산자 `.`를 사용한다.

```java
SportCar obj = new SportsCar();
obj.speed = 10;		// 부모 클래스로부터 상속받은 필드 사용
obj.setSpeed(60);	// 부모 클래스로부터 상속받은 메서드 사용
```



## 상속이 필요한 이유

- 코드를 재사용할 수 있다.

- 중복을 피할 수 있다.



- 자식 클래스에서 부모 클래스의 멤버는 초기화하지 않는게 좋다.



## 상속 제어

- `private`으로 선언한 멤버는 자식 클래스에서 접근할 수 없다.
- getter, setter를 항상 선언하여 접근하기 불편하니, `protected`로 선언하여 상속 관계에서만 접근 가능하도록 설계



#  6.2 접근 제어 지정자

| 클래스\멤버                 | public | protected | default | private |
| --------------------------- | ------ | --------- | ------- | ------- |
| 동일한 클래스               |        |           |         |         |
| 동일한 패키지의 일반 클래스 |        |           |         | X       |
| 동일한 패키지의 자식 클래스 |        |           |         | X       |
| 다른 패키지의 일반 클래스   |        |           | X       | X       |
| 다른 패키지의 자식 클래스   |        | X         | X       | X       |

- 자식 클래스는 부모 클래스의 `public`, `protected`, `default` 멤버를 상속받을 수 있다.
- 그러나 `private`은 상속되지 않는다.



# 6.3 상속과 생성자

- 서브 클래스의 객체가 생성될 때, 서브 클래스의 생성자만 호출되는가, 아니면 수퍼 클래스의 생성자도 호출되는가?
  - <u>먼저 부모 클래스의 생성자가 호출된 후, 자식 클래스의 생성자가 호출된다.</u>
- 이때 부모 클래스가 호출되는 것을 **묵시적인 생성자 호출**이라고 할 수 있다. 또한 이때 호출되는 생성자는 파라미터가 없는 생성자이다. 그런데 부모 클래스의 생성자에 파라미터를 전달해야할 때, 아무것도 호출하지 않으면 오류가 발생한다. 따라서 부모 클래스의 생성자에 파라미터를 전달해야할 때 `super()`를 사용한다. 이때는 **명시적인 생성자 호출**이다.

```java
class Base{
	public Base() {
		System.out.println("Base() 생성자...");
	}
	public Base(String msg) {
		System.out.println("Base() 생성자... "+ msg);
	}
}

class Derived extends Base{
	public Derived() {
		super("Hello!");
		System.out.println("Derived() 생성자...");
	}
}
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Derived derived = new Derived();
	}

}

```

- `super()`: 명시적으로 부모 클래스의 생성자를 호출한다.



# 6.4 메서드 재정의(메서드 오버라이딩)

- 메서드 재정의(method overriding): 자식 클래스가 필요에 따라 상속된 메서드들을 다시 정의하는 것 
- <u>**재정의한 메서드의 이름, 반환형, 매개변수의 개수와 데이터 타입이 부모의 메서드와 일치해야한다**</u>.
  - 그렇지 않다면 메서드 오버로딩(메서드 중복 정의)로 처리된다.
- `@Override` annotation: 오버라이딩이라는 것을 명시적으로 표현할 수 있다.

```java
class Animal{
	public void print(String speak) {
		System.out.println("Animal: "+ speak);
	}
}

class Lion extends Animal{
	@Override
	public void print(String speak) {
        super.print("크왕");
		System.out.println("Lion: "+speak);
	}
}
public class LionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lion lion = new Lion();
		lion.print("와앙");
	}

}

```

```
Animal: 크왕
Lion: 와앙
```



## 키워드 super로 부모 클래스 멤버에 접근하기

```java
class Parent{
    public void print() {}
}

class Child{
    public void print() {
        super.print()			// 부모 클래스의 print 메서드 호출
    }
}
```



# 6.5 추상 클래스

- 추상 클래스(abstract class): <u>몸체가 구현되지 않은 메서드</u>를 가지고 있는 클래스

```java
public abstract class AbstractClass {
    public abstract void abstractMethod();
}
```

- 추상 클래스는 적어도 하나의 추상 메서드를 가지고 있는 클래스이다.
- <u>추상 클래스를 상속받는 클래스는 반드시 추상 메서드를 구현해야한다</u>.
- 추상 클래스의 생성자와 `new` 연산자로 객체를 추상 클래스 타입의 객체를 생성할 수 없다.
- 추상 클래스와 추상 메서드를 선언할 때는 `abstract` 키워드를 붙인다.

```java
abstract class Animal{
	abstract public void speak();
}

class Lion extends Animal{
	public void speak() {
		System.out.println("크와왕");
	}
}
public class AbstractTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal animal = new Lion();
		Lion lion = new Lion();
		
		animal.speak();
		lion.speak();
	}
}

```



실행 결과

```
크와왕
크와왕
```



- 추상 메서드를 구현할 때, 반환형과 파라미터가 추상 메서드와 동일해야하는가?
  - **메서드 오버라이딩**에서는 반환형과 파라미터가 모두 동일해야한다.



# 6.6 다형성

- **다형성(polymorphism)**은 객체들의 타입이 다르면 똑같은 메시지가 전달되더라도 서로 다른 동작을 하는 것을 뜻한다.
- 오버라이딩(메서드 재정의)은 **동적 바인딩**을 한다.



## 상향 형변환: 부모 클래스 참조 변수에 자식 클래스 객체 할당하기

```java
Parent p1, p2;
p1 = new Parent();
p2 = new Child();
```

- 서브 클래스 객체는 부모 클래스 객체를 포함한다.
- 따라서, 서브 클래스의 객체를 부모 클래스 타입의 변수에 할당할 수 있다. 즉 부모 클래스 참조 변수로 자식 클래스 객체를 참조할 수 있다. 단, <u>이때의 변수로는 서브클래스의 멤버에 접근할 수 없다</u>. 부모 클래스로부터 상속받은 멤버에만 접근할 수 있다.

```java
public class ShapeTest{
    public static void main(String[] args){
        Shape s = new Rectangle();			// 부모 클래스 참조 변수에 자식 클래스 객체 할당하기
        Rectangle r = new Rectangle();
        
        s.x = 0;							// 상속받은 멤버에 접근하기
        	
        s.width = 100;						// 컴파일 오류 발생!
    }
}
```



## 오버라이딩된 메서드의 동적 바인딩

- **동적 바인딩(dynamic binding)**: 부모 클래스 참조 변수를 통해 **오버라이딩된 메서드를 호출하면**, 자식 클래스의 메서드가 호출된다. 오버라이딩은 런타임(실행 시간)에 메서드의 성격이 결정되기 때문이다.

```java
class Shape{
	int x;
	
	public Shape() {
		x = 3;
	}
	public void print() {
		System.out.println("In the Shape Method...");
	}
}

class Circle extends Shape{
	int x;
	
	public Circle() {
		x = 2;
	}
	@Override
	public void print() {
		System.out.println("In the Circle Method...");
	}
}

class Triangle extends Shape{
	int x;

	public Triangle() {
		x = 1;
	}
	@Override
	public void print() {
		System.out.println("In the Triangle Method...");
	}
}

public class OverrridingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape[] shapes = new Shape[3];
		shapes[0] = new Shape();
		shapes[1] = new Circle();
		shapes[2] = new Triangle();
		
		for (Shape shape : shapes) {
			System.out.println("x의 값: "+ shape.x);
			shape.print();
		}
	}
}

```



실행 결과

```
x의 값: 3
In the Shape Method...
x의 값: 3
In the Circle Method...
x의 값: 3
In the Triangle Method...
```



- 자식 클래스의 객체를 부모 클래스 참조 변수에 할당한 경우, 자식 클래스의 객체의 필드와 메서드에 접근할 수 없는데 왜 자식 클래스의 메서드에 정의된 대로 함수가 호출되어 로그가 찍히는가?
  - **오버라이딩된 메서드에 한하여**, 어떤 메서드가 호출될지 실행 시간에 결정된다.
  - 그렇지 않은 필드와 메서드의 경우, 부모 클래스 참조 변수에서는 접근할 수 없다. 컴파일 타임에 다음과 같은 오류가 발생한다.

```
The method drawTriangle() is undefined for the type Shape
```



## instanceof: 객체의 타입 반환

- `instanceof`: 피연산자의 객체의 타입을 비교한다.

```java
obj instanceof Object
```

```java
s = new Circle();

if (s instanceof Circle){
    System.out.println("s is instance of circle");
}
```



# 07 인터페이스

- **인터페이스(interface)**: 서로 다른 장치들이 연결되어 상호 데이터를 주고받는 규격을 의미. 서로 다른 클래스 간의 연결을 위해서도 일종의 규격이 있어야한다.



## 인터페이스 정의

```java
interface 인터페이스이름{
	반환형	추상메서드1();
    반환형	추상메서드2();
}
```

- 인터페이스는 **추상 메서드로 이루어진다**. `public abstract`를 생략해도 된다.
- **필드는 선언될 수 없다**.
- **상수는 정의할 수 있다**.



## 인터페이스 구현

- 인터페이스로는 객체를 생성할 수 없다. 인터페이스는 클래스에 의해 **구현(implement)**될 뿐이다.
- 인터페이스를 구현하는 클래스는 인터페이스에 정의된 **모든 추상 메서드를 구현**한다. 
- `implements` 키워드로 이를 표현한다.

```java
class 클래스이름 implements 인터페이스 이름{
    
}
```



```java
interface Drawable{
	void draw();    
}

class Circle implements Drawable{
    int radius;
    
    public void draw() {
		System.out.println("Circle Draw...");
    }
}

public class InterfaceTest{
	static public void main(String[] args) {
	 	Drawable obj = new Circle();
	    obj.draw();
	}

}
```

- 외부에 드러나는 것은 인터페이스의 추상 메서드를 오버라이딩한 메서드 뿐이다.

  



## 다중 상속의 간접 구현: 상속과 동시에 인터페이스 구현하기

```java
class Circle extends Shape implements Drawable{
    int radius;
   
    public void draw(){
        System.out.println("Cricle Draw...");
    }
}
public class TestInterface{
    public static void main(String[] args){
        
    }
}
```



## 인터페이스로 다중 상속 구현하기

```java
interface Printable{
    void print();
}
interface Drawable{
    void draw();
}
public class Circle extends Shape implements Printable, Drawable{
    public void print(){
        System.out.println("Circle Print...");
    }
    public void draw(){
        System.out.println("Circle Draw...");
    }
    public static void main(String[] args){
        Cricle obj = new Cricle();
    }
}
```

- 다중 상속은 금지되어 있지만, 인터페이스는 여러 개 구현할 수 있으므로 다중 상속을 간접적으로 구현할 수 있다.



## 인터페이스와 default

```java
interface Drawable{
    default void draw(){
        System.out.println("Default Draw...");
    }
}
```

- 인터페이스를 상속받은 클래스에서 `default`가 붙은 추상 메서드를 구현하지 않으면, 해당 메서드를 호출했을때 정의된 함수의 본문이 호출된다.



**구현해야할 메서드 이름이 같은 인터페이스가 여러 개이고 상속받는 클래스의 메서드 이름도 같은 경우**

```java
interface Drawable1{
	default void print() {
		System.out.println("Drawable1...");
	}
}

interface Drawable2{
	default void print() {
		System.out.println("Drawable2...");
	}
}

class ParentShape{
	public void print() {
		System.out.println("Parent Shape...");
	}
}

class ChildShape extends ParentShape implements Drawable1, Drawable2{
	
}

public class DefaultTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChildShape cs = new ChildShape();
		
		cs.print();
	}

}
```



```
Parent Shape...
```



**구현해야할 메서드 이름이 같은 인터페이스가 여러 개인 경우**

```java
interface Drawable1{
	default void print() {
		System.out.println("Drawable1...");
	}
}

interface Drawable2{
	default void print() {
		System.out.println("Drawable2...");
	}
}

class ChildShape implements Drawable1, Drawable2{		// 오류 발생!
	
}

public class DefaultTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChildShape cs = new ChildShape();
		
		cs.print();
	}

}

```

```
Duplicate default methods named print with the parameters () and () are inherited from the types Drawable2 and Drawable1
```

- 이름이 중복된다는 오류가 발생한다.