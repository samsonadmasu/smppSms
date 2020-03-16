package et.com.smpp.services.BulkServices;

import et.com.smpp.OutDTOs.ResponseMessageDTO;
import et.com.smpp.dao.*;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


@Stateless
public class MessageSendService {
    @EJB
    BulkMessageDao BulkMessageDao;

    @EJB
    CatagoryTableDao CatagoryTableDao;

    @EJB
    MessageTableDao messagetableDao;

    @EJB
    SubscribtionTableDao subscribtiontableDao;

    @EJB
    StaffDao staffDao;

    @EJB
    RoleDao roleDao;

    @PersistenceContext(unitName = "smppSms-persistence-unit")
    private EntityManager em;


    public ResponseMessageDTO sendSMS(String message, String phone, int moMt, String ipAdress, String username, String password) throws Exception

    {
        String cleanPhone = cleanPhone(phone);
      //  String url = ipAdress+"/cgi-bin/sendsms?username="+username+"&password="+password+"&from="+moMt+"&&to=" + cleanPhone+"&text=" + URLEncoder.encode(message);
        String url = ipAdress+"/cgi-bin/sendsms?username="+username+"&password="+password+"&from="+moMt+"&&to=" + cleanPhone+"&text=" + URLEncoder.encode(message);
        URL obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        con.setRequestMethod("GET");



        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuffer response = new StringBuffer();


    try {

        String msgResponse = in.readLine();
        System.out.println(String.format("response for %s --- msg %s",cleanPhone,msgResponse));
        if (msgResponse.contains("0: Accepted for delivery")){
            return new ResponseMessageDTO(true,"yes");
        }

        if (in!=null){
            in.close();
        }
        return new ResponseMessageDTO(false, "no!");
    } catch (Exception e) {
        e.printStackTrace();
        return new ResponseMessageDTO(false, "no!");
    }

    }


    private String cleanPhone(String phone)
    {
        String clean = phone.replace("+251", "0");
        clean = clean.replace("(", "");
        clean = clean.replace(")", "");
        return clean;
    }
}

/*
* String url = "http://"+server+":"+port+"/cgi-bin/sendsms?username="+username+"&password="+password+"&from="+shortNumber+"&&to="
            + phone + "&text=" + URLEncoder.encode(message)+"&coding=2&charset=UTF-8";



        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        StringBuffer response = new StringBuffer();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
          response.append(inputLine);
          System.out.println("SSSSSSSSSSSMMMMMMMMMMMSSSSSSSSSSS " + response);
        }
        in.close();
*
* */