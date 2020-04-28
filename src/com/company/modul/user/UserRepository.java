package com.company.modul.user;

import com.company.modul.DBConnector;
import com.company.modul.IRepository;
import com.mysql.cj.protocol.Resultset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepository implements IRepository {
    private DBConnector dbConnector;

    public UserRepository (){
        this.dbConnector = DBConnector.getInstance();
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Object findOne(int id) {
        return null;
    }

    @Override
    public boolean create(Object entity) {
        User user = (User) entity;
        if(dbConnector.insert("INSERT INTO `cineast`(`id`) VALUES (null)")){
            //following sql is not perfect. But LAST_INSET_ID() is connection specific. Since connection after the last
            //insert was closed result would be always 0
            ResultSet rs = dbConnector.fetchData("SELECT MAX(id) FROM cineast");
            try {
                if (rs.next()) {
                    int id = rs.getInt("MAX(id)");
                    user.setId(id);
                }
            } catch (SQLException ex){
                System.out.println("could't get LAST_INSERT_ID()");
                ex.printStackTrace();
            } finally {
                dbConnector.closeConnection();
            }
            return true;
        } else { return false; }


    }


}
