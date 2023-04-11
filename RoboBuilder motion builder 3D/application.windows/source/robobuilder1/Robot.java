package robobuilder1;

import processing.core.*;

public class Robot {
	Robot(PApplet parent) {
		p = parent;
	}
	
	public void draw(int [] rotateAngle) {
		this.rotateAngle = rotateAngle;
		p.pushMatrix();
			p.stroke(255);
			p.fill(0);
			drawBody();
			drawHead();
			drawBack();
			drawAss();
			drawUpperArmL();
			drawLowerArmL();
			drawUpperArmR();
			drawLowerArmR();
			drawUpperLegL();
			drawLowerLegL();
			drawFootL();
			drawUpperLegR();
			drawLowerLegR();
			drawFootR();
		p.popMatrix();
	}
	
	private void drawHead() {
		p.pushMatrix();
			p.translate( 0, (-1)*(half_body_y+half_head_y), 0);
			p.box(head_x, head_y, head_z);
		p.popMatrix();
	}
	
	private void drawBody() {
		p.translate(250, 200, 0);
		//p.rotate(PApplet.radians(-15), 0, 1, 0);
		p.rotateY(PApplet.radians(rotateAngle[16]));
		p.rotateX(PApplet.radians(rotateAngle[17]));
		p.box(body_x, body_y, body_z);
	}
	
	private void drawBack() {
		p.pushMatrix();
			p.translate(0, half_back_y-half_body_y, (-1)*(half_body_z+half_back_z));
			p.box(back_x, back_y, back_z);
	}
	
	private void drawAss() {
			p.translate(0, half_back_y+half_ass_y, 0);
			p.box(ass_x, ass_y, ass_z);
		p.popMatrix();
	}
	
	private void drawUpperArmL() {
		p.pushMatrix();
			p.translate(half_body_x+half_upper_arm_x, (-1)*half_upper_arm_y-5, 0);
			//p.rotate(PApplet.radians(30), 1, 0, 0);
			p.rotateX(PApplet.radians(rotateAngle[10]));
			p.rotateZ(PApplet.radians(rotateAngle[11])*(-1));
			p.translate(0, half_upper_arm_y, 0);
			p.box(upper_arm_x, upper_arm_y, upper_arm_z);
	}
	
	private void drawLowerArmL() {
			p.translate(0, half_upper_arm_y, 0);
			//p.rotate(PApplet.radians(90), 1, 0, 0);
			p.rotateX(PApplet.radians(rotateAngle[12])*(-1));
			p.translate(0, half_lower_arm_y, 0);
			p.box(lower_arm_x, lower_arm_y, lower_arm_z);
		p.popMatrix();
	}
	
	private void drawUpperArmR() {
		p.pushMatrix();
			p.translate((-1)*(body_x+upper_arm_x)/2, (-1)*upper_arm_y/2-5, 0);
			//p.rotate(PApplet.radians(30), 1, 0, 0);
			p.rotateX(PApplet.radians(rotateAngle[13])*(-1));
			p.rotateZ(PApplet.radians(rotateAngle[14])*(-1));
			p.translate(0, upper_arm_y/2, 0);
			p.box(upper_arm_x, upper_arm_y, upper_arm_z);
	}
	
	private void drawLowerArmR() {
			p.translate(0, half_upper_arm_y, 0);
			//p.rotate(PApplet.radians(90), 1, 0, 0);
			p.rotateX(PApplet.radians(rotateAngle[15]));
			p.translate(0, half_lower_arm_y, 0);
			p.box(lower_arm_x, lower_arm_y, lower_arm_z);
		p.popMatrix();
	}
	
	private void drawUpperLegL() {
		p.pushMatrix();
			p.translate(30, half_body_y, 0);
			//p.rotateX(PApplet.radians(30));
			p.rotateX(PApplet.radians(rotateAngle[1])*(-1));
			p.rotateZ(PApplet.radians(rotateAngle[0]));
			p.translate(0, half_upper_leg_y, 0);
			p.box(upper_leg_x, upper_leg_y, upper_leg_z);
	}
	
	private void drawLowerLegL() {
			p.translate(0, half_upper_leg_y, 0);
			//p.rotateX(PApplet.radians(-30));
			p.rotateX(PApplet.radians(rotateAngle[2])*(-1));
			p.translate(0, half_lower_leg_y, 0);
			p.box(lower_leg_x, lower_leg_y, lower_leg_z);
	}
	
	private void drawFootL() {
			p.translate(5, half_lower_leg_y, 0);
			p.rotateX(PApplet.radians(rotateAngle[3]));
			p.rotateZ(PApplet.radians(rotateAngle[4])*(-1));
			p.translate(0, half_foot_y, 0);
			p.box(foot_x, foot_y, foot_z);
		p.popMatrix();
	}
	
	private void drawUpperLegR() {
		p.pushMatrix();
			p.translate(-30, half_body_y, 0);
			//p.rotateX(PApplet.radians(-10));
			p.rotateX(PApplet.radians(rotateAngle[6]));
			p.rotateZ(PApplet.radians(rotateAngle[5]));
			p.translate(0, half_upper_leg_y, 0);
			p.box(upper_leg_x, upper_leg_y, upper_leg_z);
	}
	
	private void drawLowerLegR() {
			p.translate(0, half_upper_leg_y, 0);
			p.rotateX(PApplet.radians(rotateAngle[7]));
			p.translate(0, half_lower_leg_y, 0);
			p.box(lower_leg_x, lower_leg_y, lower_leg_z);
	}
	
	private void drawFootR() {
			p.translate(-5, half_lower_leg_y, 0);
			p.rotateX(PApplet.radians(rotateAngle[8])*(-1));
			p.rotateZ(PApplet.radians(rotateAngle[9])*(-1));
			p.translate(-5, half_foot_y, 0);
			p.box(foot_x, foot_y, foot_z);
		p.popMatrix();
	}
	
	private PApplet p;
	
	int [] rotateAngle;
	
	// robot body
	private final int body_x = 90;
	private final int body_y = 75;
	private final int body_z = 50;
	private final int half_body_x = body_x / 2;
	private final int half_body_y = body_y / 2;
	private final int half_body_z = body_z / 2;
	
	// robot back
	private final int back_x = 80;
	private final int back_y = 60;
	private final int back_z = 40;
	private final int half_back_x = back_x / 2;
	private final int half_back_y = back_y / 2;
	private final int half_back_z = back_z / 2;
	
	// robot ass
	private final int ass_x = 80;
	private final int ass_y = 50;
	private final int ass_z = 40;
	private final int half_ass_x = ass_x / 2;
	private final int half_ass_y = ass_y / 2;
	private final int half_ass_z = ass_z / 2;
	
	// robot head
	private final int head_x = 40;
	private final int head_y = 35;
	private final int head_z = 35;
	private final int half_head_x = head_x / 2;
	private final int half_head_y = head_y / 2;
	private final int half_head_z = head_z / 2;
	
	// robot upper_arm
	private final int upper_arm_x = 25;
	private final int upper_arm_y = 50;
	private final int upper_arm_z = 35;
	private final int half_upper_arm_x = upper_arm_x / 2;
	private final int half_upper_arm_y = upper_arm_y / 2;
	private final int half_upper_arm_z = upper_arm_z / 2;
	
	// robot lower_arm
	private final int lower_arm_x = 35;
	private final int lower_arm_y = 90;
	private final int lower_arm_z = 28;
	private final int half_lower_arm_x = lower_arm_x / 2;
	private final int half_lower_arm_y = lower_arm_y / 2;
	private final int half_lower_arm_z = lower_arm_z / 2;
	
	// robot upper_leg
	private final int upper_leg_x = 35;
	private final int upper_leg_y = 60;
	private final int upper_leg_z = 25;
	private final int half_upper_leg_x = upper_leg_x / 2;
	private final int half_upper_leg_y = upper_leg_y / 2;
	private final int half_upper_leg_z = upper_leg_z / 2;
	
	// robot lower_leg
	private final int lower_leg_x = 40;
	private final int lower_leg_y = 90;
	private final int lower_leg_z = 50;
	private final int half_lower_leg_x = lower_leg_x / 2;
	private final int half_lower_leg_y = lower_leg_y / 2;
	private final int half_lower_leg_z = lower_leg_z / 2;
	
	// robot foot
	private final int foot_x = 55;
	private final int foot_y = 15;
	private final int foot_z = 100;
	private final int half_foot_x = foot_x / 2;
	private final int half_foot_y = foot_y / 2;
	private final int half_foot_z = foot_z / 2;
}
