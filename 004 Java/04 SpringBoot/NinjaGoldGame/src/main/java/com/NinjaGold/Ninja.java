package com.NinjaGold;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ninja {
	
	@RequestMapping("/gold")	
	public String main(HttpSession session,Model model) {
		if (session.getAttribute("gold")== null ) {
			session.setAttribute("gold",0);
		}
		if (session.getAttribute("result")== null ) {
			session.setAttribute("result","");
		}
		model.addAttribute("gold", (Integer) session.getAttribute("gold"));
		model.addAttribute("result", (String) session.getAttribute("result"));
		if((Integer)session.getAttribute("gold")<-40) {
			return ("jail.jsp");
		}else {
		
		
		return ("ninja.jsp");}
	}
	
	@RequestMapping(value="/process_money", method=RequestMethod.POST)	
	public String process_money(HttpSession session,@RequestParam(value="which_form") String which_form) {

		Date date = new Date();
		session.setAttribute("date",date);
		if(which_form.equals("farm")) {
			Random randMachine =  new Random();
			int num = randMachine.nextInt(20 - 10) + 10;
			session.setAttribute("gold",((Integer)session.getAttribute("gold")+num));
			String result= "Earned "+num + "golds from the farm!"+date+"<br/>";
			session.setAttribute("result",(String) session.getAttribute("result")+result);
		}else if(which_form.equals("cave")) {
			Random randMachine =  new Random();
			int num = randMachine.nextInt(10 - 5) + 5;
			session.setAttribute("gold",((Integer)session.getAttribute("gold")+num));
			String result= "Earned "+num + "golds from the cave!"+date+"<br/>";
			session.setAttribute("result",(String) session.getAttribute("result")+result);
		}else if(which_form.equals("house")) {
			Random randMachine =  new Random();
			int num = randMachine.nextInt(5 - 2) + 2;
			session.setAttribute("gold",((Integer)session.getAttribute("gold")+num));
			String result= "Earned "+num + "golds from the cave!"+date+"<br/>";
			session.setAttribute("result",(String) session.getAttribute("result")+result);
		}else if(which_form.equals("casino")){
			Random randMachine =  new Random();
			int num = randMachine.nextInt(50 - -50) + -50;
			session.setAttribute("gold",((Integer)session.getAttribute("gold")+num));
			if(num < 0) {	
				String result= "Entered a casino and lost "+num + "golds...Ouch!!..."+date+"<br/>";
				session.setAttribute("result",(String) session.getAttribute("result")+ result);
			}else {
				String result= "Entered a casino and earned "+num + "golds"+date+"<br/>";
				session.setAttribute("result",(String) session.getAttribute("result")+ result);
			}
		}else {
			Random randMachine =  new Random();
			int num = randMachine.nextInt(-5 - -20) + -20;
			session.setAttribute("gold",((Integer)session.getAttribute("gold")+num));
			String result= "Earned "+num + "golds from the cave!"+date+"<br/>";
			session.setAttribute("result",(String) session.getAttribute("result")+result);
		}
		return ("redirect:/gold");
	}
	
	@RequestMapping("/destroy_session")	
	public String destroy(HttpSession session) {
		session.setAttribute("result","");
		session.setAttribute("gold",0);
		return ("redirect:/gold");
	}
}
