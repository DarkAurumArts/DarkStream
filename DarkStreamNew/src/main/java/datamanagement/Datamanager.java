/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package darkStream.datamanagement;

import Tools.NeonThread;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Marcel
 */
public class Datamanager extends NeonThread{
Fileloader fileloader;
    private String serverStorage;
    public Datamanager() {
     fileloader = new Fileloader(this);
    
    }

    
    @Override
    protected void threadDoWork() {
        
        
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private Object loadFile(String pathToFile) {
        FileInputStream inputStream;
        ObjectInputStream objectInputStream;

        try {

            File f = new File(serverStorage+ "//" + pathToFile);
            inputStream = new FileInputStream(f);
            objectInputStream = new ObjectInputStream(inputStream);
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            objectInputStream.close();
            objectInputStream = null;
            System.gc();
            return object;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;


    }
     private void saveFile(Object chatroom, String pathToSavingObject) {


        FileOutputStream outputStream;
        ObjectOutputStream objectOutputStream;
        
        try {
            File f = new File(serverStorage+"\\"+pathToSavingObject);
            f.getParentFile().mkdirs();
            f.createNewFile();
            outputStream = new FileOutputStream(f);
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(chatroom);
            objectOutputStream.close();
            objectOutputStream = null;
            System.gc();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
