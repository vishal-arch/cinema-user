create sequence  user_registration_seq INCREMENT BY 50;

CREATE TABLE USER_REGISTRATION (
    id bigint,
    mobileNumber varchar(15),
    emailId varchar(50),
    country varchar(50),
    state varchar(100),
    city varchar(100),
    userRegistrationId UUID,
    creationTime timestamp
)