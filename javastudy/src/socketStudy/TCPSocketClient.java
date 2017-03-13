package socketStudy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPSocketClient {

	public static void main(String[] args){
		try (Socket socket = new Socket("localhost", 9479);
				OutputStream os = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(os);
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				Scanner sc = new Scanner(System.in)) {
			//			pw.write("姓名：陈忱2；性别：男");
			//			pw.flush();
			int i = 0;
			System.out.println("请输入客户端输入内容：");
			while (i == 0) {
				while (sc.hasNext()) {
					pw.write("客户端说：" + sc.next());
					pw.flush();
					i = 1;
					break;
				}
			}
			socket.shutdownOutput();//不关闭永远不会往下走
			String content = null;
			while ((content = br.readLine()) != null) {
				System.out.println(content);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
