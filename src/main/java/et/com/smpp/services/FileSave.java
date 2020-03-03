package et.com.smpp.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileSave {
    public static void writeFile(byte[] content, String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fop = new FileOutputStream(file);
        fop.write(content);
        fop.flush();
        fop.close();
    }
}
