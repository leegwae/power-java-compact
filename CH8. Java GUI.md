# CH8. Java GUI

## 8.1 그래픽 사용자 인터페이스

- **GUI(Graphical User Interface; 그래픽 사용자 인터페이스)**
  - **컴포넌트(component)**로 이루어진다.

- 자바에서는 언어에서 GUI 제공한다.
  - 컴포넌트, 컨테이너
  - 배치 관리자
  - 버튼, 레이븐, 텍스트 필드



### 8.1.1 AWT와 스윙

|                 | Java AWT | Java Swing  |
| --------------- | -------- | ----------- |
| 플랫폼          | 의존적   | 독립적이다. |
| 용량            | 크다     | 가볍다.     |
| 룩앤필          | 지원 X   | 지원한다.   |
| 컴포넌트의 개수 | 적다     | 많다.       |

- AWT(Abstract Windows Toolkit)은 OS가 제공하는 자원으로 만드므로 OS마다 그 모습이 다를 수 있다.



### 8.1.2 스윙 클래스 계층 구조

- 스윙 컴포넌트 역시 가장 최상위 클래스로 `Object`를 가진다. 
- AWT의 클래스와 구분하기 위해 `J`로 시작한다.



## 8.2 컨테이너와 컴포넌트

- 기본 컴포넌트, `JButton`, `JLabel`, `JCheckbox`, `JChoice`, `JList`, `Menu` 등
- 컨테이너 컴포넌트: 다른 컴포넌트를 안에 포함할 수 있는 컴포넌트



### 컨테이너의 종류

- 최상위 컨테이너: 다른 컨테이너에 포함될 수 없는 컨테이너
  - `JFrame`
  - `JDialog`
  - `JApplet`
- 일반 컨테이너: 다른 컨테이너 안에 포함될 수 있는 컨테이너
  - `JPanel`
  - `JScroll`



## 8.3 GUI 작성 절차

- 컨테이너를 생성한다.
- 컴포넌트를 추가한다.



### 8.3.1 컨테이너 생성하고 컴포넌트 추가하기

```java
import javax.swing.*;

public class MyFrame extends JFrame{
    public MyFrame(){
        setSize(300, 200);
        setTitle("MyFrame");
        SetDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new FlowLayout());
        JButton button = new JButton("버튼");
        add(button);
        setVisible(true);
    }
    
    public static void main(String[] args){
        MyFrame f = new MyFrame();
    }
}
```



### 8.3.2 JFrame 클래스

- 컨테이너는 컴포넌트들을 트리 형태로 저장한다. 최상위 컨테이너는 이 트리의 루트 노드가 된다.
- 최상위 컨테이너는 내부에 content pane을 가지고 있다. 여기에 화면에 보이는 컴포넌트를 저장한다.
- 최상위 컨테이너에는 메뉴바를 추가할 수 있다.



| function                     | 설명                                              |
| ---------------------------- | ------------------------------------------------- |
| `add(컴포넌트)`              | 프레임에 컴포넌트를 추가한다.                     |
| `setSize(가로, 세로)`        | 윈도우의 `가로`와 `세로`를 설정                   |
| `setLocation(x, y)`          | 프레임의 위치 설정                                |
| `setIconImage(IconImage)`    | 아이콘 설정                                       |
| `setTitle(타이틀)`           | 타이틀 설정                                       |
| `setVisible(불리언)`         | 윈도우 보일지 말지 설정                           |
| `setResizable(boolean)`      | 사용자가 프레임의 크기 조절할 수 있는지 여부 설정 |
| `SetDefaultCloseOperation()` | 윈도우 끄는 연산 설정                             |



## 8.4 배치 관리자

- **배치 관리자(layout manager)**: 컨테이너 안의 컴포넌트의 크기와 위치를 자동으로 관리



### 8.4.1 BorderLayout

- 컴포넌트들을 꽉 채워서 배치

```java
setLayout(new BorderLayout());
add(b1, BorderLayout.NORTH);	// 북쪽
add(b2, BorderLayout.SOUTH);	// 남쪽
add(b3, BorderLayout.EAST);		// 동쪽
add(b4, BorderLayout.WEST);		// 서쪽
add(b5, BorderLayout.CENTER);	// 중앙
```



### 8.4.2 FlowLayout

- 디폴트 배치 관리자
- 왼쪽에서 오른쪽으로 배치하고 자리 없으면 다음줄로 넘어감

```java
setLayout(new FlowLayout());

for (int i = 0; i < 5; i++){
    add(buttons[i]);
}
```



### 8.4.3 GridLayout

- `setLayout(new GridLayout(행의 개수, 열의 개수));`: 행이나 열의 개수를 `0`으로 지정하면 추가하는 컴포넌트의 개수에 따라 행이나 열의 개수가 결정된다.
- `setLayout(new GridLayout(0,3,1,1));`: 격자 간의 간격 `1`픽셀

```java
setLayout(new GridLayout(0,3));

for (int i = 0; i < 5; i++){
    add(buttons[i]);
}
```



### 8.4.4 CardLayout

- 카드가 겹쳐 쌓여있는 형태

```java
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MyCards extends JFrame implements ActionListener{
	JPanel panel;
	Cards cards;
	
	public MyCards() {
		setTitle("CardLayoutTest");
		setSize(400,200);
		
		panel = new JPanel(new GridLayout(0, 5, 0, 0));
		addButton("<<", panel);
		addButton("<", panel);
		
		add(panel, "North");
		cards = new Cards();
		add(cards, "Center");
		setVisible(true);
;	}
	
	void addButton(String str, Container target) {
		JButton button = new JButton(str);
		button.addActionListener(this);
		target.add(button);
	}
	
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		
		switch(actionCommand) {
		case "종료": System.exit(0);
		case "<<": cards.layout.first(cards); break;
		case "<": cards.layout.previous(cards); break;
		}
	}
	public static void main(String[] args) {
		MyCards f = new MyCards();

	}

	private class Cards extends JPanel {
		CardLayout layout;
		
		public Cards() {
			layout = new CardLayout();
			setLayout(layout);
			
			for (int i = 0; i <= 10; i++) {
				add(new JButton("현재 카드 번호는 "+i+"입니다"), "Center");
			}
			
		}
	}
}

```



### 8.4.5 절대 위치로 배치하기

```java
setLayout(null);
button2.setLocation(10, 30);
button2.setSize(90, 20);
```



## 8.5 패널 사용하기

```java
JPanel panel = new JPanel();
panel.setLayout(new GridLayout(3, 3));
panel.setBackground(Color.orange);
```

- 패널(panel): 컴포넌트들을 포함하고 있도록 설계된 컨테이너 중 하나



## 8.6 기초 컴포넌트들

| 컴포넌트                 | 설명                                          |
| ------------------------ | --------------------------------------------- |
| 레이블(`JLabel`)         | 텍스트를 표시할 수 있는 공간                  |
| 텍스트필드(`JTextField`) | 사용자가 한 줄의 텍스트를 입력할 수 있는 공간 |
| 버튼(`Button`)           | 클릭되면 어떤 동작을 실행하는 버튼            |



### 8.6.1 레이블

```java
JLabel label = new JLabel("안녕!");

JLabel label = new JLabel();
label.setText("안녕!");
```



### 8.6.2 텍스트 필드

- 텍스트 필드의 종류

| 텍스트 필드           | 설명                                                         |
| --------------------- | ------------------------------------------------------------ |
| `JTextField`          | 기본적인 텍스트 필드                                         |
| `JFormattedTextField` | 사용자가 입력할 수 있는 문자를 제한                          |
| `JPasswordField`      | 사용자가 입력하는 내용이 보이지 않는다.                      |
| `JComboBox`           | 사용자가 직접 입력할 수도 있지만 항목 중에서 선택할 수 있다. |
| `JSpinner`            | 텍스트 필드와 버튼이 조합된 것                               |



```java
textField = new JTextField(20);
textField.setEditable(fasle);	// 사용자가 편집 못하도록
```



### 8.6.3 버튼

| 버튼                | 설명                                                  |
| ------------------- | ----------------------------------------------------- |
| `JButton`           | 가장 일반적인 버튼                                    |
| `JCheckBox`         | 체크박스 버튼                                         |
| `JRadioButton`      | 라디오 버튼으로 그룹 중 하나의 버튼만 체크할 수 있다. |
| `JMenuItem`         | 메뉴                                                  |
| `JCheckBoxMenuItem` | 체크박스를 가지고 있는 메뉴항목                       |
| `JToggleButton`     | 토글 버튼                                             |



