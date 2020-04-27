package data;

import com.mario.test.dao.TestDao;
import com.mario.test.domain.Student;
import com.mario.test.domain.Teacher;
import com.simpletour.commons.test.generator.AbstractDataGenerator;

/**
 * Created by Mario on 2016/5/7.
 */
public class StudentData extends AbstractDataGenerator {

    private TestDao testDao;

    public StudentData(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public void generator() {
        Student student = new Student();
        student.setName("student1");
        student.setTeacher((Teacher) getDomains(Teacher.class).get(0));
        domains.add(testDao.save(student));


        Student student1 = new Student();
        student1.setName("student2");
        student1.setTeacher((Teacher) getDomains(Teacher.class).get(0));
        domains.add(testDao.save(student1));
    }
}
