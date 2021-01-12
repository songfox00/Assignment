import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickPracticeFrame extends JFrame{
	JLabel l;
	public ClickPracticeFrame() {
		setTitle("클릭 연습용 응용프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		Container c=getContentPane();
		c.setLayout(null);
		
		l=new JLabel("c");	//라벨 생성
		l.setLocation(100,100);//위치 (100,100)으로 지정
		l.setSize(10,10);//사이즈 지정
		l.addMouseListener(new MyMouse());//Mouse이벤트 리스너 등록
		
		c.add(l);
		setVisible(true);
		l.requestFocus();
	}
	
	public static void main(String[] args) {
		new ClickPracticeFrame();

	}
	
	private class MyMouse extends MouseAdapter{
		int x,y;
		public void mousePressed(MouseEvent e) {//마우 버튼이 눌러질 때
			x=(int)(Math.random()*300);//넘어가지 않게 하기 위해 300으로 설정
			y=(int)(Math.random()*300);
			l.setLocation(x,y);	//랜덤 위치 설정
		}
	}
}
