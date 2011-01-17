INSERT INTO student (id, name, surname, email, faculty, year) VALUES (1, "John", "Smith", "jsmith@test.edu", "Mathematics", 2015);
INSERT INTO student (id, name, surname, email, faculty, year) VALUES (2, "Jane", "Doe", "jdoe@test.edu", "Science", 2012);
INSERT INTO student (id, name, surname, email, faculty, year) VALUES (3, "Sam", "Spade", "sspade@test.edu", "Mathematics", 2012);
INSERT INTO student (id, name, surname, email, faculty, year) VALUES (4, "Jeff", "Jackson", "", "Science", 2015);

INSERT INTO professor (name, surname, email, phonenum, faculty, ssn) VALUES ("Ha", "Le", "hle@test.edu", "519-888-1920", "Mathematics", 123456789);
INSERT INTO professor (name, surname, email, phonenum, faculty, ssn) VALUES ("Cassidy", "Gentle", "cgentle@test.edu", "519-888-1921", "Science", 987654321);

INSERT INTO course (name, subject, credits) VALUES ("CS101", "Introduction to Computers", 4);
INSERT INTO course (name, subject, credits) VALUES ("SCI100", "Science of Hi Fidelity", 8);
INSERT INTO course (name, subject, credits) VALUES ("MAT104", "Algebra I", 2);

INSERT INTO course_professor (course_name, prof_id) VALUES ("CS101", 123456789);
INSERT INTO course_professor (course_name, prof_id) VALUES ("SCI100", 987654321);
INSERT INTO course_professor (course_name, prof_id) VALUES ("MAT104", 123456789);

INSERT INTO student_course (course_name, student_id) VALUES ("MAT104", 1);
INSERT INTO student_course (course_name, student_id) VALUES ("MAT104", 2);
INSERT INTO student_course (course_name, student_id) VALUES ("MAT104", 3);
INSERT INTO student_course (course_name, student_id) VALUES ("SCI100", 2);
INSERT INTO student_course (course_name, student_id) VALUES ("SCI100", 3);
INSERT INTO student_course (course_name, student_id) VALUES ("SCI100", 4);
INSERT INTO student_course (course_name, student_id) VALUES ("CS101", 3);
