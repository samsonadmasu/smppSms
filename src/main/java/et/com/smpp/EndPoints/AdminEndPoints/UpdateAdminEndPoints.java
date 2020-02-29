package et.com.smpp.EndPoints.AdminEndPoints;

import et.com.smpp.InDTOs.*;
import et.com.smpp.OutDTOs.ResponseMessageDTO;
import et.com.smpp.services.AdminServices.UpdateAdminServices;
import et.com.smpp.services.BulkServices.PrepareMessageForSendService;
import io.swagger.annotations.Api;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@RequestScoped
@Path("/AdminUpdate")
@Api(value = "update Admin")
public class UpdateAdminEndPoints {

    @EJB
    UpdateAdminServices updateAdminServices;

    @Path("/updateCatagory")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public InUpdateCatagoryDTO updateCatagory(InUpdateCatagoryDTO inUpdateCatagoryDto) {
        return this.updateAdminServices.updateCatagory(inUpdateCatagoryDto);
    }

    @Path("/updaterMessage")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public InUpdateMessageDTO updaterMessage(InUpdateMessageDTO inUpdateMessageDto) {
        return this.updateAdminServices.updaterMessage(inUpdateMessageDto);
    }

    @Path("/updateCatagoryIn")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public UpdateCatagoryStatusDTO updateCatagoryInStatus(UpdateCatagoryStatusDTO updateCatagoryStatusDTO) {
        return this.updateAdminServices.updateCatagoryInStatus(updateCatagoryStatusDTO);
    }


    @Path("/updateInternalBulk")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public InRegisterInternalBulkDTO UpdateInternalBulk(InRegisterInternalBulkDTO inRegisterInternalBulkDTO) {
        return this.updateAdminServices.updateInternalBulk(inRegisterInternalBulkDTO);
    }

    @Path("/updaterStaff")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public InUpdateStaffDTO updaterStaff(InUpdateStaffDTO inUpdateStaffDto) {
        return this.updateAdminServices.updaterStaff(inUpdateStaffDto);
    }
}
