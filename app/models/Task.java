package models;

import java.util.List;

import javax.persistence.Entity;

import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.ObjectId;
import play.modules.mongodb.jackson.MongoDB;

@Entity
public class Task
{

    @Id
    @ObjectId
    public String id;

    public String custName;

    public String comments;

    public String creator;

    public String assignee;

    public String status;

    private static JacksonDBCollection<Task, String> coll = MongoDB.getCollection("tasks", Task.class, String.class);

    public Task()
    {

    }

    public Task(String label, String description, String creator, String assignee, String status)
    {
        this.custName = label;
        this.comments = description;
        this.creator = creator;
        this.assignee = assignee;
        this.status = status;
    }

    public static List<Task> all()
    {
        return Task.coll.find().toArray();
    }

    public static void create(Task task)
    {
        Task.coll.save(task);
    }

    public static void create(String label, String description, String creator, String assignee, String status)
    {
        create(new Task(label, description, creator, assignee, status));
    }

    public static void delete(String id)
    {
        Task task = Task.coll.findOneById(id);
        if (task != null)
        {
            Task.coll.remove(task);
        }
    }

    public static void removeAll()
    {
        Task.coll.drop();
    }

    public static void update(Task task)
    {
        Task.coll.updateById(task.id, task);
    }

    public static Task get(String id)
    {
        Task task = Task.coll.findOneById(id);
        return task;
    }

}
