package goodee.gdj58.online.mapper;



import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Example;
import goodee.gdj58.online.vo.Question;
import goodee.gdj58.online.vo.Student;

@Mapper
public interface StudentMapper {
	List<Example> exList(Map<String, Object> paramMap);
	List<Question> qList(Map<String, Object> paramMap);
	int countSd(String searchWord);
	List<Student> selectStudList(Map<String, Object> paramMap);
	Student loginSd(Student student);
}