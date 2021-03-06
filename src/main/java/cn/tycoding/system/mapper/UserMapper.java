package cn.tycoding.system.mapper;

import cn.tycoding.common.config.MyMapper;
import cn.tycoding.system.entity.User;
import cn.tycoding.system.entity.UserWithRole;
import java.util.List;

/**
 * @author tycoding
 * @date 2019-01-19
 */
public interface UserMapper extends MyMapper<User> {

	List<User> queryList(User user);

	List<User> list(User user);

	List<UserWithRole> findById(Long id);

	User get(Long id);


}
