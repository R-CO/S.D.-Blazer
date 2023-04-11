package robobuilder1;

import processing.core.PApplet;

import processing.serial.*;

import controlP5.*;

public class RoboBuilder1 extends PApplet {
	Robot robot;
	ControlP5 cp5;
	Serial port;
	RoboBuilder1 self = this;
	
	int serialCase = 0;
	
	int [] rotateAngle = new int [18];
	byte [] serialIn;// = new byte [16];
	
	boolean isConnectedToRobot = false;
	
	Button robot_turn_rightButton;
	Button robot_turn_leftButton;
	Button robot_turn_upButton;
	Button robot_turn_downButton;
	
	Button initial_viewButton;
	Button standard_poseButton;
	
	MultiList connect_robotML;
	MultiListButton connect_robotMLB;
	Button [] portButton;
	
	Slider [] motor_slider_ID;
	
	final int maxFrameRate = 25;
	final int maxMotors = 16;
	
	final int baudRate = 115200;
	
	// for drawing
	final int [] originalAngleID = {125, 214, 143, 105, 
									108, 126, 36, 106,
									146, 139, 86, 47,
									125, 164, 205, 126};
	// the real robot motors' initial angles 
	final int [] initialAngleID = {125, 179, 199, 88,
								   108, 126, 72, 49,
								   163, 141, 51, 47,
								   49, 199, 205, 205};
	
	public void setup() {
		size(1000, 600, OPENGL);
		//smooth();
		//frameRate(maxFrameRate); // it's doesn't work
		background(127);
		
		robot = new Robot(this);		
		
		createGUI();
	}

	public void draw() {
		background(127);
		controlRobotRotate();
		computeRotateAngles();
		robot.draw(rotateAngle);
	}

	public void serialEvent(Serial p) {				
		serialIn = p.readBytes();
		//println(serialIn);
		switch (serialCase) {
			case	0:		
				//serialIn = p.readBytes();
				checkRobotConnection();
				break;
			case	1:
				//serialIn = p.readBytes();
				break;
		}
	}
	
	public void createGUI() {
		cp5 = new ControlP5(this);
		
		robot_turn_leftButton = cp5.addButton("ROBOT_TURN_LEFT")
				.setPosition(300, 500)
				.setSize(100, 20)
				.activateBy(ControlP5.PRESSED);
			
		robot_turn_rightButton = cp5.addButton("ROBOT_TURN_RIGHT")
				.setPosition(50, 500)
				.setSize(100, 20)
				.activateBy(ControlP5.PRESSED);
			
		robot_turn_upButton = cp5.addButton("ROBOT_TURN_UP")
				.setPosition(225, 450)
				.setSize(20, 50)
				.activateBy(ControlP5.PRESSED)
				.setLabelVisible(false);
			
		robot_turn_downButton = cp5.addButton("ROBOT_TURN_DOWN")
				.setPosition(225, 520)
				.setSize(20, 50)
				.activateBy(ControlP5.PRESSED)
				.setLabelVisible(false);
		
		initial_viewButton = cp5.addButton("INITIAL_VIEW")
				.setPosition(300, 550)
				.setSize(100, 20);
		
		standard_poseButton = cp5.addButton("STANDARD_POSE")
				.setPosition(50, 550)
				.setSize(100, 20);
			
		motor_slider_ID = new Slider [maxMotors];
		for (int i = 0; i < maxMotors; ++i) {
			motor_slider_ID[i] = cp5.addSlider("ID["+i+"]")
					.setPosition(i*30+300, i*30)
					.setRange(0, 255)
					.setValue(originalAngleID[i])
					.setSliderMode(Slider.FLEXIBLE)
					.setDecimalPrecision(0);
		}
		setMotorSliderPostion();
		addSliderCallback();
		
		connect_robotML = cp5.addMultiList("CONNECT_ROBOT_ML", 830, 20, 100, 20);
		
		connect_robotMLB = (MultiListButton) connect_robotML.add("CONNECT_ROBOT", 0)
				.setPosition(830, 20)
				.setSize(100, 20)
				.setColorBackground(color(0, 230, 0))
				.setColorForeground(color(0, 240, 0))
				.setColorActive(color(0, 255, 0));
		
		portButton = new Button [Serial.list().length];
		for (int i = 0; i < Serial.list().length; ++i) {
			portButton[i] = connect_robotMLB.add(Serial.list()[i], i)
				.setSize(50, 20)
				.addCallback(new CallbackListener() {
					@Override
					public void controlEvent(CallbackEvent e) {
						// TODO Auto-generated method stub
						if (e.getAction() == ControlP5.ACTION_RELEASED) {
							if (isConnectedToRobot == false) {
								port = new Serial(self, e.getController().getName(), baudRate);
							}
						}
					}
				});
		}
	}
	
	private void setMotorSliderPostion() {
		motor_slider_ID[13].setPosition(80, 130);
		motor_slider_ID[10].setPosition(290, 130);
		motor_slider_ID[14].setPosition(20, 160);
		motor_slider_ID[15].setPosition(20, 210);
		motor_slider_ID[11].setPosition(350, 160);
		motor_slider_ID[12].setPosition(350, 210);
		motor_slider_ID[5].setPosition(30, 230);
		motor_slider_ID[6].setPosition(30, 250);
		motor_slider_ID[0].setPosition(340, 230);
		motor_slider_ID[1].setPosition(340, 250);
		motor_slider_ID[7].setPosition(30, 300);
		motor_slider_ID[2].setPosition(340, 300);
		motor_slider_ID[8].setPosition(20, 380);
		motor_slider_ID[9].setPosition(20, 400);
		motor_slider_ID[3].setPosition(350, 380);
		motor_slider_ID[4].setPosition(350, 400);
	}
	
	public void addSliderCallback() {
		int i;
		for (i = 0; i < maxMotors; ++i) {
			motor_slider_ID[i].addCallback(new CallbackListener() {
				@Override
				public void controlEvent(CallbackEvent e) {
					// TODO Auto-generated method stub
					switch (e.getAction()) {
						case ControlP5.ACTION_RELEASED:
							if (isConnectedToRobot == true) {
								port.buffer(2);
								port.write(WCKCommand.positionMove(2, getID(e.getController().getName()), (int) e.getController().getValue()));
							}
							break;
					}
				}
				
			});
		}
	}
	
	public void ROBOT_TURN_LEFT() {
		//
	}
	
	public void ROBOT_TURN_RIGHT() {
		// 
	}
	
	public void ROBOT_TURN_UP() {
		//
	}
	
	public void ROBOT_TURN_DOWN() {
		//
	}
	
	public void INITIAL_VIEW() {
		rotateAngle[16] = rotateAngle[17] = 0;
	}
	
	public void STANDARD_POSE() {
		if(isConnectedToRobot == true) {
			port.buffer(2);
		}
		for (int i = 0; i < maxMotors; ++i) {
			rotateAngle[i] = initialAngleID[i] - originalAngleID[i];
			motor_slider_ID[i].setValue(initialAngleID[i]);
			if (isConnectedToRobot == true) {
				port.write(WCKCommand.positionMove(2, i, (int) motor_slider_ID[i].getValue()));
			}
		}
	}
	
	public void CONNECT_ROBOT() {					
		if (isConnectedToRobot == false) {
			serialCase = 0;
			if (port != null) {
				port.buffer(16);
				port.write(RBCCommandList.toRBC_DirectControlMode);
			}
		}
		else { // isConnectedToRobot == true
			port.buffer(2);
			for (int ID = 0; ID < maxMotors; ++ID) {
				port.write(WCKCommand.passiveWCK(ID));
			}
			port.write(RBCCommandList.toRBC_DirectControlMode_Release);
			connect_robotMLB.setColorBackground(color(0, 230, 0))
				.setColorForeground(color(0, 240, 0))
				.setColorActive(color(0, 255, 0))
				.setCaptionLabel("CONNECT_ROBOT");
			isConnectedToRobot = false;
		}
	}
	
	public void checkRobotConnection() {
		boolean yes = true;
		
		for (int i = 0; i < 16; ++i) {
			if (serialIn[i] != RBCCommandList.fromRBC_DirectControlMode[i]) {
				//println(i);
				yes = false;
				break;
			}
		}
		if (yes) {
			serialCase = 1;
			isConnectedToRobot = true;
			connect_robotMLB.setColorBackground(color(230, 0, 0))
				.setColorForeground(color(240, 0, 0))
				.setColorActive(color(255, 0, 0))
				.setCaptionLabel("CLOSE_CONNECTION");
			for (int i = 0; i < portButton.length; ++i) {
				portButton[i].remove();
			}
		}
	}
	
	public int getID(String name) {
		int ID = 0;
		String [] tokens = splitTokens(name, "[]");
		
		ID = Integer.valueOf(tokens[1]);
		
		return ID;
	}
	
	private void controlRobotRotate() {
		int i = 0;
		if (robot_turn_rightButton.isMousePressed() == true) {
			if (i == 0) {
				--rotateAngle[16];
				if (rotateAngle[16] == -1) {
					rotateAngle[16] = 359;
				}
			}
			++i;
			if (i == maxFrameRate / 10) {
				i = 0;
			}
		}
		else if (robot_turn_leftButton.isMousePressed() == true) {
			if (i == 0) {
				++rotateAngle[16];
				rotateAngle[16] %= 360;
			}
			++i;
			if (i == maxFrameRate / 10) {
				i = 0;
			}
		}
		else if (robot_turn_upButton.isMousePressed() == true) {
			if (i == 0) {
				++rotateAngle[17];
				rotateAngle[17] %= 360;
			}
			++i;
			if (i == maxFrameRate / 10) {
				i = 0;
			}
		}
		else if (robot_turn_downButton.isMousePressed() == true) {
			if (i == 0) {
				--rotateAngle[17];
				if (rotateAngle[17] == -1) {
					rotateAngle[17] = 359;
				}
			}
			++i;
			if (i == maxFrameRate / 10) {
				i = 0;
			}
		}
	}
	
	private void computeRotateAngles() {
		for (int i = 0; i < maxMotors; ++i) {
			rotateAngle[i] = (int) (motor_slider_ID[i].getValue() - originalAngleID[i]);
		}
	}
	
	public static void main(String _args[]) {
		PApplet.main(new String[] { robobuilder1.RoboBuilder1.class.getName() });
	}
}
