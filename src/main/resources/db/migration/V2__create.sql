CREATE  TABLE IF NOT EXISTS   user (
  user_id bigint(20) NOT NULL AUTO_INCREMENT,
  password varchar(255) DEFAULT NULL,
  user_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (user_id)
) ;

CREATE  TABLE IF NOT EXISTS  workout (
  workout_id bigint(20) NOT NULL AUTO_INCREMENT,
  cal_burnt_per_unit_time double NOT NULL,
  title varchar(255) DEFAULT NULL,
  unit_time varchar(255),
  user_id bigint(20) NOT NULL,
  PRIMARY KEY (workout_id),
  CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES user (user_id)
) ;


CREATE  TABLE IF NOT EXISTS  workout_transaction (
  txn_id bigint(20) NOT NULL AUTO_INCREMENT,
  cals_burnt double NOT NULL,
  duration bigint(20),
  start_time TIMESTAMP,
  stop_time TIMESTAMP,
  workout_id bigint(20) NOT NULL,
  PRIMARY KEY (txn_id),
  CONSTRAINT fk_workoutId_workouttransaction FOREIGN KEY (workout_id) REFERENCES workout (workout_id)
) ;
