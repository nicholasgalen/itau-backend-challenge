itau-backend-challenge
======================

Itaú Unibanco - Programming Challenge
=====================================

This is a cool challenge for both software development and software engineering. We want to test your ability to build software with multiple parts working together!

YouTube video: [https://youtu.be/uke3i4uOejs](https://youtu.be/uke3i4uOejs)

1\. Introduction
----------------

Your mission, should you choose to accept it, is to create a REST API that receives transactions and returns statistics based on those transactions. For this challenge, the API must be built using Java or [Kotlin](https://kotlinlang.org/) and Spring Boot.

A good place to start is the [Spring Starter](https://start.spring.io/).

> **Tip:** There is no single correct way to complete this challenge! We will evaluate things such as code quality, code readability, project organization, amount and quality of testing, security concerns, and many other factors :)

2\. Challenge Definition
------------------------

In this challenge, you must **create a REST API** and host it on [GitHub](https://github.com/) or [GitLab](https://gitlab.com/). **Please read all instructions carefully!**

### 2.1. Technical Requirements

Your project:

*   **MUST** be hosted on [GitHub](https://github.com/) or [GitLab](https://gitlab.com/)
    
*   **MUST NOT** be a fork of any other project
    
*   **MUST** have at least 1 commit per endpoint (minimum of 3 commits)
    
    *   We want to see the progression of your project over time ;)
        
*   All commits **MUST** be made by the same user who created the repository
    
    *   We understand that some people use personal and professional accounts or separate study accounts. Make sure you're consistent with the account used!
        
*   **MUST** follow the endpoints _exactly_ as described below
    
    *   For example, /transacao is not the same as /transacoes
        
*   **MUST** accept and return objects exactly as described below
    
    *   For example, dataHora is not the same as data-hora or dtTransacao
        
*   **MUST NOT** use any database systems (e.g., H2, MySQL, PostgreSQL, etc.) or caching systems (e.g., Redis, Memcached, Infinispan, etc.)
    
*   **MUST** store all data **in memory**
    
*   **MUST** accept and respond only with JSON
    

> **Warning!** For security reasons, we do not accept projects submitted as files. You **MUST** make your project publicly available for us to access and review it! After receiving feedback, feel free to make your project **private** :)

### 2.2. API Endpoints

Below are the endpoints your API must implement and their expected functionality.

#### 2.2.1. Receive Transactions: POST /transacao

This endpoint receives transactions. Each transaction consists of a valor (amount) and a dataHora (timestamp):

```json
{
  "valor": 123.45,      "dataHora": "2020-08-07T12:34:56.789-03:00"
}
```

Field definitions:

FieldDescriptionRequired?valor**Decimal floating point value** of the transactionYesdataHora**Timestamp in ISO 8601 format** when the transaction occurredYes

> **Tip:** Spring Boot can parse ISO 8601 timestamps natively. Try using OffsetDateTime!

The API should only accept transactions that:

1.  Have both valor and dataHora fields filled
    
2.  **MUST NOT** be dated in the future
    
3.  **MUST** be from any point in the past
    
4.  **MUST NOT** have a negative value
    
5.  **MUST** have a value equal to or greater than 0
    

Responses:

*   201 Created with no body
    
    *   Transaction was accepted (i.e., validated and stored)
        
*   422 Unprocessable Entity with no body
    
    *   Transaction was not accepted (e.g., value less than 0)
        
*   400 Bad Request with no body
    
    *   API could not understand the client request (e.g., malformed JSON)
        

#### 2.2.2. Delete Transactions: DELETE /transacao

This endpoint **deletes all stored transactions**.

Response:

*   200 OK with no body
    
    *   All data has been successfully deleted
        

#### 2.2.3. Get Statistics: GET /estatistica

This endpoint returns statistics for transactions that **occurred in the last 60 seconds**. Statistics include:

```json
{
  "count": 10,
  "sum": 1234.56,
  "avg": 123.456,
  "min": 12.34,
  "max": 123.56
}
```

Field definitions:
| Field | Meaning                                                   |
|-------|-----------------------------------------------------------|
| count | Number of transactions in the last 60 seconds             |
| sum   | Total sum of the amount transacted in the last 60 seconds |
| avg   | Average amount transacted in the last 60 seconds           |
| min   | Lowest amount transacted in the last 60 seconds            |
| max   | Highest amount transacted in the last 60 seconds           |


> **Tip:** The Java 8+ DoubleSummaryStatistics class can be useful or serve as inspiration.

Response:

*   200 OK with JSON containing count, sum, avg, min, and max
    
    *   **Note:** If there are no transactions in the last 60 seconds, all values must be 0
        

4\. Bonus Features
------------------

Here are some optional advanced features that can serve as a bonus if you want to push your skills further! These are not mandatory but can be a differentiator.

1.  **Automated Tests:** Unit and/or functional tests are important for avoiding future issues. Be sure your tests are effective! Only testing happy paths is not sufficient.
    
2.  **Containerization:** Can you make your application available via a container (e.g., Docker)?_Note: You do not need to publish the container._
    
3.  **Logging:** Does your application log meaningful information during execution? This helps developers troubleshoot problems.
    
4.  **Observability:** Does your API include a healthcheck endpoint?
    
5.  **Performance:** Can you estimate the time your app takes to compute statistics?
    
6.  **Error Handling:** Spring Boot provides tools for better error responses. Can you customize them to show _what_ went wrong?
    
7.  **API Documentation:** Can you document your API using tools like [Swagger](https://swagger.io/) or standards like [RAML](http://raml.org/)?
    
8.  **System Documentation:** Can someone who just cloned your project build and run it? Provide clear setup instructions.
    
9.  **Configuration:** Can your app be configured to use a different time window (e.g., 120 seconds instead of 60) for statistics?
