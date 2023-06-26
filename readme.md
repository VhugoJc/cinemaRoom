# Cinema Room 

## Description

This project is a Cinema Room Management System developed using Maven and Java Spring Boot. The system allows users to manage cinema rooms, book seats, and perform various operations related to cinema management.

## Features

- **Cinema Room Management:** The system provides functionality to manage the cinema room.
- **Ticket Management:** The system enables users to purchase seats with a Tickets system which use a token as identifier. Users can return their tickets if it is necesary.
- **Stats managment:** The system enables users with password to get the stats for the cinema room.


## Installation

1. Clone the repository:

```shell
    git clone https://github.com/VhugoJc/cinemaRoom.git
```
2. Navigate to the project directory:
```bash
    cd cinemaRoom
```
3. Run the application:
```bash
mvn spring-boot:run
```
The application will start running on http://localhost:8080.

## API Endpoints

Once the application is running, you can access the Cinema Room Management System through a web browser or API testing tools like Postman.

The following endpoints are available:
### Read cinema room
- **Endpoint:** `GET /seats`
- **Description:** Retreives the total of rows, the total of columns and a list of available seats.
- **Example request:** ` /api/todos `
- **Example response:**
```json
{
    "total_rows": 9,
    "total_columns": 9,
    "available_seats": [
        {
            "row": 1,
            "column": 1,
            "price": 10
        },
        {
            "row": 1,
            "column": 2,
            "price": 10
        }, 
        ...
        {
            "row": 9,
            "column": 9,
            "price":8
        }
    ]
}
```
### Purchase seat
- **Endpount:** `POST /purchase`
- **Description:** purchases a seat and remove it from the available seats list.
- **Example request:** `/purchase`
```json
{
    "column":1,
    "row":1
}
```
- **Example response:**
```json
{
    "token": "755dce08-8750-4d0c-beb3-ef43d7a7c613",
    "ticket": {
        "row": 1,
        "column": 1,
        "price": 10
    }
}
```
### Return seat
- **Endpoint:** `POST /return`
- **Description:** returns the seat using the given token.
- **Example request:** `/return`
```json
{
    "token":"755dce08-8750-4d0c-beb3-ef43d7a7c613"
}
```
- **Example response:** 
```json
{
    "returned_ticket": {
        "row": 1,
        "column": 1,
        "price": 10
    }
}
```
### Read stats
- **Endpoint:** `GET /stats`
- **Description:** Retreives current income, number of available seats and number of purchased seats.
- **Params:**
    -`password`(required): Password to get the stats.
- **Example request:** `/stats?password=super_secret`
- **Example response:**
```json
{
    "current_income": 40,
    "number_of_available_seats": 77,
    "number_of_purchased_tickets": 4
}
```

## Configuration
The application uses the default configuration provided by Spring Boot. However, you can modify the configuration by editing the application.properties file located in the src/main/resources directory.

## Dependencies
The project utilizes the following dependencies:
- Spring Boot
- Maven

Please refer to the pom.xml file for a complete list of dependencies and their versions.

## Contributing
If you wish to contribute to this project, you can follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Implement your changes.
4. Test your changes thoroughly.
5. Commit and push your changes to your forked repository.
6. Create a pull request, describing your changes in detail.
## License
This project is licensed under the MIT License.