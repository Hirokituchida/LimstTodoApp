CREATE TABLE　IF NOT EXISTS todo_details(
   id INT PRIMARY KEY,
   title VARCHAR (40) NOT NULL,
   is_done BOOLEAN,
   time_limit DATE
   );