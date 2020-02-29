package et.com.smpp.EndPoints.BulkEndPoints;

import et.com.smpp.OutDTOs.ResponseMessageDTO;
import et.com.smpp.services.BulkServices.PrepareMessageForSendService;
import io.swagger.annotations.Api;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;

@RequestScoped
@Path("/prepareInternalBulk")
@Api(value = "prepareInternalBulk")
public class InternalBulkPrepareEndPoint {

    @EJB
    PrepareMessageForSendService prepareMessageForSendService;

    @Path("/PrepareInternalBulk")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public ResponseMessageDTO PrepareInternalBulk(@QueryParam("id") long id) {
        return this.prepareMessageForSendService.PrepareInternalBulk(id);
    }
}
