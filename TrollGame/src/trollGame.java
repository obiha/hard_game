//import java.awt.Color;
//import java.awt.event.MouseEvent;
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.awt.*;
//import acm.program.*;
//import acm.graphics.*;
//import acm.io.*;
//
//public class trollGame extends GraphicsProgram{
//
//	double X, Y = 0;
//
//	GImage title = new GImage("title.png");
//	GImage startButton = new GImage ("start_button.png");
//	GImage wallpaper = new GImage ("wallpaper.png");
//	GImage menuButton1 = new GImage ("menubutton.png");
//	GImage whiteBackground = new GImage("whiteBackground.png");
//	GImage question1 = new GImage("question1.png");
//	GImage answer1 = new GImage("thugGlasses.png");
//	GImage answerBar1 = new GImage("answerBar.png");
//	GImage answerBar2 = new GImage("answerBar.png");
//	GImage answerBar3 = new GImage("answerBar.png");
//	GImage answerBar4 = new GImage("answerBar.png");
//	GImage cursor = new GImage("pencil.png");
//
//	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//
//	int scwidth =(int) screenSize.getWidth();
//	int scheight = (int) screenSize.getHeight();
//
//	GLabel nameDisp;
//	GLabel questionDisp = new GLabel("");
//
//	ArrayList<String> questions = new ArrayList<String>();
//
//	int questionCount;
//
//	boolean selectingQuestion;
//
//
//	public void init (){
//		//Canvas settings
//		setTitle("Implossible Game");
//		setSize((int)scwidth , (int) scheight);
//
//
//		//wall paper settings
//
//		wallpaper.setLocation(0,0);
//		wallpaper.setSize((int)scwidth,(int)scheight);
//		
//
//		//question1 settings
//
//		question1.setSize((int)scwidth,(int)scheight);
//		question1.setLocation(getWidth()/2 - question1.getWidth()/2 , getHeight()/2 - question1.getHeight()/2);
//
//		// answer1 settings
//
//		answer1.setSize(450,210);
//		answer1.setLocation(getWidth()/2 + answer1.getWidth()/2,450);
//
//		//title settings
//
//		title.setSize((int)scwidth,(int)scheight);
//		title.setLocation(getWidth()/2 - title.getWidth()/2,getHeight()/2 - title.getHeight()/2);
//		add(title);
//
//		//startButton settings
//
//		startButton.setSize(120,50);
//		startButton.setLocation((int)scwidth/2 , (int)scheight/2);
//		add(startButton);
//
//		//menuButton settings
//
//		menuButton1.setSize(3000 ,50);
//		menuButton1.setLocation(getWidth()/menuButton1.getWidth(), getHeight()/menuButton1.getHeight());
//
//		//questionDisplay settings
//
//		questionDisp.setFont("Calibri-35-BOLD");
//		questionDisp.setLocation(getWidth()/2 - question1.getWidth()/2 ,70 );
//		questionDisp.setColor(Color.CYAN);
//
//		//answerBar settings
//		
//		answerBar1.setLocation(0+answerBar1.getWidth()/4,90+scheight/3);
//		answerBar1.setSize(400, 200);
//				
//		answerBar2.setLocation(0+answerBar2.getWidth()/4,90+scheight/9);
//		answerBar2.setSize(400, 200);
//
//		answerBar3.setLocation(0+getWidth()-answerBar3.getWidth()/2,90+scheight/3);
//		answerBar3.setSize(400, 200);
//				
//		answerBar4.setLocation(0+getWidth()-answerBar4.getWidth()/2,90+scheight/9);
//		answerBar4.setSize(400, 200);
//
//		addMouseListeners();
//
//		BufferedReader rd = null;
//		try {
//			rd = new BufferedReader(new FileReader("question.txt"));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		String line;
//		try {
//			while((line = rd.readLine()) != null){
//				questions.add(line);
//
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch(NullPointerException e){
//			e.printStackTrace();
//		}
//
//	}
//
//	public void mouseClicked(MouseEvent m){
//		if (m.getX() >= startButton.getX() && m.getX() <= startButton.getX() + startButton.getWidth() && m.getY() >= startButton.getY() && m.getY() <= startButton.getY() + startButton.getHeight()){
//			startButton.setLocation(scwidth/ startButton.getWidth(),scheight/ startButton.getHeight());
//			remove(startButton);
//			
//
//			String name = (new IODialog()).readLine("Type in your name ");
//			nameDisp = new GLabel("Welcome " + name + "!" );
//			nameDisp.setLocation(50, scheight - 100);
//			nameDisp.setColor(Color.WHITE);
//			nameDisp.setFont("Arial-50-BOLD");
//			add(nameDisp);
//			add(menuButton1);
//
//		}
//
//		if (m.getX() >= menuButton1.getX() && m.getX() <= menuButton1.getX() + menuButton1.getWidth() && m.getY() >= menuButton1.getY() && m.getY()<= menuButton1.getY() + menuButton1.getHeight()){
//			remove(title);
//			remove(menuButton1);
//			remove(nameDisp);
//			remove(wallpaper);
//			add(question1);
//			add(answer1);
//		}
//
//		if (m.getX() >= answer1.getX() && m.getX() <= answer1.getX() + answer1.getWidth() && m.getY() >= answer1.getY() && m.getY()<= answer1.getY() + answer1.getHeight()){
//			remove(answer1);
//			remove(question1);
//			add(whiteBackground);
//			add(answerBar1);
//			add(answerBar2);
//			add(answerBar3);
//			add(answerBar4);
//			add(questionDisp);
//			selectingQuestion = true;
//
//		}
//
//
//		if(selectingQuestion){
//			questionDisp.setLabel(questions.get(questionCount));
//			if(questionCount < questions.size() - 1) questionCount++;
//
//		}
//
//	}
//
//	//	}
//
//
//
//	/*	public void mouseMoved(MouseEvent m){
//			cursor.setLocation(m.getX(), m.getY() - cursor.getHeight());
//			cursor.sendToFront();
//		}
//
//
//		public void mouseDragged(MouseEvent m){
//			cursor.setLocation(m.getX(), m.getY() - cursor.getHeight());
//			cursor.sendToFront();
//			}
//	 */
//
//
//	public void run(){
//
//
//
//
//	}
//
//
//}

