SET search_path TO public;

CREATE TABLE users (
    user_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE doctors (
    doctor_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id BIGINT REFERENCES users(user_id) NOT NULL UNIQUE,
    name VARCHAR(50) NOT NULL,
    department VARCHAR(50),
    speciality VARCHAR(255),
    education VARCHAR(255),
    mobile_no VARCHAR(15)
);

CREATE TABLE patients (
    patient_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    mobile_no VARCHAR(15) NOT NULL,
    address VARCHAR(255),
    blood_group VARCHAR(5),
    birth_date DATE NOT NULL,
    gender VARCHAR(15) NOT NULL,
    created_at TIMESTAMP DEFAULT now(),
    updated_at TIMESTAMP
);

CREATE TABLE appointments (
    appmt_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    patient_id BIGINT REFERENCES patients(patient_id) NOT NULL,
    doctor_id BIGINT REFERENCES doctors(doctor_id) NOT NULL,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    token_number INT NOT NULL,
    reason VARCHAR(100),
    status VARCHAR(50) NOT NULL DEFAULT 'BOOKED',
    created_at TIMESTAMP DEFAULT now(),
    updated_at TIMESTAMP,
    CHECK (start_time < end_time)
);

CREATE UNIQUE INDEX appmt_index
ON appointments (
    doctor_id,
    CAST(start_time AS DATE),
    token_number
);

CREATE TABLE visits (
    visit_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    patient_id BIGINT REFERENCES patients(patient_id) NOT NULL,
    doctor_id BIGINT REFERENCES doctors(doctor_id) NOT NULL,
    appmt_id BIGINT REFERENCES appointments(appmt_id) NOT NULL UNIQUE,
    visit_time TIMESTAMP DEFAULT now(),
    weight DOUBLE PRECISION,
    height DOUBLE PRECISION,
    bp VARCHAR(20),
    symptoms VARCHAR(255) NOT NULL,
    diagnosis VARCHAR(255),
    prescription VARCHAR(255),
    notes VARCHAR(255)
);