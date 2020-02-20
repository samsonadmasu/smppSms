package et.com.smpp.EndPoints.AdminEndPoints;
import et.com.smpp.OutDTOs.EthioTelLogListOutDTO;
import et.com.smpp.OutDTOs.GetSubscribesDTO;
import et.com.smpp.OutDTOs.OutGetCatagoryDTO;
import et.com.smpp.OutDTOs.OutMessageDTO;
import et.com.smpp.services.AdminServices.AdminGetServices;
import io.swagger.annotations.Api;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import java.util.List;

@RequestScoped
@Path("/getAdmin")
@Api(value = "Get Admin")
public class GetAdminEndPoints {

    @PersistenceContext(unitName = "smppSms-persistence-unit")
    private EntityManager em;

    @EJB
    AdminGetServices adminGetServices;

    @Path("/listCatagory")
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @RolesAllowed("Admin")
    public List<OutGetCatagoryDTO> listCatagory() {
        {
            return this.adminGetServices.listCatagory();
        }
    }

    @Path("/listMessage")
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public List<OutMessageDTO> listMessage(){
        {
            return this.adminGetServices.listMessage();
        }
    }

    @Path("/listSubscriberActive")
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public List<GetSubscribesDTO> listSubscriberActive(){
        {
            return this.adminGetServices.listSubscriberActive();
        }
    }

    @Path("/listSubscriberDeactive")
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public List<GetSubscribesDTO> listSubscriberDeactive(){
        {
            return this.adminGetServices.listSubscriberDeactive();
        }
    }



    @Path("/ethioTelLogListOut")
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public List<EthioTelLogListOutDTO> ethioTelLogListOut(@QueryParam("phoneNumber") String phoneNumber){
        {
            return this.adminGetServices.ethioTelLogListOut(phoneNumber);
        }
    }
}
