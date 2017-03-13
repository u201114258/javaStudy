package socketStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPSocketServer {

	public static void main (String[] args){
		//注意此种写法必须保证创建的资源都实现了autoclosable接口，刚刚查看api发现以下资源都实现
		try(//创建一个socket，端口号为9479
				ServerSocket ss = new ServerSocket(9479);
				//调用accept()方法进行监听，若有客户端连接端口号为9479的这个socket，就获取它
//				Socket socket = ss.accept();
				//获取输入信息
//				InputStream is = socket.getInputStream();
//				InputStreamReader isr = new InputStreamReader(is);
//				BufferedReader br = new BufferedReader(isr);
//				OutputStream os = socket.getOutputStream();
//				PrintWriter pw = new PrintWriter(os);
				){
			System.out.println("********服务器端已启动，等待客户端连接*****");
//			String content = null;
//			while ((content = br.readLine()) != null){
//				System.out.println(content);
//			}
//			socket.shutdownInput();//不关闭永远不会往下走
//			pw.write("test");
//			pw.flush();
			while(true){
				Socket socket = ss.accept();
				TCPSocketServerThread tcpsst = new TCPSocketServerThread(socket);
				tcpsst.run();
				socket.close();
			}
		}catch (IOException ie){
			ie.printStackTrace();
		}
	}
}

class TCPSocketServerThread implements Runnable{
	private Socket socket;
	public TCPSocketServerThread(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		try (
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				OutputStream os = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(os);
				Scanner sc = new Scanner(System.in)){

			String content = null;
			while (content == null){
				content = br.readLine();
			}
			System.out.println("客户端说：" + content);
			socket.shutdownInput();
			System.out.println("请输入回复内容：");
			while (true){
				while (sc.hasNext()){
					pw.write("服务器已收到该信息！服务器说：" + sc.next());
					pw.flush();
					socket.shutdownOutput();
					sc.close();
					return;
				}
			}
//			pw.write("test");
//			pw.flush();
		} catch (IOException ioe){
			ioe.printStackTrace();
		}
	}
}
