# Cinema App

## Project Summary

Cinema App is a backend Spring Boot web application designed to manage movie screenings, bookings, and customer information. Additionally, it uses the [tmdb-java](https://github.com/UweTrottmann/tmdb-java) wrapper for accessing the themoviedb.org API to fetch movie details and metadata.

## Entity Relationship Diagram



## Running the Application

To run the Cinema App using Docker Compose, follow these steps:

1. Ensure you have Docker and Docker Compose installed on your machine.
2. Navigate to the project directory:
    ```sh
    cd /Users/jason/Workspace/Cinema-App
    ```
3. Build and start the containers:
    ```sh
    docker-compose up --build
    ```
4. Open your browser and go to `http://localhost:8000` to access the application.

## Resources

The `resources` directory contains pretend JSON examples that can be used to populate the database with sample data. These examples are useful for testing and development purposes.


