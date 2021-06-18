package com.io.bio;

import com.mysql.cj.util.StringUtils;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Client {


    public void link(String ip, int port) throws IOException {
        Socket socket = new Socket(ip, port);

//        for (; ; ) {
//            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            bufferedWriter.write("hello world"+"\r\n");
//            bufferedWriter.flush();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//
//            new Thread(() -> {
//            try {
//
//                BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
//                byte[] bytes=new byte[1024];
//                int n = 0;
//                ByteArrayOutputStream output = new ByteArrayOutputStream();
//                while (-1 != (n = bufferedInputStream .read(bytes))) {
//                    output.write(bytes, 0, n);
//                }
//
//                output.close();
//                byte[] result = output.toByteArray();
//                System.out.println(Arrays.toString(result));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            }).start();

        BufferedReader mBufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        PrintWriter mPrintWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8")), true);

        BufferedReader ii = new BufferedReader(new InputStreamReader(System.in));

        for(;;) {

//            mPrintWriter.print("client :hello world" + System.lineSeparator());
            mPrintWriter.println(ii.readLine());
            mPrintWriter.flush();
//        socket.shutdownOutput();


            String line;
                line = mBufferedReader.readLine();
                System.out.println(line);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new Client().link("127.0.0.1", 9999);
//        try {
//            发送到8888端口
//            Socket socket=new Socket("127.0.0.1", 9999);
//            输出流
//            OutputStream outputStream=socket.getOutputStream();
//            PrintWriter printWriter=new PrintWriter(outputStream);
//            printWriter.write("server端你好，我是client。");
//            printWriter.flush();
//            关闭资源
//            printWriter.close();
//            outputStream.close();
//            socket.close();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
