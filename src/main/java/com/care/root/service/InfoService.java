package com.care.root.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.care.root.dto.InfoDTO;

@Service
public class InfoService {
	Map<String, InfoDTO> DB;
	ArrayList<InfoDTO> list;
	public InfoService() {
		DB = new HashMap<String, InfoDTO>();
		list = new ArrayList<InfoDTO>();
		for(int i=0; i<5; i++) {
			InfoDTO dto = new InfoDTO();
			dto.setName("ȫ�浿" + i);
			dto.setAge(i);
			list.add(dto);
			DB.put("ȫ�浿" + i, dto);
		}
	}
	
	public List<InfoDTO> getList() {
		//select * from table;
		return list;
	}
	
	public InfoDTO getUser(String id) {
		return DB.get(id);
	}
}
