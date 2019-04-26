package cn.qlq.action;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.qlq.bean.Area;
import cn.qlq.service.AreaService;


@RestController/**自动返回的是json格式数据***/
public class AreaController {
	
	@Autowired
	private AreaService areaService;

	@RequestMapping("list")
	public List<Area> list(){
		List<Area> list = areaService.findAllArea();
		return list;
	}
	
	@RequestMapping("batchInsert")
	public Integer batchInsert(){
		Integer num = null;
		try {
			num = areaService.batchInsert();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return num;
	}
}
