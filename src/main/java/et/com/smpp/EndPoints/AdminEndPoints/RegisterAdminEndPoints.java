package et.com.smpp.EndPoints.AdminEndPoints;

import et.com.smpp.InDTOs.*;
import et.com.smpp.InDTOs.subscription.InMessageTestDTO;
import et.com.smpp.services.AdminServices.AdminRegisterServices;
import et.com.smpp.services.AdminServices.DataMapper;
import et.com.smpp.services.security.AuthRegisterServices;
import io.swagger.annotations.Api;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import java.util.List;

@RequestScoped
@Path("/Subscription")
@Api(value = "register Admin")
public class RegisterAdminEndPoints {

    @PersistenceContext(unitName = "smppSms-persistence-unit")
    private EntityManager em;

    @Inject AdminRegisterServices adminRegisterServices;

    @Inject
    AuthRegisterServices authRegisterServices;

    @EJB
    DataMapper dataMapper;

    @Path("/RegisterCatagory")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public InRegisterCatagoryDTO RegisterCatagory(InRegisterCatagoryDTO inRegisterCatagoryDto) {
        return this.adminRegisterServices.RegisterCatagory(inRegisterCatagoryDto);
    }


    @Path("/RegisterInternalBulk")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public InRegisterInternalBulkDTO RegisterInternalBulk(InRegisterInternalBulkDTO inRegisterInternalBulkDTO) {
        return this.adminRegisterServices.RegisterInternalBulk(inRegisterInternalBulkDTO);
    }


    @Path("/RegisterMessage")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public InMessageRegisterDTO RegisterMessage(InMessageRegisterDTO inMessageRegisterDto) {
        return this.adminRegisterServices.RegisterMessage(inMessageRegisterDto);
    }

    @Path("/registerTest")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public InMessageTestDTO registerTest(InMessageTestDTO inMessageTestDTO){
        return this.adminRegisterServices.registerTest(inMessageTestDTO);
    }


    @Path("/RegisterStaff")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public InRegisterStaffDTO RegisterStaff(InRegisterStaffDTO inRegisterStaffDto) {
     InRegisterStaffDTO inRegisterStaffDTOA = this.adminRegisterServices.RegisterStaff(inRegisterStaffDto);
   //  if(inRegisterStaffDTOA.isRegistrationStatus()){
         return this.authRegisterServices.registeStaffToAuth(inRegisterStaffDTOA);
    // }else return inRegisterStaffDTOA;
    }

    @Path("/RegisterRole")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public InRegisterRoleDTO RegisterRole(InRegisterRoleDTO inRegisterRoleDto) {
        return this.adminRegisterServices.RegisterRole(inRegisterRoleDto);
    }

    @Path("/registerBlackList")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public InBlackListDTO registerBlackList(InBlackListDTO inBlackListDTO){
        return this.adminRegisterServices.registerBlackList(inBlackListDTO);
    }


    // upload excel
    @Path("/listPhoneNumber")
    @POST
    @Produces("application/json")
    @Consumes("multipart/form-data")
    @PermitAll
    public List<PhoneNumber> listPhoneNumber(@MultipartForm FileUploadForm form) {
        return this.dataMapper.listPhoneNumber(form);
    }
}
