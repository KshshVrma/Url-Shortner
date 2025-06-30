# URL Shortener Project

## Overview
This project is a URL shortener application built using **Java**, **Spring Boot**, and **Redis**. It allows users to store, retrieve, update, and delete URLs, with Redis used as the primary data store.

## Features
- **Add URL**: Store key-value pairs in Redis.
- **Get URL**: Retrieve a URL by its key.
- **Delete URL**: Remove a URL from Redis.
- **Update URL**: Modify an existing URL.
- **Display URLs**: View all stored URLs.

## Technologies Used
- **Java**: Programming language.
- **Spring Boot**: Framework for building the application.
- **Redis**: In-memory data store for fast key-value operations.
- **Docker**: Used to run Redis as a container.
- **Maven**: Build and dependency management tool.

## Prerequisites
- Java 17 or higher.
- Maven 3.9.10 or higher.
- Docker (optional, for Redis setup).

## Setup Instructions

### 1. Clone the Repository
```bash
git clone <repository-url>
cd shortner
docker run -d --name redis -p 6379:6379 redis
```