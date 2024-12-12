# Job Application Management System

## Overview
The Job Application Management System is a Backend application that allows users to manage job postings, companies, and reviews. Built using Java and Spring Boot, this application provides a RESTful API for seamless interaction between the front-end and backend, along with a PostgreSQL database for data persistence.

## Features
- **Company Management**: Create, read, update, and delete company profiles.
- **Job Listings**: Manage job postings associated with companies.
- **Review System**: Users can rate and provide feedback on companies.
- **RESTful API**: Well-defined endpoints for all operations.
- **Docker Support**: Containerized application for easy deployment and scalability.

## Technologies Used
- **Backend**: Java, Spring Boot, JPA/Hibernate
- **Database**: PostgreSQL
- **Containerization**: Docker
- **API Format**: JSON
- **Development Tools**: Git, Postman

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven
- Docker
- PostgreSQL

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/debu4natsu/JobApp.git
   cd JobApp

2. **Set up Docker**:
Ensure Docker is installed and running on your machine.
Use the provided docker-compose.yml file to set up the PostgreSQL database and pgAdmin.
Run the application:

 Start the Docker containers:
  
     docker-compose up -d
    
3. **Build the application**:

  Navigate to the project directory and build the application using Maven:

    mvn clean install

4. **Run the application**:

  Start the Spring Boot application:

     mvn spring-boot:run



## API Endpoints

The following endpoints are available in the application:

    Companies
        GET /companies - Retrieve all companies
        POST /companies - Create a new company
        PUT /companies/{id} - Update a company
        DELETE /companies/{id} - Delete a company

    Jobs
        GET /jobs - Retrieve all jobs
        POST /jobs - Create a new job
        GET /jobs/{id} - Retrieve a job by ID
        PUT /jobs/{id} - Update a job
        DELETE /jobs/{id} - Delete a job

    Reviews
        GET /companies/{companyId}/reviews - Retrieve all reviews for a company
        POST /companies/{companyId}/reviews - Add a review for a company
        GET /companies/{companyId}/reviews/{reviewId} - Retrieve a specific review
        PUT /companies/{companyId}/reviews/{reviewId} - Update a review
        DELETE /companies/{companyId}/reviews/{reviewId} - Delete a review

