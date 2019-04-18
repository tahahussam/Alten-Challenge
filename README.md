# Alten Challenge implemented by Taha On Tuesday 16-April-2019

# How to Build
  - Download latest maven version from https://maven.apache.org/download.cgi
  - Follow instruction to be able to run 'mvn' commands.
  - If you are using windows you need to add bin folder to the System path variable.
  - Run 'mvn clean install' to run test-cases, generate the jar.

# How to Run
  - Install jdk 8 in your machine.
  - If you are using windows you need to add bin folder to the System path variable.
  - The Database will start automatically after running next command.
  - Run 'java -jar target\alten-challenge.jar'
  - After running the application you can see the logs in '/logs/alten-challenge.log'
  
# By default, Tomcat will take port 8080, so you can call 
  - GET		'http://localhost:8080/vehicles/all' to see all available vehicles in the in memory Database.
  - GET		'http://localhost:8080/vehicles/customer/{customerId}' to see available vehicles under specific customer.
  - GET		'http://localhost:8080/vehicles/status/{status}' to see available vehicles with specific status.