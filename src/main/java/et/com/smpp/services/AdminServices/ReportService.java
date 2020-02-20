package et.com.smpp.services.AdminServices;

import et.com.smpp.dao.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;


@Stateless
public class ReportService {
    @EJB
    et.com.smpp.dao.BulkMessageDao BulkMessageDao;

    @EJB
    et.com.smpp.dao.CatagoryTableDao CatagoryTableDao;

    @EJB
    MessageTableDao messagetableDao;

    @EJB
    SubscribtionTableDao subscribtiontableDao;

    @EJB
    RoleDao roleDao;

    @EJB
    StaffDao staffDao;

    @PersistenceContext(unitName = "smppSms-persistence-unit")
    private EntityManager em;



    // all
    public int countSubscribersAll(){
        int subscriberList = this.subscribtiontableDao.countSubscribersALL();
        return subscriberList;
    }

    //all by catagory
    public int countSubscribersAllByCatagory(Long id){
        int subscriberList = this.subscribtiontableDao.countSubscribersAllByCatagory(id);
        return subscriberList;
    }

    // year by catagory
    public int countSubscribersYearlybyCatagory(Long id){
        int subscriberList = this.subscribtiontableDao.countSubscribersYearlybyCatagory(id);
        return subscriberList;
    }


    public int countSubscribersYearlyAll(){
        int subscriberList = this.subscribtiontableDao.countSubscribersYearlyAll();
        return subscriberList;
    }


    // month by catagory
    public int countSubscribersmonthlyByCatagory(Long id){
        int subscriberList = this.subscribtiontableDao.countSubscribersMonthByCatagory(id);
        return subscriberList;
    }


    public int countSubscribersmonthlyAll(){
        int subscriberList = this.subscribtiontableDao.countSubscribersmonthlyAll();
        return subscriberList;
    }


    //month all
    public Long countSubscribersBetweenAll(Date startDate, Date endDate){
        return this.subscribtiontableDao.countSubscribersBetweenAll(startDate,endDate);
    }


    // weak by catagory
    public Long countSubscribersBetweenByCatagory(Long id, Date startDate, Date endDate){
        return this.subscribtiontableDao.countSubscribersBetweenByCatagory(startDate,endDate,id);

    }

//SELECT e FROM Events e WHERE e.eventsDate BETWEEN :startDate AND :endDate

    //weak all
//    public int countSubscribersWeeklyAll(){
//        int subscriberList = this.subscribtiontableDao.countSubscribersAllByCatagory();
//        return subscriberList;
//    }


    // dailly by catagory
    public int countSubscribersDailyByCatagory(Long id){
        int subscriberList = this.subscribtiontableDao.countSubscribersDailyByCatagory(id);
        return subscriberList;
    }

    //dailly all
    public int countSubscribersDailyAll(){
        int subscriberList = this.subscribtiontableDao.countSubscribersDailyAll();
        return subscriberList;
    }

}
