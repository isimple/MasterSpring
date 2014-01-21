package dao;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: yang
 * Date: 14-1-22
 */
@Repository
public class UserDao {

    @Autowired
    /**
     * 分装了JDBC的连接,创建,获取,结果
     */
    private JdbcTemplate jdbcTemplate;

    /**
     *
     * @param userName
     * @param password
     * @return 1 true ; 0 false
     */
    public int getMatchCount(String userName,String password){
        String sql = "select count(*) from t_user where user_name=? and password=?";
        return jdbcTemplate.queryForInt(sql,new Object[]{userName,password});
    }


    public User findUserByUserName(final String userName){
        String sql = "select user_id,user_name,credits from t_user where user_name=?";
        final User user = new User();
        jdbcTemplate.query(sql,new Object[]{userName},new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                user.setCredits(rs.getInt("credits"));
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(userName);
            }
        });
        return user;
    }

    public void updateLoginInfo(User user){
        String sql = "update t_user set last_visit=?,last_ip=?,credits=? where user_id=?";
        jdbcTemplate.update(sql,new Object[]{user.getLastVisit(),user.getLastIp(),user.getUserId()});
    }


}
