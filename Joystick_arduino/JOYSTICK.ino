int const UP_BTN = 2;
int const DOWN_BTN = 4;
int const LEFT_BTN = 5;
int const RIGHT_BTN = 3;
int const E_BTN = 6;
int const F_BTN = 7;
int const JOYSTICK_BTN = 8;
int const JOYSTICK_AXIS_X = A0;
int const JOYSTICK_AXIS_Y = A1;
int buttons[] = {UP_BTN, DOWN_BTN, LEFT_BTN, RIGHT_BTN, E_BTN, F_BTN, JOYSTICK_BTN};
//===============================================================================
//  Initialization
//===============================================================================
void setup() {
  //Set all button pins as inputs with internal pullup resistors enabled.
  for (int i; i < 7; i++)  pinMode(buttons[i], INPUT_PULLUP);
  Serial.begin(9600);
}
//===============================================================================
//  Main
//===============================================================================
void loop() {
 int X = analogRead(JOYSTICK_AXIS_X);
 int Y = analogRead(JOYSTICK_AXIS_Y);
  
   if(X > 700)
  {
    delay(200);
    if(X > 700)
  {
      Serial.print("R");    
  }
  }

   if(X < 300)
  {
    delay(200);
    if(X < 300)
  {
      Serial.print("L");    
  }
  }

  if(Y > 700)
  {
    delay(200);
    if(Y > 700)
  {
      Serial.print("U");    
  }
  }

     if(Y < 300)
  {
    delay(200);
    if(Y < 300)
  {
      Serial.print("D");    
  }
  }
  
  if(digitalRead(UP_BTN)==0)
  {
    delay(200);
    if(digitalRead(UP_BTN)==0)
  {
      Serial.print("u");    
  }
  }
  
   if(digitalRead(DOWN_BTN)==0)
  {
    delay(200);
    if(digitalRead(DOWN_BTN)==0)
  {
      Serial.print("d"); 
  }   
  }

   if(digitalRead(LEFT_BTN)==0)
  {
    delay(200);
    if(digitalRead(LEFT_BTN)==0)
  {
      Serial.print("l");    
  }
  }
  
   if(digitalRead(RIGHT_BTN)==0)
  {
    delay(200);
     if(digitalRead(RIGHT_BTN)==0)
  {
      Serial.print("r");    
  }
  }
  
  if (digitalRead(E_BTN) == 0 || digitalRead(F_BTN) == 0 || digitalRead(JOYSTICK_BTN) == 0)
  {
        delay(100);
        if (digitalRead(E_BTN) == 0 || digitalRead(F_BTN) == 0 || digitalRead(JOYSTICK_BTN) == 0)
  {
    Serial.print("F");  
  }
  }
 

 }
