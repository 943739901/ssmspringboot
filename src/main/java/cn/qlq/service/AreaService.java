package cn.qlq.service;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import cn.qlq.bean.Area;


public interface AreaService {
	
	/**
	 * 根据接口查询所用的用户
	 */
	public List<Area> findAllArea();

	public Integer batchInsert() throws FileNotFoundException, IOException;
}
