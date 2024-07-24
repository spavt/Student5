package Dao;

import Model.Admin;
import Model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class DaoStuHandle {

    public DaoStuHandle() throws Exception {

    }

    public static void info() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/config/log4j.properties");
        properties.load(fileInputStream);
        PropertyConfigurator.configure(properties);
    }
//    public void  throws Exception {
        public List<Student> showStuDAO() throws IOException {

            DaoStuHandle.info();
            //从配置文件中获取一个工厂对象
            InputStream in = Resources.getResourceAsStream("config/mybatis-config.xml");
            SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(in);
            //通过工厂获取sqLsession对象
            SqlSession sqlsession = fac.openSession();
            //sqLsession对象执行映射mapper文件中的sql语句
            List<Student> students = sqlsession.selectList( "EmpMapper.findAll");
            return students;
        }

    public int addStuDAO(Student stu) throws Exception {
        DaoStuHandle.info();
        InputStream resourceAsStream = Resources.getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlsession = fac.openSession();
        int insert = sqlsession.update("EmpMapper.insertdata", stu);
        sqlsession.commit();
        return insert;
    }

    public int delStuDAO(int sno) throws Exception {
        DaoStuHandle.info();
        InputStream resourceAsStream = Resources.getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlsession = fac.openSession();
        int del = sqlsession.update("EmpMapper.deletedata", sno);
        sqlsession.commit();
        return del;
    }

    public Student findStuDAO(int sno) throws Exception {
        DaoStuHandle.info();
        InputStream resourceAsStream = Resources.getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlsession = fac.openSession();
        List<Student> students = sqlsession.selectList( "EmpMapper.findById",sno);
        return students.get(0);

    }

    public int updateStuDAO(Student stu) throws Exception {
        DaoStuHandle.info();

        InputStream resourceAsStream = Resources.getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlsession = fac.openSession();
        int update = sqlsession.update("EmpMapper.updatedata", stu);
        sqlsession.commit();
        return update;

    }
    public boolean selectAdmin(String username, String password) throws IOException {
        DaoStuHandle.info();
        Admin admin1 = new Admin();
        admin1.setUsername(username);
        admin1.setPassword(password);
        InputStream resourceAsStream = Resources.getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlsession = fac.openSession();
        List<Admin> adminList = sqlsession.selectList("EmpMapper.findAdmin",admin1);
        return !adminList.isEmpty();
    }
}
