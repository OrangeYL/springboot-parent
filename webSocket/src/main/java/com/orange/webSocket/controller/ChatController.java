package com.orange.webSocket.controller;

import com.orange.webSocket.entity.User;
import com.orange.webSocket.service.LoginService;
import com.orange.webSocket.service.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.Session;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class ChatController {

	@Autowired
	LoginService loginservice;


	@RequestMapping("/onlineUsers")
	@ResponseBody
	public Set<String> onlineUsers(@RequestParam("currentUser") String currentUser) {
		ConcurrentHashMap<String, Session> map = WebSocketServer.getSessionPools();
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		Set<String> nameSet = new HashSet<String>();
		while (it.hasNext()) {
			String entry = it.next();
			if (!entry.equals(currentUser))
				nameSet.add(entry);
		}
		return nameSet;
	}


	@RequestMapping("getId")
	@ResponseBody
	public User getuid(@RequestParam("username") String username) {
		int id = loginservice.getIdByName(username);
		User u = new User();
		u.setId(id);
		return u;
	}
}
