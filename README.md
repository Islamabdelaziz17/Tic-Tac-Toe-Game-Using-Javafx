# Tic-Tac-Toe-Game-Using-Javafx
Tic-Tac-Toe Game using Java but our project is little bit different we control our game using External Joystick through Arduino

# Video
Follow the link for the [Demonstrative video](https://youtu.be/4tB1NDlyix0)

![x](https://user-images.githubusercontent.com/71322040/206015901-6825ec30-d411-4921-8f0a-c94904cc65a9.jpg)
------------------------------------
# Authors
* Abdollah Mahmoud
* Ahmad Noaman
* Islam Abd El-Aziz Lashin
* Nourhan Mahmoud
* Samira Fayez
* Samuel Medhat 
------------------------------------
# How To Use:

1. Download this Repository to your local machine.
2. Connect the hardware
3. Upload the Arduino code
4. Run the Java project


![6](https://user-images.githubusercontent.com/71322040/206017186-6dde3080-cc7a-4fa6-a399-e73eed2c58d5.jpg) 
![c](https://user-images.githubusercontent.com/71322040/206017258-173b8f41-df6e-46f2-96ac-46e39050d9ed.jpg)
------------------------------------
# Dependencies and packages:

1. JSSC-2.6.0-Release
2. jSerialComm.SerialPort
------------------------------------
# Brief About the Files:
1. **FXMLDocumentController.java:**
* Sends and receives data from the Arduino to the Java GUI.
* Handles the turns between players and computer.
* Decides the winner
------------------------------------
2. **StartMenuFXMLController.java:**
* Selects whether it’s a multiplayer game or a one player vs computer game
------------------------------------
3. **FXMLDocument.FXML:**
* Responsible for the heights, lengths and shapes of the buttons and the grid.
* Responsible for setting up the images.
* Responsible for the colors.
------------------------------------
4. **StartFXML.FXML:**
* Holds the single player and multiplayer buttons.
* Holds the background color.
