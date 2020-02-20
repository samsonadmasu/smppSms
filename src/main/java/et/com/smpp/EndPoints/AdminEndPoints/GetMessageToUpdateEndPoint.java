package et.com.smpp.EndPoints.AdminEndPoints;

import et.com.smpp.OutDTOs.EthioTelLogListOutDTO;
import et.com.smpp.OutDTOs.OutMessageDTO;
import et.com.smpp.services.AdminServices.AdminGetServices;
import io.swagger.annotations.Api;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import java.util.List;

@RequestScoped
@Path("/getMessageToUpdate")
@Api(value = "Get Admin")
public class GetMessageToUpdateEndPoint {

    @PersistenceContext(unitName = "smppSms-persistence-unit")
    private EntityManager em;

    @EJB
    AdminGetServices adminGetServices;

    @Path("/GetMessageToUpdate")
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public List<OutMessageDTO> listMessageByCatagory(@QueryParam("id") Long id){
        {
            return this.adminGetServices.listMessageByCatagory(id);
        }
    }

}
