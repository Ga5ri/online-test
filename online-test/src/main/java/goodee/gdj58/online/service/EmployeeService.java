package goodee.gdj58.online.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.EmployeeMapper;
import goodee.gdj58.online.vo.Employee;

@Service
//service도 객체가 생김(bean)
@Transactional
//실행중 예외가 발생하면 메소드에서 트랜잭션, db에게 권한을 주는것이 아니라 스프링이 관리
public class EmployeeService {
	// DI 역할 => new EmployeeMapper()
	@Autowired	// bean 안에 employeeMapper 타입에 들어갈 수 있는 게 있는지 스캔 후 주입
	private EmployeeMapper employeeMapper;

	
	public int updateEmployeePw(int empNo, String oldPw, String newPw) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("empNo", empNo);
		paramMap.put("oldPw", oldPw);
		paramMap.put("newPw", newPw);
		return employeeMapper.updateEmployeePw(paramMap);
	}
	
	public Employee login(Employee emp) {
		return employeeMapper.login(emp);
	}
	
	public int removeEmployee(int empNo) {
		return employeeMapper.deleteEmployee(empNo);
	}
	
	public int addEmployee(Employee employee) {
		return employeeMapper.insertEmployee(employee);
	}
	
	public List<Employee> getEmployeeList(int currentPage, int rowPerPage){
		int beginRow = (currentPage-1)*rowPerPage;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		return employeeMapper.selectEmployeeList(paramMap);
	}
}