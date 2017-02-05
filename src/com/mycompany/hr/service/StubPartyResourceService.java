package com.mycompany.hr.service;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class StubPartyResourceService implements PartyResourceService {
	public void bookHoliday(Date startDate, Date endDate, String name) {
		System.out.println("Booking holiday for [" + startDate + "-" + endDate + "] for [" + name + "] ");
	}
}