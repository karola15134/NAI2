CREATE TABLE mybatis_db.drivers
(
    id int(11) NOT NULL AUTO_INCREMENT,
    fName varchar(100) NOT NULL,
    lName varchar(100) NOT NULL,
    drivingLicDate varchar(100) NOT NULL,
    categories varchar(50),
    PRIMARY KEY (id)
);
