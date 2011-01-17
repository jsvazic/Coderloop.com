CREATE TABLE student (
  id BIGINT UNSIGNED NOT NULL UNIQUE,
  name VARCHAR(50) NOT NULL,
  surname VARCHAR(50) NOT NULL,
  email VARCHAR(50),
  faculty VARCHAR(50) NOT NULL,
  year YEAR NOT NULL,
  INDEX id_idx (id),
  PRIMARY KEY (id)
) ENGINE=INNODB;

CREATE TABLE professor (
  name VARCHAR(50) NOT NULL,
  surname VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  phonenum VARCHAR (25),
  faculty VARCHAR(50) NOT NULL,
  ssn INT NOT NULL UNIQUE,
  INDEX ssn_idx (ssn),
  PRIMARY KEY (ssn)
) ENGINE=INNODB;

CREATE TABLE course (
   name VARCHAR(50) NOT NULL UNIQUE,
   subject VARCHAR(50) NOT NULL,
   credits INT NOT NULL,
   INDEX name_idx (name),
   PRIMARY KEY (name)
) ENGINE=INNODB;

CREATE TABLE course_professor (
   course_name VARCHAR(50) NOT NULL,
   prof_id INT NOT NULL,
   INDEX main_idx (course_name, prof_id),
   PRIMARY KEY (course_name, prof_id)
) ENGINE=INNODB;

CREATE TABLE student_course (
   course_name VARCHAR(50) NOT NULL,
   student_id BIGINT UNSIGNED NOT NULL,
   INDEX course_idx (course_name),
   INDEX student_idx (student_id)
) ENGINE=INNODB;
