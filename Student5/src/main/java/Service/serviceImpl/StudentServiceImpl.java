package Service.serviceImpl;

import Dao.DaoStuHandle;
import Model.Student;
import Service.StudentService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * 业务层
 */
public class StudentServiceImpl implements StudentService {
    DaoStuHandle daoStuHandle;

    public StudentServiceImpl() {
        try {
            daoStuHandle = new DaoStuHandle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showStu() throws Exception {
        List<Student> students = daoStuHandle.showStuDAO();
        for (Student stu :students){
            System.out.println(stu);
        }

    }

    @Override
    public void addStu(Student stu) {
        try {
            daoStuHandle.addStuDAO(stu);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delStu(int id) throws Exception {
        int b = daoStuHandle.delStuDAO(id);
        if (b!=0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    public void findStu(int id) {
        try {
            Student student = daoStuHandle.findStuDAO(id);
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("你要查找的学号不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStu(int id) {
        try {
            Student student = daoStuHandle.findStuDAO(id); // 先查找是否存在
            if (student != null) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("请输入学生的新姓名");
                String sname = scanner.next();
                System.out.println("请输入学生的新性别");
                String ssex = scanner.next();
                System.out.println("请输入学生的新专业");
                String sclass = scanner.next();

                student.setsname(sname);
                student.setssex(ssex);
                student.setsclass(sclass);
                student.setsno(id);

                daoStuHandle.updateStuDAO(student);
            } else {
                System.out.println("你要修改的学号不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean selectAdmin(String username, String password) throws IOException {
        return daoStuHandle.selectAdmin(username, password);
    }
}
