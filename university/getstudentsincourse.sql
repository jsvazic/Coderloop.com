SELECT name, surname FROM student JOIN student_course ON id = student_id WHERE course_name = ? ORDER BY surname ASC;
