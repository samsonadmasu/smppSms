package et.com.smpp.EndPoints.BulkEndPoints;

import et.com.smpp.OutDTOs.ResponseMessageDTO;
import et.com.smpp.services.BulkServices.PrepareMessageForSendService;
import io.swagger.annotations.Api;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;

@RequestScoped
@Path("/SendBulk")
@Api(value = "SendBulk")

public class SendBulkEndPoint {

    @EJB
    PrepareMessageForSendService prepareMessageForSendService;

    @Path("/Send")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public ResponseMessageDTO mangeSend(@QueryParam("id") Long id) {
        return this.prepareMessageForSendService.Send(id);
    }


    @Path("/SendInternalBulk")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public ResponseMessageDTO mangeSendInternalBulk() {
        return this.prepareMessageForSendService.SendInternalBulk();

    }


    @Path("/SendExternalBulk")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public ResponseMessageDTO SendExternalBulk() {
        return this.prepareMessageForSendService.SendExternalBulk();

    }


}
