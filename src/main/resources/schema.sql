DROP TABLE IF EXISTS STUDENT_CLASS CASCADE;

CREATE TABLE STUDENT_CLASS (
    student_id INT NOT NULL,
    class_id INT NOT NULL,
    PRIMARY KEY (student_id, class_id),
    FOREIGN KEY (student_id) REFERENCES STUDENT(id),
    FOREIGN KEY (class_id) REFERENCES CLASS(id)
);

DROP TABLE IF EXISTS GRADE CASCADE;

CREATE TABLE GRADE (
    id INT AUTO_INCREMENT PRIMARY KEY,
    score INT NOT NULL,
    student_id INT NOT NULL,
    class_id INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES STUDENT(id),
    FOREIGN KEY (class_id) REFERENCES CLASS(id)
);


DROP TABLE IF EXISTS STUDENT CASCADE;

CREATE TABLE STUDENT (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(10) NOT NULL,
    last_name VARCHAR(10) NOT NULL
);

DROP TABLE IF EXISTS CLASS CASCADE;

CREATE TABLE CLASS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(10) NOT NULL
);





