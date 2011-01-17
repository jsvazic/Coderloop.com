SELECT name, surname, ssn FROM professor JOIN course_professor ON ssn = prof_id WHERE course_name = ?; 
