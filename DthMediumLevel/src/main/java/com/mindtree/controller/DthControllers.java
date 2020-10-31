package com.mindtree.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.dao.DthDao;
import com.mindtree.entity.Channels;
import com.mindtree.entity.Subscription_Channel;

@Controller
public class DthControllers {

	@Autowired
	DthDao dao;

	@RequestMapping("/sub")
	public ModelAndView dthSubscription() {
		List<Channels> list = dao.getAllChannels();
		ModelAndView mv = new ModelAndView();
		mv.addObject("clist", list);
		mv.setViewName("dthsub");
		return mv;
	}

	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/edit")
	public ModelAndView editSubcription() {
		ModelAndView mv = new ModelAndView();
		List<Channels> list = dao.getAllChannels();
		@SuppressWarnings("rawtypes")
		Iterator it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		mv.addObject("clist", list);
		mv.setViewName("editsub");
		return mv;
	}

	@RequestMapping("/viewaction")
	public ModelAndView viewDetails(@RequestParam("subscriber_id") String subid) {
		ModelAndView mv = new ModelAndView();
		double totalCost = 100;
		String msg = "";
		Map<String, List<Object>> model = new HashMap<String, List<Object>>();

		List<Object> list = dao.getDetails(Integer.parseInt(subid));
		List<Object> list1 = dao.getCustomerDetails(Integer.parseInt(subid));

		for (Object ch : list) {
			totalCost += ((Channels) ch).getCost_per_month();
		}
		if (list1.size() == 0) {
			msg = "No such customer is registered";
			mv.addObject("msg", msg);
			mv.setViewName("success");
			return mv;
		} else if (list.size() == 0) {
			msg = "No channel subscribed";
			mv.addObject("msg", msg);
			mv.setViewName("success");
			return mv;
		} else {
			model.put("userdetails", list1);
			model.put("subdetails", list);

			mv.addObject("lists", model);
			mv.addObject("totalcost", totalCost);
			mv.setViewName("viewdetails");
			return mv;
		}
	}

	@RequestMapping("/view")
	public ModelAndView viewSubscription() {
		return new ModelAndView("viewsub");
	}

	@RequestMapping("/addsub")
	public ModelAndView addSubs(HttpServletRequest request, HttpServletResponse response) {
		String msg = "";
		Subscription_Channel sc = new Subscription_Channel();
		sc.setChannel_id(dao.getChannelId(request.getParameter("channel_name")));
		sc.setSubscriber_id(Integer.parseInt(request.getParameter("subscriber_id")));
		sc.setSubscription_date(request.getParameter("subscription_date"));
		if (!dao.checkSubcription(sc.getChannel_id(), sc.getSubscriber_id())) {
			if (dao.addSubscription(sc)) {
				msg = "Successfully Subscribed";
				return new ModelAndView("success", "msg", msg);
			} else {
				msg = "No such customer registered with us";
				return new ModelAndView("success", "msg", msg);
			}
		} else {
			msg = "Subscription already exists";
			return new ModelAndView("success", "msg", msg);
		}
	}

	@RequestMapping("/editaction")
	public ModelAndView unsubcription(@RequestParam("subscriber_id") String id,
			@RequestParam("channelname") String ch) {
		int flag = 0;
		String msg = "Successfully Unsubscribed";
		flag = dao.unsubscribe(Integer.parseInt(id), ch);
		if (flag != 0)
			return new ModelAndView("success", "msg", msg);
		else {
			msg = "No such subscription";
			return new ModelAndView("success", "msg", msg);
		}
	}
}
