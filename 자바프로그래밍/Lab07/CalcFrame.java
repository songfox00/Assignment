import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalcFrame extends JFrame {
	JTextField t1,t2,t3;
	JButton b;
	public CalcFrame(){
		setTitle("계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,100);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		MyListener m1=new MyListener();
		t1=new JTextField(5);	//num1
		JLabel l=new JLabel("X");
		t2=new JTextField(5);	//num2
		b=new JButton("=");
		t3=new JTextField(10);	//result
		
		t1.addActionListener(m1);//텍스트필드 이벤트 리스너 등록
		t2.addActionListener(m1);
		t3.addActionListener(m1);
		b.addActionListener(m1);//버튼 이벤트 리스너 등록
		
		c.add(t1); 
		c.add(l); 
		c.add(t2); 
		c.add(b); 
		c.add(t3);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new CalcFrame();

	}
	
	private class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b=(JButton)e.getSource();
			if(b.getText().equals("=")) {	//"="버튼을 누르면
				int n1=Integer.parseInt(t1.getText());//숫자로 변환
				int n2=Integer.parseInt(t2.getText());
				String result=Integer.toString(n1*n2);//문자열로 변환
				t3.setText(result);//마지막 필드에 결과 넣기
			}
		}
	}
}
