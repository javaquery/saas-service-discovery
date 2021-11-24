# SaaS service discovery server [Draft]

## What is SaaS Service Discovery Server

Its the server which can help you to scale your <a href="https://en.wikipedia.org/wiki/Software_as_a_service" target="_blank">Software as a service (SaaS)</a> product.

## Features

- Scale services horizontally.
- Decouple services irrespective of technologies.
- Balance the load on multiple services.  

## Why SaaS Service Discovery Server?

You might be wondering why we need this server. So before we begin I strongly recommend you to read the article of Amazon about problems with SaaS product and how to fix it using their managed service.

Article: <a href="https://aws.amazon.com/blogs/apn/using-amazon-sqs-in-a-multi-tenant-saas-solution/" target="_blank">Using Amazon SQS in a Multi-Tenant SaaS Solution</a>

Given solution by Amazon is applicable only when using it in Amazon Web Services however sometime organizations need cheaper and custom solution. That is why I created SaaS Service Discovery Server, which is both free and opensource.  

# Getting started with SaaS Service Discovery Server

We will understand the scenario with actual usecase and see where you can fit the SaaS Service Discovery Server to scale up your services.

## Traditional SaaS Service Architecture

Image shows the traditional design of SaaS services. 
Note: Your system architecture might be the different from given architecture. Image is created to give you general idea about problem. 

docker run -p 8888:8090 -e "MONGODB_CONNECTION_STRING=mongodb://root:root@192.168.225.133:27017/ssd?authSource=admin&readPreference=primary&ssl=false" javaquery/saas-service-discovery:1.0.0
