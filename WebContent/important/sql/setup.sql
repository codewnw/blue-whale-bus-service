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

Create Table `Booking` (
`booking_id` int(11) NOT NULL auto_increment,
`booking_status` varchar(10) NOT NULL,
`Bus_no` varchar(11) NOT NULL,
`Seat_no` int(5),
`Price` varchar(10),
`Booking_date` date DEFAULT NULL,
`From_Place` varchar(10) DEFAULT NULL,
`To_Place` varchar(10) DEFAULT NULL,
`Travel_Date` date NOT NULL,
`Payment_mode` varchar(15),
`customer_id` int(11),
PRIMARY KEY (booking_id),
FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);