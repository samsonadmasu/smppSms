package et.com.smpp.services.AdminServices;

import et.com.smpp.OutDTOs.SendPrivateMsgOutDTO;

import et.com.smpp.dao.*;
import et.com.smpp.model.SmppNumber;


import javax.ejb.EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;


@Stateless
public class SendPrivateMassageService {
    @EJB
    et.com.smpp.dao.BulkMessageDao BulkMessageDao;

    @EJB
    et.com.smpp.dao.CatagoryTableDao CatagoryTableDao;

    @EJB
    MessageTableDao messagetableDao;

    @EJB
    SubscribtionTableDao subscribtiontableDao;

    @EJB
    RoleDao roleDao;

    @EJB
    StaffDao staffDao;

    @EJB
    SmppNumberDao smppNumberDao;

    @PersistenceContext(unitName = "smppSms-persistence-unit")
    private EntityManager em;


    public SendPrivateMsgOutDTO sendPrivateMsgOutDTO(SendPrivateMsgOutDTO sendPrivateMsgOutDTO) {
        try { SmppNumber smppNumber = this.smppNumberDao.mo();


            sendSMS(sendPrivateMsgOutDTO.getMessage(), sendPrivateMsgOutDTO.getPhoneNumber(),smppNumber.getMo(),smppNumber.getIpAdress(),smppNumber.getUsername(),smppNumber.getPassword());
       } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
return sendPrivateMsgOutDTO;
    }

    @Deprecated
    private void sendSMS(String message, String phone, int mo, String ipAdress, String username, String password) throws Exception
    {
        //http://196.189.53.129:12213
        String cleanPhone = cleanPhone(phone);
        String url = ipAdress+"/cgi-bin/sendsms?username="+username+"&password="+password+"&from="+mo+"&&to=" + cleanPhone+"&text=" + URLEncoder.encode(message);
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
