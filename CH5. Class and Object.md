# CH5. Class and Object

## 01 정적 멤버

- **정적 멤버(static member)**
  - 클래스 당 하나만 생성되어 모든 객체가 이것을 공유한다(그러니 객체를 만들지 않아도 생성된다). 
  - 클래스 멤버라고도 한다. 
  - `static` 키워드를 붙여 선언한다. 
  - **정적 변수(class variable)**: 클래스 당 하나만 생성되는 변수

```java
class StaticTest{
    static int count = 0;
}

public class MainPrograrm(String args[]){
    StaticTest st = new StaticTest();
    System.out.println(st.count);
    System.out.println(StaticTest.count);
}
```

- 인스턴스 멤버(instance member): 인스턴스마다 생겨나는 변수이다.



### 정적 변수

- 전역 변수: 프로그램의 어디서나 사용할 수 있는 변수
- 자바에는 전역 변수(global variable)의 개념이 없다. 모든 변수는 클래스 외부에 존재할 수 없다.
- 정적 변수로 일종의 전역 변수를 만들 수 있다.



### 정적 메서드

- **정적 메서드**: 메서드도 정적 메서드로 만들 수 있다.
- 메서드를 호출하기 위해 객체를 생성할 필요가 없다. 우리가 클래스의 인스턴스를 생성하지 않아도 `main` 메서드가 실행되는 이유이다.

```java
double value = Math.sqrt(9.0);
```

- <u>정적 메서드에서는 인스턴스 멤버에 접근할 수 없다. 정적 멤버에만 접근가능하다.</u>



## 02 객체 소멸

### 참조 변수 대입, 객체의 소멸과 가비지 콜렉터

- 객체는 반드시 `new` 연산자를 사용하여 생성한다.

```java
Pizza obj1 = new Pizza();
Pizza obj2 = new Pizza();

obj1 = obj2;
```

- `obj1`과 `obj2`는 이제 같은 객체를 참조한다.
- `obj2`가 원래 참조하던 객체는 reference count가 0이 되어 가비지 콜렉터에 의해 회수된다.



### 메서드로 기초형 변수가 전달되는 경우

```java
int x = 10;
obj.inc(x);
```

- 기초형 변수가 복사되어 전달된다.



## 03 인수의 전달

- 값에 의한 호출: 매개변수로 인수의 값이 복사된다. 
- 자바에서 메서드의 매개변수로 인수가 전달되는 방법은 기본적으로 **값에 의한 호출(call by value)**이다.



### 메서드로 객체가 전달되는 경우

```java
Circle obj = new Circle(10);
obj.inc(obj);

void inc(Circle c){
    c.count++;
}
```

- 객체가 복사되어 전달되지 않고, <u>참조 변수의 값(주소)이 복사되어서 전달</u>된다.
- 따라서 메서드 내에서 객체에 접근하여 값을 변경하면 원본 객체의 값이 변경된다.



### 메서드로 배열이 전달되는 경우

- 배열은 객체이므로 배열을 전달하는 것은 배열 참조 변수를 복사하는 것이다.



## 04 객체 배열

- 배열은 힙 영역에 저장된다.
- 기초형 배열: 값들의 배열을 참조
- 객체 배열: 주소값들의 배열을 참조



```java
class Album{
    String writer;
    
    pulibc Album(String writer){
        this.writer = writer;
    }
}

class Test{
    public static void Main(String[] args){
        Album[] albums;							// 배열 참조형 변수 선언
        albums = new Album[5];					// 배열 객체 생성하고 변수에 할당
        
        for (int i = 0; i < albums.length; i++){
            albums[i] = new Album("Writer"+i);	// Album 객체 생성하고 변수에 할당
        }
    }
}
```



### 동적 객체 배열 ArrayList

CH3. Selection and Iteration - 09 `ArrayList` 참고

- 배열의 사이즈가 생성될 때부터 결정된 배열과 달리 `ArrayList`는 동적으로 배열의 사이즈를 변경할 수 있다.



## 05 내장 클래스

- 내장 클래스: 클래스 안에 선언된 클래스
  - 정적 내장 클래스
  - 비정적 내장 클래스
    - **내부 클래스**
    - 지역 클래스
    - 무명 클래스
- 외부 클래스: 내부에 클래스를 가지고 있는 클래스



```java
public class Circle {
	int radius;
	Point center;
	
	class Point{			// 내부 클래스
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public void print() {
			System.out.println("원의 중심 = "+"("+x+" "+y+")");
		}
	}

	static class Line {		// 정적 내장 클래스
		int x1, y1, x2, y2;
		public Line(int a, int b, int c, int d) {
			x1 = a;
			y1 = b;
			x2 = c;
			y2 = d;
		}
	}
	
	public Circle(int radius, int x, int y){
		this.radius = radius;
		this.center = new Point(x, y);
	}
	
	double caclArea() {
		class C {			// 지역 클래스
			String name;
		}
		C c= new C();
		
		return 3.14 * radius * radius;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle circle = new Circle(10, 0, 0);
		Circle.Point p = circle.new Point(10, 20);
		
		Circle.Line l = new Circle.Line(10, 10, 20, 20);
	}

}

```



### 내부 클래스

- **내부 클래스(inner class)**: 클래스 안의 클래스이다. 그 자신이 선언된 외부 클래스의 멤버에 모두 접근할 수 있다.

```java
class OuterClass{
    private int num;
    
    class InnerClass{
        System.out.println(num);
    }
}
```

