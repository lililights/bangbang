package com.bitwin.bangbang.member.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;

import com.bitwin.bangbang.member.domain.Member;
import com.bitwin.bangbang.store.domain.Store;
import com.bitwin.bangbang.store.domain.StoreRegRequest;

@Service
public class MailSenderService {

	@Autowired
	private JavaMailSender sender;

	public int send(String email, String userName) {

		int resultCnt = 1;

		MimeMessage message = sender.createMimeMessage();

		try {

			// 메일 제목
			message.setSubject("[안내] " + userName + " 님 회원가입을 축하합니다.", "utf-8");

			// 메일 내용 : html
			String html = "<h1>회원가입을 축하합니다.</h1>";
			html += "<a href=\"http://localhost:8080/bangbang\">방방술래 바로가기</a> <br>";

			message.setText(html, "utf-8", "html");

			// from : 보내는 사람 설정 , 구글 정책은 setFrom 이 적용되지 않는다.
			message.setFrom(new InternetAddress("bitwin214@gamil.com"));

			// to : 받는 사람의 이메일 설정
			message.addRecipient(RecipientType.TO, new InternetAddress(email, userName + "님", "utf-8"));

			// 메일 발송
			sender.send(message);

		} catch (AddressException e) {
			System.out.println("메일발송 실패 : 이메일 형식에 맞지 않음!!!");
		} catch (SendFailedException e) {
			System.out.println("발송 실패 : " + e.getMessage());
		} catch (MailSendException e) {
			System.out.println("발송 실패 : " + e.getMessage());
		} catch (MessagingException | UnsupportedEncodingException e) {
			resultCnt = 0;
			e.printStackTrace();
		}

		return resultCnt;
	}

	public int sendStore(StoreRegRequest store, String pw) {
		int resultCnt = 1;

		MimeMessage message = sender.createMimeMessage();

		try {
			message.setSubject("[안내] " + store.getOname() + " 님 가맹점 계정이 등록되었습니다.", "utf-8");

			// 메일 내용 : html
			String html = "<h1>가맹점 등록에 감사드립니다.</h1>\r\n" + "<br>\r\n" + "<div>\r\n" + "  <table>\r\n"
					+ "    <thead>\r\n" + "      <tr>\r\n" + "        <th>가맹점 정보</th>\r\n" + "      </tr>\r\n"
					+ "    </thead>\r\n" + "    <tbody>\r\n" + "      <tr>\r\n" + "        <td>가맹점 이름</td>\r\n"
					+ "        <td>" + store.getSname() + "</td>\r\n" + "      </tr>\r\n" + "      <tr>\r\n"
					+ "        <td>가맹점 주소</td>\r\n" + "        <td>" + store.getAddress() + "</td>\r\n"
					+ "      </tr>\r\n" + "      <tr>\r\n" + "        <td>가맹점 전화번호</td>\r\n" + "        <td>"
					+ store.getSphone() + "</td>\r\n" + "      </tr>\r\n" + "      <tr>\r\n"
					+ "        <td>아이디</td>\r\n" + "        <td>" + store.getStoreId() + "</td>\r\n" + "      </tr>\r\n"
					+ "      <tr>\r\n" + "        <td>임시 비밀번호</td>\r\n" + "        <td>" + pw + "</td>\r\n"
					+ "      </tr>\r\n" + "    </tbody>\r\n" + "  </table>\r\n"
					+ "  <div>비밀번호를 변경하여 사용하시길 바랍니다.</div>\r\n" + "</div>";

			html += "<a href=\"http://localhost:8080/bangbang/login/store\">방방술래 가맹점 페이지 바로가기</a> <br>";

			message.setText(html, "utf-8", "html");

			// from : 보내는 사람 설정 , 구글 정책은 setFrom 이 적용되지 않는다.
			message.setFrom(new InternetAddress("bitwin214@gamil.com"));

			// to : 받는 사람의 이메일 설정
			message.addRecipient(RecipientType.TO,
					new InternetAddress(store.getOemail(), store.getOname() + "님", "utf-8"));

			// 메일 발송
			sender.send(message);
		} catch (AddressException e) {
			System.out.println("메일발송 실패 : 이메일 형식에 맞지 않음!!!");
		} catch (SendFailedException e) {
			System.out.println("발송 실패 : " + e.getMessage());
		} catch (MailSendException e) {
			System.out.println("발송 실패 : " + e.getMessage());
		} catch (MessagingException | UnsupportedEncodingException e) {
			resultCnt = 0;
			e.printStackTrace();
		}

		return resultCnt;
	}

	public int sendId(String email, String userid) {
		int resultCnt = 1;

		MimeMessage message = sender.createMimeMessage();

		try {

			// 메일 제목
			message.setSubject("[안내] 방방술래 아이디 찾기", "utf-8");

			// 메일 내용 : html
			String html = "<h1>아이디 찾기</h1>";
			html += "<table><tr><td>회원님의 아이디: </td><td>" + userid + "</td></tr></table><br>";
			html += "<a href=\"http://localhost:8080/bangbang/member/login\">방방술래 로그인 바로가기</a> <br>";

			message.setText(html, "utf-8", "html");

			// from : 보내는 사람 설정 , 구글 정책은 setFrom 이 적용되지 않는다.
			message.setFrom(new InternetAddress("bitwin214@gamil.com"));

			// to : 받는 사람의 이메일 설정
			message.addRecipient(RecipientType.TO, new InternetAddress(email, "회원님", "utf-8"));

			// 메일 발송
			sender.send(message);

		} catch (AddressException e) {
			System.out.println("메일발송 실패 : 이메일 형식에 맞지 않음!!!");
		} catch (SendFailedException e) {
			System.out.println("발송 실패 : " + e.getMessage());
		} catch (MailSendException e) {
			System.out.println("발송 실패 : " + e.getMessage());
		} catch (MessagingException | UnsupportedEncodingException e) {
			resultCnt = 0;
			e.printStackTrace();
		}

		return resultCnt;
	}

	public int sendPw(String email, String password) {
		int resultCnt = 1;

		MimeMessage message = sender.createMimeMessage();

		try {

			// 메일 제목
			message.setSubject("[안내] 방방술래 비밀번호 찾기", "utf-8");

			// 메일 내용 : html
			String html = "<h1>비밀번호 찾기</h1>";
			html += "<table><tr><td>임시 비밀번호: </td><td>" + password + "</td></tr></table><br>";
			html += "<a href=\"http://localhost:8080/bangbang/member/login?referer=http://localhost:8080/bangbang/member/mypage/edit/pw\">방방술래 로그인 바로가기</a> <br>";

			message.setText(html, "utf-8", "html");

			// from : 보내는 사람 설정 , 구글 정책은 setFrom 이 적용되지 않는다.
			message.setFrom(new InternetAddress("bitwin214@gamil.com"));

			// to : 받는 사람의 이메일 설정
			message.addRecipient(RecipientType.TO, new InternetAddress(email, "회원님", "utf-8"));

			// 메일 발송
			sender.send(message);

		} catch (AddressException e) {
			System.out.println("메일발송 실패 : 이메일 형식에 맞지 않음!!!");
		} catch (SendFailedException e) {
			System.out.println("발송 실패 : " + e.getMessage());
		} catch (MailSendException e) {
			System.out.println("발송 실패 : " + e.getMessage());
		} catch (MessagingException | UnsupportedEncodingException e) {
			resultCnt = 0;
			e.printStackTrace();
		}

		return resultCnt;
	}

}
