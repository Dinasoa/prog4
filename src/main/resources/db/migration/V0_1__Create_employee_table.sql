create extension if not exists "uuid-ossp";

CREATE SEQUENCE my_sequence;

CREATE TABLE employee {
    id int constraint id_employee primary key default uuid_generate_v4(),
    varchar matricule,
    varchar firstName,
    varchar lastName,
    varchar birthdate,
    varchar picture,
};


CREATE OR REPLACE FUNCTION generate_id_with_prefix()
RETURNS TRIGGER AS $$
BEGIN
  NEW.matricule := 'REF-000' || nextval('my_sequence');
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER id_trigger
BEFORE INSERT ON employee
FOR EACH ROW
EXECUTE FUNCTION generate_id_with_prefix();
