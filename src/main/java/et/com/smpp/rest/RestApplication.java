package et.com.smpp.rest;

import io.swagger.annotations.Contact;
import io.swagger.annotations.SwaggerDefinition;

import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/rest")
@SwaggerDefinition(info =  @io.swagger.annotations.Info  (
        title = "Smpp",
        description = "buk Sms system",
        version = "1.0.0",
        contact = @Contact(
                name = "Phillip Kruger",
                email = "apiee@phillip-kruger.com",
                url = "http://phillip-kruger.com"
        )
)
)
public class RestApplication extends Application {
}