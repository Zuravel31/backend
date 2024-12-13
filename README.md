POST /client/create
Content-Type: application/json

{
"name": "John Doe"
}

{
"id": 1,
"name": "John Doe"
}


POST /contact/create
Content-Type: application/json
{
"clientId": 1,
"type": "email",
"contactValue": "john.doe@example.com"
}

{
"id": 1,
"clientId": 1,
"type": "email",
"contactValue": "john.doe@example.com"
}


GET /name?name=John%20Doe
{
"id": 1,
"name": "John Doe"
},
{
"id": 2,
"name": "John Doe Jr."
}


GET /1
{
"id": 1,
"name": "John Doe"
}

GET /contact/1
{
"id": 1,
"clientId": 1,
"type": "email",
"contactValue": "john.doe@example.com"
},
{
"id": 2,
"clientId": 1,
"type": "phone",
"contactValue": "123-456-7890"
}
