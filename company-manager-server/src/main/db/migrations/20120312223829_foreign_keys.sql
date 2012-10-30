ALTER TABLE `sessions` 
	CHARACTER SET = utf8;

ALTER TABLE `products` 
	CHANGE COLUMN `id` `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
	CHANGE COLUMN `contact_id` `contact_id` INT(10) UNSIGNED NOT NULL;

ALTER TABLE `contacts`
	CHANGE COLUMN `id` `id` INT(10) UNSIGNED NOT NULL, 
	CHANGE COLUMN `title_id` `title_id` INT(10) UNSIGNED NOT NULL, 
	CHANGE COLUMN `role_id` `role_id` INT(10) UNSIGNED NOT NULL;

ALTER TABLE `users` 
	CHANGE COLUMN `id` `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT, 
	CHANGE COLUMN `access_level` `access_level` INT(10) NOT NULL DEFAULT '0';

ALTER TABLE `invoice_rows` 
	CHANGE COLUMN `product_id` `product_id` INT(10) UNSIGNED NOT NULL,
	CHANGE COLUMN `parent_id` `invoice_id` INT(10) UNSIGNED NOT NULL;

ALTER TABLE `invoices` 
	CHANGE COLUMN `contact_id` `contact_id` INT(10) UNSIGNED NOT NULL;

ALTER TABLE `invoices` 
  ADD CONSTRAINT `invoices_contacts_fk`
  FOREIGN KEY (`contact_id` )
  REFERENCES `contacts` (`id` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, ADD INDEX `invoices_contacts_fk` (`contact_id` ASC);

ALTER TABLE `invoice_rows`
  ADD CONSTRAINT `invoice_rows_invoices_fk`
  FOREIGN KEY (`invoice_id` )
  REFERENCES `invoices` (`id` )
  ON DELETE CASCADE
  ON UPDATE NO ACTION
, ADD INDEX `invoice_rows_invoices_fk` (`invoice_id` ASC);

ALTER TABLE `invoice_rows`
  ADD CONSTRAINT `invoice_rows_products_fk`
  FOREIGN KEY (`product_id` )
  REFERENCES `products` (`id` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, ADD INDEX `invoice_rows_products_fk` (`product_id` ASC);

ALTER TABLE `user_options` 
  ADD CONSTRAINT `user_options_users_fk`
  FOREIGN KEY (`user_id` )
  REFERENCES `users` (`id` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, ADD INDEX `user_options_users_fk` (`user_id` ASC);

