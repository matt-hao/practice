import com.test.domain.Country;
import com.test.domain.Person;
import com.test.service.TestCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mario on 2016/7/29.
 */
@ContextConfiguration({"classpath:applicationContext.xml"})
public class MarioTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TestCountryService testCountryService;

    private Country countryTemp;

    @Test
    public void saveCountry() {
        List<Person> persons = new ArrayList<>();
        Country country = new Country("china", persons);
        persons.add(new Person("mario", country));
        persons.add(new Person("sam", country));
        countryTemp = testCountryService.addCountry(country);
    }

    @Test(dependsOnMethods = "saveCountry")
    public void testSession() {
        testCountryService.findCountryById(countryTemp.getId());
    }
}
