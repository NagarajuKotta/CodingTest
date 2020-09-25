package com.kgn.business.rules.order.controller;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgn.business.rules.order.entity.BusinessRuleEngine;

@RestController
@RequestMapping("/order")
public class BusinessRuleEngineOrdersController {

	@Autowired
	KieSession kieSession;
	
	@PostMapping("/rules")
	public BusinessRuleEngine executeOrders(@RequestBody BusinessRuleEngine rule) {
		
		kieSession.insert(rule);
		kieSession.fireAllRules();
		return rule;
	}
}