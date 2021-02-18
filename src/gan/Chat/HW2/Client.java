package gan.homeworks.Network.homework.Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        startClient();
    }

    private static void startClient(){
        try(Socket socket = new Socket("localhost",8888);
            DataInputStream in = new DataInputStream(socket.getInputStream());//чтение
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());//отправка
            Scanner scanner = new Scanner(System.in)){
            String message = "";
            //считываем и выводим сообщения от сервера в отдельно потоке
            Thread serverReader = new Thread(()->{
                String serverMessage =  "";
                while(!socket.isClosed()){
                    try{
                        serverMessage = in.readUTF();//тут читаем сообщения с сервера
                        System.out.println(serverMessage);
                    } catch (IOException e) {
                        System.out.println(e);
                    }

                }
            });
            serverReader.start();
            do{
                message = scanner.nextLine();
                out.writeUTF(message);//отправляем сообщения серверу
                out.flush();
            }while(!message.equalsIgnoreCase("stop"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
