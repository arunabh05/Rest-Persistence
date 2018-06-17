# Rest-Persistence

A set of REST APIs to manage entities and relationships in a mini gaming website. 

The general requirements and constraints were as follows,
- There are two primary types of entities: Players and Sponsors.
- They have the following relationships and constraints:
.. 1. Opponents: if two players play against each other, they are opponents.
.. 2. The opponent relationship is symmetric in that is Alice is an opponent of Bob, then Bob is also an opponent of Alice.
.. 3. A player can have zero or more opponent players. 
- Sponsors: a player can optionally be sponsored by an external sponsor. 
- Different players can have the same sponsor.
- The firstname, lastname, and email fields are required for any player. Emails have to be unique across players.
- The name field is required for any Sponsor, and does not need to be unique.

Additional requirements,
- All these operations should be transactional.
- Must use JPA for persistence.
- This system needs to be hosted on the cloud.
 
Partial definition of the related classes are provided below.

```javascript
package edu.sjsu.cmpe275.lab2;

public class Player {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String description;
    private Address address;
    private Sponsor sponsor;
    private List<Player> opponents;
    // constructors, setters, getters, etc.
}


public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;
    ...
}

public class Sponsor {
    private long id;
    private String name;
    private String description;
    private Address address;
    ...
}
```

## API Description

**_1. Create a player_**

__Path__: _player?firstname=XX&lastname=YY&email=ZZ&description=UU&street=VV$_

__Method__: _POST_

This API creates a player object. 

The request returns the newly created player object in JSON in its HTTP payload, including all attributes. (Please note this differs    from generally recommended practice of only returning the ID.) If the request is invalid, e.g., missing required parameters, the HTTP    status code should be 400; otherwise 200.


**_2. Get a player_**

__Path__: _player/{id}_

__Method__: _GET_

This returns a full player object in JSON in its HTTP payload. 

The JSON should contain the full sponsor object, if present. If the player of the given user ID does not exist, the HTTP return code should be 404; otherwise, 200.

**_3. Update a player_**

__Path__: _player/{id}?firstname=XX&lastname=YY&email=ZZ&description=UU&street=VV$..._

__Method__: _POST_

This API updates a player object. 

The request returns the updated player object, including all attributes (first name, last name, email, opponents, sponsor, etc), in JSON. If the player ID does not exist, 404 should be returned. If required parameters are missing, return 400 instead. Otherwise, return 200.

**_4. Delete a player_**

__URL__: _player/{id}_

__Method__: _DELETE_

This deletes the player object with the given ID. 

If the player with the given ID does not exist, return 404.
Otherwise, delete the player and remove any reference of this player from your persistence of opponent relations, and return HTTP status code 200 and the deleted player in JSON. 

**_5. Create an sponsor_**

__Path__: _sponsor?name=XX&description=YY&street=ZZ&..._

__Method__: _POST_

This API creates an sponsor object. 

The request returns the newly created sponsor object in JSON in its HTTP payload, including all attributes.
If the request is invalid, e.g., missing required parameters, the HTTP status code should be 400; otherwise 200.


**_6. Get a sponsor_**
__Path__: _sponsor/{id}_

__Method__: _GET_

This returns a full sponsor object in JSON in its HTTP payload. 

All existing fields, including name, description, street, and city, should be returned. 
If the sponsor of the given ID does not exist, the HTTP return code should be 404; otherwise, 200.

**_7. Update a sponsor_**

__Path__: _sponsor/{id}?name=XX&description=YY&street=ZZ&..._

__Method__: _POST_

This API updates a sponsor object. 

The request returns the updated sponsor object, including all attributes in JSON. If the sponsor ID does not exist, 404 should be returned. If required parameters are missing, return 400 instead. Otherwise, return 200.

**_8. Delete a sponsor_**

__Path__: _sponsor/{id}_

__Method__: _DELETE_

This method deletes the sponsor object with the given ID. 

If there is still any player belonging to this sponsor, return 400. 
If the sponsor with the given ID does not exist, return 404.
Return HTTP code 200 and the deleted object in JSON if the object is deleted; 

**_9. Add an opponent_**

__Path__: _opponents/{id1}/{id2}_

__Method__: _PUT_

This makes the two players with the given IDs opponents with each other. 

If either player does not exist, return 404. 
If the two players are already opponents, do nothing, just return 200. Otherwise,
Record this opponent relation. If all is successful, return HTTP code 200 and any informative text message in the payload.

**_10. Remove an opponent_**

__Path__: _opponents/{id1}/{id2}_

__Method__ : _DELETE_

This request removes the opponent relation between the two players.

If either player does not exist, return 404. 
If the two players are not opponents, return 404. Otherwise,
Remove this opponent relation. Return HTTP code 200 and a meaningful text message if all is successful.
