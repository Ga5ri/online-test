package goodee.gdj58.online.mapper;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Example;

@Mapper
public interface ExampleMapper {
	int deleteExample(int exampleNo);
	int updateExample(Example example);
	Example exList(int exampleNo);
	int addExample(Example example);
	List<Example> questionOne(Map<String, Object> paramMap);
}
