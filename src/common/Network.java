package common;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Network implements Runnable {
    // 접속하기 위해 필요한 것들
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Socket s;

    // 서버 연결 메서드
    public void connected() {
        try {
            // 집: 192.168.0.11
        	// 학원: 192.168.0.78
        	// 집2:192.168.31.8
            s = new Socket("192.168.0.78", 7789);
            out = new ObjectOutputStream(s.getOutputStream());
            in = new ObjectInputStream(s.getInputStream());
            new Thread(this).start();
        } catch (Exception e) {
            System.out.println("connected error" + e);
        }
    }

    // 서버 연결 해제 메서드
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
        // 추가적인 코드 작성 필요
    }
}
