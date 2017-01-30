set FOREIGN_KEY_CHECKS = 0;
truncate students;
TRUNCATE teachers;
truncate klasses;
set FOREIGN_KEY_CHECKS = 1;

INSERT INTO `students` (`email`) VALUES ('abc@gmail.com');
INSERT INTO `students` (`email`) VALUES ('efg@gmail.com');
#
# INSERT INTO `klasses`
# (`name`,`semester`,`credits`,`department`,`fee`)
# VALUES
#   ("English","2017-01-30",2,"LITERATURE",100.00);