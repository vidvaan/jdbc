-- ems.org_tab definition

CREATE TABLE `org_tab` (
  `OID` int NOT NULL AUTO_INCREMENT,
  `ONAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`OID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ems.addr_tab definition

CREATE TABLE `addr_tab` (
  `AID` int NOT NULL AUTO_INCREMENT,
  `ALOC` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`AID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ems.proj_tab definition

CREATE TABLE `proj_tab` (
  `PID` int NOT NULL AUTO_INCREMENT,
  `PNAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ems.dept_tab definition

CREATE TABLE `dept_tab` (
  `DID` int NOT NULL AUTO_INCREMENT,
  `DNAME` varchar(100) DEFAULT NULL,
  `OID` int DEFAULT NULL,
  PRIMARY KEY (`DID`),
  KEY `DEPT_TAB_FK` (`OID`),
  CONSTRAINT `DEPT_TAB_FK` FOREIGN KEY (`OID`) REFERENCES `org_tab` (`OID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ems.emp_tab definition

CREATE TABLE `emp_tab` (
  `EID` int NOT NULL AUTO_INCREMENT,
  `ENAME` varchar(100) DEFAULT NULL,
  `ESAL` double DEFAULT NULL,
  `DID` int DEFAULT NULL,
  `AID` int DEFAULT NULL,
  PRIMARY KEY (`EID`),
  KEY `emp_tab_FK` (`DID`),
  KEY `emp_tab_FK_1` (`AID`),
  CONSTRAINT `emp_tab_FK` FOREIGN KEY (`DID`) REFERENCES `dept_tab` (`DID`),
  CONSTRAINT `emp_tab_FK_1` FOREIGN KEY (`AID`) REFERENCES `addr_tab` (`AID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- ems.emp_proj_tab definition

CREATE TABLE `emp_proj_tab` (
  `EID` int NOT NULL,
  `PID` int NOT NULL,
  PRIMARY KEY (`EID`,`PID`),
  KEY `emp_proj_tab_FK_1` (`PID`),
  CONSTRAINT `emp_proj_tab_FK` FOREIGN KEY (`EID`) REFERENCES `emp_tab` (`EID`),
  CONSTRAINT `emp_proj_tab_FK_1` FOREIGN KEY (`PID`) REFERENCES `proj_tab` (`PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
