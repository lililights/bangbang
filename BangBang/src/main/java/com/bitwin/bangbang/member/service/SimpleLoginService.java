package com.bitwin.bangbang.member.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitwin.bangbang.member.dao.MemberDao;
import com.bitwin.bangbang.member.domain.KakaoInfo;
import com.bitwin.bangbang.member.domain.LoginInfo;
import com.bitwin.bangbang.member.domain.Member;
import com.bitwin.bangbang.member.domain.NaverInfo;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class SimpleLoginService {

	private MemberDao dao;

	@Autowired
	private SqlSessionTemplate template;

	public String getAccessToken(String snsname, String authorize_code) {
		// 카카오 간편 로그인일 경우
		String access_Token = "";
		String refresh_Token = "";
		if (snsname.equals("kakao")) {
			KakaoInfo kakao = new KakaoInfo();
			String reqURL = "https://kauth.kakao.com/oauth/token";
			try {
				URL url = new URL(reqURL);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();

				// POST 요청을 위해 기본값이 false인 setDoOutput을 true로
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);

				// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
				StringBuilder sb = new StringBuilder();
				sb.append("grant_type=authorization_code");
				sb.append("&client_id=" + kakao.getClient_id());
				sb.append("&redirect_uri=" + kakao.getRedirect_uri());
				sb.append("&code=" + authorize_code);
				bw.write(sb.toString());
				bw.flush();

				// 결과 코드가 200이라면 성공
				int responseCode = conn.getResponseCode();
				System.out.println("responseCode : " + responseCode);

				// 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line = "";
				String result = "";

				while ((line = br.readLine()) != null) {
					result += line;
				}
				System.out.println("response body : " + result);

				// Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
				JsonParser parser = new JsonParser();
				JsonElement element = parser.parse(result);

				access_Token = element.getAsJsonObject().get("access_token").getAsString();
				refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

				System.out.println("access_token : " + access_Token);
				System.out.println("refresh_token : " + refresh_Token);

				br.close();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (snsname.equals("naver")) {
			NaverInfo naver = new NaverInfo();
			String reqURL = "https://nid.naver.com/oauth2.0/token";
			try {
				URL url = new URL(reqURL);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();

				// POST 요청을 위해 기본값이 false인 setDoOutput을 true로
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);

				// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
				StringBuilder sb = new StringBuilder();
				sb.append("grant_type=authorization_code");
				sb.append("&client_id=" + naver.getClient_id());
				sb.append("&client_secret=" + naver.getClient_secret());
				sb.append("&redirect_uri=" + naver.getRedirect_uri());
				sb.append("&code=" + authorize_code);
				bw.write(sb.toString());
				bw.flush();

				// 결과 코드가 200이라면 성공
				int responseCode = conn.getResponseCode();
				System.out.println("responseCode : " + responseCode);

				// 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line = "";
				String result = "";

				while ((line = br.readLine()) != null) {
					result += line;
				}
				System.out.println("response body : " + result);

				// Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
				JsonParser parser = new JsonParser();
				JsonElement element = parser.parse(result);

				access_Token = element.getAsJsonObject().get("access_token").getAsString();
				refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

				System.out.println("access_token : " + access_Token);
				System.out.println("refresh_token : " + refresh_Token);

				br.close();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return access_Token;
	}

	public HashMap<String, Object> getUserInfo(String snsname, String access_Token) {

		// 요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
		HashMap<String, Object> userInfo = new HashMap<>();
		if (snsname.equals("kakao")) {
			String reqURL = "https://kapi.kakao.com/v2/user/me";

			try {
				URL url = new URL(reqURL);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");

				// 요청에 필요한 Header에 포함될 내용
				conn.setRequestProperty("Authorization", "Bearer " + access_Token);

				int responseCode = conn.getResponseCode();
				System.out.println("responseCode : " + responseCode);

				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

				String line = "";
				String result = "";

				while ((line = br.readLine()) != null) {
					result += line;
				}
				System.out.println("response body : " + result);

				JsonParser parser = new JsonParser();
				JsonElement element = parser.parse(result);

				JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
				System.out.println("properties:" + properties);
				JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

				String nickname = properties.getAsJsonObject().get("nickname").getAsString();
				String profile = properties.getAsJsonObject().get("profile_image").getAsString();
				String email = kakao_account.getAsJsonObject().get("email").getAsString();
				String range = kakao_account.getAsJsonObject().get("age_range").getAsString();

				userInfo.put("nickname", nickname);
				userInfo.put("profile", profile);
				userInfo.put("email", email);
				userInfo.put("reage", range);

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else if (snsname.equals("naver")) {
			String reqURL = "https://openapi.naver.com/v1/nid/me";

			try {
				URL url = new URL(reqURL);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");

				// 요청에 필요한 Header에 포함될 내용
				conn.setRequestProperty("Authorization", "Bearer " + access_Token);

				int responseCode = conn.getResponseCode();
				System.out.println("responseCode : " + responseCode);

				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

				String line = "";
				String result = "";

				while ((line = br.readLine()) != null) {
					result += line;
				}
				System.out.println("response body : " + result);

				JsonParser parser = new JsonParser();
				JsonElement element = parser.parse(result);

				JsonObject properties = element.getAsJsonObject().get("response").getAsJsonObject();
				System.out.println("properties:" + properties);
				//JsonObject naver_account = element.getAsJsonObject().get("naver_account").getAsJsonObject();

				String nickname = properties.getAsJsonObject().get("name").getAsString();
				String profile = properties.getAsJsonObject().get("profile_image").getAsString();
				String email = properties.getAsJsonObject().get("email").getAsString();
				String range = properties.getAsJsonObject().get("age").getAsString();
				String phonenum = properties.getAsJsonObject().get("mobile").getAsString();

				userInfo.put("nickname", nickname);
				userInfo.put("profile", profile);
				userInfo.put("email", email);
				userInfo.put("reage", range);
				userInfo.put("phonenum", phonenum);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return userInfo;
	}

	public int checkEmail(String email) {
		int resultCnt = 0;

		dao = template.getMapper(MemberDao.class);

		resultCnt = dao.selectCountByEmail(email);

		return resultCnt;

	}

	public LoginInfo getLoginInfo(String email) {
		LoginInfo loginInfo = null;

		dao = template.getMapper(MemberDao.class);

		loginInfo = dao.selectByEmail(email);

		return loginInfo;
	}
}
