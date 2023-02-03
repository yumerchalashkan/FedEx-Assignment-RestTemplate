# FedEx-Assignment-RestTemplate

N tier architectural approach was used. each layer was abstracted within itself. I didn't use dto in interlayer communication because I had limited time. I focused more on business logic. can be implemented more effectively in a larger time. There are basically 3 APIs.

1- pricing
2- shipment-products
3- track-status

all these api's are handled by giving parameters to the apis with @RequestParam anatation. All api queries in the system respond in less than 5 seconds. The h2 in-memory database was used as a database for rapid development.

The FedEx-Assignment project runs on port 4000. Some sample endpoints for this project are as follows:

1- http://localhost:4000/shipment-products?orderNumber=109347263

2- http://localhost:4000/track-status?orderNumber=109347263

3- http://localhost:4000/pricing?countryCode=NL


Apart from all these, there is a project called FedEx-Assignment-RestTemplate. this project is running on port 8080. And it makes get requests to FedEx-Assignment project running on port 4000 with RestTemplate Aggregation. Aggregation api handles these get requests. An example endpoint for this project is as follows:

1- http://127.0.0.1:8080/aggregation?shipmentsOrderNumbers=987654321,123456789&trackOrderNumbers=987654321,123456789&pricingCountryCodes=NL,CN


In short, this is an approach I took to achieve the result. I coded the architecture as cleanly as I could. In bigger times, I'm sure it will be made more effective.
