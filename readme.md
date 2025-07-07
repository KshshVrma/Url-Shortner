# URL Shortener Project

## Overview
The URL Shortener is a web application built using **Java**, **Spring Boot**, and **Redis**. It allows users to store, retrieve, update, and delete shortened URLs, with Redis serving as the primary data store for fast key-value operations.

## Features
- **Add URL**: Store key-value pairs in Redis.
- **Get URL**: Retrieve the original URL by its key.
- **Delete URL**: Remove a URL from Redis.
- **Redirect URL**: Redirect to the original URL stored in Redis.
- **View All URLs**: Display all stored URLs.

## Technologies Used
- **Java 17**: Programming language.
- **Spring Boot**: Framework for building the application.
- **Redis**: In-memory data store for fast key-value operations.
- **Maven**: Build and dependency management tool.
- **Docker**: Used to run Redis as a container.

## Prerequisites
- **Java 17** or higher.
- **Maven 3.9.10** or higher.
- **Docker** (optional, for Redis setup).

## Setup Instructions

Test the Endpoints
You can test the application using tools like Postman or cURL. Below are some example endpoints:  
Add URL: POST /hello/addurl  
{
"shortKey": "example",
"url": "https://example.com"
}
Get URL: GET /hello/geturl?url=shortKey  
Redirect URL: GET /hello/redirect?url=shortKey  
Delete URL: DELETE /hello/deleteurl?url=shortKey

Project Structure
Controller: Handles HTTP requests and responses.
Service: Contains business logic for URL storage and retrieval.
Redis Integration: Manages key-value storage using Redis.

/redirect?url=x: for redirection of the short url to the original endpoint

### 1. Clone the Repository
```bash




git clone <repository-url>
cd shortner

