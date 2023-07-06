package common;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//싱글톤 패턴
public class Network implements Runnable {
	private static Network instance;

    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Socket s;

    private Network() {
        // Network 클래스의 초기화 작업 수행
    }

    public static synchronized Network getInstance() {
        if (instance == null) {
            instance = new Network();
        }
        return instance;
    }

    public void connected() {
        try {
        	// 학원: 192.168.0.78
        	// 집:192.168.0.11
            s = new Socket("192.168.0.78", 7789);
            out = new ObjectOutputStream(s.getOutputStream());
            in = new ObjectInputStream(s.getInputStream());
        } catch (Exception e) {
            System.out.println("connected error" + e);
        }
    }

    public synchronized void closed() {
        try {
            if (out != null) {
                out.close();
                out = null;
            }
            if (in != null) {
                in.close();
                in = null;
            }
            if (s != null && !s.isClosed()) {
                s.close();
                s = null;
            }
            System.out.println("프로그램 종료");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObjectInputStream getIn() {
        return in;
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public Socket getS() {
        return s;
    }

    public void sendProtocol(Protocol p) {
        try {
            if (out != null) {
                System.out.println("sendProtocol 했다!");
                out.writeObject(p);
                out.flush();
            } else {
                System.out.println("ObjectOutputStream is null");
            }
        } catch (IOException e) {
            System.out.println("Error sending protocol: " + e.getMessage());
            e.printStackTrace();
        }
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}