## A introduction to spring cloud 

This project will show a simple spring boot cloud application. It will start have a Postgres database and make available some services to see and manipulate this data, as well some examples how to implement certain strucutre, like Spring security with Oauth2, Eureka for services registration and discovery.

#### Pre-requisites:

    * jdk1.8
    * Maven
    * Postgresql


#### This project is composed of the following modules :

    * Ares - The Spring Cloud Config implementation that use the following public GIT repo : https://github.com/PvMeira/spring-cloud-configs
    * Gaia - The Spring Cloud using Eureka implementation for services registration and discovery.
    * Hades - The Spring security with Oauth2 implementation.

#### Some endpoints useful:
    
    
    * http://localhost:9092/swagger-ui.html on HADES 
        this will show all endpoints.

    * http://localhost:{API-PORT}/log
        Show a endpoint with all logs mapped (see application.properties)

    * http://localhost:{API-PORT}/health
    
    * http://localhost:{API-PORT}/mappings
    
    * http://localhost:{API-PORT}/beans
        These will show some information about service.
        
    * http://localhost:9091/ 
        These will show the Eureka dashboard with all avaliable instances.
        
    * https://github.com/PvMeira/spring-cloud-configs
        These will show the project that the ARES project will use to load the aplications configuratios
        
 #### How to run the app:
    
    1. Run the Ares  application
    2. Run the Gaia  application
    3. Run the Hades application
    4. Run the Register Aplication