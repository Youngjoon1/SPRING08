package com.care.root.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.care.root.dto.FileDTO;

public interface FileService {
	public void fileProcess(String id,String name, MultipartFile file);
	
	public String IMAGE_REPO = "C:\\spring\\image_repo"; //위치 정보 등록
	
	public List<FileDTO> getData();
	
	public void delete(String file,String id);
	
	public FileDTO getInfo(String id);
	
	public void modify(String id,String name,MultipartFile file);
	
	public void modifyName(String id,String name,MultipartFile file,String oriId);
	
}
