# 9장 이벤트 처리

## 9.1 이벤트 처리 개요

### 9.1.1 이벤트란

- **이벤트-구동 프로그래밍(event-driven programming)**: 어떤 이벤트가 일어나는지 감시하고 있다가 이벤트가 발생하면 적절한 처리를 해주는 프로그래밍 방식



### 9.1.2 이벤트는 누가 처리하는가?

- **위임(delegation)**: 이벤트를 발생시키는 객체가 아니라 다른 객체가 이벤트를 처리하는 것
  - 객체 지향 프로그래밍에서는 모든 작업을 객체가 하므로 이벤트 처리 역시 객체가 수행한다.
  - 따라서 이벤트를 처리하는 클래스를 정의하고, 해당 클래스의 객체를 생성한 후 이벤트를 발생하는 객체에 등록한다. 이벤트가 발생하면 등록된 객체가 이벤트를 처리한다.



### 9.1.3 위임으로 이벤트를 처리하는 방법

- (1) 이벤트를 처리하는 클래스를 정의하기

```java
class MyListenr implements ActionListner{
    public void actionPerforemd(ActionEvent e){
    	// ActionEvent를 처리하는 코드
	}
}
```

- (2) 컴포넌트에 이벤트 처리 객체 등록하기

```java
button = new JButton("증가");
button.addActionListner(new MyListner());
```



```java
// counter 변수를 증가시키는 버튼
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FlowLayoutWindow extends JFrame {

	private JButton button;
    private JLabel label;
    int counter = 0;
    
    class MyListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
   			counter++;
            label.setText("현재의 카운터값: " + counter);
		}
	}
    
    public FlowLayoutWindow(){
        setSize(400, 150);
        setTitle("이벤트 예제");
        setLayout(new FlowLayout());
        
        button = new JButton("증가");
        button.addActionListener(new MyListener());
        
        label = new JLabel("현재의 카운터값" + counter);
        
        add(label);
        add(button);
        setVisible(true);
    }
    
    public static void main(String[] args){
        FlowLayoutWindow f = new FlowLayoutWindow();
    }

}
```

 

## 9.2 이벤트를  처리하는 방법

- 방법 (1) 별도의 클래스를 정의하기(인터페이스를 구현하는 객체 생성하기): 9.1.3 참고
- 방법 (2) 프레임 클래스가 이벤트 처리하기: 프레임 클래스가 인터페이스를 구현
- 방법 (3) 무명 클래스가 이벤트 처리



### 9.2.1 (2) 프레임 클래스가 이벤트를 정의하기

```java
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FlowLayoutWindow extends JFrame implements ActionListener {

	private JButton button;
    private JLabel label;
    int counter = 0;
    
	public void actionPerformed(ActionEvent e){
		counter++;
        label.setText("현재의 카운터값: " + counter);
	}
    
    public FlowLayoutWindow(){
        setSize(400, 150);
        setTitle("이벤트 예제");
        setLayout(new FlowLayout());
        
        button = new JButton("증가");
        label = new JLabel("현재의 카운터값" + counter);
        button.addActionListener(this);
        
        add(label);
        add(button);
        
        setVisible(true);
    }
    
    public static void main(String[] args){
        FlowLayoutWindow f = new FlowLayoutWindow();
    }

}

```



### 9.2.2 (3) 무명 클래스가 이벤트 처리

```java
package Week10;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FlowLayoutWindow extends JFrame {

	private JButton button;
    private JLabel label;
    int counter = 0;
    
    public FlowLayoutWindow(){
        setSize(400, 150);
        setTitle("이벤트 예제");
        setLayout(new FlowLayout());
        
        button = new JButton("증가");
        label = new JLabel("현재의 카운터값" + counter);
        
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
       			counter++;
                label.setText("현재의 카운터값: " + counter);
    		}
    	});
        
        add(label);
        add(button);
        
        setVisible(true);
    }
    
    public static void main(String[] args){
        FlowLayoutWindow f = new FlowLayoutWindow();
    }

}

```



### 9.2.3 무명 클래스

```java
new 인터페이스이름() {
    // 인터페이스 구현
}
```

```java
// ActionListener 인터페이스를 구현한 무명 클래스
new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        
    }
}
```

- **무명 클래스**: 이름이 없는 클래스다.

- 무명 클래스의 작성: (1) 부모 클래스에서 상속을 받거나 (2) 인터페이스를 구현하여 작성할 수 있다.

  - (1) 부모클래스로부터 상속받는 무명 클래스 생성하기

    ```java
    new 부모클래스이름() {}
    ```

  - (2) 인터페이스를 구현하는 무명 클래스 생성하기

    ```java
    new 인터페이스이름() { // 인터페이스의 추상 메서드 구현 }
    ```



## 9.3 람다식

- **람다식(lambda expression)**은 이름이 없는 메서드이다.

```java
(arg1, arg2) -> {  }
```

```java
(int a, int b) -> { return a + b; }
```



### 람다식을 이용한 counter 이벤트의 처리

```java
button.addActionListener(e -> {
    counter++;
    label.setText("현재의 카운터값: "+counter);
});
```



## 모든 컴포넌트들이 지원하는 이벤트

| 이벤트        | 설명                                                         |
| ------------- | ------------------------------------------------------------ |
| `Component`   | 컴포넌트의 크기나 위치가 변경되었을 때 발생                  |
| `Focus`       | 키보드 입력을 받을 수 있는 상태가 되었을 때, 혹은 그 반대의 경우에 발생 |
| `Container`   | 컴포넌트가 컨테이너에 추가되거나 삭제될 때 발생              |
| `Key`         | 사용자가 키를 눌렀을 때 키보드 포커스를 가지고 있는 객체에서 발생 |
| `Mouse`       | 마우스 버튼이 클릭되었을 때, 또는 마우스가 객체의 영역으로 들어오거나 나갈 때 발생 |
| `MouseMotion` | 마우스가 움직였을 때 발생                                    |
| `MouseWheel`  | 컴포넌트 위에서 마우스 휠을 움직이는 경우 발생               |
| `Window`      | 윈도우에 어떤 변화가 있을 때 발생(열림, 닫힘, 아이콘화 등)   |



## 일부 컴포넌트들이 지원하는 이벤트

| 이벤트          | 설명                                                         |
| --------------- | ------------------------------------------------------------ |
| `Action`        | 사용자가 어떤 동작을 하는 경우에 발생                        |
| `Caret`         | 텍스트 삽입점이 이동하거나 텍스트 선택이 변경되었을 경우 발생 |
| `Change`        | 일반적으로 객체의 상태가 변경되었을 경우 발생                |
| `Document`      | 문서의 상태가 변경되는 경우 발생                             |
| `Item`          | 선택 가능한 컴포넌트에서 사용자가 선택을 하였을 때 발생      |
| `ListSelection` | 리스트나 테이블에서 선택 부분이 변경되었을 경우에 발생       |



## Listener 인터페이스의 요약

| 리스트 인터페이스     | 어댑터 클래스        | 메서드                                                       |
| --------------------- | -------------------- | ------------------------------------------------------------ |
| `ActionListenenr`     | none                 | `actionPerformend()`                                         |
| `AdjustmentListner`   | none                 | `adjustmentValueChanged()`                                   |
| `ComponentListener`   | `ComponentAdapter`   | `componentHidden()`, `componentMoved()`, `componentResized()`, `componentShown()` |
| `ContianerListener`   | `ContainerAdapter`   | `componentAdded()`, `componentRemoved()`                     |
| `FocusListener`       | `FocusAdapter`       | `focusGained()`, `focusLost()`                               |
| `ItemListener`        | none                 | `itemStateChanged()`                                         |
| `KeyListener`         | `KeyAdapter`         | `KeyPressed()`, `KeyReleased()`, `KeyTyped()`                |
| `MouseListener`       | `MouseAdapter`       | `mouseClicked()`, `mouseEntered()`, `mouseExited()`, `mousePressed()`, `mouseReleased()` |
| `MouseMotionListener` | `MouseMotionAdapter` | `mouseDragged()`, `mouseMoved()`                             |
| `TextListener`        | none                 | `textValueChange()`                                          |
| `WindowListener`      | `WindowAdapter`      | `windowActivated()`, `windowClose()`, `windwoClosing`, `windowDeactivated()`, `windowDeiconfied()`, `windowIconified()`, `windowOpend()` |



## 9.4 키 이벤트

- **키 이벤트(key event)**는 사용자가 키보드를 이용하여 입력하는 경우 발생한다.
  - `KeyEvent e`: 사용자가 입력한 키보드의 가상 키 번호

```java
public class MyListener implements KeyListener {    
    // 사용자가 키를 눌렀을 때 호출 
    public void keyPressed(KeyEvent e) {}
    // 사용자가 키에서 손을 떼었을 때 호출
    public void keyReleased(KeyEvent e) {}
    // 사용자가 글자(유니코드)를 입력했을 때 호출
    public void keyTyped(KeyEvent e) {}		
}
```



## 키보드 포커스

- `KeyEvent`가 발생하려면 컴포넌트가 키보드 포커스를 가지고 있어야 한다.
  - `requestFocus()`, `setFocusable(true)`를 호출하여 키보드 포커스를 획득한다.

```java
panel.requestFoucus();
panel.setFocusable(true);
```





### 간단한 난수 기계 만들기

```java
// 프레임 선택 후 엔터 누를 때마다 버튼에 난수가 생김
    import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleGame extends JFrame {
    int n1, n2, n3;
    JButton button1, button2, button3;
    
    public SimpleGame() {
        setTitle("Simple Game Machine");
        setSize(300, 150);
        
        JPanel panel = new JPanel();
        
        button1 = new JButton("" + n1);
        button2 = new JButton("" + n2);
        button3 = new JButton("" + n3);
        
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        
        panel.requestFocus();
        panel.setFocusable(true);
        
        panel.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                int keycode = e.getKeyCode();
                
                if (keycode == KeyEvent.VK_ENTER) {
                    n1 = (int)(Math.random()*10);
                    n2 = (int)(Math.random()*10);
                    n2 = (int)(Math.random()*10);
                    
                    button1.setText("" + n1);
                    button2.setText("" + n2);
                    button3.setText("" + n3);
                }
            }
            
            public void keyReleased(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
        
        add(panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        SimpleGame game = new SimpleGame();
    }
}
```



### 자동차 게임 만들기

```java
ImageIcon icon = new ImageIcon('이미지경로');
```

```java
import javax.swing.*;
import java.awt.event.*;

public class CarGame extends JFrame {
	int img_x = 150, img_y = 150;

	public CarGame() {
		setSize(600, 300);				
		
		JPanel panel = new JPanel();
		
		JButton button = new JButton("");		
		ImageIcon icon = new ImageIcon("car.png");
		button.setIcon(icon);
		button.setLocation(img_x, img_y);

		panel.add(button);
		panel.requestFocus();
		panel.setVisible(true);
		
		panel.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				
				switch (keyCode) {
				case KeyEvent.VK_UP: img_y -= 10; break;
				case KeyEvent.VK_DOWN: img_y += 10; break;
				case KeyEvent.VK_LEFT: img_x -= 10; break;
				case KeyEvent.VK_RIGHT: img_x += 10; break;
				}
				
				button.setLocation(img_x, img_y);
			}
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
		});
		
		add(panel);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		CarGame cg = new CarGame();	
	}
}

```





### 텍스트 필드 예제

```java
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


class KeyFrame extends JFrame implements KeyListener {
	public KeyFrame() {
		setSize(100, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Event Test");
		
		JTextField tf = new JTextField(30);
		tf.addKeyListener(this);
		
		add(tf);
		setVisible(true);
	}
	
    // 사용자가 키를 눌렀을 때 호출
    public void keyPressed(KeyEvent e) {
    	display(e, "keyTyped");
    }
    
    // 사용자가 키에서 손을 떼었을 때 호출
    public void keyReleased(KeyEvent e) {
    	display(e, "keyPressed");
    }	
    
    // 사용자가 글자(유니코드)를 입력했을 때 호출
    public void keyTyped(KeyEvent e) {
    	display(e, "keyReleased");
    }		
    
    protected void display(KeyEvent e, String s) {
    	char c = e.getKeyChar();
    	int keyCode = e.getKeyCode();
    	
    	String modifiers = 
            e.isAltDown() + " " + e.isControlDown() + " "+ e.isShiftDown();
    	
    	System.out.println(s + " " + c + " " + keyCode + " " + modifiers);
    }
}
public class KeyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeyFrame f = new KeyFrame();
	}

}

```



## 9.5 Mouse와 MouseMotion 이벤트

- **마우스 이벤트(Mouse Event)**: 사용자가 마우스 버튼을 누르거나 마우스를 움직일 때 발생한다.
  - 마우스의 클릭 처리하기: `MouseListener` 구현하기
  - 마우스의 드래그(이동) 처리하기: `MouseMotionListener` 구현하기



### 9.5.1 MouseListener 인터페이스

```java
public class MyListener implements MouseListener {
    // 마우스가 컴포넌트 위에서 눌리면 호출
	public void mousePressed(MouseEvent e) {}
    // 마우스가 컴포넌트 위에서 떼어지면 호출
	public void mouseReleased(MouseEvent e) {}
    // 마우스 커서가 컴포넌트로 들어가면 호출
	public void mouseEntered(MouseEvent e) {}
    // 마우스 커서가 컴포넌트에서 나가면 호출
	public void mouseExited(MouseEvent e) {}
    // 사용자가 컴포넌트를 클릭한 경우 호출
	public void mouseClicked(MouseEvent e) {}
}
```



### 9.5.2 MouseMotionListener 인터페이스

```java
public class MyListener implements MouseMotionListener {
    // 마우스 드래그하면 호출
    public void mouseDragged(MouseEvnet e) {}
    // 마우스가 클릭되지 않고 이동하는 경우 호출
    public void mouseMoved(MouseEvnet e) {}
}
```



## 9.6 어댑터 클래스

- **어댑터 클래스(adaptor class)**: 어댑터 클래스는 인터페이스를 구현해 놓은 크래스로, 어떤 리스터 인터페이스에서 하나의 추상 메서드만 구현하여 이용하고 싶으면 사용한다.

```java
// 마우스가 클릭된 위치로 이미지 이동하기
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MouseTest extends JFrame{
	int img_x = 150, img_y = 150;
	
	public MouseTest() {
		setSize(600, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        
		JButton button = new JButton("");
		ImageIcon icon = new ImageIcon("car.png");
		button.setIcon(icon);
        

		panel.add(button);
		panel.requestFocus();
		panel.setFocusable(true);
		
		panel.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				img_x = e.getX();
				img_y = e.getY();
				button.setLocation(img_x, img_y);
			}
		
		    public void mouseReleased(MouseEvent e) {}
		    public void mouseEntered(MouseEvent e) {}
		    public void mouseExited(MouseEvent e) {}
		    public void mouseClicked(MouseEvent e) {}
		});
		
		add(panel);
		setVisible(true);
	}
	public static void main(String[] args) {
		MouseTest f = new MouseTest();
	}

}
```

이때 

```java
		panel.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				img_x = e.getX();
				img_y = e.getY();
				button.setLocation(img_x, img_y);
			}
		
		    public void mouseReleased(MouseEvent e) {}
		    public void mouseEntered(MouseEvent e) {}
		    public void mouseExited(MouseEvent e) {}
		    public void mouseClicked(MouseEvent e) {}
		});
```

는 아래와 같이 어댑터 클래스를 이용하여 바꿀 수 있다.

```java
panel.addMouseListener(new MouseAdapter() {
	public void mousePressed(MouseEvent e) {
		img_x = e.getX();
		img_y = e.getY();
		button.setLocation(img_x, img_y);
	}
});
```

- `MouseAdpater`는 클래스이다. 이 클래스 안에는 `MouseListenter`의 추상 메서드들이 모두 구현되어있으므로, 모든 메서드를 빈 몸체로 정의할 필요없이 원하는 메서드만 재정의하면 된다.

```java
// 리스터 인터페이스를 직접 구현할 경우
class MyListener impelements KeyListener {
    public void keyTyped(KeyEvent e) {}
    // ...
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}
```

```java
// 어댑터 클래스를 사용하는 경우
class MyListener extends MouseAdapter {
    public void KeyTyped(KeyEvent e){
        if (e.getKeyChar() == 'x') {
            
        }
    }
    
}
```
