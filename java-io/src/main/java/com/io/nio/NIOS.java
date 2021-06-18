package com.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class NIOS {

    static List<SocketChannel> socketChannelList=new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(9000));
            serverSocketChannel.configureBlocking(false);
            System.out.println("server start");

            for(;;){
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel!=null){
                    System.out.println("link success");
                    socketChannel.configureBlocking(false);
                    socketChannelList.add(socketChannel);
                }

                for (int i = 0; i < socketChannelList.size()-1 ; i++) {
                    ByteBuffer allocate = ByteBuffer.allocate(128);

                    SocketChannel sc = socketChannelList.get(i);
                    int len=sc.read(allocate);
                    if(len>0){
                        System.out.println("rev data:" +new String(allocate.array()));
                    }else if(len==-1){
                        socketChannelList.remove(allocate);
                        System.out.println("client 离开");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
