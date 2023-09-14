package com.care.root.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.care.root.dto.InfoDTO;

@Controller
public class AjaxController {
	
	@GetMapping("non_ajax")
	public String nonAjax() {
		System.out.println("non_ajax");
		return "ajax/non_ajax";
	}
	
	@GetMapping("ajax01")
	public String ajax01() {
		System.out.println("=========");
		System.out.println("ajax01");
		return "ajax/ajax01";
	}
	
	@GetMapping("ajax_test")
	public void ajaxTest() {
		System.out.println("ajax_test");
	}
	
	@GetMapping("ajax02")
	public String ajax02() {
		return "ajax/ajax02";
	}
	
	int cnt = 0;
	@GetMapping("result02")
	@ResponseBody //데이터를 리턴할 때 사용
	public String result02() {
		return "" + cnt++;
	}
	
	@GetMapping("ajax03")
	public String ajax03() {
		return "ajax/ajax03";
	}
	
	
	@PostMapping(value="result03", produces = "application/json; charset=utf-8")// 어떠한 형식으로 받을지 여기에서도 명시
	@ResponseBody //데이터를 리턴할 때 사용
	public InfoDTO result03(@RequestBody InfoDTO dto) {
		System.out.println("이름 : " + dto.getName());
		System.out.println("나이 : " + dto.getAge());
		dto.setName("서버 수정 이름");
		dto.setAge(111111);
		return dto;
	}
	
	@GetMapping("ajax04")
	public String ajax04() {
		return "ajax/ajax04";
	}
	
	
	@PostMapping(value="result04", produces = "application/json; charset=utf-8")// 어떠한 형식으로 받을지 여기에서도 명시
	@ResponseBody //데이터를 리턴할 때 사용
	public Map<String,String> result04(@RequestBody Map<String,String> map) {
		System.out.println(map);
		System.out.println(map.get("name"));
		map.put("nick", "점심 먹을 시간이네요~");
		return map;
	}
	
	@GetMapping("rest01")
	public String rest01() {
		return "ajax/rest01";
	}

	@GetMapping("member")
	public String member() {
		return "ajax/member";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
