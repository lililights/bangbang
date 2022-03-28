package com.bitwin.bangbang;

import java.util.HashMap;
import org.json.simple.JSONObject;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

/**
 * @class ExampleSend
 * @brief This sample code demonstrate how to send sms through CoolSMS Rest API PHP
 */
public class smsSending {
  public static void main(String[] args, String phoneNum) {
    String api_key = "";
    String api_secret = "";
    Message coolsms = new Message(api_key, api_secret);

    
    
    // 4 params(to, from, type, text) are mandatory. must be filled
    HashMap<String, String> params = new HashMap<String, String>();
    params.put("to", phoneNum);
    params.put("from", "01037224175");
    params.put("type", "SMS");
    params.put("text", "방방술래에 보내주신 1:1 문의 답변이 완료되었습니다.");
    params.put("app_version", "test app 1.2"); // application name and version

    try {
      JSONObject obj = (JSONObject) coolsms.send(params);
      System.out.println(obj.toString());
    } catch (CoolsmsException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getCode());
    }
  }
}
