//package Tool;
//import Model.Student;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class TestConnection {
//    public static void main(String[] args) throws Exception {
////        System.out.println("jdbcTools.getConnection() = " + jdbcTools.getConnection());
////        jdbcTools.update("update students set sname=? where sno='108'","李华");
////        jdbcTools.select("select * from students where sno=?","108");
//        String sql = "SELECT * FROM students WHERE sno = ?";
//        List<Student> results = jdbcTools.select(sql,Student.class,"108");
//        for (Student student : results) {
//            System.out.println(student);
//        }
//        ArrayList<Map> maps = jdbcTools.queryMapList(sql, "108");
//        System.out.println("maps = " + maps);
//        List<Object[]> selectquery = jdbcTools.selectquery(sql, "108");
////        for (Object[] row : selectquery) {
////            for (Object column : row) {
////                System.out.println(column + "\t");
////            }
////        }
//        for (int i = 0; i < selectquery.size(); i++) {
//            for (int j = 0; j < selectquery.get(i).length; j++) {
//                System.out.print(selectquery.get(i)[j]+" ");
//            }
//        }
//    }
//}
