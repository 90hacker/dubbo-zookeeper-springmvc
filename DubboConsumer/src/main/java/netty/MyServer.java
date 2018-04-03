package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.socket.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class MyServer {

	private final int port;

	public MyServer(int port) {
		this.port = port;
	}

	public void run() throws Exception {
		ServerBootstrap server = new ServerBootstrap();
		try {
			server.group(new NioEventLoopGroup(), new NioEventLoopGroup())
					.channel(NioServerSocketChannel.class).localAddress(port)
					.childHandler(new DispatcherServletChannelInitializer());

			server.bind().sync().channel().closeFuture().sync();
            System.out.println("启动成功...");
        } finally {
			server.shutdown();
		}
	}

	public static void main(String[] args) throws Exception {
        System.out.println("启动中...");
		int port;
		if (args.length > 0) {
			port = Integer.parseInt(args[0]);
		} else {
			port = 8089;
		}
		new MyServer(port).run();
	}
}
