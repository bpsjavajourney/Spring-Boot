End point URL's with Req & Res jsons

Redis commands reference: https://redis.io/commands/

Swagger URL:   http://localhost:8080/swagger-ui/index.html#

Create Item:
*******************************
Post:  http://localhost:8080/api/items
---------------------
Request:
{
  "name": "HP DeskJet Printer",
  "description": "Wireless Printer 275Series",
  "price": 179,
  "quantityInStock": 100,
  "category": "Electronics"
}
Response:
{
    "id": 1,
    "name": "HP DeskJet Printer",
    "description": "Wireless Printer 275Series",
    "price": 179,
    "quantityInStock": 100,
    "category": "Electronics"
}

getItem(GET):  http://localhost:8080/api/items/1
---------------------
{
    "id": 1,
    "name": "HP DeskJet Printer",
    "description": "Wireless Printer 275Series",
    "price": 179,
    "quantityInStock": 100,
    "category": "Electronics"
}

getAllItems(GET):http://localhost:8080/api/items
---------------------
[
    {
        "id": 1,
        "name": "HP DeskJet Printer",
        "description": "Wireless Printer 275Series",
        "price": 179.00,
        "quantityInStock": 100,
        "category": "Electronics"
    }
]

update Item(PUT): http://localhost:8080/api/items
---------------------
{
    "id": 1,
    "name": "HP DeskJet Printer",
    "description": "Wireless Printer 275Series",
    "price": 200,
    "quantityInStock": 100,
    "category": "Electronics"
}
response:
{
    "id": 1,
    "name": "HP DeskJet Printer",
    "description": "Wireless Printer 275Series",
    "price": 200,
    "quantityInStock": 100,
    "category": "Electronics"
}

Delete Item(DELETE): 
---------------------
Request: http://localhost:8080/api/items/1
Response: Response with status Http status code 200

