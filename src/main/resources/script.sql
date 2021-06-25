create table ingredients (id bigint not null auto_increment, ingredient_name varchar(255), recipe_id bigint, primary key (id));
create table recipe (recipe_id bigint not null auto_increment, cooking_instructions longtext, created_date datetime, is_vegetarian bit not null, recipe_name varchar(255), serve_count integer not null, primary key (recipe_id));
alter table ingredients add constraint FKiau49hpb0ahqg8r9mi42deywl foreign key (recipe_id) references recipe (recipe_id);

insert INTO `recipe` (`recipe_name`, `is_vegetarian`, `serve_count`, `cooking_instructions`,`created_date`) 
VALUES ('Onion Garlic Parantha', '1', '2','1.Heat oil in a pan. Add onion, garlic and cumin powder.
2.Saute till the raw smell of garlic goes away and onions turn soft, not brown.
3.Remove from gas, add green chilli, garam masala and coriander leaves.
4.Use this mixture to fill your parathas and enjoy your meal.',now());

insert INTO `recipe` (`recipe_name`, `is_vegetarian`, `serve_count`, `cooking_instructions`,`created_date`) 
VALUES ('Meethi Koki', '1', '4','1.To make sugar syrup, take a pan add sugar and one cup of water to it along with cardamom powder. Let it boil.
2.Cook until the sugar melts completely. The consistency should not be too thick neither too thin. Let the syrup cool for 10 minutes.
3.Meanwhile, make a stiff dough by mixing whole wheat flour, water and ghee.
4.Now take the cooled sugar syrup and pour it slowly over the dough and mix again. Let it rest for about 15 minutes.
5.After 15 minutes, divide the dough into equal parts. Take each ball, roll and flatten it like chapatis.
6.Heat some ghee on a pan and cook the rolled ball from both sides.
7.Serve hot with curry, pickle or chutney.',now());


INSERT INTO `ingredients` ( `ingredient_name`, `recipe_id`) VALUES ( '200 gms Whole Wheat Flour', (select recipe_id from recipe where recipe_name='Onion Garlic Parantha'));
INSERT INTO `ingredients` ( `ingredient_name`, `recipe_id`) VALUES ( '1 medium Onion (Chopped)', (select recipe_id from recipe where recipe_name='Onion Garlic Parantha'));
INSERT INTO `ingredients` ( `ingredient_name`, `recipe_id`) VALUES ( '3-4 cloves Garlic (chopped)', (select recipe_id from recipe where recipe_name='Onion Garlic Parantha'));
INSERT INTO `ingredients` ( `ingredient_name`, `recipe_id`) VALUES ( '1/2 tsp cumin powder', (select recipe_id from recipe where recipe_name='Onion Garlic Parantha'));
INSERT INTO `ingredients` ( `ingredient_name`, `recipe_id`) VALUES ( '1/2 tsp Garam Masala', (select recipe_id from recipe where recipe_name='Onion Garlic Parantha'));
INSERT INTO `ingredients` ( `ingredient_name`, `recipe_id`) VALUES ( '2 Green Chillies', (select recipe_id from recipe where recipe_name='Onion Garlic Parantha'));
INSERT INTO `ingredients` ( `ingredient_name`, `recipe_id`) VALUES ( '2 Coriander Leaves', (select recipe_id from recipe where recipe_name='Onion Garlic Parantha'));

INSERT INTO `ingredients` ( `ingredient_name`, `recipe_id`) VALUES ( '2 Cups whole wheat flour', (select recipe_id from recipe where recipe_name='Meethi Koki'));
INSERT INTO `ingredients` ( `ingredient_name`, `recipe_id`) VALUES ( '1 Tbsp sugar', (select recipe_id from recipe where recipe_name='Meethi Koki'));
INSERT INTO `ingredients` ( `ingredient_name`, `recipe_id`) VALUES ( '3 tsp cardamom powder', (select recipe_id from recipe where recipe_name='Meethi Koki'));
INSERT INTO `ingredients` ( `ingredient_name`, `recipe_id`) VALUES ( '2 Tbsp butter/ghee', (select recipe_id from recipe where recipe_name='Meethi Koki'));
INSERT INTO `ingredients` ( `ingredient_name`, `recipe_id`) VALUES ( 'Water (as needed)', (select recipe_id from recipe where recipe_name='Meethi Koki'));