End point URL's with Req & Res jsons

Swagger URL:   http://localhost:8080/swagger-ui/index.html#
Actuator URL: http://localhost:8080/actuator

UserProfile Controller:
**********************
Create Person(Post): http://localhost:8080/api/userprofile/persons
--------------------
Request:
{  
  "firstName": "James",
  "lastName": "Smith"
}

Response:
{
  "id": 1,
  "firstName": "James",
  "lastName": "Smith"
}

Create Address(Post): http://localhost:8080/api/userprofile/persons/1/address
--------------------
Request:
{
 
  "street": "123 Main Street",
  "city": "Orlando",
  "zipCode": "12345",
  "country": "USA",
  "personId": 1
}

Response:
{
  "id": 1,
  "street": "123 Main Street",
  "city": "Orlando",
  "zipCode": "12345",
  "country": "USA",
  "personId": 1
}


Create Address(Get): http://localhost:8080/api/userprofile/1
--------------------
Request:
http://localhost:8080/api/userprofile/1

Response:
{
  "person": {
    "id": 1,
    "firstName": "James",
    "lastName": "Smith"
  },
  "address": [
    {
      "id": 1,
      "street": "123 Main Street",
      "city": "Orlando",
      "zipCode": "12345",
      "country": "USA",
      "personId": 1
    }
  ]
}
