## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup DB](#Setup-DB)
* [Setup Hibernate](#Setup-hibernate)
* [Installation](#Installation)

## General info
This project is simple client browser.
	
## Technologies
Project is created with:
* Hibernate version: 5.5.6
* Spring Boot version 2.2.1
* JDBC version 9.2.1
	
## Setup DB	
### SQL SERVER
Sample code creating a database 

* Creating DB
```shell
CREATE DATABASE [Client]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Client', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Client.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Client_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Client_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
```

* Creating Table
```shell
CREATE TABLE [dbo].[Client](
	[ID] [int] NOT NULL,
	[Name] [varchar](255) NOT NULL,
	[Surname] [varchar](255) NOT NULL,
	[Mail] [varchar](255) NOT NULL,
	[Address] [varchar](255) NOT NULL,
	[Phone] [varchar](9) NOT NULL,
	[AnotherInformation] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
```
## Setup Hibernate
### SQL SERVER
#### Settings for Windows Authentication

* Change the server, port and database name for your data. 

<img src="https://raw.githubusercontent.com/ModryyyXX/client-browser/master/documents/pics1.png"/>

#### Settings with Login and Password

* Change the server, port, database name, login and password for your data. 

  <img src="https://raw.githubusercontent.com/ModryyyXX/client-browser/master/documents/pics2.png"/>
  
## Installation
#### Running the application with IDE

* 	Download the zip or clone the Git repository.
* 	Unzip the zip file (if you downloaded one)
* 	Open Command Prompt and Change directory (cd) to folder containing pom.xml
* 	Open Eclipse
	* File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
	* Select the project
* 	Choose the Spring Boot Application file (search for @SpringBootApplication)
* 	Right Click on the file and Run as Java Application
* 	Select App - TaskForJob
* 	Done


