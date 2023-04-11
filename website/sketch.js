// clang-format off
const rotateAngle = [
  0, 0, 0, 0, 0, 0,
  0, 0, 0, 0, 0, 0,
  0, 0, 0, 0, 0, 0];

const originalAngleID = [
  125, 214, 143, 105,
  108, 126, 36, 106,
  146, 139, 86, 47,
  125, 164, 205, 126];

const initialAngleID = [
  125, 179, 199, 88,
  108, 126, 72, 49,
  163, 141, 51, 47,
  49, 199, 205, 205];
// clang-format on

const maxMotors = 16;

function setup() {
  createCanvas(1000, 1000, WEBGL);
  standard_pose();
}

function draw() {
  background(127);
  let robot = new Robot();

  robot.draw(rotateAngle)
}

function standard_pose() {
  for (let i = 0; i < maxMotors; ++i) {
    rotateAngle[i] = initialAngleID[i] - originalAngleID[i];
    // motor_slider_ID[i].setValue(initialAngleID[i]);
    // if (isConnectedToRobot == true) {
    //   port.write(WCKCommand.positionMove(2, i, (int)
    //   motor_slider_ID[i].getValue()));
    // }
  }
}