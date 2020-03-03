package et.com.smpp.services.AdminServices;


import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import et.com.smpp.InDTOs.FileUploadForm;
import et.com.smpp.InDTOs.PhoneNumber;
import et.com.smpp.dao.ExternalBulkDao;
import et.com.smpp.model.ExternalBulk;
import et.com.smpp.services.ExcelObjectMapper;
import et.com.smpp.services.FileSave;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.now;

@Stateless
public class DataMapper {
    @EJB
    ExternalBulkDao externalBulkDao;

    public List<PhoneNumber> listPhoneNumber(FileUploadForm fileUploadForm) {
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        String folder = System.getProperty("jboss.home.dir") + File.separator + "welcome-content" + File.separator + "excelFiles";
        String fileName = folder + File.separator + now() + ".xlsx";
        try {
            FileSave.writeFile(fileUploadForm.getData(), fileName);
            phoneNumbers = ExcelObjectMapper.phoneNumberList(fileName);

            phoneNumbers.forEach(phones -> {
                ExternalBulk externalBulk = new ExternalBulk();
                externalBulk.setPhoneNumber(phones.getPhoneNumber());
                externalBulkDao.create(externalBulk);
            });

            return phoneNumbers;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return phoneNumbers;

    }
}

