INSERT INTO USERS (id, name, email, gender_type, created_at) VALUES (100, 'John DOE', 'john.doe@gmail.com', 'FEMALE', now());
INSERT INTO USERS (id, name, email,  gender_type, created_at) VALUES (101, 'John DOE', 'john.doe@gmail.com', 'MALE', now());

INSERT INTO ADDRESSES (id, name, user_id) VALUES (201, '11 rue du moulin blanc', 101);