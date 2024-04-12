package dataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CollectionData {

	

		// Download the latest UCanAccess binary zip file from here:
		// http://sourceforge.net/projects/ucanaccess/files/
		// Extract the files
		// Copy files located in the extracted “lib” directory to
		// [YourYellowfinInstallDirectory]/appserver/lib/ These include
	// commons-lang-2.6.jar, commons-logging-1.1.1.jar, hsqldb.jar, and
		// jackcess-2.1.6.jar, ucanacess.jar
	 
		public static void main(String[] args) throws SQLException {
			// TODO Auto-generated method stub
			// paste jars(downloaded jars ) in jre1.8.0_131\lib\ext folder
			// Class.forName( "com.microsoft.sqlserver.jdbc.SQLServerDriver" );
			//JDBC is used for database connectivity with java
		//execute is used for DML staments and executeQuery for select statement
			//syntax:jdbc:<driver>:DbasePath
			String connectionString = "jdbc:ucanaccess://D:/TestDB.accdb";	
			Connection conn = DriverManager.getConnection(connectionString);
			Statement st = conn.createStatement();
			try {
			// drop
			st.execute("drop table Employee1");
			st.execute("create table Employee1(Empid varchar(10),Empname varchar(10))");
			System.out.println("working on data");
			st.execute("insert into Employee1 values('1','Naresh')");
			st.execute("insert into Employee1 values('2','Kumar')");
	 
			st.execute("update Employee1 set Empid='E101' where Empname='Naresh'");
			// st.execute("delete from Employee");
			ResultSet rs = st.executeQuery("select * from Employee1");
			System.out.println("Table data");
			while (rs.next()) {
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
					System.out.println(rs.getString(i).toString());
			}
			System.out.println("working on Metadata");  //data about data is metedata
			// get metadata
			System.out.println(rs.getMetaData().getColumnCount());
			for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
				System.out.println(rs.getMetaData().getColumnName(i));
				System.out.println(rs.getMetaData().getColumnTypeName(i));
	 
			}
			// get table records

	 
			// delete
			st.execute("delete from Employee1");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	 
	

	}


