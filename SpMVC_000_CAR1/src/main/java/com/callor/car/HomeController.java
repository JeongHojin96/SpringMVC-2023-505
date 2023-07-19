package com.callor.car;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.car.dao.CarDao;
import com.callor.car.models.CarDto;
@Controller
public class HomeController {

	private final CarDao carDao;

	public HomeController(CarDao carDao) {
		this.carDao = carDao;
	}
	
	@ModelAttribute
	public CarDto carDTo() {
		CarDto carDto = new CarDto();
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	
		carDto.setC_sdate(dateFormat.format(date));
		carDto.setC_stime(timeFormat.format(date));
		
		return carDto;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<CarDto> carList = carDao.selectAll();
		model.addAttribute("CAR_LIST", carList);

		return "home";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String insert(CarDto carDto, Model model) {
		carDao.insert(carDto);
		
		return "redirect:/";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(String seq, Model model) {

		CarDto carDto = carDao.findByseq(seq);
		model.addAttribute("CAR", carDto);
		return "detail";
	}
}
