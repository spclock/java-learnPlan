socket 网络io

bio

最好用字节流

​	read都是阻塞的 ，网络io不像读文件流那样，网络io是不知道什么结束，需要结束符

​	字符流  readline()  \r   \n  \r\n

```java
//字节流可以这样
               BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
                byte[] buffer = new byte[1024];
               int line;
               while ((line = bufferedInputStream.read(buffer)) != -1) {
                   System.out.println(new String(buffer, 0, line));
               }

//但字符流不可以用   是错误的 
String line;
while((line=buffer.readline())!=null){
    
}

//正确的 就可以了
String line=buffer.readline();

//readline() 是以\r \n \r\n 结束但返回的是 不带结束符
//读一行就该结束了
//条件不对一直循环 
```



使用readLine()注意事项：

读入的数据要注意有/r或/n或/r/n
这句话意思是服务端写完数据后，会打印报文结束符/r或/n或/r/n；
同理，客户端写数据时也要打印报文结束符，这样服务端才能读取到数据。
没有数据时会阻塞，在数据流异常或断开时才会返回null
使用socket之类的数据流时，要避免使用readLine()，以免为了等待一个换行/回车符而一直阻塞

​	字节流  read() 读到-1就是当可以结束了

长连接

​	字符流

​	字节流

短连接

对于读取的数据，写入这些数据的流发生异常或者直接关闭，那么readLine()就会把它吃的数据全部吐出来。这就刚好解释了，为什么在我的程序中，断开客户端Socket连接，服务器端立刻输出所有客户端消息的原因。