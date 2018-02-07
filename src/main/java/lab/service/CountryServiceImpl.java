package lab.service;

import lab.dao.jdbc.CountryJdbcDao;
import lab.model.Country;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.transaction.annotation.Propagation.*;

//@Repository is more convenient declaration for such a class than general @Service
@Repository
@Data
@Transactional
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryJdbcDao countryDao;

    public List<Country> getAllCountriesInsideTransaction(
            Propagation propagation) {
        if (REQUIRED.equals(propagation)) {
            return getAllCountriesRequired();
        } else if (REQUIRES_NEW.equals(propagation)) {
            return getAllCountriesRequiresNew();
        } else if (SUPPORTS.equals(propagation)) {
            return getAllCountriesSupports();
        } else if (NEVER.equals(propagation)) {
            return getAllCountriesNever();
        } else if (MANDATORY.equals(propagation)) {
            return getAllCountriesMandatory();
        } else if (NOT_SUPPORTED.equals(propagation)) {
            return getAllCountriesNotSupported();
        } else {
            return getAllCountries();
        }
    }
    @Transactional(propagation = REQUIRED)
    public List<Country> getAllCountriesRequired() {
        return countryDao.getCountryList();
    }

    @Transactional(propagation = REQUIRES_NEW)
    public List<Country> getAllCountriesRequiresNew() {
        return countryDao.getCountryList();
    }

    @Transactional(propagation = SUPPORTS)
    public List<Country> getAllCountriesSupports() {
        return countryDao.getCountryList();
    }

    @Transactional(propagation = NEVER)
    public List<Country> getAllCountriesNever() {
        return countryDao.getCountryList();
    }

    @Transactional(propagation = MANDATORY)
    public List<Country> getAllCountriesMandatory() {
        return countryDao.getCountryList();
    }

    @Transactional(propagation = NOT_SUPPORTED)
    public List<Country> getAllCountriesNotSupported() {
        return countryDao.getCountryList();
    }

    public List<Country> getAllCountries() {
        return countryDao.getCountryList();
    }

}