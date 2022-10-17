package conEmployee;
import java.util.ArrayList;
import java.util.Scanner;
public class empController {
	public static void addData() {
		Scanner sc=new Scanner(System.in);
		Employee employee=new Employee();
		System.out.println("enter the name and salary");
		employee.setEmpname(sc.next());
		employee.setSalary(sc.nextInt());
		empServiceImp employeeservice=new empServiceImp();
		employeeservice.addEmployee(employee);   
	}
	public   static void displayData() {
		Employee employee=new Employee();
		empServiceImp employeeservice=new empServiceImp();
		ArrayList<Employee> list=employeeservice.displayEmployee(employee);
		System.out.println("-----------Employee Details---------");
		System.out.println("Employee name"+"        "+"Employee Salary");
		
		for(Employee e :list) {
			
			System.out.println(e.getEmpname()+"                     " +e.getSalary());
		}
	}
	public static void deleteData() {
		Scanner sc=new Scanner(System.in);
		Employee employee=new Employee();
		System.out.println("enter the name");
		employee.setEmpname(sc.next());
		empServiceImp employeeservice=new empServiceImp();
		employeeservice.deleteEmployee(employee);
	}
	public  static String updateData() {
		Scanner sc=new Scanner(System.in);
		Employee employee=new Employee();
		System.out.println("enter the name");
		String name=sc.next();
		empServiceImp employeeservice=new empServiceImp();
		ArrayList<Employee> list=employeeservice.displayEmployee(employee);
		for(Employee e:list)
		{
			if(e.getEmpname()==name)
			{

			}
		}
		System.out.println("enter the updated salary");
		float sal=sc.nextFloat();
		String query="UPDATE `employee`.`employeedetails` SET `salary` = '"+sal+"'  WHERE (`empname` = '"+name+"')";
		return query;
	}
	public static void main(String[] args) 
	{
		String s;
		System.out.println("enter ur choice");
		Scanner  scanner=new Scanner(System.in);
		int choice=scanner.nextInt();
		if(choice==1)
			addData();        
		else if(choice==2 )     
			displayData();

		else if(choice==3)
		{
			s=updateData();
			empServiceImp employeeservice=new empServiceImp();
			employeeservice.updateEmployee(s);
			System.out.println("salary is updated");        }
	}
}
