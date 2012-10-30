ALTER TABLE `contacts`
DROP COLUMN `role_id`,
DROP COLUMN `tel_1`,
DROP COLUMN `tel_2`,
DROP COLUMN `mobile`,
DROP COLUMN `fax`,
DROP COLUMN `www`,
ADD COLUMN `title` varchar(255) default NULL AFTER `account_ref`;

update contacts con set con.title = (select tit.title from titles tit where tit.id = con.title_id);
commit;

alter table `contacts`
drop column `title_id`;

