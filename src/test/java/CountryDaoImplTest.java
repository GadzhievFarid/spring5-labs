import lab.dao.CountryDao;
import lab.model.Country;
import lab.model.simple.SimpleCountry;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Illustrates basic use of Hibernate as a JPA provider.
 */
@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:orm.xml")
@NoArgsConstructor
class CountryDaoImplTest {

	private Country exampleCountry =
            new SimpleCountry(1L, "Australia", "AU");

    @Autowired
	private CountryDao countryDao;

	@Test
	void testSaveCountry() {

		countryDao.save(exampleCountry);

		List<Country> countryList = countryDao.getAllCountries();
		assertEquals(1, countryList.size());
		assertEquals(exampleCountry, countryList.get(0));
	}

	@Test
	void testGtAllCountries() {

		countryDao.save(new SimpleCountry(1L, "Canada", "CA"));

		List<Country> countryList = countryDao.getAllCountries();
		assertEquals(2, countryList.size());
	}

	@Test
	void testGetCountryByName() {

		Country country = countryDao.getCountryByName("Australia");
		assertEquals(exampleCountry, country);
	}

}
