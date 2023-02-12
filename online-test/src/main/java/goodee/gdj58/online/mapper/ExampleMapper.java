package goodee.gdj58.online.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Example;
import goodee.gdj58.online.vo.Question;
@Mapper
public interface ExampleMapper {
	int updateExample(Map<String, Object> paramMap);
	int addExample(Example example);
	List<Question> questionOne(Map<String, Object> paramMap);
}
