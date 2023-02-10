package goodee.gdj58.online.mapper;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Question;
import goodee.gdj58.online.vo.Student;
import goodee.gdj58.online.vo.Teacher;

@Mapper
public interface TeacherMapper {
	int countSd(String searchWord);
	List<Student> selectSdList(Map<String, Object> paramMap);
	int updateTeacherPw(Map<String, Object> paramMap);
	Teacher loginTc(Teacher teacher);
}
