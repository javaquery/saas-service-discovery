# saas-service-discovery
Saas service discovery server


docker run -p 8888:8090 -e "MONGODB_CONNECTION_STRING=mongodb://root:root@192.168.225.133:27017/ssd?authSource=admin&readPreference=primary&ssl=false" javaquery/saas-service-discovery:1.0.0
