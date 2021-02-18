package gan.homeworks.Network.homework.Main;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        startServer();
    }

    private static void startServer(){
        try(ServerSocket serverSocket = new ServerSocket(8888)){
            System.out.println("Сервер запущен, ожидаем подключения клиента...");
            //while (true){ по заданию сказано убрать цикл.
                Socket socket = serverSocket.accept();
                System.out.println("Клиент подключился");
                ServerThread thread = new ServerThread(socket);
                thread.start();//для каждого нового клиента создаём новый поток. *для цикла
            //}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

