/*
 * Class: User
 * 
 * Created on Jul 16, 2015
 * 
 * (c) Copyright Lam Research Corporation, unpublished work, created 2015
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Lam Research Corporation
 * 4000 N. First Street
 * San Jose, CA
 */
package models;

import java.util.List;

import javax.persistence.Entity;

import play.modules.mongodb.jackson.MongoDB;

import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.ObjectId;

@Entity
public class User
{

    @Id
    @ObjectId
    public String id;

    public String username;

    public String password;

    private static JacksonDBCollection<User, String> coll = MongoDB.getCollection("users", User.class, String.class);

    public static boolean login(String username, String password)
    {
        List<User> all = User.all();
        for (User user : all)
        {
            if (user.username.equals(username) && user.password.equals(password))
            {
                return true;
            }
        }
        return false;
    }

    public static List<User> all()
    {
        return coll.find().toArray();
    }

}
