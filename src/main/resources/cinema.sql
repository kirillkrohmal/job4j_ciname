CREATE TABLE accounts
(
    id serial NOT NULL,
    value character varying(2000),
    username character varying(2000),
    phone character varying(2000),
    CONSTRAINT accounts_pkey PRIMARY KEY (id)
);

CREATE TABLE halls
(
  id serial NOT NULL,
  rows character varying(2000),
  columns character varying(2000),
  account_id integer REFERENCES accounts (id),
  CONSTRAINT halls_pkey PRIMARY KEY (id)
);


insert table halls(rows, columns, account_id) values('1', '1', 1);