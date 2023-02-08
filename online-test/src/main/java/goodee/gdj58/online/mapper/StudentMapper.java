package goodee.gdj58.online.mapper;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Student;

@Mapper
public interface StudentMapper {
	List<Student> selectQuestionByStudent(Map<String, Object> paramMap);
	int countSd(String searchWord);
	List<Student> selectStudList(Map<String, Object> paramMap);
	Student loginSd(Student student);
}