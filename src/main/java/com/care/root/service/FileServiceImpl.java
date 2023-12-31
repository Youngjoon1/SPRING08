package com.care.root.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.dto.FileDTO;
import com.care.root.mybatis.FileMapper;

@Service
public class FileServiceImpl implements FileService {
	@Autowired FileMapper mapper;
	
	
	public void fileProcess(String id,String name, MultipartFile file) {
		FileDTO dto = new FileDTO();
		dto.setId(id);
		dto.setName(name);
		
		if(file.getSize() != 0 ) { // !file.isEmpty(), file.isEmpty() == false
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
			//sysFileName = 2022090901
			String sysFileName = fo.format(new Date());
			sysFileName += file.getOriginalFilename();
			System.out.println("sysFileName : " + sysFileName);
			File saveFile = new File(IMAGE_REPO + "/" +sysFileName);
			try {
				file.transferTo(saveFile);
				dto.setImgName(sysFileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			dto.setImgName("nan");
		}
		try {
			mapper.saveData(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<FileDTO> getData() {
		List<FileDTO> list = null;
		
		try {
			list = mapper.getData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void delete(String file,String id) {
		try {
			int result = mapper.delete(id);
			if( result == 1) {
				File d = new File(IMAGE_REPO+"/"+file);
				if(d.exists()) {
					d.delete();
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public FileDTO getInfo(String id) {
		FileDTO dto = null;
		
		try {
			dto = mapper.getInfo(id);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public void modify(String id,String name,MultipartFile file) {
		FileDTO dto = new FileDTO();
		dto.setId(id);
		dto.setName(name);
		File d = new File(IMAGE_REPO+"/"+mapper.getInfo(id).getImgName());
		d.delete();
		
		
		if(file.isEmpty() == false) {
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
			String sysFileName = fo.format(new Date());
			sysFileName += file.getOriginalFilename();
			File saveFile = new File(IMAGE_REPO + "/" +sysFileName);
			try {
				file.transferTo(saveFile);
				dto.setImgName(sysFileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			dto.setImgName("nan");
		}
		try {
			mapper.updateInfo(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void modifyName(String id,String name,MultipartFile file,String OriId) {
		FileDTO dto = new FileDTO();
		
		File d = new File(IMAGE_REPO+"/"+mapper.getInfo(OriId).getImgName());
		d.delete();
		dto.setId(OriId);
		dto.setName(name);
		if(file.isEmpty() == false) {
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
			String sysFileName = fo.format(new Date());
			sysFileName += file.getOriginalFilename();
			File saveFile = new File(IMAGE_REPO + "/" +sysFileName);
			try {
				file.transferTo(saveFile);
				dto.setImgName(sysFileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			dto.setImgName("nan");
		}
		try {
			mapper.updateInfo(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!OriId.equals(id)) {
			dto.setId(id);
			mapper.updateId(dto);
		}
	}
	
	
	
	
}
