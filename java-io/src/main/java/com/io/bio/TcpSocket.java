package com.io.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.function.Function;

public class TcpSocket {

    private Function<String, String> handler;

    public TcpSocket(Function<String, String> handler) {
        this.handler = handler;
    }

    public void listen(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        for (; ; ) {
            this.accept(serverSocket);
        }
    }

    public void accept(ServerSocket serverSocket) throws IOException {

        try {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));

            StringBuilder request = new StringBuilder();

            String line;
            for (; ; ) {
                line = bufferedReader.readLine();
                if (line == null || line.isEmpty()) {
                    break;
                }
                request.append(line).append("\n");
            }

            System.out.println(request.toString());

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String response = this.handler.apply(request.toString());
            bufferedWriter.write(response);
            bufferedWriter.flush();
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpSocket tcpSocket = new TcpSocket(rep -> "HTTP/1.1 200 OK\n\n Hello World");
        tcpSocket.listen(9999);
    }


}
