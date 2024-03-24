package jdbcex2;

import java.util.List;

public class DataBaseClient {

	public static void main(String[] args) 
	{
		EmployeeDao employeeDao=new EmployeeDao();
		int res1= employeeDao. save(new Employee(1001,"santhosh",116));
		System.out.println("Data inserted sucessfully"+res1);
		
		int res2= employeeDao. save(new Employee(1002,"anandham",118));
		System.out.println("Data inserted sucessfully"+res2);
		int res3= employeeDao. save(new Employee(1003,"suresh",119));
		
		//read the data from database
		 /*Employee emp=employeeDao.findById(1001);
		 System.out.println(emp);
		 
		 Employee emp=employeeDao.findById(1004);
		 System.out.println(emp);*/

		 	/*int deletecount = employeeDao.deleteById(1001);
		 	if(deletecount==1)
		 	{
		 		System.out.println("Data deleted successfully....");
		 	}
		 	else
		 	{
		 		System.out.println("data deletion fail...");
		 	}*/
		 	//int deletecount = employeeDao.deleteBySalary(119.0);
		 	// System.out.println("data deleted");
		/*List<Employee> emps=employeeDao.findAll();
		emps.forEach(emp->System.out.println(emps));*/
		
		//int updatecount=employeeDao.updateSalary(100, 100);
		
		//System.out.println("salary updated....."+updatecount);
	}

}
