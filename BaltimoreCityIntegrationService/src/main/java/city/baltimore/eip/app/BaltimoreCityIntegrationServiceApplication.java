package city.baltimore.eip.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;




import java.util.ArrayList;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.ws.transport.http.MessageDispatcherServlet;


@Configuration
@EnableAutoConfiguration
@SpringBootApplication
/* Was used to create REST endpoints. Not needed now.
@RestController
 */
//This imports the HTTPS properties. Needed for KCI dev server. Not needed at City as going through reverse proxy.
@PropertySource(value="${ssl.properties.filelocation}", ignoreResourceNotFound=true)
//The context containing beans and integration configurations.
@ImportResource("applicationContext.xml")
public class BaltimoreCityIntegrationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaltimoreCityIntegrationServiceApplication.class, args);
    }

//** These were samples to get REST and SOAP endpoints working when thought they were needed. Leaving in for future reference, if needed.
//    @RequestMapping("/hello/{name}")
//    String hi(@PathVariable String name) {
//        return "Hello, " + name + "!";
//    }
    
//    @Bean
//    public ServletRegistrationBean wsServletRegistrationBean() {
//        ServletRegistrationBean bean = new ServletRegistrationBean();
//        bean.setServlet(wsdispatcherServlet());
//        bean.addUrlMappings("/ws/*");
//        return bean;
//    }
//
//    public MessageDispatcherServlet wsdispatcherServlet() {
//        XmlWebApplicationContext ctx = new XmlWebApplicationContext();
//        ctx.setConfigLocation("classpath:/spring-ws-config.xml");
//        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet(ctx);
//        return messageDispatcherServlet;
//    }

//  disable default dispatherServlet!
//    @Bean
//    public Void dispatcherServlet() {
//        return null;
//    }
}