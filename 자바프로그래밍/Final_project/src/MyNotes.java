import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.event.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;

public class MyNotes extends JFrame{
	private JTextArea story=new JTextArea(6,60);
	private JTextArea review=new JTextArea(6,60);
	private JLabel info1, info2, info3, info4, info5, info6,info7;	//상세보기 정보
	JButton b1, b2, b3, b4, b5, fileOpen;
	private String[] title= {"제목", "별점"};
	private JTextField tf1=new JTextField(10);
	private JList<String> list1=new JList<String>();
	private JList<String> list2=new JList<String>();
	private JList<String> list3=new JList<String>();
	private JList<String> list4=new JList<String>();
	private MyDialog1 dialog1;
	private JRadioButton movie, book;
	private JTextField tf2, tf3,tf4, tf5, tf6, tf7, path1, path2;
	public JTextArea sto=new JTextArea(3,50);
	public JTextArea rev=new JTextArea(3,50);
	public JTextArea sto2=new JTextArea(3,50);
	public JTextArea rev2=new JTextArea(3,50);
	JComboBox<String> strCombo=new JComboBox<String>(title);
	JComboBox<String> gen, ag, yea, yea2;
	private String movie_genre[]= {"액션", "미스테리, 스릴러","코미디","드라마","애니메이션","범죄"};
	private String movie_age[]= {"전체", "12세 이상","18세 이상","청소년 관람 불가"};
	private String ye[]= {"2020","2019","2018","2017","2016","2015","2014"};
	private JSlider Js1, Js2;
	private int star=5, star2=5;
	moviePanel panel1=new moviePanel();
	bookPanel panel2=new bookPanel();
	JPanel MovieInfo, BookInfo;
	p5Panel p5=new p5Panel();
	ItemCollections collect=new ItemCollections();
	public Vector<String>vTitle=new Vector<String>();
	public Vector<String>vTitle1=new Vector<String>();
	public Vector<String>vTitle2=new Vector<String>();
	public Vector<String>vTitle3=new Vector<String>();
	private String ComboGenre, ComboAge, ComboYear;
	ImageIcon icon=new ImageIcon("noImage.jpg");
	ImgPanel Img=new ImgPanel();
	Image img;
	ImageIcon icon1;
	JTabbedPane pane;
	int flag=0;
	p1Panel p1=new p1Panel();//상세보기
	public MyNotes() {
		setTitle("JAVA 005 1914036 송혜민");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();

		Container c=getContentPane();
		
		JPanel p0=new JPanel();	//상단 정보
		JLabel note=new JLabel("My Notes");
		note.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 30));
		note.setForeground(Color.blue);
		JPanel my=new JPanel();
		my.add(note);
		JPanel time=new JPanel();	//시간
		time.add(new MyLabel());
		p0.setLayout(new BorderLayout());
		p0.add(my, BorderLayout.WEST);
		p0.add(time, BorderLayout.EAST);
		c.add(p0, BorderLayout.NORTH);
		
		JTabbedPane pane = createTabbedPane();	//탑팬
		JPanel pList=new JPanel();	//탑팬과 추가버튼 넣는 패널
		pList.setLayout(new BorderLayout());
		pList.add(pane,BorderLayout.CENTER);
		JPanel pB=new JPanel();
		b1=new JButton("추가");	//추가 버튼
		dialog1=new MyDialog1(this, "입력");	//다이얼로그 생성
		b1.addActionListener(new Action());
		pB.add(b1);
		pList.add(pB, BorderLayout.SOUTH);
		c.add(pList, BorderLayout.WEST);
		
		p5.setPreferredSize(new Dimension(300,300));	//상세보기 정보 위치 지정
		
		JPanel p2=new JPanel();	//줄거리
		Border rb2=BorderFactory.createTitledBorder("줄거리");
		p2.setBorder(rb2);
		JScrollPane story_scroll=new JScrollPane(story);	//스크롤 생성
		story.setLineWrap(true);	//자동 줄바꿈 설정
		p2.add(story_scroll);
		
		JPanel p3=new JPanel();	//감상평
		Border rb3=BorderFactory.createTitledBorder("감상평");
		p3.setBorder(rb3);
		JScrollPane review_scroll=new JScrollPane(review);	//스크롤 생성
		review.setLineWrap(true);	//자동 줄바꿈 설정
		p3.add(review_scroll);
		
		JPanel btn2= new JPanel();	//수정, 삭제 버튼 패널 
		b2= new JButton("수정");
		b3=new JButton("삭제");
		btn2.add(b2);
		btn2.add(b3);
		b2.addActionListener(new Action());
		b3.addActionListener(new Action());
		
		Img.setPreferredSize(new Dimension(200,300));	//이미지 위치 지정
		p1.add(Img);	//상세보기 패널 전체
		p1.add(p5);
		p1.add(p2);
		p1.add(p3);
		
		JPanel pRight=new JPanel();	//오른쪽 정보
		pRight.setLayout(new BorderLayout());
		pRight.add(p1, BorderLayout.CENTER);
		pRight.add(btn2, BorderLayout.SOUTH);
		
		c.add(pRight, BorderLayout.CENTER);
		
		setSize(900,800);
		setVisible(true);
	}
	private void createMenu() {	//상단 메뉴
		JMenuBar mb=new JMenuBar();
		JMenu file=new JMenu("파일");
		JMenuItem open=new JMenuItem("불러오기");
		JMenuItem save=new JMenuItem("저장하기");
		JMenuItem exit=new JMenuItem("종료");
		file.add(open);
		file.add(save);
		file.add(exit);
		open.addActionListener(new MenuAction());
		save.addActionListener(new MenuAction());
		exit.addActionListener(new MenuAction());
		
		JMenu help=new JMenu("도움말");
		JMenuItem info=new JMenuItem("시스템 정보");
		info.addActionListener(new MenuAction());
		help.add(info);
		
		mb.add(file);
		mb.add(help);
		setJMenuBar(mb);
	}
	class p1Panel extends JPanel{
		public p1Panel() {
			Border rb1=BorderFactory.createTitledBorder("상세 보기");
			setBorder(rb1);
		}
	}
	class p5Panel extends JPanel{
		public p5Panel() {
			setLayout(new GridLayout(7,0));
			info1=new JLabel("");	//제목
			info2=new JLabel("");	//감독
			info3=new JLabel("");	//배우
			info4=new JLabel("");	//장르
			info5=new JLabel("");	//등급
			info6=new JLabel("");	//개봉년도
			info7=new JLabel("");	//별점
			
			add(info1);add(info2);add(info3);
			add(info4);add(info5);add(info6);add(info7);
		}
	}
	class ImgPanel extends JPanel{	//이미지 패널
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			img=icon.getImage();
			g.drawImage(img, 0, 0 ,getWidth(),getHeight(), this);
		}
	}
	
	private JTabbedPane createTabbedPane(){	//탑팬
		pane=new JTabbedPane(JTabbedPane.TOP);
		pane.addTab("전체", new JScrollPane(list1));
		pane.addTab("영화", new JScrollPane(list2));
		pane.addTab("도서", new JScrollPane(list3));
		list1.addListSelectionListener(new ListSelectionListener(){	//전체 탭
			public void valueChanged(ListSelectionEvent e) {
				try {
				int index=list1.getSelectedIndex();
				if(collect.vItem.get(index) instanceof Movie) {	//영화이면
					Movie m=(Movie) collect.vItem.get(index);
					info1.setText("제목     "+m.getTitle());	//저장해 놓은 객체 읽어와서 상세보기 정보에 출력하기
					info2.setText("감독     "+m.getDir());
					info3.setText("배우     "+m.getAct());
					info4.setText("장르     "+m.getGenre());
					info5.setText("등급     "+m.getAge());
					info6.setText("개봉년도     "+m.getYear());
					info7.setText("별점     "+m.getStar());
					story.setText(m.getStory());
					review.setText(m.getReview());
					icon=new ImageIcon(m.getPath());
				}
				else if(collect.vItem.get(index) instanceof Book){	//도서이면
					Book b=(Book) collect.vItem.get(index);
					info1.setText("제목     "+b.getTitle());//저장해 놓은 객체 읽어와서 상세보기 정보에 출력하기
					info2.setText("저자     "+b.getDir());
					info3.setText("출판사     "+b.getPub());
					info4.setText("개봉년도     "+b.getYear());
					info5.setText("별점     "+b.getStar());
					info6.setText("");
					info7.setText("");
					story.setText(b.getStory());
					review.setText(b.getReview());
					icon=new ImageIcon(b.getPath());
				}
				Img.repaint();
				}catch(Exception e1) {
					System.out.println("배열 인덱스 범위 초과");
				}
			}
		});
		list2.addListSelectionListener(new ListSelectionListener(){//영화 탭
			public void valueChanged(ListSelectionEvent e) {
				try {
				String name=(String)list2.getSelectedValue();	//선택된 제목
				int index=vTitle.indexOf(name);	//같은 제목이 저장되어 있는 객체의 인덱스 찾기
				if(collect.vItem.get(index) instanceof Book) {
					index=vTitle.indexOf(name, index+1);
				}
				else {
				Movie m=(Movie) collect.vItem.get(index);//저장해 놓은 객체 읽어와서 상세보기 정보에 출력하기
				info1.setText("제목     "+m.getTitle());
				info2.setText("감독     "+m.getDir());
				info3.setText("배우     "+m.getAct());
				info4.setText("장르     "+m.getGenre());
				info5.setText("등급     "+m.getAge());
				info6.setText("개봉년도     "+m.getYear());
				info7.setText("별점     "+m.getStar());
				story.setText(m.getStory());
				review.setText(m.getReview());
				icon=new ImageIcon(m.getPath());
				Img.repaint();
				}
				}catch(Exception e1) {
					System.out.println("배열 인덱스 범위 초과");
				}
			}
		});
		list3.addListSelectionListener(new ListSelectionListener(){//도서 탭
			public void valueChanged(ListSelectionEvent e) {
				try {
				String name=(String)list3.getSelectedValue();//선택된 제목
				int index=vTitle.indexOf(name);//같은 제목이 저장되어 있는 객체의 인덱스 찾기
				if(collect.vItem.get(index) instanceof Movie) {
					index=vTitle.indexOf(name, index+1);
				}
				else {
				Book b=(Book)collect.vItem.get(index);//저장해 놓은 객체 읽어와서 상세보기 정보에 출력하기
				info1.setText("제목     "+b.getTitle());
				info2.setText("저자     "+b.getDir());	
				info3.setText("출판사     "+b.getPub());
				info4.setText("개봉년도     "+b.getYear());
				info5.setText("별점     "+b.getStar());
				info6.setText("");
				info7.setText("");
				story.setText(b.getStory());
				icon=new ImageIcon(b.getPath());
				Img.repaint();
				}
				}catch(Exception e1) {
					System.out.println("배열 인덱스 범위 초과");
				}
			}
		});
		JPanel search=new JPanel();
		search.setLayout(new BorderLayout());
		JPanel pSe=new JPanel();	//검색 패널
		pSe.add(strCombo);	//별점,제목 콤보 박스
		pSe.add(tf1); //입력 받는 칸
		b4=new JButton("검색");
		b4.addActionListener(new Action());
		pSe.add(b4);
		search.add(pSe, BorderLayout.NORTH);
		search.add(new JScrollPane(list4), BorderLayout.CENTER);
		pane.addTab("검색", search);//검색 버튼
		
		list4.addListSelectionListener(new ListSelectionListener(){//검색 탭
			public void valueChanged(ListSelectionEvent e) {
				try {
					int index1, index2;
				String name=(String)list4.getSelectedValue();//선택된 제목
				int index=vTitle.indexOf(name);//같은 제목이 저장되어 있는 객체의 인덱스 찾기
				if(collect.vItem.get(index) instanceof Movie) {
					Movie m=(Movie) collect.vItem.get(index);//저장해 놓은 객체 읽어와서 상세보기 정보에 출력하기
					info1.setText("제목     "+m.getTitle());
					info2.setText("감독     "+m.getDir());
					info3.setText("배우     "+m.getAct());
					info4.setText("장르     "+m.getGenre());
					info5.setText("등급     "+m.getAge());
					info6.setText("개봉년도     "+m.getYear());
					info7.setText("별점     "+m.getStar());
					story.setText(m.getStory());
					review.setText(m.getReview());
					icon=new ImageIcon(m.getPath());
				}
				else if(collect.vItem.get(index) instanceof Book){
					Book b=(Book) collect.vItem.get(index);//저장해 놓은 객체 읽어와서 상세보기 정보에 출력하기
					info1.setText("제목     "+b.getTitle());
					info2.setText("저자     "+b.getDir());
					info3.setText("출판사     "+b.getPub());
					info4.setText("개봉년도     "+b.getYear());
					info5.setText("별점     "+b.getStar());
					info6.setText("");
					info7.setText("");
					story.setText(b.getStory());
					review.setText(b.getReview());
					icon=new ImageIcon(b.getPath());
				}
				Img.repaint();
				}catch(Exception e1) {
					System.out.println("배열 인덱스 범위 초과");
				}
			}
		});
		return pane;
	}
	
	class moviePanel extends JPanel {	//영화 다이얼로그 패널
		private String str[]= {"제목","감독","배우","장르","등급","개봉년도","포스터","별점"};
		public moviePanel() {
			setLayout(new BorderLayout());
			MovieInfo=new JPanel(new BorderLayout());
			Border MovieRB=BorderFactory.createTitledBorder("영화 정보");
			MovieInfo.setBorder(MovieRB);
			
			JPanel Mlabel=new JPanel(new GridLayout(8,0,2,35));
			JPanel Mlabel2=new JPanel(new GridLayout(8,0,2,7));
			JPanel Mtext=new JPanel(new GridLayout(2,0,10,50));
			JPanel Mtext2=new JPanel(new GridLayout(2,0,10,3));
			
			for(int i=0;i<8;i++) {
				Mlabel.add(new JLabel(str[i]));	//줄거리, 감상평 빼고 나머지 정보 Jlabel 만들기
			}
			tf2=new JTextField(12);	//입력받을 칸
			tf3=new JTextField(12);
			tf4=new JTextField(12);
			gen=new JComboBox<String>(movie_genre);//장르
			ag=new JComboBox<String>(movie_age);//등급
			yea=new JComboBox<String>(ye);//연도
			
			
			JPanel poster=new JPanel();	//이미지
			path1=new JTextField(12);	//파일 경로
			path1.setEnabled(false);
			fileOpen=new JButton("불러오기");	//불러오기 버튼
			fileOpen.addActionListener(new Action());
			poster.add(path1);
			poster.add(fileOpen);
			
			Js1=new JSlider(JSlider.HORIZONTAL, 1, 10,5);//별점
			Js1.setPaintLabels(true);
			Js1.setPaintTicks(true);
			Js1.setPaintTrack(true);
			Js1.setMajorTickSpacing(1);
			sto=new JTextArea(4,25);	//줄거리
			rev=new JTextArea(4,25);	//감상평
			JScrollPane sto_scroll=new JScrollPane(sto);//스크롤
			JScrollPane rev_scroll=new JScrollPane(rev);//스크롤
			
			
			Js1.addChangeListener(new MyChange());//별점이 변경 값을 받아옴
			
			Mlabel2.add(tf2);
			Mlabel2.add(tf3);
			Mlabel2.add(tf4);
			Mlabel2.add(gen);
			Mlabel2.add(ag);
			Mlabel2.add(yea);
			Mlabel2.add(poster);
			Mlabel2.add(Js1);
			
			Mtext.add(new JLabel("줄거리"));
			Mtext.add(new JLabel("감상평"));
			
			Mtext2.add(sto_scroll);
			Mtext2.add(rev_scroll);
			sto.setLineWrap(true);	//자동 줄바꿈
			rev.setLineWrap(true);
			
			JPanel MTop=new JPanel();
			MTop.add(Mlabel);
			MTop.add(Mlabel2);
			
			JPanel MBottom =new JPanel();
			MBottom.add(Mtext);
			MBottom.add(Mtext2);
			
			MovieInfo.add(MTop, BorderLayout.CENTER);
			MovieInfo.add(MBottom, BorderLayout.SOUTH);
			add(MovieInfo);	//영화 다이얼로그 패널에 다 집어 넣기
			
			JPanel btn5=new JPanel();
			b5=new JButton("OK");
			btn5.add(b5);
			b5.addActionListener(new Action());
			add(btn5, BorderLayout.SOUTH);
			setSize(400, 650);
		}
	}
	
	class bookPanel extends JPanel{//도서 다이얼로그 패널
		private String str[]= {"제목","저자","출판사","출판년도","책이미지","별점"};
		public bookPanel() {
			BookInfo=new JPanel(new BorderLayout());
			Border BookRB=BorderFactory.createTitledBorder("도서 정보");
			BookInfo.setBorder(BookRB);
			
			JPanel Mlabel=new JPanel(new GridLayout(6,0,2,35));
			JPanel Mlabel2=new JPanel(new GridLayout(6,0,2,7));
			JPanel Mtext=new JPanel(new GridLayout(2,0,10,50));
			JPanel Mtext2=new JPanel(new GridLayout(2,0,10,3));
			
			for(int i=0;i<6;i++) {	
				Mlabel.add(new JLabel(str[i]));//책소개, 감상평 빼고 나머지 정보 JLable 만들기
			}
			tf5=new JTextField(12);//입력받는 칸
			tf6=new JTextField(12);
			tf7=new JTextField(12);
			yea2=new JComboBox<String>(ye);//연도
			JPanel poster=new JPanel();//이미지 패널
			path2=new JTextField(12); //경로
			path2.setEnabled(false);
			fileOpen=new JButton("불러오기");
			fileOpen.addActionListener(new Action());
			poster.add(path2);
			poster.add(fileOpen);
			
			Js2=new JSlider(JSlider.HORIZONTAL, 1, 10,5);//별점
			Js2.setMaximum(10);
			Js2.setMinimum(1);
			Js2.setPaintLabels(true);
			Js2.setPaintTicks(true);
			Js2.setPaintTrack(true);
			Js2.setMajorTickSpacing(1);
			Js2.addChangeListener(new MyChange());
			sto2=new JTextArea(4,25);//줄거리
			rev2=new JTextArea(4,25);//감상평
			JScrollPane sto2_scroll=new JScrollPane(sto2);
			JScrollPane rev2_scroll=new JScrollPane(rev2);
			sto2.setLineWrap(true);//자동 줄바꿈
			rev2.setLineWrap(true);
			
			Mlabel2.add(tf5);
			Mlabel2.add(tf6);
			Mlabel2.add(tf7);
			Mlabel2.add(yea2);
			Mlabel2.add(poster);
			Mlabel2.add(Js2);
			
			Mtext.add(new JLabel("책소개"));
			Mtext.add(new JLabel("감상평"));
			
			Mtext2.add(sto2_scroll);
			Mtext2.add(rev2_scroll);
			
			JPanel MTop=new JPanel();
			MTop.add(Mlabel);
			MTop.add(Mlabel2);
			
			JPanel MBottom =new JPanel();
			MBottom.add(Mtext);
			MBottom.add(Mtext2);
			
			BookInfo.add(MTop, BorderLayout.CENTER);
			BookInfo.add(MBottom, BorderLayout.SOUTH);
			add(BookInfo);
			
			JPanel btn5=new JPanel();
			b5=new JButton("OK");
			btn5.add(b5);
			b5.addActionListener(new Action());
			add(btn5, BorderLayout.SOUTH);
			setSize(400, 650);
		}
	}
	class MyDialog1 extends JDialog{//다이얼로그
		public MyDialog1(JFrame frame, String title) {
			super(frame, title);
			setLayout(new BorderLayout());
			ButtonGroup group=new ButtonGroup();
			movie=new JRadioButton("Movie");//라디오 버튼
			book=new JRadioButton("Book");
			group.add(movie);//그룹으로 묶기
			group.add(book);
			JPanel radio=new JPanel();
			radio.add(movie);
			radio.add(book);

			movie.addItemListener(new MyItem());//이벤트 등록
			book.addItemListener(new MyItem());
			movie.setSelected(true);//처음엔 movie 라디오 버튼이 눌려있도록 함
			panel2.setVisible(false);
			
			add(radio, BorderLayout.NORTH);
			
			panel2.setBounds(20, 50, 350, 650);//패널 위치
			add(panel2, BorderLayout.CENTER);
			add(panel1, BorderLayout.CENTER);
			
			setSize(400, 720);
			}
	}
	
	class MenuAction implements ActionListener{
		private JFileChooser chooser;
		public MenuAction() {
			chooser=new JFileChooser();
		}
		public void actionPerformed(ActionEvent e) {
			JMenuItem b=(JMenuItem)e.getSource();
			if(b.getText()=="불러오기") {	//메뉴 파일에서 불러오기 누르면
				try {
					int ret=chooser.showOpenDialog(null);//파일 다이얼로그
					String filePath=chooser.getSelectedFile().getPath();
					collect.vItem.clear();//원래 있던 리스트 모두 삭제
					vTitle.clear();
					vTitle1.clear();
					vTitle2.clear();
					ObjectInputStream ois=new ObjectInputStream(new FileInputStream(filePath));	//파일 열기
					collect.vItem =(Vector)ois.readObject();//ItemCollection 객체에 불러온 정보 저장
					for(int i=0;i<collect.vItem.size();i++) {
						Item item=(Item)collect.vItem.get(i);
						vTitle.add(item.getTitle());	//불러온 정보만큼 리스트도 다시 채워줌
						if(item instanceof Movie) {//movie 객체일 때
							vTitle1.add(item.getTitle());
						}
						else//book 객체일 때
							vTitle2.add(item.getTitle());
					}
					ois.close();
					list1.setListData(vTitle);	//탭 list 업데이트
					list2.setListData(vTitle1);
					list3.setListData(vTitle2);
				}catch(ClassNotFoundException e2) {
					System.out.println("파일을 찾을 수 없습니다.");
				}catch(IOException e2) {
					System.out.println("입출력 오류");
				}
			}
			else if(b.getText()=="저장하기") {	//저장 다이얼로그
				try {
					int ret=chooser.showSaveDialog(null);//파일 다이얼로그
					String filePath=chooser.getSelectedFile().getPath();
					ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filePath));	//파일 열기
					oos.writeObject(collect.vItem);	//지금까지 입력받은 ItemCollections 저장
					oos.close();
				}
				catch(IOException e1) {
					System.out.println("입출력 오류");
				}
			}
			else if(b.getText()=="종료") {
				System.exit(0);
			}
			else if(b.getText()=="시스템 정보") {
				JOptionPane.showMessageDialog(null, "MyNotes 시스템 v1.0 입니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	}
	
	class Action implements ActionListener{	//액션 리스너
		private JFileChooser chooser;
		public Action() {
			chooser=new JFileChooser();
		}
		public void actionPerformed(ActionEvent e) {
			JButton b= (JButton)e.getSource();
			if(b.getText()=="추가") {		//버튼
				dialog1.setVisible(true); //다이얼로그 열기
			}
			else if(b.getText()=="OK") {	//정보 입력후 OK 버튼
				if(panel1.isVisible()) { //panel1은 movie 패널
					Movie movie=new Movie(tf2.getText(), tf3.getText(), tf4.getText(), gen.getSelectedItem().toString(), ag.getSelectedItem().toString(), yea.getSelectedItem().toString(), path1.getText(), star, sto.getText(), rev.getText());
					if(flag==1) {	//수정으로 창을 열었을 때
						int index=vTitle.indexOf(tf2.getText());
							if(collect.vItem.get(index) instanceof Book) {
								index=vTitle.indexOf(tf2.getText(), index+1);
							}
						collect.ItemEditM(index,movie);//정보 수정
						info1.setText("제목     "+movie.getTitle());		//ok 버튼 누르면 바뀐 정보가 업데이트 되서 보여짐
						info2.setText("감독     "+movie.getDir());
						info3.setText("배우     "+movie.getAct());
						info4.setText("장르     "+movie.getGenre());
						info5.setText("등급     "+movie.getAge());
						info6.setText("개봉년도     "+movie.getYear());
						info7.setText("별점     "+movie.getStar());
						story.setText(movie.getStory());
						review.setText(movie.getReview());
						icon=new ImageIcon(movie.getPath());
						flag=0;//0으로 초기화
					}
					else if(flag==0) {	//수정이 아닌 추가 버튼으로 다이얼로그 열었을 때
						collect.ItemSave(movie);
						vTitle.add(tf2.getText());	//탑팬 리스트에 추가
						vTitle1.add(tf2.getText());
					}
					list1.setListData(vTitle);
					list2.setListData(vTitle1);
					tf2.setText("");	//다이얼로그 창 초기화
					tf3.setText("");
					tf4.setText("");
					sto.setText("");
					rev.setText("");
					path1.setText("");
					dialog1.setVisible(false);	//다이얼로그 창 없애기
				}
				else if(panel2.isVisible()) {	//panel2는 book 패널
					Book book=new Book(tf5.getText(), tf6.getText(), tf7.getText(), yea2.getSelectedItem().toString(), path2.getText(), star2, sto2.getText(), rev2.getText());
					if(flag==1) {	//수정 버튼으로 다이얼로그 열었을 때
						int index=vTitle.indexOf(tf5.getText());
							if(collect.vItem.get(index) instanceof Movie) {
								index=vTitle.indexOf(tf5.getText(),index+1);
							}
						collect.ItemEditB(index,book);	//정보 수정
						info1.setText("제목     "+book.getTitle());//수정된 정보 다시 상세보기에 출력
						info2.setText("저자     "+book.getDir());
						info3.setText("출판사     "+book.getPub());
						info4.setText("개봉년도     "+book.getYear());
						info5.setText("별점     "+book.getStar());
						info6.setText("");
						info7.setText("");
						story.setText(book.getStory());
						review.setText(book.getReview());
						icon=new ImageIcon(book.getPath());
						flag=0;	//0으로 초기화
					}
					else if(flag==0) {	//추가 버튼으로 다이얼로그 열었을 때
						collect.ItemSave(book);	//객체 저장
						vTitle.add(tf5.getText()); //탑팬 리스트에 추가
						vTitle2.add(tf5.getText());
					}
					list1.setListData(vTitle);
					list3.setListData(vTitle2);
					tf5.setText("");//다이얼로그 창 초기화
					tf6.setText("");
					tf7.setText("");
					sto2.setText("");
					rev2.setText("");
					path2.setText("");
					dialog1.setVisible(false);//다이얼로그 창 없애기
				}
				Img.repaint();	
			}
			else if(b.getText()=="불러오기") {	//이미지 불러오는 버튼
				try {
				int ret=chooser.showOpenDialog(null);//파일 다이얼로그
				String filePath=chooser.getSelectedFile().getPath();
				if(panel1.isVisible()) {//movie 패널일 때
					path1.setText(filePath);
				}
				else	//book 패널일 때
					path2.setText(filePath);
				}catch(Exception e1) {
					System.out.println("");
				}
			}
			else if(b.getText()=="검색") {	//검색 버튼
				vTitle3.clear();
				if(strCombo.getSelectedItem().toString()=="제목") {	//콤보 값이 '제목'일 때
					String name=tf1.getText();	//옆 텍스트필드 값 읽어오기
					collect.TitleFind(name, vTitle3);	//같은 이름의 제목이 있다면 벡터에 저장
					list4.setListData(vTitle3);	//검색 탑팬의 list에 추가
					if(vTitle3.size()==0) {//같은 이름의 객체가 없다면
						JOptionPane.showMessageDialog(null, "["+name+"] 검색 결과가 없습니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else if(strCombo.getSelectedItem().toString()=="별점"){//콤보 값이 '별점'일 때
					try {
					int star_search=Integer.parseInt(tf1.getText());//입력한 숫자 읽어오기
					collect.StarFind(star_search, vTitle3);	//입력된 별점보다 크거나 같은 객체의 제목을 벡터에 저장
					list4.setListData(vTitle3);//검색 탑팬의 list에 추가
					}catch(Exception e1) {
						System.out.println("숫자가 아닙니다.");
					}
				}
			}
			else if(b.getText()=="수정") {
				String name=null;
				flag=1;	//수정으로 다이얼로그를 열었다는 변수
				if(pane.getSelectedIndex()==0) {	//전체 탑팬
					int index=list1.getSelectedIndex();	//선택된 index
					name=list1.getSelectedValue();	//선택된 값
					if(collect.vItem.get(index) instanceof Movie) {	//영화라면
						movie.setSelected(true);	//movie 라디오 버튼 선택
						Movie m=(Movie)collect.vItem.get(index);
						tf2.setText(m.getTitle());
						tf3.setText(m.getDir());
						tf4.setText(m.getAct());
						gen.setSelectedItem(m.getGenre());
						ag.setSelectedItem(m.getAge());
						yea.setSelectedItem(m.getYear());
						path1.setText(m.getPath());
						Js1.setValue(m.getStar());
						sto.setText(m.getStory());
						rev.setText(m.getReview());
					}
					else if(collect.vItem.get(index) instanceof Book){	//도서라면
						book.setSelected(true); //book 라디오 버튼 선택
						Book m=(Book)collect.vItem.get(index);
						tf5.setText(m.getTitle());
						tf6.setText(m.getDir());
						tf7.setText(m.getPub());
						yea2.setSelectedItem(m.getYear());
						path2.setText(m.getPath());
						Js2.setValue(m.getStar());
						sto2.setText(m.getStory());
						rev2.setText(m.getReview());
					}
				}
				else if(pane.getSelectedIndex()==1) {	//영화 탑팬
					name=list2.getSelectedValue();
					int index=vTitle.indexOf(name);
					movie.setSelected(true);//movie 라디오 버튼 선택
					Movie m=(Movie)collect.vItem.get(index);
					tf2.setText(m.getTitle());
					tf3.setText(m.getDir());
					tf4.setText(m.getAct());
					gen.setSelectedItem(m.getGenre());
					ag.setSelectedItem(m.getAge());
					yea.setSelectedItem(m.getYear());
					path1.setText(m.getPath());
					Js1.setValue(m.getStar());
					sto.setText(m.getStory());
					rev.setText(m.getReview());
				}
				else if(pane.getSelectedIndex()==2) {	//도서 탑팬
					name=list3.getSelectedValue();
					int index=vTitle.indexOf(name);
					book.setSelected(true);//book 라디오 버튼 선택
					Book m=(Book)collect.vItem.get(index);
					tf5.setText(m.getTitle());
					tf6.setText(m.getDir());
					tf7.setText(m.getPub());
					yea2.setSelectedItem(m.getYear());
					path2.setText(m.getPath());
					Js2.setValue(m.getStar());
					sto2.setText(m.getStory());
					rev2.setText(m.getReview());
				}
				else if(pane.getSelectedIndex()==3) {	//검색 탑팬
					name=list4.getSelectedValue();
					int index=vTitle.indexOf(name);
					if(collect.vItem.get(index) instanceof Movie) {
						movie.setSelected(true);//movie 라디오 버튼 선택
						Movie m=(Movie)collect.vItem.get(index);
						tf2.setText(m.getTitle());
						tf3.setText(m.getDir());
						tf4.setText(m.getAct());
						gen.setSelectedItem(m.getGenre());
						ag.setSelectedItem(m.getAge());
						yea.setSelectedItem(m.getYear());
						path1.setText(m.getPath());
						Js1.setValue(m.getStar());
						sto.setText(m.getStory());
						rev.setText(m.getReview());
					}
					else if(collect.vItem.get(index) instanceof Book) {
						book.setSelected(true);//book 라디오 버튼 선택
						Book m=(Book)collect.vItem.get(index);
						tf5.setText(m.getTitle());
						tf6.setText(m.getDir());
						tf7.setText(m.getPub());
						yea2.setSelectedItem(m.getYear());
						path2.setText(m.getPath());
						Js2.setValue(m.getStar());
						sto2.setText(m.getStory());
						rev2.setText(m.getReview());
					}
				}
				dialog1.setVisible(true);	//다이얼로그 열기
			}
			else if(b.getText()=="삭제") {
				String name=null;
				int index=-1;
				int result=JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);//확인 다이얼로그
				if(result==JOptionPane.CLOSED_OPTION) {
				}
				else if(result==JOptionPane.YES_OPTION) {	//yes버튼 누르면
					if(pane.getSelectedIndex()==0) {	//전체 탭에서 선택했을 때
						name=list1.getSelectedValue();
						index=vTitle.indexOf(name);
						if(collect.vItem.get(index) instanceof Movie) {//영화이면
							collect.ItemDel(index);
							vTitle.remove(index);
							vTitle1.remove(name);
							list2.setListData(vTitle1);
						}
						else if(collect.vItem.get(index) instanceof Book) {//도서이면
							collect.ItemDel(index);
							vTitle.remove(index);
							vTitle2.remove(name);
							list3.setListData(vTitle2);
						}
					}
					else if(pane.getSelectedIndex()==1) {//영화 탭에서 선택했을 때
						name=list2.getSelectedValue();
						index=vTitle.indexOf(name);
						collect.ItemDel(index);
						vTitle.remove(index);
						vTitle1.remove(name);
						list2.setListData(vTitle1);
					}
					else if(pane.getSelectedIndex()==2) {//도서 탭에서 선택했을 때
						name=list3.getSelectedValue();
						index=vTitle.indexOf(name);
						collect.ItemDel(index);
						vTitle.remove(index);
						vTitle2.remove(name);
						list3.setListData(vTitle2);
					}	
					else if(pane.getSelectedIndex()==3) {//검색 탭에서 선택했을 때
						name=list4.getSelectedValue();
						int index2=list4.getSelectedIndex();
						index=vTitle.indexOf(name);
						if(collect.vItem.get(index) instanceof Movie) {//영화이면
							collect.ItemDel(index);
							vTitle.remove(index);
							vTitle1.remove(name);
							list2.setListData(vTitle1);
						}
						else if(collect.vItem.get(index) instanceof Book) {//도서이면
							collect.ItemDel(index);
							vTitle.remove(index);
							vTitle2.remove(name);
							list3.setListData(vTitle2);
						}
						vTitle3.remove(index2);
						list4.setListData(vTitle3);
					}	
					list1.setListData(vTitle);//리스트 업데이트
					info1.setText("");//상세보기 정보 다 지우기
					info2.setText("");
					info3.setText("");
					info4.setText("");
					info5.setText("");
					info6.setText("");
					info7.setText("");
					story.setText("");
					review.setText("");
					icon=new ImageIcon("noImage.jpg");
					Img.repaint();
				}
			}
		}
	}
	
	class MyChange implements ChangeListener{	//별점 JSlider 이벤트
		public void stateChanged(ChangeEvent e) {
			star=Js1.getValue();
			star2=Js2.getValue();
		}
	}
	
	class MyItem implements ItemListener{	//라디오 버튼 이벤트
		public void itemStateChanged(ItemEvent e) {
			if(movie.isSelected()) {
				panel2.setVisible(false);
				panel1.setVisible(true);
			}
			else if(book.isSelected()) {
				panel1.setVisible(false);
				panel2.setVisible(true); 
			}
		}
	}
	
	public static void main(String[] args) {
		new MyNotes();
	}
}
