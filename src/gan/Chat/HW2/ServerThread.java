package gan.homeworks.Network.homework.Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread extends Thread{

    private final Socket socket;

    public ServerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run(){
        try(DataInputStream in = new DataInputStream(socket.getInputStream());//чтение);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream())){//отправка
            out.writeUTF("Привет, клиент");
            out.flush();
            String message = "";
            do{
                message = in.readUTF();
                out.writeUTF("Сообщение: " + message + " - доставлено серверу");
                out.flush();
            }while(!message.equalsIgnoreCase("stop"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
                System.out.println("Клиент отключился");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}