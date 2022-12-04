package Arduino;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import jssc.SerialPort;
import static jssc.SerialPort.MASK_RXCHAR;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import jssc.SerialPortList;
import tic.tac.toe.FXMLDocumentController;

public class SerialControl{
    
    static public SerialPort arduinoPort = null;
    static public String reading; 
    static public String port = null; 
    static public FXMLDocumentController tic;
        static public void detectPort(){
         
        String[] serialPortNames = SerialPortList.getPortNames();
        for(String name: serialPortNames){
            System.out.println(name);
         
        }
        port = serialPortNames[0];
    }
 

    static public boolean connectArduino(String port){
        
        System.out.println("connectArduino");
        
        boolean success = false;
        SerialPort serialPort = new SerialPort(port);
        try {
            //serialPort.closePort();
            serialPort.openPort();
            serialPort.setParams(
                    SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            serialPort.setEventsMask(MASK_RXCHAR);
            serialPort.addEventListener(new SerialPortEventListener() {
                @Override
                public void serialEvent(SerialPortEvent serialPortEvent) {
                    if(serialPortEvent.isRXCHAR()){
                        try
                        {
                            reading = serialPort.readString();
                            System.out.println(reading);
                        
                        } catch (SerialPortException ex) {
                            Logger.getLogger(SerialControl.class.getName())
                                    .log(Level.SEVERE, null, ex);
                        }
                        
                    }
                }
            });
            
            arduinoPort = serialPort;
            success = true;
        } catch (SerialPortException ex) {
            Logger.getLogger(SerialControl.class.getName())
                    .log(Level.SEVERE, null, ex);
            System.out.println("SerialPortException: " + ex.toString());
            
        }

        return success;
    }
    
    static public void disconnectArduino(){
        
        System.out.println("disconnectArduino()");
        if(arduinoPort != null){
            try {
                arduinoPort.removeEventListener();
                
                if(arduinoPort.isOpened()){
                    arduinoPort.closePort();
                }
                
            } catch (SerialPortException ex) {
                Logger.getLogger(SerialControl.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
        
    }


}