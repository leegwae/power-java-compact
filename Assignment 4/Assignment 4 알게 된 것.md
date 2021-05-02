# Assignment 4 알게 된 것

## EX4_4

- 어떠한 메서드가 오류를 던질 수 있다고 기술되었을 때, 해당 메서드의 호출은 반드시 `try` 블록 안에서 이루어져야한다.

```java
public void withdraw(int amount) throws NagativeBalanceException {}
```

위와 같이 정의된 메서드의 호출을 `try` 블록 바깥에서 한다고 하자.

```java
bankAccount.deposit(20000);
bankAccount.withdraw(15000);
try {
	bankAccount.withdraw(10000);
} catch (NagativeBalanceException e) {
	System.out.println(e.getMessage());
}
```

다음과 같은 오류가 2행에서 발생한다.

```java
Unhandled exception type NagativeBalanceException
```

반드시 `try` 블록 안에서 호출하여 에러를 처리할 수 있도록 한다.

```java
bankAccount.deposit(20000);
try {
	bankAccount.withdraw(15000);
	bankAccount.withdraw(10000);
} catch (NagativeBalanceException e) {
	System.out.println(e.getMessage());
}
```

