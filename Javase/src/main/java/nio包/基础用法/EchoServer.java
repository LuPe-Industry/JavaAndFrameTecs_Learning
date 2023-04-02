package nio包.基础用法;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class EchoServer {
    private static final int PORT = 8080;
    private Selector selector;
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

    public void start() throws IOException {
        // 创建一个Selector
        selector = Selector.open();

        // 创建一个ServerSocketChannel，并绑定到指定端口
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
        serverSocketChannel.configureBlocking(false);

        // 将ServerSocketChannel注册到Selector，并设置为接受连接的操作
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("Echo Server started on port " + PORT);

        while (true) {
            // 阻塞等待就绪的通道
            int readyChannels = selector.select();

            // 获取已经就绪的通道的SelectionKey集合
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();

                if (!key.isValid()) {
                    continue;
                }

                // 处理接受连接的事件
                if (key.isAcceptable()) {
                    accept(key);
                }

                // 处理读取数据的事件
                if (key.isReadable()) {
                    read(key);
                }

                // 处理发送数据的事件
                if (key.isWritable()) {
                    write(key);
                }
            }
        }
    }

    private void accept(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    private void read(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        readBuffer.clear();
        int numRead = socketChannel.read(readBuffer);
        if (numRead == -1) {
            key.cancel();
            socketChannel.close();
            return;
        }
        readBuffer.flip();
        socketChannel.register(selector, SelectionKey.OP_WRITE);
    }

    private void write(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        writeBuffer.flip();
        socketChannel.write(writeBuffer);
        writeBuffer.compact();
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    public static void main(String[] args) throws IOException {
        new EchoServer().start();
    }
}
