CREATE SCHEMA blue_whale_bus_service;
SET SQL_SAFE_UPDATES = 0;

CREATE TABLE BUS_SCHEDULE (
    trip_Id VARCHAR(100),
    from_City VARCHAR(100),
    to_City VARCHAR(100),
    bus_Type VARCHAR(100),
    total_Seats INT,
    avail_Seats INT,
    departure_date VARCHAR(100),
    departure_time VARCHAR(100)
);

CREATE TABLE LOGIN (
    USERNAME VARCHAR(256) PRIMARY KEY,
    PASSWORD VARCHAR(256),
    TYPE VARCHAR(128),
    STATUS VARCHAR(128)
);

INSERT INTO LOGIN VALUES ('admin', 'admin', 'admin', 'Verified');

CREATE TABLE user (
    username VARCHAR(256) PRIMARY KEY,
    first_name VARCHAR(256) NOT NULL,
    last_name VARCHAR(256) NOT NULL,
    phone VARCHAR(50),
    dob DATE,
    gender VARCHAR(10)
);

INSERT INTO USER VALUE (?, ?, ?, ?, ?, ?);

CREATE TABLE otp (
    username VARCHAR(256) PRIMARY KEY,
    otp VARCHAR(10) NOT NULL
);

Create Table Booking (
booking_id int(11) auto_increment,
booking_status varchar(256) ,
Bus_no varchar(256) ,
Seat_no varchar(256),
Price varchar(256),
Payment_mode varchar(256),
username varchar(256),
Booking_date date,
From_Place varchar(256),
To_Place varchar(256),
Travel_Date date,
PRIMARY KEY (booking_id),
FOREIGN KEY (username) REFERENCES user(username)
);