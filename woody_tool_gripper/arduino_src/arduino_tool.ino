#include <Wire.h>
#include <Servo.h> 

int LED = 13;
int x = 0;
int servoPin = 3;
Servo servo;
void setup() {
  // Define the LED pin as Output
  servo.attach(servoPin);
  servo.write(90);
  
  pinMode(LED_BUILTIN, OUTPUT);
  // Start the I2C Bus as Slave on address 9
  Wire.begin(9); 
  // Attach a function to trigger when something is received.
  Wire.onReceive(receiveEvent);
}
void receiveEvent(int bytes) {
  x = Wire.read();    // read one character from the I2C
}
void loop() {
  if (servo.read() != x*18){
    servo.write(x * 18);
  }
  
}
