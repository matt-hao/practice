import com.mario.test.dao.TestDao;
import com.mario.test.domain.Teacher;
import com.mario.test.domain.TestDate;
import com.mario.test.service.TestService;
import data.StudentData;
import data.TeacherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.ZoneOffset;
import java.util.Date;


@ContextConfiguration({"classpath:applicationContext.xml"})
public class JpaTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TestService testService;

    @Autowired
    private TestDao testDao;

    private StudentData studentData;

    @BeforeClass
    public void setUp() {
        TeacherData teacherData = new TeacherData(testDao);
        studentData = new StudentData(testDao);
        studentData.addDataGenerators(teacherData);
        studentData.createData();
    }

    @AfterClass
    public void destroy() {
    }

    @Test
    public void testAddteacher() {
//        Teacher teacher = new Teacher();
//        teacher.setName("mario");
//        List<Student> students = new ArrayList<Student>();
//        Student s1 = new Student();
//        s1.setName("xuesheng1");
//        students.add(s1);
//        Student s2 = new Student();
//        s2.setName("xuesheng2");
//        students.add(s2);
//        teacher.setStudents(students);
//        Optional<Teacher> teacherOptional = testService.addTeacher(teacher);
//        Assert.assertTrue(teacherOptional.isPresent());
//        Teacher teacher = testDao.getEntityById(Teacher.class, (studentData.getDomains(Teacher.class).get(0)).getId());
//        System.out.println(teacher.getStudents());

//        Teacher teacher = ((Teacher) studentData.getDomains(Teacher.class).get(0));
//        teacher = testDao.getEntityById(Teacher.class,teacher.getId());
//        teacher.getStudents().stream().forEach(student -> {
//            testDao.remove(student);
//        });
//        testDao.remove(teacher);
        Teacher teacher = new Teacher();
        teacher.setId(8L);
        teacher.setName("wtf");
        teacher.setVerison(0);
        Teacher teacher1 = testDao.save(teacher);
        System.out.println("aaa");
    }

    @Test
    public void testDate() {
        Date c = new Date();
        TestDate test= new TestDate();
        test.setDay(c);
        TestDate test1 = testDao.save(test);
        System.out.println(c.getTime());
        System.out.println(test1.getDay().toInstant().atOffset(ZoneOffset.ofHours(0)).toEpochSecond());
    }

    @Test
    public void seataaa(){
        System.out.println("adad");
    }
}
