package ioc;

import lab.model.Country;
import lab.model.Person;
import lab.model.UsualPerson;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

class HelloWorldTest {

    private static final String APPLICATION_CONTEXT_XML_FILE_NAME =
            "ioc.xml";

    private BeanFactory context =
            new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML_FILE_NAME);

    static Person getExpectedPerson() {
        return new UsualPerson()
                .setAge(35)
                .setName("John Smith")
                .setProgrammer(true)
                .setHeight(1.78F)
                .setContacts(Arrays.asList("asd@asd.ru", "+7-234-456-67-89"))
                .setCountry(new Country()
                        .setId(1)
                        .setName("Russia")
                        .setCodeName("RU"));
    }
}
