package et.com.smpp.EndPoints.AdminEndPoints;

import et.com.smpp.InDTOs.subscription.SubscriptionDTOInt;
import et.com.smpp.InDTOs.subscription.SubscriptionQueryDTO;
import et.com.smpp.OutDTOs.EthioTelLogListOutDTO;
import et.com.smpp.services.AdminServices.AdminGetServices;
import et.com.smpp.services.AdminServices.ReportService;
import io.swagger.annotations.Api;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import java.util.List;

@RequestScoped
@Path("/Report")
@Api(value = "Report")
public class ReportEndPoint {

    @PersistenceContext(unitName = "smppSms-persistence-unit")
    private EntityManager em;

    @EJB
    AdminGetServices adminGetServices;

    @EJB
    ReportService reportService;


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

    //all
    @Path("/CountSubscribersAll")
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public int countSubscribersActive(){
        {
            return this.reportService.countSubscribersAll();
        }
    }


    @Path("/CountSubscribersAllByCatagory")
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public int countSubscribersActiveByCatagory(@QueryParam("id") Long id){
        {
            return this.reportService.countSubscribersAllByCatagory(id);
        }
    }


    //Dailly
    @Path("/countSubscribersDailyAll")
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public int countSubscribersDailyAll(){
        {
            return this.reportService.countSubscribersDailyAll();
        }
    }


    @Path("/countSubscribersDailyByCatagory")
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public int countSubscribersDailyByCatagory(@QueryParam("id") Long id){
        {
            return this.reportService.countSubscribersDailyByCatagory(id);
        }
    }


//Month

    @Path("/countSubscribersmonthlyAll")
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public int countSubscribersmonthlyAll(){
        {
            return this.reportService.countSubscribersmonthlyAll();
        }
    }


    @Path("/countSubscribersmonthlyByCatagory")
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public int countSubscribersmonthlyByCatagory(@QueryParam("id") Long id){
        {
            return this.reportService.countSubscribersmonthlyByCatagory(id);
        }
    }


    //year
    @Path("/countSubscribersYearlyAll")
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public int countSubscribersYearlyAll(){
        {
            return this.reportService.countSubscribersYearlyAll();
        }
    }


    @Path("/countSubscribersYearlybyCatagory")
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public int countSubscribersYearlybyCatagory(@QueryParam("id") Long id){
        {
            return this.reportService.countSubscribersYearlybyCatagory(id);
        }
    }


    //All Round
    @Path("/countSubscribersBetweenAll")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public Long countSubscribersBetweenAll(SubscriptionQueryDTO subscriptionQueryDTO){ {
            return this.reportService.countSubscribersBetweenAll(subscriptionQueryDTO.getStartDate(),subscriptionQueryDTO.getEndDate());
        }
    }


    @Path("/countSubscribersBetweenByCatagory")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @PermitAll
    public Long countSubscribersBetweenByCatagory(SubscriptionDTOInt subscriptionDTOInt){
        {
            return this.reportService.countSubscribersBetweenByCatagory(subscriptionDTOInt.getId(),subscriptionDTOInt.getStartDate(),subscriptionDTOInt.getEndDate());
        }
    }




}
