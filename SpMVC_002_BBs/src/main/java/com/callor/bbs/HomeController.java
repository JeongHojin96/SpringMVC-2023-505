package com.callor.bbs;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.bbs.dao.BBsDao;
import com.callor.bbs.dto.BBsDto;

@Controller
public class HomeController {

	private final BBsDao bbsDao;

	public HomeController(BBsDao bbsDao) {
		this.bbsDao = bbsDao;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

//		List<BBsDto> bbsList = bbsDao.selectAll();
		List<BBsDto> bbsList = bbsDao.findUserSelectLimit();
		model.addAttribute("BBS_LIST", bbsList);
		return "home";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(String seq, Model model) {
		// request 에 설정된 id 값으로 DB table 에서 주소 정보를 SELECT
		BBsDto bbsDto = bbsDao.findBySeq(seq);

		// SELECT 된 주소를 model 에 담아서 view 로 전달
		model.addAttribute("BBS", bbsDto);

		// home.jsp 에 include 되어 보여질 화면(변수) 세팅
		return "detail";
	}

}
