package cn.qlq.service.impl;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.qlq.bean.Area;
import cn.qlq.mapper.AreaMapper;
import cn.qlq.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {
	private static final String PATH = "D:\\java\\learnWorkSpace\\jsontosql\\trans\\json\\areas.json";
	
	@Autowired
	private AreaMapper AreaMapper;
	
	
	public List<Area> findAllArea() {
		List<Area> list = AreaMapper.findAll();
		return list;
	}


	@Override
	public Integer batchInsert() throws FileNotFoundException, IOException {
		String json = readFileToString(PATH);
		if(json != null) {
	    	JSONArray jsonArray = (JSONArray) JSONObject.parseArray(json);
	    	List<Area> list = jsonArray.toJavaList(Area.class);
	    	for (Area area : list) {
	    		AreaMapper.add(area);
			}
		}
		return null;
	}
	
    private static String readFileToString(String filepath) throws FileNotFoundException, IOException {
  	  StringBuilder sb = new StringBuilder();
  	  String s ="";
  	  BufferedReader br = new BufferedReader(new FileReader(filepath));

  	  while( (s = br.readLine()) != null) {
  		  sb.append(s + "\n");
  	  }

  	  br.close();
  	  String str = sb.toString();
  	  
  	  return str;
 }
}
