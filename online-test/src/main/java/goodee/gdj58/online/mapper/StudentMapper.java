package goodee.gdj58.online.mapper;



import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Example;
import goodee.gdj58.online.vo.Question;
import goodee.gdj58.online.vo.Student;

@Mapper
public interface StudentMapper {
	List<Map<String, Object>> scoreQuestionList(Map<String, Object> paramMap);
	List<Example> exList(int testNo);
	List<Question> qList(Map<String, Object> paramMap);
	int countSd(String searchWord);
	List<Student> selectStudList(Map<String, Object> paramMap);
	Student loginSd(Student student);
}