package et.com.smpp.EndPoints.AdminEndPoints;

import et.com.smpp.OutDTOs.OutGetCatagoryDTO;
import et.com.smpp.OutDTOs.SendPrivateMsgOutDTO;
import et.com.smpp.services.AdminServices.AdminGetServices;
import et.com.smpp.services.AdminServices.SendPrivateMassageService;
import io.swagger.annotations.Api;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import java.util.List;

@RequestScoped
@Path("/SendPrivateMassage")
@Api(value = "send Private Massage")
public class SendPrivateMassageEndPoint {

    @PersistenceContext(unitName = "smppSms-persistence-unit")
    private EntityManager em;


    @EJB
    SendPrivateMassageService sendPrivateMassageService;

    @Path("/SendPrivateMessage")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @RolesAllowed("Admin")
    public SendPrivateMsgOutDTO sendPrivateMsgOutDto(SendPrivateMsgOutDTO sendPrivateMsgOutDTO) {
        {
            return this.sendPrivateMassageService.sendPrivateMsgOutDTO(sendPrivateMsgOutDTO);
        }
    }
    //@QueryParam("phoneNumber") String phoneNumber,
    //                                                     @QueryParam("phoneNumber") String message
}