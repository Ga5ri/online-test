package goodee.gdj58.online.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IdMapper {
	String selectIdCheck(String id);
}