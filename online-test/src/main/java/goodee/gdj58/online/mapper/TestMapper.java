package goodee.gdj58.online.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Test;

@Mapper
public interface TestMapper {
	List<Test> testOne(Map<String, Object> paramMap);
	int insertTest(Test test);
	List<Test> testList(Map<String, Object> paramMap);
}
