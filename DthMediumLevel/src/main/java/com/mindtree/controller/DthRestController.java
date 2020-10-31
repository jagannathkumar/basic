/**
 * 
 */
package com.mindtree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mindtree.dao.DthDao;
import com.mindtree.entity.Channels;

/**
 * @author M1044482
 *
 */

@EnableWebMvc
@RestController
@CrossOrigin
@RequestMapping(value="/rest")
public class DthRestController {

	@Autowired
	DthDao dao;
	
	@RequestMapping(value="/getall1",method=RequestMethod.GET,produces="application/json")
	public List<Channels> getchannels()
	{
		List<Channels> ch=dao.getAllChannels();
		return ch;
	}
	
	@RequestMapping(value="/str",method=RequestMethod.GET)
	public String qwerty()
	{
		return "Check";
	}
	
}
