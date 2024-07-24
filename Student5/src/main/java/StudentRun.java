import Service.serviceImpl.StudentServiceImpl;
import Tool.Code;
import UserView.UseUi;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class StudentRun {



    public static void main(String[] args) throws Exception {
        System.out.println("--------------------------------------");
        System.out.println("**欢迎使用学生信息管理系统***");
        System.out.println("--------------------------------------");
        System.out.println("请选择你的业务操作");

        Scanner scanner = new Scanner(System.in);
        StudentServiceImpl studentService = new StudentServiceImpl();
        int count = 0;
        while (count < 3) {
            System.out.print("请输入用户名：");
            String user = scanner.next();
            System.out.print("请输入密码：");
            String ps = scanner.next();

            while (true) {
                System.out.println("请输入验证码：");
                String code = Code.code();
                System.out.println(code);
                String usercode = scanner.next();
                if (!usercode.equals(code)) {
                    System.out.println("验证码错误");
                } else {
                    break;
                }
            }

            if (!studentService.selectAdmin(user, ps)) {
                if (count < 2) {
                    System.out.println("账号或密码错误，请重新输入：");
                }
                count++;
            } else {
                System.out.println("登录成功！");
                UseUi useUi = new UseUi();
                useUi.UI();
                break;
            }

            if (count == 3) {
                System.out.println("连续三次登录失败，程序退出。");
            }
        }
    }
}
