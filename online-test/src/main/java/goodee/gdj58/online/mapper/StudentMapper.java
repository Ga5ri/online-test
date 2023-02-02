package goodee.gdj58.online.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Student;

@Mapper
public interface StudentMapper {
	int countStudent(String searchWord);
	int deleteStudent(int studentNo);
	int insertStudent(Student student);
	List<Student> selectStudentList(Map<String, Object> paramMap);
}