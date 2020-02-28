package et.com.smpp.EndPoints.BulkEndPoints;

import et.com.smpp.InDTOs.InBulkSMSDTO;
import et.com.smpp.InDTOs.InFindByIdDTO;
import et.com.smpp.InDTOs.InRegisterCatagoryDTO;

import et.com.smpp.OutDTOs.ResponseMessageDTO;
import et.com.smpp.services.AdminServices.AdminRegisterServices;
import et.com.smpp.services.BulkServices.PrepareMessageForSendService;
import io.swagger.annotations.Api;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import java.util.List;
@RequestScoped
@Path("/prepareBulk")
@Api(value = "prepare Bulk")
public class PrepareBulkEndPoints {
    @EJB
    PrepareMessageForSendService prepareMessageForSendService;


    @Path("/Prepare")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public ResponseMessageDTO prepareSend(@QueryParam("id") long id){
        return this.prepareMessageForSendService.PrepareBulk(id);
    }


    @Path("/Test")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public ResponseMessageDTO mangeTest() {
        return this.prepareMessageForSendService.ReChooserSendFornewSubscribures();
    }

}
