package com.kh.exam1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.db.conn.OracleCloudConnect;

class DeptCount {
	private String name;
	private int count;
	
	public DeptCount(String name, int count) {
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "DeptCount [name=" + name + ", count=" + count + "]";
	}
	
	
}

class empSalary{
	private String name;
	private int salary;
	public int getySalary() {
		return ySalary;
	}
	public void setySalary(int ySalary) {
		this.ySalary = ySalary;
	}

	private int ySalary = salary * 12;
	
	public empSalary(String name, int salary, int ySalary) {
		
		this.name = name;
		this.salary = salary;
		this.ySalary = ySalary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "empSalary [name=" + name + ", salary=" + salary + ", ySalary=" + ySalary + "]";
	}
	
	
}

public class Sample2 {

	public static void main(String[] args) {
		OracleCloudConnect occ;
		try {
			occ= new OracleCloudConnect();
			occ.connection();
			
			// Employees 테이블을 사용하여 부서별 인원수를 구해본다.
			String query = "" 
					+  "SELECT DEPARTMENT_NAME, "
					+ "        COUNT(EMPLOYEE_ID)"
					+ "   FROM EMPLOYEES A JOIN DEPARTMENTS B"
					+ "     ON A.DEPARTMENT_ID = B.DEPARTMENT_ID"
					+ "  WHERE A.DEPARTMENT_ID IS NOT NULL"
					+ "  GROUP BY B.DEPARTMENT_NAME"
					+ "  ORDER BY B.DEPARTMENT_NAME";
			ResultSet res = occ.sendQuery(query);
			
			
			// Set 컬렉션에 조회 데이터를 담아본다.
			Set<DeptCount> deptSet = new HashSet<DeptCount>();
			while(res.next()) {
				System.out.println(res.getString(1) + " | " + res.getInt(2));
				deptSet.add(new DeptCount(res.getString(1), res.getInt(2)));
			}
			System.out.println(deptSet);
			
			// Employees 테이블을 사용하여 급여가 8000 이상인 사원을 조회 후
			// Set 컬렉션에 담아본다.(사원명, 급여액, 연봉)
			String query2 = "" 
					+  "SELECT FIRST_NAME || ' ' || LAST_NAME AS \"NAME\", "
					+ "        SALARY AS 급여액,"
					+ "		   SALARY * 12 AS 연봉"
					+ "   FROM EMPLOYEES"
					+ "  WHERE SALARY >= 8000";
			
			ResultSet res2 = occ.sendQuery(query2);
			
			// Set 컬렉션에 조회 데이터를 담아본다.
			Set<empSalary> salarySet = new HashSet<empSalary>();
			while(res2.next()) {
				System.out.println(res2.getString(1) + " | " + res2.getInt(2) + " | " + res2.getInt(3));
				salarySet.add(new empSalary(res2.getString(1), res2.getInt(2), res2.getInt(3)));
			}
			System.out.println(salarySet);
			
			res.close();
			occ.close();
			occ.connectionClose();
			
		} catch(SQLException e) { 
			e.printStackTrace();
		}
	}

}
