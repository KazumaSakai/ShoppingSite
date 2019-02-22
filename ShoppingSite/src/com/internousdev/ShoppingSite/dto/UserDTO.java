package com.internousdev.ShoppingSite.dto;

public class UserDTO {
	private int id;
	private boolean admin;
	private boolean oauthUser;
	private String login_id;
	private String email;
	private String login_pass;
	private String user_name;
	private String insert_date;
	private boolean loginFlg;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean getLoginFlg() {
		return loginFlg;
	}

	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getLogin_pass() {
		return login_pass;
	}

	public void setLogin_pass(String login_pass) {
		this.login_pass = login_pass;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getInsert_date() {
		return insert_date;
	}

	public void setInsert_date(String insert_date) {
		String[] date_seconds = insert_date.split(" ");
		String[] dates = date_seconds[0].split("-");
		String[] seconds = date_seconds[1].split(":");

		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(dates[0]).append("年").append(dates[1]).append("月").append(dates[2]).append("日 ").append(seconds[0]).append("時");

		this.insert_date = sBuilder.toString();
	}

	public boolean getOauthUser() {
		return oauthUser;
	}

	public void setOauthUser(boolean oauthUser) {
		this.oauthUser = oauthUser;
	}
}
