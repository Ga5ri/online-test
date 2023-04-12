package goodee.gdj58.online.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.EmployeeMapper;
import goodee.gdj58.online.vo.Employee;
import goodee.gdj58.online.vo.Student;
import goodee.gdj58.online.vo.Teacher;

@Service
//service도 객체가 생김(bean)
@Transactional
//실행중 예외가 발생하면 메소드에서 트랜잭션, db에게 권한을 주는것이 아니라 스프링이 관리
public class EmployeeService {
	// DI 역할 => new EmployeeMapper()
	@Autowired private EmployeeMapper employeeMapper;
	// 카운트
	public int countStudent(String searchWord) {
		return employeeMapper.countStudent(searchWord);
	}
	
	// 삭제
	public int removeStudent(int studentNo) {
		return employeeMapper.deleteStudent(studentNo);
	}
	
	// 등록
	public int addStudent(Student student) {
		return employeeMapper.insertStudent(student);
	}
	
	// 리스트
	public List<Student> getStudentList(int currentPage, int rowPerPage, String searchWord) {
		int beginRow = (currentPage - 1) * rowPerPage;
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		paramMap.put("searchWord", searchWord);
		return employeeMapper.selectStudentList(paramMap);
	}
	
	// 강사
	// 카운트
	public int countTeacher(String searchWord) {
		return employeeMapper.countTeacher(searchWord);
	}
	
	// 삭제
	public int removeTeacher(int teacherNo) {
		return employeeMapper.deleteTeacher(teacherNo);
	}
	
	// 등록
	public int addTeacher(Teacher teacher) {
		return employeeMapper.insertTeacher(teacher);
	}
	
	// 리스트
	public List<Teacher> getTeacherList(int currentPage, int rowPerPage, String searchWord) {
		int beginRow = (currentPage - 1) * rowPerPage;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		paramMap.put("searchWord", searchWord);
		return employeeMapper.selectTeacherList(paramMap);
	}
	
	// 사원
	// 카운트
	public int countEmp(String searchWord) {
		return employeeMapper.countEmp(searchWord);
	}
	
	// 사원 수정
	public int updateEmployeePw(int empNo, String oldPw, String newPw) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("empNo", empNo);
		paramMap.put("oldPw", oldPw);
		paramMap.put("newPw", newPw);
		return employeeMapper.updateEmployeePw(paramMap);
	}
	
	// 로그인
	public Employee login(Employee emp) {
		return employeeMapper.login(emp);
	}
	
	// 사원 삭제
	public int removeEmployee(int empNo) {
		return employeeMapper.deleteEmployee(empNo);
	}
	
	// 사원 등록
	public int addEmployee(Employee employee) {
		return employeeMapper.insertEmployee(employee);
	}
	
	// 리스트
	public List<Employee> getEmployeeList(){
		return employeeMapper.selectEmployeeList();
	}
	
	/*
	부트스트랩 자체 적용으로 주석 처리
	// 리스트
	public List<Employee> getEmployeeList(int currentPage, int rowPerPage, String searchWord){
		int beginRow = (currentPage - 1) * rowPerPage;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		paramMap.put("searchWord", searchWord);
		return employeeMapper.selectEmployeeList(paramMap);
	}
	*/
}