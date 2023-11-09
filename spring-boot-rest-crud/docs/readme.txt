End point URL's with Req & Res jsons

Swagger URL:   http://localhost:8080/swagger-ui/index.html#

Subject Controller:
**********************
Create Subject(Post): http://localhost:8080/api/subjects
---------------------
Request:{ "name": "English"}
Response: [ {"id": 1,"name": "English" }]

Update Subject(Put):  http://localhost:8080/api/subjects
--------------------
Request:
{
    "id": 1,
    "name": "Science"
}
Response:
{
    "id": 1,
    "name": "Science"
}
Find Subject(Get): http://localhost:8080/api/subjects/1
--------------------
Response:
{
    "id": 1,
    "name": "Science"
}
Find All Subjects(Get):http://localhost:8080/api/subjects
--------------------
Response:
[
    {
        "id": 1,
        "name": "Science"
    },
    {
        "id": 2,
        "name": "Math"
    },
    {
        "id": 3,
        "name": "Social"
    }
]
Delete Subject(Delete): http://localhost:8080/api/subjects/3
----------------------
Response with status Http status code 200

Student Controller:
**********************
Create Student(Post): http://localhost:8080/api/students
--------------------
Request json:
{    
    "firstName": "David",
    "lastName": "Paul"
}

Response json
{
    "id": 1652,
    "firstName": "David",
    "lastName": "Paul",
    "marksList": []
}

Creating Student with MarksList(Post):  http://localhost:8080/api/students
--------------------------------
Request:
{	
	"firstName": "Arthur",
	"lastName": "Paul",
	"marksList": [{			
		"subject": {
			"id": 1,
			"name": "Science"

		},
		"timestamp": "2023-09-26T14:30:00Z",
		"mark": 90
	},{			
		"subject": {
			"id": 2,
			"name": "Math"

		},
		"timestamp": "2023-09-26T14:30:00Z",
		"mark": 90
	}
	
	]
}

Response:
{
    "id": 2,
    "firstName": "Arthur",
    "lastName": "Paul",
    "marksList": [
        {
            "id": 1,
            "subject": {
                "id": 1,
                "name": "Science"
            },
            "timestamp": "2023-10-02T17:12:54.180+00:00",
            "mark": 90
        },
        {
            "id": 2,
            "subject": {
                "id": 2,
                "name": "Math"
            },
            "timestamp": "2023-10-02T17:12:54.186+00:00",
            "mark": 90
        }
    ]
}}

Update Student(Put):    http://localhost:8080/api/students
--------------------
Update any field
Request json:
{
    "id": 1,
    "firstName": "John",
    "lastName": "Wick",
    "marksList": [
        {
          
            "subject": {
                "id": 1,
                "title": "Science"
            },
            "timestamp": "2023-09-26T14:30:00.000+00:00",
            "mark": 85
        },
		{
           
            "subject": {
                "id": 2,
                "title": "Math"
            },
            "timestamp": "2023-09-26T14:30:00.000+00:00",
            "mark": 95
        }
    ]
}
Response json:
{
    "id": 1,
    "firstName": "John",
    "lastName": "Wick",
    "marksList": [
        {
            "id": 3,
            "subject": {
                "id": 2,
                "name": "Math"
            },
            "timestamp": "2023-10-02T17:13:56.061+00:00",
            "mark": 95
        },
        {
            "id": 4,
            "subject": {
                "id": 1,
                "name": "Science"
            },
            "timestamp": "2023-10-02T17:13:56.070+00:00",
            "mark": 85
        }
    ]
}

Find Student(GET):
--------------------
Request(GET): http://localhost:8080/api/students/2
Response:
{
    "id": 2,
    "firstName": "Arthur",
    "lastName": "Paul",
    "marksList": [
        {
            "id": 1,
            "subject": {
                "id": 1,
                "name": "Science"
            },
            "timestamp": "2023-10-02T17:12:54.180+00:00",
            "mark": 90
        },
        {
            "id": 2,
            "subject": {
                "id": 2,
                "name": "Math"
            },
            "timestamp": "2023-10-02T17:12:54.186+00:00",
            "mark": 90
        }
    ]
}



Find All Students:
--------------------
Request(GET):  http://localhost:8080/api/students

Response json:
[
    {
        "id": 1,
        "firstName": "John",
        "lastName": "Wick",
        "marksList": [
            {
                "id": 3,
                "subject": {
                    "id": 2,
                    "name": "Math"
                },
                "timestamp": "2023-10-02T17:13:56.061+00:00",
                "mark": 95
            },
            {
                "id": 4,
                "subject": {
                    "id": 1,
                    "name": "Science"
                },
                "timestamp": "2023-10-02T17:13:56.070+00:00",
                "mark": 85
            }
        ]
    },
    {
        "id": 2,
        "firstName": "Arthur",
        "lastName": "Paul",
        "marksList": [
            {
                "id": 1,
                "subject": {
                    "id": 1,
                    "name": "Science"
                },
                "timestamp": "2023-10-02T17:12:54.180+00:00",
                "mark": 90
            },
            {
                "id": 2,
                "subject": {
                    "id": 2,
                    "name": "Math"
                },
                "timestamp": "2023-10-02T17:12:54.186+00:00",
                "mark": 90
            }
        ]
    }
]
Delete Student:
--------------------
Request(Delete): http://localhost:8080/api/students/2
Response: Response with status Http status code 200

Marks Controller:
*********************
Create Student(Post): http://localhost:8080/api/students
---------------------
Request:
{    
    "firstName": "David",
    "lastName": "Warner"
}
Response:
{
    "id": 3,
    "firstName": "David",
    "lastName": "Warner",
    "marksList": []
}
Create Mark of a subject/s(Post): http://localhost:8080/api/marks
---------------------
Request:  
{
   "student": {
      "id": 3,
       "firstName": "David",
       "lastName": "Warner"
   },
    "subject": {
        "id": 2,
        "name": "Math"
    },
    "timestamp": "2023-10-02T17:13:56.061+00:00",
    "mark": 95
}

Response:
{
    "id": 5,
    "subject": {
        "id": 2,
        "name": "Math"
    },
    "timestamp": "2023-10-02T17:32:47.674+00:00",
    "mark": 95
}
Update Mark(Put):  http://localhost:8080/api/marks
---------------------
Request json:
{
    "id": 6,
     "student": {
      "id": 3     
   },
    "subject": {
        "id": 1,
        "name": "Science"
    },
    "timestamp": "2023-10-02T17:34:35.961+00:00",
    "mark": 75
}
Response json:
{
    "id": 6,
    "subject": {
        "id": 1,
        "name": "Science"
    },
    "timestamp": "2023-10-02T17:38:34.590+00:00",
    "mark": 75
}
Delete Mark(delete)  : 
---------------------
Request: http://localhost:8080/api/marks/6
Response: Response with status Http status code 200