package com.dpoli.inventory.ws;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {

	private String pattern = "MM/dd/yyyy";

	public Date unmarshal(String dateString) throws Exception {
		return new SimpleDateFormat(pattern).parse(dateString);
	}

	public String marshal(Date date) throws Exception {
		return new SimpleDateFormat(pattern).format(date);
	}
}
