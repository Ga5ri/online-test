package goodee.gdj58.online.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Score;
import goodee.gdj58.online.vo.Student;

@Mapper
public interface ScoreMapper {
	List<Score> selectScore(Map<String, Object> paramMap);
	int insertScore(Score score);
}
