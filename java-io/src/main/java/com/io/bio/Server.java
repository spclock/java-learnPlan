package com.io.bio;

import com.mysql.cj.util.StringUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public void listen(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        for (; ; ) {
            this.handler(serverSocket);
        }
    }

    private void handler(ServerSocket serverSocket) throws IOException {
        Socket socket = serverSocket.accept();
        new Thread(() -> {
            try (BufferedReader mBufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                PrintWriter mPrintWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8")), true);
            ){

                for (; ; ) {
                    String line;
                    line = mBufferedReader.readLine();
                    System.out.println(line);
//                BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
//                byte[] buffer = new byte[1024];
//                int line;

//                while ((line = bufferedInputStream.read(buffer)) != -1) {
//                    System.out.println(new String(buffer, 0, line));
//                }

                    mPrintWriter.print("server :我收到了" + System.lineSeparator());
//                mPrintWriter.print("HTTP/1.1 200 OK\r\n\r\n hello");
                    mPrintWriter.flush();

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();
    }


    public static void main(String[] args) {
        try {
            new Server().listen(9999);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
