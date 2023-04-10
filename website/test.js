// var canvas_width = 400;
// var canvas_height = 300;

// var frame_rate = 30;
// const frame_rate_half = frame_rate / 2;

// var x_pos = 0;
// //var y_pos = 300;
// var y_pos = 0;
// var width = 50;
// var height = 50;

// var animation_mode = true;

// var text_size = 120;
// const words = ["超", "棒", "丹", "尼", "爾"];
// var word_idx = 0;
// var count = 0;

// function setup() {
//   // put setup code here
//   createCanvas(canvas_width, canvas_height, WEBGL);
//   // createCanvas(canvas_width, canvas_height);
//   // frameRate(frame_rate);
//   textSize(text_size);
// }

// function draw() {
//   // put drawing code here
//   background(255, 255, 255);
//   let time_millis = millis();
//   rotateX(time_millis / 1000);
//   rotateZ(time_millis / 1234);
//   text(words[word_idx], 0, 0);
//   // text(words[word_idx], canvas_width / 2, canvas_height / 2);
//   if (count++ === frame_rate_half) {
//     ++word_idx;
//     word_idx %= words.length;
//     count = 0;
//   }

//   //fill(150, 150, 150);
//   //ellipse(x_pos, y_pos, width, height);
//   //ellipse(x_pos, y_pos, width);

//   // x_pos += 2;
//   // if (x_pos >= width + canvas_width) {
//   //   x_pos = 0 - width;
//   // }
//   // y_pos++;
//   // if (y_pos) {
//   //   y_pos = 0 - y_pos;
//   // }
// }

// function mousePressed() {
//   if (mouseButton === LEFT) {
//     modeChanging();
//     // redraw();
//   }
// }

// function modeChanging() {
//   animation_mode = !animation_mode;
//   if (animation_mode === true) {
//     loop();
//   } else {
//     noLoop();
//   }
// }

// ##########################