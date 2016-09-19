package cn.w28l30.dao;

import cn.w28l30.domain.User;

public interface Userdao {

	void add(User user);

	User find(String id);

	User find(String username, String password);

}
