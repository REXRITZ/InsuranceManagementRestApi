
# Insurance Management Platform

The Insurance management rest api allows user to manage policies, clients, and claims using CRUD operations.


## Technolgies used

+ H2 in-memory database is used for storing data.
+ Spring JPA is used for persisting the changes.
+ Request validation performed using spring boot starter validation.
+ Lombok library used for reducing boilerplate code.
+ Exceptional handling performed on requests.


## API Reference

### Client

| Method | Endpint     | Description                |
| :-------- | :------- | :------------------------- |
| `GET` | `/api/clients` | Fetch all clients |
| `GET` | `/api/clients/{id}` | Fetch client by specific id |
| `POST` | `/api/clients` | Create new client |
| `PUT` | `/api/clients/{id}` | Update client's information |
| `DELETE` | `/api/clients/{id}` | Delete a client |

#### Sample JSON Request body for POST and PUT request

```JSON
{
    "name": "Tim Holland",
    "dob": "1997-06-03",
    "address": "Gandhi Stree, Delhi",
    "email": "tim@gmail.com"
}
```
### Insurance Policy

| Method | Endpint     | Description                |
| :-------- | :------- | :------------------------- |
| `GET` | `/api/policies` | Fetch all policies |
| `GET` | `/api/policies/{id}` | Fetch policy by specific id |
| `POST` | `/api/policies` | Create new policies |
| `PUT` | `/api/policies/{id}` | Update policiy's information |
| `DELETE` | `/api/policies/{id}` | Delete a policy |

#### Sample JSON Request body for POST and PUT request

```JSON
{
    "type": "HOME",
    "coverageAmount": 100000,
    "premium": 2000,
    "startDate": "2023-04-05",
    "endDate": "2024-05-05",
    "clientId": 1,
    "claimId": 2
}
```
### Claim

| Method | Endpint     | Description                |
| :-------- | :------- | :------------------------- |
| `GET` | `/api/claims` | Fetch all claims |
| `GET` | `/api/claims/{id}` | Fetch claim by specific id |
| `POST` | `/api/claims` | Create new claim |
| `PUT` | `/api/claims/{id}` | Update claim's information |
| `DELETE` | `/api/claims/{id}` | Delete a claim |

#### Sample JSON Request body for POST and PUT request

```JSON
{
    "description": "Claim description",
    "claimDate": "2023-07-04",
    "claimStatus": "PENDING"
}
```

