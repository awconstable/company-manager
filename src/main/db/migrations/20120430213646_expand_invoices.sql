ALTER TABLE `invoices`
  ADD COLUMN `account_ref` varchar(50) NOT NULL,
  ADD COLUMN `company_name` varchar(255) default NULL,
  ADD COLUMN `address_1` varchar(255) default NULL,
  ADD COLUMN `address_2` varchar(255) default NULL,
  ADD COLUMN `city` varchar(255) default NULL,
  ADD COLUMN `postcode` varchar(50) default NULL,
  ADD COLUMN `vat_number` varchar(30) default NULL,
  ADD COLUMN `country` varchar(255) default NULL
;
