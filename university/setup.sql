CREATE TABLE student (
  id BIGINT UNSIGNED NOT NULL UNIQUE,
  name VARCHAR(25) NOT NULL,
  surname VARCHAR(25) NOT NULL,
  email VARCHAR(50),
  faculty VARCHAR(25),
  year_of_marticulation YEAR,
  INDEX id_idx (id),
  PRIMARY KEY (id)
) ENGINE=INNODB;

CREATE TABLE professor (
  name VARCHAR(25) NOT NULL,
  surname VARCHAR(25) NOT NULL,
  email VARCHAR(50) NOT NULL,
  phonenum VARCHAR (25),
  faculty VARCHAR(25),
  ssn INT NOT NULL UNIQUE,
  INDEX ssn_idx (ssn),
  PRIMARY KEY (ssn)
) ENGINE=INNODB;

CREATE TABLE course (
   name VARCHAR(50) NOT NULL UNIQUE,
   subject VARCHAR(25) NOT NULL,
   credits INT(2),
   prof_id INT,
   INDEX name_idx (name),
   INDEX prof_idx (prof_id),
   PRIMARY KEY (name),
   FOREIGN KEY (prof_id) REFERENCES professor(ssn) ON DELETE CASCADE
) ENGINE=INNODB;

CREATE TABLE student_course (
   course_name VARCHAR(50) NOT NULL,
   student_id BIGINT UNSIGNED NOT NULL,
   INDEX course_idx (course_name),
   INDEX student_idx (student_id),
   FOREIGN KEY (course_name) REFERENCES course(name) ON DELETE CASCADE,
   FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE
) ENGINE=INNODB;
