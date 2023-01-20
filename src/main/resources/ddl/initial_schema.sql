create table if not exists exams
(
    id               bigint auto_increment primary key,
    answer           varchar(2048) null,
    author_id        bigint       null,
    creation_date    date         null,
    text             varchar(2048) null,
    time_restriction bigint       null,
    source_id      bigint       null,
    constraint exam_to_source
        foreign key (source_id) references exams (id) on DELETE set null
);

create table if not exists lectures
(
    id            bigint auto_increment primary key,
    author_id     bigint       null,
    creation_date date         null,
    text          varchar(4096) null,
    source_id   bigint       null,
    constraint lecture_to_template
        foreign key (source_id) references lectures (id) on delete set null
);

create table if not exists practices
(
    id            bigint auto_increment primary key,
    answer        varchar(2048) null,
    author_id     bigint       null,
    creation_date date         null,
    text          varchar(2048) null,
    source_id   bigint       null,
    constraint practice_to_template
        foreign key (source_id) references practices (id) on delete set null
);
