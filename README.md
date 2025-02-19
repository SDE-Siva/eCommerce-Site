# eCommerce Front Store

A simple eCommerce front store built using **Spring Boot, JPA, MySQL, React.js, and Bootstrap**. The app provides a basic UI with search functionality and injects dummy data into the database using `DataSeeder`. The UI supports customizable image templates.

## Features
- **React.js & Bootstrap** for frontend
- **Spring Boot & JPA** for backend
- **MySQL** for data storage
- **Search functionality**
- **Automatic dummy data seeding**
- **Customizable image templates**

## Setup
### Backend
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/ecommerce-store.git
   cd ecommerce-store/backend
   ```
2. Configure MySQL in `application.properties`.
3. Build and run:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

### Frontend
1. Navigate to the frontend folder:
   ```sh
   cd ../frontend
   ```
2. Install dependencies and start:
   ```sh
   npm install
   npm start
   ```

## API Endpoints
- `GET /api/products` - Fetch all products
- `GET /api/products/{id}` - Get product by ID
- `GET /api/products/search?query={keyword}` - Search products



