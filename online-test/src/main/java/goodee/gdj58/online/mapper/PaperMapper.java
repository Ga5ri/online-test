package goodee.gdj58.online.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Paper;

@Mapper
public interface PaperMapper {
	List<Map<String, Object>> paperScore(Map<String, Object> paramMap);
	List<Map<String, Object>> paperOne(Map<String,Object> paramMap);
	int insertPaper(Map<String,Object> paramMap);
}
