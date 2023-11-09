End point URL's with Req & Res jsons

Swagger URL:   http://localhost:8080/swagger-ui/index.html#

Student Controller:
**********************
Create Student(Post): http://localhost:8080/api/students
--------------------------------
Request:
{
    "firstName": "Raj",
    "lastName": "Kumar",
    "dateOfBirth": "2014-10-01",
    "address": "456 Main Street"
}

Response:
{
  "id": 1,
  "firstName": "Raj",
  "lastName": "Kumar",
  "dateOfBirth": "2014-09-30",
  "address": "456 Main Street"
}

Update Student(Put):    http://localhost:8080/api/students
--------------------
Update any field
Request json:
{
  "id": 1,
  "firstName": "Dev",
  "lastName": "Kumar",
  "dateOfBirth": "2015-08-20",
  "address": "4567 Main Street"
}
Response json:
{
  "id": 1,
  "firstName": "Dev",
  "lastName": "Kumar",
  "dateOfBirth": "2015-08-20",
  "address": "4567 Main Street"
}
Find Student(GET):
--------------------
Request(GET): http://localhost:8080/api/students/1
Response:
{
  "id": 1,
  "firstName": "Dev",
  "lastName": "Kumar",
  "dateOfBirth": "2015-08-19",
  "address": "4567 Main Street"
}


Find All Students:
--------------------
Request(GET):  http://localhost:8080/api/students

Response json:
[
  {
    "id": 1,
    "firstName": "Dev",
    "lastName": "Kumar",
    "dateOfBirth": "2015-08-19",
    "address": "4567 Main Street"
  },
  {
    "id": 2,
    "firstName": "Ravi",
    "lastName": "Shastri",
    "dateOfBirth": "1980-11-20",
    "address": "12 Main Street"
  }
]
Delete Student:
--------------------
Request(Delete): http://localhost:8080/api/students/1
Response: Response with status Http status code 200

