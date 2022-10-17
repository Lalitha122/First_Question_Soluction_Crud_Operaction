package conEmployee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class empServiceImp implements empService{
	public ArrayList<Employee> displayEmployee(Employee employee){
		 ArrayList<Employee>arrayList=new ArrayList<Employee>();
	        try {
	        
	        Connection con =ConnectionFactory.getConnection();
	        Statement statement=con.createStatement();
	        ResultSet  rset=statement.executeQuery("SELECT * FROM employee.employeedetails");
	        while(rset.next()) {
	          Employee e=new Employee();
	          System.out.println(rset.getString(1));
	          e.setEmpname(rset.getString(1));
	          e.setSalary(rset.getFloat(2));
	          arrayList.add(e);
	        }
	        
	    }catch(Exception e) {
	        e.printStackTrace();
	    }
	        return arrayList;
	    }
	public void addEmployee(Employee employee) {
	      try {
	        Connection con =ConnectionFactory.getConnection();
	        Statement statement=con.createStatement();
	        String query="insert into employee.employeedetails(`empname`,`salary`) values('"+employee.getEmpname()+"','"+employee.getSalary() +"')";
	        statement.executeUpdate(query);
	        System.out.println("data inserted successfully");
	    }catch(Exception e) {
	        e.printStackTrace();
	    }
	    }
	public void updateEmployee(String s)
	{
	       try {
	           Connection con =ConnectionFactory.getConnection();
	        Statement statement=con.createStatement();
	        statement.executeUpdate(s);
	        ResultSet  rset=statement.executeQuery("SELECT * FROM employee.employeedetails");
	        }catch(Exception e) {
	            e.printStackTrace();
	    }
	    }
	public void deleteEmployee(Employee employee) {
		try {
		Connection con =ConnectionFactory.getConnection();
        Statement statement=con.createStatement();
        String query="DELETE FROM `employee`.`employeedetails` WHERE (`empname` ='"+employee.getEmpname()+"' )";
	statement.executeUpdate(query);
	System.out.println("data deleted successfully");
	}
		catch(Exception e) {
            e.printStackTrace();
    }
}
}
