CREATE database ADSDental;
USE ADSDental;
CREATE TABLE Dentists (
    DentistID INT PRIMARY KEY,
    FirstName VARCHAR(100),
    LastName VARCHAR(100),
    PhoneNumber VARCHAR(15),
    Email VARCHAR(100),
    Specialization VARCHAR(100)
);

CREATE TABLE Patients (
    PatientID INT PRIMARY KEY,
    FirstName VARCHAR(100),
    LastName VARCHAR(100),
    PhoneNumber VARCHAR(15),
    Email VARCHAR(100),
    Address VARCHAR(200),
    DateOfBirth DATE
);

CREATE TABLE Surgeries (
    SurgeryID INT PRIMARY KEY,
    Name VARCHAR(100),
    LocationAddress VARCHAR(200),
    PhoneNumber VARCHAR(15)
);

CREATE TABLE Appointments (
    AppointmentID INT PRIMARY KEY,
    DentistID INT,
    PatientID INT,
    SurgeryID INT,
    AppointmentDate DATE,
    AppointmentTime TIME,
    FOREIGN KEY (DentistID) REFERENCES Dentists(DentistID),
    FOREIGN KEY (PatientID) REFERENCES Patients(PatientID),
    FOREIGN KEY (SurgeryID) REFERENCES Surgeries(SurgeryID)
); 


INSERT INTO Dentists (DentistID, FirstName, LastName, PhoneNumber, Email, Specialization)
VALUES
(101, 'David', 'Smith', '123-456-7890', 'dsmith@email.com', 'Orthodontics'),
(102, 'Maheder', 'Abreha', '098-765-4321', 'mabreha@email.com', 'Pediatric Dentistry');

INSERT INTO Patients (PatientID, FirstName, LastName, PhoneNumber, Email, Address, DateOfBirth)
VALUES
(201, 'Alice', 'Johnson', '555-123-4567', 'alicej@email.com', '123 Main St, Anytown, AT 12345', '2000-04-12'),
(202, 'Bob', 'Williams', '555-987-6543', 'bobw@email.com', '456 Elm St, Othertown, OT 67890', '1998-08-24');

INSERT INTO Surgeries (SurgeryID, Name, LocationAddress, PhoneNumber)
VALUES
(301, 'Downtown Dental Clinic', '789 Central Ave, Bigcity, BC 78901', '555-111-2222'),
(302, 'Suburban Smile Center', '654 Suburbia Dr, Smalltown, ST 45678', '555-333-4444');

INSERT INTO Appointments (AppointmentID, DentistID, PatientID, SurgeryID, AppointmentDate, AppointmentTime)
VALUES
(401, 101, 201, 301, '2024-05-01', '09:00'),
(402, 102, 202, 302, '2024-05-02', '14:30');


SELECT *
FROM Dentists
ORDER BY LastName ASC;

SELECT A.AppointmentID, A.AppointmentDate, A.AppointmentTime, P.FirstName AS PatientFirstName, P.LastName AS PatientLastName, P.PhoneNumber, P.Email
FROM Appointments A
JOIN Patients P ON A.PatientID = P.PatientID
WHERE A.DentistID = 101
ORDER BY A.AppointmentDate, A.AppointmentTime;

SELECT A.AppointmentID, A.AppointmentDate, A.AppointmentTime, S.Name AS SurgeryName, S.LocationAddress, S.PhoneNumber
FROM Appointments A
JOIN Surgeries S ON A.SurgeryID = S.SurgeryID
ORDER BY A.AppointmentDate, A.AppointmentTime;

SELECT A.AppointmentID, A.AppointmentDate, A.AppointmentTime, D.FirstName AS DentistFirstName, D.LastName AS DentistLastName, S.Name AS SurgeryName, S.LocationAddress
FROM Appointments A
JOIN Dentists D ON A.DentistID = D.DentistID
JOIN Surgeries S ON A.SurgeryID = S.SurgeryID
WHERE A.PatientID = 201 AND A.AppointmentDate = '2024-05-01'
ORDER BY A.AppointmentTime;




