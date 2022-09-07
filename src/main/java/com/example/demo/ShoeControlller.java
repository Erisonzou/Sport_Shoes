package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoeControlller {
	
	
	@Autowired
	ShoeDAO dao;
	
	@Autowired
	PurchaseDAO pdao;
	
	Logger log = Logger.getAnonymousLogger();
	
	@RequestMapping("/newShoe")
	public ModelAndView newShoe(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("newShoeProduct.jsp");
		return mv;
		}

@RequestMapping("/insert")
	public ModelAndView insert(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Shoe s = new Shoe();
		s.setName(request.getParameter("Sname"));
		s.setPrice(Integer.parseInt(request.getParameter("Sprice")));
		s.setBrand(request.getParameter("Sbrand"));
		s.setSize(Integer.parseInt(request.getParameter("Ssize")));
		s.setQuantity(Integer.parseInt(request.getParameter("Squantity")));
		Shoe ss = dao.insertShoe(s);
		if(ss!=null) {
			mv.setViewName("ShoeInsertStatus.jsp");
		}
		
		return mv;
		
	}

	
@RequestMapping("/get")
public ModelAndView getall(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();	
	List<Shoe> list=dao.getallShoe();
	if (list != null) {
	mv.setViewName("CurrentShoe.jsp");
	mv.addObject("list",list);
	}
	return mv;
	
}

@RequestMapping("/getBrand")
public ModelAndView getallBrand(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();	
	List<Shoe> Shoelist=dao.getallShoeBrand(request.getParameter("Brand"));
	if (Shoelist != null) {
	mv.setViewName("ShoeBrand.jsp");
	mv.addObject("ShoeList",Shoelist);
	}
	return mv;
}
@RequestMapping("/allShoesToBuy")
public ModelAndView getallShoesToBuy(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();	
	List<Shoe> list=dao.getallShoe();
	if (list != null) {
	mv.setViewName("ShoetoBuy.jsp");
	mv.addObject("list",list);
	}
	return mv;
}
@RequestMapping("/update")
public ModelAndView update(HttpServletRequest request,HttpServletResponse response) {
	
	log.info("inside the update");
	ModelAndView mv=new ModelAndView();
	Shoe s=new Shoe();
	s.setName(request.getParameter("id"));
	s.setPrice(Integer.parseInt(request.getParameter("price")));
	log.info(s.getName()+"   "+s.getPrice());
	Shoe ss=dao.updateName(s);
	if(ss!=null) {
		mv.setViewName("update.jsp");
	}
	return mv;
}
@RequestMapping("/delete")
public ModelAndView deleteUpdate(HttpServletRequest request,HttpServletResponse response) {
	
	log.info("inside the update");
	ModelAndView mv=new ModelAndView();
	dao.deleteByShoeId(request.getParameter("id"));
	mv.setViewName("update.jsp");
	return mv;
}

@RequestMapping("/AdminMain")
public ModelAndView AdminMain(HttpServletRequest request,HttpServletResponse response) {
	
	ModelAndView mv=new ModelAndView();
	mv.setViewName("Admin.jsp");
	return mv;
}

@RequestMapping("/userShoeBrand")
public ModelAndView userShoeBrand(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();	
	
	List<Shoe> Shoelist=dao.getallShoeBrand(request.getParameter("Brand"));
	
	if (Shoelist != null) {
	mv.setViewName("UserShoebrand.jsp");
	mv.addObject("ShoeList",Shoelist);
	}
	
	return mv;
}
@RequestMapping("/buy")
public ModelAndView ShoePurchased(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();	
	LocalDateTime now = LocalDateTime.now();
	Purchase p = new Purchase();
	log.info("Created mv, Purhase,LocalDateTime variable");
	p.setUser(request.getParameter("user"));
	p.setTime(now);
	log.info("set User to the given Parametern and time to now");
	Shoe s = dao.findbyId(request.getParameter("shoe"));
	log.info("Searched and grab shoe by name");
	p.setShoeName(s.getName());
	p.setShoeBrand(s.getBrand());
	p.setShoePrice(s.getPrice());
	p.setShoeSize(s.getSize());
	log.info("gave p the appropraite info");
	
	Purchase pp = pdao.insertPurchase(p);
	log.info("saved p");
	if(pp!=null) {
		mv.setViewName("PurchaseComplete.jsp");
	}
	return mv;
}

@RequestMapping("/purchaseList")
public ModelAndView ShoePurchase(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();	
	
	List<Purchase> Purchaselist=pdao.getallPurchase(request.getParameter("user"));
	
	if (Purchaselist != null) {
	mv.setViewName("AdminPurchases.jsp");
	mv.addObject("Purchases",Purchaselist);
	}
	
	return mv;
}

@RequestMapping("/MainMenuU")
public ModelAndView UserMain(HttpServletRequest request,HttpServletResponse response) {
	
	ModelAndView mv=new ModelAndView();
	mv.setViewName("display.jsp");
	return mv;
}

}

