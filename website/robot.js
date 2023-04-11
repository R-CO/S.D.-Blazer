
class Robot {
  constructor() {}

  draw(rotateAngle) {
    this.rotateAngle = rotateAngle;
    push();
    translate(-300, -300, 0);
    stroke(255);
    fill(0);
    this.drawBody();
    this.drawHead();
    this.drawBack();
    this.drawAss();
    this.drawUpperArmL();
    this.drawLowerArmL();
    this.drawUpperArmR();
    this.drawLowerArmR();
    this.drawUpperLegL();
    this.drawLowerLegL();
    this.drawFootL();
    this.drawUpperLegR();
    this.drawLowerLegR();
    this.drawFootR();
    pop();
  }

  drawHead() {
    push();
    translate(0, (-1) * (this.half_body_y + this.half_head_y), 0);
    box(this.head_x, this.head_y, this.head_z);
    pop();
  }

  drawBody() {
    translate(250, 200, 0);
    // rotate(radians(-15), 0, 1, 0);
    rotateY(radians(this.rotateAngle[16]));
    rotateX(radians(this.rotateAngle[17]));
    box(this.body_x, this.body_y, this.body_z);
  }

  drawBack() {
    push();
    translate(
        0, this.half_back_y - this.half_body_y,
        (-1) * (this.half_body_z + this.half_back_z));
    box(this.back_x, this.back_y, this.back_z);
  }

  drawAss() {
    translate(0, this.half_back_y + this.half_ass_y, 0);
    box(this.ass_x, this.ass_y, this.ass_z);
    pop();
  }

  drawUpperArmL() {
    push();
    translate(
        this.half_body_x + this.half_upper_arm_x,
        (-1) * this.half_upper_arm_y - 5, 0);
    // rotate(radians(30), 1, 0, 0);
    rotateX(radians(this.rotateAngle[10]));
    rotateZ(radians(this.rotateAngle[11]) * (-1));
    translate(0, this.half_upper_arm_y, 0);
    box(this.upper_arm_x, this.upper_arm_y, this.upper_arm_z);
  }

  drawLowerArmL() {
    translate(0, this.half_upper_arm_y, 0);
    // rotate(radians(90), 1, 0, 0);
    rotateX(radians(this.rotateAngle[12]) * (-1));
    translate(0, this.half_lower_arm_y, 0);
    box(this.lower_arm_x, this.lower_arm_y, this.lower_arm_z);
    pop();
  }

  drawUpperArmR() {
    push();
    translate(
        (-1) * (this.body_x + this.upper_arm_x) / 2,
        (-1) * this.upper_arm_y / 2 - 5, 0);
    // rotate(radians(30), 1, 0, 0);
    rotateX(radians(this.rotateAngle[13]) * (-1));
    rotateZ(radians(this.rotateAngle[14]) * (-1));
    translate(0, this.upper_arm_y / 2, 0);
    box(this.upper_arm_x, this.upper_arm_y, this.upper_arm_z);
  }

  drawLowerArmR() {
    translate(0, this.half_upper_arm_y, 0);
    // rotate(radians(90), 1, 0, 0);
    rotateX(radians(this.rotateAngle[15]));
    translate(0, this.half_lower_arm_y, 0);
    box(this.lower_arm_x, this.lower_arm_y, this.lower_arm_z);
    pop();
  }

  drawUpperLegL() {
    push();
    translate(30, this.half_body_y, 0);
    // rotateX(radians(30));
    rotateX(radians(this.rotateAngle[1]) * (-1));
    rotateZ(radians(this.rotateAngle[0]));
    translate(0, this.half_upper_leg_y, 0);
    box(this.upper_leg_x, this.upper_leg_y, this.upper_leg_z);
  }

  drawLowerLegL() {
    translate(0, this.half_upper_leg_y, 0);
    // rotateX(radians(-30));
    rotateX(radians(this.rotateAngle[2]) * (-1));
    translate(0, this.half_lower_leg_y, 0);
    box(this.lower_leg_x, this.lower_leg_y, this.lower_leg_z);
  }

  drawFootL() {
    translate(5, this.half_lower_leg_y, 0);
    rotateX(radians(this.rotateAngle[3]));
    rotateZ(radians(this.rotateAngle[4]) * (-1));
    translate(0, this.half_foot_y, 0);
    box(this.foot_x, this.foot_y, this.foot_z);
    pop();
  }

  drawUpperLegR() {
    push();
    translate(-30, this.half_body_y, 0);
    // rotateX(radians(-10));
    rotateX(radians(this.rotateAngle[6]));
    rotateZ(radians(this.rotateAngle[5]));
    translate(0, this.half_upper_leg_y, 0);
    box(this.upper_leg_x, this.upper_leg_y, this.upper_leg_z);
  }

  drawLowerLegR() {
    translate(0, this.half_upper_leg_y, 0);
    rotateX(radians(this.rotateAngle[7]));
    translate(0, this.half_lower_leg_y, 0);
    box(this.lower_leg_x, this.lower_leg_y, this.lower_leg_z);
  }

  drawFootR() {
    translate(-5, this.half_lower_leg_y, 0);
    rotateX(radians(this.rotateAngle[8]) * (-1));
    rotateZ(radians(this.rotateAngle[9]) * (-1));
    translate(-5, this.half_foot_y, 0);
    box(this.foot_x, this.foot_y, this.foot_z);
    pop();
  }

  rotateAngle;

  // robot body
  body_x = 90;
  body_y = 75;
  body_z = 50;
  half_body_x = this.body_x / 2;
  half_body_y = this.body_y / 2;
  half_body_z = this.body_z / 2;

  // robot back
  back_x = 80;
  back_y = 60;
  back_z = 40;
  half_back_x = this.back_x / 2;
  half_back_y = this.back_y / 2;
  half_back_z = this.back_z / 2;

  // robot ass
  ass_x = 80;
  ass_y = 50;
  ass_z = 40;
  half_ass_x = this.ass_x / 2;
  half_ass_y = this.ass_y / 2;
  half_ass_z = this.ass_z / 2;

  // robot head
  head_x = 40;
  head_y = 35;
  head_z = 35;
  half_head_x = this.head_x / 2;
  half_head_y = this.head_y / 2;
  half_head_z = this.head_z / 2;

  // robot upper_arm
  upper_arm_x = 25;
  upper_arm_y = 50;
  upper_arm_z = 35;
  half_upper_arm_x = this.upper_arm_x / 2;
  half_upper_arm_y = this.upper_arm_y / 2;
  half_upper_arm_z = this.upper_arm_z / 2;

  // robot lower_arm
  lower_arm_x = 35;
  lower_arm_y = 90;
  lower_arm_z = 28;
  half_lower_arm_x = this.lower_arm_x / 2;
  half_lower_arm_y = this.lower_arm_y / 2;
  half_lower_arm_z = this.lower_arm_z / 2;

  // robot upper_leg
  upper_leg_x = 35;
  upper_leg_y = 60;
  upper_leg_z = 25;
  half_upper_leg_x = this.upper_leg_x / 2;
  half_upper_leg_y = this.upper_leg_y / 2;
  half_upper_leg_z = this.upper_leg_z / 2;

  // robot lower_leg
  lower_leg_x = 40;
  lower_leg_y = 90;
  lower_leg_z = 50;
  half_lower_leg_x = this.lower_leg_x / 2;
  half_lower_leg_y = this.lower_leg_y / 2;
  half_lower_leg_z = this.lower_leg_z / 2;

  // robot foot
  foot_x = 55;
  foot_y = 15;
  foot_z = 100;
  half_foot_x = this.foot_x / 2;
  half_foot_y = this.foot_y / 2;
  half_foot_z = this.foot_z / 2;
}
