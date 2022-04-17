# jaxws

* [Temperature WSDL](https://www.w3schools.com/xml/tempconvert.asmx?wsdl)
* [Calculator WSDL](http://www.dneonline.com/calculator.asmx?wsdl)

## Creating stubs from command prompt

* create the `stub` folder and execute the below command

```sh
wsimport -keep -s stub https://www.w3schools.com/xml/tempconvert.asmx?wsdl
```

## Install the JEE SDK 7

* [JEE SDK 7](http://www.oracle.com/technetwork/java/javaee/downloads/java-ee-sdk-7-jdk-7u21-downloads-1956231.html)
* When we intall the JEE SDK 7 it installs the Glassfish4 server. We will be using this to deploy our applications
* During Glassfish installation it will create a domain and start that domain. Below are the command to start/stop the server

```sh
C:\installs\glassfish4\glassfish\bin>asadmin.bat stop-domain domain1
C:\installs\glassfish4\glassfish\bin>asadmin.bat start-domain domain1
```

* Glassfish console address [http://localhost:4848](http://localhost:4848)
