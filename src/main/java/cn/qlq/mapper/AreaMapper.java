package cn.qlq.mapper;


import java.util.List;

/*import org.apache.ibatis.annotations.Mapper;*/

import cn.qlq.bean.Area;

/*@Mapper*/
public interface AreaMapper {
	
	public List<Area> findAll();
	
	public int add(Area area);

}
