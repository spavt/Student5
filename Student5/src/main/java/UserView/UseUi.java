package UserView;

import Model.Student;
import Service.serviceImpl.StudentServiceImpl;

import java.util.Scanner;

/**
 * 表现层
 */
public class UseUi {
    public void UI() throws Exception {
        StudentServiceImpl studentService = new StudentServiceImpl();

        boolean flag = true;
        while (flag) {
            System.out.println("1.查询所有学生信息");
            System.out.println("2.添加学生信息");
            System.out.println("3.删除学生信息");
            System.out.println("4.查找学生信息");
            System.out.println("5.修改学生信息");
            System.out.println("0.退出系统");

            System.out.println("请输入你的业务数字");
            Scanner scanner = new Scanner(System.in);
            int num;
            try {
                num = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("请输入正确的数据！");
                continue;
            }

            switch (num) {
                case 1:
                    studentService.showStu();
                    break;
                case 2:
                    Student zhang = new Student();
                    System.out.println("请输入学生的ID");
                    Integer sno = scanner.nextInt();
                    System.out.println("请输入学生的姓名");
                    String name = scanner.next();
                    System.out.println("请输入学生的性别");
                    String ssex = scanner.next();
                    System.out.println("请输入学生的专业");
                    String major = scanner.next();

                    zhang.setsno(sno);
                    zhang.setsname(name);
                    zhang.setssex(ssex);
                    zhang.setsclass(major);

                    studentService.addStu(zhang);
                    break;
                case 3:
                    System.out.println("请输入你要删除的学生id");
                    int stuid = scanner.nextInt();
                    Boolean b=null;
                    studentService.delStu(stuid);
                    break;
                case 4:
                    System.out.println("请输入你查找的学生学号");
                    int stuid1 = scanner.nextInt();
                    studentService.findStu(stuid1);
                    break;
                case 5:
                    System.out.println("请输入你修改的学生学号");
                    int stuid2 = scanner.nextInt();
                    studentService.updateStu(stuid2);
                    break;
                case 0:
                    System.out.println("退出系统");
                    flag = false;
                    break;
            }
        }
    }
}
