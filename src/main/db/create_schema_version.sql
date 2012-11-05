CREATE TABLE `schema_version` (
  `version` varchar(32) NOT NULL,
  `applied_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `duration` int(11) NOT NULL,
  UNIQUE KEY `version` (`version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into schema_version (version, duration) values ('20110820130418', 0);
insert into schema_version (version, duration) values ('20110820142226', 0);
commit;
