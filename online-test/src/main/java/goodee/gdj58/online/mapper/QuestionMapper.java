package goodee.gdj58.online.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Question;
import goodee.gdj58.online.vo.Test;

@Mapper
public interface QuestionMapper {
	int deleteQuestion(int questionNo);
	int updateQuestion(Map<String, Object> paramMap);
	List<Question> questionOne(Map<String, Object> paramMap);
	int insertQuestion(Question question);
}
