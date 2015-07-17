Ticketing Application
--------------------------------------------------
The Ticketing sytem application allows customer service representatives to register complaints from the customer.

The features are:
* Logging the ticket
* Adding Comments to the Ticket
* Changing the status of the Ticket
* Assigning the Tickets
* Viewing the Tickets
* Deleting the Tickets


Starting the Application
--------------------------------------------------
The steps to start the application are as follows:

* Download this zip and extract it to desired location
* Start the MongoDB server. It should use the default host (localhost) and the default port.
* Create a collection in the Mongo Db with the name users. And add the default users in it.
* Run the below scripts for it.
```
use TicketingSystem
db.createCollection("users")
db.users.insert({
   username: 'aks', 
   password: 'aks',
})
```
* Run the application using the command  
```
activator run
```
* Open the browser and open the page http://localhost:9000/