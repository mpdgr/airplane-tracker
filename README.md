# Airplane tracker

Monitors Boeing 747 flights in Polish airspace and provides REST API with flights information and history.
Live service at:

https://airplanes.mpdgr.com/

The app monitors commercial flights in Polish airspace by periodic queries to opensky-network. Additional information from other APIs and data previously collected in own database, is used to identify Boeing 747 aircrafts flying over Poland.
Flights and aircraft information is stored in the database and shared via Rest endpoints. Data accumulation helps to reduce external Api calls. The service consists of relatively indenpendent layers (web, data and domain) connected with interfaces. Uses Java, Spring Boot, SQL/h2

Avaliable endpoints:
```
    GET /currentflights       returns current B747 flights in PL airspace
    GET /recentflights{1-60}  returns B747 flights in PL airspace recorded within given nr of days
    GET /allflights           returns all B747 flights recoded in the database
    
    and additional endpoint for admin account providing the api logs. 
```
