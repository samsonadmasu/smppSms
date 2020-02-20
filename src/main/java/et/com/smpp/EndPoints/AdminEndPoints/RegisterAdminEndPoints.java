package et.com.smpp.EndPoints.AdminEndPoints;

import et.com.smpp.InDTOs.InMessageRegisterDTO;
import et.com.smpp.InDTOs.InRegisterCatagoryDTO;
import et.com.smpp.InDTOs.InRegisterRoleDTO;
import et.com.smpp.InDTOs.InRegisterStaffDTO;
import et.com.smpp.services.AdminServices.AdminRegisterServices;
import io.swagger.annotations.Api;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;

@RequestScoped
@Path("/Subscription")
@Api(value = "register Admin")
public class RegisterAdminEndPoints {

    @PersistenceContext(unitName = "smppSms-persistence-unit")
    private EntityManager em;

    @Inject AdminRegisterServices adminRegisterServices;

    @Path("/RegisterCatagory")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @RolesAllowed("Admin")
    public InRegisterCatagoryDTO RegisterCatagory(InRegisterCatagoryDTO inRegisterCatagoryDto) {
        return this.adminRegisterServices.RegisterCatagory(inRegisterCatagoryDto);
    }

    @Path("/RegisterMessage")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public InMessageRegisterDTO RegisterMessage(InMessageRegisterDTO inMessageRegisterDto) {
        return this.adminRegisterServices.RegisterMessage(inMessageRegisterDto);
    }

    @Path("/RegisterStaff")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public InRegisterStaffDTO RegisterStaff(InRegisterStaffDTO inRegisterStaffDto) {
        return this.adminRegisterServices.RegisterStaff(inRegisterStaffDto);
    }

    @Path("/RegisterRole")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public InRegisterRoleDTO RegisterRole(InRegisterRoleDTO inRegisterRoleDto) {
        return this.adminRegisterServices.RegisterRole(inRegisterRoleDto);
    }
}
