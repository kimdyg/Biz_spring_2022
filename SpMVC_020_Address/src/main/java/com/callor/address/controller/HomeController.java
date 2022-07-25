package com.callor.address.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.address.model.AddressVO;
import com.callor.address.model.SearchPage;
import com.callor.address.service.impl.AddressServiceImplV1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@Service
public class HomeController {

	private final AddressServiceImplV1 addrServiceImpl;

	public HomeController(AddressServiceImplV1 addrServiceImpl) {
		this.addrServiceImpl = addrServiceImpl;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, @RequestParam(name="pageno", required =false, defaultValue = "0") int pageno) {
		// List<AddressVO> addrList = addrServiceImpl.selectAll();
		//model.addAttribute("ADDRS", addrList);
		SearchPage searchPage = SearchPage.builder()
									.a_name("")
									.limit(10)
									.offset(pageno * 10)
									.build();
		
		searchPage.setCurrentPageNo(pageno);
		// 페이지 계산
		addrServiceImpl.searchAndPage(model, searchPage);
		
		List<AddressVO> addrList1 = addrServiceImpl.searchAndPage(searchPage);
		model.addAttribute("ADDRS",addrList1);

		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(Model model, AddressVO addressVO) {

		addrServiceImpl.insert(addressVO);
		log.debug(addressVO.toString());
		log.debug("받은데이터 {}", addressVO.toString()); // 중괄호 안에 데이터가 들어감

		return "redirect:/";
	}

	/*
	 * // 요청 http://localhost:8080/address/detail?seq=3
	 * 
	 * @RequestMapping(value = "/detail", method = RequestMethod.GET) public String
	 * detail(@RequestParam("seq") String strSeq, Model model) { log.debug("SEQ {}",
	 * strSeq); long a_seq = Long.valueOf(3); addrServiceImpl.findById(a_seq);
	 * log.debug("SEQ {}", a_seq);
	 * 
	 * AddressVO addr = addrServiceImpl.findById(a_seq); log.debug("find {}",
	 * addr.toString()); model.addAttribute("ADDR",addr); return "detail"; }
	 */
	// 숫자형 매개변수를 사용하면서 
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam(name = "seq", required = false, defaultValue = "0") long a_seq, Model model) {
		log.debug("SEQ {}", a_seq);
		AddressVO vo = addrServiceImpl.findById(a_seq);
		log.debug("findById seq {}", vo.toString());
		model.addAttribute("ADDR", vo);
		return "detail";
	}

	/*
	 * @RequestMapping(value = "/detail",method=RequestMethod.GET) public String
	 * detail(@RequestParam( name = "seq", required = false, defaultValue = "0")
	 * long a_seq) { log.debug("SEQ {}", a_seq); return "detail";
	 * 
	 * }
	 */
	
	@RequestMapping(value ="/update", method = RequestMethod.GET)
	public String update(@RequestParam(name = "seq", required = false, defaultValue = "0") long a_seq, Model model) {
		AddressVO vo = addrServiceImpl.findById(a_seq);
		model.addAttribute("ADDR",vo);
		return "home";	
	}
	@RequestMapping(value ="/update", method = RequestMethod.POST)
	public String update(@RequestParam("seq") long seq, AddressVO vo) {
		vo.setA_seq(seq);
		addrServiceImpl.update(vo);
		return "redirect:/detail?seq=" +seq;
	}

	@RequestMapping(value ="/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(name = "seq", required = false, defaultValue = "0") long a_seq) {
		addrServiceImpl.delete(a_seq);
		return "redirect:/";
	}
}
