package cn.tedu.store.entity.excel;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class TestExcelWrite {
	public void createExcel(OutputStream os) throws WriteException, IOException {

		// 创建工作薄
		WritableWorkbook workbook = Workbook.createWorkbook(os);
		// 创建新的一页
		WritableSheet sheet = workbook.createSheet("First Sheet", 0);
		// 创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
		Label xuexiao = new Label(0, 0, "id");
		sheet.addCell(xuexiao);
		Label zhuanye = new Label(1, 0, "nickname");
		sheet.addCell(zhuanye);
		Label jingzhengli = new Label(2, 0, "token");
		sheet.addCell(jingzhengli);
		sheet.addCell(new Label(3,0,"mobil"));
		sheet.addCell(new Label(4,0,"money"));
		sheet.addCell(new Label(5,0,"integral"));
		

		// 数据库驱动类名的字符串
		String driver = "com.mysql.cj.jdbc.Driver";
		// 数据库连接串
		String url = "jdbc:mysql://127.0.0.1:3306/zpb_db?serverTimezone=GMT%2B8";
		// 用户名
		String username = "root";
		// 密码
		String password = "123456";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1、加载数据库驱动（ 成功加载后，会将Driver类的实例注册到DriverManager类中）
			try{//加载MySql的驱动类    
		         Class.forName(driver);    
		    }catch(ClassNotFoundException e){    
		         System.out.println("找不到驱动程序类 ，加载驱动失败！");    
		         e.printStackTrace() ;    
		    }   
			// 2、获取数据库连接
			conn = DriverManager.getConnection(url, username, password);
			// 3、获取数据库操作对象
			stmt = conn.createStatement();
			// 4、定义操作的SQL语句
			String sql = "select * from zpb_members limit 0,100";
			// 5、执行数据库操作
			rs = stmt.executeQuery(sql);
			// 6、获取并操作结果集
			int y = 1;
			while (rs.next()) {
				int x = 0;
				sheet.addCell(new Label(x, y, String.valueOf(rs.getInt("id"))));
				x++;
				sheet.addCell(new Label(x, y, String.valueOf(rs.getString("nickname"))));
				x++;
				sheet.addCell(new Label(x, y, String.valueOf(rs.getString("token"))));
				x++;
				sheet.addCell(new Label(x, y, String.valueOf(rs.getString("mobile"))));
				x++;
				sheet.addCell(new Label(x, y, String.valueOf(rs.getString("money"))));
				x++;
				sheet.addCell(new Label(x, y, String.valueOf(rs.getString("integral"))));
				y++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7、关闭对象，回收数据库资源
			if (rs != null) { // 关闭结果集对象
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) { // 关闭数据库操作对象
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) { // 关闭数据库连接对象
				try {
					if (!conn.isClosed()) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

/*		Label qinghua = new Label(0, 1, "清华大学");
		sheet.addCell(qinghua);
		Label jisuanji = new Label(1, 1, "计算机专业");
		sheet.addCell(jisuanji);
		Label gao = new Label(2, 1, "高");
		sheet.addCell(gao);

		Label beida = new Label(0, 2, "北京大学");
		sheet.addCell(beida);
		Label falv = new Label(1, 2, "法律专业");
		sheet.addCell(falv);
		Label zhong = new Label(2, 2, "中");
		sheet.addCell(zhong);

		Label ligong = new Label(0, 3, "北京理工大学");
		sheet.addCell(ligong);
		Label hangkong = new Label(1, 3, "航空专业");
		sheet.addCell(hangkong);
		Label di = new Label(2, 3, "低");
		sheet.addCell(di);*/

		// 把创建的内容写入到输出流中，并关闭输出流
		workbook.write();
		workbook.close();
		os.close();
	}

}