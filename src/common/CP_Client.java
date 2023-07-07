//package common;
//
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.Socket;
//import java.net.SocketException;
//import java.util.ArrayList;
//
//import Pay.Pay_DAO;
//import Pay.Pay_VO;
//import Ticket.Ticket_DAO;
//import Ticket.Ticket_VO;
//
//public class CP_Client extends Thread {
//    // 클라이언트와의 소켓 연결과 DB_Server 객체에 대한 참조를 저장하는 변수
//	Socket s;
//    DB_Server server;
//
//    // 객체 직렬화를 위한 입출력 스트림
//    ObjectInputStream in;
//    ObjectOutputStream out;
//    String ip;
//    int result;
//    
//    public static String currentUserId;
//
//    // CP_Client 생성자
//    // 입출력 스트림 생성
//    public CP_Client(Socket s, DB_Server server) {
//        this.s = s;
//        this.server = server;
//        try {
//            in = new ObjectInputStream(s.getInputStream());
//            out = new ObjectOutputStream(s.getOutputStream());
//        } catch (Exception e) {
//        }
//    }
//
//    @Override
//    public void run() {
//        try {
//            esc: while (true) {
//                Object obj = in.readObject();
//				if (obj != null) {
//					Protocol p = (Protocol) obj;
//					switch (p.getCmd()) {
//					case 100:
//						System.out.println("결제하기창 닫기 클릭! CP_Client");
//						
//						out.writeObject(p);
//						out.flush();
//						break esc;
//                    case 102: // 로그인한 회원의 잔여 포인트 가져오기
//                    	System.out.println("===CP_Client의 case 102===");
//                    	
//                    	currentUserId = Session.getCurrentUserId();
//                    	int chargepoint = Pay_DAO.getRemainingPoints(currentUserId);
//                    	p.setResult(chargepoint);
//                    	out.writeObject(p);
//                        out.flush();
//                        break;
//                    case 103: // 결제 완료 후 티켓 INSERT
//                    	System.out.println("===CP_Client의 case 103===");
//
//                    	Pay_VO pay_vo = p.getPay_vo();
//                    	result = Pay_DAO.getInsert(pay_vo);
//                    	p.setResult(result); // DB 삽입 작업의 결과를 설정
//                    	System.out.println(result + "예매 완료!");
//                    	out.writeObject(p);
//                    	out.flush();
//                    	break;
//                    case 104: // 현재 로그인 회원의 티켓 리스트 출력
//                    	System.out.println("===CP_Client의 case 104===");
//                    	
//                    	currentUserId = Session.getCurrentUserId();
//                    	Ticket_DAO ticketDAO = new Ticket_DAO();
//                		ArrayList<Ticket_VO> ticketList = ticketDAO.getTicketList(currentUserId);
//                		System.out.println("티켓 리스트 가져오기 성공");
//                		p.setList(ticketList);
//                    	out.writeObject(p);
//                    	out.flush();
//                    	break;
//					}
//				}
//            }
//        } catch (SocketException se) {
//            System.out.println("서버와의 연결이 종료되었습니다.");
//        } catch (IOException e) {
//            System.out.println("I/O error: " + e);
//            e.printStackTrace();
//        } catch (Exception e) {
//            System.out.println("Exception in CP_Client: " + e);
//            e.printStackTrace();
//        } finally {
//            try {
//                if(out != null) {
//                    out.flush(); // 먼저 아직 전송되지 않은 데이터를 전송합니다.
//                    out.close();
//                }
//                if(in != null) in.close();
//                if(s != null) s.close();
//            } catch (Exception e) {
//                System.out.println("Exception when closing resources: " + e);
//                e.printStackTrace();
//            }
//        }
//    }
//}
