package com.dpoli.inventory.model.user;

public class User {

	private String name;
	private String login;
	private String password;

	User(String name, String login, String password) {
		this.name = name;
		this.login = login;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public static class Builder {

		private String name;
		private String login;
		private String password;

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withLogin(String login) {
			this.login = login;
			return this;
		}

		public Builder withPassword(String password) {
			this.password = password;
			return this;
		}

		public User build() {
			return new User(name, login, password);
		}
	}
}
