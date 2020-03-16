package et.com.smpp.EndPoints.SubscribtionEndPoints;

import et.com.smpp.InDTOs.InDeliveryReportDTO;
import et.com.smpp.InDTOs.InSubscriptioDTO;
import et.com.smpp.services.BulkServices.SubscrptionService;
import io.swagger.annotations.Api;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import java.util.Date;

@RequestScoped
@Path("/Subscription")
@Api(value = "Get Subscription")
public class GetSubscribtionEndPoint {

    @EJB
    SubscrptionService subscrptionService;

    @Path("/writeSMS")
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    public InSubscriptioDTO registerSMSTest(
            @QueryParam("sender") String sender,
            @QueryParam("reciever") String reciever,
            @QueryParam("message") String message
    )
    {
        InSubscriptioDTO subscriptionSMSRequestDto = new InSubscriptioDTO();
        subscriptionSMSRequestDto.setSender(sender);
        subscriptionSMSRequestDto.setReciever(reciever);
        subscriptionSMSRequestDto.setMessage(message);
        this.subscrptionService.RegisterSubscription(subscriptionSMSRequestDto);
        return subscriptionSMSRequestDto;

        //http://localhost:8080/smppSms/rest/Subscription/writeSMS?sender=12&reciever=12&message=12


    }


    @Path("/getDelivery")
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    public InDeliveryReportDTO getDelivery(
            @QueryParam("sender") String sender)
    {
        InDeliveryReportDTO inDeliveryReportDTO = new InDeliveryReportDTO();
        inDeliveryReportDTO.setSender(sender);
         this.subscrptionService.getDelivery(inDeliveryReportDTO);
        return inDeliveryReportDTO;

        //http://localhost:8080/smppSms/rest/Subscription/writeSMS?sender=%d
    }
}
