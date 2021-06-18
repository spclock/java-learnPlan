package com.io.bio;

import java.io.*;

import java.net.ServerSocket;

import java.net.Socket;

public class SortServer {

    public void listen(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        handler(serverSocket);
    }

    private void handler(ServerSocket serverSocket) {
        for (; ; ) {
            try {
                Socket socket = serverSocket.accept();
                socket.setSoTimeout(3 * 1000);
                new Thread(() -> {

                }).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void stream_read(Socket socket) {
        try (InputStream mInputStream = socket.getInputStream();
             OutputStream mOutputStream = socket.getOutputStream();) {
//            mOutputStream.write(bytes);
            mOutputStream.flush();
            byte[] buffer = new byte[1024];
            int n = 0;
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            while (-1 != (n = mInputStream.read(buffer))) {
                output.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {


    }

}
