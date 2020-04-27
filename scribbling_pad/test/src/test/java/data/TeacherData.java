package data;

import com.mario.test.dao.TestDao;
import com.mario.test.domain.Teacher;
import com.simpletour.commons.test.generator.AbstractDataGenerator;

/**
 * Created by Mario on 2016/5/7.
 */
public class TeacherData extends AbstractDataGenerator {

    private TestDao testDao;

    public TeacherData(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public void generator() {
        Teacher teacher = new Teacher();
        teacher.setName("teacher");
        domains.add(testDao.save(teacher));
    }
}
