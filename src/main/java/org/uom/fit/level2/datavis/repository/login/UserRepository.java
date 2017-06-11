package org.uom.fit.level2.datavis.repository.login;


import org.springframework.data.repository.CrudRepository;
import org.uom.fit.level2.datavis.model.login.User;


public interface UserRepository extends CrudRepository<User,String> {
    public User findByUserName(String userName);
    public User findByPassword(String password);


}
