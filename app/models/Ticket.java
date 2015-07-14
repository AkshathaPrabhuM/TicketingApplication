package models;

import java.util.List;

import javax.persistence.Entity;

import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.ObjectId;
import play.modules.mongodb.jackson.MongoDB;

@Entity
public class Ticket
{

    @Id
    @ObjectId
    public String id;

    public String custName;

    public String comments;

    public String creator;

    public String assignee;

    public String status;

    private static JacksonDBCollection<Ticket, String> coll = MongoDB.getCollection("tickets", Ticket.class, String.class);

    public Ticket()
    {

    }

    public Ticket(String label, String description, String creator, String assignee, String status)
    {
        this.custName = label;
        this.comments = description;
        this.creator = creator;
        this.assignee = assignee;
        this.status = status;
    }

    public static List<Ticket> all()
    {
        return Ticket.coll.find().toArray();
    }

    public static void create(Ticket ticket)
    {
        Ticket.coll.save(ticket);
    }

    public static void create(String label, String description, String creator, String assignee, String status)
    {
        create(new Ticket(label, description, creator, assignee, status));
    }

    public static void delete(String id)
    {
        Ticket ticket = Ticket.coll.findOneById(id);
        if (ticket != null)
        {
            Ticket.coll.remove(ticket);
        }
    }

    public static void removeAll()
    {
        Ticket.coll.drop();
    }

    public static void update(Ticket ticket)
    {
        Ticket.coll.updateById(ticket.id, ticket);
    }

    public static Ticket get(String id)
    {
        Ticket ticket = Ticket.coll.findOneById(id);
        return ticket;
    }

}
