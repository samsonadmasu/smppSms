package et.com.smpp.services.BulkServices;

import et.com.smpp.OutDTOs.msgSendResponseDTO;
import et.com.smpp.dao.*;
import et.com.smpp.model.BulkMessage;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;


@Startup
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

    @Deprecated
    public void sendSMS(String message, String phone,int moMt) throws Exception
    {
        String cleanPhone = cleanPhone(phone);
          String url = "http://196.189.53.129:12213/cgi-bin/sendsms?username=atlas&password=atlas@1234&from=8748&&to=" + cleanPhone+"&text=" + URLEncoder.encode(message);
          URL obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuffer response = new StringBuffer();
        String inputLine;
        while ((inputLine = in.readLine()) != null)
        {

         //   response.append(inputLine).toString();
            System.out.println(response.append(inputLine.charAt(0)) + "-------------------------");
        }
        in.close();
    }


    private String cleanPhone(String phone)
    {
        String clean = phone.replace("+251", "0");
        clean = clean.replace("(", "");
        clean = clean.replace(")", "");
        return clean;
    }
}
