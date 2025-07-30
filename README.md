# Spring Boot E-commerce API Starter

This repository contains a comprehensive Spring Boot starter project for building e-commerce APIs with authentication, shopping cart management, and product catalog functionality.

## Features

- 🔐 **JWT Authentication** - Secure user authentication with JWT tokens
- 🛒 **Shopping Cart** - Complete cart management system
- 📦 **Product Management** - Product catalog with categories
- 👤 **User Management** - User registration and profile management
- 🔍 **API Documentation** - Auto-generated Swagger/OpenAPI docs
- 🗄️ **Database Migration** - Flyway database migrations
- 🧪 **Testing** - Comprehensive test setup with H2 in-memory database
- 📊 **Health Checks** - Spring Boot Actuator endpoints

## Technology Stack

- **Java 17**
- **Spring Boot 3.4.1**
- **Spring Security** - JWT authentication
- **Spring Data JPA** - Database access
- **MySQL** - Primary database
- **H2** - Test database
- **Flyway** - Database migrations
- **MapStruct** - Object mapping
- **Lombok** - Reduce boilerplate code
- **OpenAPI/Swagger** - API documentation

## Quick Start

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- MySQL 8.0 or higher (for production)

### Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/DarkLight606/spring-api-starter.git
   cd spring-api-starter
   ```

2. **Environment Configuration**
   ```bash
   # Copy the example environment file
   cp .env.example .env
   
   # Edit .env file with your configuration
   # Set JWT_SECRET to a secure 256-bit key
   # Configure database credentials
   ```

3. **Database Setup**
   ```bash
   # Create MySQL database
   mysql -u root -p
   CREATE DATABASE store_api;
   exit
   
   # Run database migrations
   mvn flyway:migrate
   ```

4. **Build and Run**
   ```bash
   # Build the project
   mvn clean compile
   
   # Run tests
   mvn test
   
   # Start the application
   mvn spring-boot:run
   ```

### Environment Variables

Create a `.env` file in the project root with the following variables:

```properties
# JWT Configuration
JWT_SECRET=your-super-secret-jwt-key-that-should-be-at-least-256-bits-long-for-security
ACCESS_TOKEN_EXPIRATION=300
REFRESH_TOKEN_EXPIRATION=604800

# Database Configuration
DB_HOST=localhost
DB_PORT=3306
DB_NAME=store_api
DB_USERNAME=root
DB_PASSWORD=your-database-password

# Security Configuration
SECURE_COOKIES=true

# Logging Configuration
LOG_LEVEL=INFO
SECURITY_LOG_LEVEL=WARN
SHOW_SQL=false
```

## API Documentation

Once the application is running, you can access:

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **API Docs**: http://localhost:8080/v3/api-docs
- **Health Check**: http://localhost:8080/actuator/health

## API Endpoints

### Authentication
- `POST /auth/login` - User login
- `POST /auth/validate` - Token validation
- `GET /auth/me` - Get current user info

### Users
- `POST /users` - Register new user
- `GET /users/{id}` - Get user by ID
- `PUT /users/{id}` - Update user

### Products
- `GET /products` - List products
- `GET /products/{id}` - Get product by ID

### Shopping Cart
- `GET /carts/{userId}` - Get user's cart
- `POST /carts/{userId}/items` - Add item to cart
- `PUT /carts/{userId}/items/{itemId}` - Update cart item
- `DELETE /carts/{userId}/items/{itemId}` - Remove item from cart

## Development

### Running Tests

```bash
# Run all tests
mvn test

# Run tests with coverage
mvn test jacoco:report
```

### Database Migrations

```bash
# Create new migration
mvn flyway:migrate

# Clean database (development only)
mvn flyway:clean
```

### Code Style

The project uses standard Java conventions with Lombok annotations to reduce boilerplate code.

## Security Features

- **JWT Authentication** with secure token generation
- **Password Encryption** using BCrypt
- **CORS Configuration** for cross-origin requests
- **Secure Cookie Settings** for refresh tokens
- **Environment-based Security** settings

## Production Deployment

For production deployment:

1. Set `SECURE_COOKIES=true` for HTTPS environments
2. Use a strong, randomly generated JWT secret
3. Configure proper database connection pooling
4. Set appropriate logging levels
5. Enable SSL/TLS encryption

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Ensure all tests pass
6. Submit a pull request

## License

This project is open source and available under the [MIT License](LICENSE).

## Support

For questions or issues, please create an issue in the GitHub repository.