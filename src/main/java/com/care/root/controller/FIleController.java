package com.care.root.controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.dto.FileDTO;
import com.care.root.service.FileService;



@Controller
@RequestMapping("file")
public class FIleController {
	
	@Autowired FileService fs;
	
	
	@GetMapping("form")
	public String form() {
		return "file/uploadForm";
	}
	
	@PostMapping("upLoad1")
	public String upLoad1(@RequestParam String id,@RequestParam String name,@RequestParam MultipartFile file) {
		System.out.println(id);
		System.out.println(name);
		System.out.println(file.getOriginalFilename());
		
		fs.fileProcess(id,name,file);
		
		return "redirect:form"; 	
		
	}
	
	
	@PostMapping("upLoad2")
	public String upLoad2(MultipartHttpServletRequest mt) {
		
		System.out.println("-----------------------------");
		System.out.println(mt.getParameter("id"));
		System.out.println(mt.getParameter("name"));
		MultipartFile file = mt.getFile("file");
		System.out.println(file.getOriginalFilename());
		
		return "redirect:form";
	}
	
	@GetMapping("views")
	public String views(Model model) {
		model.addAttribute("list", fs.getData());
		return "file/result";
	}
	
	@GetMapping("downLoad")
	public void downLoad(@RequestParam String file, HttpServletResponse res) throws Exception {
		res.addHeader("Content-disoisition", "attachment; fileName=" + URLEncoder.encode(file,"utf-8"));
		
		File f = new File(FileService.IMAGE_REPO + "/"+ file);
		if(f.exists()) {
		FileInputStream in = new FileInputStream(f);
		FileCopyUtils.copy(in,res.getOutputStream());
		in.close();
		}
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam String file,@RequestParam String id) {
		fs.delete(file,id);
		
		return "redirect:views";
	}
	
	@GetMapping("modify_View")
	public String modify_View(@RequestParam String id,Model model) {
		model.addAttribute("info",fs.getInfo(id));
		return "file/modify_View";
	}
	
	@PostMapping("modify")
	public String modify(@RequestParam String id,@RequestParam String name,@RequestParam MultipartFile file) {
		fs.modify(id,name,file);
		
		return "redirect:views";
	}
	
	@PostMapping("modifyName")
	public String modifyName(@RequestParam String id,@RequestParam String name,@RequestParam MultipartFile file,@RequestParam String oriId) {
		
		fs.modifyName(id, name, file, oriId);
		
		
		return "redirect:views";
	}
	
	
}
