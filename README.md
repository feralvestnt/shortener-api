# Shortener-api
  This project is a API for short URL creation
  
It is necessary to use maven to run the project http://maven.apache.org
	
	mvn spring-boot:run
	
Then access in your browser http://localhost:8080
	
# Technologies and Resources
	- Spring Boot
	- Spring Data
	- Spring Boot Actuator
	- Java 8
	- H2 database
	- Lombok
	- Bitly api client

# Build
	Ready for build with Docker
	
# Endpoints

# Save and shorten Url
	
* **URL**
	- api/url
* **Method**
	- POST
* **Params**
	- id (optional)
	- address (mandatory)
	- shortenedAddress (optional)
* **Success**
	- code 200
* **Invalid Data**
  - code 400
* **Communication Problem**
	- code 502
	
# Get All

* **URL**
	- api/url
* **Method**
	- GET
* **Params**
	- none
	
# Get by Id

* **URL**
	- api/url
* **Method**
	- GET
* **Params**
	- urlId
	
# Health status

* **URL**
	- /actuator/health



	
