USE MASTER
GO
IF EXISTS(SELECT name FROM master.dbo.sysdatabases
WHERE name ='students')

DROP DATABASE students
GO

CREATE DATABASE students
ON PRIMARY
(
	NAME ='students',
	FILENAME ='C:\training\students.mdf',
	SIZE = 5MB,
	FILEGROWTH = 10%
)
LOG ON
(
	NAME ='students_log',
	FILENAME ='C:\training\students_log.ldf',
	SIZE = 5MB,
	FILEGROWTH = 10%
)
GO

USE students
GO

CREATE TABLE student
(
	id INT NOT NULL PRIMARY KEY IDENTITY,
	name VARCHAR(30) NOT NULL, 
    surname VARCHAR(30) NOT NULL, 
    email VARCHAR(50) NOT NULL, 
    telephone VARCHAR(15) NOT NULL
)

CREATE USER Patience FOR LOGIN Patience
GO

ALTER ROLE [db_owner] ADD MEMBER Patience
GO
