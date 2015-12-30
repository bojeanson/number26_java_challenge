Number 26 Java Code Challenge
===============
# Introduction
A RESTful web service that stores some transactions (in memory is fine) and returns information about those transactions. The transactions to be stored have a type and an amount. The service should support returning all  transactions of a type. Also, transactions can be linked to each other (using a "parent_id") and we need to know the total amount involved for all transactions linked to a particular transaction.

# Use cases
**PUT /transactionservice/transaction/$transaction_id**
Body:
'''
{ "amount":double,"type":string,"parent_id":long }
'''

**GET /transactionservice/transaction/$transaction_id**
Returns:
''''
{ "amount":double,"type":string,"parent_id":long }
'''

**GET /transactionservice/types/$type**
Returns: 
''''
[ long, long, .... ] 
'''
A json list of all transaction ids that share the same type $type.

**GET /transactionservice/sum/$transaction_id **
Returns:
'''
{ "sum", double }
'''
A sum of all transactions that are transitively linked by their parent_id to $transaction_id.

# Installation & Deployement
- Java 8
- Maven 3
- Eclipse (Kepler)
- Apache Tomcat 7

Open the project in Eclipse and build it with maven ('''mvn clean install'''). Then export the project to WAR format and deploy it with tomcat.

# Request
With '''curl''' :
- curl -i -H "Content-Type: application/json" -X PUT -d '{"amount":1000,"type":"shopping"}' http://localhost:8080/TransactionApplicationJSON/rest/transactionservice/transaction/1
- curl -i -H "Accept: application/json" -X GET 0.0.0.0:8080/TransactionApplicationJSON/rest/transactionservice/transaction/1
- curl -i -H "Accept: application/json" -X GET http://localhost:8080/TransactionApplicationJSON/rest/transactionservice/types/shopping
- curl -i -H "Accept: application/json" -X GET http://localhost:8080/TransactionApplicationJSON/rest/transactionservice/sum/1
