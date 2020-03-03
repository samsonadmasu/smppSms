package et.com.smpp.services;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import et.com.smpp.InDTOs.PhoneNumber;

import java.io.File;
import java.util.List;

public class ExcelObjectMapper {

    public static List<PhoneNumber> phoneNumberList(String fileName) {
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings(0) // zero based index of excel row
                .build();
        List<PhoneNumber> phoneNumbers = Poiji.fromExcel(new File(fileName), PhoneNumber.class, options);
        return phoneNumbers;
    }

}
