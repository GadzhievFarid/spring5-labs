package ioc;

import lab.model.Person;
import lab.model.UsualPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static ioc.HelloWorldTest.getExpectedPerson;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class SimpleAppTest {
	
	private static final String APPLICATION_CONTEXT_XML_FILE_NAME =
            "classpath:ioc.xml";

	private AbstractApplicationContext context;

	private Person expectedPerson;

	@BeforeEach
	void setUp() {
		context = new ClassPathXmlApplicationContext(
				APPLICATION_CONTEXT_XML_FILE_NAME);
		expectedPerson = getExpectedPerson();
	}

	@Test
	void testInitPerson() {
		Person person = context.getBean("person", UsualPerson.class);
		System.out.println(person.toString());
//		FYI: Another way to achieve the bean
//		person = context.getBean(UsualPerson.class);
        assertThat(person, is(getExpectedPerson()));
	}
}
