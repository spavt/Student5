package Service;

import Model.Student;

import java.io.IOException;

/**
 * Crd
 */
public interface StudentService {//增删改查
    void showStu() throws Exception; // 查询所有学生信息，不需要传递数组和长度
    void addStu(Student stu); // 添加学生信息
    void delStu(int id) throws Exception; // 删除学生信息，不需要传递数组和长度，只需要学生ID
    void findStu(int id); // 查找学生信息，不需要传递数组和长度，只需要学生ID
    void updateStu(int id); // 修改学生信息，不需要传递数组和长度，只需要学生ID
    boolean selectAdmin(String username, String password) throws IOException;
}
