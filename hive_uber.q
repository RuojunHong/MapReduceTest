create external table uber14 (date_time string, lat double, lon double, base string)
row format delimited fields terminated by ','
location '/user/rh2544/uber_14/';
create external table uber15 (Dispatching_base_num string,Pickup_date string,Affiliated_base_num string,locationID string)
row format delimited fields terminated by ',
location '/user/rh2544/uber_15/';
create external table uber_cleaned (date_time string, lat double, lon double, base string);
insert into uber_cleaned select * from uber14 where date_time != NULL;
