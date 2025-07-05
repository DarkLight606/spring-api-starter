alter table cart
    change dateCreated date_created date default (curdate()) not null;



