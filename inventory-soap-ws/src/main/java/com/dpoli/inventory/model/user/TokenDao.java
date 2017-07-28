package com.dpoli.inventory.model.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class TokenDao {

	private static Map<TokenUser, User> USERS = new LinkedHashMap<>();

	public TokenDao() {
		addUsersToMap();
	}

	public boolean isValid(TokenUser user) {
		return USERS.containsKey(user);
	}

	private void addUsersToMap() {
		USERS.put(
				new TokenUser("AAA", parseDate("31/12/2015")),
				new User.Builder().withName("Diego").withLogin("diego").withPassword("pass").build());
		USERS.put(
				new TokenUser("BBB", parseDate("31/12/2015")),
				new User.Builder().withName("John").withLogin("john").withPassword("pass").build());
		USERS.put(
				new TokenUser("CCC", parseDate("31/12/2015")),
				new User.Builder().withName("Paul").withLogin("paul").withPassword("pass").build());
		USERS.put(
				new TokenUser("DDD", parseDate("31/12/2015")),
				new User.Builder().withName("Rick").withLogin("rick").withPassword("pass").build());
	}

	private Date parseDate(String dateAsString) {
		try {
			return new SimpleDateFormat("dd/MM/yyyy").parse(dateAsString);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

}
