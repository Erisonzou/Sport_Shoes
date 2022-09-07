package com.example.demo;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class UserController {
	
@Autowired
	UserRepo repo;
	ShoeDAO sDao;

	Logger log = Logger.getAnonymousLogger();
	
	@RequestMapping("/")
	public ModelAndView loadpage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv =  new ModelAndView();
		mv.setViewName("login.jsp");
		return mv;
	}
	
	
	@RequestMapping("/login")
	public ModelAndView loginlogic(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv =  new ModelAndView();
		log.info("entered into the login request mapping");
		
		String username = request.getParameter("user");
		String password=request.getParameter("pwd");
		log.info("got the data from the front page");
		
		if(repo.findbyuser(username)!=null&&repo.findbypassword(password)!=null) {
			
			if(repo.findbyuser(username).equals(repo.findbypassword(password))) 
			{
				
				if(repo.findbyuser(username).getUserType().equals("admin")){
					log.info("Admin login is successful");
					mv.setViewName("Admin.jsp");
					log.info("control passed to admin.jsp");
				}
				else 
				{
				
				log.info("login is success");
				
				mv.setViewName("display.jsp");
				mv.addObject("userid",username);
				}
				log.info("control passed to display.jsp");
				}
			}
			else
			{
			mv.setViewName("fail.jsp");
			log.info("control pass to fail.jsp");
			}
		
		return mv;
	}
	
	RestTemplate temp=new RestTemplate();
	
	@ResponseBody
	@RequestMapping("/registermsconfig")
	public ModelAndView registermsconfig(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mv=new ModelAndView();
		String user=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		log.info("inside register ms and data set");
		
		String url="http://localhost:8084/register-user/"+user+"/"+password+"/"+email;
		temp.getForObject(url, String.class);
		log.info("control went to register ms");
		mv.setViewName("DoneRegistration.jsp");
		return mv;
	}
	
	@RequestMapping("/CurrentUsers")
	public ModelAndView CurrentUsers(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		List<User> list= repo.findAll();
		if (list != null) {
		mv.setViewName("CurrentUsers.jsp");
		mv.addObject("list",list);
		}
		return mv;
		}
	
	@RequestMapping("/UserHistory")
	public ModelAndView UserhistoryMain(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mv=new ModelAndView();
		List<User> list= repo.findAll();
		if (list != null) {
		mv.setViewName("ChooseUserHistory.jsp");
		mv.addObject("list",list);
		}
		return mv;
		}
	
	@RequestMapping("/deleteUser")
	public ModelAndView deleteUpdate(HttpServletRequest request,HttpServletResponse response) {
		
		log.info("inside the update");
		ModelAndView mv=new ModelAndView();
		repo.deleteById(request.getParameter("id"));
		mv.setViewName("updateUser.jsp");
		return mv;
	}
	
	@RequestMapping("/editUser")
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response) {
		
		log.info("inside the update");
		ModelAndView mv=new ModelAndView();
		User s=new User();
		s.setUsername(request.getParameter("id"));
		s.setUserType(request.getParameter("type"));
		log.info(s.getUserType());
		User ss = repo.findById(s.getUsername()).orElse(null); 
		ss.setUsername(s.getUsername());
		repo.save(ss);
		if(ss!=null) {
			mv.setViewName("UpdateUser.jsp");
		}
		return mv;
	}
	
}

