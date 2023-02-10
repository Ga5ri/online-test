package goodee.gdj58.online.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Test;

@Mapper
public interface TestMapper {
	List<Test> testOne(Map<String, Object> paramMap);
	int insertTest(Test test);
	int updateTest(Test test);
	int deleteTest(int testNo);
	List<Test> testList(Map<String, Object> paramMap);
}
