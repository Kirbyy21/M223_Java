
insert into Team (id, name, deleted)
values
    (NEXT VALUE FOR team_seq, 'Alpha', false),
    (NEXT VALUE FOR team_seq, 'Beta', false),
    (NEXT VALUE FOR team_seq, 'Gamma', false);


insert into Game_Profile (id, game_name, level, deleted)
values
    (NEXT VALUE FOR profile_seq, 'Valorant', 50, false),
    (NEXT VALUE FOR profile_seq, 'Fortnite', 30, false),
    (NEXT VALUE FOR profile_seq, 'Minecraft', 99, false),
    (NEXT VALUE FOR profile_seq, 'CSGO', 70, false);


insert into Player (id, nickname, deleted, team_id, profile_id)
values
    (
        NEXT VALUE FOR PLAYER_SEQ,
             'Shadow',
             false,
             (select id from TEAM where name = 'Alpha'),
             (select id from GAME_PROFILE where game_name = 'Valorant')
    ),
    (
        NEXT VALUE FOR PLAYER_SEQ,
             'Blaze',
             false,
             (select id from TEAM where name = 'Alpha'),
             (select id from GAME_PROFILE where game_name = 'Fortnite')
    ),
    (
        NEXT VALUE FOR PLAYER_SEQ,
             'Creeper',
             false,
             (select id from TEAM where name = 'Beta'),
             (select id from GAME_PROFILE where game_name = 'Minecraft')
    ),
    (
        NEXT VALUE FOR PLAYER_SEQ,
             'Sniper',
             false,
             (select id from TEAM where name = 'Gamma'),
             (select id from GAME_PROFILE where game_name = 'CSGO')
    );