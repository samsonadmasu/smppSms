package et.com.smpp.EndPoints.BulkEndPoints;

import et.com.smpp.OutDTOs.ResponseMessageDTO;
import et.com.smpp.services.BulkServices.PrepareMessageForSendService;
import io.swagger.annotations.Api;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    public ResponseMessageDTO mangeSend() {
        return this.prepareMessageForSendService.Send();
    }

}
