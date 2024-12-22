DROP TABLE IF EXISTS  contacts;

CREATE TABLE IF NOT EXISTS contacts
(
    dtype VARCHAR (40),
    id LONG NOT NULL IDENTITY PRIMARY KEY ,
    contactType VARCHAR(20) NOT NULL,
    name VARCHAR (255) NOT NULL,
    phoneNumber INTEGER UNIQUE NOT NULL,
    textComment VARCHAR (255),
    email VARCHAR (255),
    isPrivate BOOLEAN,
    city VARCHAR (100),
    url VARCHAR (255)
);