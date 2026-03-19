-- 1. Create the Clinical Database
CREATE DATABASE IF NOT EXISTS clinic_db;
USE clinic_db;

-- 2. Create the Safety Results Table (The Audit Trail)
CREATE TABLE IF NOT EXISTS safety_results (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id VARCHAR(50) NOT NULL,
    safety_status VARCHAR(50) NOT NULL,
    check_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 3. Verify the table is empty and ready
SELECT * FROM safety_results;