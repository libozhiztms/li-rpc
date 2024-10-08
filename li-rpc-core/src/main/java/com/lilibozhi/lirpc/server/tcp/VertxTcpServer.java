package com.lilibozhi.lirpc.server.tcp;

import com.lilibozhi.lirpc.server.HttpServer;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.NetServer;
import lombok.extern.slf4j.Slf4j;

/**
 * Vertx TCP 服务器
 */
@Slf4j
public class VertxTcpServer implements HttpServer {
    private byte[] handleRequest(byte[] requestData) {
        return "Hello, client!".getBytes();
    }

    @Override
    public void doStart(int port) {
        Vertx vertx = Vertx.vertx();

        //创建 TCP 服务器
        NetServer server = vertx.createNetServer();

        //处理请求
        server.connectHandler(new TcpServerHandler());
//        server.connectHandler(socket->{
//            //处理连接
//           socket.handler(buffer -> {
//               //处理接收到的字节数组
//               byte[] requestData = buffer.getBytes();
//               //自定义字节数组处理逻辑（如解析请求、调用服务、构造响应等）
//               byte[] responseData = handleRequest(requestData);
//               //发送响应
//               socket.write(Buffer.buffer(responseData));
//           });
//        });

        //启动 TCP 服务器并监听指定端口
        server.listen(port,result->{
           if(result.succeeded()){
               log.info("TCP server started on port {}", port);
           }else {
               log.info("Failed to start TCP server: {}", result.cause());
           }
        });
    }

    public static void main(String[] args) {
        new VertxTcpServer().doStart(8888);
    }
}
